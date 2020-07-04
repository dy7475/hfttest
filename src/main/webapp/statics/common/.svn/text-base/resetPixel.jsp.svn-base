<%@page import="org.fto.jthink.resource.*" %>
<%@page import="com.myfun7.util.*" %>
<%
	try{
		ResourceManager resManager = (ResourceManager)request.getAttribute(ResourceManager.class.getName());
		Operator thisOperator = (Operator)resManager.getResource(org.fto.jthink.j2ee.web.HttpSession.class.getName(), Operator.class.getName());
		
		thisOperator.setAttribute("remotePixelX", request.getParameter("remotePixelX"));
		thisOperator.setAttribute("remotePixelY", request.getParameter("remotePixelY"));
	}catch(Exception e){}
%>