package com.myofcourse.ubcdata;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Abstract class that forms the basis of XML parsers for data received
 * from UBC service.
 */
public abstract class AbstractUBCParser extends DefaultHandler {
	// For error checking from UBC service - need to test to find out how it returns errors
	// and adjust accordingly - extends default handler for xml parsing purposes
	protected int code;
	protected String message;
	protected boolean isError;

	public AbstractUBCParser() {
		super();
	}

	public boolean receivedError() {
		return isError;
	}

	public int getErrorCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}