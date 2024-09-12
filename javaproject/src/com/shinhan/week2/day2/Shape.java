package com.shinhan.week2.day2;

public abstract class Shape {
	private int numSides; //변의 수
	
	Shape(int numSides){
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}
 
	abstract double getArea();
	abstract double getPerimeter();
}


class RectTriangle extends Shape{
	double width;
	double height;
	
	RectTriangle(double w, double h){
		super(3);
		this.width = w;
		this.height = h;
		getArea();
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		double result = (width * height) / 2;
		return result;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return width + height + Math.sqrt(height*height+width*width);
	}
	
	
	
}


class Rectangle extends Shape implements Resizable, ReResizable{
	double width;
	double height;
	
	Rectangle(double w, double h){
		super(4);
		this.width = w;
		this.height = h;
		getArea();
	}
	
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		double result = width * height;
		return result;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		
		return 2 * (width + height);
	}

	@Override
	public void resize(double s) {
		// TODO Auto-generated method stub
		width = width * s;
		height = height * s;
	}

	@Override
	public void reresize(double s) {
		// TODO Auto-generated method stub
		width = width * s * s;
		height = height * s * s;
	}
	
}