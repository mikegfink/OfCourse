package com.myofcourse.ubcdata;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.myofcourse.exceptions.ConnectionException;
import com.myofcourse.exceptions.UBCException;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


/**
 * Wrapper around a service which gets real time bus information from Translink.
 */
public class UBCService extends AbstractUBCService {
	/**
	 * Set timeouts on connection and data acquisition from Translink
	 */
	private static int CONNECT_TIMEOUT = 3000;
	private static int READ_TIMEOUT = 3000;

	/**
	 * For filtering LogCat messages
	 */
	private final static String LOG_TAG = "UBCService";

	/**
	 * Associated Android activity
	 */
	private Activity activity;

	/**
	 * HTTP connection client
	 */
	private HttpURLConnection client;

	public UBCService(Activity activity) {
		this.activity = activity;
		client = null;
	}

	public void exampleQueryBuilder() throws UBCException {
		// TODO: example
//		StringBuilder uriBuilder = new StringBuilder(
//				"//api.translink.ca/RTTIAPI/V1/");
//		uriBuilder.append("stops/" + stop.getStopNum() + "/");
//		uriBuilder.append("estimates?");
//		uriBuilder.append("apikey=" + APIKEY);
//		uriBuilder.append("&count=" + NUM_BUSES);
//		uriBuilder.append("&timeframe=" + TIME_FRAME);
//		stop.clearWaitTimes();
//		try {
//			InputSource is = makeXMLQuery(uriBuilder);
//
//			parseWaitTimesFromXML(is, stop);
//		} finally {
//			if(client != null) {
//				client.disconnect();
//				client = null;
//			}
//		}
	}

	/**
	 * Execute a given XML query 
	 * 
	 * @param urlBuilder The query with everything but http:
	 * @return The input source built from client response 
	 * @throws UBCException when an error occurs trying to connect or get data
	 * 			from UBC service
	 */
	private InputSource makeXMLQuery(StringBuilder urlBuilder) throws UBCException {

		try {
			checkConnection();

			URL url = new URL("http:" + urlBuilder.toString());
			client = (HttpURLConnection) url.openConnection();
			client.setConnectTimeout(CONNECT_TIMEOUT);
			client.setReadTimeout(READ_TIMEOUT);
			client.connect();

			InputSource is;
			InputStream err = client.getErrorStream();
			if( err != null )
				is = new InputSource(err);
			else {
				InputStream in = client.getInputStream();
				is = new InputSource(in);
			}

			return is;
		} catch (SocketTimeoutException e) {
			throw new UBCException(); // Do something clever
		} catch (ConnectionException e) {
			throw new UBCException(); // Do something clever
		} catch (Exception e) {
			throw new UBCException(); // Do something clever
		}
	}

	/**
	 * Checks that data connection is available on device
	 * @throws ConnectionException when data services are not available
	 */
	private void checkConnection() throws ConnectionException {
		ConnectivityManager cm = (ConnectivityManager) activity
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo == null || !netInfo.isConnected()) {
			throw new ConnectionException("Check network connection");
		}
	}
}
