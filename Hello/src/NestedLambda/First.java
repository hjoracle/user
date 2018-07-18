package NestedLambda;

interface Printable5 {
	void print();
}
class Papers1 {
	private String con;
	public Papers1(String s) {con = s;}

	public Printable5 getPrinter() {
		class Printer implements Printable5 {		//���� Ŭ������ ����
			public void print() {
				System.out.println(con);
			}
		}
		return new Printer();		//���� Ŭ������ �ν��Ͻ� ���� �� ��ȯ
	}
}

public class First {

	public static void main(String[] args) {
		Papers1 p = new Papers1("print this");
		Printable5 prn = p.getPrinter();
		prn.print();
	}
}
