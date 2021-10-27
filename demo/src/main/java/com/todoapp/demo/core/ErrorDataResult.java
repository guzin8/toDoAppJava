package com.todoapp.demo.core;

public class ErrorDataResult<T> extends DataResult<T> {
	
	public ErrorDataResult(T data, String message) {
		super(false,data,message);
	}
	
	public ErrorDataResult(T data) {
		super(data,false);
	}
	
	public ErrorDataResult() {
		super(null,false);
	}
	
	public ErrorDataResult(String message) {
		super(false,null,message);
	}

}
