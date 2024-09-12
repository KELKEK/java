package com.shinhan.week2.day2;

public class Speaker implements Volume{
	int volLevel;
	
	public void volumeUp(int vol) {
		// TODO Auto-generated method stub
		volLevel += vol;
		
		if(vol > 100) {
			volLevel = 100;
		}
		System.out.println(getClass().getSimpleName() +"볼륨을 올립니다." + volLevel);
	}

	public void volumeDown(int vol) {
		// TODO Auto-generated method stub
		//VolLevel 을 주어진 level 만큼 증가, 메시지 출력, 100보다 크면 100으로 설정
		volLevel -= vol;
		if(volLevel < 0) {
			volLevel = 0;
		}
		System.out.println(getClass().getSimpleName() +"볼륨을 내립니다." + volLevel);
	}
	
}
