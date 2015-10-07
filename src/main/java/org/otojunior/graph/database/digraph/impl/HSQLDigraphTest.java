package org.otojunior.graph.database.digraph.impl;

import org.otojunior.graph.DigraphsTestCase;

public class HSQLDigraphTest extends DigraphsTestCase<String>{
	@Override
	public void setUp() throws Exception {
		graph = new HSQLDigraph<String, Integer>(
				"jdbc:hsqldb:mem:mymemdb;sql.unique_nulls=false", "SA", "") {
			@Override
			protected String getSQLTypeForEdge() { return "INTEGER"; }
			@Override
			protected String getSQLTypeForVertex() { return "VARCHAR(3)";	}
		};
		
	}

	@Override
	protected String toV(String v) {
		return v;
	}
}
