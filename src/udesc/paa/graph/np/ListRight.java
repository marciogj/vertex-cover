package udesc.paa.graph.np;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import udesc.paa.graph.utils.GraphUtils;

public class ListRight implements VertexCover {

	@Override
	public Set<String>  vertexes(final UndirectedGraph<String, DefaultEdge> graph) {
		return listRight(graph);
	}	
	
	public Set<String>  listRight(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  result = new HashSet<String>();
		List<String> allVertexes = GraphUtils.getSortedAscending(graph);
		Set<DefaultEdge> edges = null;
		String neighbor = null;
		List<String> visited = new ArrayList<String>();

		for (String vertex : allVertexes) {
			edges = graph.edgesOf(vertex);
			
			for (DefaultEdge edge : edges) {
				neighbor = GraphUtils.getNeighbor(graph, vertex, edge);
				if (visited.contains(neighbor) && !result.contains(neighbor)) {
					result.add(vertex);
					break;
				}
			}
			visited.add(vertex);
		}
		return result;
	}
	

}
