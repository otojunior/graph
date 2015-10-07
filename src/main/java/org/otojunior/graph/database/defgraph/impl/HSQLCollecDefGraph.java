package org.otojunior.graph.database.defgraph.impl;

import org.otojunior.graph.database.defgraph.AbstractCollecDbDefGraph;
import org.otojunior.graph.util.sql.Sql;

public abstract class HSQLCollecDefGraph<V,E> extends AbstractCollecDbDefGraph<V,E> {
	public HSQLCollecDefGraph(String url, String user, String password) {
		super(Sql.HSQLDB_DRIVER, url, user, password);
	}
}
