<%@ page contentType="text/html; charset=UTF-8" language="java"  errorPage="../common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html oncontextmenu='' style="overflow-x:hidden;overflow-y:auto;" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>好房通_发布主题帖</title>
	<base href="${statics}/bulletin/" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
	<link href="${statics}bulletin/css/style-bbs.css" rel="stylesheet" type="text/css" />
	<link href="${statics}css/button.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="divMaskLayer" id="divMaskLayer"></div>
<div id="divPayment" class="divPayment">
	<div class="divClose" onclick="closePayment(this)"></div>
	<iframe src="about:blank" id="iframe" border="0" scrolling="no" frameborder="0"></iframe>
</div>
<div id="loading" style="display: none;">
	<div id="loadbox">生成预览中，请稍等......</div>
</div>
<div id="editMode" style="width:610px;margin:0 auto;">
	<form action="" id="base" name="base" method="post">
		<input type="hidden" id="BROADCAST" name="BROADCAST" value="" />
		<input type="hidden" id="BULLET_ID" name="BULLET_ID" value="${bulletId}" />
		<input type="hidden" id="BULLET_BOUND" name="BULLET_BOUND" value="${bulletBound}" />
		<input type="hidden" id="CASE_TYPE" name="CASE_TYPE" value="${param.caseType}" />
		<input type="hidden" id="HOUSE_IDS" name="HOUSE_IDS" value="${param.housingIds}" />
		<div id="mycontentDiv" style="display: none;"></div>
		<input type="hidden" name="isVote" id="isVote" value="0" />
		<input type="hidden" id='mycontent' name="BULLET_CONTENT" />
		<div class="bbs-content">
			<ul style="width:610px;">
				<li class="border1px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" style="height:23px;padding-top:1px;">
						<tr>
							<td width="50"> 主 题：</td>
							<td>
								<input name="BULLET_SUBJECT" type="text" placeholder="标题的长度限制为 30 汉字" value="${bulletinInfo.bulletSubject}" class="ipt-textfield" id="topic" />
							</td>
							<td width="75" align="right">
								<a onfocus="this.blur();" onclick="${empty bulletId ? 'showVote();' : ';'}return false;" id="vote" href="javascript:void(-1);" class="btn_b65 bt-blue-l">
									<span class="im-tp" style="margin-right: 8px;vertical-align: middle;margin-top: -8px;"></span>开启投票
								</a>
							</td>
						</tr>
					</table>
				</li>
				<li>
					<div class="divTip">范 围：</div>
					<c:if test="${operator.operatorHT['SUB_VERSION'] ne 1 or operator.operatorHT['CITY_EXCHANGES_FLAG'] eq 1}">
						<label ${not empty bulletId?'title="范围不可修改"':''} style="${ALLOW_CITY_BBS eq 0?'display:none;':''}">
							<input showText="同城交流" hidefocus type="checkbox" ${bulletBound eq 2 ? 'checked=checked' : ''} name="checkbox" value="2" onchange="choose(this)" id="checkbox"/>
						</label>
						<label ${not empty bulletId?'title="范围不可修改"':''} style="${ALLOW_CITY_BBS eq 0?'display:none;':''}">
							<input showText="经纪天地" hidefocus type="checkbox" ${bulletBound eq 3 ? 'checked=checked' : ''} name="checkbox"	value="3" onchange="choose(this)" id="checkbox2"/>
						</label>
					</c:if>
					<c:if test="${operator.operatorHT['COMP_MODEL'] eq 2 and operator.operatorHT['COMP_ATTR'] eq 1 and PUB_BULLETIN_INFO_OPER}">
						<label ${not empty bulletId?'title="范围不可修改"':''} style="${ALLOW_CITY_BBS eq 0?'display:none;':''}">
							<input showText="加&nbsp;盟&nbsp;圈" hidefocus type="checkbox" ${bulletBound eq 7 ? 'checked=checked' : ''} name="checkbox"	value="7" onchange="choose(this)" id="checkbox7"/>
						</label>
					</c:if>
					<!--纯精英版没有公司和本店-->
					<c:if test="${operator.operatorHT['DEPT_PERSONAL'] ne 0}">
						<c:if test="${operator.operatorHT['COMP_TYPE'] ne '2'}">
							<label ${not empty bulletId?'title="范围不可修改"':''}>
								<input showText="本店信息" hidefocus type="checkbox" name="checkbox" value="0" ${bulletBound eq 0 ? 'checked=checked' : ''} id="checkbox4" onchange="choose(this)"/>
							</label>
						</c:if>
						<label ${not empty bulletId?'title="范围不可修改"':''}>
							<input showText="公司信息" hidefocus type="checkbox" name="checkbox"	${bulletBound eq 1 ? 'checked=checked' : ''} value="1" id="checkbox3" onchange="choose(this)"/>
						</label>
					</c:if>
				</li>
				<li style="padding:0;">
					<textarea id="cb_ke_content" style="width:610px;" rows="20"></textarea>
					<div class="fileItem">
						<input type="hidden" name="bulletPsInput" id="bulletPsInput"/>
						<ul>
							<c:forEach items="${bulletinPsPOs}" var="bulletinPs" varStatus="status">
								<li fileName="${bulletinPs.fileName}" path="${bulletinPs.psPath}" url="FastdfsManager.getHttpAccessDomain() ${bulletinPs.psPath}" >
									<span class="file_icon"></span>
									<span class="file_name">${bulletinPs.fileName}</span>
									<c:if test="${canEdit}">
					 					<a href="javascript:void(-1);" class="delete_file" onclick="deleteFile(this)"></a>
									</c:if>
									<a href="javascript:void(-1);" class="download_file" onclick="downloadFile(this)"></a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</li>
				<li>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
						<td align="right" id="normalSubmit">
							<div style="float:right;width:215px;margin-left:10px;">
								<input type="button" id="submitBullet" onfocus="this.blur();" onclick="saveCommerce(this);return false;" class="bulletin_bg btn_b45 lt bt-blue-l" value="发 帖" style="margin-right: 10px;"/>
								<input type="button" onfocus="this.blur();" onclick="preview();return false;" class="bulletin_bg btn_b44 bt-white-l" value="预 览"/>
							</div>
							<div style="float: left;">
								显示电话：<label hidefocus class="blue"><input hidefocus type="radio" name="showPhone1" id="showPhone1"  ${!bulletinInfo.showTel or empty bulletId ? 'checked="checked"' : ''} value="0" />是</label>
								<label hidefocus class="blue"><input hidefocus type="radio" name="showPhone1" id="showPhone0" ${bulletinInfo.showTel ? 'checked="checked"' : ''} value="1"/>否</label>
							</div>
						</td>
					</tr>
				</table>
				</li>
				<li class="border1px" id="voteArea"  style="display:none; margin-top: -21px;">
					<div class="divVote">
						<div class="divVoteType">
							类型：<label hidefocus class="blue"><input hidefocus type="radio" checked="checked" name="voteType" id="voteType1" value="0"/>单选投票</label>
							<label hidefocus class="blue"><input hidefocus type="radio" name="voteType" id="voteType2" value="1"/>多选投票</label><br />
						</div>
						<textarea cols="100%" rows="4" id="tb_VoteItem" name="tb_VoteItem" class="ipt-textarea"></textarea>
					</div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td></td>
							<td align="right" id="voteSubmit" width="300">
								<div style="float:right;width:205px;margin-left:10px;">
									<a id="submitBullet" onfocus="this.blur();" onclick="saveCommerce(this);return false;" href="javascript:void(-1);" class="bulletin_bg btn_b45 lt bt-blue-l">发 帖</a>
									<a onfocus="this.blur();" onclick="preview();return false;" href="javascript:void(-1);" class="bulletin_bg btn_b44 bt-white-l">预 览</a>
								</div>
								<div style="float: left;">
									显示电话：<label hidefocus class="blue">
									<input hidefocus type="radio" name="showPhone" id="showPhone1" ${!bulletinInfo.showTel or empty bulletId ? 'checked="checked"' : ''}  value="0" />是</label>
									<label hidefocus class="blue">
										<input hidefocus type="radio" name="showPhone" id="showPhone0" ${bulletinInfo.showTel ? 'checked="checked"' : ''} value="1"/>否
									</label>
								</div>
							</td>
						</tr>
					</table>
				</li>
			</ul>
		</div>
	</form>
