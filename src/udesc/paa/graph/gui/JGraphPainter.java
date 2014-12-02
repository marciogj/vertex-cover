package udesc.paa.graph.gui;

import java.awt.Dimension;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jgraph.JGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;

import udesc.paa.graph.utils.NamedGraph;

import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxStyleUtils;

public class JGraphPainter extends JFrame{
	private static final long serialVersionUID = 2202072534703043195L;
	private static final Dimension DEFAULT_SIZE = new Dimension(1800,900);
	private JGraphXAdapter<String, DefaultEdge> jgxAdapter;
	private NamedGraph graph;

	JGraphPainter(NamedGraph graph) {
		this.graph = graph;
		//this.init();
		initJPanel();
		this.setTitle("Vertex Cover - " + graph.getName());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920, 1080);
		//this.pack();
	}

	public void init() {
		ListenableGraph<String, DefaultEdge> g = new ListenableUndirectedGraph<String, DefaultEdge>(graph.get());
		jgxAdapter = new JGraphXAdapter<String, DefaultEdge>(g);
		
		//jgxAdapter.setPreferredSize(DEFAULT_SIZE);
		
		mxGraphComponent mxGraph = new mxGraphComponent(jgxAdapter);
		mxGraph.setPreferredSize(DEFAULT_SIZE);
		mxGraph.setMinimumSize(DEFAULT_SIZE);
		mxGraph.setMaximumSize(DEFAULT_SIZE);
		
		getContentPane().add(mxGraph);
		//jgxAdapter.setMinimumGraphSize(new mxRectangle(0,0, 1800, 900));
		mxGraphModel graphModel  = (mxGraphModel)mxGraph.getGraph().getModel(); 
		
		Collection<Object> cells =  graphModel.getCells().values(); 
		mxStyleUtils.setCellStyles(mxGraph.getGraph().getModel(), cells.toArray(),
				mxConstants.STYLE_ENDARROW, mxConstants.NONE);
		//mxUtils.setCellStyles(graphComponent.getGraph().getModel(), 
		//    cells.toArray(), mxConstants.STYLE_ENDARROW, mxConstants.NONE);
		
		
		//mxCompactTreeLayout layout = new mxCompactTreeLayout(jgxAdapter);
		mxIGraphLayout layout = new mxFastOrganicLayout(jgxAdapter);
		
		//mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
		layout.execute(jgxAdapter.getDefaultParent());
	}
	
	
	public void initJPanel() {
	        setSize(DEFAULT_SIZE);
	        JPanel p = new JPanel();
	        p.setSize(DEFAULT_SIZE);

	        GuiGraph g = new GuiGraph();
	        g.run(graph);

	        JGraph jg = g.getJgraph();

	        p.add(jg);

	        add(p);
	        setVisible(true);
	}
}


