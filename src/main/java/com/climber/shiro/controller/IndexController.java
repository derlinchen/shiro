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
		Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
        	return ResultGenerator.genFailResult("登录失败");
        } else{
        	return ResultGenerator.genSuccessResult("helloworld");
        }
        
    }
	
	@PostMapping("/login")
    public Result<String> doLogin(String username, String password) {
		
		// 获取当前操作用户
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
        	UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        	try {
        		// 通过shiro对token进行验证
        		subject.login(token);
        	} catch (AuthenticationException e) {
        		token.clear();
        		return ResultGenerator.genFailResult("登录失败，用户名或密码错误！");
        	}
        	return ResultGenerator.genSuccessResult("登录成功");
        } else{
        	return ResultGenerator.genSuccessResult("登录成功");
        }
    }
	
	@GetMapping("/logout")
	public Result<String> logout(){
		try {
			Subject subject = SecurityUtils.getSubject();
		    subject.logout();
		} catch (Exception e) {
			return ResultGenerator.genFailResult("登出失败");
		}
		return ResultGenerator.genLogoutResult("登出成功");
	}
}
