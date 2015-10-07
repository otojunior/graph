package org.otojunior.graph.memory.defgraph.impl;

import org.otojunior.graph.DefGraphsTestCase;

public class HashDefGraphTest extends DefGraphsTestCase<String> {
	@Override
	public void setUp() throws Exception {
		graph = new HashDefGraph<String, Integer>();
		
	}

	@Override
	protected String toV(String v) {
		return v;
	}
}
