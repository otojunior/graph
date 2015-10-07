package org.otojunior.graph.memory.digraph.impl;

import org.otojunior.graph.DigraphsTestCase;

public class LinkedDigraphTest extends DigraphsTestCase<String>{
	@Override
	public void setUp() throws Exception {
		graph = new LinkedDigraph<String, Integer>();
		
	}

	@Override
	protected String toV(String v) {
		return v;
	}
}
