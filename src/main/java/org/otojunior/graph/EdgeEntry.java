package org.otojunior.graph;

import java.io.Serializable;

/**
 * Entry representing a edge.
 * @author Oto Junior
 *
 * @param <V> Vertex type.
 * @param <E> Edge type.
 */
public interface EdgeEntry<V, E> extends Serializable {
	/**
	 * Get origin vertex.
	 * @return Origin Vertex.
	 */
	public V getVi();
	
	/**
	 * Get the destiny vertex.
	 * @return Destiny vertex.
	 */
	public V getVj();
	
	/**
	 * Get the edge value.
	 * @return The dge value.
	 */
	public E getEdge();
	
	/**
	 * Set the edge value.
	 * @param newValue The edge value.
	 * @return the edge changed.
	 */
	public E setEdge(E newValue);
}
