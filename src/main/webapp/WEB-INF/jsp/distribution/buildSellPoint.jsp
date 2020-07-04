<%@ page language="java"  pageEncoding="UTF-8" %>
<%@include file="/basePage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>楼盘管理</title>
<link href="css/case.css" rel="stylesheet" type="text/css">
<link href="css/pagination.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/manhuaDate.1.0.css">
<style>
html,body,{height:100%;}
	::-webkit-scrollbar{width:5px;}
	::-webkit-scrollbar-track{background-color:#D7DBE0;}
	::-webkit-scrollbar-thumb{background-color:#ACAFB3;}
	::-webkit-scrollbar-thumb:hover {background-color:#ACAFB3;}
	::-webkit-scrollbar-thumb:active {background-color:#ACAFB3;}
</style>
</head>
<body style="overflow-x: hidden;overflow-y: auto;">
	<div id="ym-window"
		style="width: 730px; height: 380px;">
		<div class="ym-ml" id="ym-ml">
			<div class="ym-mr">
				<div class="ym-mc">
					<div class="ym-body " style="height: 380px;">
						<div class="ym-content">
							<div class="msg-post"
								style="padding: 30px 85px; height: 320px;">
<!-- 								<div class="cnt" -->
<!-- 									style="line-height: 30px; font-size: 18px; color: #666;margin-left: -69px;"> -->
<!-- 									<h4 -->
<!-- 										style="color: #000; font-size: 18px; text-align: center; margin-bottom: 30px;" -->
<%-- 										id="content_title">${agencyTitle }</h4> --%>
<!-- 									<p class="mt20"></p> -->
<%-- 									<c:if test="${not empty photoList }"> --%>
<%-- 										<c:forEach var="photoList" items="${photoList }"> --%>
<%-- 											<img src="${photoList.PHOTO_ADDR }" style="width:100%;" alt=""/> --%>
<!-- 										</c:forEach> -->
<!-- 									</c:if> -->
<%-- 									<c:if test="${empty agencyIntro }"> --%>
<!-- 										<div id="msg_content" style="text-align: center;padding-top: 20px;"> -->
<!-- 											<img src="images/no_data.png" /> -->
<!-- 										</div> -->
<!-- 									</c:if> -->
<%-- 									<c:if test="${not empty agencyIntro }"> --%>
<%-- 										<div id="msg_content">　　${agencyIntro }</div> --%>
<!-- 									</c:if> -->
<!-- 									<p></p> -->
<!-- 									<p class="mt20"></p> -->
<!-- 									<p></p> -->
<!-- 									<p></p> -->
<!-- 								</div> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="ym-ml" id="ym-btnl" style="display: none;">
			<div class="ym-mr">
				<div class="ym-btn"></div>
			</div>
		</div>
		<div class="ym-bl" id="ym-bl">
			<div class="ym-br">
				<div class="ym-bc"></div>
			</div>
		</div>
	</div>
<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:none;" ></object>
</body>
</html>
