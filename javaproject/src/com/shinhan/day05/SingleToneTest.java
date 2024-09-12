package com.shinhan.day05;

public class SingleToneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTone a = SingleTone.getInstance();
		SingleTone b = SingleTone.getInstance();
		
		System.out.println(a == b);
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		//객체가 한 번만 생성됨, 외부에서 마음대로 객체를 생성할 수 없다.
	}

}
