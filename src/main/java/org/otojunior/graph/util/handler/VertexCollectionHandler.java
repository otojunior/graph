package org.otojunior.graph.util.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * Vertex collection handler for use in Databases graphs.
 * @author Oto Junior
 *
 * @param <V> Vertex
 */
public class VertexCollectionHandler<V> implements ResultSetHandler<Collection<V>> {
	/**
	 * Handles the ResultSet. 
	 */
	@SuppressWarnings("unchecked")
	public Collection<V> handle(ResultSet rs) throws SQLException {
		Collection<V> vertexes = new HashSet<V>();
		while (rs.next())
			vertexes.add((V)rs.getObject(1));
		return Collections.unmodifiableCollection(vertexes);
	}
}
