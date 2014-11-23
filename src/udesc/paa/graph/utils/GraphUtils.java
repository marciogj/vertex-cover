package udesc.paa.graph.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphUtils {

	public static List<String> getSortedAscending(final UndirectedGraph<String, DefaultEdge> graph) {
		return getSorted(graph, Order.ASC);
	}
	
	public static List<String> getSortedDescending(final UndirectedGraph<String, DefaultEdge> graph) {
		return getSorted(graph, Order.DESC);
	}
	
	public static List<String> getSorted(final UndirectedGraph<String, DefaultEdge> graph, Order order) {
		List<CachedVertex> sortedVertex = new ArrayList<CachedVertex>();
		
		for (String v : graph.vertexSet()) {
			Set<DefaultEdge> edges = graph.edgesOf(v);
			sortedVertex.add(new CachedVertex(v, edges));
		}
		if (order ==  Order.DESC) {
			Collections.sort(sortedVertex, Collections.reverseOrder(new VertexComparator()));
		} else {
			Collections.sort(sortedVertex, new VertexComparator());
		}
				
		List<String> vertexList = new ArrayList<String>();
		for (CachedVertex v : sortedVertex) {
			vertexList.add(v.vertex);
			
		}
		return vertexList;
	}
	
}

