package com.shinhan.week3.day2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// f1();
		 f2();
		// f3();
		// f4();//오토세이브스레드
		// f6();
		// f7();//callable
		/*Thread thread = new MovieThread();
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
		
	}
*/
}
/*
	private static void f7() {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 100; i++) {
			int end = i;
			Future<Integer> result = service.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j <= end; j++) {// i의 값이 변경되면 안되는데 변경되고 있으므로 end를 통해 값이 바뀌어도 상관없는 변수를 하나 선언한다.
						sum += j;
					}
					System.out.println(Thread.currentThread().getName() + " : " + end + "까지 합 ==>" + sum);
					return sum;
				}
			});
			result.get();
		}
	}
*/
	private static void f6() {
		// TODO Auto-generated method stub
		String s = "JAVA";// final이 생략
		int score = 100;
		class LocalClass {
			void method1() {
				// 안됨 System.out.println(score);
				System.out.println(s);
			}
		}
		score = 200;
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// System.out.println(score); score 값을 바꿔서 안됨
				System.out.println(s);
			}

		};
	}

	private static void f4() {
		// TODO Auto-generated method stub
		AutoSaveThread t1 = new AutoSaveThread();
		// t1.setDaemon(true); //메인이 끝나면 같이 종료
		// t1.start(); //계속 반복됨

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f3() {
		// TODO Auto-generated method stub
		PrintThread t1 = new PrintThread();
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.setStop(true);
		// 비추천 : t1.stop();

		t1.interrupt();
	}

	private static void f2() {
		// TODO Auto-generated method stub
		// 여러 쓰레드가 공유하는 공유데이터
		Calculator calculator = new Calculator();

		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		

		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
		user1Thread.start();
	}

	private static void f1() {
		WorkThread t1 = new WorkThread("WorkThread1");
		WorkThread t2 = new WorkThread("WorkThread2");
		t2.start();
		t1.start();
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.work = false;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.work = true;
	}

}
