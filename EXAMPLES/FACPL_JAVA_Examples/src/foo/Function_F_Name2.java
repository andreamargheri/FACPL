/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package foo;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class Function_F_Name2 implements IExpressionFunction{

	@Override
	public Object evaluateFunction(List<Object> args) throws Throwable {
		
		if (args.size() == 2) {
			if( 
			args.get(0) instanceof String && 
			args.get(1) instanceof Boolean
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
