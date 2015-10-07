package org.otojunior.graph.database.digraph;

import org.otojunior.graph.database.AbstractDbGraph;


/**
 * Abstract class of directional graphs.
 * @author Oto
 */
public abstract class AbstractDbDigraph<V, E> extends AbstractDbGraph<V, E> {
	/**
	 * Default constructor.
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 */
	public AbstractDbDigraph(String driver, String url, String user,
			String password) {
		super(driver, url, user, password);
	}
}
