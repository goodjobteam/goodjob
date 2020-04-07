package com.mingzhi.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by 廖师兄
 * 2019-03-11 21:35
 */
@RestController
public class LuckymoneyController {
	
//@Autowired 是一个注释，它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作。
//	@Autowired 默认是按照类去匹配，配合 @Qualifier 指定按照名称去装配 bean
//	@Autowired不能跨包调用。需要单独注解处理。
	@Autowired
	private LuckmoneyRepository repository;

	@Autowired
	private LuckymoneyService service;

	/**
	 * 获取红包列表
	 */
	@GetMapping("/luckymoneys")
	public List<Luckymoney> list() {
		return repository.findAll();
	}

	/**
	 * 创建红包(发红包)
	 */
	@PostMapping("/luckymoneys")
	public Luckymoney create(@RequestParam("producer") String producer,
							 @RequestParam("money") BigDecimal money) {
		Luckymoney luckymoney = new Luckymoney();
		luckymoney.setProducer(producer);
		luckymoney.setMoney(money);
		return repository.save(luckymoney);
	}

	/**
	 * 通过id查询红包
	 */
	@GetMapping("/luckymoneys/{id}")
	public Luckymoney findById(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * 更新红包(领红包)
	 */
	@PutMapping("/luckymoneys/{id}")
	public Luckymoney update(@PathVariable("id") Integer id,
							 @RequestParam("consumer") String consumer) {
//		为了防止更新后其他值变为null 需要先根据ID查询出值再存进去。
		Optional<Luckymoney> optional = repository.findById(id);
//		判断不为null 则重新对内容set ，optional 为jdk8的新特性。 optional类是一个可以为null的容器对象，如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
//		Optional 是个容器：它可以保存类型T的值，或者仅仅保存null
//		optional.orElse(value); //如果对象的值为null时,则使用value
		if (optional.isPresent()) {
			Luckymoney luckymoney = optional.get();
			luckymoney.setConsumer(consumer);
			return repository.save(luckymoney);
		}

		return null;
	}

//	注意请求方式的不同。 GET请求获取列表和根据ID查信息。POST存储数据。PUT更新数据
	@PostMapping("/luckymoneys/two")
	public void createTwo() {
		service.createTwo();
	}
}
