package com.kobe.server;

public class Servlet {
	
	public void service(Request req,Response rep){
		rep.println("<html><head><title>HTTP第一个</title>");
		rep.println("</head><body>");
		rep.println("欢迎：").println(req.getParameter("uname")).println("回来了!");
		rep.println("</body></html>");
		
	}

}
