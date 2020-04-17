package com.mingzhi.goodjob.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * 
 * @author Administrator
 *
 *         1、scheduler是一个计划调度器容器，容器里面可以盛放众多的JobDetail和trigger，当容器启动后，里面的每个JobDetail都会根据trigger按部就班自动去执行。
 * 
 *         2、JobDetail是一个可执行的工作，它本身可能是有状态的。
 * 
 *         3、Trigger代表一个调度参数的配置，什么时候去调。
 * 
 *         4、当JobDetail和Trigger在scheduler容器上注册后，形成了装配好的作业（JobDetail和Trigger所组成的一对儿），就可以伴随容器启动而调度执行了。
 * 
 *         5、scheduler是个容器，容器中有一个线程池，用来并行调度执行每个作业，这样可以提高容器效率。
 *
 *		Quartz定时任务，利用Schedule计划调度容器将Trigger触发器配置的执行时间去调度执行对用的JobDetail （job需要继承QuartzJobBean类）
 *
 *
 *
 */
public class MyCronJob extends QuartzJobBean {

//	@Autowired
//    IndexController indexController;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务执行了" + new Date());
        // indexController.testMail();
    }
}
