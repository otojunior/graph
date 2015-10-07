package org.otojunior.graph.memory.digraph.impl;


import java.util.HashMap;
import java.util.Map;

import org.otojunior.graph.memory.digraph.AbstractDigraph;

/**
 * Hash Directional Graph.
 * @author Oto
 */
public class HashDigraph<V, E> extends
		AbstractDigraph<V, E> {
	/**
	 * {@inheritDoc}
	 */
	public HashDigraph() {
		graph = new HashMap<V,Map<V,E>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		graph.put(v, new HashMap<V,E>());
	}
}
