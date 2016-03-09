package it.unifi.xtext.facpl.generator.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date parseDate(String s) throws Exception {
		DateFormat dateLong = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		DateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat dateTime = new SimpleDateFormat("HH:mm:ss");
		try {
			return dateLong.parse(s);
		} catch (Exception e) {
			try {
				return dateOnly.parse(s);
			} catch (Exception t) {
				return dateTime.parse(s);
			}
		}
	}

}
