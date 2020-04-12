package com.mingzhi.interview.springioc;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("dog 汪汪汪！");
	}

}
