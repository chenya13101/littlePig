package com.vincent.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) {
		int port = 19527; // 这个端口可以变化
		int registryPort = 1099; // 这个改成其他接口会报错，应该是默认值
		String name = "businessDemo";
		Business business = new BusinessImpl();
		try {
			UnicastRemoteObject.exportObject(business, port);
			Registry registry = LocateRegistry.createRegistry(registryPort);
			registry.rebind(name, business);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
