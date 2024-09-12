package com.shinhan.week3.day1.thread;


//MultiThread : A. 1)Thread상속 2) run()메서드 재정의 3)new객체 생성 후 start()...run()수행됨
//B. 이미 상속받은 부모가 있다면 자바는 멀티상속불가하므로 Runnable interface 구현
public class UppercaseThread2 extends Thread{//스레드 상속받음, 추상메서드는 아니지만 run메서드 재정의
	@Override
	public void run() {
		//1. 영문자 대문자 출력
		for(char i = 'A'; i <= 'Z'; i++) {
			try {
				sleep(10); // try-catch해줘야 함(밑줄이 끝까지 그어져있으면)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread 상숙받음" + " : " + Thread.currentThread().getName() + i + " ");
			//A) 이 클래스는 스레드가 되었으므로 'Thread.'생략 가능하다.
			//B) 스레드가 아니므로 'Thread.'해주어야 한다.
		}
	}
	
	
}
