package org.otojunior.graph.memory;

import org.otojunior.graph.DigraphsTestCase;
import org.otojunior.graph.memory.HashDigraph;

/**
 * Hash Digraph test.
 * @author Oto Junior
 */
public class HashDigraphTest extends DigraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		graph = new HashDigraph<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
