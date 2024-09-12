package com.shinhan.week3.day2;
//607p
public class WorkThread extends Thread {

	boolean work = true;
	WorkThread(String name){
		//setName(name); 둘 다 됨
		super(name);
	}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(work) {
				System.out.println(getName() + "작업처리");
			}else {
				Thread.yield();//일을 하지 않는 중일 땐 다른 쓰레드에 양보, 굉장히 잠깐이다.
			}
		}
	}
	
	
}
