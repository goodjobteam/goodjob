package com.mingzhi.luckymoney;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 廖师兄
 * 2019-03-11 21:38
 */
//  Luckymoney是数据库的实体类  第二个参数是id类型
public interface LuckmoneyRepository extends JpaRepository<Luckymoney, Integer> {
}
