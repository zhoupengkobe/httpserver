package com.kobe.Demo01;

import java.net.Socket;

import com.kobe.serverdemo02.Servlet;

/**
 * ����ʵ��  ���ÿչ���
 * @author ko
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("com.kobe.serverdemo03.LoginServlet");
		//���ÿչ��죬ȷ���չ������
		Servlet ser = (Servlet)clz.newInstance();
		//return ser;
	}

}
