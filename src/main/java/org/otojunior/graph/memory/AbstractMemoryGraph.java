package org.otojunior.graph.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.Graph;
import org.otojunior.graph.SimpleEdgeEntry;

/**
 * Abstract Class of graphs.
 * @author Oto Junior
 */
public abstract class AbstractMemoryGraph<V,E> implements Graph<V,E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6310174772197171090L;
	
	/**
	 * The data structure to be used.
	 */
	protected Map<V,Map<V,E>> graph;
	
	/**
	 * {@inheritDoc}
	 */
	public void addEdge(V vi, V vj, E e) {
		if (!graph.containsKey(vi))
			addVertex(vi);
		if (!graph.containsKey(vj))
			addVertex(vj);
		
		Map<V,E> vertex = graph.get(vi);
		vertex.put(vj, e);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract void addVertex(V v);

	/**
	 * {@inheritDoc}
	 */
	public E getEdge(V vi, V vj) {
		if (graph.containsKey(vi)) {
			Map<V,E> vertex = graph.get(vi);
			if (vertex.containsKey(vj)) {
				return vertex.get(vj);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<EdgeEntry<V, E>> getEdgeCollection() {
		Collection<EdgeEntry<V, E>> edges = new ArrayList<EdgeEntry<V, E>>();

		Set<Entry<V, Map<V, E>>> entrySeti = graph.entrySet();
		for (Entry<V, Map<V, E>> ei : entrySeti) {
			V keyi = ei.getKey();
			Map<V, E> valuei = ei.getValue();
			Set<Entry<V, E>> entrySetj = valuei.entrySet();
			for (Entry<V, E> ej : entrySetj) {
				V keyj = ej.getKey();
				E valuej = ej.getValue();
				EdgeEntry<V, E> aEdgeEntry = 
					new SimpleEdgeEntry<V, E>(keyi, keyj, valuej);
				edges.add(aEdgeEntry);
			}
		}
		return edges;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<V> getVertexCollection() {
		return graph.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasEdge(V vi, V vj) {
		if (graph.containsKey(vi)) {
			Map<V,E> vertex = graph.get(vi);
			if (vertex.containsKey(vj)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public E removeEdge(V vi, V vj) {
		E edge = null;
		if (graph.containsKey(vi)) {
			Map<V,E> vertex = graph.get(vi);
			if (vertex.containsKey(vj)) {
				edge = vertex.get(vj);
				vertex.remove(vj);
			}
		}
		return edge;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removeVertex(V v) {
		graph.remove(v);
		Collection<Map<V, E>> values = graph.values();
		for (Map<V, E> mapvi : values)
			mapvi.remove(v);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return graph.size();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Iterator<EdgeEntry<V, E>> iterator() {
		return new Iterator<EdgeEntry<V, E>>() {
			final Iterator<EdgeEntry<V, E>> iteratorEdge = 
				getEdgeCollection().iterator();
			private V currentVi;
			private V currentVj;
			
			/**
			 * {@inheritDoc}
			 */
			public boolean hasNext() {
				return iteratorEdge.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			public EdgeEntry<V, E> next() {
				EdgeEntry<V, E> element = iteratorEdge.next();
				return element;
			}

			/**
			 * {@inheritDoc}
			 */
			public void remove() {
				removeEdge(currentVi, currentVj);
			}
		};
	}
}
