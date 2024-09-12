package com.shinhan.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//DTO(Data Transfer Object), 데이터가 전송될 때는 항상 DTO를 이용한다.(한 건에 여러 데이터를 담기 위해 필요한 클래스)
//JavaBeans기술에서 이용(JSP, String, Mybatis는 javabeans기술을 이용한다.)
//어떤 곳에선 DTO 대신 VO라고 하기도 한다.
@Getter@Setter@ToString
public class EmpDTO {
	//칼럼이름 선언
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
	
	//ctrl+shift+y : 대문자 -> 소문자
}
