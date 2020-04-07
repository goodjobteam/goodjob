package com.mingzhi.wiser;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WiserMain {

	public static void main() {

		System.out.println("hello wiser");

	}
	
	public String test() {
		
		
		System.out.println("hello wiser");

		return "success";
	}

}
