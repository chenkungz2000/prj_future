package com.change.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 */
@Component
// 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class annotationDemo {
	Logger logger = LoggerFactory.getLogger(annotationDemo.class);

	@Scheduled(fixedDelay = 50000)
	// 触发源
	// 在上一个任务完成之后，5s后再次执行
	public void demo1() {

		logger.info("定时任务demo1开始......");
		long begin = System.currentTimeMillis();
		// 执行你需要操作的定时任务
		try {
			System.out.println("AA");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		logger.info("定时任务demo1结束，共耗时：[" + (end - begin) + "]毫秒");
	}

	@Scheduled(fixedRate = 50000)
	// 从上一任务开始执行后5s再次调用：
	public void demo2() {
		logger.info("定时任务demo2开始.");
		long begin = System.currentTimeMillis();
		// 执行你需要操作的定时任务
		System.out.println("BB");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		logger.info("定时任务demo2结束，共耗时：[" + (end - begin) + "]毫秒");
	}

	@Scheduled(cron = "0 34 13 * * ?") // 如果你需要在特定的时间执行，就需要用到cron 了
	// 这里是在每天的13点30分执行一次
	public void demo3() {
		logger.info("定时任务demo3开始.");
		long begin = System.currentTimeMillis();
		// 执行你需要操作的定时任务
		System.out.println("CC");
		try {
			System.out.println("CC");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		logger.info("定时任务demo3结束，共耗时：[" + (end - begin) + "]毫秒");
	}
}