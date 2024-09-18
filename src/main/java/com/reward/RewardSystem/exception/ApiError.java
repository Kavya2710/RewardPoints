package com.reward.RewardSystem.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private String message;
	private String error;

	public ApiError(HttpStatus status, String message, String string) {
		super();
		this.status = status;
		this.message = message;
		this.error = string;
	}
	
	
}
