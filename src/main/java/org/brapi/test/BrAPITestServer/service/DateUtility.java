package org.brapi.test.BrAPITestServer.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;


public class DateUtility {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
	
	public static Date toDate(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
		Date date = new Date();
		try {
			if (string != null && !string.isEmpty()) {
				date = sdf.parse(string);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date toDate(OffsetDateTime offsetDateTime) {
		if(offsetDateTime == null)
			return null;
		return new Date(offsetDateTime.toEpochSecond() * 1000);
	}
	
	public static String toDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
	
	public static String toTimeString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
		return sdf.format(date);
	}

	public static LocalDate toLocalDate(Date date) {
		if(date == null)
			return null;
		return LocalDate.parse(toDateString(date));
	}

	public static OffsetDateTime toOffsetDateTime(Date date) {
		if(date == null)
			return null;
		return  OffsetDateTime.parse(toTimeString(date));
	}
	
	public static OffsetDateTime toOffsetDateTime(String date) {
		if(date == null || date.equals(""))
			return null;
		return  OffsetDateTime.parse(date);
	}

	public static Date toDate(LocalDate localDate) {
		if(localDate == null)
			return null;
		return new Date(localDate.toEpochDay());
	}
}
