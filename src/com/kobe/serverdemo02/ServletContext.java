package com.kobe.serverdemo02;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 * @author ko
 *
 */
public class ServletContext {
	//为每一个servlet 取个别名
	//login -->LoginServlet
	private Map<String,Servlet> servlet;
	//url-->login
	//   /login-->url
	//   //login -->url
	private Map<String, String> mapping;
	
	
	public ServletContext() {
		servlet = new HashMap<String,Servlet>();
		mapping = new HashMap<String,String>();
	}
	
	
	
	
	public Map<String, Servlet> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
	
}
