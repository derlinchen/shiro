package com.climber.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	/**
	 * 自定义的Realm
	 */
	@Bean(name = "shiroRealm")
	public ShiroRealm shiroRealm() {
		ShiroRealm shiroRealm = new ShiroRealm();
		return shiroRealm;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		return securityManager;
	}

	@Bean(name = "shiroFilterFactoryBean")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 定义请求拦截器
		// Map<String, String> map = new HashMap<String, String>();
		// // 登出
		// map.put("/logout", "logout");
		// // 对所有用户认证
		// map.put("/**", "authc");
		// // 登录
		// shiroFilterFactoryBean.setLoginUrl("/login");
		// // 首页
		// shiroFilterFactoryBean.setSuccessUrl("/index.html");
		// // // 错误页面，认证不通过跳转
		// // shiroFilterFactoryBean.setUnauthorizedUrl("/error");
		// shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
}
