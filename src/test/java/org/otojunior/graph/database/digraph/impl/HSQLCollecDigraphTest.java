package org.otojunior.graph.database.digraph.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import org.junit.Test;
import org.otojunior.graph.DigraphsTestCase;

public class HSQLCollecDigraphTest extends DigraphsTestCase<Collection<String>> {
	@Override
	public void setUp() throws Exception {
		graph = new HSQLCollecDigraph<String, Integer>(
				"jdbc:hsqldb:mem:mymemdb;sql.unique_nulls=false", "SA", "",
				"VARCHAR(3) ARRAY", "INTEGER");
		
	}
	
	@Test
	public void testAddAndGetEdgeUnOrdered() {
		Collection<String> v1 = toV("A");
		Collection<String> v2 = toV("B","C");
		Collection<String> v3 = toV("C","B");
		assertTrue(v2.equals(v3));
		graph.addEdge(v1, v2, 2);
		assertNotNull(graph.getEdge(v1, v2));
		assertNotNull(graph.getEdge(v1, v3));
		assertNull(graph.getEdge(v2, v1));
		assertNull(graph.getEdge(v3, v1));
	}

	@Override
	protected Collection<String> toV(String v) {
		return Collections.singleton(v);
	}
	
	protected Collection<String> toV(String... v) {
		Collection<String> c = new LinkedHashSet<String>();
		for (String string : v)
			c.add(string);
		return c;
	}
}
