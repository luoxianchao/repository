package com.haoxw.db.oracle;

import java.util.List;

import org.junit.Test;

import com.haoxw.db.oracle.base.DbcpPool;
import com.haoxw.db.oracle.base.PageModel;
import com.haoxw.db.oracle.demo.Users;
import com.haoxw.db.oracle.demo.UsersDao;

public class UserTest {  
    DbcpPool dbConn = DbcpPool.getInstance();  
  
  
    /************测试插入记录***************/  
  
  @Test  
  public void testinsert() {  
      UsersDao usersdao = new UsersDao();  
      for(int i=0;i<20;i++){  
      Users u = new Users();  
      u.setId(""+i);  
      u.setName("郝学武123");  
      u.setAge("2"+i);  
      boolean b=usersdao.insert(u);  
      if(b==false){  
          System.out.println("插入失败");  
      }else{  
          System.out.println("插入成功");  
      }}  
        
  
  }  
    /************测试修改记录***************/  
  
  @Test  
  public void testupdate() {  
      UsersDao usersdao = new UsersDao();  
      Users u = new Users();  
      u.setId("5");  
      u.setName("郝学武123123123123");  
      u.setAge("31");  
      boolean b=usersdao.update(u);  
      if(b==false){  
          System.out.println("更新失败");  
      }else{  
          System.out.println("更新成功");  
      }  
        
  
  }  
    /************测试删除单条记录***************/  
  
  @Test  
  public void testdeleteById() {  
	  UsersDao usersdao = new UsersDao();
      boolean b=usersdao.delete("2");  
      if(b==false){  
          System.out.println("删除失败");  
      }else{  
          System.out.println("删除成功");  
      }  
        
  }  
  
  @Test  
  public void testfindById() {  
	  UsersDao usersdao = new UsersDao();
	  Users u=usersdao.query("2"); 
      if(u==null){  
          System.out.println("查询失败");  
      }else{  
          System.out.println(u.toString());  
      }  
        
  }  
    /************测试批量删除记录***************/  
  
  @Test  
  public void testdeleteByArray() {  
      UsersDao usersdao = new UsersDao();
      String[] s={"3","4","5"};  
      boolean b=usersdao.delete(s);  
      if(b==false){  
          System.out.println("删除失败");  
      }else{  
          System.out.println("删除成功");  
      }  
        
  }  
    /*********查询全部记录结果集为泛型 ************/  
  @Test  
  public void testqueryAll0(){  
	  UsersDao usersdao = new UsersDao();
      List<Users> list=usersdao.query();  
      for(Users u:list){  
          System.out.println(u.getId());  
      }  
  }  
    /*********查询单条记录结果集为对象 ************/  
  @Test  
  public void testqueryAll1(){  
      UsersDao usersdao = new UsersDao();  
      Users u=usersdao.query("7");  
      System.out.println(u.getName());  
        
  }  
  /*********分页查询全部记录结果集为pagemodel************/  
  @Test  
  public void testqueryAll2(){  
	  UsersDao usersdao = new UsersDao(); 
      PageModel pml=usersdao.query(2,2);  
      List<Users> list=pml.getList();  
      for(Users u:list){  
          System.out.println(u.toString());  
      }  
  }  
    /*********分页模糊查询全部记录结果集为pagemodel************/  
    @Test  
    public void testqueryAll(){  
        UsersDao usersdao = new UsersDao();  
        PageModel pml=usersdao.query(1,10,"郝学武");  
        List<Users> list=pml.getList();  
        for(Users u:list){  
            System.out.println(u.toString());  
        }  
    }  
    
    @Test  
    public void testcount(){  
        UsersDao usersdao = new UsersDao();  
        long l=usersdao.count();  
        System.out.println(l);  
          
    }  
  
}  