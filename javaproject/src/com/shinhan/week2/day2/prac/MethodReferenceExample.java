package com.shinhan.week2.day2.prac;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Person person = new Person(8, 5);
		
		//정적메소드일 경우
		//람다식
		person.action((x, y) -> Computer.staticMethod(x, y));
		//메소드 참조
		person.action(Computer::staticMethod);
		
		//인스턴스 메소드일 경우(객체를 만들어야 함)
		Computer com = new Computer();
		//람다식
		person.action((x, y) ->{
			
			System.out.println("2, 람다표현식 구현");
			com.instanceMethod(x, y);
			return x + y;
			//여러 줄일 경우 무조건 return 추가하기
		});
		//메소드 참조
		person.action(com::instanceMethod);
	}

}


class Person{
	double su1, su2;
	Person(double su1, double su2){
		this.su1 = su1;
		this.su2 = su2;
	}
	Person(){
		this.su1 = 10;
		this.su2 = 6;
	}
	public void action(Calculable calculable) {
		double result = calculable.calc(su1,su2);
		System.out.println("결과 : " + result);
	}
}

//로직은 사용하는 쪽에서 결정한다. <- 람다식 쓰는 이유
@FunctionalInterface
interface Calculable{
	double calc(double x, double y);
}
