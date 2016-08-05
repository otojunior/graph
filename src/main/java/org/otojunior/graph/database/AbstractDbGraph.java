package org.otojunior.graph.database;

import java.sql.SQLException;

/**
 * <p>Abstract AbstractDbGraph class.</p>
 *
 * @author Oto
 * @param <V>
 * @param <E>
 * @version $Id: $Id
 */
public abstract class AbstractDbGraph<V, E> extends AbstractDbBaseGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3417071306191229349L;

	/**
	 * Default constructor.
	 *
	 * @param driver a {@link java.lang.String} object.
	 * @param url a {@link java.lang.String} object.
	 * @param user a {@link java.lang.String} object.
	 * @param password a {@link java.lang.String} object.
	 * @throws java.sql.SQLException if any.
	 * @throws java.lang.ClassNotFoundException if any.
	 */
	public AbstractDbGraph(String driver, String url, String user, String password) throws 
			ClassNotFoundException, 
			SQLException {
		super(driver, url, user, password);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param vi a V object.
	 * @param vj a V object.
	 * @param e a E object.
	 */
	public void addEdge(V vi, V vj, E e) {
		E edge = super.getEdge(vi, vj);
		if (edge == null) {
			edge = super.getEdge(vj, vi); 	// test otherside
			if (edge == null)				// not exists any edge
				super.addEdge(vi, vj, e);	// add first time edge
			else super.addEdge(vj, vi, e);	// update existent (vj,vi) edge
		}
		else super.addEdge(vi, vj, e); // update (vi,vj) edge
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @param vi a V object.
	 * @param vj a V object.
	 * @return a E object.
	 */
	public E getEdge(V vi, V vj) {
		E edge = super.getEdge(vi, vj);
		if (edge == null)
			edge = super.getEdge(vj, vi);
		return edge;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @param vi a V object.
	 * @param vj a V object.
	 * @return a boolean.
	 */
	public boolean hasEdge(V vi, V vj) {
		boolean edge = super.hasEdge(vi, vj);
		if (edge == false)
			edge = super.hasEdge(vj, vi);
		return edge;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @param vi a V object.
	 * @param vj a V object.
	 * @return a E object.
	 */
	public E removeEdge(V vi, V vj) {
		E edge = super.removeEdge(vi, vj);
		if (edge == null)
			edge = super.removeEdge(vj, vi);
		return edge;
	}
}
