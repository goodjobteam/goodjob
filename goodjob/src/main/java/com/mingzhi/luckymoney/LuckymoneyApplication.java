package com.mingzhi.luckymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuckymoneyApplication {
//运行当前包就执行当前包的启动类。保障该类下的方法好用。
	public static void main(String[] args) {
		SpringApplication.run(LuckymoneyApplication.class, args);
	}

}
