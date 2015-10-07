package org.otojunior.graph.database;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.util.handler.FilteredEdgeCollectionHandler;
import org.otojunior.graph.util.handler.FilteredVertexCollectionHandler;

public abstract class AbstractCollecDbGraph<V, E> extends AbstractDbGraph<Collection<V>, E> {
	/**
	 * Default constructor.
	 * @param driver JDBC driver.
	 * @param url String of connection
	 * @param user User
	 * @param password Password
	 */
	public AbstractCollecDbGraph(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addEdge(Collection<V> vi, Collection<V> vj, E e) {
		try {
			Object viArray = vi.toArray();
			Object vjArray = vj.toArray();
			
			/**
			 * Ordering the array(s) for solve the issue of comparations between
			 * Java Collections and Databases arrays. 
			 */
			Arrays.sort((Object[])viArray);
			Arrays.sort((Object[])vjArray);
			
			if (!hasEdge(vi, vj)) {
				addVertex(vi);
				addVertex(vj);
				run.update(conn, sql.INSERT_EDGE, viArray, vjArray, e);
			} else {
				run.update(conn, sql.UPDATE_EDGE, e, viArray, vjArray);
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(Collection<V> v) {
		try {
			Object vArray = v.toArray();
			
			/**
			 * Ordering the array(s) for solve the issue of comparations between
			 * Java Collections and Databases arrays. 
			 */
			Arrays.sort((Object[])vArray);
			
			if (!hasVertex(v)) {
				run.update(conn, sql.INSERT_VERTEX, vArray);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public E getEdge(Collection<V> vi, Collection<V> vj) {
		try {
			Object viArray = vi.toArray();
			Object vjArray = vj.toArray();
			
			/**
			 * Ordering the array(s) for solve the issue of comparations between
			 * Java Collections and Databases arrays. 
			 */
			Arrays.sort((Object[])viArray);
			Arrays.sort((Object[])vjArray);
			
			E edge = run.query(conn, sql.SELECT_EDGE, 
					new ScalarHandler<E>(), viArray, vjArray);
			return edge;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public E removeEdge(Collection<V> vi, Collection<V> vj) {
		try {
			Object viArray = vi.toArray();
			Object vjArray = vj.toArray();
			
			/**
			 * Ordering the array(s) for solve the issue of comparations between
			 * Java Collections and Databases arrays. 
			 */
			Arrays.sort((Object[])viArray);
			Arrays.sort((Object[])vjArray);
			
			E edge = getEdge(vi, vj);
			if (edge != null) {
				run.update(conn, sql.DELETE_EDGE, viArray, vjArray);
			}
			return edge;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeVertex(Collection<V> v) {
		try {
			Object vArray = v.toArray();
			
			/**
			 * Ordering the array(s) for solve the issue of comparations between
			 * Java Collections and Databases arrays. 
			 */
			Arrays.sort((Object[])vArray);
			
			String[] sqls = new String[] {
				sql.DELETE_VERTEX, 
				sql.DELETE_EDGE_VI, 
				sql.DELETE_EDGE_VJ};
			for (String sql : sqls)
				run.update(conn, sql, vArray);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	private boolean hasVertex(Collection<V> v) throws SQLException {
		Object vArray = v.toArray();
		
		/**
		 * Ordering the array(s) for solve the issue of comparations between
		 * Java Collections and Databases arrays. 
		 */
		Arrays.sort((Object[])vArray);
		
		Number n = run.query(conn, sql.SELECT_COUNT_VERTEX_VI, new ScalarHandler<Number>(), vArray);
		return (n.intValue() != 0);
	}
	
	@Override
	protected ResultSetHandler<Collection<Collection<V>>> createVertexCollectionHandler() {
		return new FilteredVertexCollectionHandler<Collection<V>>();
	}

	@Override
	protected ResultSetHandler<Collection<EdgeEntry<Collection<V>, E>>> createEdgeCollectionHandler() {
		return new FilteredEdgeCollectionHandler<Collection<V>, E>();
	}
	
	

	

}
