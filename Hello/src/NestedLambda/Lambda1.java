package NestedLambda;

interface Printable1 {
	void print(String s);
}
class Printer implements Printable1 {
	public void print(String s) {
		System.out.println(s);
	}
}

public class Lambda1 {

	public static void main(String[] args) {
		Printable1 prn = new Printer();
		prn.print("What is Lambda?");
	}
}
