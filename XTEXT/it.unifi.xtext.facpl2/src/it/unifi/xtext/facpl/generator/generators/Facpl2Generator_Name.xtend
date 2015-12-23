package it.unifi.xtext.facpl.generator.generators

import it.unifi.xtext.facpl.facpl2.funID

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
			case IN : return "comparison.Subset"
			case ADD : return "arithmetic.Add"
			case SUBTRACT : return "arithmetic.Subtract"
			case MULTIPLY : return "arithmetic.Multiply"
			case DIVIDE : return "arithmetic.Divide"	
		}
	}
}