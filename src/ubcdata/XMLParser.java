package ubcdata;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Parser for XML files that contain TODO.
 */
public class XMLParser extends DefaultHandler {
	private StringBuilder sb;
	
	/**
	 * Constructor
	 * @param route  the route to which parsed route segments are to be added
	 */
	public XMLParser() {
	
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		sb = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
//		if (qName.equals(""))
//			
//		else if (qName.equals(""))
//			
//		else if (qName.equals(""))
//			
//		else if (qName.equals(""))
//			
//		else if (qName.equals(""))
//			
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		sb.append(new String(ch, start, length));
	}


}
