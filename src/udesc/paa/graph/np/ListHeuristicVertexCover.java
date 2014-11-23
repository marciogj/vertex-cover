package udesc.paa.graph.np;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import udesc.paa.graph.utils.GraphUtils;

public class ListHeuristicVertexCover implements VertexCover {

	@Override
	public Set<String>  vertexes(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  leftList = listLeft(graph);
		Set<String>  rightList = listRight(graph);
		
		return leftList.size() < rightList.size() ? leftList : rightList;
	}
	
	public Set<String>  listLeft(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  result = new HashSet<String>();
		List<String> allVertexes = GraphUtils.getSortedDescending(graph);
		Set<DefaultEdge> edges = null;
		String neighbor = null;
		for (String vertex : allVertexes) {
			edges = graph.edgesOf(vertex);
			
			for (DefaultEdge edge : edges) {
				neighbor = getNeighbor(graph, vertex, edge);
				if (!result.contains(neighbor)) {
					result.add(vertex);
					break;
				}
			}
		}
		return result;
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
				neighbor = getNeighbor(graph, vertex, edge);
				if (visited.contains(neighbor) && !result.contains(neighbor)) {
					result.add(vertex);
					break;
				}
			}
			visited.add(vertex);
		}
		return result;
	}
	
	private String getNeighbor(final UndirectedGraph<String, DefaultEdge> graph, String v, DefaultEdge edge) {
		String neighbor = graph.getEdgeTarget(edge);
		
		if (neighbor.equals(v)) {
			neighbor = graph.getEdgeSource(edge);
		}
		return neighbor;
	}
	
//	public Set<String>  list(final UndirectedGraph<String, DefaultEdge> graph) {
//		Set<String>  result = new HashSet<String>();
//		
//		List<String> allVertexes =GraphUtils.getSortedDescending(graph);
//		Set<DefaultEdge> edges = null;
//		String neighbor = null;
//		for (String currentVertex : allVertexes) {
//			edges = graph.edgesOf(currentVertex);
//			for (DefaultEdge edge : edges) {
//				neighbor = graph.getEdgeTarget(edge);
//				if (neighbor.equals(currentVertex)) {
//					neighbor = graph.getEdgeSource(edge);
//				}
//				if (!result.contains(neighbor)) {
//					result.add(currentVertex);
//					break;
//				}
//			}
//		}
//		
//		return result;
//	}

}
