package com.shinhan.week3.day1.thread;

//process : 실행중인 하나의 프로그램
//thread : 하나의 process 내의 프로그램의 흐름
//Thread class이용하면 MultiThread프로그램이 가능
public class MultiThreadTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " thread 시작....");
		//1) 구현class로 만들기
		//3) Runnable interface를 구현
		//Thread t1 = new UppercaseThread();//자식이 부모에 자동형변환(1)
		//Thread t1 = new Thread(new UppercaseThread());//자식이 부모에 자동형변환(3)
		UppercaseThread2 t2 = new UppercaseThread2();
		
		//2)익명구현class만들기
		Thread t3 = new Thread() {
			@Override
			public void run() {
				//2. 영문자 소문자 출력
				for(char i = 'a'; i <= 'z'; i++) {
					System.out.println(Thread.currentThread().getName() + i + " ");
				}
			}
			
		};//익명구현으로 재정의
		
		//4)interface로 익명구현class 만들기
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//3. 숫자 1~26 출력
				for(int i = 27; i <= 52; i++) {
					System.out.println(Thread.currentThread().getName() + i + " ");
				}
			}
		}); 
		
		Thread t5 = new Thread(() ->{
			//3. 숫자 1~26 출력
			for(int i = 1; i <= 26; i++) {//메서드가 run()밖에 없으므로 람다표현식으로 익명구현클래스 표현 가능
				try {
					Thread.sleep(20);//딜레이를 줌으로써 쓰레드들 중 늦게 처리가 되게 된다.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//밑줄이 길면 exception처리 가능성
				System.out.println(Thread.currentThread().getName() + i + " ");
			}
		});
		//t1.run();//다 끝날 때 까지 다른 스레드가 실행불가능한 동기
		t2.start();
		t3.start();//비동기 //실행의 흐름을 만들고 run()호출 <- 흐름이 같아서 흐름의 혼동이 옴
		t4.start();
		t5.start();
		//누가 먼저 끝날지는 그때그때 다름
		
		//3. 숫자 1~26 출력
		for(int i = 1; i <= 26; i++) {//메서드가 run()밖에 없으므로 람다표현식으로 익명구현클래스 표현 가능
			System.out.println(Thread.currentThread().getName() + i + " ");
		}
		System.out.println(Thread.currentThread().getName() + " thread 끝....");

	}

}
