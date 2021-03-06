package com.kfit;

import java.util.concurrent.TimeUnit;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.kfit.job.HelloJob;

/**
 * 直接在Main方法中进行启动测试.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年4月21日
 */
public class App {
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		/*
		 *在 Quartz 中， scheduler 由 scheduler 工厂创建：DirectSchedulerFactory 或者 StdSchedulerFactory。 第二种工厂 StdSchedulerFactory 使用较多，
		 *因为 DirectSchedulerFactory 使用起来不够方便，需要作许多详细的手工编码设置。 
		 */
		// 获取Scheduler实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		System.out.println("scheduler.start");
		System.out.println(scheduler.getSchedulerName());
		
		//具体任务.
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();
		
		//触发时间点. (每5秒执行1次.)
		SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();
		
		// 交由Scheduler安排触发
		scheduler.scheduleJob(jobDetail,trigger);
		
		
		//睡眠20秒.
		TimeUnit.SECONDS.sleep(20);
		scheduler.shutdown();//关闭定时任务调度器.
		System.out.println("scheduler.shutdown");
	}
}
