package com.vincent.spring.rmi.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.vincent.spring.rmi.common.service.StudentService;

@Configuration
@ComponentScan(basePackages = { "com.vincent.spring.rmi.server" })
public class ServerConfig {

	@Bean
	public RmiServiceExporter rmiExporter(StudentService service) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(service);
		// serviceName属性用来在RMI注册表中注册一个服务
		exporter.setServiceName("StudentService");
		exporter.setServiceInterface(StudentService.class);
		return exporter;
	}
}
