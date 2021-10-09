package com.team.rbad.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.team.rbad.base.TranResponse;
import com.team.rbad.enums.ReturnCode;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.util.TranResponseFactory;

@RestControllerAdvice
public class WebExceptionHandler {
	
	@Autowired
	private TranResponseFactory tranResponseFactory;

	/** DataNotFoundException */
	@ExceptionHandler(value = DataNotFoundException.class)
	public <T> TranResponse<T> handleDataNotFoundException(){
		return tranResponseFactory.genFailResponse(null, ReturnCode.C002);
	}
}
