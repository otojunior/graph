package org.otojunior.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Non Directional Test Case.
 * @author Oto Junior
 *
 * @param <V> Vertex.
 */
public abstract class DefGraphsTestCase<V> extends DigraphsTestCase<V> {
	/**
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#addEdge(java.lang.Object, java.lang.Object, java.lang.Object)}.
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
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#addEdge(java.lang.Object, java.lang.Object, java.lang.Object)}.
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
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#getEdge(java.lang.Object, java.lang.Object)}.
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
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#getEdgeCollection()}.
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
	 * Test method for {@link graph.memory.digraph.impl.LinkedDigraph#hasEdge()}.
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
}
