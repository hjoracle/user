package MethodReferencesOptional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ArrangeList {

	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
		ls = new ArrayList<>(ls);
		
		Consumer<List<Integer>> c = l -> Collections.reverse(l); 		//람다식
		c.accept(ls);				//순서 뒤집기 진행
		System.out.println(ls);		//출력
	}
}
//Consumer<T> void accept(T t)