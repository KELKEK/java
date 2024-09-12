
class Prob3 {
	public static void main(String args[]){
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge{	
	//구현하시오.
	private String user; //폰 사용자 이름
	private int call; //통화시간(분단위)
	private int sms; // 문자전송건수
	private int data; // 데이터통신량(GB단위)
	private int total; // 통신요금(원)
	
	
	public PhoneCharge(String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}
	
	public int calcCharge() {
		int callFee;
		int smsFee;
		int dataFee;
		
		if(call >= 200) {
			callFee = call * 20;
		}else {
			callFee = call * 10;
		}
		
		if(sms >= 300) {
			smsFee = sms * 80;
		}else {
			smsFee = sms * 20;
		}
		
		if(data >= 7) {
			dataFee = data * 2000;
		}else {
			dataFee = data * 1000;
		}
		
		total = callFee + smsFee + dataFee;
		return total;
	}
	
	public void printCharge() {
		System.out.println(user + "사용자는 이번달에 사용하신 전화요금이 " + calcCharge() + "원입니다.");
	}
	
}
 