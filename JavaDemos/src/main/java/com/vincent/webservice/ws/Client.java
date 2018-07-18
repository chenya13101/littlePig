package com.vincent.webservice.ws;

public class Client {
	public static void main(String[] args) {
		BusinessService service = new BusinessService();
		Business business = service.getBusinessPort();
		System.out.println("两个业务类都是调用 wsimport生成的客户端辅助类");
		String response = business.echo("show me the money!!");
		System.out.println(response);
	}
}
