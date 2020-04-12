package com.mingzhi.interview.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//web访问入口  
@RestController
public class HaaController {

//	创建切面，什么时候切入
//	比如在每一个Controller的每个方法都添加 日志记录功能的逻辑，后续要修改日志记录信息比如请求的协议是什么，则所以都要修改维护成本大，此时引入AOP --aspect切面编程。 
//	只需要处理好WWW :WHAT=切面（首先将请求日志的功能分离出来组成一个切面）,WHEN=什么时候织入,可以在hello方法执行前，执行后，或者执行中织入。WHERE=切面的织入发生在哪个位置 即可。
//	切入点Pointcut： 就是Controller调用什么方法的时候调用切面，本例咱们想要增加hello的方法即在这个方法被调用的地方我们需要用日志记录下相关的信息。
		@RequestMapping(value="/haa",method=RequestMethod.GET)
		@ResponseBody
		public String hello() {
			String sentence="hello world";
			System.out.println(sentence);
			return sentence;
		}
	
}
