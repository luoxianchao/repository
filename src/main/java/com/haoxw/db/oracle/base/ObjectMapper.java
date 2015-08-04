package com.haoxw.db.oracle.base;

import java.sql.ResultSet;

public interface ObjectMapper {  
    public Object mapping(ResultSet rs);  
  
} 
