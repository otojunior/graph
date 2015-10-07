package org.otojunior.graph.database.defgraph.impl;

import org.otojunior.graph.DefGraphsTestCase;

public class HSQLDefGraphTest extends DefGraphsTestCase<String> {
	@Override
	public void setUp() throws Exception {
		graph = new HSQLDefGraph<String, Integer>(
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
