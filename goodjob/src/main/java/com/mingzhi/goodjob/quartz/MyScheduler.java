package com.mingzhi.goodjob.quartz;

import java.text.SimpleDateFormat;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @author wiser-zhi
 *
 *         调度任务小例子
 *
 *         quartz的使用必须掌握下面三个对象
 * 
 *         Scheduler 定时器对象 
 *         JobDetail 任务对象 
 *         Trigger 触发器对象
 *         SimpleTrigger 简单触发器
 *         CornTrigger任务调度触发器
 *
 *			本例子为单例模式。建议实际参考整合到Spring容器中的使用方式
 *
 */
public class MyScheduler {

	public static void main(String[] args) throws SchedulerException {
		
		
		//定时器对象
		 Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		 //定义一个工作对象 设置工作名称与组名
		 JobDetail job =JobBuilder.newJob(Myjob.class).withIdentity("今日的执行任务","group1工作组1").build();		 
        //定义一个触发器 简单Trigger 设置工作名称与组名 5秒触发一次
		 Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();
		 //定义一个任务调度的Trigger 设置工作名称与组名 每天的24:00触发一次
		 //Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?")).build();
		 //设置工作 与触发器
		 scheduler.scheduleJob(job, trigger);
		 // and start it off
		 //开始定时任务
        scheduler.start();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
////		创建一个Trigger实例，将该实例与Myjob class绑定
//		JobDetail jobDetail=JobBuilder.newJob(Myjob.class).withIdentity("myJob","group1").build();
//
////		创建一个Trigger实例，定义该Job立即执行，并且每隔两秒中重复一次
//		Trigger trigger=TriggerBuilder.newTrigger().
//				withIdentity("myTrigger","group1")
//				.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
//				.withIntervalInSeconds(5).repeatForever()).build();
//		SchedulerFactory sf =new StdSchedulerFactory();
//		Scheduler scheduler=sf.getScheduler();
//		scheduler.start();
//		
//		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		scheduler.scheduleJob(jobDetail, trigger);


		

	}
	
}
