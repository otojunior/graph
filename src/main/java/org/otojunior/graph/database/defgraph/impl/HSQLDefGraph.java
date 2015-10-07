package org.otojunior.graph.database.defgraph.impl;

import org.otojunior.graph.database.defgraph.AbstractDbDefGraph;
import org.otojunior.graph.util.sql.Sql;

public abstract class HSQLDefGraph<V,E> extends AbstractDbDefGraph<V, E> {
	public HSQLDefGraph(String url, String user, String password) {
		super(Sql.HSQLDB_DRIVER, url, user, password);
	}
}
