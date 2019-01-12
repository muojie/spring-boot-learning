package com.kfit;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);

		Scheduler scheduler = ctx.getBean(Scheduler.class);
		try {
			Thread.sleep(40000);
			scheduler.deleteJob(new JobKey("MyTask_job","MyTask_group"));
			System.out.println("App.main().deleteJob");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
