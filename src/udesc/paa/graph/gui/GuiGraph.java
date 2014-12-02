package udesc.paa.graph.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;

import udesc.paa.graph.utils.NamedGraph;

public class GuiGraph {
	private static final Dimension DEFAULT_SIZE = new Dimension(1900, 980);
	private JGraphModelAdapter<String, DefaultEdge>  m_jgAdapter;
	private JGraph jgraph = null;

	/**
	 * @see java.applet.Applet#init().
	 */
	public void run(NamedGraph graph) {
		// create a JGraphT graph
		ListenableGraph<String, DefaultEdge> g = new ListenableUndirectedGraph<String, DefaultEdge>(graph.get());

		// create a visualization using JGraph, via an adapter
		m_jgAdapter = new JGraphModelAdapter<String, DefaultEdge>(g);
		jgraph = new JGraph(m_jgAdapter);
		adjustDisplaySettings(jgraph);

		Set<String> allVertexes = g.vertexSet();
		int x = 50; int y = 40;
		for (String vertex : allVertexes) {
			positionVertexAt(vertex, x, y);
			x+=50;
			if (x>=(DEFAULT_SIZE.width-100)) {
				x=50;
				y+=50;
			}
		}
		
		// that's all there is to it!...
	}

	private void adjustDisplaySettings(JGraph jg) {
		jg.setPreferredSize(DEFAULT_SIZE);
		jg.setBackground(Color.GRAY);
	}

	private void positionVertexAt(Object vertex, int x, int y) {
		DefaultGraphCell cell = m_jgAdapter.getVertexCell(vertex);
		Map attr = cell.getAttributes();
		Rectangle2D b = GraphConstants.getBounds(attr);

		GraphConstants.setBounds(attr, new Rectangle(x, y, (int)
				b.getWidth(), (int) b.getHeight()));

		Map cellAttr = new HashMap();
		cellAttr.put(cell, attr);
		m_jgAdapter.edit(cellAttr, null, null, null);
	}

	public JGraph getJgraph() {
		return jgraph;
	}

	public void setJgraph(JGraph jgraph) {
		this.jgraph = jgraph;
	}
}