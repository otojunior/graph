package org.otojunior.graph.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash Non-Directinal Graph.
 * @author Oto Junior
 */
public class HashGraph<V, E> extends AbstractGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -140928490459208185L;

	/**
	 * {@inheritDoc}
	 */
	public HashGraph() {
		graph = new HashMap<V,Map<V,E>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		graph.put(v, new HashMap<V,E>());
	}
}
