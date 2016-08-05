package org.otojunior.graph.memory;

/**
 * Abstract Class of non directional graphs.
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public abstract class AbstractGraph<V, E> extends AbstractMemoryGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8267131727405133720L;

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
	};

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
