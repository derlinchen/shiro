package com.climber.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.climber.shiro.bean.Result;
import com.climber.shiro.bean.ResultGenerator;

@RestController
public class IndexController {
	@GetMapping("/helloworld")
    public Result<String> helloWorld() {
        return ResultGenerator.genSuccessResult("helloworld");
    }
	
	@PostMapping("/doLogin")
    public Result<String> doLogin(String username, String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return ResultGenerator.genFailResult("登录失败，用户名或密码错误！");
        }
        return ResultGenerator.genSuccessResult("登录成功");
    }
}
