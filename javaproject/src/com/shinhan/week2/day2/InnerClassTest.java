package com.shinhan.week2.day2;

public class InnerClassTest {
	
	public static void main(String[] args) {
		
		System.out.println(OuterClass.InnerClass2.bb);
		OuterClass.InnerClass2.method4();
		OuterClass.InnerClass2 inner = new OuterClass.InnerClass2();
		//static이라 바로 쓸 수 있다.
		
		System.out.println(inner.aa);
		System.out.println(inner.score);
		inner.method3();
	}

	public static void f1(String[] args) {
		// TODO Auto-generated method stub
		/*OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
		outer.new InnerClass();
		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
		*/
		
		//static 사용
		System.out.println(OuterClass.InnerClass.bb);
		OuterClass.InnerClass.method4();;
		
		
		//instance 사용
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
		System.out.println(inner.aa);
		System.out.println(inner.score);
		inner.method3();
	}

}

//외부 class
class OuterClass{
	int a = 100;//1, 인스턴스 변수(필드, 멤버변수)
	int score = 99;
	
	//2, class 변수
	static int b = 200;
	
	//3, instance 메서드
	void method() {
		//static method
	}
	//4, static 메서드
	static void method2() {
		
	}
	
	void call() {
		//지역변수는 내부 class에서 접근하면 무조건 변경불가(final)
		int price = 100;
		//method 내에 있는 class, method내에서만 접근 가능
		class LocalClass{
			//1, field
			int price2 = 2000;
			static int price3 = 3000;
			//method
			void show() {
				System.out.println("LocalClass instance method");
				System.out.println("지역변수를 local class에서 사용 price = " + price);
			}
			static void show2() {
				System.out.println("LocalClass class method");

			}
		}
		//price = 8888; 값 수정 불가
		//static
		System.out.println(LocalClass.price3);
		LocalClass.show2();
		
		//instance
		LocalClass local = new LocalClass();
		local.show2();
	}
	
	//5, instance inner class
	class InnerClass{
		int aa = 100;//1, 인스턴스 변수(필드, 멤버변수)
		String score = "A학점";
		
		//2, class 변수
		static int bb = 200;
		
		//3, instance 메서드
		void method3() {
			//static method
			System.out.println("innerclass의 method3 : " + (a+b+aa+bb));
			System.out.println(score);
			System.out.println("innerclass의 field : " +  score);
			System.out.println(OuterClass.this.score + " : outerclass의 field" );
		}
		//4, static 메서드
		static void method4() {
			//System.out.println("innerclass의 static method4" + (a+b+aa+bb));
			//static 변수가 아니면 쓸 수 없다.
		}
	}
	
	
	static class InnerClass2{
		int aa = 100;//1, 인스턴스 변수(필드, 멤버변수)
		String score = "A학점";
		
		//2, class 변수
		static int bb = 200;
		
		//3, instance 메서드
		void method3() {
			//static method
			System.out.println("innerclass의 method3 : " + (b+aa+bb));//a는 사용 불가 aa는 객체를 생성했기 때문에 쓸 수 있다. 
			System.out.println("innerclass의 field : " +  score);
			// System.out.println(OuterClass.this.score + " : outerclass의 field" ); //불가능 : static에서 instance를 받아올 수 없으므로
			
		}
		//4, static 메서드
		static void method4() {
			//System.out.println("innerclass의 static method4" + (a+b+aa+bb));
			//static 변수가 아니면 쓸 수 없다.
		}
	}
}