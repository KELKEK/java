package com.shinhan.week2.day2;

//다중인터페이스 구현
public class RemoteUsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		//f4();
		//f6();
		f7();
	}

	private static void f7() {
		// TODO Auto-generated method stub
		RemoteController a = new Television();
		RemoteController aa = new Audio();
		//사용방법은 값고 사용 결과가 다름 - "다형성"
		a.method1();
		aa.method1();
		
		//리모컨 인터페이스를 통해 티비와 오디오의 기능을 쓸 수 있게 규격화하였다.
		
	}

	private static void f6() {
		// TODO Auto-generated method stub
		//String과 Integer class는 Comparable interface가 구현되어있다.
		//compareTo
		//Comparable interface : 추상메서드 public abstract compareTo();
		//String class가 Comparable interface 구현....compateTo()재정의
		String s1 = "A";
		String s2 = "C";
		Integer i1 = 100;
		Integer i2 = 105;
		
		int result = s1.compareTo(s2);//차이를 리턴함
		System.out.println(result);
		
		result = i1.compareTo(i2); // -1, 0, 1(<, =, >)
		System.out.println(result);
	}

	private static void f4() {
		// TODO Auto-generated method stub
		SmartTelevision a = new SmartTelevision();
		RemoteController b = new SmartTelevision();
		Searchable c = new SmartTelevision();
		Object d = new SmartTelevision();
		
		f5(a);
		f5(b);
		f5(c);
		f5(d);
	}

	private static void f5(Object smart) {
		// TODO Auto-generated method stub
		((SmartTelevision)smart).search("http://youtube");
		
		if(smart instanceof SmartTelevision ss) {
			ss.search("http://youtube");
		}
	}

	private static void f3() {
		// TODO Auto-generated method stub
		action(new Television());
		action(new Audio());
	}

	private static void action(RemoteController remote) {
		// TODO Auto-generated method stub
		// 사용할 변수, 메서드는 타입을 따른다.
		// method는 재정의된 자식들의 메서드를 따른다.
		System.out.println(remote.CHANNEL);//상수접근
		remote.turnOff();
		remote.turnOn();
		
		//default
		remote.method3();
		
		//static
		RemoteController.method4();
	}

	private static void f2() {
		// TODO Auto-generated method stub
		Audio audio = new Audio();
		audio.method1();
		audio.method2();
		audio.method3();
		audio.turnOn();
		audio.turnOff();
		audio.show();
		RemoteController.method4();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Television t1 = new Television();
		t1.method1();
		t1.method2();
		t1.method3();
		t1.method4();
		RemoteController.method4();
		
		System.out.println(t1.CHANNEL);
		//위에 쓴 건 바람직한 방법은 아니다.
		System.out.println(RemoteController.CHANNEL2);
	}

}
