<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="../common/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!-- com.myfun.erpWeb.bulletin.BulletinController#bulletinInfo -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html oncontextmenu="return false;" style="overflow:hidden;" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="${statics}/bulletin/" target="_self"/>
	<title>好房通</title>
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${statics}css/button.css" rel="stylesheet" type="text/css" />
	<link href="${statics}bulletinNew/css/style-bbs.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${statics}publicJs/layui/css/layui.css">
	<script language="javascript" src="${statics}publicJs/jquery-3.3.1.min.js"></script>
	<script language="javascript" src="${statics}publicJs/layer/layer.js"></script>
	<script language="javascript" src="${statics}publicJs/layui/layui.all.js"></script>
	<script type="text/javascript">
		var basePath = "${operator.operatorHT.HOUSE_PIC_DOC}";
	</script>
	<style>
		.content-out1{width: 100%;height:100%; overflow-x:hidden;overflow-y:auto;box-sizing: border-box;}
		.bullet-subject{font-weight: bold;font-size: 18px;text-align: center;color: #555;}
		.bullet-read-info{border-bottom: 1px solid #eee;padding: 20px 0 20px 0;}
		.bullet-read-count{float: right;}
		.bullet-content{padding-top: 20px;}
		.bullet-subject{font-weight: bold;font-size: 16px;text-align: left;color: #555;border-bottom: 1px solid #ddd;padding-bottom: 10px;}
		
		.content{width: 100%;margin-top: 20px; padding: 0 10px 20px 0;}
		.content .item{margin-top: 10px;}
		.title-input{padding: 0 15px;}
		#bulletinTitle{padding: 0 10px;}
		#uploadBulletImg{display: none;}
		.float-right{float: right;}
		.checkbox{padding: 12px 0 0 10px;}
		#fileList{margin-top: 10px; height: 40px;display: none;}
		#fileList li{background-color: #f7f7f7; list-style:none; float: left;width: 220px;padding:5px; margin-right: 20px;}
		#fileList li .icon{width: 28px; height: 28px;float: left;margin-right: 5px;}
		#fileList li .close{width: 20px; height: 16px;float: right;margin: 8px 5px 0 0;cursor: pointer;}
		#fileList li .file-name{white-space:nowrap;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;}
		
		body{background-color: #EFF4F9;}
		html{height: auto;}
		
		#bulletinTitle,.layui-form-select .layui-input{
			height:30px;
			border-radius: 3px;
			outline: none;
			transition: box-shadow 0.3s, border 0.3s;
			font-size: 14px;
			-webkit-transition: box-shadow 0.3s, border 0.3s;
			box-shadow: 0 0 3px #ddd inset !important;
			-moz-appearance: textfield !important;
		}
		.content{width: 790px;background-color: #fff;padding: 20px;}
		.layui-form-select{text-align: center;}
		.bullet-bounds-div .layui-form-select{width: 100px;position: absolute;}
		#toSave{width: 80px;background-size: 80px 30px;margin-top: 5px;}
		.add-appendix{border: 0;background-color: #fff;cursor: pointer;border-right: 1px solid #cdcdcd; padding-right: 7px;}
		#bulletinTitleMid{padding-top: 8px;}
		
		.ke-statusbar {height: 0px !important;}
	</style>
	<script type="application/javascript">
		var hasFile = 0;
        $(function () {
           if(${null != bulletinPsPOs and bulletinPsPOs.size() > 0}) {
                hasFile = 1;
		   }
           resetWindow();
        });
        $(window).resize(function() {
            resetWindow();
        });
        
		function resetWindow() {
            var v = $(window).height();
            $("#contentDiv").height(v-80);
            $(".ke-edit").height(v-270-(parseInt(hasFile)*50));
            $(".ke-edit-iframe").height(v-270-(parseInt(hasFile)*50));
        }
	</script>
</head>
<body scroll="no" oncontextmenu="return false" onselectstart="return false" onbeforecopy="return false">
	<div align="center" class="content-out1 layui-form" style="height: 100%">
		<div align="left" id="contentDiv" class="content" style="position:relative;">
			<div class="layui-row">
				<div class="layui-col-xs2">
					<select lay-verify="required" class="layui-col-md2" id="bulletType">
						<option value="3" ${bulletinInfo.bulletType eq 3 ? 'selected' : ''}>公告通知</option>
						<option value="1" ${bulletinInfo.bulletType eq 1 ? 'selected' : ''}>签单喜报</option>
					<%--<option value="2" ${bulletinInfo.bulletType eq 2 ? 'selected' : ''}>内部公示</option>--%>
						<option value="5" ${bulletinInfo.bulletType eq 5 ? 'selected' : ''}>公司制度</option>
						<option value="8" ${bulletinInfo.bulletType eq 8 ? 'selected' : ''}>业务制度</option>

					</select>
				</div>
				<div class="layui-col-xs8 title-input">
					<input type="text" id="bulletinTitle" value="${bulletinInfo.bulletSubject}" placeholder="请输入标题" class="layui-input">
				</div>
				<div class="layui-col-xs2">
					<div id="bulletinTitleMid">还可输入40个字符</div>
				</div>
			</div>
			<div class="item">
				<button type="button" class="layui-btn" id="uploadBulletImg"></button>
				<button type="button" class="add-appendix bg-appendix" id="uploadBulletFile">添加附件</button>
				<ul id="fileList">
					<c:forEach items="${bulletinPsPOs}" var="bulletinPs" varStatus="status">
						<li fileInfo="${bulletinPs.fileName},${bulletinPs.fileSize},${bulletinPs.psPath}" title="${bulletinPs.fileName}">
							<div>
								<img class="icon" src="${statics}bulletinNew/img/file/${bulletinPs.fileType}.png" />
								<img class="close" src="${statics}bulletinNew/img/close.png" />
								<div class="file-name">${bulletinPs.fileName}<br/>${bulletinPs.fileSizeStr}</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="item">
				<textarea id="cbKeContent" style="width: 100%;">${bulletinInfo.bulletContent}</textarea>
			</div>
			<div class="item" style="height: 35px;position:absolute; right:3%; bottom:5%;">
				<div class="float-right" style="display: inline;">
					<c:if test="${not empty bulletId}">
						<button class="bt-blue-l" id="cancelSave">取消修改</button>
					</c:if>
					<button class="bt-blue-l" id="toSave">保存</button>
				</div>
				<div class="checkbox float-right" style="display: inline;">
					<input type="checkbox" id="stick" title="置顶" lay-skin="primary" ${bulletinInfo.stick ? 'checked' : ''}>
					<input type="checkbox" id="replyStatus" title="关闭评论" lay-skin="primary" ${empty bulletinInfo.replyStatus or bulletinInfo.replyStatus eq 1 ? 'checked' : ''}>
				</div>
				<div style="display: inline;width: 170px; padding-right: 5px;" class="bullet-bounds-div float-right" align="right">
					<div style="float: left;padding-top: 13px; font-size: 14px; margin-right: 5px;">接收范围</div>
					<div style="margin-left: 70px;padding-top: 6px;">
						<select lay-verify="required" id="bulletBounds" style="width: 100px;font-size: 12px;">
							<c:if test="${partnerFlag eq 1}">
								<option value="10" ${bulletinInfo.bulletBound eq 10 ? 'selected' : ''}>加盟商</option>
							</c:if>
							<c:if test="${compFlag eq 1}">
								<option value="1" ${bulletinInfo.bulletBound eq 1 ? 'selected' : ''}>全公司</option>
							</c:if>
							<option value="0" ${bulletinInfo.bulletBound eq 0 ? 'selected' : ''}>本门店</option>
						</select>
					</div>
				</div>
			</div>
		</div>
	</div>
	<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height: 0px; width: 0px; display: block;"></object>
	<script type="text/javascript" src="../publicJs/kindeditor/v4.1.7/kindeditor-erp.js"></script>
	<script language="javascript">
		layui.use(['layer', 'form', 'upload'], function(){
			var layer = layui.layer
			,form = layui.form
			,upload = layui.upload;
			form.render(); //更新全部
			var uploadInst = upload.render({
				elem: '#uploadBulletFile' //绑定元素
				,auto: false
				,accept: 'file'
				,size: 5120 //限制文件大小，单位 KB，5M
				,url: '${ctx}bulletinNew/uploaderFile?CLIENTKEY=${clientKey}' //上传接口
				,before: function(obj){
					layer.load();
				},done: function(res){
					//上传完毕回调
                    hasFile = 1;
                    resetWindow();
					layer.closeAll('loading');
					$("#fileList").show();
					var fileName = res.data.fileList[0].fileOldName;
					var filePath = res.data.fileList[0].filePath;
					var fileSize = res.data.fileList[0].fileSize;
					var fileSizeStr = res.data.fileList[0].fileSizeStr;
					var fileType = res.data.fileList[0].fileType;
					$("#fileList").append(
						'<li fileInfo="'+fileName+','+fileSize+','+filePath+'">'
							+'<div>'
								+'<img class="icon" src="${statics}bulletinNew/img/file/' + fileType + '.png" />'
								+'<img class="close" src="${statics}bulletinNew/img/close.png" />'
								+'<div class="file-name" title='+fileName+'>' + fileName + '<br/>' + fileSizeStr + '</div>'
							+'</div>'
						+'</li>'
					);
				},choose: function(){
					if($("#fileList").find("li").length >= 3) {
						layer.msg("最多只能上传3个文件", {time:1000});
					} else {
						uploadInst.upload();
					}
				},error: function(e){
					//请求异常回调
					layer.closeAll('loading');
					console.log(e);
				}
			});
			var uploadImg = upload.render({
				elem: '#uploadBulletImg' //绑定元素
				,auto: true
				,accept: 'file'
				,size: 5120 //限制文件大小，单位 KB，5M
				,url: '${ctx}bulletinNew/uploaderFile?CLIENTKEY=${clientKey}' //上传接口
				,before: function(obj){
					layer.load();
				},done: function(res){
					//上传完毕回调
					layer.closeAll('loading');
					var filePath = res.data.fileList[0].filePath;
					var domain = res.data.domain;
					editor.appendHtml("<img src=" + domain + filePath + "></img>");
				},error: function(e){
					//请求异常回调
					layer.closeAll('loading');
					console.log(e);
				}
			});
		});
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('#cbKeContent', {
				resizeType : 0,
				allowPreviewEmoticons : true,
				allowImageUpload : true,
				filterMode: false,
				items : K.options.items_bulletin,
				cssPath : '${ctx}statics/publicJs/kindeditor/v4.1.7/themes/myfun7.css'
			});
		});
		/* $(document).ready(function () {
			window.onresize = function(){
				$(".content").css("height",(window.innerHeight - 90) + "px");
			}
			window.onresize();
		}); */
		function getNotEmptyStr(str, def){
			if(isEmpty(str)) {
				return isEmpty(def) ? "" : def;
			}
			return str;
		}
		function isEmpty(str) {
			return (str == "" || str == null || str == undefined);
		}
		$("#bulletinTitle").on("input", function() {
			updateCanInputTitleCount();
		});
		$("#fileList").on("click", ".close", function() {
			$(this).parents("li").remove();
			if($("#fileList").find("li").length <= 0) {
                hasFile = 0;
                resetWindow();
				$("#fileList").hide();

			}
		});
		$("#cancelSave").click(function() {
			history.back(-1);
		});
		$("#toSave").click(function() {
			var bulletContent = editor.html();
			var bulletSubject = $("#bulletinTitle").val();
			var bulletBounds = $("#bulletBounds").val();
			var bulletType = $("#bulletType").val();
			var stick = ($('#stick').is(':checked')) ? 1 : 0;// 置顶
			var replyStatus = ($('#replyStatus').is(':checked')) ? 1 : 0;// 关闭回复
			var bulletinPs = "";
			
			$("#fileList li").each(function() {
				bulletinPs += $(this).attr("fileInfo") + ";";
			});
			if(isEmpty(bulletSubject) || bulletSubject.length <= 5) {
				layer.msg("标题不能少于5个文字", {time:1000});return;
			}
			if(isEmpty(bulletContent)) {
				layer.msg("内容不能为空", {time:1000});return;
			}
			$("#toSave").attr('disabled', true);
			$.ajax({
				type : "POST",
				data : {
					bounds:bulletBounds,bulletinPs:bulletinPs,bulletSubject:bulletSubject,
					bulletContent:bulletContent, bulletType: bulletType, bulletId: '${bulletId}',
					replyStatus:replyStatus, stick:stick
				},
				url : "${ctx}bulletinNew/createBullet?CLIENTKEY=${clientKey}",
				success : function(result) {
					if (result.errCode == 200) {
						layer.msg("发布成功", {time : 1000});
						window.location.href = "${ctx}bulletinNew/bulletinInfo?CLIENTKEY=${clientKey}&bulletId=" + result.data;
					} else {
						layer.msg(result.errMsg, {time : 1000});
					}
				}
			});
		});
		function updateCanInputTitleCount() {
			var titleText = $("#bulletinTitle").val();
			var titleLen = titleText.length;
			if(titleLen > 40) {
				titleLen = 40;
				$("#bulletinTitle").val(titleText.substr(0, 40));
			}
			$("#bulletinTitleMid").text("还可输入"+(40 - titleLen)+"个字符");
		}
		updateCanInputTitleCount();
		if($("#fileList").find("li").length > 0) {
			$("#fileList").show();
		}
	</script>
</body>
</html>

