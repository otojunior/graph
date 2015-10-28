package org.otojunior.graph.memory.digraph;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Linked Directional Graph.
 * @author Oto Junior
 */
public class LinkedDigraph<V, E> extends AbstractDigraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4502519357499061929L;

	/**
	 * {@inheritDoc}
	 */
	public LinkedDigraph() {
		graph = new LinkedHashMap<V,Map<V,E>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		graph.put(v, new LinkedHashMap<V,E>());
	}
}
