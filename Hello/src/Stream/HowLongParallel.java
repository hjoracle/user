package Stream;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class HowLongParallel {
	
	public static long fibonacci(long n) {
		if(n ==1 || n ==2)
			return 1;
		return
			fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(41, 41, 43, 44, 45, 46);
		
		Instant start = Instant.now();		//스톱워치 시작
		nums.parallelStream()						//순차 스트림 생성
			.map(n -> fibonacci(n))
			.forEach(r -> System.out.println(r));
		
		Instant end = Instant.now();		//스톱워치 멈춤
		System.out.println("Parallel Processing Time: " + 
			Duration.between(start, end).toMillis());

	}
}
