package com.jp.ht.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jp.ht.pojo.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		e.printStackTrace();
		return Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失敗");//失敗結果メッセージ変更
	}
}
