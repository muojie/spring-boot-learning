# spring-boot-learning

MyBatis: 持久化    -> Spring Data JPA (hibernate)

定时任务:

1. JDK自带的Timer + TimerTask            //debug用
2. Spring的Scheduled Task，一个轻量级的定时任务调度器      //ThreadPoolTaskScheduler
//以上两种方式有一个共同的缺点，那就是应用服务器集群下会出现任务多次被调度执行的情况，因为集群的节点之间是不会共享任务信息的，每个节点上的任务都会按时执行。
3. Quartz等     //它支持集群环境下的任务调度，当然代价也很大，需要将任务调度状态序列化到数据库。Quartz框架需要10多张表协同，配置繁多。

对于Quartz与Spring的整合问题，spring其实提供了很多内建方案：
第一种方式：使用org.springframework.scheduling.quartz.JobDetailBean+jobDataAsMap
第二种方式：使用org.springframework.scheduling.quartz.SchedulerFactoryBean+schedulerContextAsMap
第三种方式：使用org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean：这个可以让任何定义在spring中的类成为Quartz要求的job。
第四种方式：使用org.springframework.scheduling.quartz.SchedulerFactoryBean+applicationContextSchedulerContextKey：比如这个
代码使用的方式是：org.springframework.scheduling.quartz.SchedulerFactoryBean+AutowireCapableBeanFactory，这种方式使用起来比较灵活，但是不见得是最优的。
