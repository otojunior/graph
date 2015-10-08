package org.otojunior.graph;

/**
 * Internal class that represents a Edge with the origin and destiny 
 * vertexes. 
 * @author Oto Junior
 */
public class SimpleEdgeEntry<V,E> implements EdgeEntry<V,E> {
	private static final long serialVersionUID = 8749235506878058451L;

	private V vi;
	private V vj;
	private E edge;
	
	/**
	 * Default constructor.
	 * @param vi Origin vertex.
	 * @param vj Destiny vertex.
	 * @param edge A edge value.
	 */
	public SimpleEdgeEntry(V vi, V vj, E edge) {
		this.vi = vi;
		this.vj = vj;
		this.edge = edge;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EdgeEntry)) return false;
		EdgeEntry<V, E> e = (EdgeEntry<V,E>)obj;
		return eq(vi, e.getVi()) && eq(vj, e.getVj()) && eq(edge, e.getEdge());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public E getEdge() {
		return this.edge;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public V getVi() {
		return this.vi;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public V getVj() {
		return this.vj;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edge == null) ? 0 : edge.hashCode());
		result = prime * result + ((vi == null) ? 0 : vi.hashCode());
		result = prime * result + ((vj == null) ? 0 : vj.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public E setEdge(E newValue) {
		E oldValue = this.edge;
		this.edge = newValue;
		return oldValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return String.format("SimpleEdgeEntry [vi=%s, vj=%s, edge=%s]", vi,
				vj, edge);
	}

	/**
     * Utility method for SimpleEntry and SimpleImmutableEntry.
     * Test for equality, checking for nulls.
     */
    private boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }
}
