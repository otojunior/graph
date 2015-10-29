/**
 * 
 */
package org.otojunior.graph.database;

import org.otojunior.graph.GraphsTestCase;
import org.otojunior.graph.database.AbstractDbGraph;

/**
 * @author 01456231650
 *
 */
public class AbstractDbGraphTest extends GraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:target/graphtest";
		String user = "sa";
		String password = "sa";
		
		graph = new AbstractDbGraph<String, Integer>(driver, url, user, password) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 220823437973060133L;

			/**
			 * {@inheritDoc}
			 */
			@Override 
			protected String getSQLTypeForVertex() { 
				return "VARCHAR(5)";
			}
			
			/**
			 * {@inheritDoc}
			 */
			@Override 
			protected String getSQLTypeForEdge() {
				return "INTEGER";
			}
		};
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String toV(String v) {
		return v;
	}
}
