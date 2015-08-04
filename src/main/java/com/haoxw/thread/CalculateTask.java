package com.haoxw.thread;

import java.util.concurrent.Callable;

/**
 * 求从1到X相加之和
 * @author haoxw
 *
 */
public class CalculateTask implements Callable<Long> {
	private long seed = 0;
	public CalculateTask(long seed){
		this.seed = seed;
	}
	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long temp = 0;
		for(int i=1;i<=seed;i++){
			temp = temp+i;
		}
		return temp;
	}

}
