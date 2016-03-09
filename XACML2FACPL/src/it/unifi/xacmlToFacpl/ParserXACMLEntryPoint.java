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

import it.unifi.xacmlToFacpl.parser.XacmlParser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class ParserXACMLEntryPoint {

	public static void main(String[] args) throws Exception {
		System.out.println(translate("source/ws-fm/Create_Policies.xml"));
		System.out.println("##########################");
	
		System.out.println(translate("source/web-example/Deny_All.xml"));
		System.out.println("##########################");
		
//		System.out.println(translate("source/policy.xml"));
		System.out.println("##########################");
		System.out.println(translate("source/epSOS_policySet.xml"));
//		System.out.println("##########################");
//		System.out.println(translate("source/request1.xml"));
//		System.out.println("##########################");
//		System.out.println(translate("source/src-xml/ContextRequest_andrea.xml"));
//		System.out.println("##########################");
//		System.out.println(translate("source/src-xml/ContextRequest_andreaaa.xml"));
	}
	
	public static String translate(String file) throws Exception{
		Logger l = Logger.getLogger(ParserXACMLEntryPoint.class);
		try {
			l.debug("Start parsing...");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				Document d = parser.parse(new File(file)); 
				l.trace("End reading of xml file");
				
				//call parsing 
				XacmlParser xacmlParser = new XacmlParser();
				
				StringBuffer st = xacmlParser.parse(d);
				
//				System.out.println(st.toString());			
				
				return st.toString();
				
			}
			catch (Exception e) {
				System.err.println("Unable to Parse XML file due to following exception: \n "+ e);
				e.printStackTrace();
				throw e;
			}
		} 
		catch (ParserConfigurationException e) {
			System.err.println(
					"No parser suporting JAXP could be found in the local class path."); 
			throw e;
		} 
	} 

//NAVIGATE THE XML TREE
	
//	// note use of recursion
//	public static int countWordsInNode(Node node) {
//
//		int numWords = 0;
//
//		if (node.hasChildNodes()) {
//			NodeList children = node.getChildNodes();
//			for (int i = 0; i < children.getLength(); i++) {
//				numWords += countWordsInNode(children.item(i));
//			} 
//		}  
//
//		int type = node.getNodeType();
//		if (type == Node.TEXT_NODE) {
//			String s = node.getNodeValue();
//			numWords += countWordsInString(s);
//		}
//
//		return numWords;  
//
//	}
//
//	private static int countWordsInString(String s) {
//
//		if (s == null) return 0;
//		s = s.trim();
//		if (s.length() == 0) return 0;
//
//		StringTokenizer st = new StringTokenizer(s);
//		return st.countTokens();
//
//	} 

}
