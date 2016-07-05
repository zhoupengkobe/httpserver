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
 * ������������������
 * 1.����
 * 2.��Ӧ
 * @author ko
 *
 */
public class Server5 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server5 server = new Server5();
		server.start();
		
	}
	/**
	 * ��������
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
	 * ���տͻ���
	 */
	private void receive(){
		try {
			Socket client = server.accept();
			//����
			Request req=new Request(client.getInputStream());
			//��Ӧ
			Response rep = new Response(client);
			rep.println("<html><head><title>HTTP��һ��</title>");
			rep.println("</head><body>");
			rep.println("��ӭ��").println(req.getParameter("uname")).println("������!");
			rep.println("</body></html>");
			rep.pushToClient(200);
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * ֹͣ������
	 */
	public void stop(){
		
	}
	
	
	

}
