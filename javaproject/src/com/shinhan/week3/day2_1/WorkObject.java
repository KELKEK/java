package com.shinhan.week3.day2_1;

public class WorkObject {
	public synchronized void methodA() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " : methodA 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	
	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " : methodB 작업 실행");
		notify();//다른 스레드를 실행대기상태로 만듦
		try {
			wait();//자신의 스레드는 일시정지 상태로 만듦
		} catch (InterruptedException e) {
		}
	}
}
