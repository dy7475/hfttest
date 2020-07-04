<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="../common/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!-- com.myfun.erpWeb.bulletin.BulletinController#bulletinInfo -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html oncontextmenu="return false;" style="overflow-x:hidden;overflow-y:auto;" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="${statics}/bulletin/" />
	<title>好房通</title>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${statics}css/button.css" rel="stylesheet" type="text/css" />
	<link href="${statics}bulletin/css/style-bbs.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="${statics}/publicJs/kindeditor/v4.1.7/themes/myfun7.css" />
	<script language="JavaScript">
		var basePath = "${operator.operatorHT.HOUSE_PIC_DOC}";
	</script>
	<script language="javascript" src="${statics}publicJs/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="${statics}publicJs/kindeditor/v4.1.7/kindeditor-erp.js"></script>
	<%-- <script type="text/javascript" src="${statics}/publicJs/kindeditor/v4.1.7/kindeditor-all-min.js"></script> --%>
	<script type="text/javascript" src="${statics}bulletin/js/openBuildDiv.js"></script>
	<script language="JavaScript" src="${statics}bulletin/js/Validator.js"></script>
	<script type="text/javascript" src="${statics}common/score/score.js"></script>
	<script type="text/javascript">
	var insertHouseInfoPath = "${ctx}bulletin/insertHouseInfo?CLIENTKEY=${CLIENTKEY}&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(); //插入房源的页面路径
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[id="bulletin_ke_content"]', {
			resizeType : 0,
			allowPreviewEmoticons : true,
			allowImageUpload : true,
			minWidth : 610,
			items : K.options.items_bulletin_reply,
			cssPath : '${statics}/publicJs/kindeditor/v4.1.7/themes/myfun7.css'
		});
	});
	</script>
	<style>img{max-width: 600px;}</style>
	<base target="_self" />
