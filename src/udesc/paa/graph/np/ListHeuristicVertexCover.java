package udesc.paa.graph.np;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ListHeuristicVertexCover implements VertexCover {

	@Override
	public Set<String>  vertexes(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  leftList = listLeft(graph);
		Set<String>  rightList = listLeft(graph);
		
		return leftList.size() < rightList.size() ? leftList : rightList;
	}
	
	public Set<String>  listLeft(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  vertexList = new HashSet<String>();
		Set<String> graphVertexes = graph.vertexSet();
		List<String> neighbors = new ArrayList<String>(graphVertexes);
		for (String currentVertex : graphVertexes) {
			boolean isNeighbor = false;
			int i = 0;
			while (!isNeighbor && i < neighbors.size()){
				String neighborCandidate = neighbors.get(i);
				isNeighbor = graph.containsEdge(currentVertex, neighborCandidate);
				if (isNeighbor) {
					vertexList.add(currentVertex);
				}
				i++;
			}
		}
		
		return vertexList;
	}
	
	
	public Set<String>  listRight(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  vertexList = new HashSet<String>();
		Set<String> graphVertexes = graph.vertexSet();
		List<String> rightNeighbors = new ArrayList<String>(graphVertexes);
		for (String currentVertex : graphVertexes) {
			rightNeighbors.remove(currentVertex);
			boolean hasRightNeighbor = false;
			int i =  rightNeighbors.size() -1;
			while (!hasRightNeighbor && i >= 0){
				String neighborCandidate = rightNeighbors.get(i);
				hasRightNeighbor = graph.containsEdge(currentVertex, neighborCandidate);
				i--;
			}
			if(hasRightNeighbor){
				vertexList.add(currentVertex);
			}
		}
		
		return vertexList;
	}

}
