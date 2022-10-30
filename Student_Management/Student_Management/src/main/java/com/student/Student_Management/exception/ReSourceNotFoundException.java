package com.student.Student_Management.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ReSourceNotFoundException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	public ReSourceNotFoundException(String message) {
		super(message);
	}
}
