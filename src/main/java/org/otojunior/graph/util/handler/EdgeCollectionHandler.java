package org.otojunior.graph.util.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.apache.commons.dbutils.ResultSetHandler;
import org.otojunior.graph.EdgeEntry;
import org.otojunior.graph.SimpleEdgeEntry;

/**
 * Edge collection handler for use in Databases graphs.
 * @author Oto
 *
 * @param <V> Vertex
 * @param <E> edge
 */
public class EdgeCollectionHandler<V,E> implements ResultSetHandler<Collection<EdgeEntry<V, E>>> {
	/**
	 * Handles the ResultSet. 
	 */
	@SuppressWarnings("unchecked")
	public Collection<EdgeEntry<V, E>> handle(ResultSet rs) throws SQLException {
		Collection<EdgeEntry<V, E>> edges = 
			new HashSet<EdgeEntry<V, E>>();
		while (rs.next()) {
			EdgeEntry<V, E> aEdgeEntry = new SimpleEdgeEntry<V,E>(
				(V)rs.getObject(1), 
				(V)rs.getObject(2), 
				(E)rs.getObject(3));
			edges.add(aEdgeEntry);
		}
		return Collections.unmodifiableCollection(edges);
	}
}
