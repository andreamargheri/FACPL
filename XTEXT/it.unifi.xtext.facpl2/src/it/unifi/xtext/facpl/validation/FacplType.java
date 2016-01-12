package it.unifi.xtext.facpl.validation;

import it.unifi.xtext.facpl.facpl2.TypeLiteral;
import it.unifi.xtext.facpl.validation.FacplType;

public enum FacplType {
	INT, DOUBLE, STRING, BOOLEAN, DATE, BAG_INT, BAG_DOUBLE, BAG_STRING, BAG_BOOLEAN, BAG_DATE, BAG_NAME, NAME, ERR;

	public static FacplType combine(FacplType f1, FacplType f2) {
		if (f1.equals(f2)) {
			return f1;
		} else if (f1.equals(INT) && f2.equals(DOUBLE) || f2.equals(INT) && f1.equals(DOUBLE)) {
			// sub-typing for int < double
			return DOUBLE;
		} else if (isBag(f1) && !f2.equals(ERR)) {
			// bag function
			return f1;
		} else if (isBag(f2) && !f1.equals(ERR)) {
			// bag function
			return f2;
		} else {
			// NAME is combined with all type, expected when there is an error
			if (f1.equals(NAME) && !f2.equals(ERR)) {
				return f2;
			} else if (f2.equals(NAME) && !f1.equals(ERR)) {
				return f1;
			} else
				return ERR;
		}
	}

	public static boolean isBag(FacplType f2) {
		switch (f2) {
		case BAG_BOOLEAN:
			return true;
		case BAG_INT:
			return true;
		case BAG_DOUBLE:
			return true;
		case BAG_STRING:
			return true;
		case BAG_DATE:
			return true;
		case BAG_NAME:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Return the BAG_* corresponding to the type * in input
	 * 
	 * @param f
	 * @return
	 */
	public static FacplType getBagType(FacplType f) {
		switch (f) {
		case BOOLEAN:
			return BAG_BOOLEAN;
		case INT:
			return BAG_INT;
		case DOUBLE:
			return BAG_DOUBLE;
		case STRING:
			return BAG_STRING;
		case DATE:
			return BAG_DATE;
		case NAME:
			return BAG_NAME;
		default:
			return ERR;
		}
	}

	/**
	 * Return the type * of the bag type BAG_* in input
	 * 
	 * @param f
	 * @return
	 */
	public static FacplType getTypeBag(FacplType f) {
		switch (f) {
		case BAG_BOOLEAN:
			return BOOLEAN;
		case BAG_INT:
			return INT;
		case BAG_DOUBLE:
			return DOUBLE;
		case BAG_STRING:
			return STRING;
		case BAG_DATE:
			return DATE;
		default:
			return null;
		}
	}

	public static boolean equalType(FacplType type, TypeLiteral literal) {
		switch (literal) {
		case BAG:
			if (type.equals(BAG_BOOLEAN) || type.equals(BAG_DATE) || type.equals(BAG_DOUBLE) || type.equals(BAG_INT)
					|| type.equals(BAG_NAME) || type.equals(BAG_STRING)) {
				return true;
			} else {
				return false;
			}
		case BOOL:
			if (type.equals(BOOLEAN))
				return true;
			else
				return false;
		case DOUBLE:
			if (type.equals(DOUBLE))
				return true;
			else
				return false;
		case INT:
			if (type.equals(INT))
				return true;
			else
				return false;
		case STRING:
			if (type.equals(STRING))
				return true;
			else
				return false;
		case DATE_TIME:
			if (type.equals(DATE))
				return true;
			else
				return false;
		default: 
			return false;
			
		}
	}

	public static FacplType getFacplType(TypeLiteral literal) {
		switch (literal) {
		case BAG:
			return FacplType.BAG_NAME;
		case BOOL:
			return FacplType.BOOLEAN;
		case DOUBLE:
			return FacplType.DOUBLE;
		case INT:
			return FacplType.INT;
		case STRING:
			return FacplType.STRING;
		case DATE_TIME:
			return FacplType.DATE;
		default: 
			return FacplType.NAME;
		}
	  
	}

}
