package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonFunction;
import it.unifi.facpl.lib.util.Set;

public class AtLeastOneMemberOf implements IComparisonFunction {

	@Override
	public Boolean evaluateFunction(List<Object> args) throws Throwable {
		if (args.size() == 2) {
			if (args.get(0) instanceof Set && args.get(1) instanceof Set) {
				// check for each element. This function must return true
				// if AT-LEAST one member of the first argument is contained in
				// the second
				Boolean flag = false;
				for (Object obj : ((Set) args.get(0)).getBag_values()) {
					if (((Set) (args.get(1))).contains(obj)) {
						flag = true;
						break;
					}
				}
				return flag;

			} else if (args.get(0) instanceof String && args.get(1) instanceof Set) {
				if (((Set) args.get(1)).contains((String) args.get(0))) {
					return true;
				} else {
					return false;
				}
			} else if (args.get(0) instanceof Set && args.get(1) instanceof String) {
				// first argument BAG
				// second argument STRING
				// BAG atLeastOneMemberOf into STRING -> iff one of the BAG el
				// is equal to the string element
				Set b = (Set) (args.get(0));
				Boolean flag = false;
				for (Object obj : b.getBag_values()) {
					if (obj.equals((String) args.get(1))) {
						flag = true;
						break;
					}
				}
				return flag;

			} else {
				throw new Exception("Illegal Type of arguments");
			}
		} else {
			throw new Exception("Illegal number of arguments");
		}
	}

}
