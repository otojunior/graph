package org.otojunior.graph.memory.defgraph;

import org.otojunior.graph.memory.AbstractMemoryGraph;

/**
 * @author Oto
 *
 */
public abstract class AbstractDefGraph<V, E> extends AbstractMemoryGraph<V, E> {
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
	};

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
