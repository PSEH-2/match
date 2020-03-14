package com.sapient.match.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class InvalidMatchUniqueIdException extends RuntimeException{
	
	public InvalidMatchUniqueIdException(String msg){
		super(msg);
	}

}
