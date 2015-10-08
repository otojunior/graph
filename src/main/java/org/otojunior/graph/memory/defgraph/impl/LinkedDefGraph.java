package org.otojunior.graph.memory.defgraph.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.otojunior.graph.memory.defgraph.AbstractDefGraph;

/**
 * Linked Non-Directinal Graph.
 * @author Oto Junior
 */
public class LinkedDefGraph<V, E> extends AbstractDefGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7051324677952115606L;

	/**
	 * {@inheritDoc}
	 */
	public LinkedDefGraph() {
		graph = new LinkedHashMap<V,Map<V,E>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		graph.put(v, new LinkedHashMap<V,E>());
	}
}
