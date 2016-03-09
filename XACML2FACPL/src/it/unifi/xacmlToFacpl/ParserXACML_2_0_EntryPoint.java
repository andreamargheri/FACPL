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
package it.unifi.xacmlToFacpl;

import it.unifi.xacmlToFacpl.xacml2.parser.Xacml_2_0_Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class ParserXACML_2_0_EntryPoint {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		if (true) {

			// Path Richieste
			//String req = "source/xacml2/CONTINUE/Simple_Comb/";
			String req = "source/xacml2/demo-5/Simple_Comb/";
			
			File folder = new File(req);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					// System.out.println("File " + listOfFiles[i].getName());

					try {
						File f = new File(req + "../facpl/req/"
								+ listOfFiles[i].getName() + ".fpl");
						f.createNewFile();
						BufferedWriter output = new BufferedWriter(
								new FileWriter(f));
						output.write(translate(req + listOfFiles[i].getName()));
						output.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else if (listOfFiles[i].isDirectory()) {
					System.out.println("Directory " + listOfFiles[i].getName());
				}
			}
		} else {
			// Path Policy
			
			//String req = "source/xacml2/CONTINUE/xacmlPolicy/";
			String req = "source/xacml2/demo-5/xacmlPolicy/";
			File folder = new File(req);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					// System.out.println("File " + listOfFiles[i].getName());

					try {
						File f = new File(req + "../facpl/policy/"
								+ listOfFiles[i].getName() + ".fpl");
						f.createNewFile();
						BufferedWriter output = new BufferedWriter(
								new FileWriter(f));
						output.write(translate(req + listOfFiles[i].getName()));
						
						output.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else if (listOfFiles[i].isDirectory()) {
					System.out.println("Directory " + listOfFiles[i].getName());
				}
			}
			
			

		}
	}

	public static String translate(String file) throws Exception {
		Logger l = Logger.getLogger(ParserXACML_2_0_EntryPoint.class);
		try {
			l.debug("Start parsing...");
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				Document d = parser.parse(new File(file));
				l.trace("End reading of xml file");

				// call parsing
				Xacml_2_0_Parser xacml_2_0_Parser = Xacml_2_0_Parser.getInstance();

				StringBuffer st = xacml_2_0_Parser.parse(d);

				// System.out.println(st.toString());

				return st.toString();

			} catch (Exception e) {
				System.err
						.println("Unable to Parse XML file due to following exception: \n "
								+ e);
				e.printStackTrace();
				throw e;
			}
		} catch (ParserConfigurationException e) {
			System.err
					.println("No parser suporting JAXP could be found in the local class path.");
			throw e;
		}
	}

}
