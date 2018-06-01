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
		SimpleDateFormat sdf = new SimpleDateFormat();
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
		return new Date(offsetDateTime.toEpochSecond());
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
		return LocalDate.ofEpochDay(date.getTime());
	}

	public static OffsetDateTime toOffsetDateTime(Date date) {
		return  OffsetDateTime.parse(toTimeString(date));
	}
	
	public static OffsetDateTime toOffsetDateTime(String date) {
		return  OffsetDateTime.parse(date);
	}
}
