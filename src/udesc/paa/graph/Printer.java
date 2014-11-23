package udesc.paa.graph;

import java.util.Collection;

public class Printer {

	public static void print(Collection<String> list) {
		String str = "";
		for (String item : list) {
			str += str.isEmpty() ? item : ", " + item;
		}
		System.out.println("{"+str+"}");
	}

}
