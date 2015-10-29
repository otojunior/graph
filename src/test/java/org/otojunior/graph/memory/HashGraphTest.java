package org.otojunior.graph.memory;

import org.otojunior.graph.GraphsTestCase;
import org.otojunior.graph.memory.HashGraph;

/**
 * Hash defgraphs test.
 * @author Oto Junior
 *
 */
public class HashGraphTest extends GraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		graph = new HashGraph<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
