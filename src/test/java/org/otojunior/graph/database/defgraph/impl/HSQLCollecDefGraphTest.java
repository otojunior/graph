package graph.database.defgraph.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import graph.DefGraphsTestCase;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import org.junit.Test;

public class HSQLCollecDefGraphTest extends DefGraphsTestCase<Collection<String>> {
	@Override
	public void setUp() throws Exception {
		graph = new HSQLCollecDefGraph<String, Integer>(
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
		assertNotNull(graph.getEdge(v2, v1));
		assertNotNull(graph.getEdge(v3, v1));
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