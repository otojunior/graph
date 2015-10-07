package org.otojunior.graph.memory.defgraph.impl;

import org.otojunior.graph.DefGraphsTestCase;

public class LinkedDefGraphTest extends DefGraphsTestCase<String> {
	@Override
	public void setUp() throws Exception {
		graph = new LinkedDefGraph<String, Integer>();
		
	}

	@Override
	protected String toV(String v) {
		return v;
	}
}
