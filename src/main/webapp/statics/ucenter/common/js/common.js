
/**
 * 初始化项目地址，用于配置线上和本地
 * @param returnUrl
 * @returns
 */
function initUrlConfig(returnUrl) {
	payConfig.erpWebUrl = erpWebUrl;
	payConfig.crmWebUrl = crmWebUrl;
	payConfig.adminWebUrl = adminWebUrl;
	// "http://192.168.11.101:8080/erpWeb/" + "usercenter/payment/hfBeans/result?CLIENTKEY=clientKey"
	payConfig.returnUrl = erpWebUrl + returnUrl;
}

function openWindow(url) {
	try {
		document.getElementById("custObj").openWindow(url);
	} catch (e) {}
}

var alertMsg = function(msg, sec){
	try {
		// 消息内容，3=感叹号、4=勾勾，1=一个按钮、2=两个按钮
		// 返回值，0=取消、1=确定
		var result = document.getElementById("custObj").openMessageBox(msg, 3, 1);
		if(result == 1 && typeof(sec) == 'function') {
			sec();sec = null;
		}
	} catch (e) {
		alert(msg);
	}
}

/**
 * crm返回值验证
 * @param data
 * @returns 可以继续往下执行返回true
 */
function validateCrmResult(data, start, alt) {
	if (data.code == 300 || data.code == 500) {
		if(alt == 1) {
			alertMsg(start + data.msg);
		}
		return false;
	} else if (data.code != 200) {
		if(alt == 1) {
			alertMsg(start + "系统错误");
		}
		return false;
	}
	return true;
}

/**
 * 客服帮助
 */
try {
	$('.customer-service').on('click', function() {
		openWindow('https://www.sobot.com/chat/pc/index.html?sysNum=568c7972e09a46659bc97a984f719e02');
	});
} catch (e) {
	// TODO: handle exception
}

/**
 * 显示提示框
 * @param content
 * @param sec
 * @param cancel
 * @returns
 */
function showConfirm(content, sec, cancel){
	$("#confirmModel .content .info").text(content);
	$("#confirmModel .ok,#confirmModel .cancel").unbind("click");
	$("#confirmModel .ok").click(function(){
		$("#confirmModel").hide();
		if (typeof(sec) == 'function') {
			sec();sec = null;
		}
	});
	$("#confirmModel .cancel,#confirmModel .model-delete").click(function(){
		$("#confirmModel").hide();
		if (typeof(cancel) == 'function') {
			cancel();cancel = null;
		}
	});
	$("#confirmModel").show();
}

/**
 * ajax处理事件模板
 * @url 后台处理的url，即action
 * @dataSentType 数据发送的方式，有post，get方式
 * @dataReceiveType 数据接收格式，有html json text等
 * @paramsStr 传入后台的参数
 * @successFunction ajax成功后执行的函数名
 * ajaxTemp("", "GET", "html", {}, function(){}, function(){}, "");
 */
function ajaxTemp(url, dataSentType, dataReceiveType, paramsStr, successFunction, errorFunction, id) {
	$.ajax({
		url : url, // 后台处理程序
		sync : false,
		type : dataSentType, // 数据发送方式
		dataType : dataReceiveType, // 接受数据格式
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