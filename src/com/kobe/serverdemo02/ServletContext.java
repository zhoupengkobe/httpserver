package com.kobe.serverdemo02;

import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * @author ko
 *
 */
public class ServletContext {
	//Ϊÿһ��servlet ȡ������
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
