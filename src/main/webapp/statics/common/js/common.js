
function isEmpty(str){
	return (!str || str == "" || str == null);
}
function isNotEmpty(str){
	return !isEmpty(str);
}

/**
 * ajax处理事件模板
 * 
 * @url 后台处理的url，即action
 * @dataSentType 数据发送的方式，有post，get方式
 * @dataReceiveType 数据接收格式，有html json text等
 * @paramsStr 传入后台的参数
 * @successFunction ajax成功后执行的函数名
 */
function ajaxTemp(url, dataSentType, dataReceiveType, paramsStr, successFunction,errorFunction, id) {
	$.ajax({
		url : url, // 后台处理程序
		async : false,
		type : dataSentType, // 数据发送方式
		dataType : dataReceiveType, // 接受数据格式
		data : eval(paramsStr),
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(msg) {
			successFunction(msg, id);
		},
		beforeSend : function() {
			// $('#loader').jqmShowEx();
		},
		complete : function() {
			// $('#loader').jqmHide();
		},
		error : function(msg) {
			errorFunction(msg,id);
		}
	});
}

function getQueryString(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return decodeURI(r[2]); return null;
}
function isNumber(value) {
	var s = new RegExp("^[0-9]*$");
	if (s.test(value)) {
		return true;
	} else {
		return false;
	}
}

(function(win) {
	var Map = function() {
		this.count = 0;
		this.entrySet = {};
	};

	var proto = Map.prototype;

	proto.size = function() {
		return this.count;
	};

	proto.isEmpty = function() {
		return this.count === 0;
	};

	proto.containsKey = function(key) {
		if (this.isEmpty()) {
			return false;
		}

		for ( var prop in this.entrySet) {
			if (prop === key) {
				return true;
			}
		}

		return false;
	};

	proto.containsValue = function(value) {
		if (this.isEmpty()) {
			return false;
		}

		for ( var key in this.entrySet) {
			if (this.entrySet[key] === value) {
				return true;
			}
		}

		return false;
	};

	proto.get = function(key) {
		if (this.isEmpty()) {
			return null;
		}

		if (this.containsKey(key)) {
			return this.entrySet[key];
		}

		return null;
	};

	proto.put = function(key, value) {
		this.entrySet[key] = value;
		this.count++;
	};

	proto.remove = function(key) {
		if (this.containsKey(key)) {
			delete this.entrySet[key];
			this.count--;
		}
	};

	proto.clear = function() {
		for ( var key in this.entrySet) {
			this.remove(key);
		}
	};

	proto.values = function() {
		var result = [];

		for ( var key in this.entrySet) {
			result.push(this.entrySet[key]);
		}

		return result;
	};

	proto.keySet = function() {
		var result = [];

		for ( var key in this.entrySet) {
			result.push(key);
		}

		return result;
	};

	proto.toString = function() {
		var result = [];
		for ( var key in this.entrySet) {
			result.push(key + ":" + this.entrySet[key]);
		}

		return "{" + result.join() + "}";
	};

	proto.valueOf = function() {
		return this.toString();
	};

	win.Map = Map;
})(window);