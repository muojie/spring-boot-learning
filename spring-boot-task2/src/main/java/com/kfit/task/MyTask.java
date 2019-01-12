package com.kfit.task;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
MyTask.tast1()
MyTask.tast1()
MyTask.tast1()
MyTask.tast2()
MyTask.tast1()
------------------------------

tast1: 每10秒打印1次.
task2: 每1分钟打印1次.
-----------------------
1分钟是60秒 = 没打印6次task1之后才能够打印1次task2.

--------------------------
spring task 在计算时间的时候，是根据当前服务器的系统时间进行计算.
如果是每10秒执行一次的话，那么它是从系统时间的0,10,20秒进行计算的.
如果是每1分钟执行一次的话，那么它是从系统时间的1分钟，2分钟进行计算的。

如果是这样的话，那么我会碰到这样的情况：就是当我们刚刚启动程序的时候，我们的时间

刚好是9:39:55秒，那么就会出现5秒之后会执行1次task1和1次task2.

 
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年3月26日
 */
@Configuration
@EnableScheduling
public class MyTask {
	
	/**
	 * 我们希望这个方法每10秒打印一次.
	 * cron: 定时任务表达式.
	 * 
	 * 指定 ：秒，分钟，小时，日期，月份，星期，年（可选）.
	 * *：任意.
	 * 
	 */
	@Scheduled(cron="0/2 * * * * *")
//  @Scheduled(cron="0/10 * * * * ?")
//	@Scheduled(fixedDelay = 3000)
	public void tast1(){
		Date d = new Date();
		System.out.println("MyTask.tast1(),"+d);
		try {
			Thread.sleep(1000);
			System.out.println("MyTask.tast1(),"+d+".end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 我们希望这个方法每1分钟打印一次.
	 */
//	@Scheduled(cron="0 0/1 * * * *")
//	public void tast2(){
//		System.out.println("MyTask.tast2(),"+new Date());
//	}

	
//	@Scheduled(fixedDelay = 3000)
//	public void tast3(){
//		Date d = new Date();
//		System.out.println("MyTask.tast3(),"+d);
//		try {
//			Thread.sleep(6000);
//			System.out.println("MyTask.tast3(),"+d+".end");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Scheduled(fixedRate  = 3000)
//	public void tast4(){
//		Date d = new Date();
//		System.out.println("MyTask.tast4(),"+d);
//		try {
//			Thread.sleep(4000);
//			System.out.println("MyTask.tast4(),"+d+".end");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
}
