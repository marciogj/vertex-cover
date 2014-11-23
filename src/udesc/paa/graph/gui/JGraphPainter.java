package udesc.paa.graph.gui;

import java.util.Collection;

import javax.swing.JFrame;

import org.jgrapht.ListenableGraph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;

import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxStyleUtils;

public class JGraphPainter extends JFrame{
	private static final long serialVersionUID = 2202072534703043195L;

	private JGraphXAdapter<String, DefaultEdge> jgxAdapter;
	private UndirectedGraph<String, DefaultEdge> graph;

	JGraphPainter(UndirectedGraph<String, DefaultEdge> graph) {
		this.graph = graph;
		this.init();
		this.setTitle("PAA Vertex Cover Painter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	public void init() {
		ListenableGraph<String, DefaultEdge> g = new ListenableUndirectedGraph<String, DefaultEdge>(graph);
		jgxAdapter = new JGraphXAdapter<String, DefaultEdge>(g);
		
		getContentPane().add(new mxGraphComponent(jgxAdapter));
		
		mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
		mxGraphModel graphModel  = (mxGraphModel)graphComponent.getGraph().getModel(); 
		Collection<Object> cells =  graphModel.getCells().values(); 
		mxStyleUtils.setCellStyles(graphComponent.getGraph().getModel(), cells.toArray(),
				mxConstants.STYLE_ENDARROW, mxConstants.NONE);
		//mxUtils.setCellStyles(graphComponent.getGraph().getModel(), 
		//    cells.toArray(), mxConstants.STYLE_ENDARROW, mxConstants.NONE);
		
		
		//mxCompactTreeLayout layout = new mxCompactTreeLayout(jgxAdapter);
		mxIGraphLayout layout = new mxFastOrganicLayout(jgxAdapter);
		//mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
		layout.execute(jgxAdapter.getDefaultParent());
	}
}

