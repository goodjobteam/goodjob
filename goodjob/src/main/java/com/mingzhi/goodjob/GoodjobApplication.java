package com.mingzhi.goodjob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author mingzhi
 * @date 2020年4月2日
 * @target：goodJob
 *
 */
//@RestController
@SpringBootApplication
public class GoodjobApplication {
	
    private static final Logger LOG = LoggerFactory.getLogger(GoodjobApplication.class);


	@RequestMapping("/")
	public String hello() {
		return "hello goodjob";
	}
	public static void main(String[] args) {
		SpringApplication.run(GoodjobApplication.class, args);
		LOG.info("==============console info=============");
		LOG.debug("==============console debug============");
		System.out.println("console hello goodjob");
		
	}
	
	
	
//	掌握日志打印配置文件意思
//	git提交忽略文件学习
	
	
//	nginx使用
	
//	TODO:调用配置文件
	
//  TODO:Mybatis使用
	
//	TODO:调用其他类文件分别实现 数组，链表  ，等操作。
	
//  TODO:将一些常用的方法配置到一个公共类中

}
