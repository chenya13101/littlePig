package com.vincent.webservice.server;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "business", serviceName = "BusinessService", targetNamespace = "http://webservice.vincent.com/ws")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BusinessImpl implements Business {

	@Override
	public String echo(String content) {
		if ("quit".equalsIgnoreCase(content)) {
			System.exit(0);
		}

		System.out.println("From client :" + content);
		return "Server response: Received content:" + content;
	}

}
