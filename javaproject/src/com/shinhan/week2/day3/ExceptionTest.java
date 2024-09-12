package com.shinhan.week2.day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {
	

	public static void main(String[] args)  {// <- 이 경우는 던진거
		//method1(10);
		//method2();
		//try {//이 경우는 메인에서 직접 에러처리
		//	method3();
		//} catch (Exception e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//method4();
		//method5();
		//method6();
		try {
			method7();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------main end-------------------");
	}

	private static void method7() throws IOException, ClassNotFoundException, FileNotFoundException{//여러 예외처리에 던질 수 있다.
		// TODO Auto-generated method stub
		Class.forName("com.shinhan.week2.day3_1");
		FileReader f2 = new FileReader("src/com/shinhan/week2/day3/Book.java");
		int i;
		while((i = f2.read()) != -1){
			System.out.print((char)i);
		}
		f2.close();
			
	}

	private static void method6() {
		// TODO Auto-generated method stub
		try(FileReader f2 = new FileReader("src/com/shinhan/week2/day3/Book.javㄴㄴㄴa"))
		{
			int i;
			while((i = f2.read()) != -1){
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("넌나가라");
			//e.printStackTrace();
		} catch(IOException e) {
			System.out.println("ㄴㄴ");
		}

	}

	private static void method5() {
		// TODO Auto-generated method stub
		//FileInputStream f1 = null; 1바이트씩 읽음
		FileReader f2 = null;//2바이트씩 읽음
		int i;
		try {
			f2 = new FileReader("src/com/shinhan/week2/day3/Book.javaaaaa");
			while((i = f2.read()) != -1) { System.out.print((char)i);} //파일의 끝이 아닌 동안 계속 1파이트씩 읽음 //1013...returnEnter의 ASCII code값
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음" + e.getMessage());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(f2 != null) f2.close(); //다 쓰면 안전하게 닫아야 한다.
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*catch (NullPointerException e){
				 * system.out.println("파일open, close불가")
				 * } 만일 앞에 try문의 조건문이 없다면 null에 대한 예외처리를 해줘야함
				 */
		}
	}

	private static void method4() {
		// TODO Auto-generated method stub
		//하나의 메서드에서 혹은 class에서 같은 이름의 class를 이용하는 경우
		//같은 패키지를 먼저 검색한다.
		//다른 패키지의 class는 반드시 패키지 이름까지 사용한다.
		com.shinhan.week2.day3_1.Book a = new com.shinhan.week2.day3_1.Book();
		Book b = new Book();
		
		System.out.println(a);
		System.out.println(b);
		try {
			Class mybook = Class.forName("com.shinhan.week2.day3_1.Book");
			System.out.println(mybook.getName());
			System.out.println(mybook.getPackageName());
			System.out.println(mybook.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//이 구문을 쓰려면 예외처리가 제대로 되어야 한다.
		System.out.println("***************************8");
	}

	private static void method3() throws IOException{//예외처리를 해서 main의 method3에 받으면 그걸 다른곳으로 넘기거나 내가 받거나 해야함
		// TODO Auto-generated method stub
		// 나를 부른 곳으로 떠넘기기(2번을 한 것)
		InputStream input =  System.in;//입력을 받는것
		int data = input.read();
		System.out.println((char)data);

	}

	private static void method2() {
		// TODO Auto-generated method stub
		//일반 Exception : 컴파일 시에 check
		// 반드시 Exception 처리를 줘얗나.
		//1)내게 한다. 2) 떠넘긴다.
		InputStream input =  System.in;//입력을 받는걸
		try {
		int data = input.read();
		System.out.println((char)data);
		}catch(Exception e) {
			System.out.println("IO오류");
		}
	}

	private static void method1(int count) {
		// TODO Auto-generated method stub
		
		//오류발생 사동으로 JVM Exception 객체를 생성해서 Exception 발생한 곳으로 준다.
		//예외1)RuntimeExcetion...실행시 오류 발생 2)일반Exception
		
		int score = 100;
		int[] arr = new int[10];
		String s = "백";
		
		//if(count == 0) 	return; <- 비지니스로직
		//오류처리로직과 비지니스로직 처리가 섞인다. 권장하지 않음
		//try~catch : 오류처리로직과 비지니스 처리 로직을 분리할 수 있다.
		try {
			System.out.println("평균은 " + score/count);
			arr[10] = 99;//배열을 생성도 안했는데 값을 할당한 꼴
			System.out.println(arr[10]);
			System.out.println(Integer.parseInt(s)+200);//s가 숫자로 적혀있는 문자의 경우 숫자가 됨. 문자는..
		}catch(ArithmeticException ex){//상위 예외인 Exception ex라고 써도 된다.
			//Exception처리함..그러므로 프로그램 중단없이 계속 진행됨
			System.out.println("나눌 수 없습니다." + ex.getMessage());
		}catch(NullPointerException ex){//상위 예외인 Exception ex라고 써도 된다.
			//Exception처리함..그러므로 프로그램 중단없이 계속 진행됨
			System.out.println("범위에 없습니다." + ex.getMessage());
		}catch(ArrayIndexOutOfBoundsException ex){//상위 예외인 Exception ex라고 써도 된다.
			//Exception처리함..그러므로 프로그램 중단없이 계속 진행됨
			System.out.println("범위를 넘었습니다." + ex.getMessage());
		}catch(NumberFormatException ex){//상위 예외인 Exception ex라고 써도 된다.
			//Exception처리함..그러므로 프로그램 중단없이 계속 진행됨
			System.out.println("숫자가 이상해요" + ex.getMessage());
		}catch(Exception ex){//상위 예외인 Exception ex라고 써도 된다.
			//Exception처리함..그러므로 프로그램 중단없이 계속 진행됨
			System.out.println("이상해요");
		}
		finally {
			System.out.println("오류가 있거나 없거나 무조건 수행하는 업무이다.(Finally)");
		}
		System.out.println("------------------------------------------");
	}
}
