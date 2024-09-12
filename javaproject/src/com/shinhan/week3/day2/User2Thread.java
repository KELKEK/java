package com.shinhan.week3.day2;

public class User2Thread extends Thread{
	private Calculator calculator;//풀네임을 적어주면 유지보수에 편하다.
	
	User2Thread(){
		setName("User2Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;//calculator가 들어오면 this.calculator에 넣어라
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		calculator.setMemory2(50);
	}
	
	
}
