package com.kobe.Demo01;

import java.net.Socket;

import com.kobe.serverdemo02.Servlet;

/**
 * 创建实例  调用空构造
 * @author ko
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("com.kobe.serverdemo03.LoginServlet");
		//调用空构造，确保空构造存在
		Servlet ser = (Servlet)clz.newInstance();
		//return ser;
	}

}
