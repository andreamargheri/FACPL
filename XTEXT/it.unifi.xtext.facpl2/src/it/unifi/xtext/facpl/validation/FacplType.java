package it.unifi.xtext.facpl.validation;

import it.unifi.xtext.facpl.facpl2.TypeLiteral;

public enum FacplType {
	/**
	 * TYPED -> it is used for typing a well-typed high-level element (e.g., policy, policy set, PAF)
	 */
	INT, DOUBLE, STRING, BOOLEAN, DATETIME, SET_INT, SET_DOUBLE, SET_STRING, SET_BOOLEAN, SET_DATETIME, SET_NAME, NAME, ERR, TYPED;

	public static FacplType combine(FacplType f1, FacplType f2) {
		if (f1.equals(f2)) {
			return f1;
		} else if (f1.equals(INT) && f2.equals(DOUBLE) || f2.equals(INT) && f1.equals(DOUBLE)) {
			// sub-typing for int < double
			return DOUBLE;
		} else if (isSet(f1) && !f2.equals(ERR)) {
			// SET function
			return f1;
		} else if (isSet(f2) && !f1.equals(ERR)) {
			// SET function
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

	public static boolean isSet(FacplType f2) {
		switch (f2) {
		case SET_BOOLEAN:
			return true;
		case SET_INT:
			return true;
		case SET_DOUBLE:
			return true;
		case SET_STRING:
			return true;
		case SET_DATETIME:
			return true;
		case SET_NAME:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Return the SET_* corresponding to the type * in input
	 * 
	 * @param f
	 * @return
	 */
	public static FacplType getSetType(FacplType f) {
		switch (f) {
		case BOOLEAN:
			return SET_BOOLEAN;
		case INT:
			return SET_INT;
		case DOUBLE:
			return SET_DOUBLE;
		case STRING:
			return SET_STRING;
		case DATETIME:
			return SET_DATETIME;
		case NAME:
			return SET_NAME;
		default:
			return ERR;
		}
	}

	/**
	 * Return the type * of the SET type SET_* in input
	 * 
	 * @param f
	 * @return
	 */
	public static FacplType getTypeSet(FacplType f) {
		switch (f) {
		case SET_BOOLEAN:
			return BOOLEAN;
		case SET_INT:
			return INT;
		case SET_DOUBLE:
			return DOUBLE;
		case SET_STRING:
			return STRING;
		case SET_DATETIME:
			return DATETIME;
		default:
			return null;
		}
	}

	public static boolean equalType(FacplType type, TypeLiteral literal) {
		switch (literal) {
		//SETs
		case SET_BOOL:
			if (type.equals(SET_BOOLEAN) || type.equals(SET_NAME) ) {
				return true;
			} else {
				return false;
			}
		case SET_DOUBLE:
			if (type.equals(SET_DOUBLE) || type.equals(SET_NAME) ) {
				return true;
			} else {
				return false;
			}
		case SET_INT:
			if (type.equals(SET_INT) || type.equals(SET_NAME) ) {
				return true;
			} else {
				return false;
			}
		case SET_STRING:
			if (type.equals(SET_STRING) || type.equals(SET_NAME) ) {
				return true;
			} else {
				return false;
			}
		case SET_DATE_TIME:
			if (type.equals(SET_DATETIME) || type.equals(SET_NAME) ) {
				return true;
			} else {
				return false;
			}
		//literals	
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
			if (type.equals(DATETIME))
				return true;
			else
				return false;
		default: 
			return false;
			
		}
	}

	public static FacplType getFacplType(TypeLiteral literal) {
		switch (literal) {
		case SET_BOOL:
			return FacplType.SET_BOOLEAN;
		case SET_DATE_TIME:
			return FacplType.SET_DATETIME;
		case SET_DOUBLE: 
			return FacplType.SET_DOUBLE;
		case SET_INT: 
			return FacplType.SET_INT;
		case SET_STRING: 
			return FacplType.SET_STRING; 
			//literals
		case BOOL:
			return FacplType.BOOLEAN;
		case DOUBLE:
			return FacplType.DOUBLE;
		case INT:
			return FacplType.INT;
		case STRING:
			return FacplType.STRING;
		case DATE_TIME:
			return FacplType.DATETIME;
		default: 
			return FacplType.NAME;
		}
	  
	}

	@Override
	public String toString() {
		return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
	}
	
}
