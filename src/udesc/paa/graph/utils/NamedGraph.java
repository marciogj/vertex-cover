package udesc.paa.graph.utils;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;


public class NamedGraph {
	private String name;
	private String minVertexCover;
	private UndirectedGraph<String, DefaultEdge> graph;
	
	public NamedGraph(String name, UndirectedGraph<String, DefaultEdge> graph) {
		super();
		this.name = name;
		this.graph = graph;
	}
	
	public NamedGraph(String name, UndirectedGraph<String, DefaultEdge> graph, String minVertexCover) {
		this(name, graph);
		this.minVertexCover = minVertexCover;
	}

	public UndirectedGraph<String, DefaultEdge> get() {
		return graph;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMinVertexCover() {
		return minVertexCover;
	}

	public void setMinVertexCover(String minVertexCover) {
		this.minVertexCover = minVertexCover;
	}
	
	
}
