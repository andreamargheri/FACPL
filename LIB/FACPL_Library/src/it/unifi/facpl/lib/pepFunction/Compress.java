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
package it.unifi.facpl.lib.pepFunction;

import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IPepAction;

public class Compress implements IPepAction {

	@Override
	public void eval(List<Object> args) throws Throwable {
		Logger l = LoggerFactory.getLogger(Log.class);
		try {
			FileOutputStream fos = new FileOutputStream("file.zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			ZipEntry ze = new ZipEntry("communication.log");
			zos.putNextEntry(ze);

			if (args.size() > 0) {
				for (Object a : args) {
					zos.write(a.toString().getBytes());
				}
			}
			zos.closeEntry();
			zos.close();

			System.out.println("Compress Done");

		} catch (Exception e) {// Catch exception if any
			l.debug("Error in log pep function: " + e.getMessage());
			throw e; // throw to manage indeterminate result from enforcement
						// algorithm
		}
	}
}
