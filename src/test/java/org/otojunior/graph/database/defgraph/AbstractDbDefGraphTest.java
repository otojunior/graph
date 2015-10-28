/**
 * 
 */
package org.otojunior.graph.database.defgraph;

import org.otojunior.graph.DefGraphsTestCase;

/**
 * @author 01456231650
 *
 */
public class AbstractDbDefGraphTest extends DefGraphsTestCase<String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUp() throws Exception {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:target/graphtest";
		String user = "sa";
		String password = "sa";
		
		graph = new AbstractDbDefGraph<String, Integer>(driver, url, user, password) {
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
