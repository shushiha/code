package com.jp.ht.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jp.ht.pojo.Admin;

public interface AdminMapper {
	@Select("select * from admin_login_info where id=#{id}")
	Admin findByAdminId(Integer id);
	@Insert("insert into admin_login_info(password,auth,regist_date,update_date,register)"+
	         " values(#{password},#{privilege},now(),now(),#{register})")
	void add(String password,Integer privilege,String register);
}
