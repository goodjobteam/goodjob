package com.mingzhi.luckymoney;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* mingzhi
*  @goal:访问页面的方法
* 
*/
//@Controller+@Responsebody==@RestController
@RestController
public class HelloController {

//	获取配置文件数据的方式，金额使用
	@Value("${minmoney}")
	private BigDecimal minmoney;
	@Value("${descpriton}")
	private String descpriton;


	
//	页面访问地址：localhost:8088/hello   getmapping只支持post请求
	@GetMapping("/hello1")  
//	就版本1点多的时候使用如下较繁琐,如下不写请求方式则get 和post都可。
//	@RequestMapping(value="/hello")
//	@RequestMapping(value="/hello",method=RequestMethod.POST) 
	public String say(){
//		return "实现了页面访问，goodboy!";
		return "minmoney : " + minmoney+ "发红包说明：" + descpriton;
	}
	
	
//	获取链接中的参数方式   @PathVariable [通过url传参]或者 @RequestParam 【通过url或者body】  访问的连接：http://localhost:8088/selfsetpath/hi/100  或者  http://localhost:8088/selfsetpath/hi？id=100
	@GetMapping("/hi/{id}")  
	public String say1(@PathVariable("id") Integer myid){
//		return "实现了页面访问，goodboy!";
		return "您输入的ID是：" + myid;
	}
	
//	这里改成访问的时候可不输入id 也不报错的方式。 访问连接 http://localhost:8088/selfsetpath/hi1?id=22 或者  http://localhost:8088/selfsetpath/hi1
	@GetMapping("/hi1")  
//	如果使用@PostMapping 则传参方式可以使用body也可以拼接串。
	public String say2(@RequestParam(value="id",required =false, defaultValue="0" ) Integer myid){
//		return "实现了页面访问，goodboy!";
		return "您输入的ID是：" + myid;
	}
	
	
	
}
