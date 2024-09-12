package com.shinhan.week2.day4;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//class : 틀(template), object를 만들기 위해
//object : instance(실체)

//VO(Value Object) : data 저장(여러개의 필드를 저장), c언어의 structuor비슷
//DTO(Data Transfer Object) : data전송목적
//JavaBeans기술 : default생성자를 이용해서 객체생성을 한다(default가 반드시 있어야 한다.)
//@ToString
//@EqualsAndHashCode
//@Getter@Setter
//@AllArgsConstructor //모든인자생성자
//@NoArgsConstructor //기본생성자
@AllArgsConstructor
@Data //이렇게 써도 됨
public class ComputerVO3 {
	//1, field(데이터 저장)
	
	@NonNull  //model값에 null이 올 수 없도록 함. 예외로 발생한다.
	String model;
	int price;
	String company;
	
	
	
}
