package com.shinhan.day06.prac;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		tire.run();
	}
}


class Tire{
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}
class SnowTire extends Tire{
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다.");
	}
}

//스노우 타이어가 굴러갑니다.
//스노우 타이어가 굴러갑니다.