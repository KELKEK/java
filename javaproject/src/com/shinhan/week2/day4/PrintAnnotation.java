package com.shinhan.week2.day4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) //어디다 쓸 것인지를 적음//메소드에다 씀
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default "-";
	int number() default 7;
	String subject() default "자바";
	String subject2() default "자바2";//속성을 계속 추가할 수 있음
	
}
