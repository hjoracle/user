package Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Car implements Comparable<Car> {
	protected int disp;		//��ⷮ

	public Car(int d) {disp = d;}

	@Override
	public String toString() {
		return "cc: " + disp;
	}
	@Override
	public int compareTo(Car o) {
		return disp - o.disp;
	}
}

class ECar extends Car {	//���� �ڵ����� ǥ���� Ŭ����
	private int battery;	//���͸�
	
	public ECar(int d, int b) {
		super(d);
		battery = b;
	}
	@Override
	public String toString() {
		return "cc: " + disp + ", ba: " + battery;
	}
}


public class ECarSortCollections {

	public static void main(String[] args) {
		List<ECar> list = new ArrayList<>();
		list.add(new ECar(1200, 99));
		list.add(new ECar(3000, 55));
		list.add(new ECar(1800, 87));
		Collections.sort(list);		//����
		
		for(Iterator<ECar> itr = list.iterator(); itr.hasNext();)	//���
			System.out.println(itr.next().toString() + '\t');

	}
}