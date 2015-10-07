package org.otojunior.graph.database.digraph.impl;

import org.otojunior.graph.database.digraph.AbstractDbDigraph;
import org.otojunior.graph.util.sql.Sql;

public abstract class HSQLDigraph<V,E> extends AbstractDbDigraph<V, E> {
	public HSQLDigraph(String url, String user, String password) {
		super(Sql.HSQLDB_DRIVER, url, user, password);
	}
}
