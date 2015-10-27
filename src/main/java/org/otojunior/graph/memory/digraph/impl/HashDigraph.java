package org.otojunior.graph.memory.digraph.impl;

import java.util.HashMap;
import java.util.Map;

import org.otojunior.graph.memory.digraph.AbstractDigraph;

/**
 * Hash Directional Graph.
 * @author Oto Junior
 */
public class HashDigraph<V, E> extends AbstractDigraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3091980736765347603L;

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
