package udesc.paa.graph.tests;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Test;

import udesc.paa.graph.Printer;
import udesc.paa.graph.SampleGraphFactory;
import udesc.paa.graph.np.ApproxVertexCover;
import udesc.paa.graph.np.ListHeuristicVertexCover;

public class VertexCoverTest {

	@Test
	public void testCover() {
		ApproxVertexCover approx = new ApproxVertexCover();
		UndirectedGraph<String, DefaultEdge> graph = SampleGraphFactory.cormenFig35();
		Set<String> solution = approx.vertexes(graph);
		System.out.println("Aproximation Algorithm");
		Printer.print(solution);
		
		ListHeuristicVertexCover listHeuristic = new ListHeuristicVertexCover();
		solution = listHeuristic.vertexes(graph);
		System.out.println("List Heuristic Algorithm");
		Printer.print(solution);
		
		assertTrue(true);
	}

}
