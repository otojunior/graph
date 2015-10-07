package org.otojunior.graph.database.digraph.impl;

import org.otojunior.graph.database.digraph.AbstractCollecDbDigraph;
import org.otojunior.graph.util.sql.Sql;

public abstract class HSQLCollecDigraph<V,E> extends AbstractCollecDbDigraph<V,E> {
	public HSQLCollecDigraph(String url, String user, String password) {
		super(Sql.HSQLDB_DRIVER, url, user, password);
	}
}
