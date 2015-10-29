package org.otojunior.graph.memory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Linked Non-Directinal Graph.
 * @author Oto Junior
 */
public class LinkedGraph<V, E> extends AbstractGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7051324677952115606L;

	/**
	 * {@inheritDoc}
	 */
	public LinkedGraph() {
		graph = new LinkedHashMap<V,Map<V,E>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addVertex(V v) {
		graph.put(v, new LinkedHashMap<V,E>());
	}
}
