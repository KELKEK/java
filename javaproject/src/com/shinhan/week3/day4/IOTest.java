package com.shinhan.week3.day4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOTest {

	public static void main(String[] args) throws IOException {
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		//f7();
	}

	private static void f7() throws IOException {//f3내용 복사해옴
		// 파일입력(읽기), 한글 안깨지게 Reader로 읽기
				String filename = "./src/com/shinhan/week3/day4/Review2.java";
				FileReader fis;
				BufferedReader br;

				String i;
				fis = new FileReader(filename);// 파일열기....2Byte씩 처리한다.
				br = new BufferedReader(fis);//한 개의 라인씩 읽음
				while ((i = br.readLine()) != null) {
					System.out.println(i);// println은 한바이트씩마다 띄워쓰므로 print로 바꿔줌
				}

				fis.close();
	}

	private static void f6() throws IOException {//실기문제 출제(봐두기)
		String fileName = "aa.txt";
		FileOutputStream fos = new FileOutputStream(fileName);
		//보조스트림
		DataOutputStream dos = new DataOutputStream(fos);
		fos.write(10);
		dos.write(20);
		dos.writeDouble(10.5);
		dos.writeDouble(20.5);
		dos.writeUTF("문자");
		fos.flush();
		fos.close();
		
		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		int a = dis.read();
		int b = dis.read();
		double c = dis.readDouble();
		double d = dis.readDouble();
		String s = dis.readUTF();
		System.out.println(a+b+c+d);
		System.out.println(s);
		fis.close();
	}

	private static void f5() throws IOException {
		// 파일에 출력 FileWriter : 2바이트씩 처리
		String fileName = "aa2.txt";
		FileWriter fw = new FileWriter(fileName);
		
		fw.write("java\n");
		fw.write("자바끝");
		fw.close();//자원을 반납하지 않으면 다른 곳에서 이 파일을 사용할 수 없다.(실행해도 결과가 뜨지 않는 문제 발생)
		
	}

	private static void f4() {
		//모니터 출력
		PrintStream moniter = System.out;
		moniter.println("모니터 출력");
	}

	private static void f3() throws IOException {
		// 파일입력(읽기), 한글 안깨지게 Reader로 읽기
		String filename = "./src/com/shinhan/week3/day4/Review2.java";
		FileReader fis;

		int i;
		fis = new FileReader(filename);// 파일열기

		while ((i = fis.read()) != -1) {
			System.out.print((char) i);// println은 한바이트씩마다 띄워쓰므로 print로 바꿔줌
		}

		fis.close();
	}

	private static void f2() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/week3/day4/Review2.java";
		FileInputStream fis;

		int i;
		fis = new FileInputStream(filename);// 파일열기

		while ((i = fis.read()) != -1) {
			System.out.print((char) i);// println은 한바이트씩마다 띄워쓰므로 print로 바꿔줌
		}

		fis.close();
	}

	private static void f1() throws IOException {
		// 키보드 입력을 받아라
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);// 보조, 2바이트씩 출력
		int i;
		while ((i = isr.read()) != 13) {// 스트림의 끝 = -1, enter할 때 끝내기 : enter의 아스키 값이 13
			System.out.println((char) i);
			// 1byte읽음, abc입력 -> a의 아스키코드값 97이 출력((char)i하면 a 출력
		}
	}

}
