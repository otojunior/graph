package org.otojunior.graph.database;

/**
 * Abstract class of directional graphs.
 * @author Oto Junior
 */
public abstract class AbstractDbDigraph<V, E> extends AbstractDbBaseGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4881254544550998031L;

	/**
	 * Default constructor.
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 */
	public AbstractDbDigraph(String driver, String url, String user, String password) {
		super(driver, url, user, password);
	}
}
