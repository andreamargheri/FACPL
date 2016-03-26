package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import java.util.Calendar;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.function.comparison.evaluator.Util;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class NumberArithmeticEvaluatorStatus implements ArithmeticEvaluatorStatus {

	private static NumberArithmeticEvaluatorStatus instance;

	private NumberArithmeticEvaluatorStatus() {

	}

	public static NumberArithmeticEvaluatorStatus getInstance() {
		if (instance == null) {
			instance = new NumberArithmeticEvaluatorStatus();
		}
		return instance;
	}

	@Override
	public void add(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT) {
			Integer value = (int) (status.retrieveAttribute(o1));
			Integer newValue = value + (int) o2;
			status.setAttribute(o1, newValue);
		} else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = (Double) (status.retrieveAttribute(o1));
			Double newValue = value + (double) o2;
			status.setAttribute(o1, newValue);
		} else {
			throw new UnsupportedTypeException("Number", "Add");
		}
	}

	@Override
	public void divide(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT) {
			Integer value = (int) (status.retrieveAttribute(o1));
			Integer newValue = value / (int) o2;
			status.setAttribute(o1, newValue);
		} else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = (Double) (status.retrieveAttribute(o1));
			Double newValue = value / (double) o2;
			status.setAttribute(o1, newValue);
		} else {
			throw new UnsupportedTypeException("Number", "div");
		}
	}

	@Override
	public void multiply(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT) {
			Integer value = (int) (status.retrieveAttribute(o1));
			Integer newValue = value * (int) o2;
			status.setAttribute(o1, newValue);
		} else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = (Double) (status.retrieveAttribute(o1));
			Double newValue = value * (double) o2;
			status.setAttribute(o1, newValue);
		} else {
			throw new UnsupportedTypeException("Number", "mul");
		}
	}

	@Override
	public void subtract(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT) {
			Integer value = (int) (status.retrieveAttribute(o1));
			Integer newValue = value - (int) o2;
			status.setAttribute(o1, newValue);
		} else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = (Double) (status.retrieveAttribute(o1));
			Double newValue = value - (double) o2;
			status.setAttribute(o1, newValue);
		} else {
			throw new UnsupportedTypeException("Number", "sub");
		}
	}

	@Override
	public void flag(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.BOOLEAN) {
			Boolean newValue = (Boolean) o2;
			status.setAttribute(o1, newValue.booleanValue());

		} else {
			throw new UnsupportedTypeException("Boolean", "Flag");
		}

	}

	/*
	 * 
	 * RIVEDERE QUESTA
	 */
	@Override
	public void sum_date(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.DATE) {
			Calendar d1 = Util.parseDate((String) status.retrieveAttribute(o1));
			Calendar d2 = Util.parseDate(((FacplDate) o2).toString());
			d1.add(d1.DAY_OF_MONTH, d2.get(d2.DAY_OF_MONTH));
			d1.add(d1.HOUR, d2.get(d2.HOUR));
			d1.add(d1.MINUTE, d2.get(d2.MINUTE));
			d1.add(d1.SECOND, d2.get(d2.SECOND));
			status.setAttribute(o1, Util.parseCalendar(d1));
		} else {
			throw new UnsupportedTypeException("Date", "Add");
		}

	}

	@Override
	public void set_date(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.DATE) {
			Calendar d2 = Util.parseDate(((FacplDate) o2).toString());
			status.setAttribute(o1, Util.parseCalendar(d2));
		} else {
			throw new UnsupportedTypeException("Date", "Add");
		}

	}

}
