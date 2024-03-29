package com.kobe.serverdemo02;
/**
 * 抽象成一个父类
 * @author ko
 *
 */
public abstract class Servlet {
	
	public void service(Request req,Response rep) throws Exception{
		this.doGet(req,rep);
		this.doPost(req,rep);
		
	}
	
	public abstract void doGet(Request req,Response rep) throws Exception;
	public abstract void doPost(Request req,Response rep) throws Exception;

}
