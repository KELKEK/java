package com.shinhan.day04;

public class NoteBook {
	
	//1, field : object마다 다른 객체와 구별되는 값을 저장하기 위함
	//field : non-static(instance 변수) -> 반드시 생성 후 사용가능 
	//		  static(class변수, 공유 변수, C언의의 share변수와 같다.) -> 객체 생성과 무관하다.
	private String model;
	private int price;
	
	//int count;
	//여기에 count변수를 만들어도 공유변수가 아니기 때문에 몇 개의 객체를 만들든 결과가 1
	//공유변수로 설정할 경우 객체의 갯수가 계속 증가되어 제대로 결과를 추출할 수 있다.
	static int count;
	
	//2, constructor : 값초기화
	public NoteBook(String model, int price) {
		this.model = model;
		this.price = price;
		count++;
	}
	
	//3. getter/setter
	//setter : 값 변경할 때 쓰임
	//getter : 값 리턴할 때 쓰임
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "으헤";
	}
	
	
	

}
