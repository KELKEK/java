package com.shinhan.week3.day1_1;

public class ContainerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Container<String> container1 = new Container<String>();
		 container1.set("홍길동");
		 String str = container1.get();
		 Container<Integer> container2 = new Container<Integer>();//default 생성자
		 container2.set(6);
		 int value = container2.get();
		 
		 
		 System.out.println(str);
		 System.out.println(value);
		
		 Container2<String, String> container3 = new Container2<String, String>();
		 container3.set("홍길동", "도적");
		 String name1 = container3.getKey();
		 String job = container3.getValue();
		 Container2<String, Integer> container4 = new Container2<String, Integer>();
		 container4.set("홍길동", 35);
		 String name2 = container4.getKey();
		 int age = container4.getValue();
		 
		 System.out.println(name1);
		 System.out.println(job);
		 System.out.println(name2);
		 System.out.println(age);
	}

}


class Container<T>{
	T data;
	
	void set(T data) {
		this.data = data;
	}
	
	T get() {
		return data;
	}
	
}