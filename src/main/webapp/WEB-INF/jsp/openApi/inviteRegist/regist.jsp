<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">dd
	<meta name="format-detection" content="telephone=no" />
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<title>${inviteInfo.createUserName}邀请你加入${adminFunDepts.deptCname}</title>
	<style type="text/css">
		@charset "UTF-8";@media screen and (max-width:319px){html{font-size:85.33333px}}@media screen and (min-width:320px) and (max-width:359px){html{font-size:85.33333px}}@media screen and (min-width:360px) and (max-width:374px){html{font-size:96px}}@media screen and (min-width:375px) and (max-width:383px){html{font-size:100px}}@media screen and (min-width:384px) and (max-width:399px){html{font-size:102.4px}}@media screen and (min-width:400px) and (max-width:413px){html{font-size:106.66667px}}@media screen and (min-width:414px){html{font-size:110.4px}}body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,input,textarea,p,blockquote,th,td,header,hgroup,nav,section,article,aside,footer,figure,figcaption,menu,button{margin:0;padding:0}
		html,body{background-color: #dfe2e7;width:100%; height: 100%; font-family: "微软雅黑"; margin: 0 auto;}
		body {font-size: 16px; color: #000; outline: 0;}
		img{display: block;}
		li{list-style: none;}
		html,body,p{margin: 0;padding: 0;width: 100%;height: 100%;font-family: "微软雅黑";font-size: 16px;}
		#app{
			width: 100%;margin: 0 auto; overflow-x:hidden;
			padding-bottom:20px;background-color: #dfe2e7;
			padding: 10px;box-sizing:border-box;
		}
		#content{background: #fff;min-height: 300px;}
		.topBg{position:relative; background-color:#008cee; height: 30px;padding: 6px 0 0 10px;}
		.topBg img{width: 100px; height: 25px;}
		
		.userInfo{color: #008cee;padding: 10px 0;}
		.userInfo .userName{font-size: 15px;line-height:30px;}
		.userInfo .deptName{font-size: 16px;}
		
		.lineDotted{border-bottom: 1px dotted #aaa;margin: 15px 0 0 0;}
		.lineDotted:before{
			width: 20px;height:20px;background-color:#dfe2e7;
			border-top-right-radius: 50%;
			border-bottom-right-radius: 50%;
			content:"";margin: -10px 0 0 -10px;
			display: block;float: left;
		}
		.lineDotted:after{
			width: 20px;height:20px;background-color:#dfe2e7;
			border-top-left-radius: 50%;
			border-bottom-left-radius: 50%;
			content:"";margin: -10px -10px 0 0;
			display: block;float: right;
		}
		
		.formTable{padding: 0 15px 15px 15px;width: 100%;color: #3f5a72;font-size:14px;border-spacing: 0px;}
		.formTable tbody tr{}
		.formTable tbody td{padding: 15px 0;text-align: left;border-bottom: 1px solid #eee;}
		.formTable tbody .noBottomLine td{border-bottom: 0px;}
		.formTable tbody td.left{width: 80px;}
		#submitFormBtn{
			width: 100%;height: 40px;line-height: 40px;border: 0;font-size: 18px;outline:none;
			border-radius: 3px;text-align: center;color: #fff;font-family: "微软雅黑";
			background-image: url('${statics}openApi/inviteRegist/img/submit.png');
			background-size: 100% 40px;
		}
		select {
			border: solid 1px #000; appearance:none; -moz-appearance:none; -webkit-appearance:none; padding-right: 14px;
			background: url('${statics}openApi/inviteRegist/img/right.png') no-repeat scroll right center transparent;
		}
		select::-ms-expand { display: none; }
		.formTable select{width: 100%; border: 0;font-size: 14px;font-family: "微软雅黑";outline:none;}
		.formTable .full{width: 100%;border: 0;font-size: 14px;outline:none;font-family: '微软雅黑';}
		.formTable input[name='smsCode']{width: 120px;border: 0;font-size: 14px;outline:none;font-family: '微软雅黑';}
		#smsCode{position: absolute;float: left;}
		#getSmsCode{
			width: 75px;height: 24px;line-height: 20px;border: 0;font-size: 12px;float:right;
			border-radius: 3px;text-align: center;color: #2269d5;outline:none;
			font-family: "微软雅黑";margin-top: -5px;vertical-align: middle;
			background-image: url('${statics}openApi/inviteRegist/img/getSmsCode.png');
			background-size: 75px 24px;background-color: #fff;
		}
		.formTable .footer{padding: 0;color: #2269d5;font-size: 13px;}
		
		#maskDiv{display:none; position: fixed;top: 0;left: 0;bottom:0;right:0; width: 100%;height: 100%;background-color: #000;opacity:0.5;filter:alpha(opacity=50);}
		#toastDiv{display:none;position: absolute;top: 0;left: 0;width: 100%;}
		#toastDiv .content{margin: 0 10% 0 10%;background-color: #fff;border-radius: 5px;padding: 20px 10px 10px 10px;}
		#toastDiv .info{margin-bottom: 30px;}
		#toastDivOkBtn{
			width: 150px;height: 35px;line-height: 35px;border: 0;font-size: 14px;outline:none;
			border-radius: 3px;text-align: center;color: #fff;font-family: "微软雅黑";
			background-image: url('${statics}openApi/inviteRegist/img/submit.png');
			background-size: 150px 35px;
		}
	</style>
</head>
<body>
	<div id="app">
		<div id="content">
			<div class="topBg">
				<img src="${statics}openApi/inviteRegist/img/logoERP.png"/>
			</div>
			<div class="userInfo" align="center">
				<p class="userName">${inviteInfo.userName}${inviteInfo.userSex eq 0 ? '女士':'先生'}</p>
				<p class="deptName" align="center">欢迎加入${adminFunDepts.deptCname}</p>
			</div>
			<div class="lineDotted"></div>
			<form action="" method="post">
				<table class="formTable" style="display: black;">
					<thead>
						<tr><td style="width: 80px;"></td></tr>
					</thead>
					<tbody>
						<tr>
							<td>服务区域：</td>
							<td>
								<select name="serviceReg" id="serviceReg" onchange="getServiceZoneList();">
									<c:forEach items="${regList}" var="reg" varStatus="status">
										<option value="${reg.regId}">${reg.regName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>服务商圈：</td>
							<td>
								<select name="serviceZoneIds" id="serviceZoneIds" onchange="serviceZoneChange();">
									<c:forEach items="${sectionList}" var="section" varStatus="status">
										<option value="${section.sectionId}">${section.sectionName}</option>
									</c:forEach>
								</select>
								<input type="hidden" name="serviceZone" id="serviceZone" value="">
							</td>
						</tr>
						<c:choose>
							<c:when test="${not empty userEdition and userEdition eq 2}">
								<tr>
									<td>确认密码：</td>
									<td>精英版密码一致</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>输入密码：</td>
									<td>
										<input type="password" name="pwd" id="pwd" class="full" placeholder="请输入密码" maxlength="20">
									</td>
								</tr>
								<tr>
									<td>确认密码：</td>
									<td>
										<input type="password" name="repwd" id="repwd" class="full" placeholder="请再次输入密码" maxlength="20">
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr>
							<td>注册手机：</td><td>${inviteInfo.userMobile}</td>
						</tr>
						<tr class="noBottomLine">
							<td>短信验证：</td>
							<td>
								<input type="text" name="smsCode" id="smsCode" placeholder="请输入短信验证码" maxlength="6">
								<input type="button" id="getSmsCode" value="获取验证码">
							</td>
						</tr>
						<tr class="noBottomLine">
							<td colspan="2">
								<input type="hidden" name="uuidCode" value="${code}">
								<input type="submit" value="提交" id="submitFormBtn">
							</td>
						</tr>
						<tr class="noBottomLine">
							<td colspan="2" class="footer">
								<div align="center">好房通客服电话：028-88889666 转4</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<div id="maskDiv"></div>
	<div id="toastDiv">
		<div class="content" align="center">
			<div class="info"></div>
			<input type="button" value="确定" id="toastDivOkBtn">
		</div>
	</div>
</body>
<script src="${statics}publicJs/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	$("#submitFormBtn").click(function(){
		var serviceReg = $("#serviceReg").val();
		var serviceZone = $("#serviceZoneIds").val();
		var pwd = $("#pwd").val();
		var repwd = $("#repwd").val();
		var smsCode = $("#smsCode").val();
		if(!judgeParam(serviceReg, "请先选择服务区域")){return false;}
		if(!judgeParam(serviceZone, "请先选择服务商圈")){return false;}
		<c:if test="${empty userEdition}">
			if(!judgeParam(pwd, "请先输入密码")){return false;}
			if(!judgeParam(repwd, "请再次输入密码")){return false;}
			if(pwd != repwd) {
				alertMsg("两次输入的密码不匹配");
				return false;
			}
			var reg = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
			if(!reg.test(pwd)) {
				alertMsg("密码只能为6-20位数字和字母的组合");
				return false;
			}
		</c:if>
		if(!judgeParam(smsCode, "请输入手机验证码")){return false;}
		serviceZoneChange();
		return true;
	});
	function alertMsg(msg){
		$("#maskDiv,#toastDiv").show();
		$("#toastDiv .info").text(msg);
		var scrollTop = $(document).scrollTop();
		var winHeight = $(window).height();
		var divHeight = $("#toastDiv .content").outerHeight();
		$("#toastDiv").css("top", (winHeight - divHeight)/2 + scrollTop);
	}
	function judgeParam(param, msg){
		if(param == null || param == "") {
			alertMsg(msg);
			return false;
		}
		return true;
	}
	$("#toastDivOkBtn").click(function(){
		$("#maskDiv,#toastDiv").hide();
	});
	$("#getSmsCode").click(function(){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "${ctx}openApi/inviteRegist/sendRegistSms",
			data: {code:'${code}'},
			success: function(result){
				if(result.errCode != 200) {
					alertMsg(result.errMsg);
				} else {
					alertMsg("短信发送成功，请注意查收");
				}
			}
		});
	});
	function serviceZoneChange(){
		var text = $("#serviceZoneIds option:selected").text();
		$("#serviceZone").val(text);
	}
	function getServiceZoneList(){
		var regId = $("#serviceReg").val();
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "${ctx}openApi/inviteRegist/getServiceZoneList",
			data: {regId:regId,cityId:'${inviteInfo.cityId}'},
			success: function(result){
				if(result.errCode != 200) {
					alertMsg(result.errMsg);
				} else {
					$("#serviceZoneIds").empty();
					for (var i = 0; i < result.data.length; i++) {
						var temp = result.data[i];
						$("#serviceZoneIds").append('<option value="'+temp.sectionId+'">'+temp.sectionName+'</option>');
					}
				}
			}
		});
	}
</script>
</html>