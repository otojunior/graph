package org.otojunior.graph.database;

import java.sql.SQLException;

/**
 * Abstract class of directional graphs.
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public abstract class AbstractDbDigraph<V, E> extends AbstractDbBaseGraph<V, E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4881254544550998031L;

	/**
	 * Default constructor.
	 *
	 * @param driver a {@link java.lang.String} object.
	 * @param url a {@link java.lang.String} object.
	 * @param user a {@link java.lang.String} object.
	 * @param password a {@link java.lang.String} object.
	 * @throws java.sql.SQLException if any.
	 * @throws java.lang.ClassNotFoundException if any.
	 */
	public AbstractDbDigraph(String driver, String url, String user, String password) throws 
			ClassNotFoundException, 
			SQLException {
		super(driver, url, user, password);
	}
}
