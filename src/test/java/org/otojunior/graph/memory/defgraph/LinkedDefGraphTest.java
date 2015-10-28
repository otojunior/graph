package org.otojunior.graph.memory.defgraph;

import org.otojunior.graph.DefGraphsTestCase;
import org.otojunior.graph.memory.defgraph.LinkedDefGraph;

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
