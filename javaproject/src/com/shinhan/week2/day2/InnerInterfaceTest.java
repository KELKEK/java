package com.shinhan.week2.day2;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OKButtonListener ok1 = new OKButtonListener();
		OKButtonListener2 ok2 = new OKButtonListener2();
		
		
		Button button = new Button();
		button.setListener(ok2);
		button.click();
		
		//이름이 없는 이명의 구현class만들기
		//별도로 객체를 계속 만들 필요 없다.
		Button.ClickListener ok3 = new Button.ClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("익명 구현 class 만들기");
			}
		};
		
		//익명구현 class 만들기2
	button.setListener(new Button.ClickListener() {
		
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
			System.out.println("익명 구현 class 만들기 2");
		}
	});
button.click();
//람다식(interface에 메서드가 1개 있을 때만 가능)
button.setListener(()-> System.out.println("익명 구현 classs 만들기3"));
button.click();	
	}

}
