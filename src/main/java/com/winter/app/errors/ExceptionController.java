package com.winter.app.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public String handler1() {
		return "errors/error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handler2() {
		return "errors/error";
	}
	@ExceptionHandler(RuntimeException.class)
	public String handler3() {
		return "errors/error";
	}
	
	@ExceptionHandler(Throwable.class)
	public String handler4() {
		return "errors/error";
	}
}
