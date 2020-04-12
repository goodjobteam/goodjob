package com.mingzhi.interview.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration标签就会注入到容器中
@Configuration
public class ApplicationConfig {

//	Bean是将 initPerson方法返回的实体类装配到IOC容器中，而name是来定义Bean的名称，如果没写则默认会变为initPerson
//	实体类中如果使用Compnent注入到Spring则下面的试题配置可不写。因为生产环境中不可能每个实体类都写bean文件。
//	@Bean(name="person")
//	public Person initPerson() {
//		Person user= new Person();
//		
//		user.setAge(11);
//		user.setName("明智");
//		return user;
//	}
	
	
}
