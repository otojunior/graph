package org.otojunior.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Digraphs Test Case.
 * @author Oto Junior
 *
 * @param <V> Vertex.
 */
public abstract class DigraphsTestCase<V> {
	protected Graph<V, Integer> graph;

	@Before
	public abstract void setUp() throws Exception;

	@After
	public void tearDown() throws Exception {
		graph = null;
	}
	
	/**
	 * Test method addVertex().
	 */
	@Test
	public void testAddVertex() {
		assertEquals(0, graph.size());
		graph.addVertex(toV("A"));
		graph.addVertex(toV("B"));
		graph.addVertex(toV("C"));
		assertEquals(3, graph.size());
	}
	
	/**
	 * Test method addRepeatedVertex().
	 */
	@Test
	public void testAddRepeatedVertex() {
		assertEquals(0, graph.size());
		graph.addVertex(toV("A"));
		graph.addVertex(toV("A"));
		graph.addVertex(toV("B"));
		graph.addVertex(toV("C"));
		assertEquals(3, graph.size());
	}
	
	/**
	 * Test method removeVertex().
	 */
	@Test
	public void testRemoveVertex() {
		graph.addVertex(toV("A"));
		graph.addVertex(toV("B"));
		graph.addVertex(toV("C"));
		assertEquals(3, graph.size());
		graph.removeVertex(toV("B"));
		assertEquals(2, graph.size());
	}
	
	/**
	 * Test method addEdge()
	 */
	@Test
	public void testAddEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(5, graph.getEdgeCollection().size());
	}
	
	/**
	 * Test method repeatedEdge().
	 */
	@Test
	public void testRepeatedEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("A"),toV("B"),9);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(4, graph.getEdgeCollection().size());
		assertEquals(9, graph.getEdge(toV("A"),toV("B")).intValue());
	}
	
	
	/**
	 * Test method getEdge()
	 */
	@Test
	public void testGetEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("A"),9);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(2, graph.getEdge(toV("A"), toV("B")).intValue());
		assertEquals(9, graph.getEdge(toV("B"), toV("A")).intValue());
		assertEquals(3, graph.getEdge(toV("B"), toV("D")).intValue());
		assertNull(graph.getEdge(toV("D"), toV("B")));
	}

	/**
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#removeEdge(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testRemoveEdge() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(2, graph.getEdgeCollection().size());
		graph.removeEdge(toV("B"), toV("D"));
		assertEquals(1, graph.getEdgeCollection().size());
		assertNull(graph.getEdge(toV("D"), toV("B")));
		assertNull(graph.getEdge(toV("B"), toV("D")));
	}

	/**
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#size()}.
	 */
	@Test
	public void testSize() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		graph.addEdge(toV("B"),toV("D"),3);
		assertEquals(4, graph.size());
	}

	/**
	 * Test method for {@link graph.memory.digraph.impl.HashDigraph#getVertexCollection()}.
	 */
	@Test
	public void testGetVertexCollection() {
		graph.addEdge(toV("A"),toV("B"),2);
		graph.addEdge(toV("B"),toV("D"),3);
		graph.addEdge(toV("B"),toV("C"),5);
		graph.addEdge(toV("C"),toV("A"),7);
		Collection<V> vertexCollection = graph.getVertexCollection();
		assertEquals(4, vertexCollection.size());
		assertTrue(vertexCollection.contains(toV("A")));
		assertTrue(vertexCollection.contains(toV("B")));
		assertTrue(vertexCollection.contains(toV("C")));
		assertTrue(vertexCollection.contains(toV("D")));
		assertFalse(vertexCollection.contains(toV("E")));
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
		Collection<EdgeEntry<V, Integer>> edges = graph.getEdgeCollection();
		assertEquals(5, edges.size());
		assertTrue(edges.contains(new SimpleEdgeEntry<V, Integer>(toV("A"),toV("B"),2)));
		assertTrue(edges.contains(new SimpleEdgeEntry<V, Integer>(toV("B"),toV("A"),9)));
		assertTrue(edges.contains(new SimpleEdgeEntry<V, Integer>(toV("B"),toV("D"),3)));
		assertTrue(edges.contains(new SimpleEdgeEntry<V, Integer>(toV("B"),toV("C"),5)));
		assertTrue(edges.contains(new SimpleEdgeEntry<V, Integer>(toV("C"),toV("A"),7)));
		assertFalse(edges.contains(new SimpleEdgeEntry<V, Integer>(toV("A"),toV("D"),1)));
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
		assertFalse(graph.hasEdge(toV("D"), toV("B")));
	}
	
	/**
	 * Test method for {@link }
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
		assertEquals(4, count);
	}
	
	protected abstract V toV(String v);
}
