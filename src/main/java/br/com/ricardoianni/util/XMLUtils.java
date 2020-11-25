package br.com.ricardoianni.util;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtils {

	public static Document convertStringToXML(String xmlString) throws ParserConfigurationException, SAXException, IOException{
	        
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document document = docBuilder.parse(new InputSource(new StringReader(xmlString)));
	       
		return document;
		
	}
	
	public static LocalDate convertContextToDate(Document xmlDoc, String tagName) {
		String strData = getTagValue(xmlDoc, tagName);
	
		Integer year  = Integer.valueOf(strData.substring(6));
		Integer month = Integer.valueOf(strData.substring(3, 5));
		Integer day   = Integer.valueOf(strData.substring(0, 2));
		
		return LocalDate.of(year, month, day);
	}
	
	public static BigDecimal convertContextToBigDecimal(Document xmlDoc, String tagName) {
		String strData = getTagValue(xmlDoc, tagName);
		
		return new BigDecimal(strData);
	}
	
	public static String getTagValue(Document xmlDoc, String tagName) {
		return xmlDoc.getElementsByTagName(tagName).item(0).getTextContent();
	}
	
	public static NodeList getTagChildNodeList(Document xmlDoc, String tagName) {
		return xmlDoc.getElementsByTagName(tagName).item(0).getChildNodes();
	}
	
	public static String getNodeValue(Node node) {
		return node.getTextContent();
	}
	
	public static String getAttributeValue(Node node, String attribute) {
		return node.getAttributes().getNamedItem(attribute).getTextContent();
	}

}
