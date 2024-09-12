package com.shinhan.week3.day1.thread;

public class MultiThreadTest2 {
	
	
	public static void main(String[] args) {
		BathRoom room = new BathRoom();
		BathRoomThread t1 = new BathRoomThread(room, "김");
		BathRoomThread t2 = new BathRoomThread(room, "박");
		BathRoomThread t3 = new BathRoomThread(room, "양");
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	
	public static void ff(String[] args) {
		ShareArea sharearea = new ShareArea(
				new Account("112", "이몽룡", 2000),
				new Account("113", "성춘향", 1000)
				);
		Thread t1 = new TransferThread(sharearea);
		Thread t2 = new Thread(new PrintThread(sharearea));
		t1.start();
		t2.start();//계산하는 중간에 다른 스레드가 값을 계산할 수 있음(총합이 달라질 수 있다.)
		
	}

	public static void f1(String[] args) {
		System.out.println(Thread.currentThread().getName() + " : 시작");
		
		Thread t1 = new UppercaseThread2();
		Thread t2 = new Thread(new UppercaseThread());
		Thread t3 = new UppercaseThread2();

		t1.start();
		t2.start();
		t3.start();
		
		
		System.out.println(Thread.currentThread().getName() + " : 끝");
	}

}
