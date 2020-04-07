package com.mingzhi.goodjob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingzhi.common.SpringUtil;
import com.mingzhi.wiser.WiserMain;

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

    //通过类反射获取其他类实现调用
//   @Autowired
//   private static  WiserMain wiserMain;
//    
//    static ApplicationContext context = SpringUtil.getApplicationContext();
//    static WiserMain wiserMain = context.getBean(WiserMain.class);// 注意是Service，不是ServiceImpl

	public static void main(String[] args) {
		SpringApplication.run(GoodjobApplication.class, args);
		LOG.info("==============console info=============");
		LOG.debug("==============console debug============");
		System.out.println("console hello goodjob");
		 //调用Sercice层
//	    ApplicationContext context = SpringUtil.getApplicationContext();
//	    WiserMain wiserMain = context.getBean(WiserMain.class);// 注意是Service，不是ServiceImpl
//		getNewWord();
		 
	}
	
	
//	nginx使用
	
//	TODO:调用配置文件
	
//  TODO:Mybatis使用
	
//	TODO:调用其他类文件分别实现 数组，链表  ，等操作。
	

}
