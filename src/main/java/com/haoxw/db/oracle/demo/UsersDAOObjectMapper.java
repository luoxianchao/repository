package com.haoxw.db.oracle.demo;

import java.sql.ResultSet;

import com.haoxw.db.oracle.base.ObjectMapper;

class UsersDAOObjectMapper implements ObjectMapper{  
    public Object mapping(ResultSet rs){  
        Users u=new Users();      
            try{  
                u.setId(rs.getString("id"));  
                u.setAge(rs.getString("age"));  
                u.setName(rs.getString("name"));  
                  
            }catch(Exception ex){  
                ex.printStackTrace();  
            }  
  
        return u;  
    }  
      
}  