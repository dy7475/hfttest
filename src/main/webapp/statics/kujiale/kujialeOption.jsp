<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>好房通户型图工具</title>
</head>
<script src="../common/jquery-2.1.3.min.js" type="text/javascript"></script>
<style>
html,body{width: 100%;height: 100%;margin: 0;padding: 0;overflow: hidden;}
</style>
<body onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false" onmouseup="return false">
	<div id="userOption" style="width: 100%;height: 100%;background-color: #aaa;">
		<input type="text" id="searchInput">
		<input type="button" value="搜户型图" onclick="showSearchHouseDiv();">
	</div>
	<object type='application/x-qt-plugin' classid='CKjlAddIn' id='CKjlAddIn' style="height:0px;width:0px;display:block;" ></object>
</body>
<script type="text/javascript">
</script>
</html>