package com.mingzhi.interview.springaop;


/**
 * 
 * @author mingzhi
 *	Spring里代理模式的实现
 *
 *		真实实现类的逻辑包含在了getBean方法里
 *		getBean方法返回的实际上是Proxy的实例
 *		Proxy实例是Spring采用JDK Proxy 或CGLIB动态生成的
 *
 *
 *
 */
public class ProxyDemo {
	
	public static void main(String[] args) {
		Payment proxy =new AliPay(new RealPayment());
		proxy.pay();
		
	}
	

}
