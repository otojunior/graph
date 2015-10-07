package org.otojunior.graph.database.defgraph;

import java.util.Collection;

import org.otojunior.graph.database.AbstractCollecDbGraph;

/**
 * 
 * @author Oto
 *
 * @param <V>
 * @param <E>
 */
public abstract class AbstractCollecDbDefGraph<V, E> extends AbstractCollecDbGraph<V, E> {
	/**
	 * Constructor.
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 */
	public AbstractCollecDbDefGraph(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}
	
	public void addEdge(java.util.Collection<V> vi, java.util.Collection<V> vj, E e) {
		E edge = super.getEdge(vi, vj);
		if (edge == null) {
			edge = super.getEdge(vj, vi); 	// test otherside
			if (edge == null)				// not exists any edge
				super.addEdge(vi, vj, e);	// add first time edge
			else super.addEdge(vj, vi, e);	// update existent (vj,vi) edge
		}
		else super.addEdge(vi, vj, e); // update (vi,vj) edge
	};
	
	@Override
	public E getEdge(Collection<V> vi, Collection<V> vj) {
		E edge = super.getEdge(vi, vj);
		if (edge == null)
			edge = super.getEdge(vj, vi);
		return edge;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasEdge(Collection<V> vi, Collection<V> vj) {
		boolean edge = super.hasEdge(vi, vj);
		if (edge == false)
			edge = super.hasEdge(vj, vi);
		return edge;
	}
	
	@Override
	public E removeEdge(Collection<V> vi, Collection<V> vj) {
		E edge = super.removeEdge(vi, vj);
		if (edge == null)
			edge = super.removeEdge(vj, vi);
		return edge;
	}
}
