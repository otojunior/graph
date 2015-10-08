package org.otojunior.graph.util;

import java.util.Iterator;

import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.Graph;

/**
 * Graphic Utilities.
 * @author Oto Junior
 */
public class GraphUtil {
	/**
	 * Obtain the maximal valued edge.
	 * @param <V> The Vertex Class.
	 * @param <E> The Edge Class.
	 * @param graph The Graph to be searched.
	 * @return an Edge Entry.
	 */
	public static <V, E extends Number> EdgeEntry<V, E> maxEdge(Graph<V, E> graph) {
		EdgeEntry<V, E> found = null;
		Iterator<EdgeEntry<V, E>> it = graph.iterator();
		if (it.hasNext()) found = it.next();
		while (it.hasNext()) {
			EdgeEntry<V, E> current = it.next();
			if (current.getEdge().doubleValue() > found.getEdge().doubleValue()) {
				found = current;
			}
		}
		return found;
	}
	
	/**
	 * Obtain the minimal valued edge.
	 * @param <V> The Vertex Class.
	 * @param <E> The Edge Class.
	 * @param graph The Graph to be searched.
	 * @return an Edge Entry.
	 */
	public static <V, E extends Number> EdgeEntry<V, E> minEdge(Graph<V, E> graph) {
		EdgeEntry<V, E> found = null;
		Iterator<EdgeEntry<V, E>> it = graph.iterator();
		if (it.hasNext()) found = it.next();
		while (it.hasNext()) {
			EdgeEntry<V, E> current = it.next();
			if (current.getEdge().doubleValue() < found.getEdge().doubleValue()) {
				found = current;
			}
		}
		return found;
	}
}
