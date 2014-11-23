package udesc.paa.graph.utils;

import java.util.Comparator;

public class VertexComparator  implements Comparator<CachedVertex> {
	
	public int compare(CachedVertex v1, CachedVertex v2){
		int v1Degree = v1.edges.size();
		int v2Degree = v2.edges.size();
		if (v1Degree == v2Degree)
			return 0;
		else if (v1Degree > v2Degree)
			return 1;
		else
			return -1;
	}
}
