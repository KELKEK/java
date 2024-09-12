package com.shinhan.week2.day4;

import java.util.Objects;

//class : 틀(template), object를 만들기 위해
//object : instance(실체)

//VO(Value Object) : data 저장(여러개의 필드를 저장), c언어의 structuor비슷
//DTO(Data Transfer Object) : data전송목적
//JavaBeans기술 : default생성자를 이용해서 객체생성을 한다(default가 반드시 있어야 한다.)
public class ComputerVO {
	//1, field(데이터 저장)
	String model;
	int price;
	String company;
	
	public ComputerVO () {
		
	}
	
	public ComputerVO(String model, int price, String company) {
		this.model = model;
		this.price = price;
		this.company = company;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public int hashCode() {
		return Objects.hash(company, model, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerVO other = (ComputerVO) obj;
		return Objects.equals(company, other.company) && Objects.equals(model, other.model) && price == other.price;
	}

	@Override //컴파일 시점에 해석
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputerVO [model=")
		.append(model)
		.append(", price=")
		.append(price)
		.append(", company=")		
		.append(company)
		.append("]");
		return builder.toString();
	}

	
	
}
