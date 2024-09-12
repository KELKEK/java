package com.shinhan.day05;


//class : object를 만들기 위한 틀(template), 설계도
//object : class를 이용해서 만든 독립된 개체
//instance == object, new로 만든 실체
public class Car {
	//1, field(특징, data값 저장 목적, 변수)
	//static(class 변수, object들의 공통변수), 정적멤버
	//non-static(instance 변수, 멤버변수), new 시에 자동으로 초기화된다, 인스턴스 멤버
	static String company = "현대자동차";//private이 아니므로 값변경은 가능하지만 초기화할 때 굳이 값을 추가할 필요가 없어져서 좋다. class가 load시에 값이 할당된다.
	static int carCount;//기본값으로 0이 들어간다.
	private String model;
	private int price;
	int i;
	{
		i++;
	}//객체 생성 시마다 값이 늘어남
	//2, constructor [method]...컴파일시에 정의가 없으면 자동으로 default 생성자(argument 없음)가 만들어짐
	//객체 생성 시 자동으로 호출된다. new Car();
	//생성자는 생성 시 값 초기화가 목적이다.
	//오버로딩 : 이름같고 매개변수 사양이 다르다.
	//하나의 생성자가 같은 이름의 다른모양의 생성자를 호출 시 사용한다(this());
	Car(String model, int price){//(파라미터에 들어있는 지역변수) == 매개변수
		//함수이름 (변수타입 매개변수)
		this.model = model;//매개변수의 이름과 멤버변수의 이름충돌 발생. 이를 구분하기 위해 현재객체를 this라고 사용한다.
		this.price = price;
		carCount++;
		System.out.println(carCount + "번쨰 자동차가 만들어집니다.");
	}
	
	Car(String model){
		//this.model = model;
		//this.price = 1000;
		//carCount++;
		this(model, 1000); //유지보수를 용이하게 하기 위해 매개변수 2개짜리인 생성자와 합쳤다.
	}
	Car(int price){
		//this.model = "이름 미정";
		//this.price = price;
		//carCount++;
		this("모델명 미정", price);
	}
	//3, method(기능구현{}, 문장들의 묶음), "반드시" return값의 타입을 정의해야 한다. 값이 없으면 void
	void carInfoPrint(String title){
		System.out.println(title);
		System.out.println("company : " + company);
		System.out.println("carCount : " + carCount);
		System.out.println("model : " + model);
		System.out.println("price : " + price);
		//static이 올려와져 있어도 쓸 수 있다.
	}
	
	//Getter/Setter는 이름규칙을 지킨다. 자바기술에 JavaBeans기술에서 사용하기 때문
	String getModel() {
		return model;
	}
	int getPrice(){
		return price;
	}
	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {//static 변수는 getter/setter에 static이 들어간다.)
		Car.company = company;
	}

	public static int getCarCount() {
		return carCount;
	}

	public static void setCarCount(int carCount) {
		Car.carCount = carCount;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setModel(String model) {
		//모든 사람들이 접근해도 ㄱㅊ

		this.model = model;
	}
	static void carInfoPrint2(String title){
		System.out.println(title);
		System.out.println("company : " + company);
		System.out.println("carCount : " + carCount);
		//System.out.println("model : " + model);
		//System.out.println("price : " + price);
		//static method에서 non-static(instance변수) 사용 불가
	}
	//4, block
	{
		System.out.println("-----------instance block(객체 생성할 떄마다 수행)---------------------");
	}
	
	static {
		System.out.println("-----------class load 시에 1회 수행---------------------");
		//class load 시 static변수 로직이 필요한 초기화할 때 사용된다.
	}
	
	//5, inner class
	class Tier{
		//1, field
		String color;
		//2, constructor
		//3, method
		//4, block
		//5, inner class
	}
	
}
