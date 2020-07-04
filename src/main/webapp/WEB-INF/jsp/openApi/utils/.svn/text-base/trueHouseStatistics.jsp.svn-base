<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>真房源统计数据</title>
	<script src="../../statics/common/js/common.js" type="text/javascript" ></script>
	<script src="../../statics/publicJs/jquery-1.9.1.min.js" type="text/javascript" ></script>
	<script src="../../statics/publicJs/My97DatePicker/WdatePicker.js" type="text/javascript" ></script>
</head>
<body>
	<div align="center">
		<div align="left" style="width: 250px;">
			<div align="center" style="margin-bottom: 10px;">统计某天真房源数和参与人数</div>
			选择查询日期：<br/>
			<input type="text" id="queryDayDate" placeholder="选择时间" onClick="WdatePicker();" readonly="readonly">
			<input type="button" value="查询" id="getTrueDayCount">
			<div>
				<div>参与人数：<span id="queryDayUserCount"></span></div>
				<div>真房源数：<span id="queryDayTrueCount"></span></div>
			</div>
		</div>
		<div align="left" style="width: 350px;">
			<div align="center" style="margin-top: 40px; margin-bottom: 10px;">按手机号统计</div>
			手机号：<input type="text" id="queryMobile" placeholder="手机号"><br/>
			选择查询日期：<br/>
			<input type="text" id="queryMobileStartDate" placeholder="开始时间" onClick="WdatePicker();" readonly="readonly">
			<input type="text" id="queryMobileEndDate" placeholder="结束时间" onClick="WdatePicker();" readonly="readonly">
			<input type="button" value="查询" id="getTrueMobileCount">
			<div>
				<div>真房源数：<span id="queryMobileTrueCount"></span></div>
			</div>
		</div>
		<div align="left" style="width: 350px;">
			<div align="center" style="margin-top: 40px; margin-bottom: 10px;">按门店统计</div>
			公司编号和门店编号：<br/>
			<input type="text" id="queryDeptCompNo" placeholder="公司编号">
			<input type="text" id="queryDeptDeptNo" placeholder="门店编号"><br/>
			选择查询日期：<br/>
			<input type="text" id="queryDeptStartDate" placeholder="开始时间" onClick="WdatePicker();" readonly="readonly">
			<input type="text" id="queryDeptEndDate" placeholder="结束时间" onClick="WdatePicker();" readonly="readonly">
			<input type="button" value="查询" id="getTrueDeptCount">
			<div>
				<div>真房源数：<span id="queryDeptTrueCount"></span></div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$("#getTrueDayCount").click(function(){
		$("#queryDayUserCount").text("获取中...");
		$("#queryDayTrueCount").text("获取中...");
		var queryDate = $("#queryDayDate").val();
		if(isEmpty(queryDate)){alert("时间不能为空");return;}
		ajaxTemp("getTrueDayCount", "post", "json", {queryDate:queryDate}, function(data){
			data = JSON.parse(data);
			$("#queryDayUserCount").text(data.data.userCount);
			$("#queryDayTrueCount").text(data.data.trueCount);
		}, function(){
			alert("查询失败");
		});
	});
	$("#getTrueMobileCount").click(function(){
		$("#queryMobileTrueCount").text("获取中...");
		var queryMobile = $("#queryMobile").val();
		var queryMobileStartDate = $("#queryMobileStartDate").val();
		var queryMobileEndDate = $("#queryMobileEndDate").val();
		if(isEmpty(queryMobile)){alert("手机号不能为空");return;}
		if(isEmpty(queryMobileStartDate)){alert("开始时间不能为空");return;}
		if(isEmpty(queryMobileEndDate)){alert("结束时间不能为空");return;}
		ajaxTemp("getTrueMobileCount", "post", "json", {
				mobile:queryMobile,
				startDate:queryMobileStartDate,
				endDate:queryMobileEndDate,
			}, function(data){
				data = JSON.parse(data);
				$("#queryMobileTrueCount").text(data.data.trueCount);
			}, function(){
				alert("查询失败");
			}
		);
	});
	$("#getTrueDeptCount").click(function(){
		$("#queryDeptTrueCount").text("获取中...");
		var queryDeptCompNo = $("#queryDeptCompNo").val();
		var queryDeptDeptNo = $("#queryDeptDeptNo").val();
		var queryDeptStartDate = $("#queryDeptStartDate").val();
		var queryDeptEndDate = $("#queryDeptEndDate").val();
		
		if(isEmpty(queryDeptCompNo)){alert("公司编号不能为空");return;}
		if(isEmpty(queryDeptDeptNo)){alert("门店编号不能为空");return;}
		if(isEmpty(queryDeptStartDate)){alert("开始时间不能为空");return;}
		if(isEmpty(queryDeptEndDate)){alert("结束时间不能为空");return;}
		ajaxTemp("getTrueDeptCount", "post", "json", {
				compNo:queryDeptCompNo,
				deptNo:queryDeptDeptNo,
				startDate:queryDeptStartDate,
				endDate:queryDeptEndDate,
			}, function(data){
				data = JSON.parse(data);
				$("#queryDeptTrueCount").text(data.data.trueCount);
			}, function(){
				alert("查询失败");
			}
		);
	});
</script>
</body>
</html>
