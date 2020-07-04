<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html onselectstart="return false;" oncontextmenu="return false;" style="overflow-x:hidden;overflow-y:auto;" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>好房通</title>
	<base href="${statics}bulletin/" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link href="css/style-bbs.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="${statics}publicJs/kindeditor/v4.1.7/themes/myfun7.css" />
	<script language="JavaScript">
		var projectPath = "${ctx}";
		var basePath = "${ctx}";
		function setNullImg(obj){
			console.log(obj.src);
			if(obj.src.indexOf("default.png") < 0) {
				obj.src = "./images/default.png";
			}
		}
		/*屏蔽所有的js错误*/
		window.onerror = function(){return true};
	</script>
	<script type="text/javascript" src="${statics}common/score/score.js"></script>
	<script language="javascript" src="${statics}publicJs/jquery-1.6.4.min.js"></script>
	<script language="javascript" src="${statics}publicJs/main.js"></script>
	<script type="text/javascript" src="${statics}publicJs/kindeditor/v4.1.7/kindeditor-erp.js"></script>
	<script language="JavaScript" src="${statics}bulletin/js/bulletin.js"></script>
</head>
<body style="overflow-x: hidden">
	<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
	<div class="bbs-content">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="50"><img onerror="setNullImg(this)" src="${operator.operatorHT.USER_PHOTO_MIN}" class="bulletin_bg bbs-content-img"/></td>
				<td>
					<h1 id="preTitle"></h1>
					<h2 id="userInfo">
						<span class="bbs-right2">等级：<span id="gradeCont${operator.operatorHT.ARCHIVE_ID}"></span>
						　积分：<span style="padding-top: 0px;">${userScore}</span>
						　<span class="red">0/0</span></span>
						楼主：${operator.operatorHT.USER_NAME}
						<c:if test="${operator.operatorHT.USER_RIGHT eq 1}">
							<img title="实名认证用户" src="images/bullet_right.png" style="margin-top: 2px" />
						</c:if>
						<c:if test="${operator.operatorHT.SUPER_USER eq 1}">
							<img title="付费会员" src="images/bullet_vip.gif" style="margin-top: 2px;margin-left: 6px" />
						</c:if>
						<c:if test="${isphone eq 'true'}">
							${operator.operatorHT.USER_MOBILE}
						</c:if>
					</h2>
				</td>
			</tr>
		</table>
		<script type="text/javascript">showGrade("gradeCont${operator.operatorHT.ARCHIVE_ID}","${userScore}",1);</script>
		<h4 id="preContent"></h4>
		<div id="voteTable" class="tab-vote" style="display: none">
		<div class="bulletin_bg coner_rt"></div><div class="bulletin_bg coner_lt"></div>
		<div class="bulletin_bg coner_rb"></div><div class="bulletin_bg coner_lb"></div>
			<table id="voteTableItem" border="0" align="center" cellpadding="0" cellspacing="0">
				<caption><div class="vote_title">以下为投票内容：</div></caption>
				<tr id="voteItemTemplet" style="display:none;">
					<td id="voteItemTemplet1">
						@index@、<label><input hidefocus type="@selectType@" name="voteItem" id="" value=""/>@item@</label>
					</td>
					<td width="120" id="voteItemTemplet2">
						<img src="images/t-l-bg.png" width="3" height="12" class="bbs-vote-z-img"/>
					</td>
					<td width="80" id="voteItemTemplet3">0/0%</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<a onfocus="this.blur();" onclick="showMsg();return false;" href="javascript:void(-1);" class="bulletin_bg btn_b44">投 票</a>
					</td>
				</tr>
			</table>
		</div>
		<h6><span style="float: left;margin-left: 50px;color: #ccc">公司：${operator.operatorHT.DEPT_NAME}</span>　</h6>
	</div>
	<div class="bbs-content">
		<form action="" method="post" name="myform">
			<input type="hidden" id='mycontent' name="CONTENTS" />
			<div id="mycontentDiv" style="display: none;"></div>
			<ul>
				<li style="padding:0;" id="editor">
					<textarea id="preview_ke_content" name="content" style="width:100%;height:220px"></textarea>
				</li>
				<li class="bbs-tijiao" style="float: right;">
					<a onfocus="this.blur();" onclick="gotoEdit();return false;" href="javascript:void(-1);" class="bulletin_bg btn_b44 lt" style="margin-right:5px;">返 回</a>
					<a id="submitBullet" onfocus="this.blur();" onclick="${operate eq 'update' ? 'edit();' : 'saveCommerce();'}" href="javascript:void(-1);" class="bulletin_bg btn_b44 lt">发 帖</a>
				</li>
			</ul>
		</form>
	</div>
<script language="javascript">
	function gotoEdit(){
		parent.cancelPreview();
	}
	function saveCommerce(){
		parent.saveCommerce();
		document.getElementById("submitBullet").onclick="";
	}
	function edit(){
		parent.edit();
	}
	//页面初始化
	$(document).ready(init);
	function init(){
		document.getElementById("preTitle").innerHTML = parent.document.getElementById("topic").value;
		document.getElementById("preContent").innerHTML = parent.editor.html();
		document.getElementById("editor").style.display = "none";
		var userInfo = document.getElementById("userInfo").innerHTML;
		var today = new Date();
		var todayStr = today.getFullYear()+"-"+(today.getMonth()+1)+"-"+today.getDate();
		document.getElementById("userInfo").innerHTML =
				userInfo.replace("#name#","name").replace("#phone#","phone")
				.replace("#compName#","compName").replace("#bullteTime#",todayStr);
		var isVote = parent.document.getElementById("isVote").value;
		if(isVote == "1"){
			document.getElementById("voteTable").style.display = "";
			var voteTableItem = document.getElementById("voteTableItem");
			var voteItemTemplet1 = document.getElementById("voteItemTemplet1").innerHTML;
			var voteItemTemplet2 = document.getElementById("voteItemTemplet2").innerHTML;
			var voteItemTemplet3 = document.getElementById("voteItemTemplet3").innerHTML;
			var voteTypeEls = parent.document.getElementsByName("voteType");
			var voteType;
			if(voteTypeEls[0].checked){
				voteType = "radio";
			}else{
				voteType = "checkbox";
			}
			var content = parent.document.getElementById("tb_VoteItem").value;
			var contents = new Array();
			contents = content.split("\n");
			var count = 0;
			for(var i=0;i<contents.length&&i<10;i++){
				if(contents[i]!=""){
					var str = voteItemTemplet1.replace("\@index\@",(1+count));
					str = str.replace("\@selectType\@",voteType);
					str = str.replace("\@item\@",contents[i]);
					var newRow = voteTableItem.insertRow(1+count);
					newRow.insertCell(0).innerHTML = str;
					newRow.insertCell(1).innerHTML = voteItemTemplet2;
					newRow.insertCell(2).innerHTML = voteItemTemplet3;
					count++;
				}
			}
		}
		window.focus();
		setTimeout("parent.previewInit()",1000);//调用父页面的方法，隐藏加载动画
	}
</script>
</body>
</html>