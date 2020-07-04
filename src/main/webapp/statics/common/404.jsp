<%@page language="java" contentType="text/html; charset=utf-8" isErrorPage="true" %>
<%@page import="org.fto.jthink.exception.*"%>
<%
	String siteRoot = request.getContextPath();
	request.setAttribute("IS_ERROR_PAGE", "YES");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<TITLE>好房通</TITLE>
<link type="text/css" rel="stylesheet" href="<%=siteRoot%>/style/css.css" media="screen" />
<style type="text/css">
#_error{margin:0 auto;margin-top:25%;width:380px;overflow: hidden;}
#_shadow{background-color:gray;opacity:0.40;-moz-border-radius:7px;position:fixed;width:380px;height:80px;z-index: 2000}
#_errorTmp1{background:url('<%=siteRoot%>/style/image/error.gif') center no-repeat;}
#_errorTmp2{background:url('<%=siteRoot%>/style/image/error2.gif') center no-repeat;}
#_yy_main_TMP{position:fixed;height:50px;z-index:2001;margin-top:7px;margin-left:9px;}
._closeBtn{background:url('<%=siteRoot%>/images/mouseOut.gif') center no-repeat;float: right;display:block;width:20px;height:20px;}
._closeBtn:hover{background:url('<%=siteRoot%>/images/mouseOver.gif') center no-repeat;cursor:pointer;}
</style>
<script language="javascript">
	window.onload = function(){
		try{/*top.clearCache();暂时没有用*/}catch(e){}
	};
</script>
</head>
<body> 
	<div id="_error">
		<div id="_shadow"></div>
		<div id="_yy_main_TMP">
				<div style="height: 65px;border:1px solid #646464;background-color:#FFFFFF;overflow: hidden;">
					<table style="width:360px;" height="100%">
						<tr>
							<td id='_errorTmp1' width="50px"></td>
							<td style="vertical-align:middle;">
								<span style="display:block;width:285px;font-size:12px;color:#153B6A;overflow:hidden;white-space:nowrap;-o-text-overflow:ellipsis;text-overflow: ellipsis;">
									你访问的应用不存在，请重新登录或联系在线客服！

								</span>
							</td>
							<td style="vertical-align:top;"></td>
						</tr>
					</table>
				</div>
		</div>
</div>
</body>
</html>