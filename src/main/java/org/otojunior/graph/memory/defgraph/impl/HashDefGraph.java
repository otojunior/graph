package org.otojunior.graph.memory.defgraph.impl;

import java.util.HashMap;
import java.util.Map;

import org.otojunior.graph.memory.defgraph.AbstractDefGraph;

/**
 * Hash Non-Directinal Graph.
 * @author Oto Junior
 */
public class HashDefGraph<V, E> extends AbstractDefGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -140928490459208185L;

	/**
	 * {@inheritDoc}
	 */
	public HashDefGraph() {
		graph = new HashMap<V,Map<V,E>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		graph.put(v, new HashMap<V,E>());
	}
}
