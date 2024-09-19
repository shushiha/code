package com.jp.ht.service.impl;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.ht.mapper.UserMapper;
import com.jp.ht.pojo.User;
import com.jp.ht.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public void register(User user) {
		
		userMapper.add(user);
	}

	@Override
	public User findByUserId(Integer loginId) {
		return userMapper.findByUserId(loginId);
	}

	@Override
	public void update(User user) {
		user.setUpdateDate(LocalDateTime.now());
		userMapper.update(user);
	}


	

	


	

}
