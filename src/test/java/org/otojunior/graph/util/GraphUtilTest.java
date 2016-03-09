package org.otojunior.graph.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.Graph;
import org.otojunior.graph.memory.HashDigraph;
import org.powermock.reflect.Whitebox;

/**
 * Graph Util test.
 * @author Oto Junior
 *
 */
public class GraphUtilTest {
	/**
	 * Test for method maxEdge().
	 */
	@Test
	public void testMaxEdge() {
		Graph<String, Integer> graph = new HashDigraph<String, Integer>();
		graph.addEdge("A","B",2);
		graph.addEdge("B","C",5);
		graph.addEdge("C","A",7);
		graph.addEdge("B","D",3);
		EdgeEntry<String, Integer> maxEdge = GraphUtil.maxEdge(graph);
		assertEquals("C", maxEdge.getVi());
		assertEquals("A", maxEdge.getVj());
		assertEquals(7, maxEdge.getEdge().intValue());
	}
	
	/**
	 * Test for method maxEdge() on empty graph.
	 */
	@Test
	public void testMaxEdgeEmptyGraph() {
		Graph<String, Integer> graph = new HashDigraph<String, Integer>();
		EdgeEntry<String, Integer> maxEdge = GraphUtil.maxEdge(graph);
		assertNull(maxEdge);
	}
	
	/**
	 * Test for method minEdge().
	 */
	@Test
	public void testMinEdge() {
		Graph<String, Integer> graph = new HashDigraph<String, Integer>();
		graph.addEdge("A","B",2);
		graph.addEdge("B","C",1);
		graph.addEdge("C","A",7);
		graph.addEdge("B","D",3);
		EdgeEntry<String, Integer> minEdge = GraphUtil.minEdge(graph);
		assertEquals("B", minEdge.getVi());
		assertEquals("C", minEdge.getVj());
		assertEquals(1, minEdge.getEdge().intValue());
	}
	
	/**
	 * Private constructor invocation for Eclemma coverage.
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		Whitebox.invokeConstructor(
			GraphUtil.class, 
			ArrayUtils.EMPTY_OBJECT_ARRAY);
	}
	
	/**
	 * Test for method minEdge() on empty graph.
	 */
	@Test
	public void testMinEdgeEmptyGraph() {
		Graph<String, Integer> graph = new HashDigraph<String, Integer>();
		EdgeEntry<String, Integer> minEdge = GraphUtil.minEdge(graph);
		assertNull(minEdge);
	}
}
