package com.shinhan.day05;

public class ShopServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		// ShopService obj3 = new <- new 못 씀
		ShopService obj3 = new ShopService();
		// 왜냐하면 생성자의 접근지정자가 private이기 때문.

		if (obj1 == obj2) {
			System.out.println("같은 객체입니다.");

		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}
		if (obj1 == obj3) {
			System.out.println("같은 객체입니다.");
			
		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}

}
