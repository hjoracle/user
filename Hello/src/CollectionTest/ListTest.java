package CollectionTest;

import java.util.ArrayList;
import java.util.List;

class Num {  
	int num;
	public Num(int i) {
		num = i;
	}
	    
	
	@Override
	public String toString() {
		return "Num [num=" + num + "]";
	}
	
}


public class ListTest {
	
	public static void main(String[] args) {
		
		List<Num> nlist = new ArrayList<>();
		Num num1 = new Num(1);
		Num num2 = new Num(2);
		Num num3 = new Num(3);
		
		nlist.add(num1);
		nlist.add(num2);
		nlist.add(num3);
		
		for(Num n: nlist)
			System.out.println(n.num);
		
		nlist.remove(0);
		
		for(Num n: nlist)
			System.out.println(n.toString());
	
		
	
		
		
		
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		list.remove(0);
		System.out.println();
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}

}
