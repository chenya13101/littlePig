package com.vincent.io.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest_BIO_Client {

	public static void main(String[] args) {
		SocketTest_BIO_Client client = new SocketTest_BIO_Client();
		client.init();
	}

	private void init() {
		Socket socket = null;
		BufferedReader reader = null;
		try {
			socket = new Socket("localhost", 19234);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			// 向server输出
			int i = 0;
			do {
				writer.println("client println" + i);
			} while (i++ < 5);

			// 打印输入内容
			int j = 0;
			do {
				String readContent = reader.readLine();
				System.out.println(readContent);
			} while (j++ < 5);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
