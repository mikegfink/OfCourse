package com.myofcourse.ubcdata;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


public class SectionParser extends AbstractUBCParser {
	private StringBuilder sb;

	// TODO: Document
	public SectionParser() {
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		sb = new StringBuilder();
		
		if(qName.equals("")) {
			
		}
		else if(qName.equals("")) {
		
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		
		String data = sb.toString().trim();
		
		if(qName.equals("")) {
			
		}
		else if(qName.equals("")) {
			
		}
		// TODO: How does UBC give errors?
		else if(qName.equals("Code")) 
			code = Integer.parseInt(data);
		else if(qName.equals("Message"))
			message = data;
		else if(qName.equals("Error"))
			isError = true;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		
		sb.append(new String(ch, start, length));
	}
}
