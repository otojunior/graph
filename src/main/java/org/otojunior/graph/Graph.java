package org.otojunior.graph;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 * Graph Interface.
 *
 * @author Oto Junior
 * @param <V>
 * @param <E>
 * @version $Id: $Id
 */
public interface Graph<V, E> extends Iterable<EdgeEntry<V, E>>, Serializable {
	/**
	 * Add a edge to the graph
	 *
	 * @param vi Vertex i.
	 * @param vj Vertex j.
	 * @param e Edge to be added.
	 */
	public void addEdge(V vi, V vj, E e);
	
	/**
	 * Add a vertex to the graph.
	 *
	 * @param v a Vertex
	 */
	public void addVertex(V v);
	
	/**
	 * Get edge from the graph.
	 *
	 * @param vi a V object.
	 * @param vj a V object.
	 * @return a E object.
	 */
	public E getEdge(V vi, V vj);
	
	/**
	 * Return the edge Collection (unmodifiable).
	 *
	 * @return The edge Collection (unmodifiable).
	 */
	public Collection<EdgeEntry<V,E>> getEdgeCollection();
	
	/**
	 * Return the vertex Collection (unmodifiable).
	 *
	 * @return The vertex Collection (unmodifiable).
	 */
	public Collection<V> getVertexCollection();
	
	/**
	 * Verifies if has an edge between two vertexes.
	 *
	 * @return <code>true</code> if is adjacent, <code>false</code> otherwise.
	 * @param vi a V object.
	 * @param vj a V object.
	 */
	public boolean hasEdge(V vi, V vj);
	
	/**
	 * Get the iterator for the edges of the graph.
	 *
	 * @return The iterator for the edges.
	 */
	public Iterator<EdgeEntry<V, E>> iterator();
	
	/**
	 * Remove edge from the graph.
	 *
	 * @param vi Vertex i.
	 * @param vj Vertex j.
	 * @return The edge removed or null if the edge doesn't exists.
	 */
	public E removeEdge(V vi, V vj);
	
	/**
	 * Remove a vertex from the graph.
	 *
	 * @param v a Vertex to be removed.
	 */
	public void removeVertex(V v);
	
	/**
	 * Returns the size of the graph (Number of Vertexes).
	 *
	 * @return The size of the graph (Number of Vertexes).
	 */
	public int size();
}
