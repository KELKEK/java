package com.shinhan.week3.day2;

//Process : 실행중인 하나의 프로그램
//Thread 프로그램에서 하나의 흐름
//MultiThread : 실행중인 하나의 프로그램이 여러개
//1) Thread class상속
// 2) Runnable interface 구현

class MyThread1 extends Thread {

	MyThread1(String name) {
		super(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(currentThread().getName());
	}

}

class MyThread2 extends Object implements Runnable {
	String name;

	MyThread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " : " + name);
	}
	
}

public class Review2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		MyThread1 t1 = new MyThread1("신한");
		Thread t2 = new MyThread1("신한2");//자동형변환
		Thread t3 = new Thread("신한3") {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(currentThread().getName());
			}
			
		};
		MyThread2 myrunnable = new MyThread2("신한4");//Runnable인터페이스를 구현한 클래스
		Thread t4 = new Thread(myrunnable);//이렇게 해야 실제 쓰레드
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Runnable의 익명구현class");
			}
		});
		Thread t6 = new Thread(()->{
			System.out.println("Runnable 익명구현클래스(람다식)");
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		System.out.println(Thread.currentThread().getName() + "thread End");
	}

}
