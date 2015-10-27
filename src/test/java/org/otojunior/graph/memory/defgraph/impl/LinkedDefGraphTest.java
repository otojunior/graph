package org.otojunior.graph.memory.defgraph.impl;

import org.otojunior.graph.DefGraphsTestCase;

/**
 * Linked Defgraphs Test.
 * @author Oto Junior
 */
public class LinkedDefGraphTest extends DefGraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		graph = new LinkedDefGraph<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
