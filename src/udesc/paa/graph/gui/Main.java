package udesc.paa.graph.gui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import udesc.paa.graph.SampleGraphFactory;

public class Main {
	public static PrintWriter writer;
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		//BenchmarkRunner benchmark = new BenchmarkRunner();
		//benchmark.evaluate("bhoslib-benchmark", SampleGraphFactory.BHOSLIBBenchmaks());
		//benchmark.evaluate("random-benchmark", SampleGraphFactory.randomBenchmaks());
	
		
		
		JGraphPainter painter = new JGraphPainter(SampleGraphFactory.frb59_26_5mis());
		painter.setVisible(true);
		
	}

}
