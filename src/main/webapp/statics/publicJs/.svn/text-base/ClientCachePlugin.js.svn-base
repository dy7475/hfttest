/**
 * 获取客户端缓存插件
 * 使用步骤
 * 1,注册ClientCachePlugin.regist(自定义id);
 * 2，获取值ClientCachePlugin.getValue("USER_NO")
 * 3,设置值ClientCachePlugin.setValue("USER_NO","sss")
 * @author jsg
 * @returns
 */
var ClientCachePlugin = {
	//插件名字
	pluginName : "mybutton",
	//是否注册
	isRegisted : false,
	//_REG_STR : "",//好房直供初始化区域变量
	parameters : {},//所有参数的结合
	/**
	 * 注册获取客户端插件
	 */
	regist : function(objName){
		try {
			console.log("注册控件");
		} catch(err) {}
		
		if(this.isRegisted){
			return;
		}
		var para = document.createElement("div"); 
		if(objName){
			para.innerHTML = "<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='" + objName + "'/>";
			this.pluginName = objName;
		}else{
			para.innerHTML = "<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='mybutton'/>";
		}
		document.body.appendChild(para);
		//初始化参数
		this.isRegisted = true;
		this.init();
	},
	/**
	 * 初始化控件值
	 * 先从客户端取，如果取不到则到服务器端取
	 */
	init : function(){
		var value = null;
		try{
				console.log("初始化客户端参数");
			//从客户端取
			value = document.getElementById(this.pluginName).getValues();
			if(!!value){
				this.parameters = $.parseJSON(value);
			}
		}catch(e){
			try{
				console.log("初始化服务器端参数");
			}catch(ex){}
			//从服务器端取
			value = this.getServerParameters();
			if(!!value){
				this.parameters = value;//$.parseJSON(value);
			}
		}
		if(!value){
			try{
				console.log("初始化参数失败，请联系客户!");
			}catch(ex){}
		}
	},
	/**
	 * 获取插件里面取值
	 * 如果对象为空则返回null
	 */
	getValue : function(key){
		var value = null;
		if(this.isRegisted){
			if(!$.isEmptyObject(this.parameters)){
				if((value = this.parameters[key]) == undefined){
					value = null;
				}
			}else{
				try{
					console.log("缓存对象为空");
				}catch(ex){}
			}
		}else{
			try{
				console.log("请先注册控件:"+document.location.href);
			}catch(ex){}
		}
		try{
			console.log("调用控件获取值:key=" + key + "-value=" +value);
		}catch(ex){}
		return value;
	},
	/**
	 * 把值缓存在插件里面或者把值缓存在服务器端
	 * 
	 */
	setValue : function(key, value){
		value = value.toString();
		if(this.isRegisted){
			this.parameters[key] = value;
			try{
				document.getElementById(this.pluginName).setValue(key, value);
				console.log("");
				console.log("调用控件设置值:key="+key+"-value="+value +" 客户端");
			}catch(e){
				//如果有需求则把它设置到服务的缓存里面
				this.setServerParameter(key, value);
				try{
					console.log("调用控件设置值:key="+key+"-value="+value +" 服务端");
				}catch(ex){}
			}
		}else{
			try{
				console.log("请先注册控件:"+document.location.href);
			}catch(ex){}
		}
	},
	/**
	 * 获取服务器参数放在 如果失败是返回null
	 */
	getServerParameters : function(){
		var result = null;
		var clientKey = this.getClientKey();
		if(this.isRegisted){
			$.ajax({
			   type : "post",
			   url : this.getSiteRootUrl()+"/bulletin/getParameters",
			   data : "{CLIENTKEY:'"+this.getClientKey()+"'}",
			   dataType : "json",
               beforeSend: function(request) {
                   request.setRequestHeader("CLIENTKEY", clientKey);
               },
			   contentType: "application/json; charset=utf-8",
			   async : false,
			   success: function(msg){
				   result = msg;
			   },
			   error : function(){
					try{
					   console.log("获取参数失败");
					}catch(ex){}
			   }
			});
		}
		try{
			console.log("从服务端获取所有参数:" + result);
		}catch(ex){}
		return result;
	},
	getServerParameter : function(key){
		var result = true;
		if(this.isRegisted){
			$.ajax({
			   type : "post",
			   url : this.getSiteRootUrl()+"/bulletin/getParameters",
			   data : "CLIENTKEY="+this.getClientKey()+"&key="+key,
			   dataType : "json",
			   async : false,
			   success: function(msg){
				   result = msg;
			   },
			   error : function(){
					try{
						console.log("获取参数失败");
					}catch(ex){}
				   result = false;
			   }
			});
		}
		try{
			console.log("从服务器端获取参数:key=" +key + "-value=" +result);
		}catch(ex){}
		return result;
	},
	setServerParameter : function(key, value){
		try{
			console.log("把值设置到服务器端:key="+key+"-value="+value);
		}catch(ex){}
		var result = true;
		if(this.isRegisted){
			$.ajax({
			   type : "post",
			   url : this.getSiteRootUrl()+"/bulletin/setParameter",
			   data : "CLIENTKEY="+this.getClientKey()+"&key="+key+"&value="+value,
			   dataType : "json",
			   async : true,
			   success: function(msg){
				   result = msg;
			   },
			   error : function(){
					try{
						console.log("获取参数失败");
					}catch(ex){}
				   result = false;
			   }
			});
		}
		return result;
	},
	/**
	 * 获取根路劲
	 */
	getSiteRootUrl : function(){
		//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	    var curWwwPath=window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht=curWwwPath.substring(0,pos);
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	    return(localhostPaht+projectName);
	},
	/**
	 * 获取clientkey
	 */
	getClientKey : function(){
		return this.getQueryString("CLIENTKEY") || this.getQueryString("clientkey");
	},
	/**
	 * 获取查询参数
	 */
	getQueryString : function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]); return null;
    },
    /**
     * 如果在壳里面就调用壳的方法打开一个新的窗口 否则调用浏览器自带的窗口
     * @param url
     */
    openWindow : function(url){
    	console.log(url);
    	try{
    		document.getElementById(this.pluginName).openWindow(url);
    	}catch(e){
    		window.open(url);
    	}
    }
}
