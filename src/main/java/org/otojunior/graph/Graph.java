package org.otojunior.graph;

import java.util.Collection;
import java.util.Iterator;

/**
 * Graph Interface.
 * @author Oto
 *
 * @param <V>
 * @param <E>
 */
public interface Graph<V, E> extends Iterable<EdgeEntry<V, E>> {
	/**
	 * Add a edge to the graph
	 * @param vi Vertex i.
	 * @param vj Vertex j.
	 * @param e Edge to be added.
	 */
	void addEdge(V vi, V vj, E e);
	
	/**
	 * Add a vertex to the graph.
	 * @param v a Vertex
	 */
	void addVertex(V v);
	
	/**
	 * Get edge from the graph.
	 * @param vi 
	 * @param vj
	 * @return
	 */
	E getEdge(V vi, V vj);
	
	/**
	 * Return the edge Collection (unmodifiable).
	 * @return The edge Collection (unmodifiable).
	 */
	Collection<EdgeEntry<V,E>> getEdgeCollection();
	
	/**
	 * Return the vertex Collection (unmodifiable).
	 * @return The vertex Collection (unmodifiable).
	 */
	Collection<V> getVertexCollection();
	
	/**
	 * Verifies if has an edge between two vertexes.
	 * @return <code>true</code> if is adjacent, <code>false</code> otherwise.
	 */
	boolean hasEdge(V vi, V vj);
	
	/**
	 * Get the iterator for the edges of the graph.
	 * @return The iterator for the edges.
	 */
	Iterator<EdgeEntry<V, E>> iterator();
	
	/**
	 * Remove edge from the graph.
	 * @param vi Vertex i.
	 * @param vj Vertex j.
	 * @return The edge removed or null if the edge doesn't exists. 
	 */
	E removeEdge(V vi, V vj);
	
	/**
	 * Remove a vertex from the graph.
	 * @param v a Vertex to be removed.
	 */
	void removeVertex(V v);
	
	/**
	 * Returns the size of the graph (Number of Vertexes).
	 * @return The size of the graph (Number of Vertexes).
	 */
	int size();
}
