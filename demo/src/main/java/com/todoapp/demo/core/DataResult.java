package com.todoapp.demo.core;

public class DataResult<T> extends Result{
	
	private T data;
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	public DataResult(boolean success, T data, String message) {
		super(success,message);
		this.data= data;
	}
	
	public T getData() {
		return this.data;
	}
	
}
