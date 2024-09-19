package com.jp.ht.service;

import com.jp.ht.pojo.User;

public interface UserService {


	void register(User user);

	User findByUserId(Integer loginId);

	void update(User user);



	
	

}
