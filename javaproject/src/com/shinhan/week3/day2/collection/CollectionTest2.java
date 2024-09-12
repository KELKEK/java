package com.shinhan.week3.day2.collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest2 {

	public static void main(String[] args) {
		// Map(키값이 중복이 되면 안됨) hashcode(), equals() 
		// HashMap, TreeMap(순서있음, Comparable 구현
		// HashTable(동기화 가능)
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		f7();
	}

	//변경불가
	private static void f7() {
		String[] arr = {"자바", "디비", "웹", "프레임워크"};
		List<String> alist = Arrays.asList(arr);
		List<String> alist2 = List.of("자바", "디비", "웹", "프레임워크", "자바");	
		Set<String> aset = Set.of("자바", "디비", "웹", "프레임워크"); //중복data는 불가
		Map<Integer, String> map = Map.of(1, "자바", 2, "디비", 3, "웹", 4, "프레임워크", 5, "자바");	
		//alist.add("aaaa"); 변경, 추가, 삭제 불가
		//alist2.add("aaaa"); 위와 마찬가지로 불가
		//for(String data : alist2) {
		//	System.out.println(data);
		//}
		
		for(Integer key : map.keySet()) {
			System.out.println(key + " == " + map.get(key));
		}
		
		
		List<String> alist3 = new ArrayList<String>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String> alist4 = List.copyOf(alist3);
		//alist4.add("aaa"); <- copyof로 만들어진 객체는 수정 불가하다.
		
	}

	private static void f6() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		queue.offer(200);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());//FIFO(큐)
		}
	}

	private static void f5() {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		stack.push(300);
		stack.push(200);
		stack.push(400);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());//LIFO(스택)
		}
	}

	private static void f4() {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("apple", 10);
		treeMap.put("apple2", 20);
		treeMap.put("apple3", 40);
		treeMap.put("apple4", 30);
		treeMap.put("apple5", 50);
		
		
		//print(treeMap, "original");//기본은 asc정렬
		print2(treeMap.descendingMap(), "original");
		print3(treeMap, "찾기");
	}
	
	private static void print3(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title);
		System.out.println(treeMap.firstKey());//키가 나옴
		System.out.println(treeMap.pollFirstEntry());//키랑 벨류값이 나옴, print3의 출력결과는 같아보이는데 알고보면 처음것은 다른 원리로 작동한다.
		for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void print2(NavigableMap<String, Integer> treeMap, String string) {
		for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void print(TreeMap<String, Integer> treeMap, String title) {
		for(String key : treeMap.keySet()) {
			System.out.println(key + "==>" + treeMap.get(key));
		}
	}

	private static void f3() {
		// TODO Auto-generated method stub
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		print(scores, "Ascending");
		print(scores.descendingSet(), "Descending");
		
		print(scores.tailSet(80, true), "tailSet"); // x >= 80, true는 80도 포함의 이상, 이하의미
		print(scores.subSet(80, true, 90, false), "subSet"); // 90 > x >= 80, true는 80도 포함의 이상, 이하의미
		//print2(scores);
		//System.out.println("-------내림차순");
		//NavigableSet<Integer> descScoreSet = scores.descendingSet();
		//for(Integer data : descScoreSet) {
		//	System.out.println(data);
		//}
	}

	private static void print2(TreeSet<Integer> scores) {
		System.out.println("가장 낮은 점수 : " + scores.first());
		System.out.println("가장 높은 점수 : " + scores.last());
		System.out.println("95보다 높은 점수 : " + scores.higher(95));
		System.out.println("95보다 낮은 점수 : " + scores.lower(95));
		System.out.println("95보다 낮은 점수 : " + scores.floor(95));
		System.out.println("95보다 높은 점수 : " + scores.ceiling(95));
		
	}

	private static void print(Set<Integer> scores, String title) {
		System.out.println(title + " Sort-----------------");
		for(Integer s : scores) {
			System.out.println(s + " ");
		}
		System.out.println();
	}

	private static void f2() {
		Properties pro = new Properties();
		
		try {
			pro.load(CollectionTest2.class.getResourceAsStream("oracleDB.properties"));
			
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String myname = pro.getProperty("myname");
			String myname2 = pro.getProperty("myname2", "AAA");//디폴트값으로 AAA를 줌
			
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.err.println(myname2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f1() {
		// TODO Auto-generated method stub
		// map(키, 값 쌍) 키 중복 불가
		// 멀티스레드 환경에서 쓰는 맵
		Map<String, Integer> map = new Hashtable<>();
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 1; i <= 1000; i++) {
				//	System.out.println(getName() + "!!!!" + i);
					map.put(String.valueOf(i), i); // {"1" : 1, "2" : 2...}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 1001; i <= 2000; i++) {
				//	System.out.println(getName() + "@@@@" + i);
					map.put(String.valueOf(i), i); // {"1" : 1, "2" : 2...}
				}
			}
		};
		t1.start();
		t2.start();
		
		try {
			t1.join();//t1이 종료될 때 까지 기다림, 충돌없이 t1, t2 둘 다 들어가진다.
			t2.join();
		}catch(InterruptedException e){
		}
		
		int size = map.size(); 
		System.out.println("총 엔트리 수 : " + size);
	}
}
