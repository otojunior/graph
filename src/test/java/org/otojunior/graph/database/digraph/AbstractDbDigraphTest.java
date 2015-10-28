package org.otojunior.graph.database.digraph;

import org.otojunior.graph.DigraphsTestCase;

public class AbstractDbDigraphTest extends DigraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:target/graphtest";
		String user = "sa";
		String password = "sa";
		
		graph = new AbstractDbDigraph<String, Integer>(driver, url, user, password) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8144887334682388971L;
			
			/**
			 * {@inheritDoc}
			 */
			@Override 
			protected String getSQLTypeForVertex() { 
				return "VARCHAR(5)";
			}
			
			/**
			 * {@inheritDoc}
			 */
			@Override 
			protected String getSQLTypeForEdge() {
				return "INTEGER";
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
