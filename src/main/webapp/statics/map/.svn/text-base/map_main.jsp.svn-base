<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="/common/error.jsp" %>
<%@page import="com.myfun7.bean.build.BuildJBean" %>
<%@page import="com.myfun7.db.MyfunDataStructure" %>
<%@page import="java.util.HashMap"%>
<%

	BuildJBean buildingJBean = new BuildJBean(request);
	String buildId = request.getParameter("BUILD_ID");
	String userNo = request.getParameter("USER_NO");

	String webConnId = MyfunDataStructure.DS_CONN_ID$MYFUN7_WEBSITE;
	HashMap positions = buildingJBean.getMapPosition();
	
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${SITE_ROOT_URL}/map/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<TITLE>好房通<%=request.getServerName()%></TITLE>
</head>
<body style="text-align: center;margin:0;padding:0" scroll="no"  onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false">
<iframe name="result" scrolling="no" width="100%" height="100%" frameborder="0" 
src="${SITE_ROOT_URL}/web/map/qqMap?CLIENTKEY=${CLIENTKEY}&BUILD_ID=<%=buildId%>&USER_NO=<%=userNo%>&DS_CONN_ID=<%=webConnId %>&CITY_NAME=<%=positions.get("CITY_NAME")%>&CITY_POSITION_X=<%=positions.get("POSITION_X")%>&CITY_POSITION_Y=<%=positions.get("POSITION_Y")%>"></iframe>
</body>
</html>
