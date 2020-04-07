package com.mingzhi.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 * 2019-03-12 01:39
 */
@Service
public class LuckymoneyService {

	@Autowired
	private LuckmoneyRepository repository;

	/**
	 * 事务 指数据库事务
	 * 扣库存 > 创建订单
	 * 事务的操作一般都放在service处理
	 */
	@Transactional
	public void createTwo() {
		Luckymoney luckymoney1 = new Luckymoney();
		luckymoney1.setProducer("廖师兄");
		luckymoney1.setMoney(new BigDecimal("520"));
		repository.save(luckymoney1);
//通过修改数据库字段的长度，模拟520正常存储，1314因为超过长度存储失败，事务回退，都不存储。
		Luckymoney luckymoney2 = new Luckymoney();
		luckymoney2.setProducer("廖师兄");
		luckymoney2.setMoney(new BigDecimal("1314"));
		repository.save(luckymoney2);
	}
}
