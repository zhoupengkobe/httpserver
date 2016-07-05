package com.kobe.serverdemo04;

import java.io.IOException;
import java.net.Socket;
import com.kobe.Until.CloseUtil;

/**
 * 一个请求与相应  就一个此对象
 * @author ko
 *
 */
public class Dispatcher implements Runnable{
	private Socket client;
	private Request req;
	private Response rep;
	private int code=200;
	public Dispatcher(Socket client) {
		this.client=client;
		try {
			req=new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			code=500;
			return;
		}
		
	}
	

	@Override
	public void run() {
		
		try {
			System.out.println(req.getUrl());
			System.out.println("********");
			Servlet serv = null;
			try {
				serv = WebApp.getServlet(req.getUrl());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (null==serv) {
				this.code=404;//找不到处理
			}else {
				try {
					serv.service(req, rep);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			rep.pushToClient(code);//推送到客户端
		} catch (IOException e) {
			//e.printStackTrace();
			this.code=500;
		}
		
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CloseUtil.closeAll(client);
		
	}
	

}
