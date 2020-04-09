package com.mingzhi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingzhi.common.SpringUtil;

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
  
  /**运行当前包就执行当前包的启动类。保障该类下的方法好用。
            一个项目只需要一个启动类。且该启动类的位置层级要大于所有包的层级即可保障所有包服务可访问。
	由于本环境有很多配置文件。IDE环境启动会自动适用yml配置，但打包部署时候需要手动指定适用哪个配置文件。
	命令： java -jar -Dspring.profiles.active=line 打包文件  或者实际打包中按照application.yml文件设定的为准
	**/
	public static void main(String[] args) {
		SpringApplication.run(GoodjobApplication.class, args);
		LOG.info("==============this is info级别日志=============");
		LOG.debug("==============我是 debug级别日志============");
		System.out.println("hello world 项目已经启动完成咯");
		 
	}

//	TODO:调用配置文件
	
//  TODO:Mybatis使用
	
//	TODO:调用其他类文件分别实现 数组，链表  ，等操作。

}
