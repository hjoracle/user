package Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream {
	public static void main(String[] args) {
		String[] names = {"YOON", "LEE", "PARK"};
		/*
		Stream<String> stm = Arrays.stream(names);		//��Ʈ�� ����
		stm.forEach(s -> System.out.println(s)); 		//���� ���� ����
		*/
		Arrays.stream(names)
			  .forEach(s -> System.out.println(s));
	}
}
