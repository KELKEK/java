package com.shinhan.week2.day2;

public class ShapeTest {
	//interface는 instance 생성 불가
	//Resizable aa = new Resizable();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] arr = new Shape[2];
		arr[0] = new RectTriangle(5, 6);
		arr[1] = new Rectangle(6, 2);
		
		for(Shape shape : arr) {
			System.out.println("area : " + shape.getArea());
			System.out.println("perimeter : " + shape.getPerimeter());
			if(shape instanceof Resizable rr) {
				//resize가능하면 해라는 함수
				rr.resize(0.5);
				System.out.println("area : " + shape.getArea());
				System.out.println("perimeter : " + shape.getPerimeter());
			}
			
		}
	}

}
