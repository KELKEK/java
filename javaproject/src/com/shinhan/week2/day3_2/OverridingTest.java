package com.shinhan.week2.day3_2;

public class OverridingTest {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);
		String s1 = new String("30");

		System.out.println(ms1);
		System.out.println(ms2);

		if (ms1.equals(ms2))
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		else
			System.out.println("ms1과 ms2의 합계는 다릅니다.");
		
		if (ms1.equals(s1))
			System.out.println("ms1과 s1의 값은 동일합니다.");
		else
			System.out.println("ms1과 s1의 값은 다릅니다.");
	}

}

class MySum {
    int first;
    int second;
    
    MySum (int first, int second){
        this.first = first;
        this.second = second;
    }

	public String toString() {
		return String.valueOf(first + second);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MySum)) return false;
		MySum my = (MySum)obj;
		return this.toString().equals(my.toString());
	}

}
