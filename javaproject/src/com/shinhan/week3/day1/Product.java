package com.shinhan.week3.day1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//DTO(데이터 전송 목적), VO(Value Object), JavaBeans(JavaServlet, Spring, Mybatis) : NoArgs..., 게터세터 반드시 사용
@ToString
@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor//JavaBeans기술은 AllArgs..를 쓰지 않는다.
public class Product<K,V> {//보통 K : 키, V : value로 사용
	private K kind;
	private V model;
}
