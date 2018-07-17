package com.vincent.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			String name = "businessDemo";
			Business business = (Business) registry.lookup(name);

			for (int i = 0; i < 5; i++) {
				System.out.println(business.echo("bu qu wang ba" + i));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
