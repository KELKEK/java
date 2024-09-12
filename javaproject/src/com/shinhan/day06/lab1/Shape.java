package com.shinhan.day06.lab1;

//abstract class : abstract메서드가 1개 이상 있다를 의미한다.
//abstact 메서드 : 정의는 있고 구현은 없는 메서드를 의미한다.
public abstract class Shape {

	private String color;
	private String type;
	
	public Shape() {}
	
	public Shape(String color, String type)
	{
		this.color = color;
		this.type = type;
	}
	
	public String getColor()
	{
		return color;
	}
	public String getType()
	{
		return type;
	}
	
	public abstract double calculateArea();
	
	public abstract double calculatePerimeter();
	
	public String toString()
	{
		return color + " " + type;
	}
	
}


class Circle extends Shape{
	private double radius;
	private double circumference;
	
	Circle(String color, double radius){
		super(color, "Circle");
		this.radius = radius;
		circumference = 2 * 3.1415927 * radius;
		//Math.PI <- 파이값
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		double result = (double)circumference / 2 * radius;
		return result;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return (double)circumference;
	}

	public double getRadius() {
		return radius;
	}
	
}


class Rectangle extends Shape{
	double length;
	double width;
	
	Rectangle(String color, double length, double width){
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return (double)length * width;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return (double)2 * (length + width);
	}
	
}

