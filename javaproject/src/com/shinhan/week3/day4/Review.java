package com.shinhan.week3.day4;

import java.util.stream.IntStream;

import com.shinhan.week3.day3.Student;

interface Makeable {
	public Student makeStudent(String name, int score);
	// abstract할 때는 생략 가능하더라도 public 접근지정자를 넣어주는게 좋다
}

class StudentMakeClass implements Makeable {

	@Override
	public Student makeStudent(String name, int score) {
		return new Student(name, score);
	}

}

class Button {
	// 정적 멤버 인터페이스(함수형 인터페이스)
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}

	private ClickListener clickListener;

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}

class MyButton implements Button.ClickListener {

	@Override
	public void onClick() {
		// TODO Auto-generated method stub

	}

}

interface Function {
	public double apply(double a, double b);
}

interface Function2<T> {
	public double apply(T t);
}

@FunctionalInterface
interface Operator {
	public int apply(int x, int y);
}

class Student2 {
	private String name;
	private int englishScore;
	private int mathScore;

public Student2(String name, int englishScore, int mathScore) {
 this.name = name;
 this.englishScore = englishScore;
 this.mathScore = mathScore;
 }

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}
}

public class Review {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// f1();
		// f2();// 16-4번
		// f3(); //5
		// f4();//6
		//f5(); //7
		f6();
	}

	private static void f6() {
		Student2[] students = {
				 new Student2("홍길동", 90, 96),
				 new Student2("신용권", 95, 93)
				};
		
		double englishAvg = avg(Student2::getEnglishScore, students);
		//람다식 메서드 참조
		 System.out.println("영어 평균 점수: " + englishAvg);
		 
		 double mathAvg = avg( s -> s.getMathScore(), students);
		 System.out.println("수학 평균 점수: " + mathAvg);
		
	}
	private static double avg(Function2<Student2> func, Student2[] students) {
		int total = 0;
		for(Student2 st: students) {
			total += func.apply(st);
		}
		
		return (double)total/students.length;
	}


	private static void f5() {
		// 최대값 얻기
		int max = maxOrMin((a, b) -> a >= b ? a : b);
		System.out.println("최대값: " + max);

		// 최소값 얻기
		int min = maxOrMin((a, b) -> a <= b ? a : b

		);
		System.out.println("최소값: " + min);
	}

	private static void f4() {
		// TODO Auto-generated method stub
		double result = calc((x, y) -> (x / y));
		System.out.println("result = " + result);
	}

	private static double calc(Function fun) {
		// TODO Auto-generated method stub
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

	private static void f3() {
		Button btnOk = new Button();
		// 1. 구현클래스
		// btnOk.setClickListener(new MyButton());

		btnOk.setClickListener(() -> {
			System.out.println("OK버튼을 클릭했씁니다.");
		});
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다."));
		btnCancel.click();
	}

	private static void f2() {
		Thread thread = new Thread(() -> {
			IntStream.rangeClosed(1, 3).forEach(i -> System.out.println("작업스레드가 실행됩니다."));

		});
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Makeable make1 = (n, s) -> new Student(n, s);// 3, 람다식
		Makeable make2 = Student::new;// 4, 람다식 생성자 참조 <- 매개변수 개수는 상관없다.
		Makeable make3 = new Makeable() {
			public Student makeStudent(String name, int score) {
				return new Student(name, score);
			}
		};// 1, 익명class
		Makeable make4 = new StudentMakeClass();// 2, 구현class

		Student s1 = make1.makeStudent("상호", 100);
		Student s2 = make2.makeStudent("상호2", 200);

		System.out.println(s1);
		System.out.println(s2);
	}

}
