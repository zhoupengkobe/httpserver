package com.kobe.Demo01;
/**
 * 获取结构信息Class对象（源头）
 * @author ko
 *
 */
public class reflect {
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abd";
		//Class 对象
		//对象.getClass()
		Class<?> clz = str.getClass();
		//类.Class
		clz = String.class;
		//完整路径
		clz=Class.forName("java.lang.String");
	}

}
