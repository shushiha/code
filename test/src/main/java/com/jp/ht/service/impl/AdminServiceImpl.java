package com.jp.ht.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.ht.mapper.AdminMapper;
import com.jp.ht.pojo.Admin;
import com.jp.ht.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminMapper adminMapper;
	@Override
	public Admin findByAdminId(Integer id) {
		return adminMapper.findByAdminId(id);
	}
	@Override
	public void register(String password,Integer privilege,String register) {
		
		adminMapper.add(password,privilege,register);
	}
	

}
