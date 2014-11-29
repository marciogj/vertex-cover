package udesc.paa.graph;

import java.util.Collection;

public class DSHelper {

	public static void print(Collection<String> list) {
		System.out.println(toString(list));
	}
	
	public static String toString(Collection<String> list) {
		String str = "";
		for (String item : list) {
			str += str.isEmpty() ? item : ", " + item;
		}
		return "{"+str+"}";
	}

}
