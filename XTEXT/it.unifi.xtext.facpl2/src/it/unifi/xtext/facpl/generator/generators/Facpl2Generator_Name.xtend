package it.unifi.xtext.facpl.generator.generators

import it.unifi.xtext.facpl.facpl2.funID
import it.unifi.xtext.facpl.validation.FacplType

class Facpl2Generator_Name {

	// Exression Functions
	def static getFunName(funID str) {
		
		switch (str) {
			case EQUAL: return "comparison.Equal"
			case NEQUAL: return "comparison.NotEqual"
			case GREATER: return "comparison.GreaterThan"
			case GREATER_EQ: return "comparison.GreaterThanOrEqual"
			case LESS: return "comparison.LessThan"
			case LESS_EQ: return "comparison.LessThanOrEqual"
			case IN : return "comparison.In"
			case ADD : return "arithmetic.Add"
			case SUBTRACT : return "arithmetic.Subtract"
			case MULTIPLY : return "arithmetic.Multiply"
			case DIVIDE : return "arithmetic.Divide"	
		}
	}
	
	def static getJavaType (FacplType t){
		switch (t){
			case SET_BOOLEAN: return "Bag"
			case SET_DATETIME: return "Bag"
			case SET_DOUBLE: return "Bag"
			case SET_INT: return "Bag"
			case SET_NAME: return "Bag"
			case SET_STRING: return "Bag"
			case BOOLEAN: return "Boolean"
			case DATETIME: return "FacplDate"
			case DOUBLE: return "Double"
			case INT: return "Integer" 
			case STRING: return "String"
			case NAME: return "AttributeName"
			default: 
				throw new Exception ("Unsupported Typed for Declared Functions")
		}
	}
}