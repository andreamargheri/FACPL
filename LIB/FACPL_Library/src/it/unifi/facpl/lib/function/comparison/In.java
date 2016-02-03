package it.unifi.facpl.lib.function.comparison;


import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonFunction;
import it.unifi.facpl.lib.util.Set;

public class In implements IComparisonFunction{
	/*
	 * come AtLeastOneMemberOf
	 * 
	 */
	@Override
	public Boolean evaluateFunction(List<Object> args) throws Throwable {
		//bag vs string, bag vs bag , string vs bag
		if (args.size()==2){
			if (args.get(0) instanceof String && args.get(1) instanceof Set){
				if (((Set)args.get(1)).contains((String)args.get(0))){
					return true;
				}else{
					return false;
				}
			}else if (args.get(0) instanceof Set && args.get(1) instanceof Set){
				if (((Set)args.get(1)).contains((Set)args.get(0))){
					return true;
				}else{
					return false;
				}
			}else if (args.get(0) instanceof Set && args.get(1) instanceof String){
				//first argument BAG 
				//second argument STRING
				// BAG contained into STRING -> iff BAG size == 1 and the element is equal
				Set b = (Set)(args.get(0));
				if (b.getBag_values().size()==1){
					if (b.contains((String)args.get(1))){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else {
				throw new Exception("Illegal Type of arguments");
			}
		}else{
			throw new Exception("Illegal number of arguments");
		}

	}


}
