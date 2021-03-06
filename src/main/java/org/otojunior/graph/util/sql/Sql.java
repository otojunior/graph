package org.otojunior.graph.util.sql;

/**
 * SQL to manipulate database graphs.
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class Sql {
	public final String INSERT_VERTEX;
	public final String DELETE_VERTEX;
	public final String SELECT_VERTEX;
	public final String INSERT_EDGE;
	public final String UPDATE_EDGE;
	public final String SELECT_EDGE;
	public final String DELETE_EDGE;
	public final String DELETE_EDGE_VI;
	public final String DELETE_EDGE_VJ;
	public final String SELECT_VERTEX_COLLECTION;
	public final String SELECT_EDGE_COLLECTION;
	public final String SELECT_COUNT_VERTEX;
	public final String SELECT_COUNT_VERTEX_VI;
	
	/**
	 * <p>Constructor for Sql.</p>
	 *
	 * @param table a {@link java.lang.String} object.
	 */
	public Sql(String table) {
		INSERT_VERTEX = 
			String.format("insert into vertex_%s (vi) values (?)", table);
		DELETE_VERTEX = 
			String.format("delete from vertex_%s where vi = ?",table);
		SELECT_VERTEX = 
			String.format("select vi from vertex_%s where vi = ?", table);
		INSERT_EDGE = 
			String.format("insert into edge_%s (vi,vj,e) values (?,?,?)", table);
		UPDATE_EDGE = 
			String.format("update edge_%s set e = ? where vi = ? and vj = ?", table);
		SELECT_EDGE =
			String.format("select e from edge_%s where vi = ? and vj = ?", table);
		DELETE_EDGE = 
			String.format("delete from edge_%s where vi = ? and vj = ?",table);
		DELETE_EDGE_VI =
			String.format("delete from edge_%s where vi = ?", table);
		DELETE_EDGE_VJ =
			String.format("delete from edge_%s where vj = ?", table);
		SELECT_VERTEX_COLLECTION = 
			String.format("select distinct vi from vertex_%s", table);
		SELECT_EDGE_COLLECTION =
			String.format("select distinct vi, vj, e from edge_%s", table);
		SELECT_COUNT_VERTEX = 
			String.format("select count(distinct vi) from vertex_%s", table);
		SELECT_COUNT_VERTEX_VI = 
			String.format("select count(distinct vi) from vertex_%s where vi = ?", table);
	}
}
