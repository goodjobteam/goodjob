package com.mingzhi.goodjob;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
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
public class HiController {

//	获取配置文件数据的方式，金额使用
	@Value("${minmoney}")
	private BigDecimal minmoney;
	@Value("${descpriton}")
	private String descpriton;
	
//	注意同包的其他类文件
	@Autowired
	private WiserMain wiserMain;
	
	@GetMapping("/hi")  
	public String say(){
	//调用其他类方法
		return wiserMain.test();
	}
	

	
	
	
}