</div>
<div style="height:10px;" describe="分隔符"></div>
<div id="previewMode" style="display: none; position: fixed; top:0px; width: 100%; height: 100%;left: 0;z-index: 1000">
	<iframe id="previewFrame" frameborder="0" scrolling="auto" src="" width="100%" height="100%"></iframe>
</div>
<div id="initContent" style="display: none;">${bulletinInfo.bulletContent}</div>
<div id="initHouseContent" style="display: none;" discribe="房源发布房源到公告">
	<c:if test="${not empty houseList}">
		<table id='99' border="0" cellpadding="0" cellspacing="0" class="tableCss" summary="房源列表">
			<tr>
				<th style='width:80px;'>行政区</th>
				<th style='width:120px;'>楼盘</th>
				<th style='width:60px;'>楼层</th>
				<th style='width:60px;'>户型</th>
				<th style='width:60px;'>装修</th>
				<th style='width:60px;'>面积</th>
				<th style='width:80px;'>${param.caseType eq 1 ? '价格' : '租金'}</th>
				<th colspan="2">查看</th>
			</tr>
			<c:forEach items="${houseList}" var="houseInfo" varStatus="status">
				<tr class="${status.index % 2 eq 0 ? 'trEven' : 'trOdd'}" id='fun${houseInfo.ID}'>
					<td>${houseInfo.regionName}</td>
					<td>${houseInfo.buildName}</td>
					<td>${houseInfo.caseFloor}/${houseInfo.caseFloors}</td>
					<td>${houseInfo.caseRoom}</td>
					<td>$---{pageUtil:getDicMsg('HOUSE_FITMENT',houseInfo.caseFitment)}</td>
					<td><fmt:formatNumber value="${houseInfo.caseArea}" type="number" maxFractionDigits="0" pattern="##0.#"/>m<sup>2</sup></td>
					<td>
						<fmt:formatNumber value="${houseInfo.caseTotalPrice}" type="number" maxFractionDigits="0" pattern="##0.#"/>
						$---{empty houseInfo.priceUnit ? '万' : pageUtil:getDicMsg('PRICE_UNIT',houseInfo.priceUnit)}
					</td>
					<c:choose>
						<c:when test="${not empty houseInfo.map and houseInfo.map > 0}">
							<td><a id='showImg_${houseInfo.id}' href='javascript:void(-1);' onclick="showHouseInfo('${houseInfo.id}','${param.caseType}','99',this.parentNode.parentNode.rowIndex,this,'${houseInfo.compNo}','${houseInfo.deptId}','${houseInfo.userId}','${houseInfo.picList}');return false;">图</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty houseInfo.charact}">
							<td><a id="showTxt_${houseInfo.id}" href="javascript:void(-1);" onclick="showHouseInfo('${houseInfo.id}','${houseInfo.charact}','99',this.parentNode.parentNode.rowIndex,this,'${houseInfo.compNo}','${houseInfo.deptId}','${houseInfo.userId}');return false;">文</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
