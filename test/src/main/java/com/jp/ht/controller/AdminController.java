package com.jp.ht.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.ht.pojo.Admin;
import com.jp.ht.pojo.Result;
import com.jp.ht.service.AdminService;
import com.jp.ht.utils.JwtUtil;
@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	@Autowired
	AdminService adminService;
	@PostMapping("/register")
	public Result register(@Pattern(regexp = "^\\S{5,16}$") String password,@RequestParam Integer privilege,
			@RequestParam String register) {
			adminService.register(password,privilege,register);
			return Result.success();
	
	}
	@PostMapping("/login")
	public Result<String> login(@RequestParam Integer loginId,
			@Pattern(regexp = "^\\S{5,16}$") String password) {
		Admin loginAdmin = adminService.findByAdminId(loginId);
		if (loginAdmin == null) {
			return Result.error("ログインIDが間違っています");
		}
		if (password.equals(loginAdmin.getPassword())) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("id", loginAdmin.getId());
			claims.put("auth", loginAdmin.getAuth());
			String token = JwtUtil.genToken(claims);
			return Result.success(token);
		}
		return Result.error("パスワードが間違ってます");
	}
}
