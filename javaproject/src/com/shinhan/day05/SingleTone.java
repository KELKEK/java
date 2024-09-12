package com.shinhan.day05;

//SingleTone : 객체가 1번만 생성된다.
public class SingleTone {
	
	private static SingleTone single;
	//1번만 객체를 생성하고자 할 때, 외부에서의 객체생성을 막는다.
	//new를 하지않으면 생성을 못하는데 생성자 접근권한이 private라서 static을 이용함.
	private SingleTone() {
		
	}
	
	public static SingleTone getInstance() {
		if(single == null) {
			single = new SingleTone();
		}//없으면 만들고 있으면 만들지 말아라
		return single;
	}
	//얘도 static 있어야 함(static엔 static이 있어야)
	//객체를 만들어서 리턴
}
