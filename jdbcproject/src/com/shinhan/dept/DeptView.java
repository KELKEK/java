package com.shinhan.dept;

import java.util.List;
//View : 사용자에게 어떻게 보여줄지를 담당, JSP로 담당할 예정이다.
//굳이 이제 자바에서는 잘 쓰이지 않고 웹의 영역이 됨.
public class DeptView {
	public static void print(List<DeptDTO> emplist, String title) {
		// TODO Auto-generated method stub
		System.out.printf("================%s==============\n", title);
		if(emplist == null) {
			System.out.println("해당되는 조건이 없습니다.");
		}
		emplist.stream().forEach(emp->System.out.println(emp));
	}
	public static void print(DeptDTO emp, String title) {
		// TODO Auto-generated method stub
		System.out.printf("================%s==============\n", title);
		if(emp == null) {
			System.out.println("존재하지 않는 직원입니다.");
		}else {
			System.out.println("부서 : " + emp.getDepartment_id());
			System.out.println("부서명 : " + emp.getDepartment_name());
			System.out.println("매니저 : " + emp.getManager_id());
			System.out.println("위치 : " + emp.getLocation_id());
		}
	}
	public static void print(String message) {
		// TODO Auto-generated method stub
		// 결과를 나타내주는 메시지를 출력하는 함수
		System.out.printf("================%s==============\n", message);
	}
}
