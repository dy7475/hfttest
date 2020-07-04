<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="../themes/default/default.css" />
	<script type="text/javascript" src="../../jquery-1.9.1.min.js"></script>
	<script charset="utf-8" src="../kindeditor.js"></script>
	<script charset="utf-8" src="../lang/zh_CN.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var options = {
			        cssPath : '/css/index.css',
			        filterMode : true
			};
			window.editor = K.create('textarea[name="content1"]');
		});
		function nihao(){
			alert(1);
		}
		</script>
</head>
<body>
	<%
		System.out.println(htmlData);
	%>
	<%=htmlData%>
	<form name="example" method="post" action="demo.jsp?CLIENTKEY=6608a8b82ef579b4a9378da95a2babca" >
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<input type="submit" id="submit_btn" onclick="nihao" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
	<div><%=htmlspecialchars(htmlData)%></div>
	<%
		System.out.println(htmlspecialchars(htmlData));
	%>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>