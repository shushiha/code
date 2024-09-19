package com.jp.ht.pojo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Admin {
	private Integer id;
	private String password;
	private Integer auth;
	private LocalDateTime loginDate;
	private String register;
	private LocalDateTime updateDate;
	private String updater;
}
