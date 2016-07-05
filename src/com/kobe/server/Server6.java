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
public class Server6 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server6 server = new Server6();
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
			Servlet serv = new Servlet();
			//请求
			Request req=new Request(client.getInputStream());
			//响应
			Response rep = new Response(client);
			
			serv.service(req, rep);
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
