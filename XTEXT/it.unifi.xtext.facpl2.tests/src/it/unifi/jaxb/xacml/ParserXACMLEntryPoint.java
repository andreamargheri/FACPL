package it.unifi.jaxb.xacml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;

public class ParserXACMLEntryPoint {
	
	public static Boolean parseXACML(String file) throws Exception{
		Logger l = Logger.getLogger(ParserXACMLEntryPoint.class);
		try {
			l.debug("Start parsing...");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				
				parser.parse(new File(file)); 
				l.trace("End reading of xml file");
				
				return true;
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
