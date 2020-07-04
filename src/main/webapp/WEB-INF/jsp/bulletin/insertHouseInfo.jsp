<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="../common/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html oncontextmenu="return false;" style="overflow-x:hidden" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>好房通_插入房源信息</title>
	<base href="${SITE_ROOT_URL}/bulletinNew/" />
	<link href="css/insertHouseInfo.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="../css/pagination.css" />
	<link href="css/jquery-ui.selectmenu.css" type="text/css" rel="stylesheet" />
	<style type="text/css">
		.ui-button-Sort {
			background-image: url('images/NewVersion/Combox.png');
			background-repeat: no-repeat;width: 76px;height: 22px;position: relative;
			outline: none;vertical-align: middle;margin-left: 1px;margin-right: 2px;
			margin-top: -4px;padding-top: 3px;
		}
		.ui-selectmenu-button span.ui-selectmenu-text {color: black;}
		.ui-selectmenu-menu .ui-menu {max-height: 252px;}
		.ui-selectmenu-menu .ui-menu::-webkit-scrollbar {width: 8px;border-radius: 6px;}
		.ui-selectmenu-menu .ui-menu::-webkit-scrollbar-track {background-color: #DADADA;}
		.ui-selectmenu-menu .ui-menu::-webkit-scrollbar-thumb {background-color: #757474;border-radius: 6px;}
		.ui-selectmenu-menu .ui-menu::-webkit-scrollbar-thumb:hover {background-color: #898989;}
		.ui-menu .ui-menu-item {border-top: 1px solid transparent;border-bottom: 1px solid transparent;}
		.ui-menu .ui-state-focus, .ui-menu .ui-state-active {
			background-image: none;background-color: #E5E9EC;
			border-top: 1px solid #D8D8D8;border-bottom: 1px solid #D8D8D8;
			color: black;height: 20px;
		}
	</style>
</head>
<body onselectstart="return false;" oncontextmenu="return false;">
	<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height: 0px; width: 0px; display: block;"></object>
	<form action="" method="post" id="myform" name="myform">
		<input type="hidden" id="HOUSE_REGION" name="HOUSE_REGION" />
		<input type="hidden" id="HOUSE_SECTORS" name="HOUSE_SECTORS" />
		<input type="hidden" id="REGION" name="REGION" id="REGION" />
		<input type="hidden" id="BUILD_ID" name="BUILD_ID" />
		<input type="hidden" id="BUILD_NAME" name="BUILD_NAME" />
		<table style="text-align: left; table-layout: fixed" width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="right" style="vertical-align: middle;">
					<div style="width: 639px; float: left; color: #888888; margin-top: 5px;">
						<label>
							<input style="vertical-align: middle;" onclick="tosale()" hidefocus type="radio" name="CASE_TYPE" value="SALE_FUN"
							${empty param.caseType or param.caseType eq 'SALE_FUN' ? 'checked=checked' : ''} />出售
						</label>
						<label style="margin-right: 14px;">
							<input style="vertical-align: middle;" onclick="tolease()" hidefocus type="radio" name="CASE_TYPE" value="LEASE_FUN"
							${param.caseType eq 'LEASE_FUN' ? 'checked=checked' : ''} />出租
						</label>
						区域:
						<select id="REGION_TEXT" name="REGION_TEXT" class="Combox_box">
							<option value="" selected="selected">全部</option>
							<c:forEach items="${regList}" var="reg" varStatus="status">
								<option value="${reg.regName}" ${param.regionText eq reg.regName ? "selected='selected'":""}>${reg.regName}</option>
							</c:forEach>
						</select>
						楼盘:<input id="BUILD_ID_TEXT" type="text" class="Input_box"
							value="${param.buildIdText}" name="BUILD_ID_TEXT"
							onkeyup="getBuild(this)" />
						户型:<input id="ROOM_TEXT" type="text"
							class="Combox_box" value="${empty param.roomText ? " 全部":
							param.roomText}" name="ROOM_TEXT" onclick="roomSelector(this)"
							readonly="readonly" />
						面积:<input id="AREA_TEXT" type="text"
							class="Combox_box" value="${empty param.areaText ? " 全部":
							param.areaText}" name="AREA_TEXT" onclick="areaSelector(this)"
							readonly="readonly" />
					</div>
					<a onfocus="this.blur();" onclick="searchSubmit();return false;" href="javascript:void(-1);" class="bulletin_bg btn_gb44 lt">查 询</a>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="right">
					<div style="height: 278px; width: 690px;" class="scrollBar">
						<table cellpadding="0" cellspacing="0" class="tableCss" style="text-align: left;">
							<tr>
								<th style="width: 37px;">多选</th>
								<th style="width: 29px;">图</th>
								<th style="width: 29px;">视</th>
								<th style="width: 120px;">楼盘</th>
								<th style="width: 60px;">用途</th>
								<th style="width: 60px;">楼层</th>
								<th style="width: 60px;">户型</th>
								<th style="width: 50px;">面积</th>
								<th style="width: 62px;">价格</th>
								<th style="width: 40px;">装修</th>
							</tr>
						</table>
						<div class="divContent">
							<table cellpadding="0" cellspacing="0" class="tableCss" style="text-align: left; margin-left: 1px; width: 680px;">
								<c:choose>
									<c:when test="${param.caseType eq 'SALE_FUN' or empty param.caseType}">
										<c:forEach items="${houseList}" var="house" varStatus="status">
											<tr class="trStyle">
												<td style="width: 37px; padding-left: 12px;" onclick="selectCHK(this,'${house.saleId}')">
													<input hidefocus id="chk_${house.saleId}" type="checkbox" name="cb" 
													onclick="selectCHK(this,'${house.saleId}')" value="${house.saleId}"
													_json="{id:'${house.saleId}',type:'sale',photo:'${house.saleMap}',region:'${house.buildName}',
													fitment:'${house.saleFitment}',building:'${house.buildName}',room:'${house.saleRoom}',
													hall:'${house.saleHall}',wei:'${house.saleWei}',floor:'${house.saleFloor}',
													area:'${house.saleArea}',charact:'${cf:replaceAllEntity(house.saleCharact)}',
													price:'${house.saleTotalPrice}',userId:'${house.userId}',compNo:'',deptId:'${house.deptId}',
													photoAddr:'${house.thumbUrl}',video:'${house.videoNum}',
													useage:'${cf:getDicMsg('HOUSE_USEAGE',house.saleUseage,cityId)}'}" /></td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="color: #cc0000; width: 29px;">
													${house.SALE_MAP>0 ? '<img src="../newCount/images/MarkIcon/pic.png">':'<img src="../newCount/images/MarkIcon/pic_gray.png">'}
												</td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="color: #cc0000; width: 29px;">
													${house.videoNum>0 ? '<img src="../newCount/images/MarkIcon/av.png">':'<img src="../newCount/images/MarkIcon/av_gray.png">'}
												</td>
												<%--<td onclick="selectCHK(this,'${house.saleId}')" style="color:#cc0000; width:25px;">${fn:length(house.SALE_CHARACT) >0 ? '<img src="images/NewVersion/File.png">':''}</td> --%>
												<td onclick="selectCHK(this,'${house.saleId}')" style="width: 120px;">
													${house.buildName}[${house.regionName}]
												</td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="width: 60px;">
													${cf:getDicMsg("HOUSE_USEAGE",house.saleUseage,param.cityId)}
												</td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="width: 60px;">
													${house.saleFloor}/${house.saleFloors}
												</td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="width: 60px;">
													${house.saleRoom}-${house.saleHall}-${house.saleWei}
												</td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="width: 50px;">${house.saleArea}m<sup>2</sup></td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="color: #FB8A10; font-weight: bold; width: 62px;">
													${house.saleTotalPrice}万
												</td>
												<td onclick="selectCHK(this,'${house.saleId}')" style="width: 40px;">
													${cf:getDicMsg("HOUSE_FITMENT",house.saleFitment,param.cityId)}
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach items="${houseList}" var="house" varStatus="status">
											<tr class="trStyle">
												<td style="width: 37px; padding-left: 12px;" onclick="selectCHK(this,'${house.saleId}')">
													<input hidefocus id="chk_${house.leaseId}" onclick="selectCHK(this,'${house.saleId}')"
													type="checkbox" name="cb" value="${house.leaseId}"
													_json="{id:'${house.leaseId}',type:'lease',photo:'${house.leaseMap}',region:'${house.regionName}',
													fitment:'${house.leaseFitment}',building:'${house.buildName}',room:'${house.leaseRoom}',
													hall:'${house.leaseHall}',wei:'${house.leaseWei}',floor:'${house.leaseFloor}',
													area:'${house.leaseArea}m<sup>2</sup>',charact:'${cf:replaceAllEntity(house.leaseCharact)}',
													price:'${house.leaseTotalPrice}',userId:'${house.userId}',compNo:'',deptId:'${house.deptId}',
													photoAddr:'${house.thumbUrl}',video:'${house.videoNum}',
													useage:'${cf:getDicMsg("HOUSE_USEAGE",house.leaseUseage,param.cityId)}'}" />
												</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="color: #cc0000; width: 29px;">
													${house.leaseMap>0 ? '<img src="../newCount/images/MarkIcon/pic.png">':'<img src="../newCount/images/MarkIcon/pic_gray.png">'}
												</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="color: #cc0000; width: 29px;">
													${house.videoNum>0 ? '<img src="../newCount/images/MarkIcon/av.png">':'<img src="../newCount/images/MarkIcon/av_gray.png">'}
												</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="width: 120px;">
													<div style='width: 138px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;' title='${house.buildName}[${house.regionName}]'>
														${house.buildName}[${house.regionName}]
													</div>
												</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="width: 60px;">${cf:getDicMsg("HOUSE_USEAGE",house.leaseUseage,param.cityId)}</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="width: 60px;">${house.leaseFloor}/${house.leaseFloors}</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="width: 60px;">${house.leaseRoom}-${house.leaseHall}-${house.leaseWei}</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="width: 50px;">${house.leaseArea}m<sup>2</sup></td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="color: #FB8A10; font-weight: bold; width: 62px;">
													<div style='width: 70px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;' title='${house.leaseTotalPrice}${cf:getDicMsg("PRICE_UNIT",house.priceUnit,param.cityId)}'>
														${house.leaseTotalPrice}${cf:getDicMsg("PRICE_UNIT",house.priceUnit,param.cityId)}
													</div>
												</td>
												<td onclick="selectCHK(this,'${house.leaseId}')" style="width: 40px;">
													${cf:getDicMsg("HOUSE_FITMENT",house.leaseFitment,param.cityId)}
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td align="left">
					<div id="pagination" class="none_border" describe="分页控件"></div>
				</td>
			</tr>
		</table>
		<input type="hidden" id="editorId" name="editorId" value="" />
		<input id="info" type="hidden" name="info" value="" />
	</form>
	<div class="fd fd1" id="fd1" style="z-index: 1000"></div>
	<div class="fd fd1" id="fd2" style="z-index: 1000"></div>
	<script language="javascript" src="../publicJs/jquery-1.6.4.min.js"></script>
	<script language="javascript" src="../publicJs/main.js"></script>
	<script language="JavaScript" src="../publicJs/public.js"></script>
	<script type="text/javascript" src="../publicJs/selector.js"></script>
	<script language="JavaScript" src="../js/Validator.js"></script>
	<script language="JavaScript" src="../publicJs/publicDivSetter.js"></script>
	<script language="JavaScript" src="../js/selectorJs.js"></script>
	<script type="text/javascript" src="../publicJs/jquery.pagination.js"></script>
	<script type="text/javascript" src="../publicJs/selectBuild.js"></script>
	<script type="text/javascript" src="js/jquery.ui.selectmenu.js"></script>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#REGION_TEXT").selectmenu({
				buttonClass: "ui-button-Sort",
				textClass: "ui-textClass", //文本追加样式
				change:function(item,data){
				}
			});
			$.fn.toggleCheckbox = function () {
				this.attr('checked', !this.attr('checked'));
			}
			$('input[type="radio"]').each(function (index, element) {
				if (element.checked == true) {
					$(element).wrap('<div class="radio-btn checkedRadio"><i></i></div>');
				} else {
					$(element).wrap('<div class="radio-btn"><i></i></div>');
				}
			});
			$('.radio-btn').bind('click', function () {
				var _this = $(this), block = _this.parent().parent();
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
			$('input[type="checkbox"]').each(function (index, element) {
				if (element.checked == true) {
					if (element.disabled == true) {
						$(element).wrap('<div class="check-box checkedBoxDisable"><i></i></div>');
					} else {
						$(element).wrap('<div class="check-box checkedBox"><i></i></div>');
					}
				} else {
					if (element.disabled == true) {
						$(element).wrap('<div class="check-box checkedBoxUnDisable"><i></i></div>');
					} else {
						$(element).wrap('<div class="check-box"><i></i></div>');
					}
				}	
			});
			$('.check-box').unbind("click");
			$("#pagination").pagination("${totalRows}", {//总页数
				callback: pageselectCallback,
				prev_text: "< ",
				next_text: " >",
				items_per_page: "${pageRowSize}", //每页的数据个数
				num_display_entries: 3, //两侧首尾分页条目数
				current_page: "${pageOffset-1}",   //当前页码
				num_edge_entries: 1, //连续分页主体部分分页条目数
				link_to:"javascript:void(-1)"
			});
		});
		//分页控件回调函数
		function pageselectCallback(page_id, jq) {
			goOtherPage(page_id+1);
			console.log(page_id+1);
		}
		var arr = new Array();
		function createInfo(obj,ind){
			var id = obj.value;
			if(obj.checked==true){
				arr.push(obj.getAttribute("_json"));
			}else{
				if(ind >= 0)
					arr.splice(ind,1);
			}
			document.getElementById("info").value = "["+arr.join(",")+"]";
		}

		var idArr = new Array();
		/**
		 * 点击行触发事件
		 * 奂永桥
		 */	
		function selectCHK(trObj,id){
			var obj = document.getElementById("chk_"+id);
			if(obj.checked==true){
				obj.checked = false;
			}else{
				obj.checked = true;
			}
			$(obj).parent().parent().toggleClass('checkedBox');
			var ind = idArr.indexOf(id);
			if(ind < 0){// 防止重复
				idArr.push(id);
			} else {
				idArr.splice(ind,1);
			}
			createInfo(obj,ind);
		}

		function searchSubmit(){
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			document.myform.action="${SITE_ROOT_URL}/web/bulletin/insertHouseInfo?" + param.join("&");
			document.myform.submit();
		}
		function tosale(){
			document.getElementById("REGION_TEXT").value="";
			document.getElementById("BUILD_ID_TEXT").value="";
			document.getElementById("AREA_TEXT").value="";
			document.getElementById("ROOM_TEXT").value="";
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			document.myform.action="${SITE_ROOT_URL}/web/bulletin/insertHouseInfo?" + param.join("&");
			document.myform.submit();
		}

		function tolease(){
			document.getElementById("REGION_TEXT").value="";
			document.getElementById("BUILD_ID_TEXT").value="";
			document.getElementById("AREA_TEXT").value="";
			document.getElementById("ROOM_TEXT").value="";
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			document.myform.action="${SITE_ROOT_URL}/web/bulletin/insertHouseInfo?" + param.join("&");
			document.myform.submit();
		}

		function goOtherPage(pageOffset){
			var param = new Array();
			param.push("CLIENTKEY=${CLIENTKEY}");
			param.push("PAGE_OFFSET=" + pageOffset);
			//param.push("PAGE_ROW_TOTAL=${pageRows}");
			document.myform.action="${SITE_ROOT_URL}/web/bulletin/insertHouseInfo?" + param.join("&");
			document.myform.submit();
		}
		function goSelfDefPage() {
			var page = document.getElementById('jump').value;
			if (page > "${pageRows / (empty pageRowSize or pageRowSize eq 0 ? 50 : pageRowSize) + (pageRows % pageRowSize > 0 ? 1 : 0)}"|| page < 1) {
				document.getElementById("CCustObj").openMessageBox("请输入正确的页码！",3,1);
				return;
			}
			goOtherPage(page);
		}

		function createDiv1(selectType, inputType, width, height, left, top) {
			top += 18;
			left -= 2;
			document.getElementById("BUILD_ID").value = "";
			document.getElementById("BUILD_ID_TEXT").value = "";
			showdiv(publicShowTableBuild(width), "fd2", width, height, left, top);
		}

		function createDiv(selectType, type, inputType, width, height, left, top) {
			top += 18;
			left -= 2;
			var bound = "2";
			if (selectType == "AREA") {
				var responseXml = createSelector2(selectType, type);
				showdiv(responseXml, 'fd1', width, height, left, top);
			} else {
				$.ajax({
					url : "../common/searchSelector.jsp",
					data : "SELECT_TYPE=" + selectType + "&INPUT_TYPE="
							+ inputType + "&BOUND=" + bound + "&mtyefmupn"
							+ new Date().getMilliseconds() + "="
							+ Math.random(),
					type : 'GET',
					success : function(retStr) {
						showdiv(retStr, 'fd1', width, height, left, top);
					}
				});
			}
		}

		function matchBuild(obj) {
			obj.style.color = "#000000";
			if (obj.value == "") {
				return;
			}
			var selectedBuildId = document.getElementById("BUILD_ID").value;

			var regId = "";
			var streetId = document.getElementById("HOUSE_SECTORS").value;
			var matchStr = encodeURI(encodeURI(obj.value));
			$.ajax({
				url : "../publicSelector/saleSelector.jsp",
				data : "SELECT_TYPE=MATCH_BUILD&INPUT_TYPE=checkbox&BUILD_CODE="
						+ matchStr
						+ "&REG_ID="+ regId
						+ "&STREET_ID="+ streetId
						+ "&BUILD_ID="+ selectedBuildId
						+ "&mtyefmupn"+ new Date().getMilliseconds()
						+ "=" + Math.random(),
				type : 'GET',
				success : function(retStr) {
					document.getElementById('buildDiv').innerHTML = retStr;
				}
			});
		}
		function selectValue(displayName, valueName, obj, selectObj) {
			document.getElementById(displayName).value = selectObj.getAttribute("displayText");
			document.getElementById(valueName).value = selectObj.value;
			try {
				closeed('fd1');
				closeed("fd2");
			} catch (e) {}
		}
	</script>
</body>
</html>