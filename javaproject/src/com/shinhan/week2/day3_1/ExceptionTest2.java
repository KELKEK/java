package com.shinhan.week2.day3_1;


public class ExceptionTest2 {
	
	public static void main (String[] args) {
		try {
			method1(60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//예외를 다른 곳으로 던졌을 경우와 달리 내가 직접 처리하면 그 다음 메인의 내용으로 넘어가서 정상적으로 ************도 출력된다.
		System.out.println("***********************");
	}

	private static void method1(int score) throws Exception {//이 throw는 던지다 //그리고 method1 함수에서 던져서 main에서 받는 것이라고 설명하심
		// TODO Auto-generated method stub
		//조건에 맞지 않으면 강제로 예외를 발생시키고자 한다.(raise) <- 예외를 일으키다라는 의미로 java에선 throw를 씀
		//if(score <= 70) throw new RuntimeException();
		/*
		try {
			if(score <= 70) throw new Exception("오류!!!!");//컴파일 중에 한다.

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		if(score <= 70) throw new Exception("오류!!!!");//이 throw는 발생하다 <- 둘이 다름 //new를 통해 예외를 강제로 생성한다.
		System.out.println("---------------------------------");
	}

}
