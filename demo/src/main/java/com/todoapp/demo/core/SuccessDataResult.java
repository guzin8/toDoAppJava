package com.todoapp.demo.core;

public class SuccessDataResult<T> extends DataResult<T>{
	
	public SuccessDataResult(T data, String message) {
		super(true,data,message);
	}
	
	public SuccessDataResult(T data) {
		super(data,true);
	}
	
	public SuccessDataResult() {
		super(null,true);
	}
	
	public SuccessDataResult(String message) {
		super(true,null,message);
	}

}
