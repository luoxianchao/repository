package com.haoxw.excel;

import java.util.Date;
import org.lychie.jutil.DateUtil;

public class Person {
	
	private int id;
	private int age;
	private String sex;
	private String name;
	private Date date;

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + sex + "\t" + age + "\t"
				+ DateUtil.format(date);
	}

}