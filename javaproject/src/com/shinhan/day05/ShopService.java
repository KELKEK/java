package com.shinhan.day05;

//싱글톤 문제
public class ShopService {
	private static ShopService shop;
	
	//생성자의 접근지정자를 private
	public ShopService(){
		
	}
	
	public static ShopService getInstance() {
		if(shop == null) {
			shop = new ShopService();
		}//여기 내에서는 객체를 만들 수 있음
		return shop;
		//return new ShopService(); 이러면 계속 객체 만들어짐
	}
}
