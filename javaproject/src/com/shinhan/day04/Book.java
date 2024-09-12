package com.shinhan.day04;


//class : object를 만들기 위한 틀(template)(붕어빵 틀 같은 개념), 설계도
//클래스 이름은 무조건 대문자로 시작한다.(팀플을 위해서라도..)
public class Book {
	//1, field(변수, data 저장 목적, 특징을 가짐)
	//private String title //정보 은닉
	String title;
	int price;
	//2, constructor(함수, 기능) : argument가 없는 기본생성자는 컴파일 시에 만들어진다.
	//생성자 추가 가능
	//class 이름과 같아야 한다.
	//return 불가능(void 등등을 쓰면 함수가 되어버리므로 쓰면 안된다.)
	//생성자 추가가능..추가하면 컴파일 시에 생성자를 만들지 않는다.
	//argument구조가 같아야 제대로 생성할 수 있다
	//Overloading(이름은 같고 매개변수 사양이 다르다.) <- 밑의 예시가 오버로딩 된 사례
	//this : 현재 객체
	//같은 이름의 다른 모양의 생성자를 호출하기 : this()
	//ㄴ난잡하지 않고 한 곳에 코드를 수정할 수 있게 하기 위헤 씀
	//ㄴ모인 곳의 생성자를 거치게 됨.
	Book(){
		//함수와 비슷하게 생겨서 생성자메서드라고 하기도 한다.
		this(null, 0);
	}
	Book(String title, int price){
		//System.out.println("2개 매개변수"); //모두 여기로 오게 됨
		this.title = title;
		this.price = price;
		//충돌되지 않으면 this.title을 안 써도 괜찮다.
		//ㄴ이 때는 'this.'이 자동으로 생략
		//ㄴ따라서 매개변수 이름과 field 이름이 서로 충돌하지 않도록 하기 위해 사용된다.
		//ㄴ그냥 일반적으로 title, price를 넣을 시는 가장 가까운 매개변수로 따른다.
	}
	Book(String title)
	{
		this(title, 50000);
	}
	Book(int price)
	{
		this("미정", price);
	}
	
	//3, method : 반드시 return type을 정의해야 한다! return값이 없다면 void
	void bookInfoPrint(){
		System.out.println("=======책의 정보=======");
		System.out.println("제목 : " + title);
		System.out.println("가격 : " + price);
	}
	
	//함수는 return이 있어야 한다.
	//4, block
	//이쪽은 굳이 활용도가 없다.
	{
		System.out.println("block...object생성 시마다 수행");
	}
	
	static {
		System.out.println("class load시에 1회 수행");
	}
	

	//5, inner class
	//클래스는 안에서 만들 땐 쓰임새가 달라진다.
	class AA{
		
	}
}
