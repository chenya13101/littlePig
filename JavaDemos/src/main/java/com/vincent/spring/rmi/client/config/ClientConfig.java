package com.vincent.spring.rmi.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.vincent.spring.rmi.common.service.StudentService;

@Configuration
@ComponentScan(basePackages = { "com.vincent.spring.rmi.client" })
public class ClientConfig {
	@Bean
	public RmiProxyFactoryBean spitterService() {
		RmiProxyFactoryBean proxyFactoryBean = new RmiProxyFactoryBean();
		proxyFactoryBean.setServiceUrl("rmi://localhost/StudentService");
		proxyFactoryBean.setServiceInterface(StudentService.class);
		return proxyFactoryBean;
	}
}