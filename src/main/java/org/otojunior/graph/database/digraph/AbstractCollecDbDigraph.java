package org.otojunior.graph.database.digraph;


import org.otojunior.graph.database.AbstractCollecDbGraph;

public abstract class AbstractCollecDbDigraph<V,E> extends AbstractCollecDbGraph<V, E> {
	/**
	 * Default constructor.
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 */
	public AbstractCollecDbDigraph(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}
}
