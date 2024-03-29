package com.kobe.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 存储对象
 * @author ko
 *
 */
public class PersonHandler extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag;//记录标签名
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println("开始一个元素"+qName);
		if (null!=qName) {
			tag=qName;
		}
		if (null!=qName && qName.equals("person")) {
			person = new Person();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		//System.out.println(new String(ch, start, length));
		if (null!=tag && tag.equals("name")) {
			person.setName(str);
		}else if (null!=tag && tag.equals("age")) {
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
	}
	

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//System.out.println("处理文档开始");
		persons = new ArrayList<Person>();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		//System.out.println("处理文档结束");
	}

	

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("结束一个元素"+qName);
		if (qName.equals("person")) {
			this.persons.add(person);
		}
		
		tag=null;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	
	

}
