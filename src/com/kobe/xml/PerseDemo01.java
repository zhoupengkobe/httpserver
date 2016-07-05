package com.kobe.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class PerseDemo01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1.��ȡ��������
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parse=factory.newSAXParser();
		//3.�����ķ�Documentע�ᴦ����
		//4.��д������
		PersonHandler handler = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/kobe/xml/persion.xml"), handler);
		
		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName()+"---->"+person.getAge());
		}
	}

}
