package com.shinhan.week2.day3;

import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("file.txt")) {
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}//리소스 자동닫기를 이용함
	
	
	public static void f(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try {
			fw = new FileWriter("file.txt");
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
			}
		}

	}

}

class FileWriter implements AutoCloseable {
	public FileWriter(String filePath) throws IOException {//throws를 쓸 때 상위의 것을 하위에 던지면 안된다.
		System.out.println(filePath + " 파일을 엽니다.");
	}

	public void write(String data) throws IOException {//재정의(override) 시 예외로 던진것까지 동일해야 한다.
		System.out.println(data + "를 파일에 저장합니다.");
	}

	@Override
	public void close() throws IOException {
		System.out.println("파일을 닫습니다.");
	}
}
