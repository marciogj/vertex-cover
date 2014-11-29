package udesc.paa.graph.tests;

import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Assert;
import org.junit.Test;

import udesc.paa.graph.DSHelper;
import udesc.paa.graph.SampleGraphFactory;
import udesc.paa.graph.np.ListRight;

public class VertexCoverTest {

	@Test
	public void testCover() {
		
		UndirectedGraph<String, DefaultEdge> graph = SampleGraphFactory.cormenFig35();
		testListHeuristicVertexCover(graph, new String[] {"b", "e", "d"});
		
		graph = SampleGraphFactory.cormenPag1090a();
		testListHeuristicVertexCover(graph, new String[] {"u", "x", "y", "z"});
		
		graph = SampleGraphFactory.cormenPag1090b();
		testListHeuristicVertexCover(graph, new String[] {"z", "w"});
		
		
		
	}
	
	

	public void testListHeuristicVertexCover(UndirectedGraph<String, DefaultEdge> graph, String[] expectedCover) {
		ListRight listHeuristic = new ListRight();
		Set<String> solution = listHeuristic.vertexes(graph);
		System.out.println("List Heuristic Algorithm");
		DSHelper.print(solution);
		String message = "";
		boolean isCorrect = true;
		for (String v : expectedCover) {
			isCorrect = solution.contains(v);
			if (!isCorrect) {
				message = "Expecting " + v + " but solution does not have it :(";
			}
			Assert.assertTrue(message, isCorrect);
		}
	}
	

}
