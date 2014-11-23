package udesc.paa.graph.gui;

import udesc.paa.graph.SampleGraphFactory;

public class Main {

	public static void main(String[] args) {
		JGraphPainter painter = new JGraphPainter(SampleGraphFactory.cormenFig35());
		painter.setVisible(true);
	}

}
