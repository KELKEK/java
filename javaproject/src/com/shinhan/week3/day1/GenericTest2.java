package com.shinhan.week3.day1;

import java.util.Arrays;
import java.util.Comparator;


class Student implements Comparable<Student>{

	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", score=").append(score).append("]");
		return builder.toString();
	}
	@Override
	public int compareTo(Student obj) {
		// TODO Auto-generated method stub
		//점수로 내림차순 이름은 오름차순
		if(obj.score == score) return name.compareTo(obj.name);
		return obj.score - score;
		//return name.compareTo(obj.name);//여기에 *(-1)하면 내림차순
		//return score - obj.score;//거꾸로하면 내림차순
	}
	
	
}


public class GenericTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
		//f2();
		//f4();
		//f5();
	}

	private static void f5() {
		
		Car[] arr = {
				new Car("A", 100, "black"),
				new Car("E", 500, "Pink"),
				new Car("A", 200, "red"),
				new Car("D", 200, "blue"),
				new Car("C", 300, "dark"),
		};
		System.out.println("original : " + Arrays.toString(arr));
		print2(arr, "original");
		Arrays.sort(arr);
		print2(arr, "기준바뀜");
		Arrays.sort(arr, (o1, o2) ->
		{
			return o1.price - o2.price;
		});//가격으로 ASC
		
		//메서드 자체는 하나이기 때문에 가능한 것
		Arrays.sort(arr, (Car o1, Car o2) ->
		{
			int result = o1.price - o2.price;
			if(result == 0) {
				int result2 = o2.model.compareTo(o1.model);
				return result2;
			}
			return result;
		});//가격으로 ASC, 모델로 DESC
		
	}

	private static void print2(Car[] arr, String title) {
		// TODO Auto-generated method stub
		System.out.println("====" + title + "====");
		for(Car cr:arr) {
			System.out.println(cr);
		}
	}

	//ASC : 나의 값, 들어온 값
	//== : 자리이동x
	//DESC : 들어온값, 나의 값
	private static void f4() {
		// TODO Auto-generated method stub
		Student[] arr = {
				new Student("A", 10),
				new Student("C", 10),
				new Student("E", 50),
				new Student("D", 20),
				new Student("E", 10),
		};
		System.out.println("original : " + Arrays.toString(arr));
		print(arr, "original");
		//Comparable interface를 구현해야 프린트 가능
		Arrays.sort(arr);
		print(arr, "scoreAscending");
		
		//이미 구현된 sort기준을 변경
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				//이름desc, 점수asc
				int result = o2.name.compareTo(o1.name);
				if(result == 0) return o1.score - o2.score;
				return o2.name.compareTo(o1.name);
			}
			
		});
		print(arr, "이름, 점수기준 변경");

		Arrays.sort(arr, (o1, o2) -> {
				//이름asc, 점수desc
				int result = o1.name.compareTo(o2.name);
				if(result == 0) return o1.score - o1.score;
				return o1.name.compareTo(o2.name);
			
		});
		print(arr, "이름, 점수기준 변경");
	}

	
	
	private static void print(Student[] arr, String title) {
		// TODO Auto-generated method stub
		System.out.println("====" + title + "====");
		for(Student st:arr) {
			System.out.println(st);
		}
		
	}

	private static void f2() {
		// TODO Auto-generated method stub
		String[] arr = {"Hello", "Coffee", "Computer", "Java", "java"};
		System.out.println("original : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending Sort : " + Arrays.toString(arr));
		//아스키코드 이용
		//2. 익명구현 클래스
		Arrays.sort(arr, new Comparator<String>(){	
			public int compare(String o1, String o2) {
				return o2.compareToIgnoreCase(o1); //작은게 앞에 찍히도록 함
			}	
		});
		System.out.println("Descending Sort : " + Arrays.toString(arr));

		
		Arrays.sort(arr, (String o1, String o2) ->
		{
			return o2.compareToIgnoreCase(o1);
		});
		System.out.println("Descending Sort : " + Arrays.toString(arr));

	}

	private static void f1() {
		// TODO Auto-generated method stub
		Integer[] arr = {100, 55, 22, 99, 49, 88};
		System.out.println("original" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending Sort : " + Arrays.toString(arr));

		//descending Sort
		//1, 구현class
		//Arrays.sort(arr, new MyDescendingSort());
		//2, 익명
		Arrays.sort(arr, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		System.out.println("Descending Sort : " + Arrays.toString(arr));

		//3, 람다표현식
		Arrays.sort(arr, (o1, o2) -> {
			return o2 - o1;	
		});
		System.out.println("Descending Sort : " + Arrays.toString(arr));
	}

}
