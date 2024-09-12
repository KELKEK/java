package com.shinhan.day01;

//import java.io.InputStream;
import java.util.Scanner;

public class 표준입력 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		f4();
		
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true)//무한루프
		{
			System.out.print("계속?");
			String work = sc.nextLine();
			if(work.equals("q")) break; //무한루프를 빠지게 할 수 있는 조건
			System.out.print("입력1 >> ");
			int a1 = Integer.parseInt(sc.nextLine());
			System.out.print("입력2 >> ");
			int a2 = Integer.parseInt(sc.nextLine());
			System.out.printf("결과는 %d\n", a1 + a2);
		}
		System.out.println("==============end===================");
		
		sc.close();
	}

	private static void f3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력 >> ");
		String name = sc.nextLine();
		System.out.print("나이를 입력 >> ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("자기소개 >> ");
		String intro = sc.nextLine();
		System.out.printf("당신의 이름은 %s\n", name);
		System.out.printf("당신의 나이는 %d\n", age);
		System.out.printf("자기소개.....%s\n", intro);
		sc.close();
	}

	private static void f2() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("이름과 나이를 입력 >> ");
		String name = sc.next();
		int age = sc.nextInt();
		sc.nextLine();//엔터 하나 버리기용
		System.out.print("자기소개 >> ");
		String intro = sc.nextLine();
		System.out.printf("당신의 이름은 %s\n", name);
		System.out.printf("당신의 나이는 %d\n", age);
		System.out.printf("자기소개.....%s\n", intro);
		
		sc.close();
	}

	private static void f1() {
		// 표준입력(키보드) : System.in
		//InputStream a = System.in; // 실제로 사용할 떄는 불편 왜냐하면 한 byte씩 돌면서 input되기 때문이다.
		//표준출력(모니터) : System.out
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력 >> ");
		String name = sc.next();
		System.out.print("나이를 입력 >> ");
		int age = sc.nextInt();
		sc.nextLine(); //이 구문이 1줄을 먹어버리므로 앞에 하나 넣어줘야 한다., 따라서 단어 숫자랑 같이 쓰는 것은 좋은 선태이 아니다.
		System.out.print("자기소개 >> ");
		String intro = sc.nextLine(); //1라인
		System.out.printf("당신의 이름은 %s\n", name);
		System.out.printf("당신의 나이는 %d\n", age);
		System.out.printf("자기소개.....%s\n", intro);
		sc.close();//스캐너를 다 썼으면 닫음.
		
	}

}
