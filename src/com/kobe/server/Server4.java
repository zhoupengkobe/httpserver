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
public class Server4 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server4 server = new Server4();
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
			String msg = null;//���տͻ��˵�������Ϣ
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			//���տͻ��˵�������Ϣ
			String requestInfo = new String(data, 0, len).trim();//ȥ������Ŀո�
			System.out.println(requestInfo);
			//��Ӧ
			Response rep = new Response(client);
			rep.println("<html><head><title>HTTP��һ��</title>");
			rep.println("</head><body>Hello Tomcat!</body></html>");
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
