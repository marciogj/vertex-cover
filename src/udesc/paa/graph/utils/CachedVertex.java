package udesc.paa.graph.utils;

import java.util.Set;

import org.jgrapht.graph.DefaultEdge;

public class CachedVertex {
	protected String vertex;
	protected Set<DefaultEdge> edges;
	
	public CachedVertex(String vertex, Set<DefaultEdge> edges) {
		super();
		this.vertex = vertex;
		this.edges = edges;
	}
	
	@Override
	public String toString() {
		return vertex + "(" + edges.size() + ")";
	}
	
	
}

