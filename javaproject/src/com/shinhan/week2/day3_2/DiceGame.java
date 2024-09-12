package com.shinhan.week2.day3_2;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;//1~8까지 정수
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Dice)) return false;
		Dice d = (Dice)obj;
		if(size == d.size)return true;
		return false;

	}
	
	
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {
		// 구현
		try {
		if(n < 0) throw new IllegalArgumentException("던지는횟수는 음수가 될 수 없음");//컴파일러가 체크하지 않는 에러처리
		}catch(IllegalArgumentException e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}finally {
			System.out.println("예외상관없이 실행");
		}
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		int count = 0;
		for(int i = 1; i <= n; i++) {
			int su1 = d1.play();
			int su2 = d2.play();
			if(su1 == su2) count++;
			System.out.println(su1 + "--" + su2);
		}
		return count;
	}
	
	
	
}
