package com.shinhan.week3.day2;

public class MovieThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("동영상을 재생합니다.");
			if (this.isInterrupted())
				break;					
		}
		System.out.println("자원정리");
		System.out.println("안전종료");
	}
}
