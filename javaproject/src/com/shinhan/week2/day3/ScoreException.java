package com.shinhan.week2.day3;

public class ScoreException extends Exception {//
	//String message;
	ScoreException(String message){
		//this.message = message;
		super(message); //부모의 생성자를 불러라
	}
	
	void print() {
		System.out.println("Score는 70이상이어야 합니다.");
	}
}
