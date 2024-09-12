package com.shinhan.day06.lab1;

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C(); //객체 생성은 C, 자식 생성 시 부모도 생성된다. 부모는 자식을 담을 수 있다.
        B b =  c; // (B) c
        A a =  c; // (A) c
        
        if( a instanceof A ) {
            System.out.println( "a 는 A 의 인스턴스 이다.");
        }        
        if( a instanceof B) {
            System.out.println( "a 는 B 의 인스턴스 이다.");
        }
        if( a instanceof C) {
            System.out.println( "a 는 C 의 인스턴스 이다.");
        }
        
        System.out.println(a.meth() + " " + b.meth() + " "
+ c.meth()
           + " "           + A.sMeth() + " " + B.sMeth() + " "
+ C.sMeth() );//static은 될 수 있으면 클래스에서 받는걸 권장한다. 
    } 
}


class C extends B { 
    int meth()  { return 100; } 
    static int sMeth() { return 100; } 
} 
class B extends A { 
    int meth()  { return 10; } 
    static int sMeth() { return 10; } 
} 
class A{ 
    int meth()  { return 1; } 
    static int sMeth() { return 1; } 
} 
//C->B->A, C->A->B 둘 다 가능(A,B비교는 없었기 때문)