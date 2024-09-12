package com.shinhan.day01;

public class p67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1 = 15;
		int v2; // 지역변수 선언하고 초기화하지 않음, 어떤 상황에서든 초기화를 할 수 있어야 컴파일에러 없이 정상적으로 실행 가능
		if(v1 > 10)
		{
			v2 = v1 - 10; //else문이 없으면 조건문에 안 맞을 시 초기화가 안될 수 있으므로 실행불가
		}
		else
		{
			v2 = 10;
		}
		int v3 = v1 + v2 + 5;
		
		System.out.println(v3);//System.out : 표준출력(모니터), PrintStream(Stream은 데이터의 흐름을 의미)
		//Print()
		//Println()
		//Printf()
	}

}
