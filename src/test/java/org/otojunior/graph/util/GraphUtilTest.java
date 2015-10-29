package org.otojunior.graph.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.Graph;
import org.otojunior.graph.memory.HashDigraph;

public class GraphUtilTest {
	private Graph<String, Integer> graph;

	@Before
	public void setUp() throws Exception {
		graph = new HashDigraph<String, Integer>();
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testMaxEdge_ComparableEdge() {
		graph.addEdge("A","B",2);
		graph.addEdge("B","C",5);
		graph.addEdge("C","A",7);
		graph.addEdge("B","D",3);
		EdgeEntry<String, Integer> maxEdge = GraphUtil.maxEdge(graph);
		assertEquals("C", maxEdge.getVi());
		assertEquals("A", maxEdge.getVj());
		assertEquals(7, maxEdge.getEdge().intValue());
	}
	
	@Test
	public void testMinEdge() {
		graph.addEdge("A","B",2);
		graph.addEdge("B","C",1);
		graph.addEdge("C","A",7);
		graph.addEdge("B","D",3);
		EdgeEntry<String, Integer> minEdge = GraphUtil.minEdge(graph);
		assertEquals("B", minEdge.getVi());
		assertEquals("C", minEdge.getVj());
		assertEquals(1, minEdge.getEdge().intValue());
	}
}
