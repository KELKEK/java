package com.shinhan.week2.day4;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URL;

public class ObjectTest4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//f1();
		f2();
	}

	private static void f2() throws IOException {
		// TODO Auto-generated method stub
		//new FileReader("src/com.shinhan.week2.day4/ComputerVO.java");
	Class<?>cls = ObjectTest4.class;
	URL url = cls.getResource("인증코드.png");
	
	System.out.println(url.getPath());
	
	InputStream fis = cls.getResourceAsStream("인증코드.png");
	InputStreamReader jsr = new InputStreamReader(fis);
		int i;
		while((i = fis.read()) != -1) {
			System.out.print((char)i);
		}
	}

	private static void f1() {
		// TODO Auto-generated method stub
		//리플렉션
		Class<ComputerVO> cls = ComputerVO.class;
		
		Constructor<?>[] cons = cls.getDeclaredConstructors();
		//생성자들을 
		
		for(Constructor<?> cc : cons) {
			System.out.println(cc.getName());
			System.out.println(cc.getParameterCount());
			
			for(Parameter param : cc.getParameters()) {
				System.out.println(param.getName());
			}
			System.out.println("-----------------");
		}
	}

}
