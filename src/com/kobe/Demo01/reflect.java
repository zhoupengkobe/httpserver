package com.kobe.Demo01;
/**
 * ��ȡ�ṹ��ϢClass����Դͷ��
 * @author ko
 *
 */
public class reflect {
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abd";
		//Class ����
		//����.getClass()
		Class<?> clz = str.getClass();
		//��.Class
		clz = String.class;
		//����·��
		clz=Class.forName("java.lang.String");
	}

}
