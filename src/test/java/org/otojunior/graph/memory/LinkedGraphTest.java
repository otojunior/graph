package org.otojunior.graph.memory;

import org.otojunior.graph.GraphsTestCase;
import org.otojunior.graph.memory.LinkedGraph;

/**
 * Linked Defgraphs Test.
 * @author Oto Junior
 */
public class LinkedGraphTest extends GraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		graph = new LinkedGraph<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
