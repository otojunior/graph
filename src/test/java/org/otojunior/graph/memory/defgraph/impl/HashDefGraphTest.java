package org.otojunior.graph.memory.defgraph.impl;

import org.otojunior.graph.DefGraphsTestCase;

/**
 * Hash defgraphs test.
 * @author Oto Junior
 *
 */
public class HashDefGraphTest extends DefGraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		graph = new HashDefGraph<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
