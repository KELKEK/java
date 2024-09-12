package com.shinhan.week3.day1;

public class GenericTest {
/*
	public static void main(String[] args) {
		Product<Double, Integer> p1 = makeProduct2(3.14, 100);
		

	}


	// 들어오는 타입에 제한을 걸고 싶을 때, 꼭 넘버를 상속받고자 하는 경우, <- (Integer,Double)가능
	// 제한된 타입파라미터
	private static <A extends Number, B extends Number> Product<A, B> makeProduct2(A a, B b) {
		double d1 = a.doubleValue();
		double d2 = b.doubleValue();
		
		boolean result = compare(d1, d2);
		System.out.println(result);
		
		return result;
	}
*/
	
	public static void main4(String[] args) {
		Product<String, Integer> p1 = makeProduct("A", 100);
		Product<Integer, String> p2 = makeProduct(200, "B");
		Product<String, String> p3 = makeProduct("C", "D");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

	private static <A, B> Product<A, B> makeProduct(A a, B b) {
		// TODO Auto-generated method stub
		Product<A, B> p = new Product<>(a, b);
		return p;
	}

	public static void main3(String[] args) {
		Box<String> result1 = makeBox("구체적타입 사용 시 결정");
		Box<Integer> result2 = makeBox(100);
		Box<Car> result3 = makeBox(new Car());

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

//가장 앞의 <T>는 제네릭입니다. 사용할 때 결정하겠습니다.의 의미로 return타입을 <T>로 static 뒤에 넣어준다. 이게 없으면 자바는 그냥 타입 T가 따로 있는건줄 알고 못찾아서 에러를 내놓음
	private static <T> Box<T> makeBox(T str) {// 처음부터 String을 넣어줫으므로
		// TODO Auto-generated method stub
		Box<T> box = new Box<T>(str);// 두 번째의 String은 생략 가능하다. 계속 복기하기

		return box;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 f1();
		// f2();
		// f3();
		// 574p
		// f4();
		// f5();
		//f6();
		Box<String> ss = boxing("word");
		Box<Integer> i = boxing(100);
		Box<Tv> t = boxing(new Tv());
		Box<Product<String, Integer>> p = boxing(new Product<>("키", 500));
		Box<ChildProduct<String, Integer, String>> cp = boxing(new ChildProduct<>("키키", 400, "dd"));

		System.out.println(ss.getContent());
		System.out.println(i.getContent());
		System.out.println(t.getContent());
		System.out.println(p.getContent());
		System.out.println(cp.getContent());
	}

	// <P> : P가 제네릭이다. 구체적인 타입이 아니다.
	// Box<P> : return타입, 제네릭타입인 Box를 return한다.
	private static <T> Box<T> boxing(T t) {// boxing의 매개변수를 가변으로 하고 싶을 때, return넣고 싶어 void->Box<T>로 바꿈
		Box<T> box = new Box<>(t);
		// box.setContent(t);
		return box;
	}

	private static void f6() {
		// TODO Auto-generated method stub
		ChildProduct<Integer, String, Integer> p1 = new ChildProduct<>(10, "model", 20);
		System.out.println(p1);

	}

	private static void f5() {
		// TODO Auto-generated method stub
		CoffeeAgency coffeeAg = new CoffeeAgency();
		CoffeeMachine machine = coffeeAg.rent();
		machine.method();
		coffeeAg.method1(machine);
	}

	private static void f4() {
		// TODO Auto-generated method stub
		HomeAgency homeAg = new HomeAgency();
		Home home = homeAg.rent();// Home이 리턴
		home.turnOnLight();

		CarAgency carAg = new CarAgency();
		Car car = carAg.rent();
		car.run();
	}

	private static void f3() {
		// TODO Auto-generated method stub
		Product<String, Integer> p1 = new Product<String, Integer>();
		p1.setKind("ABC");
		p1.setModel(200);//어쨌든 초기화는 제대로 해줘야 한다.
		Product<String, Integer> p2 = new Product<>("컴퓨터", 100);

		System.out.println(p1);
		System.out.println(p2);

		Product<CoffeeMachine, String> p3 = new Product<>(new CoffeeMachine(), "DDD");
		System.out.println(p3);
	}

	private static void f2() {
		// TODO Auto-generated method stub
		// 제네릭 사용 목적 comppile 시에 타입을 제한하는 목적(잘못된 타입 입력 불가, 얻을 떄 형변환 불필요)

		Box<Integer> box1 = new Box<>();// 뒤의 Integer는 생략 가능
		box1.setContent(100);
		// box1.setContent("100"); <- 이건 불가
		int a = box1.getContent();// unboxing
		System.out.println(a);
		Box<CoffeeMachine> coffee = new Box<>(new CoffeeMachine());// 뒤의 Integer는 생략 가능
		coffee.setContent(null);
		// box1.setContent("100"); <- 이건 불가
		System.out.println(coffee.getContent());
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Box box1 = new Box();
		box1.setContent(100);// 숫자
		box1.setContent("100");// 문자
		box1.setContent(new CoffeeMachine());// 객체

		CoffeeMachine obj = (CoffeeMachine) box1.getContent();

	}

}
