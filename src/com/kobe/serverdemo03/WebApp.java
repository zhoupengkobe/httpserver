package com.kobe.serverdemo03;

import java.util.Map;

public class WebApp {
	private static ServletContext contxt;
	static{
		contxt = new ServletContext();
		
		Map<String, String> mapping = contxt.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String,String> servlet = contxt.getServlet();
		servlet.put("login","com.kobe.serverdemo03.LoginServlet");
		servlet.put("register","com.kobe.serverdemo03.RegisterServlet");
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if ((null==url) ||((url=url.trim()).equals("")) ) {
			return null;
		}
		//根据字符串(完整路径)创建对象
		String name = contxt.getServlet().get(contxt.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();
		//return contxt.getServlet().get(contxt.getMapping().get(url));
	}

}
