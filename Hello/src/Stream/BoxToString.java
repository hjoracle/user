package Stream;
//문제29-1
import java.util.Arrays;
import java.util.List;

class Box<T> {
	private T ob;
	public Box(T o) { ob = o; }
	public T get() { return ob; }
}

public class BoxToString {
	public static void main(String[] args) {
		List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
		
		//문제1
		ls.stream()
		  .map(s -> s.get())
		  .forEach(n -> System.out.print(n + "\t"));
		System.out.println();
		//문제2		
		ls.stream()
		  .map(s -> s.get().length())
		  .forEach(n -> System.out.print(n + "\t"));
		System.out.println();
	}
}
