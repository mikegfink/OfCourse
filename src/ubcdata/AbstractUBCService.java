package ubcdata;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import exceptions.UBCException;

public abstract class AbstractUBCService {

	public AbstractUBCService() {
		super();
	}

	protected void parseExampleFromXML(InputSource is, Object thingToBuild) // TODO 
			throws UBCException {
// TODO: Example parsing method		
//		BusWaitTimeParser waitTimeParser; // Create parsers in own class for particular types and
		// rename this method accordingly (ie CourseParser SectionParser etc.)
//		try {
//			SAXParserFactory spf = SAXParserFactory.newInstance();
//			SAXParser parser = spf.newSAXParser();
//
//			XMLReader reader = parser.getXMLReader();
//
//			waitTimeParser = new BusWaitTimeParser(stop);
//			reader.setContentHandler(waitTimeParser);
//			reader.parse(is);
//		} catch (Exception e) {
//			// Convert other exception types to TranslinkException so clients do not
//            // have to worry about the different possibilities.
//            throw new TranslinkException(-1, e.getMessage());
//		}
//		
//		if(waitTimeParser.receivedError()) {
//			throw new TranslinkException(waitTimeParser.getErrorCode(), waitTimeParser.getMessage());
//		}
//	}


	}
}