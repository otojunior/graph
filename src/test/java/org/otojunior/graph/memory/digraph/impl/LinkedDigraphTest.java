package org.otojunior.graph.memory.digraph.impl;

import org.otojunior.graph.DigraphsTestCase;

/**
 * Linked Digraphs Test Case.
 * @author Oto Junior
 */
public class LinkedDigraphTest extends DigraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		graph = new LinkedDigraph<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
