package org.otojunior.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

/**
 * Non Directional Test Case.
 * @author Oto Junior
 *
 * @param <V> Vertex.
 */
public abstract class GraphsTestCase<V> extends DigraphsTestCase<V> {
	/**
	 * Test method addEdge().
	 */
	@Override
	@Test
	public void testAddEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(4, graph.getEdgeCollection().size());
	}
	
	/**
	 * Test method addEdge() for a repeated edge.
	 */
	@Test
	public void testRepeatedEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(4, graph.getEdgeCollection().size());
		assertEquals(9, graph.getEdge(toV("A"),toV("B")).intValue());
	}
	
	/**
	 * Test method getEdge().
	 */
	@Test
	public void testGetEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(9, graph.getEdge(toV("A"), toV("B")).intValue());
		assertEquals(9, graph.getEdge(toV("B"), toV("A")).intValue());
		assertEquals(3, graph.getEdge(toV("B"), toV("D")).intValue());
		assertNotNull(graph.getEdge(toV("D"), toV("B")));
	}

	/**
	 * Test method getEdgeCollection().
	 */
	@Test
	public void testGetEdgeCollection() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("D"),3);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		assertEquals(4, graph.getEdgeCollection().size());
	}
	
	/**
	 * Test method hasEdge().
	 */
	@Test
	public void testHasEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("B"),toV("D"),3);
		assertTrue(graph.hasEdge(toV("A"), toV("B")));
		assertTrue(graph.hasEdge(toV("B"), toV("C")));
		assertTrue(graph.hasEdge(toV("B"), toV("D")));
		assertTrue(graph.hasEdge(toV("D"), toV("B")));
	}
	
	/**
	 * Test method iterator().
	 */
	@Test
	public void testIterator() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("C"),4);
		graph.addEdge(toV("B"),toV("D"),8);
		int count = 0;
		for (@SuppressWarnings("unused") EdgeEntry<V, Integer> edge : graph)
			count++;
		assertEquals(3, count);
	}
	
	/**
	 * Test method iterator() removing one element.
	 */
	@Test
	public void testIteratorRemovingElement() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("C"),4);
		graph.addEdge(toV("B"),toV("D"),8);
		Iterator<EdgeEntry<V, Integer>> it = graph.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		assertEquals(0, graph.getEdgeCollection().size());
	}
}
