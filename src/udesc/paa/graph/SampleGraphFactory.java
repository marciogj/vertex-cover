package udesc.paa.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import udesc.paa.graph.utils.NamedGraph;

public class SampleGraphFactory {

	public static NamedGraph frb20_15_1mis() {
		String path = "bhoslib-benchmarks\frb30-15-mis\frb30-15-1.mis";
		return new NamedGraph(path, DimacsGraphReader.read(path));
	}
	
	//http://www.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm
	public static List<NamedGraph> BHOSLIBBenchmaks() {
		List<NamedGraph> benchmarkList = new ArrayList<NamedGraph>();
		File benchmarkBaseDir = new File("bhoslib-benchmarks");
		ArrayList<File> benchmarkDirs = new ArrayList<File>(Arrays.asList(benchmarkBaseDir.listFiles()));
		for (File benchmarkDir : benchmarkDirs) {
			String dirName = benchmarkDir.getName();
			String[] mvcHint = dirName.split("mvc-");
			String minVertexCover = mvcHint.length == 2 ? mvcHint[1] : "";
			
			ArrayList<File> graphFiles = new ArrayList<File>(Arrays.asList(benchmarkDir.listFiles()));
			for (File graphFile : graphFiles) {
				benchmarkList.add(new NamedGraph(graphFile.getName(), DimacsGraphReader.read(graphFile), minVertexCover));
			}
		}
		
		
		return benchmarkList;
	}
	
	public static UndirectedGraph<String, DefaultEdge> cormenFig35() {
		UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";
		String g = "g";
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);

		graph.addEdge(a, b);
		graph.addEdge(b, c);
		graph.addEdge(c, d);
		graph.addEdge(c, e);
		graph.addEdge(d, e);
		graph.addEdge(d, f);
		graph.addEdge(d, g);
		graph.addEdge(e, f);
		return graph;
	}
	
	public static UndirectedGraph<String, DefaultEdge> cormenPag1090a() {
		UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		
		String z = "z";
		String u = "u";
		String y = "y";
		String v = "v";
		String w = "w";
		String x = "x";
		
		graph.addVertex(z);
		graph.addVertex(u);
		graph.addVertex(y);
		graph.addVertex(v);
		graph.addVertex(w);
		graph.addVertex(x);

		graph.addEdge(z, u);
		graph.addEdge(z, w);
		graph.addEdge(z, x);
		graph.addEdge(u, y);
		graph.addEdge(u, x);
		graph.addEdge(u, v);
		graph.addEdge(y, v);
		graph.addEdge(y, w);
		graph.addEdge(y, x);
		graph.addEdge(x, v);
		return graph;
	}
	
	public static UndirectedGraph<String, DefaultEdge> cormenPag1090b() {
		UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		
		String z = "z";
		String u = "u";
		String y = "y";
		String v = "v";
		String w = "w";
		String x = "x";
		
		graph.addVertex(z);
		graph.addVertex(u);
		graph.addVertex(y);
		graph.addVertex(v);
		graph.addVertex(w);
		graph.addVertex(x);

		graph.addEdge(z, y);
		graph.addEdge(z, v);
		
		graph.addEdge(w, u);
		graph.addEdge(w, v);
		graph.addEdge(w, x);
		return graph;
	}
	
	

}
