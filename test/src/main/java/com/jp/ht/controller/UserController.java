package com.jp.ht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.ht.pojo.Result;
import com.jp.ht.pojo.User;
import com.jp.ht.service.UserService;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	@Autowired
	private UserService userService;

	 @PostMapping
	    public Result register(@RequestBody @Validated User user) {
		 userService.register(user);
		 return Result.success();
		
	    }

	 @GetMapping
		public Result<User> userInfo(@RequestParam Integer loginId) {
			User user = userService.findByUserId(loginId);
			return Result.success(user);
		}
	 @PutMapping
		public Result update(@RequestBody @Validated User user) {
			userService.update(user);
			return Result.success();
			}
	 

}

