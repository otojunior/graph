package org.otojunior.graph.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.Graph;
import org.otojunior.graph.util.handler.EdgeCollectionHandler;
import org.otojunior.graph.util.handler.VertexCollectionHandler;
import org.otojunior.graph.util.sql.Sql;

/**
 * Abstract class of directional graphs.
 * @author Oto
 */
public abstract class AbstractDbBaseGraph<V, E> implements Graph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 400935963846106462L;
	
	protected String tableName; 
	protected Connection conn;
	protected QueryRunner run;
	protected Sql sql;
	
	private ResultSetHandler<Collection<V>> vertexCollectionHandler;
	private ResultSetHandler<Collection<EdgeEntry<V, E>>> edgeCollectionHandler;

	/**
	 * Default constructor.
	 * @param driver JDBC driver.
	 * @param url String of connection
	 * @param user User
	 * @param password Password
	 */
	public AbstractDbBaseGraph(String driver, String url, String user, String password) {
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, user, password);
			this.conn.setAutoCommit(true);
			
			this.run = new QueryRunner();
			this.tableName = generateTableName();
			this.sql = new Sql(this.tableName);
			this.vertexCollectionHandler = createVertexCollectionHandler();
			this.edgeCollectionHandler = createEdgeCollectionHandler();
			
			createTable();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	/**
	 * @return
	 */
	protected ResultSetHandler<Collection<EdgeEntry<V, E>>> createEdgeCollectionHandler() {
		return new EdgeCollectionHandler<V, E>();
	}

	/**
	 * @return
	 */
	protected ResultSetHandler<Collection<V>> createVertexCollectionHandler() {
		return new VertexCollectionHandler<V>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addEdge(V vi, V vj, E e) {
		try {
			if (!hasEdge(vi, vj)) {
				addVertex(vi);
				addVertex(vj);
				run.update(conn, sql.INSERT_EDGE, vi, vj, e);
			} else {
				run.update(conn, sql.UPDATE_EDGE, e, vi, vj);
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		try {
			if (!hasVertex(v)) {
				run.update(conn, sql.INSERT_VERTEX, v);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public E getEdge(V vi, V vj) {
		try {
			E edge = run.query(conn, sql.SELECT_EDGE, new ScalarHandler<E>(), vi, vj);
			return edge;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Collection<EdgeEntry<V, E>> getEdgeCollection() {
		try {
			Collection<EdgeEntry<V, E>> edges = 
				run.query(conn, sql.SELECT_EDGE_COLLECTION, edgeCollectionHandler);
			return edges;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Collection<V> getVertexCollection() {
		try {
			Collection<V> vertexes = 
				run.query(conn, sql.SELECT_VERTEX_COLLECTION, vertexCollectionHandler);
			return vertexes;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean hasEdge(V vi, V vj) {
		return getEdge(vi, vj) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<EdgeEntry<V, E>> iterator() {
		return new Iterator<EdgeEntry<V, E>>() {
			final Iterator<EdgeEntry<V, E>> iteratorEdge = 
				getEdgeCollection().iterator();
			private V currentVi;
			private V currentVj;
			
			/**
			 * {@inheritDoc}
			 */
			public boolean hasNext() {
				return iteratorEdge.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			public EdgeEntry<V, E> next() {
				EdgeEntry<V, E> element = iteratorEdge.next();
				return element;
			}

			/**
			 * {@inheritDoc}
			 */
			public void remove() {
				removeEdge(currentVi, currentVj);
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public E removeEdge(V vi, V vj) {
		try {
			E edge = getEdge(vi, vj);
			if (edge != null) {
				run.update(conn, sql.DELETE_EDGE, vi, vj);
			}
			return edge;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeVertex(V v) {
		try {
			String[] sqls = new String[] {
				sql.DELETE_VERTEX, 
				sql.DELETE_EDGE_VI, 
				sql.DELETE_EDGE_VJ};
			for (String sql : sqls)
				run.update(conn, sql, v);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		try {
			Number size = run.query(conn, sql.SELECT_COUNT_VERTEX, new ScalarHandler<Number>());
			return size.intValue();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Create tables for store the data.
	 */
	private void createTable() {
		try {
			run.update(conn, getSqlCreateTableVertex());
			run.update(conn, getSqlCreateTableEdge());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @return
	 */
	private String generateTableName() {
		long t = System.currentTimeMillis();
		int r = (int)(Math.random()*1e8);
		int n = (int) (t*r);
		if (n < 0) n = n*(-1);
		return "g"+n;
	}

	/**
	 * 
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	private boolean hasVertex(V v) throws SQLException {
		Number n = (Number) run.query(conn, sql.SELECT_COUNT_VERTEX_VI, new ScalarHandler<Number>(), v);
		return (n.intValue() != 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void finalize() throws Throwable {
		run.update(conn, "drop table vertex_"+tableName);
		run.update(conn, "drop table edge_"+tableName);
		DbUtils.closeQuietly(conn);
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getSqlCreateTableEdge() {
		return String.format( 
				"CREATE TABLE edge_%s ( "+
				"   vi %s, "+
				"   vj %s, "+
				"   e %s, "+
				"   PRIMARY KEY (vi,vj)) ",
				tableName, 
				getSQLTypeForVertex(), 
				getSQLTypeForVertex(), 
				getSQLTypeForEdge()); 
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getSqlCreateTableVertex() {
		return String.format( 
				"CREATE TABLE vertex_%s ( "+
				"   vi %s," +
				"   PRIMARY KEY (vi)) ",
				tableName, 
				getSQLTypeForVertex()); 
	}

	/**
	 * 
	 * @return
	 */
	protected abstract String getSQLTypeForEdge();
	
	/**
	 * o
	 * @return
	 */
	protected abstract String getSQLTypeForVertex();
}
