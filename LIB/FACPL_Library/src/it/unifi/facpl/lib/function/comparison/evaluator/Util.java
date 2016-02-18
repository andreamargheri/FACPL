package it.unifi.facpl.lib.function.comparison.evaluator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

	public static Calendar parseDate(String s) throws Exception{
		DateFormat dateLong = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		DateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat dateTime = new SimpleDateFormat("HH:mm:ss");
		Calendar d= Calendar.getInstance();
		try{
			d.setTime(dateLong.parse(s));
			return d;
		}catch(Exception e){
			try{
				d.setTime(dateOnly.parse(s));
				return d;
			}catch(Exception t){
				d.setTime(dateTime.parse(s));
				return d;
			}
		}
	}
	
	public static String parseCalendar(Calendar c) throws Exception{
		DateFormat dateLong = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		DateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat dateTime = new SimpleDateFormat("HH:mm:ss");
		try{
			return dateTime.format(c.getTime());	
		}catch(Exception e){
			try{
				return dateOnly.format(c.getTime());
			}catch(Exception t){
				return dateLong.format(c.getTime());
			}
		}
	}
	
}
