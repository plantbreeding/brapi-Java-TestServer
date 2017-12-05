package org.brapi.test.BrAPITestServer.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
	
	public static Date convertStringToDate(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = new Date();
		try {
			if (string != null && !string.isEmpty()) {
				date = sdf.parse(string);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
