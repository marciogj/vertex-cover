package udesc.paa.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Optional;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class DimacsGraphReader {

	public static UndirectedGraph<String, DefaultEdge> read(String path) {
		File file = new File(path);
		return read(file);
	}
	
	public static UndirectedGraph<String, DefaultEdge> read(File file) {
		UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {			
			String line = reader.readLine(); 
			//here are 0 or more lines starting with c at the top of the file which are comment lines and can be ignored.
			while (line.startsWith("c")) {
				line = reader.readLine();
			}
			//"p edge V E" which specifies the size of the graph where V and E are the number of vertices and edges respectively.
			System.out.println(line);
			int lineNumber = 1;
			while( line != null ) {
				lineNumber++;
				line = reader.readLine();
				if (line == null || line.trim().isEmpty()) break; //EOF reached
				Optional<DimacEdge> edge = DimacEdge.create(line);
				if (!edge.isPresent()) {
					throw new RuntimeException("Unexpected line format" + lineNumber + " from file "+file.getName()+". Line value:\n" + line);
				}
				addEdge(graph, edge.get());
				graph.addVertex(edge.get().u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return graph;
	}
	
	private static void addEdge(UndirectedGraph<String, DefaultEdge> graph, DimacEdge edge) {
		graph.addVertex(edge.u);
		graph.addVertex(edge.v);
		graph.addEdge(edge.u, edge.v);
		
	}
}

class DimacEdge {
	String u;
	String v;
	
	public DimacEdge(String u, String v) {
		this.v = v;
		this.u = u;
	}

	//Pattern: 
	//e 1 2
	public static Optional<DimacEdge> create(String dimacLine) {
		String[] parts = dimacLine.trim().split(" ");
		if (parts.length != 3) {
			return Optional.empty();
		}
		DimacEdge edge = new DimacEdge(parts[1], parts[2]);
		return Optional.of(edge);
	}
}