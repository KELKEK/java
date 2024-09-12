package com.shinhan.week3.day3.stream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import com.shinhan.week3.day3.Product;
import com.shinhan.week3.day3.Student;


public class StreamTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		f7();
	}

	//파일로부터 스트림얻기
	private static void f7() throws URISyntaxException, IOException {//파일로부터 String 얻기
		// TODO Auto-generated method stub
		URI uri = StreamTest.class.getResource("data.txt").toURI();//현재경로의 ./data.txt 주소값이 나옴 <- './'는 생략됨
		Path path = Paths.get(uri);//uri로부터 패스를 어듬
		
		//Stream : Files.lines(path)
		Files.lines(path).forEach(line-> {//forEach : 루프
			System.out.println(line);
		});
	}

	private static void f6() {
		IntStream.range(1, 6).forEach(i->System.out.println(i));
		System.out.println("--------------------------------");
		IntStream.rangeClosed(1, 6).forEach(i->System.out.println(i));//6도 포함됨
	}

	private static void f5() {
		// TODO Auto-generated method stub
		String[] arr = {"홍길동", "심은정", "정민교"};
		int[] scores = {100, 99, 88, 77};
		double result = Arrays.stream(scores).average().getAsDouble();
		Arrays.stream(arr).forEach(name -> System.out.println(name));
		System.out.println(result);
	}

	private static void f4() {
		List<Product> list = new ArrayList<>();
		IntStream.range(1, 6).forEach(i -> {
			Product p = new Product(i, "상품"+i, "멋진회사", (int)(Math.random()*10000));
			list.add(p);
		});//1보다 크거나 같고 6보다 작다
		
		//내부반복자 이용하여 출력
		list.stream().forEach(p->System.out.println(p));
		//내부반복자 이용하여 가격합계구하기
		int total = list.stream().mapToInt(p->p.getPrice()).sum();
		System.out.println(total);
	}

	private static void f3() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("A", 100));
		data.add(new Student("C", 400));
		data.add(new Student("A", 100));
		data.add(new Student("D", 200));
		data.add(new Student("B", 100));
		//map : 변형하다.
		double avg = data.stream().mapToInt(s->s.getScore()).average().getAsDouble();//'.'기준 1->1->2(시작, 중간처리, 마무리)
		System.out.println(avg);
		
	}

	private static void f2() {
		// TODO Auto-generated method stub
		List<String> data = new ArrayList<>();
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		data.add("람다식");
		data.add("박병렬");
		
		//내부반복자
		//data.stream().forEach(a->{
		//	System.out.println(a + "=====스레드명 : " + Thread.currentThread().getName());
		//});
		
		//*병렬처리
		System.out.println("병렬처리");
		data.parallelStream().forEach(a->{
			System.out.println(a + "=====스레드명 : " + Thread.currentThread().getName());
		});
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Set<String> data = new HashSet<>();
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		
		//내부반복자(stream)
		data.stream().forEach(a ->{ //a는 반복자의 String 한 건(:기준 왼쪽에 해당)
			System.out.println(a);//소비자(Consumer)
		});//데이터는 끝날 떄 까지 흐르므로 중간에 나올 수 없다.
	}

}
