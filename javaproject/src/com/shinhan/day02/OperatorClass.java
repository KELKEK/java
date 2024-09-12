package com.shinhan.day02;

public class OperatorClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method01();
		//method02();
		//method03();
		//method04();
		//method05();
		//method06();
		method07();
		
	}

	private static void method07() {
		// TODO Auto-generated method stub
		int var1 = 100;
		int var2 = 100;
		//비교연산자가 논리연산자보다 우선순위가 높다.
		//&&(단축)는 앞이 거짓이면 뒤를 수행하지 않는다.
		//&는 앞의 결과와 무관하게 모두 수행 둘 다 같은 역할을 하는데 이러한 차이점을 갖고 있음
		//||는 앞의 결과가 참이면 뒤를 수행하지 않는다.
		//|는 앞의 결과와 무관하게 모두 수행
		boolean result1 = var1 > var2 && ++var1 > 100;
		System.out.println(result1);
		System.out.println(var1);
		boolean result2 = var1 >= var2 | ++var1 < 100;
		System.out.println(!result2);//결과의 앞에 !넣으면 결과의 반댓값이 출력
		System.out.println(var1);
	}

	private static void method06() {
		// TODO Auto-generated method stub
		int var1 = 100;
		int var2 = 100;
		String str1 = "자바"; // 컴파일 시점에 할당
		String str2 = "자바";
		String str3 = new String("자바"); // 실행 시에 new 되므로 항상 다르게 할당된다.
		String str4 = new String("자바");
		System.out.println(var1 == var2);//값의 결과는 boolean으로 나온다. 기본형은 값을 비교
		System.out.println(str1 == str2);//객체는 주소비교(true)
		System.out.println(str3 == str4);//객체는 주소비교(false). 따라서 값을 비교하려면 아래와 같은 '기능'을 써야 한다.
		System.out.println(str3.equals(str4));//내용 비교
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		
		str1 = str1 + "프로그램";
		str2 = str2 + "프로그램";//이 둘은 값이 변경된 것이 아니라 주소만 변경됨. 문자열은 값 변경 불가(append의 개념으로 됨) "자바프로그램"
		//둘 다 Stringbuffer를 새로 만들어서 "프로그램"을 append함(메모리가 엄청 낭비되어 좋은 습관은 아님), 그래도 java는 dangling 된 메모리들을 지워주어 관리가 편함.
	}

	private static void method05() {
		// TODO Auto-generated method stub
		int i = 100;
		int j = 0;
		if(j != 0) {
			System.out.println(i/j);
		}
		
		System.out.println(j != 0? 100/j : "");//삼항연산자, println이 있어서 아무것도 출력은 안했지만 줄은 띄워짐
		System.out.println(j == 0? "0으로 나눌 수 없음" : "나누기 가능");
		
		
		System.out.println(i/0.0);//Infinity(무한대)
		System.out.println(i%0.0);//NaN(Not a Number)
		//정수는 0으로 나누기 불가(Exception 발생, 프로그램 중단), 나누는 값이 0일 경우 수행을 못하게 코드를 짜거나 예외처리를 해주어야 함
		System.out.println("===================");
	}

	private static void method04() {
		// TODO Auto-generated method stub
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		double result = apple - pieceUnit * number; // 기대하는 값 0,3
		System.out.println(result);//값이 기대하는 값과는 다름 따라서 정수 연산은 정수끼리 계산하자
	}

	private static void method03() {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE;//2147483647
		int b = Integer.MIN_VALUE;//-2147483648
		a++;a++;a++;b--;b--;b--;
		System.out.println(a);
		System.out.println(b);
	}

	private static void method02() {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 3;
		System.out.println("더하기 : " + (a + b));//연산자 우선순위 때문에 문자열이 먼저 계산되므로 주의해야 한다.
		System.out.println("빼기 : " + (a - b));
		System.out.println("곱하기 : " + a * b);
		System.out.println("몫 : " + a / b);
		System.out.println("나머지 : " + a % b);
	}

	private static void method01() {
		// TODO Auto-generated method stub
		int var1 = 100;
		System.out.println(++var1);//전위 연산자 (연산 후 출력)
		System.out.println(var1++);//후위 연산자 (출력 후 연산)
		System.out.println(var1);
	}

}


// 105페이지 연산자 우선순위 잘 봐두기!!!!
