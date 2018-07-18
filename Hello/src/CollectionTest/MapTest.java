package CollectionTest;

import java.util.HashMap;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(10,  "ten");
		map.put(20, "twenty");
		map.put(30, "thirty");
		System.out.println(map.get(10));
		Set<Integer> ks = map.keySet();
		
		for(Integer i : ks)
			System.out.println(i + " " + map.get(i));
	}

}
