package com.vincent.rmi;

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
