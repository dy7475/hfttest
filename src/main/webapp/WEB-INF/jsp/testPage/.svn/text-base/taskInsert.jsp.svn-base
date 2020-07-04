<html>
<body>
<h2>建任务</h2>
</body>
<script type="text/javascript">
	var taskArr = [
		"",
		"",
		"",
	];
	var form = "";
	var createDay = 14;// 创建的是哪一天
	var assignedTo = "xionggang";//hechuanqiang  xionggang  fangliji  zhanghl  zangtie
	for(var i=0;i<taskArr.length;i++) {
		if(i != 0) {
			form +="&";
		}
		var time = taskArr[i].match(/([^\[\]]+)(?=\])/g);
		var taskContent = taskArr[i].replace(/\[.+\]/g, "");
		var nameArr = taskArr[i].split("");
		form +="module["+i+"]=0&story["+i+"]=&name["+i+"]="+taskContent+"["+createDay+"]";
		form +="&type["+i+"]=devel&assignedTo["+i+"]="+assignedTo+"&estimate["+i+"]="+time[0]+"&desc["+i+"]=&pri["+i+"]=3";
	}
	var settings = {
		"url": "http://192.168.11.103/zentaopms/www/index.php?m=task&f=batchCreate&projectID=117",
		"method": "POST",
		"mimeType": "application/x-www-form-urlencoded",
		"data": form
	}
	$.ajax(settings).done(function (response) {
		console.log(response);
	});
</script>
</html>
