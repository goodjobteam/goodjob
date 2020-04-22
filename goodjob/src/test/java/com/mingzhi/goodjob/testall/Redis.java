package com.mingzhi.goodjob.testall;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class Redis {
	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Test
	public void set() {
		redisTemplate.opsForValue().set("myKey", "myValue");
		System.out.println(redisTemplate.opsForValue().get("myKey"));
	}
}
