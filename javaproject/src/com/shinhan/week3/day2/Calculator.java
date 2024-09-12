package com.shinhan.week3.day2;

public class Calculator {
	private int memory;

	public int getMemeory() {
		return memory;
	}
	
	//동기화메서드 이용(함수 전체를 쌈)
	public synchronized void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
	//동기화블럭 사용 611p
	public void setMemory2(int memory) {
		synchronized (this) {//나 스스로가 공유됨
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		}
	}
	
	
	
	//동기화처리 안함
	public void setMemory3(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
}
