package com.climber.shiro.config;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.climber.shiro.service.ShiroService;

public class ShiroRealm extends AuthorizingRealm {
	
	@Resource
    public ShiroService shiroService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户账号
        String username = token.getPrincipal().toString();
        
        String password = String.valueOf((char[]) token.getCredentials());

        String getpassword = shiroService.getPasswordByUsername(username);
        
        if (password.equals(getpassword)) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    username,   //认证通过后，存放在session,一般存放user对象
                    password,   //用户数据库中的密码
                    getName());    //返回Realm名
            return authenticationInfo;
        }
        return null;
	}

}
