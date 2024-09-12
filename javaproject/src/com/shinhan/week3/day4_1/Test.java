package com.shinhan.week3.day4_1;


import java.util.List;

class Person{
    String name;
    Person(String name){
          this.name = name;
      }
}
public class Test{
  public static void main(String[] args){
	     Counter c1 = new Counter();
	      Counter c2 = new Counter();
  }
}

class Counter  {
	  int count = 0;
	  Counter() {
	    count++; 
	    System.out.print(count + "$"); 
	  }
}