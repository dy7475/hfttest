package com.myfun.utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

public class XMLHelper {
	private Document document = null;

	public XMLHelper(File file) throws DocumentException {
		document = DOM4JHelper.getDocument(file);
	}

	public XMLHelper(String filePath) throws DocumentException {
		document = DOM4JHelper.getDocument(filePath);
	}

	public Element selectElement(String nodeName) {
		return DOM4JHelper.getSingleElement(document.getRootElement(), nodeName);
	}

	public Element selectElement(Element el, String nodeName) {
		return DOM4JHelper.getSingleElement(el, nodeName);
	}

	public static String getAttribute(Element element, String attr) {
		return DOM4JHelper.getAttributeValue(element, attr);
	}

	public static void setAttribute(Element element, String attrName, String attrValue) {
		element.setAttributeValue(attrName, attrValue);
	}

	public void saveFile(File file) throws Exception {
		DOM4JHelper.saveFile(document, file);
	}

}