</head>
<body style="overflow-x:hidden" onload="init()">
	<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
	
	<div class="divMaskLayer" id="divMaskLayer"></div>
	<div id="divPayment" class="divPayment">
		<div class="divClose" onclick="closePayment(this)"></div>
		<iframe src="about:blank" id="iframe" border="0" scrolling="no" frameborder="0"></iframe>
	</div>
	
	<div id="formDiv" style="display:none;"></div>
	<input type="hidden" id="bound" value="${bulletinInfo.bulletBound}" />
	<input type="hidden" id="bulletinId" value="${bulletinInfo.bulletId}" />
	<form action="" name="formone" method="post"></form>
	<form name="base" method="post"></form>
	<span id="spanfocus"></span>
	<!--帖子头部-->
	<c:if test="${pageOffset eq 1}">
		<div class="bbs-content" style="margin-top: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="50"><img onerror="setNullImg(this)"
						src="${bulletinInfo.bulletBound eq 3 ? bulletinInfo.realPhoto : bulletinInfo.userPhotoMin}"
						class="bulletin_bg bbs-content-img" /></td>
					<td>
						<h1>
							${bulletinInfo.bulletSubject}
							<span title="查看数" class="replyCount">
								<img src="images/NewVersion/look.png" />${bulletinInfo.clickCount}
							</span>
							<span title="回复数" class="lookCount">${bulletinInfo.replyCount}
								<img src="images/NewVersion/replay.png" />
							</span>
							<c:if test="${bulletinInfo.isLock eq 1}">
								<div style="position: relative;float: right;color: #FD8C00">该帖无法删除和修改回复内容</div>
							</c:if>
						</h1>
						<h2 style="border-bottom: 1px solid #DAE2EA;">
							${empty bulletinInfo.contract ?
							(bulletinInfo.bulletBound eq 3 ?
							bulletinInfo.bbsName : bulletinInfo.userName) :
							bulletinInfo.contract}
							<span style="font-weight: normal; margin-right: 5px;">
							<c:if test="${!bulletinInfo.showTel and bulletinInfo.bulletBound ne 3 and not empty bulletinInfo.userMobile}">
								${bulletinInfo.userMobile}
							</c:if>
							</span>
							<c:if test="${bulletinInfo.userRight eq 1}">
								<img title="实名认证用户" src="images/bullet_right.png" style="vertical-align: middle;" />
							</c:if>
							<c:if test="${bulletinInfo.superUser eq 1}">
								<img title="付费会员" src="images/bullet_vip.gif" style="margin-top: 2px;" />
							</c:if>
							<span id="gradeCont${bulletinInfo.archiveId}"></span>
						</h2>
						<h3 style="margin-top: -10px;">
							<font style="margin-left: 10px;float: right;color: #bbbbbb;">发表于&nbsp;${cf:dateFormatStr(bulletinInfo.bulletTime,'yyyy-MM-dd HH:mm:ss')}</font>
						</h3>
					</td>
				</tr>
			</table>
			<script type="text/javascript">showGrade("gradeCont${bulletinInfo.archiveId}","${empty bulletinInfo.userScore ? 0 : bulletinInfo.userScore}",1);</script>
			<h4 id="bulletContentDiv">${bulletinInfo.bulletContent}</h4>
			<c:if test="${bulletinInfo.isvote}">
				<div class="tab-vote">
					<div class="bulletin_bg coner_rt"></div>
					<div class="bulletin_bg coner_lt"></div>
					<div class="bulletin_bg coner_rb"></div>
					<div class="bulletin_bg coner_lb"></div>
					<table border="0" align="center" cellpadding="0" cellspacing="0" style="table-layout:fixed">
						<caption>
							<div class="vote_title">以下为投票内容：</div>
						</caption>
						<c:forEach items="${voteList}" var="vote" varStatus="status">
							<tr>
								<td>
									${status.index + 1}、
									<label>
										<c:if test="${isVoted eq 0}">
											<input hidefocus type="${vote.voteType eq 0 ? 'radio' : 'checkbox'}"
												name="voteItem" id="voteItem_${status.index + 1}" value="${vote.voteId}" />
										</c:if> ${vote.voteContent}
									</label>
								</td>
								<td style="text-align: right;" width="100px">
									<img src="images/t-l-bg.png" width="${vote.count * 100}" height="12" class="bbs-vote-z-img" />
								</td>
								<td style="text-align: right;" width="80px">${vote.sumCount eq 0 ? '0' : (vote.count/vote.sumCount *100)}%</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3" align="center">
								<c:choose>
									<c:when test="${isVoted eq 0}">
										<input class="nav-blue2-but" type="button" style="CURSOR: hand;" value="投 票" onClick="updateVote()" />
									</c:when>
									<c:otherwise>
										<font style="font-size:12px;color:#b8860b">${voteDesc}</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
			<h4>${bulletinInfo.contentBottom}</h4>
			<h4>
			<c:if test="${not empty bulletinPsPOs}">
				<div class="fileItem">
					<input type="hidden" name="bulletPsInput" id="bulletPsInput"/> 
					<ul>
						<c:forEach items="${bulletinPsPOs}" var="bulletinPs" varStatus="status">
							<li fileName="${bulletinPs.fileName}" path="${bulletinPs.psPath}" url="FastdfsManager.getHttpAccessDomain()${bulletinPs.psPath}" ><span class="file_icon"></span><span class="file_name">${bulletinPs.fileName}</span><a href="javascript:void(-1);" class="download_file" onclick="downloadFile(this)"></a></li>
						</c:forEach>
					</ul>
				</div>
	 		</c:if>
			</h4>
			<h6>
				<c:choose>
					<c:when test="${bulletinInfo.bulletBound ne 3}">
						<div align="left" style="float: left;padding-left: 50px;color: #bbbbbb">
						公司：<span>
						<c:choose>
							<c:when test="${not empty bulletinInfo.compName}">
								${bulletinInfo.compName}
							</c:when>
							<c:otherwise>
								${empty bulletinInfo.deptName ? "网络经纪人" : bulletinInfo.deptName}
							</c:otherwise>
						</c:choose>
						</span>
					</c:when>
					<c:otherwise>
						<div align="left" style="float: left;padding-left: 50px;color: #bbbbbb;">
					</c:otherwise>
				</c:choose>
				<c:if test="${bulletinInfo.editTime ne bulletinInfo.bulletTime}">
					<span style="margin-left: 40px"> 本帖最后由&nbsp;
						${empty bulletinInfo.contract ? (bulletinInfo.bulletBound
						ne 3 ? bulletinInfo.bbsName :
						bulletinInfo.userName) :
						bulletinInfo.contract}&nbsp;于&nbsp;
						${cf:dateFormatStr(bulletinInfo.editTime,'yyyy-MM-dd HH:mm:ss')}
						&nbsp;编辑
					</span>
				</c:if>
			</div>
			<a href="javascript:void(-1)" onClick="relpy();return false;">回复</a>
			<!-- 如果是只有 -->
			<c:if test="${bulletinInfo.bulletBound ne 7 or (operator.operatorHT['COMP_MODEL'] eq 2 and operator.operatorHT['COMP_ATTR'] eq 1)}">
				<c:if test="${bulletinInfo.canEdit}">
					<c:if test="${bulletinInfo.canAddStick}">
						<a href="javascript:void(-1);" class="addTop" onclick="addStick(this);return false;">${bulletinInfo.stick eq 1 ? "取消置顶" : "置顶"}</a>
					</c:if>
					<a href="javascript:void(-1);" class="refresh" onclick="refresh();return false;">刷新</a>
					<a href="javascript:void(-1);" class="editor" onclick="edit();return false;">编辑</a>
				</c:if>
				<c:if test="${bulletinInfo.bulletBound eq 8 and bulletinInfo.canAddStick}">
					<a href="javascript:void(-1);" class="refresh" onclick="refresh();return false;">刷新</a>
					<a href="javascript:void(-1);" class="addTop" onclick="addStick(this);return false;">${bulletinInfo.stick eq 1 ? "取消置顶" : "置顶"}</a>
				</c:if>
				<c:if test="${bulletinInfo.canDelete}">
					<a href="javascript:void(-1);" class="delete" onclick="toremove(this);return false;">删除</a>
				</c:if>
			</c:if>
		</h6>
		</div>
	</c:if>
	<!--回复列表-->
	<c:forEach items="${replayList}" var="replay" varStatus="status">
		<div class="bbs-content">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="50" valign="top">
						<img onerror="setNullImg(this)" src="${operator.operatorHT.USER_PHOTO_DOC}${replay.realPhoto}" class="bulletin_bg bbs-content-img" />
					</td>
					<td>
						<h2 style="margin-top: -22px;">
							<span id="${status.index}user">${replay.userName}</span>
							<c:if test="${replay.showTel and bulletinInfo.bulletBound ne 3}">
								<span style='font-weight: normal;'>(${replay.telePhone})</span>
							</c:if>
							<c:if test="${replay.userRight eq 1}">
								<img title="实名认证用户" src="images/bullet_right.png" style="vertical-align: middle;" />
							</c:if>
							<c:if test="${replay.superUser eq 1}">
								<img title="付费会员" src="images/bullet_vip.gif" style="margin-top: 2px;" />
							</c:if>
							<span class="bbs-right2">
								<span id="gradeCon${status.index}"></span>
								积分：
								<span style="padding-top: 0px;">
									<fmt:parseNumber value="${replay.userScore}" type="number"  integerOnly="true"/>
								</span>
							</span> 
							<a class="JustLookAtMe" style="display:none;" title="只看此人消息" href='${SITE_ROOT_URL}/web/bulletin/onlybulletinInfo?CLIENTKEY=${CLIENTKEY}&archiveId=${replay.archiveId}&BULLET_BOUND=${bulletinInfo.bulletBound}&BULLET_ID=${bulletinInfo.bulletId}&myReply=myReply'></a>
							<font id='${status.index}Time' style="float: right;color: #bbbbbb;font-weight: normal; margin-top: -4px;">
								发表于&nbsp;
								${cf:dateFormatStr(replay.creationTime,'yyyy-MM-dd HH:mm:ss')}
							</font>
						</h2>
					</td>
				</tr>
			</table>
			<script type="text/javascript">showGrade("gradeCon${status.index}","${replay.userScore}",1);</script>
			<h4 class="replyContent">
				<!--引用回复-->
				<c:if test="${replay.useReplay != null}">
					<div class='replyQuote'>
						引用：${replay.useReplay.lou} 楼
						${bulletinInfo.bulletBound eq 3 ?
						replay.useReplay.nickName :
						replay.useReplay.userName} 在
						${cf:dateFormatStr(replay.useReplay.creationTime,'yyyy-MM-dd HH:mm:ss')}
						的回复 : <br />
						${fn:replace(replay.useReplay.contents, "hftImagesUrlAddress", operator.operatorHT.BULLET_PIC_DOC)}
					</div>
				</c:if>
				<!--回复回复-->
				<c:if test="${replay.relateReplay != null}">
					<div class='replyQuote'>
						<span style="cursor: default;"
							onmouseout="javascript:document.getElementById('relate${status.index}').style.display = 'none';"
							onmouseover="javascript:document.getElementById('relate${status.index}').style.display = 'block';">
							回复： ${replay.relateReplay.lou} 楼
							${bulletinInfo.bulletBound eq 3 ?
							replay.relateReplay.nickName :
							replay.relatereplay.userName} 在
							${cf:dateFormatStr(replay.relateReplay.creationTime,'yyyy-MM-dd HH:mm:ss')}
							的回复 : </span><br />
						<div id="relate${status.index}" class="replyQuoteDiv" style="position: absolute;display: none;">
							${replay.relateReplay.contents}
						</div>
					</div>
				</c:if>
				<!--回复内容-->
				<div id="${status.index}Reply">
					<c:choose>
						<c:when test="${!replay.isdelete and !replay.isshield}">
							${fn:replace(replay.contents, "hftImagesUrlAddress", operator.operatorHT.BULLET_PIC_DOC)}
							<c:if test="${replay.isgood}">
								<br /><br />
								<div style="width: 587px;height: 123px;background-image:url(images/zan_bg.png)">
								<c:choose>
									<c:when test="${replay.isZanOver}">
										<img style="margin-left: 305px;margin-top: 6px;position: relative;" src="images/zan_over.png" />
									</c:when>
									<c:when test="${replay.isZan}">
										<img id="zanImg${status.index}"
											onmouseover="javascript:this.src='images/zan_selected.png';"
											onmouseout="javascript:this.src='images/zan.png';"
											style="cursor: pointer;margin-left: 305px;margin-top: 6px;position: relative;"
											onclick="zan('${replay.replyId}',${status.index})"
											src="images/zan.png" />
									</c:when>
									<c:otherwise>
										<img style="margin-left: 305px;margin-top: 6px;position: relative;" src="images/zan_done.png" />
									</c:otherwise>
								</c:choose>
								<div id="zanCount${status.index}" style="color: #ffffff;position: relative;font-size: 20px;color: #FF0000;font-weight: bold;margin-left: 331px;margin-top: -82px;width: 60px;text-align: center;">${replay.GOOD_COUNT}</div>
								<br />
							</c:if>
						</c:when>
						<c:when test="${replay.isdelete}">
							<div style='border: 1px dashed gray;line-height: 34px;padding-left: 10px;'>此回复已被本人删除</div>
						</c:when>
						<c:when test="${replay.isshield}">
							<div style='border: 1px dashed gray;line-height: 34px;padding-left: 10px;'>此回复已被管理员删除</div>
						</c:when>
					</c:choose>
				</div>
			</h4>
			<h6>
				<c:choose>
					<c:when test="${bulletinInfo.bulletBound ne 3}">
						<div align="left" style="float: left;padding-left: 50px;color: #bbbbbb">
							公司：<font id='${status.index}Comp'>${replay.deptName}</font>
					</c:when>
					<c:otherwise>
						<div align="left" style="float: left;padding-left: 50px;color: #bbbbbb">
					</c:otherwise>
				</c:choose>
				<c:if test="${replay.creationTime ne replay.editTime}">
					<span style="margin-left: 10px">本帖最后由&nbsp;
						${bulletinInfo.bulletBound eq 3 ? replay.bbsName : replay.userName}&nbsp;
						于&nbsp;
						${cf:dateFormatStr(replay.editTime,'yyyy-MM-dd HH:mm:ss')}
						&nbsp;编辑</span>
				</c:if>
				</div>&nbsp;
				<c:if test="${!replay.isdelete and !replay.isshield}">
					<a href="javascript:void(-1)" onClick="toreply('${status.index}Time','${status.index}user','${(pageOffset-1) * pageRowSize + status.index + 1}','${replay.archiveId}','${replay.creatorUid}','${bulletinInfo.bulletBound eq 3 ? bulletinInfo.bbsName : bulletinInfo.userName}','${replay.replyId}');return false;">回复</a>
					<a href="javascript:void(-1);" style="background-image: url('images/NewVersion/Quote.png');background-position-y:0px; "
						onClick="use('${status.index}user','${status.index}Time','${status.index}Reply','${(pageOffset-1) * pageRowSize + status.index + 1}','${replay.replyId}','${reaply.archiveId}','${replay.userId}','${bulletinInfo.bulletBound eq 3 ? bulletinInfo.bbsName : bulletinInfo.userName}');return false;">引用</a>
					<c:if test="${(replay.archiveId eq operator.operatorHT.ARCHIVE_ID) and !bulletinInfo.isLock}">
						<a href="javascript:void(-1)" class="editor" onClick="updateReply('${replay.replyId}');return false;">修改</a>
						<div id="${replay.replyId}a" style="display: none;">${fn:replace(replay.contents, "hftImagesUrlAddress", operator.operatorHT.BULLET_PIC_DOC)}</div>
						<a href="javascript:void(-1)" class="delete" onClick="deleteReply('${replay.replyId}');return false;">删除</a>
					</c:if>
				</c:if>
			</h6>
		</div>
	</c:forEach>
	<!--分页-->
	<div id="pagediv">
		<jsp:include page="pager/pagger.jsp" flush="false">
			<jsp:param name="PAGE_ROW_TOTAL" value="${pageRows}" />
			<jsp:param name="PAGE_OFFSET" value="${pageOffset}" />
			<jsp:param name="PAGE_ROW_SIZE" value="${pageRowSize}" />
			<jsp:param name="ROW_TOTAL" value="${fn:length(voteList)}" />
		</jsp:include>
	</div>
	<div class="bbs-content" style="width:610px;margin-top:10px;">
		<form action="" method="post" id="myform" name="myform">
			<input type="hidden" id='mycontent' name="CONTENTS" />
			<input type="hidden" id="RELATE_ID" name="RELATE_ID" />
			<div id="mycontentDiv" style="display: none;"></div>
			<ul>
				<li style="padding:0;display: none;" id="mylist">
					<textarea id="bulletin_ke_content" name="content" style="width:100%;height:220px"></textarea>
				</li>
				<li class="bbs-tijiao">
					<input type="button" onfocus="this.blur();" style="margin-left:10px;" onclick="saveReply(this);return false;" href="javascript:void(-1);" class="btn_b45 rt bt-blue-l" value="提 交"/>
					<div style="float: left;">
						是否显示电话：
						<label hidefocus class="blue"><input hidefocus name="SHOW_TEL" checked="checked" type="radio" value="1" />是</label> 
						<label class="blue"><input name="SHOW_TEL" type="radio" value="0" />否</label>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<form method='post' name='deleteone'></form>
	<c:if test="${bulletinInfo.bulletBound eq 8 and bulletinInfo.newsBackUrl eq 'images/goodNews/02.png'}">
		<style>
			#bulletContentDiv{width: 690px !important;}
		</style>
	</c:if>
	<script language="javascript" src="../publicJs/ClientCachePlugin.js"></script>
	<script language="javascript">
		$(document).ready(function () {
			//注册客户端交互控件
			ClientCachePlugin.regist();
			window.onresize = function(){
				$("#divPayment").css("marginLeft",(window.innerWidth/2)-352 +"px");
				$("#divPayment").css("marginTop",(window.innerHeight/2)-219 +"px");
			}
			window.onresize();
		});
		var showReply = 0;
		/* 分页，转到其它页 */
		function goOtherPage( pageOffset ){
			if(pageOffset>0 && pageOffset<=parseInt("${pageRows}") && pageOffset!=parseInt("${pageOffset}")){
				var param = new Array();
				param.push("CLIENTKEY=${CLIENTKEY}");
				param.push("BULLET_ID=${bulletinInfo.bulletId}");
				param.push("BULLET_BOUND=${bulletinInfo.bulletBound}");
				param.push("PAGE_OFFSET=" + pageOffset);
				param.push("PAGE_ROW_TOTAL=${pageRows}");
				param.push("PAGE_ROWS=${pageRowSize}");
				param.push("showReply=" + showReply);
				param.push("mtyefmupn="+new Date().getMilliseconds());
				document.base.action = "${SITE_ROOT_URL}/web/bulletin/getBulletinInfo?" + param.join("&");
				document.base.submit();
			}
		}
		function showDetail(){
			if(document.getElementById('detailDiv').style.display == 'none'){
				document.getElementById('detailDiv').style.display='';
			}else{
				document.getElementById('detailDiv').style.display = 'none';
			}
		}
		var saveInfo="save";
		var replyId = "";
		function saveReply(obj){
			var ch1 = document.getElementById("checkbox");
			var ch2 = document.getElementById("checkbox2");
			if('${operator.operatorHT["SUPER_USER"]}' == "0" && '${operator.operatorHT["MANAGE_FLAG"]}' == "1"
				&& ((ch1 && ch1.checked) || (ch2 && ch2.checked))){
				document.getElementById("CCustObj").judgeO2O(3);
				return;
			}
			
			if("${ADD_COMMUNIC_INFO}" != "true"){
				document.getElementById("CCustObj").openMessageBox("您没有权限回复公告信息",3,1);
				return;
			}
			//如果没有实名认证 并且当前城市关闭不通过实名认证发帖
			if("${userRight}" == "0" && "${operator.operatorHT.BULLET_FLAG}" == "0" 
				&& ($("#bound").val()=="2" || $("#bound").val()=="3" 
				|| $("#bound").val()=="4" || $("#bound").val()=="5")){
				document.getElementById("CCustObj").openMessageBox("您未通过实名认证",3,1);
				return;
			}
			if("${ALLOW_CITY_BBS}"=="0" && ($("#bound").val()=="2" || $("#bound").val()=="3")){
				document.getElementById("CCustObj").openMessageBox("您的公司未开启“同城交流”平台，不能发布此类信息",3,1);
				return;
			}
			if($("#bound").val()=="2" || $("#bound").val()=="3" || $("#bound").val()=="4" || $("#bound").val()=="5"){
				//0 正常发言 1 终身经验 否则 禁言时间
				if("${bulletinStatus}" == "0"){
					toDoSave();
				}else if("${bulletinStatus}" == "1"){
					document.getElementById("CCustObj").openMessageBox("你违反公告信息发布管理办法，已被终身禁言",3,1);
				}else{
					document.getElementById("CCustObj").openMessageBox("你违反公告信息发布管理办法，${bulletinStatus} 前将不能对外发布信息",3,1);
				}
			}else{
				toDoSave();
			}
		}

		function toDoSave(){
			document.getElementById("mycontentDiv").innerHTML=editor.html();
			if(document.getElementById("mycontentDiv").innerHTML.replace(/(\r\n)|(\r)|(\n)/gi,"").replaceAll("&nbsp;","").replaceAll(" ","").replaceAll("<br>","")==""){
				document.getElementById("CCustObj").openMessageBox("内容必填",3,1);
				editor.focus();
				return;
			}
			document.getElementById("mycontentDiv").innerHTML = document.getElementById("mycontentDiv").innerHTML.replace(/(<SPAN.*?>)|(<\/SPAN>)|(<span.*?>)|(<\/span>) /gi,"");
			if(document.getElementById("mycontentDiv").innerHTML.replace(/(<.*?>)|(\r\n)|(\r)|(\n)/gi,"").length>10000){
				document.getElementById("CCustObj").openMessageBox("回复内容不能超过1000字",3,1);
				return;
			}
			
			var temp = document.getElementById("mycontentDiv").innerHTML;
			if(saveInfo=="save" && temp.indexOf("回复")==-1){
				document.getElementById("RELATE_ID").value = "";
			}
			$("#mycontentDiv .replyQuote").remove();
			temp = document.getElementById("mycontentDiv").innerHTML;
			temp = temp.replace(/script/gi,"");
			temp = temp.replaceAll("<A","<A target='_blank'");
			temp = temp.replaceAll("<a","<a target='_blank'");
			temp = temp.replaceAll("&lt;a","&lt;a target='_blank'");
			temp = temp.replaceAll("&lt;A","&lt;A target='_blank'");
			document.getElementById("mycontent").value=temp.replaceAll("${operator.operatorHT.BULLET_PIC_DOC}","hftImagesUrlAddress").replaceAll("${operator.operatorHT.USER_BASE_DOC}"+biaoqingPath,"hftImagesUrlAddress");
			//请求url
			var requestUrl = "";
			//参数
			var param = new Array();
			if(saveInfo=="update"){
				//更新
				param = new Array();
				param.push("REPLY_ID=" + replyId);
				param.push("BULLET_BOUND=" + $("#bound").val());
				param.push("BULLET_ID=" + $("#bulletinId").val());
				requestUrl = "${SITE_ROOT_URL}/web/bulletin/updateReply?";
			}else if(temp.indexOf("replyQuote")==-1){
				//普通回复
				param = new Array();
				param.push("CLIENTKEY=${CLIENTKEY}");
				param.push("BULLET_ID=" + $("#bulletinId").val());
				param.push("BULLET_BOUND=" + $("#bound").val());
				param.push("ARCHIVE_ID=" + replyArchiveId);
				param.push("USER_ID=" + replyUserId);
				param.push("bcType=" + bcType);
				param.push("useReplyId=" + useReplyId);
				requestUrl = "${SITE_ROOT_URL}/web/bulletin/createReply?";
			}
			
			if(requestUrl == ""){
				document.getElementById("CCustObj").openMessageBox("参数出错",3,1);
				return;
			}
			requestUrl += param.join("&");
			//提交数据
			var postData = $("#myform").serialize();
			//保存当前回复 然后刷新页面
			$.ajax({
				type: "POST",
				url: requestUrl,
				data: postData,
				success: function(result){
					if(result.resultCode == "success"){
						document.getElementById("CCustObj").openMessageBox("提交成功",4,1);
						window.location.href += "PAGE_OFFSET=${pageOffset}";
						window.location.reload();
					}else if(result.resultCode == "exception"){
						document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
					}else if(result.resultCode == "paramError"){
						document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
					}else if(result.resultCode == "delete"){
						document.getElementById("CCustObj").openMessageBox("当前帖子已经被删除,请刷新列表",3,1);
					}else if(result.resultCode == "canNotVerify"){
						document.getElementById("CCustObj").openMessageBox("您未通过实名认证",3,1);
					}
				}
			});
		}
		function edit(){
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			param.push("BULLET_ID=" + $("#bulletinId").val());
			param.push("BULLET_BOUND=" + $("#bound").val());
			window.location.href = "${SITE_ROOT_URL}/web/bulletin/getCreateBulletinPage?" + param.join("&");
		}
		function refresh(){
			if(document.getElementById("CCustObj").openMessageBox("确定刷新本条信息吗?",3,2) == 1){
				var param = new Array();
				param.push("CLIENTKEY=${CLIENTKEY}");
				param.push("BULLET_ID=" + $("#bulletinId").val());
				param.push("BULLET_BOUND=" + $("#bound").val());
				
				$.ajax({
					type: "POST",
					url: "${SITE_ROOT_URL}/web/bulletin/refreshBullet",
					data: param.join("&"),
					success: function(result){
						if(result.resultCode == "success"){
							document.getElementById("CCustObj").openMessageBox("刷新成功",4,1);
							window.location.reload();
						}else if(result.resultCode == "exception"){
							document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
						}else if(result.resultCode == "paramError"){
							document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
						}
					}
				});
			}
		}
		function toremove(obj){
			if(document.getElementById("CCustObj").openMessageBox("确定删除本条信息吗?",3,2) == 1){
				var param = new Array();
				param.push("CLIENTKEY=${CLIENTKEY}");
				param.push("BULLET_BOUND=" + $("#bound").val());
				param.push("BULLET_ID=" + $("#bulletinId").val());
				$.ajax({
					type: "POST",
					url: "${SITE_ROOT_URL}/web/bulletin/deleteBulletin?" + param.join("&"),
					success: function(result){
						if(result.resultCode == "success"){
							//调用客户端刷新列表
							try{
								document.getElementById("CHomePageAdapter").refreshBulletinList($("#bound").val(), $("#bulletinId").val(), 1);
							}catch(e){
								document.getElementById("CCustObj").openMessageBox("请手动刷新列表",3,1);
							}
							window.location.reload();
						}else if(result.resultCode == "exception"){
							document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
						}else if(result.resultCode == "paramError"){
							document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
						}
					}
				});
			}
		}
		function addStick(obj){
			var operate = "0";
			if(obj.innerHTML=="置顶"){
				operate = "1";
			}
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			param.push("BULLET_BOUND=" + $("#bound").val());
			param.push("BULLET_ID=" + $("#bulletinId").val());
			param.push("operate=" + operate);
			$.ajax({
				type: "POST",
				url: "${SITE_ROOT_URL}/web/bulletin/updateStick?" + param.join("&"),
				success: function(result){
					if(result.resultCode == "success"){
						if(operate=="1"){
							obj.innerHTML="取消置顶";
						}else{
							obj.innerHTML="置顶";
						}
						document.getElementById("CCustObj").openMessageBox("操作成功",4,1);
					}else if(result.resultCode == "exception"){
						document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
					}else if(result.resultCode == "paramError"){
						document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
					}
				}
			});
		}
		$(document).ready(function () {
			$.fn.toggleCheckbox = function () {
				this.attr('checked', !this.attr('checked'));
			}
			$('input[type="radio"]').each(function (index, element) {
				if (element.checked == true) {
					$(element).wrap('<div class="radio-btn checkedRadio"><i></i></div>');
				} else {
					$(element).wrap('<div class="radio-btn"><i></i></div>');
				}
			})
			$('.radio-btn').bind('click', function (event) {
				var _this = $(this),
					block = _this.parent().parent();
					checkName = _this.children().children().attr("name");
				block.find('input:radio[name=' + checkName + ']').attr('checked', false);
				$(".radio-btn").children().children().each(function (index, element) {
					if (element.name == checkName) {
						$(element).parent().parent().removeClass('checkedRadio');
					}
				});
				_this.addClass('checkedRadio');
				_this.find('input:radio').attr('checked', "checked");
				_this.find('input:radio')[0].checked = true;
				_this.find('input:radio').trigger("change");
				event.preventDefault();
			});
			$('input[type="checkbox"]').each(function (index, element) {
				if (element.checked == true) {
					if (element.disabled == true) {
						$(element).wrap('<div class="check-box1 checkedBoxDisable1"><i></i></div>');
					} else {
						$(element).wrap('<div class="check-box1 checkedBox1"><i></i></div>');
					}
				} else {
					if (element.disabled == true) {
						$(element).wrap('<div class="check-box1 checkedBoxUnDisable1"><i></i></div>');
					} else {
						$(element).wrap('<div class="check-box1"><i></i></div>');
					}
				}	
			});
			$('.check-box1').bind('click', function () {
				if ($(this).children().children()[0].disabled == false) {
					$(this).find(':checkbox').toggleCheckbox();
					$(this).toggleClass('checkedBox1');
					if ($(this).hasClass("checkedBox1") == true) {
						$(this).children().children()[0].checked = true;
					} else {
						$(this).children().children()[0].checked = false; 
					}
					$(this).children().children().trigger("change");
				}
				event.preventDefault();
			});
		});
		var html="";
		var useReplyId="";
		var bcType = "";
		function use(user,stime,reply,lou,usereplyid,archiveId,userId,userName ){
			bcType="6";
			useReplyId = usereplyid;
			replyArchiveId = archiveId;
			replyUserId = userId;
			saveInfo = "save";
			replyUserName = userName;
			window.scroll(0,document.body.scrollHeight);
			editor.focus();
			var content = document.getElementById(reply).innerHTML;
			html = "<DIV class=replyQuote>引用: "+lou+" 楼 " +document.getElementById(user).innerHTML+" 在  "+document.getElementById(stime).innerHTML+"的回复 : "+content+"</DIV><br /> ";
			editor.html(html);
		//	KE.util.insertHtml(id, html);
		}
		//修改回复
		function updateReply(id){
			saveInfo = "update";
			replyId = id;
			editor.html(document.getElementById(id+"a").innerHTML);
			window.scroll(0,document.body.scrollHeight);
			editor.focus(); 
		}
		function relpy(){
			saveInfo = "save";
			window.scroll(0,document.body.scrollHeight);
			editor.focus();  
		}
		//被回复人的archiveId
		var replyArchiveId="0";
		var replyUserId="0";
		var replyUserName = "";
		function toreply(mytime,user,lou,archiveId,userId,userName,replyId){
			bcType="5";
			replyArchiveId = archiveId;
			replyUserId = userId;
			replyUserName = userName;
			saveInfo = "save";
			document.getElementById("RELATE_ID").value = replyId;
			editor.focus();  
			editor.html("<DIV class=replyQuote><p align='left'> 回复: "+ lou + "楼  "+document.getElementById(user).innerHTML+" 在 "+document.getElementById(mytime).innerHTML+" 的回复</p></DIV><br /> ");
			window.scroll(0,document.body.scrollHeight);
		}
		function updateVote(){
			var voteType = "";
			var input = document.getElementsByName("voteItem");
			for(var i=0;i<input.length;i++){
				if(input[i].checked==true){
					voteType = voteType+input[i].value+";";
				}
			}
			if(voteType!=""){
				var param = new Array();
				param.push("CLIENTKEY=${CLIENTKEY}");
				param.push("BULLET_BOUND=" + $("#bound").val());
				param.push("BULLET_ID=" + $("#bulletinId").val());
				param.push("voteType=" + voteType);
				$.ajax({
					type: "POST",
					url: "${SITE_ROOT_URL}/web/bulletin/updateVote?" + param.join("&"),
					success: function(result){
						if(result.resultCode == "success"){
							window.location.reload();
						}else if(result.resultCode == "exception"){
							document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
						}else if(result.resultCode == "paramError"){
							document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
						}
					}
				});
			}else{
				document.getElementById("CCustObj").openMessageBox("请至少选择一项",3,1);
			}
		}
		function deleteReply(replyId){
			if(document.getElementById("CCustObj").openMessageBox("确定删除吗?",3,2) == 1){
				var param = new Array();
				param.push("CLIENTKEY=${CLIENTKEY}");
				param.push("REPLY_ID=" + replyId);
				param.push("BULLET_BOUND=" + $("#bound").val());
				param.push("BULLET_ID=" + $("#bulletinId").val());
				$.ajax({
					type: "POST",
					url: "${SITE_ROOT_URL}/web/bulletin/deleteReply?" + param.join("&"),
					success: function(result){
						if(result.resultCode == "success"){
							document.getElementById("CCustObj").openMessageBox("删除成功",4,1);
							window.location.reload();
						}else if(result.resultCode == "exception"){
							document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
						}else if(result.resultCode == "paramError"){
							document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
						}
					}
				});
			}
		}
		function init(){
			document.getElementById("mylist").style.display="";
			$("body").append("<object type='application/x-qt-plugin' style='witdh:0px;height:0px;' classid='CHomePageAdapter' id='CHomePageAdapter'/>");
		}
		function zan(replyId,index){
			document.getElementById("zanImg"+index).src = "images/zan_done.png";
			document.getElementById("zanImg"+index).style.cursor = "default";
			document.getElementById("zanImg"+index).onclick = "";
			document.getElementById("zanImg"+index).onmouseover = "";
			document.getElementById("zanImg"+index).onmouseout = "";
			document.getElementById("zanCount"+index).innerHTML = parseInt(document.getElementById("zanCount"+index).innerHTML)+1;
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			param.push("BULLET_BOUND=" + $("#bound").val());
			param.push("BULLET_ID=" + $("#bulletinId").val());
			param.push("replyId=" + replyId);
			$.post("${SITE_ROOT_URL}/web/bulletin/zanLog", param.join("&"));
		}
		function closePayment(obj){
			$(obj).parent().css("display","none"); $(obj).parent().prev().css("display","none");
		}
	</script>
</body>
</html>