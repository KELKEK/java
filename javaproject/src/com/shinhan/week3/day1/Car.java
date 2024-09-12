package com.shinhan.week3.day1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class Car implements Comparable<Car>{
	String model;
	int price;
	String color;
	
	public void run() {
		System.out.println("자동차가 달립니다.");
	}

	@Override
	public int compareTo(Car obj) {
		// 가격desc, 이름desc, 색깔asc
		int result = obj.price - price;
		if(result == 0) {
			int result2 = obj.model.compareTo(model);
			if(result2 == 0) return color.compareTo(obj.color);
			return result2;
		}
		return result;
	}
}
