package com.shinhan.week3.day1.thread;


public class BathRoom {
	//synchronized : 하나의 thread가 이 메서드 수행을 Lock건다.
	//즉, 다른 Thread가 접근불가, 하나의 thread가 메서드 벗어나면 대기 thread가 들어온다.
	
	
	boolean isFirst = true;
	//****wait()와 notify()는 동기화 메소드 또는 블록에서만 호출할 수 있다.
	synchronized void use(String name) {//메서드에 락을 거는 방법, 다른 스레드가 들어올 수 없는 상태가 됨
			if(isFirst && name.equals("김")) {
				isFirst = false;
				try {
					wait();//다른 Thread가 들어올 수 있게 됨.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("------------");
		
		notifyAll(); //wait()상태의 쓰레드를 실행대기 상태로 둔다.
	}
	
	
	 void use2(String name) {//블록에 락을 거는 방법
		 synchronized (this) {
				System.out.println(name + "입장");
				System.out.println(name + "사용중");
				System.out.println(name + "퇴장");
				System.out.println("------------");
		}
	}
}

class BathRoomThread extends Thread{
	BathRoom room;
	String name;
	
	BathRoomThread(BathRoom room, String name){
		this.room = room;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 3; i++) {
			room.use(name);
		}
	}
	
	
	
}