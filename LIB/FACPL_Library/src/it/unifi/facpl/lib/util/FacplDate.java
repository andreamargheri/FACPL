package it.unifi.facpl.lib.util;

import java.util.Calendar;

import it.unifi.facpl.lib.function.comparison.evaluator.Util;

public class FacplDate {

	private Calendar date;
	private String dateS;

	public FacplDate() {
		this.date = Calendar.getInstance();
		this.dateS = this.date.toString();
	}

	public FacplDate(String dateS) {
		try {
			this.dateS = dateS;
			date = Util.parseDate(dateS);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.append("The input date and/or time value cannot be parsed");
		}
	}

	public Calendar getDate() {
		return date;
	}

	public boolean equals(FacplDate obj) {
		return date.equals(obj.getDate());
	}

	public boolean equals(Calendar obj) {
		return date.equals(obj);
	}

	public boolean before(Calendar obj) {
		return date.before(obj);
	}

	public boolean before(FacplDate obj) {
		return date.before(obj.getDate());
	}

	public boolean after(Calendar obj) {
		return date.after(obj);
	}

	public boolean after(FacplDate obj) {
		return date.after(obj.getDate());
	}

	@Override
	public String toString() {
		return this.dateS;
	}
}
