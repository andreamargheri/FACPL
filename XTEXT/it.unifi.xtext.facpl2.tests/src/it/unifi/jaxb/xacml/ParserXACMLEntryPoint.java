package it.unifi.jaxb.xacml;

import it.unifi.xacmlToFacpl.parser.XacmlParser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class ParserXACMLEntryPoint {
	
	/**
	 * Used by Xtext test for validating XML generator
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static Boolean parseXACML(String file) throws Exception{
	
		if (parseXACMLFile(new File(file)) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Entry point for generating FACPL code from XACML
	 * @param XACML file
	 * @return
	 * @throws Exception
	 */
	public static String genFACPL(File file) throws Exception{
		Logger l = Logger.getLogger(ParserXACMLEntryPoint.class);

		Document d = parseXACMLFile(file);
		
		l.debug("Start generating FACPL Code...");
		// call parsing
		XacmlParser xacmlParser = new XacmlParser();

		StringBuffer st = xacmlParser.parse(d);

		return st.toString();

	}

	
	private static Document parseXACMLFile (File file) throws Exception{
		Logger l = Logger.getLogger(ParserXACMLEntryPoint.class);
		try {
			l.debug("Start parsing...");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				
				Document d = parser.parse(file); 
				l.debug("End reading of xml file");
				
				return d;
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
	
}
