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
package fcloud.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import it.unifi.facpl.lib.interfaces.IPepAction;

public class FreezeAction implements IPepAction {

	/**
	 * @param args
	 *            0 = HYPER_1 or HYPER_2 1 = Number of VM to freeze 2 = TYPE_1
	 *            or TYPE_2
	 * @throws Throwable
	 */
	public void eval(List<Object> args) throws Throwable {
		String absPath = FCloud.getInstance().getAbsPath();

		Properties prop = new Properties();
		try {
			// freeze([HYPER_1, -1.0, TYPE_2])
			// # vm to freeze
			double n = Math.abs(Integer.parseInt((String) args.get(1)));
			// type of vm to freeze
			String t = ((String) args.get(2)).trim(); // TYPE_1 or TYPE_2
			int l = 0;

			prop.load(new FileInputStream(new File(absPath + File.separator + args.get(0) + ".properties")));

			Enumeration<?> iter = prop.propertyNames();
			int i = 0;
			while (iter.hasMoreElements()) {
				String s = (String) iter.nextElement();
				if (s.contains(t) && !(s.contains("VM_" + t + "s"))) {
					// remove vm
					prop.remove(s);
					i++;
					l += 1;
				}
				if (i == n) {
					break;
				}
			}
			// update # VM_TYPE_1
			prop.setProperty("VM_" + t + "s",
					Integer.toString(Integer.parseInt(prop.getProperty("VM_" + t + "s")) - i));
			// update availableResources
			prop.setProperty("availableResources",
					Integer.toString(Integer.parseInt(prop.getProperty("availableResources")) + l));
			// store
			prop.store(new FileOutputStream(absPath + File.separator + args.get(0) + ".properties"), "Freeze VM");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
