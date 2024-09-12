package com.shinhan.day06;

//패키지 내 class가 존재하는지 찾는다.
//Modifier
//1, 접근지정자 : public > protected > default(생략) > private
//2, 활용방법 여러개 가능 : static, final, abstract, synchronized,....
public class SchoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student a = new Student("홍길동",20,200201);
		String s = a.getName();
		a.setName("aaaa");
		a.print();
		new Teacher("이순신",30,"JAVA");
		new Employee("유관순",40,"교무과");
	}

}


class Student {
	//instance 변수 , 객체 생성 시 자동으로 초기화된다.
	private String name;
	private int age;
	private int id;
	
	Student(String name, int age, int id){//생략 접근지정자를 사용, 다른 패키지에서도 접근하고 싶으면 클래스의 접근지정자와 맞추어 public으로 둔다.
		this.name=name;
		this.age=age;
		this.id=id;
		print();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//재정의 : 함수 이름, 매개변수, returnType이 같아야한다.
	//Modifier의 범위는 같거나 더 넓어져야 한다.
	void print() {
		System.out.println("이름:"+ name+ " 나이:"+ age+ " 학번:"+ id + this.getClass().getSimpleName());
		//마지막것은 클래스명을 불러오는 것. 'this.'은 생략 가능하다., getName()일 시에는 패키지명까지 들어가버림
	}
}


class Teacher {
	private String name;
	private int age;
	private String subject;
	
	Teacher(String name, int age, String subject){
		this.name=name;
		this.age=age;
		this.subject=subject;
		print();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	void print() {
		System.out.println("이름:"+ name+ " 나이:"+ age+ " 담당과목:"+ subject);
	}
}


class Employee {
	String name;
	int age;
	String dept;
	
	Employee(String name, int age, String dept){
		this.name = name;
		this.age = age;
		this.dept = dept;
		print();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	void print() {
		System.out.println("이름:"+ name+ " 나이:"	+ age+ " 부서:"+ dept);
	}
}


