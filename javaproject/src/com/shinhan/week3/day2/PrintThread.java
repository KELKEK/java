package com.shinhan.week3.day2;

//조건문 이용하여 안전하게 쓰레드를 종료하기
public class PrintThread extends Thread {
	boolean stop; // default는 false

	void setStop(boolean stop) {
		this.stop = stop;
	}

	// 2, interrupt()메서드로 Exception 발생시켜 안전하게종료
	public void run() {
		try {
			while (true) {
				System.out.println("실행중.....");

				sleep(1);//일시정지상태....main에서 t1.interrupt() <- exception을 발생시킴
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");

	}

	// 1. 조건문 이용하여 안전하게 쓰레드 종료
	public void run2() {
		while (!stop) {
			System.out.println("실행중.....");
		}
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");

	}
}
