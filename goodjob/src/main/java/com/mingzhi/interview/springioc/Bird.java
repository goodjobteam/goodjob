package com.mingzhi.interview.springioc;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//仅针对有两个类继承同一个接口的时候，为防止Spring不知道调用哪个类。使用@primary指定即可。
@Primary
public class Bird implements Pet {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("鸟儿，叽叽叽叽");

	}

}
