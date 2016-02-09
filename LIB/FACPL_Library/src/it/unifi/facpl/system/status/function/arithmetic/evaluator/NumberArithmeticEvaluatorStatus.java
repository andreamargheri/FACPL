package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;
import it.unifi.facpl.system.status.StatusAttribute;

public class NumberArithmeticEvaluatorStatus  implements ArithmeticEvaluatorStatus{

	private static NumberArithmeticEvaluatorStatus instance; 

	private NumberArithmeticEvaluatorStatus(){

	}

	public static NumberArithmeticEvaluatorStatus getInstance(){
		if (instance == null){
			instance = new NumberArithmeticEvaluatorStatus();
		}
		return instance;
	}

	@Override
	public void add(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT )  {
			Integer value = Integer.parseInt(o1.getValue());
			Integer newValue = value+(int)o2;
			o1.setValue(newValue.toString());
		}
		else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = Double.parseDouble(o1.getValue());
			Double newValue = value+(double)o2;
			o1.setValue(newValue.toString());
		}
		else {
			throw new UnsupportedTypeException("Number", "Add");
		}
	}

	@Override
	public void divide(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT )  {
			Integer value = Integer.parseInt(o1.getValue());
			Integer newValue = value/(int)o2;
			o1.setValue(newValue.toString());
		}
		else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = Double.parseDouble(o1.getValue());
			Double newValue = value/(double)o2;
			o1.setValue(newValue.toString());
		}
		else {
			throw new UnsupportedTypeException("Number", "div");
		}
	}

	@Override
	public void multiply(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT )  {
			Integer value = Integer.parseInt(o1.getValue());
			Integer newValue = value/(int)o2;
			o1.setValue(newValue.toString());
		}
		else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = Double.parseDouble(o1.getValue());
			Double newValue = value*(double)o2;
			o1.setValue(newValue.toString());
		}
		else {
			throw new UnsupportedTypeException("Number", "mul");
		}
	}

	@Override
	public void subtract(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.INT )  {
			Integer value = Integer.parseInt(o1.getValue());
			Integer newValue = value/(int)o2;
			o1.setValue(newValue.toString());
		}
		else if (o1.getType() == FacplStatusType.DOUBLE) {
			Double value = Double.parseDouble(o1.getValue());
			Double newValue = value-(double)o2;
			o1.setValue(newValue.toString());
		}
		else {
			throw new UnsupportedTypeException("Number", "sub");
		}
	}

	@Override
	public void flag(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.BOOLEAN && o2 instanceof Boolean )  {
			Boolean newValue = (Boolean)o2;
			o1.setValue(newValue.toString());

		}
		else {
			throw new UnsupportedTypeException("Boolean", "Flag");
		}

	}




}
