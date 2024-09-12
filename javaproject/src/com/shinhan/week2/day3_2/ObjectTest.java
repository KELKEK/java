package com.shinhan.week2.day3_2;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		//f4();
		//f6();
		//f8();
	}

	private static void f8() {
		Book bb= new Book("A", 1, "a");
		int count = 0;
		//b.equals(null);
		//b.equals("dasda");//둘 다 안됨 <- 타입 주의!
		//HashSet : 순서가 없다, 중복이 안된다, Key로 사용된다.
		//제네릭스 : type를 제한한다.
		HashSet<Book> datas = new HashSet<Book>();//문자가 아닌 애들은 만들 수 없다.
		//datas.add(100);
		datas.add(new Book("A", 1000, "김"));
		datas.add(new Book("A", 2000, "김"));
		datas.add(new Book("A", 3000, "김"));
		datas.add(new Book("A", 4000, "김"));
		datas.add(new Book("B", 4000, "김"));
		
		
		
		for(Book b : datas) {
			if(b.equals(bb)) {
				count++;
				System.out.println(b);
			}
		}
		System.out.println(count);
		System.out.println(datas.size());//중복은 안되므로 겹치면 1개만 나옴

		//datas.add(new Book("자바다", 20000, "신"));
		
		/*//제네릭 배우기 전에 배우는 간단한 개념
		for(Object obj : datas) {
			if(obj instanceof Integer) {
				
			}else if(obj instanceof String) {
				
			}else if(obj instanceof Book) {
				
			}//별로 좋지 못한 코드
		}
		*/
	}

	private static void f6() {
		// TODO Auto-generated method stub
		//HashSet : 순서가 없다, 중복이 안된다, Key로 사용된다.
		//제네릭스 : type를 제한한다.
		HashSet<String> datas = new HashSet<String>();//문자가 아닌 애들은 만들 수 없다.
		//datas.add(100);
		datas.add("월");
		datas.add("화");
		datas.add("토");
		datas.add("일");
		System.out.println(datas.size());//중복은 안되므로 겹치면 1개만 나옴
				
		for(String s : datas) {
			System.out.println(s);
		}
		//datas.add(new Book("자바다", 20000, "신"));
		
		/*//제네릭 배우기 전에 배우는 간단한 개념
		for(Object obj : datas) {
			if(obj instanceof Integer) {
				
			}else if(obj instanceof String) {
				
			}else if(obj instanceof Book) {
				
			}//별로 좋지 못한 코드
		}
		*/
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Book obj1 = new Book("홍", 30000, "ㅇㅇㅇ");
		Book obj2 = new Book("홍", 30000, "ㅇㅇㅇ");
		System.out.println(obj1 == obj2);//주소비교
		System.out.println(obj1.equals(obj2));//Book클래스에서 재정의
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f3() {
		// TODO Auto-generated method stub
		Dice obj1 = new Dice(100);//그냥 숫자 쓰는게 더 낫다는 의미로 취소선 그은 것
		Dice obj2 = new Dice(100);
		System.out.println(obj1 == obj2);//주소비교
		System.out.println(obj1.equals(obj2));//Dice클래스에 따로 equals를 재정의 하지 않았으므로 부모의 성질을 따른다.
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f2() {
		// TODO Auto-generated method stub
		//Object 상속받아서 만든 Integer
		Integer obj1 = new Integer(100);//그냥 숫자 쓰는게 더 낫다는 의미로 취소선 그은 것
		Integer obj2 = new Integer(100);
		System.out.println(obj1 == obj2);//주소비교
		System.out.println(obj1.equals(obj2));//주소비교 //String은 equals를 값 비교하는 것으로 override함 
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		
	}

	private static void f1() {
		// TODO Auto-generated method stub
		//Object는 모든 Object의 부모class
		//Object 상속받아서 만든 String
		//Object obj1 = new Object();//Object는 기본생성자만 있음
		//Object obj2 = new Object();//Object는 기본생성자만 있음
		String obj1 = new String("자바");
		String obj2 = new String("자바");
		
		System.out.println(obj1 == obj2);//주소비교
		System.out.println(obj1.equals(obj2));//주소비교 //String은 equals를 주소비교하는 것으로 override함 
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

}
