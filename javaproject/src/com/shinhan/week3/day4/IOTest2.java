package com.shinhan.week3.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.week3.day3.Product;
import com.shinhan.week3.day3.Student;

public class IOTest2 {
	static String path = "src/com/shinhan/week3/day4/";

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//f1();//lab2
		//f2();//lab3
		//f3();//lab4
		//f4();
		f5();
	}

	private static void f5() {
		File f = new File(path+"Review.java");
		System.out.println(f.exists());//파일이 존재하는지 체크
		System.out.println(f.length());//파일의 크기를 체크
		System.out.println(f.getAbsolutePath());//파일의 절대경로
		System.out.println(f.isDirectory());//디렉터리인가
	}

	private static void f4() throws IOException, ClassNotFoundException {
		//객체 저장을 파일로 하고 싶을 때
		Student st1 = new Student("홍길동1", 100, "남자");
		Student st2 = new Student("홍길동2", 100, "남자");
		Product p = new Product(1, "TV", "S", 1000);
		FileOutputStream fos = new FileOutputStream(path+"data.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.writeObject(p);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(path+"data.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student st3 = (Student)ois.readObject(); 
		Student st4 = (Student)ois.readObject();
		Product p2 = (Product)ois.readObject();
		System.out.println(st3);
		System.out.println(st4);// 해당 클래스에서 Serializable인터페이스를 받아줘야 한다.
		System.out.println(p2);// 해당 클래스에서 Serializable인터페이스를 받아줘야 한다.
		ois.close();
		fis.close();
		
	}

	private static void f3() {
		try {
			new IOTest2().reverseLine(path+"data4.txt",path+"data5.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void reverseLine(String inputFileName, String outputFileName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
		List<String> datas = new ArrayList<String>();
		String s = null;
		while((s = br.readLine()) != null) {
			datas.add(s);
		}//데이터 읽기
		
		for(int i = datas.size()-1; i >= 0; i--) {
			bw.write(datas.get(i));
			bw.newLine();//다음라인으로 이동
		}
		
		br.close();
		bw.close();
	}

	private static void f2() {
		String path = "src/com/shinhan/week3/day4/";
		new IOTest2().printScore(path+"data3.txt");
		
		
	}
	public void printScore(String fileName) {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			line = br.readLine();
			System.out.println(line.replaceAll("/", "\t") + "\t총점");
			while((line = br.readLine())!=null) {
				String[] arr = line.split("/");
				int total = 0;
				for(int i = 1; i < arr.length; i++) {
					total += Integer.parseInt(arr[i]);
				}
				
				System.out.println(line.replaceAll("/", "\t") + "\t" + total);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private static void f1() {
		String path = "src/com/shinhan/week3/day4/";
		try {
			ArrayList<String> datas = new IOTest2().compareFile(path+"data1.txt", path+"data2.txt");
			datas.stream().forEach(data->System.out.println(data));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	ArrayList<String> compareFile(String fstFileName, String scdFileName) throws Exception{
		ArrayList<String> result = new ArrayList<String>();
		//FileReader fr1 = new FileReader(fstFileName);
		FileReader fr2 = new FileReader(scdFileName);
		BufferedReader br1 = new BufferedReader(new FileReader(fstFileName));
		BufferedReader br2 = new BufferedReader(new FileReader(scdFileName));
		LineNumberReader lineReader = new LineNumberReader(br2);
		
		String s1, s2;
		while((s1 = br1.readLine()) != null) {
			s2 = br2.readLine();
			if(!(s1.equals(s2)))
				result.add("Line " + lineReader.getLineNumber() + " : " + s2 + lineReader.getLineNumber());
		}
		
		br1.close();//가까운것부터 닫아야 한다.
		br2.close();
		return result;
	}

}
