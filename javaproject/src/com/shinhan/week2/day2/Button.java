package com.shinhan.week2.day2;

//버튼의 종류 다양
public class Button {
	public static interface ClickListener{
		void onClick(); //추상메서드
	}
	//field
	ClickListener listener;
	//setter
	void setListener(ClickListener listener) {
		this.listener = listener;
	}
	
	void click() {
		listener.onClick();
	}
	
}
