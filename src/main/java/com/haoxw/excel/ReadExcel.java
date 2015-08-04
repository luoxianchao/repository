package com.haoxw.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.lychie.jexcel.ReadableExcel;
import org.lychie.jexcel.exception.ValidationCastException;
import org.lychie.jexcel.validity.BasicValidation;
import org.lychie.jutil.Printer;

/**
 * 读取EXCEL文档
 * 
 * @date 2015-01-21
 * @author Lychie Fan
 */
public class ReadExcel {

	public static void main(String[] args) {

		// 创建一个可读的EXCEL对象
		ReadableExcel excel = new ReadableExcel(Person.class);
		// 设置POJO属性与EXCEL单元格的映射关系
		excel.setMapper("id", "编号");
		excel.setMapper("age", "年龄");
		excel.setMapper("sex", "性别");
		excel.setMapper("name", "姓名");
		excel.setMapper("date", "生日");
		// 载入EXCEL文档
		try {
			excel.load(new FileInputStream(new File("d:/persons.xlsx")));

			// 校验EXCEL文档内容的合法性
			excel.validate(new MyValidation());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		// 解析EXCEL文档成集合
		List<Person> list = excel.toList();
		// 打印输出集合的内容
		Printer.print(list);

	}

	private static class MyValidation extends BasicValidation {

		@Override
		public boolean validate(Class<?> type, String name, String value) {
			// 自定义校验规则, 在 super.validate 之前校验, 以达到短路父类校验规则的目的
			if (name.equals("age")) {
				Integer age = Integer.valueOf(value);
				if (age >= 18 && age < 55) {
					return true;
				} else {
					setCause("年龄不在 [18, 55) 区间");
					return false;
				}
			}
			// 最后调父类校验方法
			return super.validate(type, name, value);
		}

	}

}