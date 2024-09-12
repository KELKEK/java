package com.shinhan.week3.day3.stream;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.shinhan.week3.day3.Product;
import com.shinhan.week3.day3.Student;

public class StreamTest2 {
	static List<Student> data2 = new ArrayList<>();
	static {
		data2.add(new Student("신용권", 100));
		data2.add(new Student("정민교", 99));
		data2.add(new Student("신용권", 100));
		data2.add(new Student("심은정", 88));
		data2.add(new Student("심은지", 60));
	}//밖에서도 쓸 수 있게 하기 위해 블록을 만들어서 넣었다. //static환경에서 쓸 수 있게 함

	public static void main(String[] args) {
		// f1();
		// f2();
		// f3();
		// f4();
		// f5();
		// f6();
		f7();
	}

	private static void f7() {
		int[] arr = {1, 2, 3, 4, 5};
		
		Arrays.stream(arr).asDoubleStream().forEach(d->System.out.println(d));
		
		Arrays.stream(arr).boxed().forEach(d->System.out.println(d));//int -> Integer로 박싱효과 (new Integer (1))
		Arrays.stream(arr).boxed().forEach(d->System.out.println(d.intValue()));//int -> Integer로 박싱효과 (new Integer (1))
	}

	private static void f6() {
		// TODO Auto-generated method stub
		// map은 들어간 것과 나오는 것이 다르다.(변형)
		data2.stream()
		.map(st->st.getName() + "$") //전부 이름 옆에 $를 붙임
		.forEach(st->System.out.println(st));
	}

	private static void f5() {// 요소 변환(매핑)
		List<Student> data = new ArrayList<>();
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 99));
		data.add(new Student("신용권", 100));
		data.add(new Student("심은정", 88));
		data.add(new Student("심은지", 60));

		data.stream().mapToInt(st -> st.getScore()) // 객체(Student)가 들어가고 int(Score)가 나온다. // IntStream
				.forEach(st -> System.out.println(st));

		IntStream scoreStream = data.stream().mapToInt(st -> st.getScore());
		double avg = scoreStream.average().getAsDouble();
		System.out.println(avg);
	}

	private static void f4() {
		List<Product> list = new ArrayList<>();
		IntStream.range(1, 6).forEach(i -> {
			Product p = new Product(i, "상품" + i, "멋진회사", (int) (Math.random() * 10000));
			list.add(p);
		});// 1보다 크거나 같고 6보다 작다

		list.stream()
				// .filter(p->p.getPno() >= 3)
				// .filter(p->p.getName().startsWith("상품"))
				.filter(p -> p.getPrice() > 5000).forEach(p -> System.out.println(p));
	}

	private static void f3() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("신용권", 100));
		data.add(new Student("정민교", 99));
		data.add(new Student("신용권", 100));
		data.add(new Student("심은정", 88));
		data.add(new Student("심은지", 60));

		System.out.println("==========이름이 심씨인 사람만 출력하는 조건=====");
		data.stream().distinct().filter(name -> name.getName().startsWith("심")).forEach(st -> System.out.println(st));

		System.out.println("==========90점 이상만 출력=====");
		data.stream().distinct().filter(st -> st.getScore() >= 90).forEach(st -> System.out.println(st));
	}

	private static void f2() {// 736p
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("A1");
		list.add("A1");
		list.add("A2");
		list.add("B");
		list.add("B");
		list.add("C3");
		list.add("C3");
		list.add("D");

		list.stream().distinct()// 이렇게 '.'기준으로 줄바꿈해도 ㄱㅊ //중복을 없애는 역할을 함, 외워두면 좋을듯(굳이 Set으로 다시 안 바꿔도 되니까)
				.filter(name -> name.length() >= 2)// filter의 조건(Predicate)에 대해 true인 것만 반환 filter(Predicate)
				.forEach(name -> System.out.println(name));// name : 받을 이름 지정 //람다표현식 사용
	}

	private static void f1() {
		// 하나의 문자를 몇바이트처리하는가? UTF-8씀(한 글자 당 3byte처리, 따라서 3바이트 처리하는 걸로 받아야한다)
		System.out.println(Charset.defaultCharset());
	}

}
