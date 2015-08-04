package com.haoxw.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String args[]) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(20);
		List<Future<Long>> resultList = new ArrayList<Future<Long>>();
		long tempRes = 0;
		for (int i = 0; i < 100; i++) {
			Future res = service.submit(new CalculateTask(Long.valueOf(i)));
			System.out.println(res.get()); // 打印各个线程（任务）执行的结果
			resultList.add(res);
		}
		service.shutdown();
		while (!service.awaitTermination(1, TimeUnit.MILLISECONDS)) {  
		    System.out.println("线程池没有关闭");  
		}  
		System.out.println("线程池已经关闭");  
	}
}
