<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="../common/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!-- com.myfun.erpWeb.bulletin.BulletinController#bulletinInfo -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html oncontextmenu="return false;" style="overflow-x:hidden;overflow-y:auto;" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="${statics}/bulletin/" target="_self"/>
	<title>好房通</title>
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${statics}css/button.css" rel="stylesheet" type="text/css" />
	<link href="${statics}bulletinNew/css/style-bbs.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="${statics}publicJs/jquery-3.3.1.min.js"></script>
	<script language="javascript" src="${statics}publicJs/layer/layer.js"></script>
	<style>
		.content-out1{width: 100%;height:100%;box-sizing: border-box;padding-top: 0px;}
		.content-out2{overflow-y: auto;overflow-x:hidden; height: inherit;margin-top: 30px;}
		.content-out3{height: 100%;padding-top: 0px;box-sizing: border-box;padding-bottom: 20px;}
		.content{max-width: 830px;padding: 45px 45px 15px 45px;background-color: #fff;box-sizing: border-box;min-height: 100%;}
		.bullet-subject{font-weight: bold;font-size: 18px;text-align: center;color: #555;}
		.bullet-read-info{border-bottom: 1px solid #eee;padding: 20px 0 20px 0;}
		.bullet-read-count{float: right;vertical-align:middle;}
		.bullet-content{padding-top: 20px;}
		.bullet-content img{max-width: 580px;}
		
		.stick-bulletin,.edit-bulletin,.delete-bulletin{cursor: pointer;width: 15px;height: 14px;}

		.text-center{text-align: center;}
		
		.comment-show{margin: 20px 0;padding-bottom: 5px; border-bottom: 1px solid #eee;color: #555;font-weight: bold;}
		.comment-show .text{border-bottom: 2px solid #db0b2e;padding-bottom: 5px;}
		.comment-text{height: 85px;width: 100%;resize: none;box-sizing: border-box;padding: 8px;border: 1px solid #ccc;outline: none;border-radius: 3px;}
		.comment-submit{height: 50px;}
		.comment-submit .submit{
			float: right;margin: 10px 0 0 0;padding: 5px 20px;background-color: #1794ea;color: #fff;
			border: 0; cursor: pointer; border-radius: 3px;outline: none;
		}
		.comment-submit .submit:hover{background-color: #1572a9;}
		.comment-submit .submit.disable{background-color: #ccc !important;}
		
		#inputMid{float: right; margin-top: -20px; margin-right: 4px; text-align: right; position: relative;}
		
		.comment-hot{background-color: #f6f6f6;width: 100%;height: 50px;margin: 20px 0; line-height: 50px;}
		.comment-hot span{padding-left: 10px;color: #555;font-weight: bold;}
		
		p, li {white-space: normal !important;}
		
		.comment-content{margin-bottom: 50px;}
		.comment-content ul li{padding: 10px;}
		.comment-content ul li.relate{background-color: #f6f6f6;margin-top: 0px;}
		.comment-content ul li.relate .options{border-bottom: 1px solid #ccc; padding-bottom: 10px;}
		.comment-content ul li.relate-last .options{border-bottom: 0;padding-bottom: 0;}
		.comment-content ul li .user-photo{vertical-align: middle;border-radius: 50%;width: 100%;height: 100%;}
		.comment-content ul li .relate-user-name{color: #1794ea;}
		.comment-content ul li .user-name{margin-left: 5px; color: #1794ea;}
		.comment-content ul li .contents{margin-left: 40px;margin-top: 5px;}
		.comment-content ul li .contents .options{margin-top: 10px;}
		.comment-content ul li .contents .options .right{float: right;}
		.comment-content ul li .contents .options .right .divide{vertical-align: top;}
		.comment-content ul li .contents .options .right .replay{cursor: pointer;}
		.comment-content ul li .contents .options .right .delete{cursor: pointer;}
		.comment-content ul li .contents .options .right .like{cursor: pointer;}
		.comment-content ul li .contents .options .right .like img{width: 15px;height: 15px;vertical-align: text-top;}
		
		#fileList{margin-top: 30px; height: 35px;}
		#fileList li{background-color: #f7f7f7; list-style:none; float: left;width: 176px;padding:5px; margin-right: 10px;cursor: pointer;}
		#fileList li:last-child{margin-right: 0;}
		#fileList li .icon{width: 28px; height: 28px;float: left;margin-right: 5px;}
		#fileList li .close{width: 20px; height: 16px;float: right;margin: 8px 5px 0 0;cursor: pointer;}
		#fileList li .file-name{white-space:nowrap;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;}
	</style>
</head>
<body scroll="no" oncontextmenu="return false" onselectstart="return false" onbeforecopy="return false">
	<div align="center" class="content-out1">
		<div align="center" class="content-out2">
			<div class="content-out3 scrollbar">
			<div align="left" class="content">
				<div class="bullet-subject">
					${bulletinInfo.bulletSubject}
				</div>
				<div class="bullet-read-info">
					<span>
						${empty bulletinInfo.contract ? bulletinInfo.userName :bulletinInfo.contract} 　/　 ${cf:dateFormatStr(bulletinInfo.bulletTime,'yyyy-MM-dd')}　/　阅读数：${bulletinInfo.clickCount}
					</span>
					<c:if test="${isSwitchCompLogin eq 0}">
						<span class="bullet-read-count">
							<c:if test="${bulletinInfo.canEdit eq 1}">
								<img class="stick-bulletin" style="vertical-align:middle;" id="stick-img" val="${bulletinInfo.stick ? '1' : '0'}" title="${bulletinInfo.stick ? '取消置顶' : '置顶'}" src="${statics}bulletinNew/img/options/${bulletinInfo.stick ? 'untop' : 'top'}.png"/>
	                            <span class="stick-bulletin"  id="stick" val="${bulletinInfo.stick ? '1' : '0'}" style="vertical-align:middle;color: #1E9FFF">
	                                ${bulletinInfo.stick ? '取消置顶' : '置顶'}
	                            </span>
	                            &nbsp;&nbsp;&nbsp;
	                            <img class="edit-bulletin" style="vertical-align:middle;"  src="${statics}bulletinNew/img/options/edit.png" title="修改"/>
								<span class="edit-bulletin" style="vertical-align:middle;color: #1E9FFF">修改</span>
	                            &nbsp;&nbsp;&nbsp;
							</c:if>
	
							<c:if test="${bulletinInfo.canDelete eq 1}">
								<img class="delete-bulletin" style="vertical-align:middle;" src="${statics}bulletinNew/img/options/delete.png" title="删除"/>
								<span class="delete-bulletin" style="vertical-align:middle;color: #1E9FFF">删除</span>
							</c:if>
						</span>
					</c:if>
				</div>
                <div class="bullet-content">
                    ${bulletinInfo.bulletContent}
					<ul id="fileList">
						<c:forEach items="${bulletinPsPOs}" var="bulletinPs" varStatus="status">
							<li url="${bulletinPs.psPath}" title="${bulletinPs.fileName}">
								<div>
									<img class="icon" src="${statics}bulletinNew/img/file/${bulletinPs.fileType}.png" />
									<%-- <img class="close" src="${statics}bulletinNew/img/close.png" /> --%>
									<div class="file-name">${bulletinPs.fileName}<br/>${bulletinPs.fileSizeStr}</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<c:if test="${bulletinInfo.replyStatus eq 0 or fn:length(replayList) > 0}">
				<div class="comment-show">
					<span class="text">评论</span>
				</div>
				<div>
					<c:choose>
						<c:when test="${bulletinInfo.replyStatus eq 1}">
							<div class="text-center">发表评论功能已关闭</div>
						</c:when>
												
						<c:otherwise>
							<c:if test="${isSwitchCompLogin eq 0}">
								<textarea class="comment-text" id="commentText" placeholder="你有什么看法..." bulletId="" replyId="" mainRelateId=""></textarea>
								<div id="inputMid">0/100</div>
								
								<div class="comment-submit">
									<input type="button" value="提交" class="submit" id="submitComment"/>
								</div>
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
				<!--
				<div class="comment-hot">
					<span>热门评论</span>
				</div>
				-->
				<!--回复列表-->
				<div class="comment-content">
					<ul>
						<c:forEach items="${replayList}" var="replay" varStatus="status">
						<li class="${empty replay.relateId or replay.relateId eq 0 ? '' : 'relate'} ${replay.lastSubRelate eq 1 ? 'relate-last' : ''}">
							<div>
								<div style="height: 35px;width:35px;float: left"><img src="${replay.userPhoto}" class="user-photo"/></div>
								<span class="user-name">${replay.userName}</span>
							</div>
							<div class="contents">
								<div>
									<c:if test="${not empty replay.relateUserName}">
										<span class="relate-user-name">回复${replay.relateUserName}：</span>
									</c:if>
									${replay.contents}
								</div>
								<div class="options">
									<span>${cf:dateFormatStr(replay.creationTime,'yyyy/MM/dd HH:mm')}</span>
									<span class="right option-data" replyId="${replay.replyId}" mainRelateId="${replay.mainRelateId}" bulletId="${replay.bulletId}" userName="${replay.userName}">
										<c:if test="${isSwitchCompLogin eq 0}">
											<c:if test="${bulletinInfo.canDelete eq 1 or replay.isSelfReply eq 1}">
												<span class="delete">删除</span>　
												<span class="divide">|</span>　
											</c:if>
										</c:if>
<%-- 										<c:if test="${bulletinInfo.replyStatus eq 0 and replay.isSelfReply eq 0}"> --%>
<!-- 											<span class="replay">回复</span>　 -->
<!-- 											<span class="divide">|</span>　 -->
<%-- 										</c:if> --%>
										<span class="like">
											<img class="zan-img" src="${statics}bulletinNew/img/options/${replay.selfZan eq 1 ? 'zaned' : 'zan'}.png"/>
											<span class="zan-count">${replay.zan}</span>
										</span>
									</span>
								</div>
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>
				</c:if>
			</div>
			</div>
		</div>
	</div>
	<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
	<script language="javascript">
		function getNotEmpty(str){
			if(!str || str == "" || str == null) {
				return "";
			}
			return str;
		}
		$(".like").click(function() {
			var data = $(this).parent(".option-data");
			var param = new Array();
			param.push("CLIENTKEY=${clientKey}");
			param.push("bulletId=${bulletId}");
			param.push("replyId=" + $(data).attr("replyId"));
			var lastZanObj = this;
			$.ajax({
				type: "POST", url: "${ctx}bulletinNew/addBulletReplyZan?" + param.join("&"),
				success: function(result){
					if(result.errCode == 200) {
						var zanCount = $(lastZanObj).find(".zan-count").text();
						$(lastZanObj).find(".zan-count").text(parseInt(zanCount) + 1);
						$(lastZanObj).find(".zan-img").attr("src", "${statics}bulletinNew/img/options/zaned.png");
						layer.msg("点赞成功", {time:1000});
					} else {
						layer.msg(result.errMsg, {time:1000});
					}
				}
			});
		});
		$("#commentText").on("input", function() {
			var titleText = $("#commentText").val();
			var titleLen = titleText.length;
			if(titleLen > 100) {
				titleLen = 100;
				$("#commentText").val(titleText.substr(0, 100));
			}
			$("#inputMid").text(titleLen + "/100");
		});
		$(".replay").click(function() {
			var data = $(this).parent(".option-data");
			$("#commentText").attr("replyId", $(data).attr("replyId"));
			$("#commentText").attr("mainRelateId", getNotEmpty($(data).attr("mainRelateId")));
			$("#commentText").attr("placeholder", "回复：" + $(data).attr("userName"));
			$("#commentText").val("").focus();
		});
		$(".stick-bulletin").click(function() {
			var stick = ($(this).attr("val") == 1) ? 0 : 1;
			var param = new Array();
			param.push("CLIENTKEY=${clientKey}");
			param.push("bulletId=${bulletId}");
			param.push("stick=" + stick);
			var stickObj = this;
			$.ajax({
				type: "POST", url: "${ctx}bulletinNew/updateBulletStick?" + param.join("&"),
				success: function(result){
					if(result.errCode == 200) {
						if(stick == 1) {
							layer.msg("置顶成功！", {time:1000});
                            $("#stick-img").attr("val", 1).attr("title", "取消置顶");
							$("#stick-img").attr("src", "${statics}bulletinNew/img/options/untop.png");
                            $("#stick").attr("val",1);
                            $("#stick").html("取消置顶");

                        } else {
							layer.msg("取消置顶成功！", {time:1000});
                            $("#stick-img").attr("val", 0).attr("title", "置顶");
                            $("#stick-img").attr("src", "${statics}bulletinNew/img/options/top.png");
                            $("#stick").attr("val",0);
                            $("#stick").html("置顶");
                        }
					} else {
						layer.msg(result.errMsg, {time:1000});
					}
				}
			});
		});
		$(".delete-bulletin").click(function() {
			layer.confirm('确定要删除吗？', function(index) {
				layer.close(index);
				var param = new Array();
				param.push("CLIENTKEY=${clientKey}");
				param.push("bulletId=${bulletId}");
				$.ajax({
					type: "POST", url: "${ctx}bulletinNew/deleteBullet?" + param.join("&"),
					success: function(result){
						if(result.errCode == 200) {
							layer.msg("删除成功！", {time:1000});
							location.reload();
						} else {
							layer.msg(result.errMsg, {time:1000});
						}
					}
				});
			});
		});
		$(".edit-bulletin").click(function() {
			window.location.href = "${ctx}bulletinNew/createBullet?CLIENTKEY=${clientKey}&bulletId=${bulletId}";
		});
		$(".delete").click(function() {
			var data = $(this).parent(".option-data");
			var param = new Array();
			param.push("CLIENTKEY=${clientKey}");
			param.push("bulletId=${bulletId}");
			param.push("replyId=" + $(data).attr("replyId"));
			var lastDeleteObj = this;
			$.ajax({
				type: "POST", url: "${ctx}bulletinNew/deleteBulletReply?" + param.join("&"),
				success: function(result){
					if(result.errCode == 200) {
						$(lastDeleteObj).parents("li").remove();
						layer.msg("删除成功！", {time:1000});
					} else {
						layer.msg(result.errMsg, {time:1000});
					}
				}
			});
		});
		$("#fileList li").click(function() {
			var url = $(this).attr("url");
			//window.open(url);
			document.getElementById("CCustObj").openWindow(url);
		});
		$("#submitComment").click(function() {
			//0 正常发言 1 终身经验 否则 禁言时间，bound=2/3/4/5的时候才判断
			/* if("${bulletinStatus}" == "1"){
				layer.open({title: '提示', icon: 2, content: '你违反公告信息发布管理办法，已被终身禁言'});
				return;
			} else {
				layer.open({title: '提示', icon: 2, content: '你违反公告信息发布管理办法，${bulletinStatus} 前将不能对外发布信息'});
				return;
			}
			if("${addCommunicInfo}" != "1"){
				layer.open({title: '提示', icon: 2, content: '您没有权限回复公告信息'});
				return;
			} */
			var commentText = getNotEmpty($("#commentText").val());
			if(commentText == "") {
				layer.msg("回复内容不能为空", {time:1000});return;
			}
			var param = new Array();
			param.push("CLIENTKEY=${clientKey}");
			param.push("bulletBound=${bulletBound}");
			param.push("bulletId=${bulletId}");
			param.push("relateId=" + getNotEmpty($("#commentText").attr("replyId")));
			param.push("mainRelateId=" + $("#commentText").attr("mainRelateId"));
			param.push("contents=" + commentText);
			var lastReplyObj = this;
			$.ajax({
				type: "POST", url: "${ctx}bulletinNew/addBulletReply?" + param.join("&"),
				success: function(result){
					if(result.errCode == 200) {
						$("#commentText").val("");
						layer.msg("回复成功", {time:1000});
						location.reload();
					} else {
						layer.msg(result.errMsg, {time:1000});
					}
				}
			});
		});
	</script>
</body>
</html>

