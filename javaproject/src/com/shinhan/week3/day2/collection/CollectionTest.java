package com.shinhan.week3.day2.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;


import com.shinhan.week3.day1.thread.Account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@EqualsAndHashCode
@ToString
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
class Car implements Comparable<Car>{
	String model;
	int price;
	@Override
	public int compareTo(Car obj) {
		// 가격ASC순, 가격이 같으면 모델 내림차순, 본인이 알아서 정렬되는거 같음
		if(price - obj.price == 0) {
			return obj.model.compareTo(model);
		}
		return price - obj.price;
	}
}

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		//f7();
		//f8();
		f9();
	}

	private static void f9() {
		Map<Car, Integer> data = new TreeMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A2", 5000), 2);
		data.put(new Car("B", 4000), 3);
		data.put(new Car("B", 4000), 4);//!!!!!
		data.put(new Car("B2", 3000), 5);
		
		System.out.println(data.containsKey(new Car("B", 3000)));//해당 키가 존재하는가?
		System.out.println(data.containsValue(4));//해당 값이 존재하는가?
		
		for(Car key : data.keySet()) {//key의 중복체크 함, 객체가 중복해도 같은걸로 취급, 순서가 적용됨
			System.out.println(key + " ==> " + data.get(key));
		}
		
	}

	private static void f8() {
		Map<Car, Integer> data = new HashMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A2", 5000), 2);
		data.put(new Car("B", 1000), 3);
		data.put(new Car("B", 1000), 4);
		data.put(new Car("B2", 3000), 5);
		
		for(Car key : data.keySet()) {//key의 중복체크만 함, 객체가 중복해도 같은걸로 취급
			System.out.println(key + " ==> " + data.get(key));
		}
	}

	private static void f7() {
		//배열(연속공간, 가변 불가) <- 속도측면에서는 제일 빠르나 길이가 가변불가라 불편(가변이 필요없으면 이게 제일 좋긴 함)
		//Collection : List(순서있고 중복있음), Set(순서없고 중복없음), Map(키와 값의 쌍 entry) <- 상황에 따라 잘 고려하자.
		Set<Car> alist = new HashSet<Car>(20); // 20개를 기본으로 둠
		alist.add(new Car("A", 1000)); //뒤에 추가
		alist.add(new Car("B", 2000)); //뒤에 추가
		alist.add(new Car("C", 2000)); //뒤에 추가
		alist.add(new Car("A", 2000)); //뒤에 추가
		//alist.add(0, new Car("B", 2000)); //원하는 위치에 삽입(앞이 인덱스) <- 이럴 때는 LinkedList가 더 좋다., 순서가 없는 Set에는 적용 안되고 컴파일에러 뜬다.
		
		for(Car car : alist) {
			System.out.println(car);
		}
		
	}

	private static void f6() {
		// Map : key와 value의 쌍이다(map.Entry), key는 Set으로 만듦(중복불가)
		// 구현class : HashMap, HashTable, TreeMap, Properties
		Map<String, Integer> data = new HashMap<>();
		data.put("D", 99);
		data.put("B", 100);
		data.put("A", 77);
		data.put("B", 99);
		data.put("C", 88);//이미 존재하는 키가 있으면 덮어쓴다.
		System.out.println(data.size());
		System.out.println(data.get("A"));
		
		//1. 키의 이름을 모른다면(키들만 다 얻는 방법)
		System.out.println("===========1. keySet()================");
		for(String key : data.keySet()) {
			System.out.println(key + "==>" + data.get(key));//key는 순서가 없다.
		}
		
		//2. 
		System.out.println("===========1. EntrySet()================");//1건을 entry라 함
		Set<Map.Entry<String, Integer>> entrySet = data.entrySet();// <- 이렇게 쓰면 복잡하므로 밑에대로 함
		for(Map.Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());//key는 순서가 없다.
		}
		
		System.out.println("===========3. iterator============");
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void f5() {
		// TreeSet
		Set<Car> data = new TreeSet<>();
		data.add(new Car("A", 1000));
		data.add(new Car("A", 1000));
		data.add(new Car("C", 4000));
		data.add(new Car("B", 2000));
		data.add(new Car("C", 5000));
		data.add(new Car("D", 5000));
		System.out.println("개수 : " + data.size());
		
		System.out.println("===============일반For불가============");
//불가
		System.out.println("===============확장============");
		for(Car s : data) {
			System.out.println(s);
		}//순서가 없음
		System.out.println("==================반복자(Iterator)이용=============");
		Iterator<Car> it = data.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}//한글자음 순서대로 소트가 된다.
	}

	private static void f4() {
		// Set : 순서가 없고 중복불가 interface => 구현 class : HashSet, TreeSet(얘는 순서 있음)
		Set<String> data = new TreeSet<>();
		data.add("A");
		data.add("C");
		data.add("E");
		data.add("D");//add 안됨(중복check)
		data.add("D");//add 안됨(중복check)
		System.out.println("개수 : " + data.size());
		
		System.out.println("===============일반For불가============");
//불가
		System.out.println("===============확장============");
		for(String s : data) {
			System.out.println(s);
		}//순서가 없음
		System.out.println("==================반복자(Iterator)이용=============");
		Iterator<String> it = data.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}//한글자음 순서대로 소트가 된다.
		
	}

	private static void f3() {
		// Set : 순서가 없고 중복불가 interface => 구현 class : HashSet, TreeSet(얘는 순서 있음)
		Set<String> data = new HashSet<>();
		data.add("월");
		data.add("화");
		data.add("토");
		data.add("토");//add 안됨(중복check)
		data.add("월");//add 안됨(중복check)
		System.out.println("개수 : " + data.size());
		
		System.out.println("===============일반============");
//불가
		System.out.println("===============확장============");
		for(String s : data) {
			System.out.println(s);
		}//순서가 없음
		System.out.println("==================반복자(Iterator)이용=============");
		Iterator<String> it = data.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f2() {
		// List : 순서있고 중복가능 interface => 구현 class : ArrayList, LinkedList, Vector(동기화를 지원하여 멀티스레드상황에선 잘 쓰임)
		//ArrayList : 연속공간피요, 공간이 부족하면 자동증가, 중간 삽입, 삭제 시 비효율적(당기거나 밀거나 이동이 있음)
		//LinkedList : 연속공간불필요, 전요소나 후요소의 주소기억(공간차지), 중간삽입, 삭제 시 효율적)
		//Vector : Multi Thread에서 동기처리 가능
		//ArrayList
		List<String> data = new LinkedList<>();//ArrayList대신 Vector들어가도 됨
		List<String> data2 = new ArrayList<>();
		List<String> data3 = new Vector<>();
		data.add("문자1");
		data.add("문자2");
		data.add("문자3");
		
		insertData(data);
		insertData(data2);
		insertData(data3);

		
		String a = (String)data.get(0);
		String b = (String)data.get(1);
		String c = (String)data.get(2);
		//String 자료형만 올 수 있음
		
		displayData(data, "ArrayList");
		displayData(data2, "LinkedList");
		displayData(data3, "Vector");
	}
	
	private static void displayData(List<String> data, String title) {
		// TODO Auto-generated method stub
		System.out.println(title + "===============일반============");
		for(int i = 0 ; i < data.size() ; i++) {
			System.out.println(data.get(i));
		}
		System.out.println(title + "===============확장============");
		for(String s : data) {
			System.out.println(s);
		}
	}

	private static void insertData(List<String> data) {
		// TODO Auto-generated method stub
		data.add("월");
		data.add("토");
		data.add("화");
		data.add("토");
	}

	private static void f1() {
		// List : 순서있고 중복가능 interface => 구현 class : ArrayList, LinkedList, Vector
		//ArrayList
		ArrayList data = new ArrayList();
		data.add("문자");
		data.add(100);
		data.add(new Account());
		
		String a = (String)data.get(0);
		int b = (Integer)data.get(1);
		Account acc = (Account)data.get(2);//제네릭을 쓰지 않아 일일히 형변환해야 한다.
	}

}
