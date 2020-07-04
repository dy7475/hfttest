<%@page import="java.util.*" %>
<%@page import="org.fto.jthink.resource.*" %>
<%@page import="org.fto.jthink.j2ee.web.util.*" %>
<%@page import="org.fto.jthink.j2ee.web.HttpRequest" %>
<%@page import="org.fto.jthink.util.*" %>
<%@page import="com.myfun7.util.*" %>
<%@page import="com.myfun7.db.MyfunDataStructure" %>
<%@page import="com.myfun7.util.SessionTimeoutChecker" %>
<%@page import="org.fto.jthink.jdbc.DataObject" %>
<%@page import="org.jdom.Element" %>
<%@page import="org.fto.jthink.exception.JThinkException"%>
<%
	//session.setAttribute(Operator.class.getName(), new Operator("1000"));
	String siteRoot = request.getContextPath();
	String isLoginPage = (String)request.getAttribute("IS_LOGIN_PAGE");
	String isIndexPage = (String)request.getAttribute("IS_INDEX_PAGE");//need operator add save into resManager
	String clientKey = request.getParameter("CLIENTKEY");
	//String isWebPage = (String)request.getSession().getAttribute("WEB_PAGE");
	boolean isValid = isIndexPage != null && (clientKey == null || clientKey.trim().length() <= 0) && isLoginPage != null;
	if(isValid){
		throw new JThinkException(Myfun7ErrorCode.INVALID_REQUEST, "apllication invalid!!!");
	}
	isValid = !isValid && isLoginPage==null && isIndexPage == null;
	if(isValid){
		/* check session timeout */
		new SessionTimeoutChecker(request);
		/* Check Permission */
		//String appnUri = request.getRequestURI();
		//appnUri = appnUri.substring(siteRoot.length());
		//new com.myfun7.bean.common.SecurityUJBean(request).judge_Permission(appnUri);
	}	
	/* Get HttpRequest and  ResourceManager */
	ResourceManager resManager = (ResourceManager)request.getAttribute(ResourceManager.class.getName());
	HttpRequest httpRequest = (HttpRequest) resManager.getResource(HttpRequest.class.getName());

	int bigDepts = 10;
	int listLines = 22;
	String pixelX = "";
	String pixelY = "";
	Operator thisOperator = (Operator)resManager.getResource(org.fto.jthink.j2ee.web.HttpSession.class.getName(), Operator.class.getName());
	if(isValid){
		pixelX = (String)thisOperator.getAttribute("remotePixelX");
		pixelY = (String)thisOperator.getAttribute("remotePixelY");
		if(pixelY != null && pixelY.equals("768")){
			listLines = 22;
		}else if(pixelY != null && pixelY.equals("864")){
			listLines = 26;
		}else if(pixelY != null && pixelY.equals("960")){
			listLines = 30;
		}else if(pixelY != null && pixelY.equals("1024")){
			listLines = 32;
		}else if(pixelY != null){
			listLines = (Integer.parseInt(pixelY) < 768) ? 22 : (26 + (Integer.parseInt(pixelY) - 768) / 25);
		}else{
			pixelX = "1024";
			pixelY = "768";
			listLines = 22;
		}
	}
	
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragrma", "no-cache");
	response.setHeader("Expires", "0");
%>