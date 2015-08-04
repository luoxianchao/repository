package com.haoxw.excel;

import java.util.Date;
import org.lychie.jutil.DateUtil;
import org.lychie.jutil.RandomUtil;

public class Employee {

	private int id;
	private String name;
	private Date hiredate;
	private double salary;
	
	public Employee(String name){
		this.name = name;
		this.id = RandomUtil.intSeed(118100, 118199);
		this.salary = RandomUtil.intSeed(5000, 10000);
		this.hiredate = DateUtil.parse("1990/09/" + RandomUtil.intSeed(1, 30));
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public double getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}