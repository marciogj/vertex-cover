package udesc.paa.graph.np;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import udesc.paa.graph.utils.GraphUtils;

public class ListLeft implements VertexCover {

	@Override
	public Set<String>  vertexes(final UndirectedGraph<String, DefaultEdge> graph) {
		return  listLeft(graph);
	}
	
	public Set<String>  listLeft(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  result = new HashSet<String>();
		List<String> allVertexes = GraphUtils.getSortedDescending(graph);
		Set<DefaultEdge> edges = null;
		String neighbor = null;
		for (String vertex : allVertexes) {
			edges = graph.edgesOf(vertex);
			
			for (DefaultEdge edge : edges) {
				neighbor = GraphUtils.getNeighbor(graph, vertex, edge);
				if (!result.contains(neighbor)) {
					result.add(vertex);
					break;
				}
			}
		}
		return result;
	}

}
