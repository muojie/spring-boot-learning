package com.kfit.task;

import java.util.Date;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import com.kfit.service.HelloService;

@Service
public class MyTask extends BaseTask{
	@Resource
	private HelloService helloService;
	
	
	@Override
//	public Class<? extends Job> getJobClass() {
//		return this.getClass();
//	}
	
//	public JobKey getJobKey(){
//		return new JobKey("MyTask_job", "MyTask_group");
//	}
	
	public String getCronExpression(){
		helloService.hello();
		return "0/3 * * * * ?";
	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("MyTask.execute().date="+new Date());
		helloService.hello();
	}
	
}
