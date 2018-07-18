package NestedLambda;

interface Printable6 {
	void print(String s);
}

class Printer implements Printable6 {
	public void print(String s) {
		System.out.println(s);
	}
}

public class Third {
	public static void main(String[] args) {
		Printable6 prn = (String s) -> {System.out.println(s);}; //new Printer();
		prn.print("Sample test");
	}
}