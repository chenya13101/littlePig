package com.vincent.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * 运行HelloServer 在命令行输入telnet 127.0.0.1 9123
 * 
 * @author WenSen
 * @date 2018年7月16日 下午5:52:11
 *
 */
public class HelloServer {

	private static final int PORT = 9123;

	public static void main(String[] args) {
		// 监听连接的对象
		IoAcceptor acceptor = new NioSocketAcceptor();
		// 配置过滤器
		// logger过滤器会输出所有的信息，例如新创建的会话、消息的接收、消息的发送、会话的关闭
		// codec过滤器会转换二进制活协议规定的数据为消息对象，这里是处理基于文本的消息
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		//
		acceptor.setHandler(new TimeServerHandler());
		// 设置输入缓冲区的大小和会话的IDLE熟悉
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		try {
			acceptor.bind(new InetSocketAddress(PORT));
			System.out.println("HelloServer started on port " + PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * * HelloServer 处理逻辑 *
 */
class TimeServerHandler extends IoHandlerAdapter {
	// 当有异常发生时触发

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();

		session.close(true);
		// session.close();
	} // 收到来自客户端的消息

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 来至客户端信息
		String str = message.toString();
		// 来至客户端ip信息
		String ip = session.getRemoteAddress().toString();
		System.out.println("===> Message From " + ip + " : " + str);
		session.write("Hello,Client " + ip);
		// 接受客户端字符串"quit"关闭当前会话连接
		if (str.trim().equalsIgnoreCase("quit")) {
			session.close(true);
			return;
		}
		// Calendar time = Calendar.getInstance();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// session.write(df.format(time.getTime()));
		// System.out.println("Time Message written...");
	} // 连接被关闭时触发

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("session closed from " + session.getRemoteAddress().toString());
	} // 有新连接时触发

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("session open for " + session.getRemoteAddress());
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// System.out.println("IDLE "+session.getIdleCount(status));
	}

}
