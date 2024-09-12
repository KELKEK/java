package com.firstzone.pack2;

public class Car {
	String model;
	int price;
	public Car() {
	}
	public Car(String model, int price) {
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//필드가 private 접근지정자가 아니더라도 다른 패키지에서 쓸 수 있게 getter/setter를 해놓음
	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
}
