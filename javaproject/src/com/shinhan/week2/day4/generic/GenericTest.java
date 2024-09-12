package com.shinhan.week2.day4.generic;

import java.util.ArrayList;

public class GenericTest {
	
	public static void main(String[] args){
		ArrayList<String> alist = new ArrayList<>();
		alist.add("월");
		alist.add("화");
		alist.add("토");
		alist.add("토");
		alist.add("토일월화수");
		for(String s : alist) {
			//System.out.println(s);
			System.out.println(((String) s).length());//둘 다 가능한데 위가 더 짧
		}
	}

	public static void f1(String[] args) {
		// TODO Auto-generated method stub
		Box<String, Integer> box1 = new Box<> ("컴퓨터1", 100);
		//제네릭에서 <>안에는 객체형식으로 와야한다.(int 등 불가)
		System.out.println(box1);
		
		
		Box<Integer, String> box2 = new Box<> (123, "Large");
		System.out.println(box2);
	}
	

}
