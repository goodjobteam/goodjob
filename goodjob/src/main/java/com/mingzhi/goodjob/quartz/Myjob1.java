package com.mingzhi.goodjob.quartz;

import java.time.LocalDateTime;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Myjob1 extends QuartzJobBean {

	 @Override
	    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
	        System.out.println("start My Job：" + LocalDateTime.now());
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("end  My Job：" + LocalDateTime.now());

	    }
	
}
