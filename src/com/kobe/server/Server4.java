package com.kobe.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器，并启动
 * 1.请求
 * 2.相应
 * @author ko
 *
 */
public class Server4 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server4 server = new Server4();
		server.start();
		
	}
	/**
	 * 启动方法
	 */
	public void start(){
		
		try {
			server = new ServerSocket(8888);		
			this.receive();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 接收客户端
	 */
	private void receive(){
		try {
			Socket client = server.accept();
			String msg = null;//接收客户端的请求信息
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			//接收客户端的请求信息
			String requestInfo = new String(data, 0, len).trim();//去掉多余的空格
			System.out.println(requestInfo);
			//响应
			Response rep = new Response(client);
			rep.println("<html><head><title>HTTP第一个</title>");
			rep.println("</head><body>Hello Tomcat!</body></html>");
			rep.pushToClient(200);
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * 停止服务器
	 */
	public void stop(){
		
	}

}
