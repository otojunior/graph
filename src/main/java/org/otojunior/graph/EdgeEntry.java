package org.otojunior.graph;

import java.io.Serializable;

public interface EdgeEntry<V, E> extends	Serializable {
	V getVi();
	V getVj();
	E getEdge();
	E setEdge(E newValue);
}
