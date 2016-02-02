package foo.declaredFunctions;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class Function_F_Name implements IExpressionFunction{

	@Override
	public Object evaluateFunction(List<Object> args) throws Throwable {
		
		if (args.size() == 2) {
			if( 
			args.get(0) instanceof String && 
			args.get(1) instanceof Integer
			){
					throw new Exception("TODO: auto-generated method stub");
			}else{
					throw new Exception("Illegal types of arguments");
			}
		} else {
			throw new Exception("Illegal number of arguments");
		}
		
	}

}
