package com.vincent.webservice.server;

import javax.xml.ws.Endpoint;

public class Server {
	public static void main(String[] args) {
		String wsdlUrl = "http://localhost:9527/BusinessService";
		Endpoint.publish(wsdlUrl, new BusinessImpl());
		System.out.println("Server started!");
		System.out.println("在浏览器中可以看到wsdl,输入: " + wsdlUrl + "?wsdl");

		System.out.println("wsimport生成辅助代码的命令为:" + "wsimport -keep http://localhost:9527/BusinessService?wsdl");
		// TODO rmi的缺點是什麽缺点
		System.out.println("rmi的缺點是什麽缺点");
	}
}
