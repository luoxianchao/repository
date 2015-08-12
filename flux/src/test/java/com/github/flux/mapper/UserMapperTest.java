package com.github.flux.mapper;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.flux.entity.Log;
import com.github.flux.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-application.xml")
public class UserMapperTest {

	@Resource
	private UserMapper userMapper;
	
	@Test
	public void save() throws Exception {
        User user = new User();
        user.setAccount(10l);
        user.setAddSum(10l);
        user.setCreateTime(System.currentTimeMillis());
        user.setGender(1);
        user.setIndustry("inde");
        user.setLogo("http://aa.jpg");
        user.setMobile("1501e108579");
        user.setNickname("xiaozhang");
        user.setSignature("fff");
        user.setSubSum(12l);
        user.setYear(201508);
		//userMapper.add(user);
        userMapper.add2(user);
	}
	
	
}
