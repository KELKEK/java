package com.shinhan.week3.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface //람다표현식 가능여부 판단
interface Calcuable{
	double calc(double x, double y);
}

//구현 class
class MyCalculator implements Calcuable{

	@Override
	public double calc(double x, double y) {
		return x + y;
	}
	
}


class Computer{
	public static double staticMethod(double x, double y) {
		return x + y + 100;
	}
	public double instanceMethod(double x, double y) {
		return x + y + 200;
	}
}

//710p
@FunctionalInterface
interface Comparable2{
	int compare(String a, String b);
}


interface Creatable{
	public Student create(String name, int score);
}


class Person{
	public Student getStudent(Creatable creatable, String name, int score) {
		return creatable.create(name, score);
	}
}

public class LambdaTest {
	static List<Student> data2 = new ArrayList<>();
	static {
		data2.add(new Student("신용권", 100));
		data2.add(new Student("정민교", 99));
		data2.add(new Student("신용철", 100));
		data2.add(new Student("심은정", 88));
		data2.add(new Student("심은지", 60));
	}//밖에서도 쓸 수 있게 하기 위해 블록을 만들어서 넣었다. //static환경에서 쓸 수 있게 함

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6(); //여기서부턴 오후 수업
		//f9();
		//f10();
		//f11();
		//f12();
		//f13();
		//f14();
		//f15();
		//f16();
		//f17();
		f18();
	}

	private static void f18() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("신용권", 100, "남"));
		data.add(new Student("정민교", 99, "남"));
		data.add(new Student("신용권", 100, "남"));
		data.add(new Student("심은정", 88, "여"));
		data.add(new Student("심은지", 60, "여"));
		
		Map<String, List<Student>> map =
		data.stream().collect(Collectors.groupingBy(st->st.getSex()));
		
		//map.get("남").stream().forEach(st->System.out.println(st));
		map.get("여").stream().forEach(st->System.out.println(st));
		
		
		//그룹화한 것의 score평균을 구하여라
		Map<String, Double> map2 =
		data.stream().collect(Collectors.groupingBy(st->st.getSex(), Collectors.averagingDouble(st->st.getScore())));
		System.out.println(map2);
	}

	private static void f17() {
		//List -> Map {"신용권", 100}, {"심은정", 88}
		//map은 키값이 중복 불가
		Map<String, Integer> map =
				data2.stream()
				.collect(Collectors.toMap(s->s.getName(), s->s.getScore()));//key를 이름, value를 점수로
		
		System.out.println(map);
		
		/*
		Set<String> set =
				data2.stream()
				.collect(Collectors.toSet())
				
				.forEach(s -> System.out.println(s.getName()));
		*/
	}

	private static void f16() {
		List<Student> data3 = new ArrayList<>();
		
		//하생들 점수의 평균구하기
		data2.stream()
		.mapToInt(st->st.getScore())
		.average()
		.ifPresentOrElse(d->{System.out.println(d);}, ()->{System.out.println("답이없음");});
		
		
		data3.stream().mapToInt(Student::getScore).reduce((a, b) -> a+b)
		.ifPresentOrElse(i -> {System.out.println(i);}, () -> {System.out.println("ㄴㄴ");});
	}

	private static void f15() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int total = Arrays.stream(arr).sum();
		long count = Arrays.stream(arr).count();
		OptionalDouble op = Arrays.stream(arr).average();
		op.ifPresent(a->System.out.println(a));
		//op.orElse(0);//배열 값이 없으면 0이라고 찍기
		double result = op.orElse(0);
		
		System.out.println("total = " + total);
		System.out.println("count = " + count);
		
		//첫번째arg : 소비자
		//두 번째arg : runnable
		op.ifPresentOrElse(a->{
			System.out.println("있다 : " + a);//존재할 경우
			}, ()->{System.out.println("없다.");//존재하지 않을 경우
		});
		
	}

	private static void f14() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
		boolean result1 = Arrays.stream(arr).allMatch(a -> a <= 10);//a가 10보다 작은지에 대한 매치를 해줌(모두 매치)
		boolean result2 = Arrays.stream(arr).allMatch(a -> a < 10);
		boolean result3 = Arrays.stream(arr).anyMatch(a -> a < 10);//최소한 하나라도 만족
		boolean result4 = Arrays.stream(arr).anyMatch(a -> a < 10);
		boolean result5 = Arrays.stream(arr).noneMatch(a -> a < 10);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
	}

	private static void f13() {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Arrays.stream(arr).forEach(data->System.out.println(data));
		System.out.println("===========================================");
		int result = Arrays.stream(arr).peek(data->System.out.println(data)).sum();
		System.out.println(result);
	}

	private static void f12() {
		//Product를 이용해서 sort연습(pno, name, company, price)
		Comparator<Product> cp1 = (c, d) -> d.getPrice() - c.getPrice();
		Comparator<Product> cp2 = new Comparator<>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPno() - o2.getPno();
			}
			
		};
		List<Product> plist = new ArrayList<>();
		IntStream.rangeClosed(100, 105).forEach(pid->{
			Product p = new Product(pid, "상품"+(pid/10), "신한", (int)(Math.random()*1000));
			plist.add(p);
		});
		plist.stream()
		.sorted(cp2)
		.forEach(p->System.out.println(p));
		
	}

	private static void f11() {
		// TODO Auto-generated method stub
		// score asc, name desc로 설정해놨었음
		// student는 implements comparable : compareTo ==> score asc, name desc
		//data2.stream().sorted().forEach(st->System.out.println(st));
		
		Comparator<Student> cp1 = (a, b) -> a.getName().compareTo(b.getName());
		Comparator<Student> cp2 = new Comparator<Student>() {//익명구현

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};//둘 다 같은 표현
		Comparator<Student> cp3 = (a, b) -> a.getScore()-b.getScore();

		
		
		data2.stream()
		.sorted((a, b)->a.getName().compareTo(b.getName()))//이름으로 asc로 바꿈
		.forEach(st->System.out.println(st));
	}

	private static void f10() {
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50", "60,70", "80, 90,100");
		
		list2.stream()
		.flatMap(str -> {
			String[] arr = str.split(",");//문자 하나씩 나눔(아직은 각각 문자인 상태) //cp1, cp2, cp3...
			Integer[] arr2 = new Integer[arr.length];
			for(int i = 0; i < arr.length; i++) {
				arr2[i] = Integer.parseInt(arr[i].trim());
			}
			return Arrays.stream(arr2);
		}).mapToInt(intData->intData.intValue()).average().getAsDouble();
		//.forEach(w->System.out.println(w)); 
		
	}

	private static void f9() {
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50", "60,70");

		
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			//Integer[] intArr = new Integer[strArr.length];
			for(int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());//trim()은 앞뒤의 공백을 없앰
			}
			return Arrays.stream(intArr);
		})
		.forEach(number -> System.out.println(number));
		//Stream : new Integer(10) new Integer(20) .....
		//IntStream
		
	}

	private static void f6() {
		List<String> list1 = new ArrayList<String>();
		list1.add("This is a java");
		list1.add("I am a best developer");
		
		//Flatmap(Function<T,R>) : T가 들어가고 R이 나온다.
		//T : String
		//R : Stream
		list1.stream()
		.flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word->System.out.println(word));
	}

	private static void f5() {
		Person p1 = new Person();
		Creatable creatable1 = new Creatable() {
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};//아랫줄이 길어질까봐 해당 줄에 미리 선언
		
		Creatable creatable2 = (String name, int score) -> new Student(name, score);	
		Creatable creatable3 = Student::new;
		Student s = p1.getStudent(creatable1, "홍길동", 100);
		System.out.println(s);
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Student s = new Student("홍길동", 100);
		Student s2 = makeStudent("홍길동", 100);
	}

	private static Student makeStudent(String name, int score) {
		// TODO Auto-generated method stub
		return new Student(name, score);
	}

	private static void f3() {
		String s1 = "A";
		String s2 = "D";
		//Comparable2 comp = (String a, String b) -> a.length() - b.length();//직접 길이의 차이를 구함
		//Comparable2 comp = (a, b) -> a.length() - b.length();
		Comparable2 comp = String::compareToIgnoreCase;//Api기능 이용
		s1.compareTo(s2);
		int result = comp.compare(s1, s2);//알파벳 순서대로 차이점을 구함
		System.out.println(result);
	}

	private static void f2() {
		System.out.println("1, 구현class이용");
		MyCalculator a = new MyCalculator();
		System.out.println("result = " + a.calc(1, 2));
		
		System.out.println("2, 익명구현class이용");
		Calcuable b = new Calcuable() {
			@Override
			public double calc(double x, double y) {
				return x-y;
			}
		};
		System.out.println("result = " + b.calc(1, 2));
		
		System.out.println("3, 람다표현식");
		//Calcuable c = (x, y)-> x * y;
		//Calcuable c = (double x,double y)-> x * y;
		//Calcuable c = (double x,double y)-> {return x * y;};		
		//Calcuable c = Computer::staticMethod;
		Computer computer = new Computer();
		Calcuable c = computer::instanceMethod;
		
		System.out.println("result = " + c.calc(1, 2));

		
	}

	private static void f1() {
		Thread t1 = new Thread(){
			public void run() { System.out.println("Thread구현");}//스레드 직접구현
		};
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread구현...Runnable interface구현");
			}
		});
		Thread t3 = new Thread(() -> {
				System.out.println("Thread구현...Runnable interface구현");
		});
	}
}


