package com.shinhan.week3.day1_1;

import lombok.Getter;

public class UtilExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue(childPair, "홍삼순");
		System.out.println(childAge);

		OtherPair<String, String> otherPair = new OtherPair<>("홍삼근", "20");
		// OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생
		//String otherAge = Util.getValue(otherPair, "홍삼원");
		//System.out.println(otherAge);

	}

}

@Getter
class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

}

class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K k, V v) {
		super(k, v);
	}
}

@Getter
class OtherPair<K, V> {
	private K key;
	private V value; 
	//이거 포함되면 null되어버림

	public OtherPair(K key, V value) {
		//super(key, value);
		this.key = key;
		this.value = value;
	}
}

class Util{
	public static<P extends Pair<K, V>, K, V> V getValue(P pair, K k) {
		if(pair.getKey().equals(k)) {
			return pair.getValue();
		}else {
			return null;
		}
	}
	
	
	public static<A, B> B getValue3(Pair<A, B> pair, String str) {
		if(pair.getKey().equals(str)) {
			return pair.getValue();
		}else {
			return null;
		}
	}
	
	
	
	public static Integer getValue2(Pair<String, Integer> pair, String str) {
		if(pair.getKey().equals(str)) {
			return pair.getValue();
		}else {
			return null;
		}
	}
	
}
