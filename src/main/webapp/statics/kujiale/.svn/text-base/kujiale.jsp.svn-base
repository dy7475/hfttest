<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>好房通户型图工具</title>
</head>
<script src="${pageContext.request.contextPath}/statics/publicJs/jquery-2.1.3.min.js" type="text/javascript"></script>
<style>
html,body{width: 100%;height: 100%;margin: 0;padding: 0;overflow: hidden;}
#kujialeIframe{width: 100%;height: 100%;border: 0;position: absolute;top: 0;left: 0;}
#kujialeOptionIframe{width: 100%;height: 50%;border: 0;position: relative;top: 0;left: 0;}
#flashContent {background-image:url("../kujiale/img/BG.jpg");background-repeat:no-repeat;background-size:100% 100%; width:100%; height: 100%;display: none;}
#flashContent table{width: 100%; position: absolute;top: 26%;}
#flashContent table tr td{text-align: center;}
#flashContent table tr td a{outline: none;}
#flashContent .divText{font-family: 'Microsoft Yahei';font-size: 18px;color: white;text-align: center; margin-bottom: 25px;letter-spacing: 2px;}
</style>
<body onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false" onmouseup="return false">
	<iframe id="kujialeIframe" src=""></iframe>
	<div id="flashContent">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<div class="divText">使用前请下载Flash插件，安装完成后重启软件</div>
					<a href="javascript:openDownloadFlashWindow();">
					<img src="../statics/kujiale/img/buttom.png" />
				</a>
				</td>
				<td><img src="../statics/kujiale/img/Info.png" /></td>
			</tr>
		</table>
	</div>
	<object type='application/x-qt-plugin' classid='CKjlAddIn' id='CKjlAddIn' style="height:0px;width:0px;display:block;" ></object>
	<object type='application/x-qt-plugin' classid='SelBuilding' id="SelBuilding" style="height:0px;width:0px;display:block;"></object>
	<object type='application/x-qt-plugin' classid='SelHouseTypePic' id="SelHouseTypePic" style="height:0px;width:0px;display:block;"></object>
</body>
<script type="text/javascript">
	function openDownloadFlashWindow() {
		document.getElementById('CKjlAddIn').openWindow('http://upgrade1.myfun7.com/install_flash_player16_x86.exe');
	}
	function flashChecker() {
		var hasFlash = 0; //是否安装了flash
		var flashVersion = 0; //flash版本
		var canUseKujiale = 0; //可以使用
		if (navigator.plugins && navigator.plugins.length > 0) {
			var swf = navigator.plugins["Shockwave Flash"];
			if (swf) {
				hasFlash = 1;
				var words = swf.description.split(" ");
				for (var i = 0; i < words.length; ++i) {
					if (isNaN(parseInt(words[i]))){
						continue;
					}
					flashVersion = parseInt(words[i]);
				}
			}
		}
		if(hasFlash){
			//alert("当前版本号："+flashVersion);
			if(flashVersion >= 16) {
				canUseKujiale = 1;
			}
		}
		if(canUseKujiale) {
			reloadPage();
		} else {
			$("#flashContent").show();
			$("#kujialeIframe").remove();
		}
	}
	flashChecker();
	function setUrl(url) {
		$("#kujialeIframe").attr("src", url);
	}
	function reloadPage() {
		$("#kujialeIframe").attr("src", '${KJL_URL}');
	}
	function loadEditFloorplanPage(planId) {
		ajaxTemp("../web/kujiale/getKjlEditFloorplanUrl", "POST", "json", {
			CLIENTKEY : "${CLIENTKEY}",
			PLANID : planId
		}, function(data) {
			setUrl(data.DATA[0].URL);
		}, function(e) {
			alert("获取地址失败");
		});
	}
	if (window.postMessage) {
		var callback = function(ev) {
			if (ev.origin === 'http://www.kujiale.com'
					|| ev.origin === 'http://yun.kujiale.com'
					|| ev.origin === 'https://www.kujiale.com'
					|| ev.origin === 'https://yun.kujiale.com') {
				var data = JSON.parse(ev.data);
				console.log(ev);
				if (data.action == "kjl_saved") {// || data.action == "kjl_completed") {
					try {
						document.getElementById("CKjlAddIn").slot_editFinish(data.fpid);
					} catch (e) {
						console.log(e);
					}
					//$("#kujialeIframe").attr("src", null);
					//loadEditFloorplanPage(data.fpid);
					//reloadPage();
				} else if (data.action == "kjl_loaded") {
					$("#SelBuilding").show();
					try {
						document.getElementById("SelBuilding").setSelectVisible(1);
					} catch (e) {
						console.log(e);
					}
				}
			}
		};
		if ('addEventListener' in document) {
			window.addEventListener('message', callback, false);
		} else if ('attachEvent' in document) {
			window.attachEvent('onmessage', callback);
		}
	} else {
		window.navigator.listenKJL = function(msg) {
			//var data = JSON.parse(msg.data);
			//$("#userOption").append(msg.data);
		};
	}

	/**
	 * ajaxTemp("", "GET", "html", {}, function(){}, function(){}, "");
	 */
	function ajaxTemp(url, dataSentType, dataReceiveType, paramsStr, successFunction, errorFunction, id) {
		$.ajax({
			url : url,
			sync : false,
			type : dataSentType,
			dataType : dataReceiveType,
			data : eval(paramsStr),
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(msg) {
				successFunction(msg, id);
			},
			beforeSend : function() {},
			complete : function() {},
			error : function(msg) {
				errorFunction(msg, id);
			}
		});
	}
</script>
</html>