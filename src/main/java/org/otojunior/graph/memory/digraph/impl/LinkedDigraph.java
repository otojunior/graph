package org.otojunior.graph.memory.digraph.impl;


import java.util.LinkedHashMap;
import java.util.Map;

import org.otojunior.graph.memory.digraph.AbstractDigraph;

/**
 * Linked Directional Graph.
 * @author Oto
 */
public class LinkedDigraph<V, E> extends
		AbstractDigraph<V, E> {
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
