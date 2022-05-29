package com.stock.Exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExeception extends RuntimeException {

	public UserNotFoundExeception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
