package com.shinhan.week3.day2;

import com.shinhan.day04.Account;

//제네릭 : 구체적인 타입은 사용할 때 결정, 컴파일 시에 강한 타입체크, T같은 제네릭 대신 Object사용한다면 강제형변환이 필요해 불편하고 비효율적 <- 제네릭을 사용하는 편이 낫다.
class Box<T>{
	T content;//여러 타입의 변수가 올 수 있다.

	public Box(T content) {
		this.content = content;
	}
	
	public Box() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [content=").append(content).append("]");
		return builder.toString();
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
	
	
}

class BigBox<T, E> extends Box<T>{
	E size;

	public BigBox(T content, E size) {
		super(content);//컨텐츠(T타입)는 부모가 초기화
		this.size = size;
	}
	
}



public class Review {
	public static void main(String[] args) {
		//f1();
		//f2();
		f3();
	f5();
	}

	private static void f5() {
		//int[] arr = {1, 2, 3, 4 5};
		String[] arr = {"A", "B", "C"};
		Object[] arr2;
		arr2= arr;
		arr[2] = "10";
		
		//제네릭은 배열생성불가.
		//Box<Accoutn>~
	}

	private static void f3() {
		// TODO Auto-generated method stub
		//Box<String> box1 = call2("문자");
		Box<Double> box1 = call2(3.14);
		Box<Integer> box2 = call2(100);
		//Box<com.shinhan.week3.day1.thread.Account> box3 = call(new Account("112", "j", 100));
		System.out.println(box1);
		System.out.println(box2);
	}

	private static void f2() {
		// TODO Auto-generated method stub
		Box<String> box1 = call("문자");
		Box<Integer> box2 = call(100);
		//Box<com.shinhan.week3.day1.thread.Account> box3 = call(new Account("112", "j", 100));
		System.out.println(box1);
		System.out.println(box2);
	}

	private static<T extends Number> Box<T> call2(T t) {//static 뒤의 <T>가 없다면 자바는 이미 있는 T클래스를 찾아서 그쪽으로 인식한다. 우리는 제네릭을 쓰고 싶으므로 그렇게 하지 않는다.
		// T에 상속받은 애들위 범위를 모음, 반대는 T super Number <- 실습하니까 또 안되네..('?' 첨가)
		// T + extends + 객체
		return new Box<T>(t);//실제 값을 넣어서 리턴할 수 있도록 함
	}
	private static<T> Box<T> call(T t) {//static 뒤의 <T>가 없다면 자바는 이미 있는 T클래스를 찾아서 그쪽으로 인식한다. 우리는 제네릭을 쓰고 싶으므로 그렇게 하지 않는다.
		// TODO Auto-generated method stub
		return new Box<T>(t);//실제 값을 넣어서 리턴할 수 있도록 함
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Box<String> box1 = new Box<>();
		Box<String> box2 = new Box<String>();
		Box<Integer> box3 = new Box<>();
		//Box<Account> box4 = new Box<String, String, Integer>();
		
		Box<Integer> box5 = new Box<>();
		box5.setContent(200);
		
		box1.content = "String";
		box2.content = "String";
		box3.content = 100;
		Integer a = box3.content;
		//Account acc = box4.content;
		
	}
}
