package it.unifi.xtext.facpl.validation;

import it.unifi.xtext.facpl.facpl2.TypeLiteral;

public enum FacplType {
	/**
	 * TYPED -> it is used for typing a well-typed high-level element (e.g., policy, policy set, PAF)
	 */
	INT, DOUBLE, STRING, BOOLEAN, DATETIME, BAG_INT, BAG_DOUBLE, BAG_STRING, BAG_BOOLEAN, BAG_DATETIME, BAG_NAME, NAME, ERR, TYPED;

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
		case BAG_DATETIME:
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
		case DATETIME:
			return BAG_DATETIME;
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
		case BAG_DATETIME:
			return DATETIME;
		default:
			return null;
		}
	}

	public static boolean equalType(FacplType type, TypeLiteral literal) {
		switch (literal) {
		//bags
		case BAG_BOOL:
			if (type.equals(BAG_BOOLEAN) || type.equals(BAG_NAME) ) {
				return true;
			} else {
				return false;
			}
		case BAG_DOUBLE:
			if (type.equals(BAG_DOUBLE) || type.equals(BAG_NAME) ) {
				return true;
			} else {
				return false;
			}
		case BAG_INT:
			if (type.equals(BAG_INT) || type.equals(BAG_NAME) ) {
				return true;
			} else {
				return false;
			}
		case BAG_STRING:
			if (type.equals(BAG_STRING) || type.equals(BAG_NAME) ) {
				return true;
			} else {
				return false;
			}
		case BAG_DATE_TIME:
			if (type.equals(BAG_DATETIME) || type.equals(BAG_NAME) ) {
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
		case BAG_BOOL:
			return FacplType.BAG_BOOLEAN;
		case BAG_DATE_TIME:
			return FacplType.BAG_DATETIME;
		case BAG_DOUBLE: 
			return FacplType.BAG_DOUBLE;
		case BAG_INT: 
			return FacplType.BAG_INT;
		case BAG_STRING: 
			return FacplType.BAG_STRING; 
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
