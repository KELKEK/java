package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;


public class DeptController {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean isStop = false;
		DeptService deptService = new DeptService();
		while(!isStop) {
			int selectJob = menuDisplay();
			switch(selectJob) {
			case 0->{
				isStop = true;
			}
			case 1->{
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모든 직원 조회");

			}
			case 2->{
				
			}
			}
		}
	}
	private static int menuDisplay() {
		System.out.println("======!!!!!!======");
		System.out.println("1, 모든 직원 조회");
		System.out.println("2, 특정 직원 조회");
		System.out.println("3, 특정부서의 직원 조회");
		System.out.println("4, 조건조회(부서/직책/입사일/급여)");
		System.out.println("5, 직원입력");
		System.out.println("6, 직원수정");
		System.out.println("7, 직원삭제");
		System.out.println("0, 종료");
		System.out.print("작업 선택 >> ");
		int job = sc.nextInt();
		System.out.println("==============");
	
		return job;
	}
}
