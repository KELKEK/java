package com.shinhan.day04;

public class Car {
	// 1, field(어떤 특징을 갖는가, 변수, data저장, 멤버변수)
	private String company = "현대자동차";
	private String model;
	private String color;
	private int maxSpeed;

	// 2, constructor(생성자)...생성자는 여러가지 방법을 정의(Overloading)
	Car() {
		System.out.println("dafault생성자...arg없음");
	}

	Car(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed + 100;
	}

	// 자료형이 달라지기만 하면 순서를 바꾸어도 상관은 없다.
	Car(String model, int maxSpeed, String color) {
		/*
		 * this.model = model; this.color = color; this.maxSpeed = maxSpeed;
		 */
		// 이쪽은 유지보수 하기 좋지 않으므로 비추
		// super();//부모 생성된다.
		// System.out.println("----------------------");
		this(model, color, maxSpeed);
		// 2번쨰로 지정해놓은 생성자로 간다.
		// ㄴ생성자 호출(첫번쨰 줄에서만 가능), super()부분이 수행안됨.
	}

	Car(String color, int maxSpeed) {
		this(null, color, maxSpeed);
	}

	Car(String model) {
		this(model, null, 0);
	}

	String first; // 얘도 함수 밖에 있으므로 필드(멤버변수)
	// 이 친구는 멤버변수이므로 초기화가 자동으로 된다. 따라서 바로 사용도 가능

	// 3, 메서드(기능, 동작, 문장들의 묶음), return type이 반드시 필요
	// ㄴreturn 값이 없으면 void
	String carInfoPrint(String title) {
		String second = null; // 얘는 지역변수(따라서 값을 초기화해야 사용가능)
		System.out.println("============Car의 정보============");
		System.out.println(title);
		System.out.println("회사 : " + company);
		System.out.println("모델 : " + model);
		System.out.println("색깔 : " + color);
		System.out.println("최고속력 : " + maxSpeed);
		System.out.println("first : " + first);
		System.out.println("second : " + second);
		powerOn();
		return "프린트완료";
		// void 제외하면 제대로 return을 해줘야 한다.
		// ㄴ앞의 println들도 정상적으로 된다.
	}

	void powerOn() {
		System.out.println("====POWER ON====");
	}
	
	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}
	// 마우스 우클릭 + source + Generate getter/setter
	// ㄴ 자동 getter/setter 생성

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return model + "모델의 " + color + "최속 " + maxSpeed;
	}
	
	
	
}
