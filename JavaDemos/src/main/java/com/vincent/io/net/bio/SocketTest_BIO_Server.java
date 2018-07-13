package com.vincent.io.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest_BIO_Server {

	public static void main(String[] args) {
		SocketTest_BIO_Server client = new SocketTest_BIO_Server();
		client.init();
	}

	private void init() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader reader = null;
		try {
			serverSocket = new ServerSocket(19234);
			socket = serverSocket.accept();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			int i = 0;
			do {
				String readContent = reader.readLine();
				System.out.println(readContent);
			} while (i++ < 5);

			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			int j = 0;
			do {
				writer.println("server writer println" + j);
			} while (j++ < 5);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
