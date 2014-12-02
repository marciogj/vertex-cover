package udesc.paa.graph.gui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import udesc.paa.graph.DSHelper;
import udesc.paa.graph.np.CormenApprox;
import udesc.paa.graph.np.ListLeft;
import udesc.paa.graph.np.ListRight;
import udesc.paa.graph.np.VertexCover;
import udesc.paa.graph.utils.NamedGraph;

public class BenchmarkRunner {
	public PrintWriter writer;
	
	public void evaluate(String benchmarkName, List<NamedGraph> benchmark) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(benchmarkName + "-"+System.currentTimeMillis()+".csv", "UTF-8");
		writer.println("graph-name;vertex-size;edges-size;min-vertex-cover;strategy;vertex-cover;time;solution");
		
		for (NamedGraph graph : benchmark) {
			evaluate(graph, new ListRight());
			evaluate(graph, new ListLeft());
			evaluate(graph, new CormenApprox());
		}	 

		writer.close();
		
	}
	
	private void evaluate(NamedGraph graph, VertexCover strategy) {
		System.out.println("------------");
		long start = System.nanoTime();
		Set<String> solution = strategy.vertexes(graph.get());
		long elapsedTime = System.nanoTime() - start;
		
			
		String graphName = graph.getName();
		int vertexSize = graph.get().vertexSet().size();
		int edgesSize = graph.get().edgeSet().size();
		String minVertexCover = graph.getMinVertexCover();
		String strategyName = strategy.getClass().getSimpleName();
		int vertexCoverSize = solution.size();
		String strSolution = DSHelper.toString(solution);
		
		
		writer.println(
			graphName + ";" + vertexSize + "; " + edgesSize + ";"+ minVertexCover + ";"+
		    strategyName + ";"+ vertexCoverSize + ";" + elapsedTime + ";" + strSolution
		 );
		System.out.println("Graph: " + graphName);
		System.out.println("VertexSize: " + vertexSize);
		System.out.println("EdgesSize: " + edgesSize);
		System.out.println("MinVertexCover" + minVertexCover);
		System.out.println("Strategy: " + strategyName);
		System.out.println("VertexCoverSize: " + vertexCoverSize);
		System.out.println("Time: " + (elapsedTime));
		System.out.println("Solution: " + strSolution);
		System.out.println("------------");
		
	}

}
