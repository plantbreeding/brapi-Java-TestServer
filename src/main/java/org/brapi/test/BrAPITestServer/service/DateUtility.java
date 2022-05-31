package org.brapi.test.BrAPITestServer.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;


public class DateUtility {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
	
	public static Date toDate(String string) throws BrAPIServerException {
		Date date = new Date();
		try {
			if (string != null && !string.isEmpty()) {
				SimpleDateFormat sdf;
				if(string.length() <= 10) {
					sdf = new SimpleDateFormat(DATE_FORMAT);
				}else {
					sdf = new SimpleDateFormat(TIME_FORMAT);
				}
				date = sdf.parse(string);
			}else {
				date = null;
			}
		} catch (ParseException e) {
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "Error parsing date: " + string);
		}
		return date;
	}

	public static Date toDate(OffsetDateTime offsetDateTime) {
		if(offsetDateTime == null)
			return null;
		return new Date(offsetDateTime.toEpochSecond() * 1000);
	}

	public static Date toDate(LocalDate localDate) {
		if(localDate == null)
			return null;
		ZoneId defaultZoneId = ZoneId.systemDefault();
		return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
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

	public static @Valid LocalDate toLocalDate(String date) throws BrAPIServerException {
		if(date == null)
			return null;
		return LocalDate.parse(toDateString(toDate(date)));
	}

	public static OffsetDateTime toOffsetDateTime(Date date) {
		if(date == null)
			return null;
		return  OffsetDateTime.parse(toTimeString(date));
	}
	
	public static OffsetDateTime toOffsetDateTime(String date) throws BrAPIServerException {
		if(date == null || date.equals(""))
			return null;
		return  OffsetDateTime.parse(toTimeString(toDate(date)));
	}
}
