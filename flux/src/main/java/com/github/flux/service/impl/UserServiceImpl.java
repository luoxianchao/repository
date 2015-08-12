package com.github.flux.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.flux.entity.Log;
import com.github.flux.entity.User;
import com.github.flux.mapper.UserMapper;
import com.github.flux.plugin.mybatis.plugin.PageView;
import com.github.flux.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public PageView query(PageView pageView, User t) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", t);
		List<User> list = userMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<User> queryAll(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		userMapper.delete(id);
	}

	@Override
	public void update(User t) throws Exception {
		// TODO Auto-generated method stub
		userMapper.update(t);
	}
	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return userMapper.getById(id);
	}

	@Override
	public void add(User t) throws Exception {
		// TODO Auto-generated method stub
		userMapper.add(t);
	}

}