<script language="JavaScript">
	var projectPath = "${ctx}";
	var basePath = "${ctx}";
</script>
<script language="javascript" src="../publicJs/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="../publicJs/kindeditor/v4.1.7/kindeditor-erp.js"></script>
<script language="javascript" src="../publicJs/ClientCachePlugin.js"></script>
<script type="text/javascript">
	var insertHouseInfoPath = "${ctx}/bulletin/insertHouseInfo?CLIENTKEY=${CLIENTKEY}&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(); //插入房源的页面路径
	var editor;
	KindEditor.ready(function(K) {
		//K.options.items_bulletin.push('insertfile');
		editor = K.create('#cb_ke_content', {
			resizeType : 0,
			allowPreviewEmoticons : true,
			allowImageUpload : true,
			filterMode: false,
			minWidth : 610,
			items : K.options.items_bulletin,
			cssPath : '${statics}/publicJs/kindeditor/v4.1.7/themes/myfun7.css'
		});
		//如果是编辑 则初始化内容
		if($.trim($("#BULLET_ID").val()) != ""){
			editor.html('$---{pageUtil:reaplaceAll(bulletinInfo.bulletContent,"\\n|\\r","")}');
		}
		if($.trim($("#HOUSE_IDS").val()) != ""){
			editor.html($("#initHouseContent").html());
		}
	});
	function closePayment(obj){
		$(obj).parent().css("display","none"); $(obj).parent().prev().css("display","none");
	}
	$(document).ready(function () {
		window.onresize = function(){
			$("#divPayment").css("marginLeft",(window.innerWidth/2)-352 +"px");
			$("#divPayment").css("marginTop",(window.innerHeight/2)-219 +"px");
		}
		window.onresize();
		//注册客户端交互控件
		ClientCachePlugin.regist();
		//jQuery 注入一个方法
		$.fn.toggleCheckbox = function () {
			this.attr('checked', !this.attr('checked'));
		}
		//为 input[type="radio"] 加壳、封装（为后期样式使用）。
		$('input[type="radio"]').each(function (index, element) {
			if (element.checked == true) {
				$(element).wrap('<div class="radio-btn checkedRadio"><i></i></div>');
			} else {
				$(element).wrap('<div class="radio-btn"><i></i></div>');
			}
		})
		//绑定点击事件，改变样式，触发 input:radio 的 change 时间代码。
		$('.radio-btn').bind('click', function (event) {
			var _this = $(this),
			block = _this.parent().parent();
			checkName = _this.children().children().attr("name");
			block.find('input:radio[name=' + checkName + ']').attr('checked', false);

			block.find(".radio-btn").children().children().each(function (index, element) {
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
		//为 input[type="checkbox"] 加壳、封装（为后期样式使用）。
		$('input[type="checkbox"]').each(function (index, element) {
			var strText = $(this).attr("showText");
			if (element.checked == true) {
				if (element.disabled == true) {
					$(element).wrap('<div class="check-box checkedBoxDisable"><i></i><div class="text">' + strText + '</div><div class="divChecked"></div></div>');
				} else {
					$(element).wrap('<div class="check-box checkedBox"><i></i><div class="text">' + strText + '</div><div class="divChecked"></div></div>');
				}
			} else {
				if (element.disabled == true) {
					$(element).wrap('<div class="check-box checkedBoxUnDisable"><i></i><div class="text">' + strText + '</div><div class="divChecked"></div></div>');
				} else {
					$(element).wrap('<div class="check-box"><i></i><div class="text">' + strText + '</div><div class="divChecked"></div></div>');
				}
			}
		});
		$('.check-box').live('click',function (event) {
			if ($(this).children().children()[0].disabled == false) {
				$(this).find(':checkbox').toggleCheckbox();
				$(this).toggleClass('checkedBox');
				if ($(this).hasClass("checkedBox") == true) {
					$(this).children().children()[0].checked = true;
				} else {
					$(this).children().children()[0].checked = false;
				}
				$(this).children().children().trigger("change");
			}
			event.preventDefault();
		});
		//注册插件
		$("body").append("<object type='application/x-qt-plugin' style='witdh:0px;height:0px;' classid='CHomePageAdapter' id='CHomePageAdapter'/>");
	});
	//取消公告返回选中状态 input
	function cancleCheck(obj){
		$(obj).prop("checked",false);
		$(obj).parent().parent().removeClass("checkedBox");
	}
	//选择后互相排斥的代码
	function choose(obj){
		var objId = $(obj).attr("id");
		if(objId == "checkbox"){//同城交流
			cancleCheck($("#checkbox2"));
			cancleCheck($("#checkbox7"));
		}else if(objId == "checkbox2"){//经济天地
			cancleCheck($("#checkbox"));
			cancleCheck($("#checkbox7"));
		}else if(objId == "checkbox7"){//加盟圈
			cancleCheck($("#checkbox"));
			cancleCheck($("#checkbox2"));
			cancleCheck($("#checkbox3"));
			cancleCheck($("#checkbox4"));
		}else if(objId == "checkbox3"){//公司信息
			cancleCheck($("#checkbox7"));
			cancleCheck($("#checkbox4"));
		}else if(objId == "checkbox4"){//本店信息
			cancleCheck($("#checkbox7"));
			cancleCheck($("#checkbox3"));
		}
	}
	function showVote(){
		var voteArea = document.getElementById("voteArea");
		var normalSubmit = document.getElementById("normalSubmit");
		var voteSubmit = document.getElementById("voteSubmit");
		var voteTip = "<span class=\"im-tp\" style=\"margin-right: 8px;vertical-align: middle;margin-top: -8px;\"></span>";
		if(voteArea.style.display == "none"){
			voteArea.style.display = "block";
			normalSubmit.style.display = "none"; voteSubmit.style.display = "table-cell";
			document.getElementById("vote").innerHTML=voteTip+"取消投票";
			document.getElementById("isVote").value="1";
		}else{
			voteArea.style.display = "none";
			normalSubmit.style.display = "table-cell"; voteSubmit.style.display = "none";
			document.getElementById("vote").innerHTML=voteTip+"开启投票";
			document.getElementById("isVote").value="0";
		}
	}
	/**
	 * 需要预览时，先显示加载画面
	 */
	function preview(){
		if(checkSubmit()){
			var isphone = document.getElementById("showPhone1").checked;
			document.getElementById("editMode").style.display = 'block';
			document.getElementById("editMode").focus(); //获得焦点
			document.getElementById("loading").style.height = document.body.clientHeight;
			document.getElementById("loading").style.display = "block";
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			param.push("isphone=" + isphone);
			param.push("operate=create");
			document.getElementById("previewFrame").src = "${ctx}bulletin/preview?" + param.join("&");
		}
	}
	/**
	 * 预览页加载完调用的方法，由预览页调用
	 */
	function previewInit(){
		document.getElementById("loading").style.display = "none";
		document.documentElement.style.overflowY = "hidden";
		document.getElementById("previewMode").style.display = '';
	}
	/**
	返回到当前页面
	**/
	function cancelPreview(){
		document.getElementById("editMode").style.display = '';
		document.documentElement.style.overflowY = "scroll";
		document.getElementById("previewMode").style.display = 'none';
	}
	function saveCommerce(obj){
		if('${operator.operatorHT["SUPER_USER"]}' == "0" && '${operator.operatorHT["MANAGE_FLAG"]}' == "1"
			&& (document.getElementById("checkbox").checked || document.getElementById("checkbox2").checked)){
			//判断是否绑定资金账户
			document.getElementById("CCustObj").judgeO2O(6);
			return;
		}
		if("${ADD_COMMUNIC_INFO}"!="true"){
			document.getElementById("CCustObj").openMessageBox("您没有权限发布公告信息",3,1);
			return;
		}
		if('${operator.operatorHT["REL_USER_RIGHT"]}' == "0" && '${operator.operatorHT["BULLET_FLAG"]}' == "0" && '${operator.operatorHT["USER_POSITION"]}' != 'GENERAL_MANAGER'){
			if(document.getElementById("checkbox").checked || document.getElementById("checkbox2").checked){
				document.getElementById("CCustObj").openMessageBox("您未通过实名认证",3,1);
				document.getElementById("checkbox").checked = false;
				document.getElementById("checkbox2").checked = false;
				return;
			}
		}
		if("${ALLOW_CITY_BBS}"!="1" && (document.getElementById("checkbox").checked || document.getElementById("checkbox2").checked)){
			document.getElementById("CCustObj").openMessageBox("您的公司未开启“同城交流”平台，不能发布此类信息",3,1);
			return;
		}
		if(document.getElementById("checkbox").checked || document.getElementById("checkbox2").checked){
			$.ajax({
				url: "${SITE_ROOT_URL}/web/bulletin/getBanTime",
				data: "CLIENTKEY=${CLIENTKEY}"+"&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
				type:'GET',
				success:function(retStr){
					if(retStr.resultCode == "success"){
						todoSaveCommerce();
					}else if(retStr.resultCode == "fail"){
						var str = retStr.message;
						if(str.indexOf("2099")==-1){
							document.getElementById("CCustObj").openMessageBox("你违反公告信息发布管理办法，"+str+" 前将不能对外发布信息",3,1);
						}else{
							document.getElementById("CCustObj").openMessageBox("你违反公告信息发布管理办法，已被终身禁言",3,1);
						}
						return;
					}else if(retStr.resultCode == "exception"){
						document.getElementById("CCustObj").openMessageBox("系统异常",3,1);
					}
				}
			});
		}else{
			todoSaveCommerce();
		}
	}
	/**
	 * 获取上传附件信息
	 */
	function getFileItem(){
		var $fileLi = $("div.fileItem ul li");
		var param = new Array();
		for(var i =0 ;i<$fileLi.length;i++){
			var tLi = $fileLi.eq(i);
			param.push(tLi.attr("fileName") + "," +tLi.attr("path"));
		}
		return param.join(";");
	}
	function todoSaveCommerce(){
		if(checkSubmit()){
			$.ajax({
				url: "${SITE_ROOT_URL}/web/bulletin/checkSend",
				data: "CLIENTKEY=${CLIENTKEY}"+"&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
				type:'GET',
				success:function(retStr){
					if(retStr.resultCode == "success"){
						document.getElementById("mycontent").value = document.getElementById("mycontent").value.replaceAll('${operator.operatorHT["BULLET_PIC_DOC"]}','hftImagesUrlAddress').replaceAll('${operator.operatorHT["USER_BASE_DOC"]}'+biaoqingPath, 'hftImagesUrlAddress');
						var requestUrl = "${SITE_ROOT_URL}/web/bulletin/createBulletin?CLIENTKEY=${CLIENTKEY}&ACTION=save";
						//提交数据
						var postData = $("#base").serialize();
						postData += "&bulletinPs=" + getFileItem();
						console.log(postData);
						//保存当前回复 然后刷新页面
						$.ajax({
							type: "POST",
							url: requestUrl,
							data: postData,
							success: function(result){
							if(result.resultCode == "success"){
								//调用客户端刷新列表
								try{
									//参数  板块 帖子id 0 创建 1删除
									document.getElementById("CHomePageAdapter").refreshBulletinList(result.message.split(":")[0], result.message.split(":")[1], 0);
								}catch(e){
									alert("请手动刷新列表");
								}
								var redirectParam = new Array();
								redirectParam.push("dispatchType=getBulletinInfo");
								redirectParam.push("CLIENTKEY=${CLIENTKEY}");
								redirectParam.push("BULLET_BOUND=" + result.message.split(":")[0]);
								redirectParam.push("BULLET_ID=" + result.message.split(":")[1]);
								window.location.href = "${SITE_ROOT_URL}/web/dispatch.jsp?" + redirectParam.join("&");
							}else if(result.resultCode == "exception"){
								document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
							}else if(result.resultCode == "paramError"){
								document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
							}
							}
						});
					}else if(retStr.resultCode == "fail"){
						if(retStr.message == "1" && (document.getElementById("checkbox").checked || document.getElementById("checkbox2").checked)){
							document.getElementById("CCustObj").openMessageBox("为避免刷屏，每日发帖量(含刷新)限${BULLETIN_INFO_DAY}次，每月共计${BULLETIN_INFO}次",3,1);
							return;
						}else if(retStr.message == "2" && (document.getElementById("checkbox").checked || document.getElementById("checkbox2").checked)){
							document.getElementById("CCustObj").openMessageBox("为避免刷屏，每日发帖量(含刷新)限${BULLETIN_INFO_DAY}次，每月共计${BULLETIN_INFO}次",3,1);
							return;
						}else{
							//本店或者本公司
							document.getElementById("mycontent").value = document.getElementById("mycontent").value.replaceAll('${operator.operatorHT["BULLET_PIC_DOC"]}',"hftImagesUrlAddress").replaceAll('${operator.operatorHT["USER_BASE_DOC"]}'+biaoqingPath,'hftImagesUrlAddress');
							var requestUrl = "${SITE_ROOT_URL}/web/bulletin/createBulletin?CLIENTKEY=${CLIENTKEY}&ACTION=save";
							//提交数据
							var postData = $("#base").serialize();
							postData += "&bulletinPs=" + getFileItem();
							//保存当前回复 然后刷新页面
							$.ajax({
								type: "POST",
								url: requestUrl,
								data: postData,
								success: function(result){
									if(result.resultCode == "success"){
										//调用客户端刷新列表
										try{
											//参数  板块 帖子id 0 创建 1删除
											document.getElementById("CHomePageAdapter").refreshBulletinList(result.message.split(":")[0], result.message.split(":")[1], 0);
										}catch(e){
											document.getElementById("CCustObj").openMessageBox("请手动刷新列表",3,1);
										}
										var redirectParam = new Array();
										redirectParam.push("dispatchType=getBulletinInfo");
										redirectParam.push("CLIENTKEY=${CLIENTKEY}");
										redirectParam.push("BULLET_BOUND=" + result.message.split(":")[0]);
										redirectParam.push("BULLET_ID=" + result.message.split(":")[1]);
										window.location.href = "${SITE_ROOT_URL}/web/dispatch.jsp?" + redirectParam.join("&");
									}else if(result.resultCode == "exception"){
										document.getElementById("CCustObj").openMessageBox("系统异常,请稍后再试",3,1);
									}else if(result.resultCode == "paramError"){
										document.getElementById("CCustObj").openMessageBox("参数异常",3,1);
									}
								}
							});
						}
					}else if(retStr.resultCode == "exception"){
						document.getElementById("CCustObj").openMessageBox("系统异常",3,1);
					}
				}
			});
			document.getElementById("submitBullet").onclick="";
		}
	}
	function checkSubmit(){
		var isChoose=false;
		var topic = document.getElementById("topic").value;
		if(topic.trim()==""){
			document.getElementById("CCustObj").openMessageBox("主题必填",3,1);
			return false;
		}
		if(strbytelen(topic)>60){
			document.getElementById("CCustObj").openMessageBox("主题不能超过30个汉字",3,1);
			return false;
		}
		document.getElementById("mycontentDiv").innerHTML=editor.html();

		if(document.getElementById("mycontentDiv").innerHTML.replaceAll(/(\r\n)|(\r)|(\n)/g,"").replaceAll("&nbsp;","").replaceAll(" ","")==""){
			document.getElementById("CCustObj").openMessageBox("内容必填",3,1);
			return false;
		}
		document.getElementById("mycontentDiv").innerHTML = document.getElementById("mycontentDiv").innerHTML.replaceAll(/(<SPAN.*?>)|(<\/SPAN>)|(<span.*?>)|(<\/span>) /gi,"");
		if(document.getElementById("mycontentDiv").innerHTML.replaceAll(/(<*?>)|(\r\n)|(\r)|(\n)/g,"").length>100000){
			document.getElementById("CCustObj").openMessageBox("内容过长",3,1);
			return false;
		}
		var chooseCheckbox = document.getElementsByName("checkbox");
		for(var i=0;i<chooseCheckbox.length;i++){
			if(chooseCheckbox[i].checked == true){
				isChoose=true;
				break;
			}
		}
		if(!isChoose){
			document.getElementById("CCustObj").openMessageBox("发帖范围至少选择一项",3,1);
			return false;
		}
		document.getElementById("mycontent").value=document.getElementById("mycontentDiv").innerHTML;
		if(document.getElementById("vote").innerHTML=="取消投票"){
			if(!getVote()){return false;}
		}
		var bounds = document.getElementsByName("checkbox");
		var bound=0;
		for(var i=0;i<bounds.length;i++){
			if(bounds[i].checked == true){
				bound = bounds[i].value;
				break;
			}
		}
		document.getElementById("mycontent").value = document.getElementById("mycontent").value.replaceAll("<A","<A target='_blank'");
		document.getElementById("mycontent").value = document.getElementById("mycontent").value.replaceAll("<a","<a target='_blank'");
		document.getElementById("mycontent").value = document.getElementById("mycontent").value.replaceAll("&lt;a","&lt;a target='_blank'");
		document.getElementById("mycontent").value = document.getElementById("mycontent").value.replaceAll("&lt;A","&lt;A target='_blank'");
		return true;
	}
	function strbytelen(str){
		var endvalue=0;
		for(var i=0;i<str.length;i++){
			if(str.charCodeAt(i)>255){
				endvalue=endvalue+2;
			}else{
				endvalue=endvalue+1;
			}
		}
		return endvalue;
	}
	String.prototype.replaceAll  = function(s1,s2){
		if (!RegExp.prototype.isPrototypeOf(s1)) {
			return this.replace(new RegExp(s1, "g"), s2);
		} else {
			return this.replace(s1, s2);
		}
	}
	function getVote(){
		var content = document.getElementById("tb_VoteItem").value;
		if(content.replaceAll("\n","").replaceAll(" ","").trim()==""){
			document.getElementById("CCustObj").openMessageBox("请输入投票内容,若发普通帖，请点击取消投票",3,1);
			return;
		}
		var voteDiv = document.getElementById("voteDiv");
		if(voteDiv !=null){
			voteDiv.innerHTML = "";
		}else{
			voteDiv = document.createElement("div");
			voteDiv.setAttribute("id", "voteDiv");
			voteDiv.style.display = "none";
		}
		content = content.replaceAll("'","&#39;");
		var contents = new Array();
		contents = content.split("\n");
		if(checkContents()){
			for(var i=0;i<contents.length&&i<10;i++){
				if(contents[i].trim()==""){continue;}
				var input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "type");
				input.setAttribute("id", "type");
				input.setAttribute("value", contents[i].trim().substring(0,25));
				voteDiv.appendChild(input);
			}
			document.base.appendChild(voteDiv);
			return true;
		}
		return false;
	}
	function checkContents(){
		var content = document.getElementById("tb_VoteItem").value;
		var contents = new Array();
		contents = content.split("\n");
		for(var i=0;i<contents.length;i++){
			for(var j=i+1;j<contents.length;j++){
				if(contents[i]==contents[j]){
					document.getElementById("CCustObj").openMessageBox("不能重复内容:"+contents[j],3,1);
					return false;
				}
			}
		}
		return true;
	}
</script>
<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
</body>
</html>