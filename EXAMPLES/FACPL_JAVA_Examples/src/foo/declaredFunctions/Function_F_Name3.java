package foo.declaredFunctions;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.*;

public class Function_F_Name3 implements IExpressionFunction {

	@Override
	public Object evaluateFunction(List<Object> args) throws Throwable {

		if (args.size() == 3) {
			if (args.get(0) instanceof Bag && args.get(1) instanceof Bag && args.get(2) instanceof Double) {
				throw new Exception("TODO: auto-generated method stub");
			} else {
				throw new Exception("Illegal types of arguments");
			}
		} else {
			throw new Exception("Illegal number of arguments");
		}

	}

}
