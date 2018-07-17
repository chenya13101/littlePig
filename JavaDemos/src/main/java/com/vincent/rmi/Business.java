package com.vincent.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Business extends Remote {

	public String echo(String content) throws RemoteException;
	// 不抛出异常则无法运行server的registry
}
