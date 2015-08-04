package com.haoxw.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.lychie.jexcel.WritableExcel;

public class WriteExcel {

    public static void main(String[] args) {

        // 创建一个可写的EXCEL对象
        WritableExcel excel = new WritableExcel(getData());
        excel.getTitle().setBackgroundColor((short)12);
        // 设置POJO属性与EXCEL单元格的映射关系
        excel.setMapper("id", "编号");
        excel.setMapper("name", "姓名");
        excel.setMapper("hiredate", "入职日期");
        excel.setMapper("salary", "薪资");
        // 将对象内容写出到EXCEL文档
        excel.write(new File("c:/write.xlsx"));

    }

    private static List<Employee> getData() {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("杨忠杰"));
        list.add(new Employee("叶水燕"));
        list.add(new Employee("杨晓婷"));
        list.add(new Employee("叶国珠"));
        list.add(new Employee("何国群"));
        return list;
    }

}