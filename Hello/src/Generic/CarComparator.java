package Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Car1 {
	protected int disp;
	public Car1(int d) {disp = d;}

	@Override
	public String toString() {return "cc: " + disp;}
}

//Car의 정렬을 위한 클래스
class CarComp implements Comparator<Car1> {
	@Override
	public int compare(Car1 o1, Car1 o2) {return o1.disp - o2.disp;}
}
class ECar1 extends Car1 { 
	private int battery;

	public ECar1(int d, int b) {
		super(d);
		battery  = b;
	}
	@Override
	public String toString() {
		return "cc: " + disp + ", ba: " + battery;
	}
} 
public class CarComparator {

	public static void main(String[] args) {
		List<Car1> clist = new ArrayList<>();
		clist.add(new Car1(1800));
		clist.add(new Car1(1200));
		clist.add(new Car1(3000));
		List<ECar1> elist = new ArrayList<>();
		elist.add(new ECar1(3000, 55));
		elist.add(new ECar1(1800, 87));
		elist.add(new ECar1(1200, 99));
		
		CarComp comp = new CarComp();
		
		//각각 정렬
		Collections.sort(clist, comp);
		Collections.sort(elist, comp);
		
		for(Iterator<Car1> itr = clist.iterator(); itr.hasNext();)
			System.out.println(itr.next().toString() + '\t');
		System.out.println();
		
		for(Iterator<ECar1> itr = elist.iterator(); itr.hasNext();)
			System.out.println(itr.next().toString() + '\t');
		
	}
}
