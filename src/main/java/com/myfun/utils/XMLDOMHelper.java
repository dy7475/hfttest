package com.myfun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * xml帮助类
 * 
 * @ClassName: XMLDOMHelper
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:10:25
 *
 */
public class XMLDOMHelper {
	public Document document = null;
	public XPath xPath = null;

	public XMLDOMHelper() {
		XPathFactory xpfactory = XPathFactory.newInstance();
		xPath = xpfactory.newXPath();
	}

	public XMLDOMHelper(String path) throws SAXException, Exception {
		XPathFactory xpfactory = XPathFactory.newInstance();
		xPath = xpfactory.newXPath();
		load(path);
	}

	public XMLDOMHelper(File file) throws SAXException, Exception {
		XPathFactory xpfactory = XPathFactory.newInstance();
		xPath = xpfactory.newXPath();
		load(file);
	}

	public XMLDOMHelper(InputStream inputStream) throws SAXException, Exception {
		XPathFactory xpfactory = XPathFactory.newInstance();
		xPath = xpfactory.newXPath();
		load(inputStream);
	}

	/**
	 * 加载配置文件
	 * 
	 * @param path
	 * @throws ParserConfigurationException
	 * @throws Exception
	 * @throws SAXException
	 */
	public void load(String path) throws ParserConfigurationException, SAXException, Exception {
		// 判断文件是否存在
		File xmlFile = new File(path);
		if (!xmlFile.isFile()) {
			throw new FileNotFoundException();
		}
		load(xmlFile);
	}

	public void load(File file) throws SAXException, Exception {
		load(new FileInputStream(file));
	}

	public void load(InputStream inputStream) throws SAXException, Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputStream);
		} catch (ParserConfigurationException e) {
			throw e;
		}
	}

	/**
	 * 通过xpath取得节点列表
	 * 
	 * @param node
	 * @param expression
	 * @return
	 * @throws XPathExpressionException
	 */
	public NodeList selectNodes(Node node, String expression) throws XPathExpressionException {
		// XPath对象编译XPath表达式
		XPathExpression xpexpreesion = this.xPath.compile(expression);
		Object object = xpexpreesion.evaluate(node, XPathConstants.NODESET);
		return (NodeList) object;
	}

	public NodeList selectNodes(String expression) throws XPathExpressionException {
		// XPath对象编译XPath表达式
		XPathExpression xpexpreesion = this.xPath.compile(expression);
		Object object = xpexpreesion.evaluate(document, XPathConstants.NODESET);
		return (NodeList) object;
	}

	/**
	 * 通过xpath取得单个节点
	 * 
	 * @param node
	 * @param expression
	 * @return
	 * @throws XPathExpressionException
	 */
	public Node selectSingleNode(Node node, String expression) throws XPathExpressionException {
		XPathExpression xpexpreesion = this.xPath.compile(expression);
		Object object = xpexpreesion.evaluate(node, XPathConstants.NODE);
		return (Node) object;
	}

	public Node selectSingleNode(String expression) throws XPathExpressionException {
		XPathExpression xpexpreesion = this.xPath.compile(expression);
		Object object = xpexpreesion.evaluate(document, XPathConstants.NODE);
		return (Node) object;
	}

	public String getAttribute(Node node, String attr) {
		NamedNodeMap map = node.getAttributes();
		return map.getNamedItem(attr).getNodeValue();
	}

	public String setAttribute(Node node, String attr, String value) {
		NamedNodeMap map = node.getAttributes();
		return map.getNamedItem(attr).getNodeValue();
	}

	/**
	 * 根据xpath取得节点的文本值
	 * 
	 * @param node
	 * @param expression
	 * @return
	 * @throws XPathExpressionException
	 */
	public String getNodeStringValue(Node node, String expression) throws XPathExpressionException {
		XPathExpression xpexpreesion = this.xPath.compile(expression);
		Object object = xpexpreesion.evaluate(node, XPathConstants.STRING);
		return (String) object;
	}

	public String getNodeStringValue(String expression) throws XPathExpressionException {
		XPathExpression xpexpreesion = this.xPath.compile(expression);
		Object object = xpexpreesion.evaluate(document, XPathConstants.STRING);
		return (String) object;
	}

	/**
	 * 遍历当前节点元素下面的所有(元素的)子节点
	 * 
	 * @param node
	 */
	@SuppressWarnings("unchecked")
	public static void listNodes(Element node) {
		System.out.println("当前节点的名称：：" + node.getName());
		// 获取当前节点的所有属性节点
		List<Attribute> list = node.attributes();
		// 遍历属性节点
		for (Attribute attr : list) {
			System.out.println(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
		}

		if (!(node.getTextTrim().equals(""))) {
			System.out.println("文本内容：：：：" + node.getText());
		}

		// 当前节点下面子节点迭代器
		Iterator<Element> it = node.elementIterator();
		// 遍历
		while (it.hasNext()) {
			// 获取某个子节点对象
			Element e = it.next();
			// 对子节点进行遍历
			listNodes(e);
		}
	}

	/**
	 * 把document对象写入新的文件
	 * 
	 * @param document
	 * @throws Exception
	 */
	public void writer(File file) throws Exception {
		// 紧凑的格式
		// OutputFormat format = OutputFormat.createCompactFormat();
		// 排版缩进的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码
		format.setEncoding("UTF-8");

		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"), format);
		// 写入
		writer.write(document);
		// 立即写入
		writer.flush();
		// 关闭操作
		writer.close();
	}
}
