package NestedLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
class StrComp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
}
*/

public class Second {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("robot");
		list.add("apple2");
		list.add("box");
		Collections.sort(list, (String o1, String o2) -> o1.length() - o2.length());
		System.out.println(list);
	}
}
