package com.shinhan.week3.day3;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

//Collection
//list, set, map
//List : add 한 순서 있음(인덱스 가능, 중복 가능)
// -> ArrayList(중간 삽입,삭제 시에 비효율적(공간이 사라지고 나머지 인덱스가 앞으로 당겨짐), 추가는 효율적),
// -> LinkedList : 다음데이터와 이전데이터 주소 저장, 공간은 차지하지만 중간삽입,삭제가 효율적
// -> Vector : 동기화지원(멀티스레드 환경에 안정적)(물론 나머지도 synchronized이용하면 됨

//Set : 순서 없음, 중복 불가
// -> HashSet : hashcode(), equals()모두 갖고 있어야(중복체크)
// -> TreeSet : Add 시 Sort한다....compareTo가 필요
//Map : 키와 값의 쌍(entry), 키는 set이다. => HashMap, Hashtable, TreeMap, Properties

public class Review {

	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
		f5();
	}

	private static void f5() {
		//Map<Student, Product> map = new HashMap<>();
		//HashMap, HashTable 얘기 : 각 객체마다 정해진 해시가 있고 그 기준에 맞게 정렬 <- 사용자는 어떤 기준으로 정렬되는지 모르므로 사용자가 원하는대로 정렬하고 싶다면 따로 기준을 만들어야 한다.
		//Map<Student, Product> map = new TreeMap<>();
		Map<Student, Product> map = new Hashtable<>();
		map.put(new Student("A", 100), new Product(1, "노트북1", "삼성", 200));
		map.put(new Student("C", 300), new Product(4, "노트북4", "삼성", 200));
		map.put(new Student("D", 500), new Product(5, "노트북5", "삼성", 200));
		map.put(new Student("A", 100), new Product(2, "노트북2", "삼성", 200));
		map.put(new Student("B", 400), new Product(3, "노트북3", "삼성", 200));
		print(map, "key가 Student");
	}

	//메서드이름, 매개변수개수와 타입이 같으면 오버로딩이 다니다.
	private static void print(Map<Student, Product> map, String title) {
		System.out.println("==========" + title);
		for(Student key : map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}
		System.out.println("==================entryset");
		for(Entry<Student, Product> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 100);
		map.put("A", 200);//덮어쓰기됨
		map.put("B", 100);
		map.put("C", 100);
		map.put("D", 100);
		print(map.keySet());
		print(map);
	}

	private static void print(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		System.out.println("==================keyset");
		for(String key : map.keySet()) {
			System.out.println(key + "==>" + map.get(key));
		}
		System.out.println("==================entryset");
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void f3() {
		System.out.println("===============TreeSet");
		Set<Student> data = new TreeSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));
		data.add(new Student("B", 80));
		data.add(new Student("C", 70));
		data.add(new Student("B", 80));

		print(data);		
	}

	private static void f2() {
		Set<Student> data = new HashSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80));

		print(data);
	}

	private static void print(Set<Student> data) {
		System.out.println("======================Set<Student>");
		for(Student s : data) {
			System.out.println(s);
		}
	}

	private static void f1() {
		// List
		// List<String> data = new ArrayList<>();
		// List<String> data = new LinkedList<>();
		List<String> data = new Vector<>();
		// 사용법은 다 같다.

		data.add("월");
		data.add("월");
		data.add("토");
		data.add("토");
		print(data);
	}

	private static void print(Collection<String> data) {
		System.out.println("==============Collection<String>");
		for (String s : data) {
			System.out.println(s);
		}
	}

}
