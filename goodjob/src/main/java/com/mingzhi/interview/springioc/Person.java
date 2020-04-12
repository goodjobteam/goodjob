package com.mingzhi.interview.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//如果是使用单个BEAN文件则不需要下面的扫描。如果是需要扫描则实际类注入的时候就简单点。
@Component("person")
public class Person {

	@Value("慷慨")
	private String name;
	
	@Value("1")
	private int age;

	@Autowired
	private Pet pet;
	
	public void call() {
		pet.move();
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
