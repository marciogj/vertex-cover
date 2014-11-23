package udesc.paa.graph.np;

import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public interface VertexCover {
	
	public Set<String> vertexes(final UndirectedGraph<String, DefaultEdge> graph);

}
