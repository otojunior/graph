package org.otojunior.graph.database;

/**
 * 
 * @author Oto
 *
 * @param <V>
 * @param <E>
 */
public abstract class AbstractDbGraph<V, E> extends AbstractDbBaseGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3417071306191229349L;

	/**
	 * Default constructor.
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 */
	public AbstractDbGraph(String driver, String url, String user, String password) {
		super(driver, url, user, password);
	}

	/**
	 * {@inheritDoc}
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
	 */
	public E getEdge(V vi, V vj) {
		E edge = super.getEdge(vi, vj);
		if (edge == null)
			edge = super.getEdge(vj, vi);
		return edge;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean hasEdge(V vi, V vj) {
		boolean edge = super.hasEdge(vi, vj);
		if (edge == false)
			edge = super.hasEdge(vj, vi);
		return edge;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public E removeEdge(V vi, V vj) {
		E edge = super.removeEdge(vi, vj);
		if (edge == null)
			edge = super.removeEdge(vj, vi);
		return edge;
	}
}
