package com.shinhan.week2.day2.prac;


interface Action {
	public void work();
}

public class ActionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Action action = new Action() {
			public void work() {
				System.out.println("익명구현객체");
			}
		};
		Action action2 =() -> System.out.println("Lambja표현식");
		
		action.work();
	}

}
