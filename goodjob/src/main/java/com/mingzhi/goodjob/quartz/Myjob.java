package com.mingzhi.goodjob.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Myjob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		//打印当前的执行时间，格式为yyyy-MM-dd HH:mm:ss
				// 编写具体的业务逻辑。
				Date date=new Date();
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//规范格式
				System.out.print("Hello World1!------------");
				System.out.println("当前时间为："+sf.format(date));
				
				

		
	}

}
