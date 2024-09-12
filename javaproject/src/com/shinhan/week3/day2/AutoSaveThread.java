package com.shinhan.week3.day2;

//데몬스레드 : 주스레드를 도와주는 스레드
//주스레드가 끝나면 같이 끝난다.
public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업내용을 저장한다.");
	}
	
	public void run() {
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
}
