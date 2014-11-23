package udesc.paa.graph.np;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ApproxVertexCover implements VertexCover {

	@Override
	public Set<String>  vertexes(final UndirectedGraph<String, DefaultEdge> graph) {
		Set<String>  vertexList = new HashSet<String>();
		Set<DefaultEdge> allEdges = graph.edgeSet();
		List<DefaultEdge> e = new ArrayList<DefaultEdge>();
		for (DefaultEdge edge : allEdges) {
			e.add(edge);
		}
		
		for (DefaultEdge currentEdge : allEdges) {
			if (e.contains(currentEdge)) {
				String source = graph.getEdgeSource(currentEdge);
				String target = graph.getEdgeTarget(currentEdge);
				
				vertexList.add(source);
				vertexList.add(target);

				//remove from E' every edge incident on either u or v
				Set<DefaultEdge> sourceEdges = graph.edgesOf(source);
				for (DefaultEdge srcEdge : sourceEdges) {
					if (!srcEdge.equals(currentEdge)) {
						e.remove(srcEdge);
					}
				}
				//remove from E' every edge incident on either u or v
				Set<DefaultEdge> targetEdges = graph.edgesOf(source);
				for (DefaultEdge tgtEdge : targetEdges) {
					if (!tgtEdge.equals(currentEdge)) {
						e.remove(tgtEdge);
					}
				}
			}
		}
		return vertexList;
	}

}
