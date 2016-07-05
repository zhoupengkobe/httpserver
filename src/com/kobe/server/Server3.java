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
public class Server3 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server3 server = new Server3();
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
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP第一个</title></head><body>Hello Tomcat!</body></html>");
			
			
			StringBuilder response = new StringBuilder();
			//1)HTTP协议版本，状态码，描述
			response.append("HTTP:/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2)响应头（Response Head）
			response.append("Server:kobe Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//正文长度：字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//正文之前
			response.append(CRLF);
			//正文
			response.append(responseContext);
			
			//输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * 停止服务器
	 */
	public void stop(){
		
	}

}
