package com.shinhan.week2.day2;

public class CupUsing {

	public static void main(String[] args) {
		//CoffeeCup cup = new CoffeeCup();
		//WaterCup cup2 = new WaterCup();
		
		print(new CoffeeCup());
		print(new WaterCup());
		print(new Cup() {
			public void use() {
				System.out.println("익명구현class");
			}
		});
		print(()->System.out.println("람다표현식으로 구현class 만들기"));
	}
	
	
	static void print(Cup cup) {
		cup.use();
	}

}
