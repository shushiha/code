package com.jp.ht.service;


import com.jp.ht.pojo.Admin;

public interface AdminService {

	Admin findByAdminId(Integer id);

	void register(String password,Integer privilege,String register);

}
