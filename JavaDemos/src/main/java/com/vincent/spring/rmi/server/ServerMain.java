package com.vincent.spring.rmi.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vincent.spring.rmi.server.config.ServerConfig;

public class ServerMain {
	public static void main(String[] args) {
		
		
		String remark = "RmiServiceExporter 类是spring封装了java rmi 的服务发布类，" + "\n代码中没有指定发布ip和端口，默认发布在本地，和发布在默认端口1099。"
				+ "\nsetServiceName方法是在RMI注册表中注册一个服务，只需要指定服务接口，即可完成最简单的远程调用服务发布。";
		System.out.println(remark);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ServerConfig.class);
		System.out.println("服务发布已发布:" + applicationContext.getApplicationName());
	}
}
