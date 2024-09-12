package com.shinhan.day06;

public class BonusPointAccount extends Account{

	int bonusPoint;    // 누적 포인트                
    BonusPointAccount(String accountNo, String ownerName, int balance, 
                      int bonusPoint) {
        super(accountNo, ownerName, balance);
        this.bonusPoint = bonusPoint;
    }
	@Override
	void deposit(int amount) {
		// TODO Auto-generated method stub
		super.deposit(amount);
		bonusPoint += (int)(amount * 0.001);
		//복합대입연산자는 자동형변환됨
	}    
    

}
