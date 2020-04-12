package com.mingzhi.interview.springaop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 
 * @author mingzhi
 *
 *
 *         AOP的主要名词概念
 * 
 *         Aspect:通用代码的实现 Target:被织如Aspect的对象 
 *         Join Point:可以作为切入点的机会，所有方法都可以作为切入点
 *         Pointcut: Aspect实际被应用在的JoinPoint,支持正则 
 *         Advice: 类里的方法以及这个方法如何织入到目标方法的方式
 *         Weaving：Aop的实现过程
 * 
 * 
 *         Advice的种类 
 *         前置通知（Before） 
 *         后置通知（AfterReturning）
 *         异常通知（AfterThrowing）
 *         最终通知（After） 
 *         环绕通知（Around）
 */


//这个切面针对的目标对象target就是HaaController
//@aspect 将一个Java类定义为切面类
@Aspect
@Component
public class RequestLogAspect {

//	===================WHAT 当前类就是切面============================
	private static final Logger logger= LoggerFactory.getLogger(RequestLogAspect.class);
	
//	===================WHERE切入点在哪=============================
//	切入点，可以是正则表达式
//	* 表示拦截的方法的返回值类型是任意的。后面的可以搜，代表拦截web目录下带有任意参数，的任何名字的方法都拦截-打日志
	@Pointcut("execution(public * com.mingzhi.interview.web..*.*(..))")
	public void webLog1() {}
	
	
//	======================WHEN 要切入的时机===========================
	@Before("webLog1()")
	public void doBefore(JoinPoint joinPoint) {
//		接受到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
//		记录下请求内容
		logger.info("URL:" + request.getRequestURI().toString());
		logger.info("IP:" + request.getRemoteAddr());
	}

	@AfterReturning(returning = "ret", pointcut = "webLog1()")
	public void doAfterReturning(Object ret) {
//		处理完请求，返回内容
		logger.info("RESPONSE:" + ret);

	}
	
}
