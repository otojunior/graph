package org.otojunior.graph.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash Directional Graph.
 *
 * @author Oto Junior
 * @version $Id: $Id
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
	 *
	 * @param v a V object.
	 */
	public void addVertex(V v) {
		graph.put(v, new HashMap<V,E>());
	}
}
