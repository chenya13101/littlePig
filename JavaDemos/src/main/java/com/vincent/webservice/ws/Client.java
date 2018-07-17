package com.vincent.webservice.ws;

public class Client {
	public static void main(String[] args) {
		BusinessService service = new BusinessService();
		Business business = service.getBusinessPort();
		String response = business.echo("show me the money!!");
		System.out.println(response);
	}
}
