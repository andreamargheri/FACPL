package it.unifi.xtext.facpl.ui.popup.actions.XACMLToFACPL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.w3c.dom.Document;

import it.unifi.xacmlToFacpl.parser.XacmlParser;

public class ParserxacmlToFacplEntryPoint {

	public static String translate(IFile file) throws Exception {
		Logger l = Logger.getLogger(ParserxacmlToFacplEntryPoint.class);
		try {
			l.debug("Start parsing...");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				Document d = parser.parse(file.getContents());
				l.trace("End reading of xml file");

				// call parsing
				XacmlParser xacmlParser = new XacmlParser();

				StringBuffer st = xacmlParser.parse(d);

				System.out.println("End XACML Parsing");

				return st.toString();

			} catch (Exception e) {
				System.err.println("Unable to Parse XML file due to following exception: \n " + e);

				e.printStackTrace();

				throw e;
			}
		} catch (ParserConfigurationException e) {
			System.err.println("No parser suporting JAXP could be found in the local class path.");
			throw e;
		}
	}

}
