package org.otojunior.graph.memory.digraph.impl;

import org.otojunior.graph.DigraphsTestCase;

public class HashDigraphTest extends DigraphsTestCase<String>{
	@Override
	public void setUp() throws Exception {
		graph = new HashDigraph<String, Integer>();
		
	}

	@Override
	protected String toV(String v) {
		return v;
	}
}
