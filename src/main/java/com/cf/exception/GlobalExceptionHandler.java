package com.cf.exception;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cf.result.CodeMsg;
import com.cf.result.Result;

 //系统异常的处理方法

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof GlobalException) {   //如果继承自全局异常
			GlobalException ex = (GlobalException) e;
			return Result.error(ex.getCm());
		}else if(e instanceof BindException) { //如果继承自绑定异常
			BindException ex = (BindException) e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {            //否则就是服务器异常
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}
