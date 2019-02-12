package com.climber.shiro.bean;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "登录成功";

    //成功
    public static <T> Result<T> genSuccessResult() {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> Result<T> genFailResult(String message) {
        return new Result<T>()
                .setCode(ResultCodeEnum.FAIL)
                .setMessage(message);
    }

    public static <T> Result<T> genUnauthorizedResult() {
        return new Result<T>()
                .setCode(ResultCodeEnum.UNAUTHORIZED)
                .setMessage("权限不足！");
    }
}
