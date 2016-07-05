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
public class Server3 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private static final String BLANK=" ";
	public static void main(String[] args) {
		Server3 server = new Server3();
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
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP��һ��</title></head><body>Hello Tomcat!</body></html>");
			
			
			StringBuilder response = new StringBuilder();
			//1)HTTPЭ��汾��״̬�룬����
			response.append("HTTP:/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2)��Ӧͷ��Response Head��
			response.append("Server:kobe Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ĳ��ȣ��ֽڳ���
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//����֮ǰ
			response.append(CRLF);
			//����
			response.append(responseContext);
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * ֹͣ������
	 */
	public void stop(){
		
	}

}
