package com.shinhan.week3.day4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

	private static void f1() {
		try {
			InetAddress a = InetAddress.getLocalHost();
			System.out.println(a.getHostName());
			System.out.println(a.getHostAddress());
			
			InetAddress[] arr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress addr : arr) {
				System.out.println(addr.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
