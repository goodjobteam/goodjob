package com.mingzhi.goodjob.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 参考小例子：https://blog.csdn.net/weixin_39723544/article/details/83382000
 * @author Administrator
 *	执行顺序 首先加载QuartzConfiguration   然后加载----根据容器中的触发器顺序取执行任务。
 *
 *  学习该知识点参考：https://blog.csdn.net/sinat_25295611/article/details/79353570
 *
 *
 */
//暂时注解掉，不让它执行调度任务。仅用于测试就行。
//@Configuration
public class QuartzConfiguration {
	// 使用jobDetail包装job
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(Myjob1.class).withIdentity("myJob").storeDurably().build();
    }

	// 把jobDetail注册到trigger上去
    @Bean
    public Trigger myJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

	// 使用jobDetail包装job
    @Bean
    public JobDetail myCronJobDetail() {
        return JobBuilder.newJob(MyCronJob.class).withIdentity("myCronJob").storeDurably().build();
    }

	// 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger CronJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(myCronJobDetail())
                .withIdentity("myCronJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
