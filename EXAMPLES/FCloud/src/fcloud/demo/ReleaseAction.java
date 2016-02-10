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

public class ReleaseAction implements IPepAction {

	/**
	 * @param args
	 *            0 = HYPER_1 or HYPER_2 1 = VM'id to release
	 * @throws Throwable
	 */
	public void eval(List<Object> args) throws Throwable {
		String absPath = FCloud.getInstance().getAbsPath();

		Properties prop = new Properties();
		try {
			// release([HYPER_1, 2f19f36d-7690-4287-beed-faa7c042f45f])
			String id = ((String) args.get(1)).trim();
			int l = 0;
			String t = "";
			prop.load(new FileInputStream(new File(absPath + File.separator + args.get(0) + ".properties")));

			Enumeration<?> iter = prop.propertyNames();
			while (iter.hasMoreElements()) {
				String s = (String) iter.nextElement();
				if (s.contains(id)) {
					if (s.contains("TYPE_1")) {
						t = "TYPE_1";
						l = 1;
					} else {
						t = "TYPE_2";
						l = 2;
					}
					// remove vm
					prop.remove(s);
					break;
				}
			}
			// update # VM_TYPE_1
			prop.setProperty("VM_" + t + "s",
					Integer.toString(Integer.parseInt(prop.getProperty("VM_" + t + "s")) - 1));
			// update availableResources
			prop.setProperty("availableResources",
					Integer.toString(Integer.parseInt(prop.getProperty("availableResources")) + l));
			// store
			prop.store(new FileOutputStream(new File(absPath + File.separator + args.get(0) + ".properties")),
					"Freeze VM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
