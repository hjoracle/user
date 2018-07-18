package NestedLambda;

interface Printable5 {
	void print();
}
class Papers1 {
	private String con;
	public Papers1(String s) {con = s;}

	public Printable5 getPrinter() {
		class Printer implements Printable5 {		//로컬 클래스의 정의
			public void print() {
				System.out.println(con);
			}
		}
		return new Printer();		//로컬 클래스의 인스턴스 생성 및 변환
	}
}

public class First {

	public static void main(String[] args) {
		Papers1 p = new Papers1("print this");
		Printable5 prn = p.getPrinter();
		prn.print();
	}
}
