package com.mingzhi.interview.springaop;

public class RealPayment implements Payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("作为用户，我只关心支付就行了");
		
	}

}
