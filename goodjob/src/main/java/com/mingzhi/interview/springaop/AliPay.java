package com.mingzhi.interview.springaop;


/**
 * 
 * @author mingzhi
 *
 */
public class AliPay implements Payment {

//	由于这里需要调用RealPayment.pay() 因此该类里需要有个Payment对象，因为我们的Alipay是代替payment做一些事情的，需要掉里面的一些方法。然后再结合其他的逻辑。
	private Payment payment;
	
//	创建构造函数，传一个payment实例
	public AliPay(Payment payment) {
		this.payment=payment;
	}
	
	public void beforePay() {
		System.out.println("从您绑定支付宝的银行卡中取款到支付宝");
	}
	@Override
	public void pay() {

		beforePay();
		
		payment.pay();
		
		afterPay();
		
	}
	public void afterPay() {
		System.out.println("把钱从支付宝支付给淘宝卖家");
		
	}

}
