package org.otojunior.graph.util.handler;

import java.sql.Array;
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
public class FilteredVertexCollectionHandler<V> implements ResultSetHandler<Collection<V>> {
	/**
	 * Handles the ResultSet. 
	 */
	public Collection<V> handle(ResultSet rs) throws SQLException {
		Collection<V> vertexes = new HashSet<V>();
		while (rs.next())
			vertexes.add(toCollection(rs.getArray(1)));
		return Collections.unmodifiableCollection(vertexes);
	}
	
	@SuppressWarnings("unchecked")
	private V toCollection(Array array) {
		try {
			Object[] objs = (Object[])array.getArray();
			Collection<Object> newCol = new HashSet<Object>();
			for (int i = 0; i < objs.length; i++) {
				newCol.add(objs[i]);
			}
			return (V)newCol;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
