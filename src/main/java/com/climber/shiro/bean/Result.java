package com.climber.shiro.bean;

public class Result<T> {
	
    private ResultCodeEnum code;
    
    private String message;
    
    private  T data;

    public ResultCodeEnum getCode() {
        return code;
    }

    public Result() {
    }

    public Result<T> setCode(ResultCodeEnum resultCode) {
        this.code = resultCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
