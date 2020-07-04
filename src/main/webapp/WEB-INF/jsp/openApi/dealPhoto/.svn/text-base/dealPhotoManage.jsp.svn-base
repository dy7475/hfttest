<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片处理</title>
</head>
<body>
	选择处理的表：
	<select id="choiseDealTable" onchange="updateSwitch(0);">
		<option value="-1">请选择</option>
		<option value="0">FUN_DEAL_PHOTO</option>
		<option value="1">FUN_ARCHIVE</option>
		<option value="2">BUILDING_PHOTO</option>
		<option value="3">FUN_PHONE</option>
		<option value="4">FUN_SALE--CELL_PHONE</option>
		<option value="5">buildRuleLimitDeal</option>
		<option value="6">dealTrack</option>
		<option value="7">流转分析</option>
		<option value="8">诚意金处理程序</option>
	</select>
	<br/><br/>
	处理次数：<input type="text" value="" id="dealCount"><br/>
	状态（0=关闭 1=开启）：<input type="text" value="" id="copySwitch"><br/>
	休息时间（毫秒）：<input type="text" value="" id="sleepTime"><br/>
	线程数：<br/>
	dbName:<input type="text" value="" id="threadDbName"><br/>
	线程数（1~20）：<input type="text" value="" id="threadCount"><br/>
	<input type="button" value="修改" onclick="updateSwitch(1);"><br/><br/><br/>
	<input type="button" value="开始处理" onclick="startDeal();">
	<input type="button" value="停止处理" onclick="stopDeal();">
	<br/><br/><br/>
	<div id="result"></div>
</body>
<script src="${statics}publicJs/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	var urlSetting = [
		{switchUrl:"${ctx}openApi/photoDeal/funDealPhoto/copySwitch",copyUrl:"${ctx}openApi/photoDeal/funDealPhoto/startCopy"},
		{switchUrl:"${ctx}openApi/photoDeal/funArchive/copySwitch",copyUrl:"${ctx}openApi/photoDeal/funArchive/startCopy"},
		{switchUrl:"${ctx}openApi/photoDeal/erpBuildingPhoto/copySwitch",copyUrl:"${ctx}openApi/photoDeal/erpBuildingPhoto/startCopy"},
		{switchUrl:"${ctx}openApi/funPhone/createSwitch",copyUrl:"${ctx}openApi/funPhone/startCreate"},
		{switchUrl:"${ctx}openApi/salePhone/createSwitch",copyUrl:"${ctx}openApi/salePhone/startCreate"},
		{switchUrl:"${ctx}openApi/buildRuleLimitDeal/createSwitch",copyUrl:"${ctx}openApi/buildRuleLimitDeal/copyLimitRuleToTempAction"},
		{switchUrl:"${ctx}openApi/dealDealTrack/copySwitch",copyUrl:"${ctx}openApi/dealDealTrack/startCopy"},
		{switchUrl:"${ctx}openApi/flowRepair/copySwitch",copyUrl:"${ctx}openApi/flowRepair/startCopy"},
		{switchUrl:"${ctx}openApi/dealEarbestMoney/copySwitch",copyUrl:"${ctx}openApi/dealEarbestMoney/startCopy"},
	];
	$("#choiseDealTable").val(0);
	function getSetting(){
		var index = $("#choiseDealTable").val();
		if(index < 0) {
			alert("请先选择处理的表");return;
		}
		return urlSetting[index];
	}
	function stopDeal(){
		$("#status").val(0);
		updateSwitch();
	}
	function startDeal(){
		$("#status").val(1);
		var setting = getSetting();
		$.ajax({
			type: "GET",
			dataType: "json",
			url: setting.copyUrl,
			success: function(result){
				$("#result").text(JSON.stringify(result));
			}
		});
	}
	function updateSwitch(needUpdateParam){
		var setting = getSetting();
		var copySwitch = $("#copySwitch").val();
		var sleepTime = $("#sleepTime").val();
		var threadDbName = $("#threadDbName").val();
		var threadCount = $("#threadCount").val();
		var dealCount = $("#dealCount").val();
		$.ajax({
			type: "POST",
			dataType: "json",
			url: setting.switchUrl,
			data: {
				sleepTime:sleepTime,copySwitch:copySwitch,threadDbName:threadDbName,
				threadCount:threadCount,dealCount:dealCount,needUpdateParam:needUpdateParam
			},
			success: function(result){
				$("#copySwitch").val(result.data.copySwitch?"1":"0");
				$("#sleepTime").val(result.data.sleepTime);
				$("#dealCount").val(result.data.dealCount);
				$("#result").text(JSON.stringify(result));
			}
		});
	}
</script>
</html>