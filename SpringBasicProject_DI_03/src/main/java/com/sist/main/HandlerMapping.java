package com.sist.main;
import java.util.*;

import org.jsoup.nodes.Attribute;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class HandlerMapping extends DefaultHandler{
	private Map map=new HashMap();

	public Map getMap() {
		return map;
	}
	/*	SAX / DOM (저장)
	 * ===== Mybatis / spring 
	 * <?xml version="1.0" encoding="UTF-8"?> => startDocument()
		<beans> => startElement()
			<bean id="sa1" class="com.sist.main.Sawon"/>
			   startElement() / endElement()
			<bean id="sa2" class="com.sist.main.Sawon"/>
			   startElement() / endElement()
			<bean id="sa3" class="com.sist.main.Sawon"/>
			   startElement() / endElement()
		</beans> endElement()
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("bean")) { // aName => 태그 읽기
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				map.put(id, obj);
			}
		}catch(Exception ex) {}
	}
	
}
