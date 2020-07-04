//dcw @20131012 toast提示框提示信息
$(document).ready(function(){
	//给查询输入框绑定事件
	ClientCachePlugin.regist();
	var upgradeMsg = (function(){
		var soft = (ClientCachePlugin.getValue("userCompType") =="2"?"专业版":"赢销版");
		if(ClientCachePlugin.getValue("sellName")=="" || ClientCachePlugin.getValue("selUPhone")==""){
			return "该功能不为"+soft+"用户开放<br/>详情请咨询:<font style='color:#f00;font-weight:bold;'>028-88889666</font>";
		}else{
			var txt = "该功能不为"+soft+"用户开放，请联系产品顾问<br/><font style='color:#f00;font-weight:bold;'>"+ClientCachePlugin.getValue("sellName")+"</font>"+"（电话："+ClientCachePlugin.getValue("selUPhone")+",QQ："+ClientCachePlugin.getValue("selUQQ")+"）";
			return txt;
		}
	})();
});

//dcw @20131015 体验版保存提示信息
var experienceMsg = "体验版不能保存设置,如需使用请开通正式版SERP";
/****************************
作用:初始化
*****************************/

if(typeof(_styleTmp) != "undefined"){
	_alert("main.js重复！");
}

//cc添加
var _styleTmp = "#_error{margin:0 auto;margin-top:25%;width:380px;overflow:hidden;}"
+"#_shadow{background-color:gray;opacity:0.40;-moz-border-radius:7px;position:fixed;width:380px;height:80px;z-index: 2000}"
+"#_errorTmp1{background:url('#SITEROOT#/style/image/error.gif') center no-repeat;}"
+"#_errorTmp2{background:url('#SITEROOT#/style/image/error2.gif') center no-repeat;}"
+"#_yy_main_TMP{position:fixed;height:50px;z-index:2001;margin-top:7px;margin-left:9px;}"
+"._closeBtn{background:url('#SITEROOT#/images/mouseOut.gif') center no-repeat;float: right;display:block;width:20px;height:20px;}"
+"._closeBtn:hover{background:url('#SITEROOT#/images/mouseOver.gif') center no-repeat;cursor:pointer;}";

var _errorDiv = "<div id='_error'>"
							+"<div id='_shadow'></div>"
							+"<div id='_yy_main_TMP'>"
								+"<div style='height:65px;border:1px solid #646464;background-color:#FFFFFF;'>"
								+"<table style='width:360px;' height='100%'>"
									+"<tr>"
										+"<td id='#ERRORCLASS#' width='50px'></td>"
										+"<td style='vertical-align:middle;'>"
										+"<span style='display:block;width:285px;font-size:12px;color:#153B6A;overflow:hidden;white-space:nowrap;-o-text-overflow:ellipsis;text-overflow: ellipsis;'>"
										+"#ERRORMSG#"
										+"</span>"
										+"</td>"
										+"<td style='vertical-align:top;'><span class='_closeBtn' onclick='closeAlert()'></span></td>"
									+"</tr>"
							+"</table></div></div></div>";
document.title = unescape("好房通ERP%A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0行业标准引领者 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0 %A0");

//屏蔽错误
//window.onerror = function(){return true;}
$(document).ready(initial);
function initial()
{
	try {
			_styleTmp = _styleTmp.replaceAll("#SITEROOT#",getTiptopWindow().siteRoot);
			var oStyle = $(document).find("style:eq(0)");
			if(oStyle[0]){
				oStyle.text(oStyle.text() + _styleTmp);
			}else{
				$(document).find('head').append("<style type='text/css'>"+_styleTmp+"</style>");
			}
		 }catch(e){
		 
		 }
	//这个部分是主菜单的显示
	if (document.getElementById("myform"))
	{
		var tagNames=new Array("input","textarea","select")
		for (var i=0; i<tagNames.length; i++)
		{
			var inputArry = document.getElementById("myform").getElementsByTagName(tagNames[i]);
			for (var j=0; j < inputArry.length; j++)
			{
				var input=inputArry[j];
				if (input.getAttribute("dataType") != null && input.getAttribute("require") == null) {input.style.backgroundColor="#fddcdc"}
				input.onblur = function() {
					this.style.borderColor= "#d4d4d4";
				}
				input.onfocus= function() {
					this.style.borderColor = "rgb(82,169,255)";
				}
				if (input.tabIndex==1) {input.focus();} //第一个输入控件获得焦点
			}
		}
	}
}

/*----------------------------------功能分隔符------------------------------------*/

/****************************
作用:表单验证
*****************************/
 Validator = {
	Require : /.+/,
	Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	Phone : /(^[0-9]{7,8}$)|(^[0-9]{3,4}[0-9]{7,8})$/,
	Mobile : /^([0]?1(?:3|4|5|7|8)[\d]{9})$/,
	Url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
	IdCard : "this.IsIdCard(value)",
	Currency : /^\d+(\.\d+)?$/,
	Number : /^\d+$/,
	Zip : /^[1-9]\d{5}$/,
	QQ : /^[1-9]\d{4,8}$/,
	Integer : /^[-\+]?\d+$/,
	Double : /^[-\+]?\d+(\.\d+)?$/,
	English : /^[A-Za-z]+$/,
	EnglishAndNumber : /^[A-Za-z0-9]+$/,
	Chinese :  /^[\u0391-\uFFE5]+$/,
	Time: /^([0-1]?[0-9]|2[0-3]):([0-5][0-9])$/,
	Username : /^[a-z]\w{3,}$/i,
	UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
	IsSafe : function(str){return !this.UnSafe.test(str);},
	SafeString : "this.IsSafe(value)",
	Filter : "this.DoFilter(value, getAttribute('accept'))",
	Limit : "this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
	LimitB : "this.limit(this.LenB(value), getAttribute('min'), getAttribute('max'))",
	Date : "this.IsDate(value, getAttribute('min'), getAttribute('format'))",
	Repeat : "value == document.getElementsByName(getAttribute('to'))[0].value",
	Range : "getAttribute('min') < (value|0) && (value|0) < getAttribute('max')",
	Compare : "this.compare(value,getAttribute('operator'),getAttribute('to'))",
	Custom : "this.Exec(value, getAttribute('regexp'))",
	Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",
	ErrorItem : [document.forms[0]],
	ErrorMessage : ["以下原因导致提交失败：\t\t\t\t"],
	Validate : function(theForm, mode){
		var obj = theForm || event.srcElement;
		var count = obj.elements.length;
		this.ErrorMessage.length = 1;
		this.ErrorItem.length = 1;
		this.ErrorItem[0] = obj;
		for(var i=0;i<count;i++){
			with(obj.elements[i]){
				var _dataType = getAttribute("dataType");
				if(typeof(_dataType) == "object" || typeof(this[_dataType]) == "undefined")  continue;
				this.ClearState(obj.elements[i]);
				if(getAttribute("require") == "false" && value == "") continue;
				switch(_dataType){
					case "IdCard" :
					case "Date" :
					case "Repeat" :
					case "Range" :
					case "Compare" :
					case "Custom" :
					case "Group" : 
					case "Limit" :
					case "LimitB" :
					case "SafeString" :
					case "Filter" :
						if(!eval(this[_dataType]))	{
							this.AddError(i, getAttribute("msg"));
						}
						break;
					default :
						if(!this[_dataType].test(value.trim())){
							this.AddError(i, getAttribute("msg"));
						}
						break;
				}
			}
		}
		if(this.ErrorMessage.length > 1){
			mode = mode || 1;
			var errCount = this.ErrorItem.length;
			switch(mode){
			case 2 :
				for(var i=1;i<errCount;i++)
					this.ErrorItem[i].style.backgroundColor = "#f5f6be"
			case 1 :
				alert(this.ErrorMessage.join("\n"));
				this.ErrorItem[1].focus();
				break;
			case 3 :
				for(var i=1;i<errCount;i++){
				try{
					var span = document.createElement("SPAN");
					span.id = "__ErrorMessagePanel";
					span.style.color = "red";
					this.ErrorItem[i].parentNode.appendChild(span);
					span.innerHTML = this.ErrorMessage[i].replace(/\d+:/,"*");
					}
					catch(e){alert(e.description);}
				}
				this.ErrorItem[1].focus();
				break;
			default :
				alert(this.ErrorMessage.join("\n"));
				break;
			}
			return false;
		}
		return true;
	},
	limit : function(len,min, max){
		min = min || 0;
		max = max || Number.MAX_VALUE;
		return min <= len && len <= max;
	},
	LenB : function(str){
		return str.replace(/[^\x00-\xff]/g,"**").length;
	},
	ClearState : function(elem){
		with(elem){
			if(style.color == "red")
				style.color = "";
			var lastNode = parentNode.childNodes[parentNode.childNodes.length-1];
			if(lastNode.id == "__ErrorMessagePanel")
				parentNode.removeChild(lastNode);
		}
	},
	AddError : function(index, str){
		this.ErrorItem[this.ErrorItem.length] = this.ErrorItem[0].elements[index];
		this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
	},
	Exec : function(op, reg){
		return new RegExp(reg,"g").test(op);
	},
	compare : function(op1,operator,op2){
		switch (operator) {
			case "NotEqual":
				return (op1 != op2);
			case "GreaterThan":
				return (op1 > op2);
			case "GreaterThanEqual":
				return (op1 >= op2);
			case "LessThan":
				return (op1 < op2);
			case "LessThanEqual":
				return (op1 <= op2);
			default:
				return (op1 == op2);            
		}
	},
	MustChecked : function(name, min, max){
		var groups = document.getElementsByName(name);
		var hasChecked = 0;
		min = min || 1;
		max = max || groups.length;
		for(var i=groups.length-1;i>=0;i--)
			if(groups[i].checked) hasChecked++;
		return min <= hasChecked && hasChecked <= max;
	},
	DoFilter : function(input, filter){
return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
	},
	IsIdCard : function(number){
		number = number.toLowerCase();
		var date, Ai;
		var verify = "10x98765432";
		var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
		var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
		var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/i);
		if(re == null) return false;
		if(re[1] >= area.length || area[re[1]] == "") return false;
		if(re[2].length == 12){
			Ai = number.substr(0, 17);
			date = [re[9], re[10], re[11]].join("-");
		}
		else{
			Ai = number.substr(0, 6) + "19" + number.substr(6);
			date = ["19" + re[4], re[5], re[6]].join("-");
		}
		if(!this.IsDate(date, "ymd")) return false;
		var sum = 0;
		for(var i = 0;i<=16;i++){
			sum += Ai.charAt(i) * Wi[i];
		}
		Ai +=  verify.charAt(sum%11);
		return (number.length ==15 || number.length == 18 && number == Ai);
	},
	IsDate : function(op, formatString){
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch(formatString){
			case "ymd" :
				m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
				if(m == null ) return false;
				day = m[6];
				month = m[5]*1;
				year =  (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
				break;
			case "dmy" :
				m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
				if(m == null ) return false;
				day = m[1];
				month = m[3]*1;
				year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
				break;
			default :
				break;
		}
		if(!parseInt(month)) return false;
		month = month==0 ?12:month;
		var date = new Date(year, month-1, day);
        return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth()+1) && day == date.getDate());
		function GetFullYear(y){return ((y<30 ? "20" : "19") + y)|0;}
	}
 }


/*----------------------------------功能分隔符------------------------------------*/


/****************************
重写IE的ALERT框

*****************************/
var mainPicPath = "/hftWebService/images/";


/*----------------------------------功能分隔符------------------------------------*/


/*----------------------------------------------------------
Submitor.js
检查是否有重复提交的功能
调用方法：
		var sub = new Submitor();
		sub.alreadySubmited();//检查是否己经提交过了
		sub.clearRepeatSubmitFlag();//清除己经提交的标志
		sub.submit('base');/提交document中名字为base的form
------------------------------------------------------------*/

var __repeatSubmitDegree = 0;
function Submitor(form) {
	/*-------------------------------------------------------
	方法名：submit(pform)
	方法功能：
			提交一个给定名称的表单				
	---------------------------------------------------------*/
	this.submit = function submit(pform){
		if(this.alreadySubmited()){
			return false;	
		}
		if(pform!=null){
			pform.submit()
		}else{
			form.submit();
		}
	}
	
	/*-------------------------------------------------------
	方法名：location(page)
	方法功能：
			重定位页面URL				
	---------------------------------------------------------*/
	this.location = function location(page){
		if(this.alreadySubmited()){
			return false;	
		}
		form.location = page;
	}
	
	/*--------------------------------------------------------
	方法名：alreadySubmited()
	方法功能：
			检查表单是否己经提交
	返回值：
			如果己经提交，返回true，并提示，请不要重复提交。
			如果没有提交，返回false;	
	----------------------------------------------------------*/
	this.alreadySubmited = function alreadySubmited(){
		var rs_flag = false;
		if(__repeatSubmitDegree>0){
			rs_flag = true;
			alert("请不要重复发出相同请求!");
		}else{
			__repeatSubmitDegree++;
		}
		return rs_flag;
	}
	
	/*----------------------------------------------------------
	方法名：clearRepeatSubmitFlag()
	方法功能：清除己重复提交的标志
	------------------------------------------------------------*/
	this.clearRepeatSubmitFlag = function clearRepeatSubmitFlag(){
		__repeatSubmitDegree = 0;
	}
}


/*----------------------------------功能分隔符------------------------------------*/


/*****************************选择框弹出层控制 divsetter***************************/
var showDialog = false;
function showdiv(str, fd, width, height, left, top){
	showDialog = true;
    try{$("#fd1").hide();}catch(e){}
    try{$("#fd2").hide();}catch(e){}
    if(left + width > document.body.clientWidth) left = document.body.clientWidth - width - 10;
	$("#"+fd).html(str);
		$("#"+fd).css({
		"z-index":"100000",
		"position":"absolute",
		"display":"block",
		"width":width,
		"height":height,
		"left":left,
		"top":top
	});
	if(fd=="fd1"){
		$("#"+fd).mouseenter(function(){
		  showDialog = true;
		});
		$("#"+fd).mouseleave(function(){
		  showDialog = false;
		  setTimeout(function(){
		    if(!showDialog){
		 		$("#"+fd).html("");
		 		$("#"+fd).css("display", "none");
		 	}
		  },2000);
		});
	}
	$("#close").click(function(event){
		closeed(fd);
	});
}

function closeed(fd){
	$("#"+fd).hide();
}

function clearText(obj){
	obj.value = "";
}


/*****************************选择框弹出层控制***************************/

/*----------------------------------功能分隔符------------------------------------*/

/********************templateDiv.js********************************/

var projectPath = "/hftWebService";

function publicShowTable(width, divName){
	if(typeof(divName) == "undefined" || divName == null){
		divName = "fd1";
	}
	selector = "<table width=\""+width+"\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\" style=\"border-collapse:separate\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\""+projectPath+"/images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\""+projectPath+"/images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1);\" onclick=\"closeed('"+divName+"');return false;\"><img src=\""+projectPath+"/images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\""+projectPath+"/images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "  	<div id=\""+divName+"Content\"></div> "
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
	return 	selector;	 
}     

function publicShowTableReg(width){
	selector = "<table width=\"200\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\" style=\"border-collapse:separate\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\""+projectPath+"/images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\""+projectPath+"/images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1);\" onclick=\"closeed('fd2');return false;\"><img src=\""+projectPath+"/images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\""+projectPath+"/images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
//			 + "  			<tr>\n"
//			 + "    			<td width=\"5%\">选：</td>\n"
//			 + "    			<td width=\"95%\"><input type=\"text\" name=\"STREET_CODE\" oninput=\"matchStreet(this)\" class=\"street_box\" value=\"请输入街道拼音或名字\" onclick=\"clearText(this)\"></td>\n"
//			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"5%\"></td>\n"
			 + "    			<td width=\"95%\">\n"
			 + "					<div id=\"regDiv\">\n"
			 + "					</div>\n"
			 + "					<div id=\"streetDiv\" style=\"display: none\">\n"
			 + "					</div>\n"
			 + "				</td>\n"
			 + "			</tr>\n"
			 + "			<tr>\n"
			 + "				<td align=\"right\" colspan=\"2\"><a href=\"javascript:void(-1)\" onclick=\"closeed('fd2');\" class=\"bg btn_40red\">确定</a></td>\n"
			 + "			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
	return 	selector;	 
} 

function publicShowTableBuild(width){
selector = "<table width=\"300\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\" style=\"border-collapse:separate\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\""+projectPath+"/images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"280\" align=\"right\" background=\""+projectPath+"/images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1);\" onclick=\"closeed('fd2');return false;\"><img src=\""+projectPath+"/images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\""+projectPath+"/images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"5%\">选：</td>\n"
			 + "    			<td width=\"95%\"><input type=\"text\" id=\"BUILD_CODE\" name=\"BUILD_CODE\" oninput=\"matchBuild(this)\" class=\"street_box\" style=\"width:230px;\" value=\"请输入楼盘拼音或名字\" onclick=\"clearText(this)\"></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "				<td colspan=\"2\">\n"
			 + "					<div id=\"buildDiv\">\n"
			 + "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"table-layout: fixed\">\n"
			 + "							<tr>\n"
			 + "								<td align=\"left\" class=\"sub\"><input type=\"checkbox\" name=\"BUILD_ID\" value=\"\" onclick=\"clearBuild('BUILD_ID_TEXT', 'BUILD_ID', this)\" displayText=\"全部\"/><a href=\"javascript:void(-1)\" onclick=\"clearBuild('BUILD_ID_TEXT', 'BUILD_ID', this.parentNode.childNodes[0])\">清除条件</a></td>\n"
			 + "							</tr>\n"
			 + "						</table>\n"
			 + "					</div>\n"
			 + "				</td>\n"
			 + "			</tr>\n"
			 + "			<tr>\n"
			 + "				<td colspan=\"2\" align=\"right\"><a href=\"javascript:void(-1)\" onclick=\"handSelect();\" class=\"bg btn_40red\">确定</a><div style=\"padding-top:5px;\">输入汉字可模糊匹配！</div></td>\n"
			 + "			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
	return 	selector;		 
}

/*----------------------------------功能分隔符------------------------------------*/

/***********************************其他一些公共方法**********************************/

//AJAX开始执行时显示loading滚动条
$(document).ready(function(){
	var myXHR = null;
	var _myXHR = null;
	
	$.ajaxSetup({
		global: true,
		timeout:10000,
		retry: 2,
		error:function(xhr){
			if(xhr.status == 0 && (!_myXHR || xhr==_myXHR)){
				if(this.flag==undefined){
					this.flag=0;
				}
				if(this.flag<this.retry){
					this.flag++;
					setTimeout($.ajax(this), 15);
				}else{
					this.flag = 0;
					alertError(_errorDiv.replace("#ERRORMSG#","请求超时，请重试!").replace("#ERRORCLASS#","_errorTmp1"));
				}
			}else if(xhr.status==500){
				var resStr = $.trim(xhr.responseText);
				if(resStr.indexOf("闲置时间过长，系统已中断连接，请重新登录！")>-1){
					resStr = "闲置时间过长，系统已中断连接，请重新登录！";
					alertError(_errorDiv.replace("#ERRORMSG#",resStr).replace("#ERRORCLASS#","_errorTmp1"));
				}else{
					alertError(_errorDiv.replace("#ERRORMSG#",resStr).replace("#ERRORCLASS#","_errorTmp2"));
				}
			}
		}
	});	        
	
	$("#loading").ajaxSend(function(e,xhr,opt){
		if(opt.type == "POST"){
			try{
				if(!!myXHR){
					_myXHR = xhr;
					myXHR.abort();
				}
			}catch(e){}
			myXHR = xhr;
			$(this).html("<p style='text-align:center;color:red;'>数据加载中，请稍等...<br><img src='"+mainPicPath+"loading.gif'></p>");
			$(this).css("display", "block");
		}
	});
	
	//AJAX执行完毕时隐藏loading滚动条
	
	
	$("#loading").ajaxComplete(function(e,xhr,opt){
		$(this).css("display", "none");
	});
	
	//AJAX执行错误时显示
	$("#loading").ajaxError(function(event,xhr,options,exc){
		$(this).css("display", "none");
		var stauts = xhr.status;
		switch(stauts){
			case 0:
				break;
			case 12029:
				alertError(_errorDiv.replace("#ERRORMSG#","对不起，您的网络连接已断开！").replace("#ERRORCLASS#","_errorTmp1"));
				break;
			default:
				var resStr = $.trim(xhr.responseText);
				if(resStr == ""){
					alertError(_errorDiv.replace("#ERRORMSG#","对不起，您的网络连接已断开！").replace("#ERRORCLASS#","_errorTmp1"));
				}else{
					if(resStr.indexOf("置时间过长")>-1){
						alertError(_errorDiv.replace("#ERRORMSG#",resStr).replace("#ERRORCLASS#","_errorTmp1"));
					}else{
						alertError(_errorDiv.replace("#ERRORMSG#",resStr).replace("#ERRORCLASS#","_errorTmp2"));
					}
				}
				break;
		}
	});
});


//获得顶级父窗口
function getTiptopWindow(win){
	var cwindow = null;
	if(win){
		cwindow = win;
	}else{
		cwindow = window
	}
	while(true){
		var pwindow = cwindow.parent;
		if(cwindow == pwindow){
			break;
		}
		cwindow = pwindow;
	}
	return cwindow;
}

function checkBound(obj){
	if(document.getElementById("BOUND").value != "0"){
		alert("只有在本公司范围内时才能使用此条件！");
		obj.value = "";
		obj.readOnly = true;
		return false;
	}else{
		obj.readOnly = false;
	}
}

function CheckNum(str,checkOK){
	var checkStr= $.trim(str);
	var temp=$.trim(str);
	var ch_h="";
	for (i=0;i<checkStr.length;i++){
		ch_h=checkStr.charAt(i);
		//判断是否为数字
		if(checkOK.indexOf(ch_h)<0){
	        temp=temp.replace(ch_h,"");		
		}
		//判断第一位是否为小数点
		else if(checkStr.substring(0,1)=='.'){
			temp=temp.replace(ch_h,"");
		}
		//判断第一位是否为0的整数
		else if(checkStr.length>1){
			if(checkStr.substring(0,1)=='0' && checkStr.substring(1,2)!='.'){
				temp=temp.replace(temp,temp.substring(1,temp.length));
				break;
			}
		}
		//判断是否有多个小数点
		if(checkStr.indexOf('.')>0){
			if((checkStr.substring(checkStr.indexOf('.')+1,checkStr.length)).indexOf('.')>=0){
				temp=temp.replace(temp,temp.substring(0,temp.length-1));
				break;
			}
		}
	}
	return temp;
}

function checkPointNumber(obj){
	if(obj.value!=''){
		obj.value=CheckNum(obj.value,"0123456789.");
		obj.focus();
	}
}
function checkBaseNumber(obj){
	if(obj.value!=''){
		obj.value=CheckNum(obj.value,"0123456789");
		obj.focus();
	}
}
function checkNumChat(obj){
	if(obj.value!=''){
		obj.value=CheckNum(obj.value,"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		obj.focus();
	}
}

String.prototype.replaceAll  = function(s1,s2){    
	return this.replace(new RegExp(s1,"gm"),s2);    
}

function Display(obj) {
	var frameHeight = $("#result").css("height");
	frameHeight = frameHeight.replace((new RegExp("(px)"),"g"),"");
	var newHeight = parseInt(frameHeight);
	sid=obj.parentNode.parentNode.parentNode.childNodes[1];
	if (sid.style.display == "none") 
	{ 
		$("#result").css("height", (newHeight - 25) + "px");
		sid.style.display="";
	}else{ 
		$("#result").css("height", (newHeight + 25) + "px");
		sid.style.display="none";
	} 
} 

//构建默认时间条件
var defaultDateStart = "";
var defaultDateEnd = "";
var defaultDateShow = "";
var deptsCount = getTiptopWindow().deptsCount;
var bigDepts = getTiptopWindow().bigDepts;
function getDefaultCond(type){
	//范围
	try{
		var viewAllInfo = getTiptopWindow().viewAllInfo;
		var bound = getTiptopWindow().COND_BOUND;
		var deptIdStr = getTiptopWindow().COND_DEPT_ID;
		var boundText = getTiptopWindow().COND_BOUND_TEXT;
		var userId = getTiptopWindow().COND_USER_ID;
		var userIdText = getTiptopWindow().COND_USER_ID_TEXT;
		if(bound == ""){
			bound = "0";
			deptIdStr = eval(viewAllInfo) ? "" : getTiptopWindow().myDeptId;
			boundText = eval(viewAllInfo) ? "全公司" : getTiptopWindow().myDeptName;
		}
		if(userId == ""){
			userId = "";
			userIdText = "全部";
		}
		$("#BOUND").val(bound);
		$("#DEPT_ID").val(deptIdStr);
		$("#BOUND_TEXT").val(boundText);
		$("#USER_ID").val(userId);
		$("#USER_ID_TEXT").val(userIdText);
		chgButAbl();
	}catch(e){}
	
	//时间
	try{
		var defualtQuery = eval("getTiptopWindow().defualt"+type+"Query");
		var dateStart = getTiptopWindow().nowDateStr;
		var dateEnd = getTiptopWindow().nowDateStr;
		var dateShow = "";
		var nowDate = new Date(dateStart.replaceAll("-", "/"));
		if(defualtQuery == "ONEWEEK"){
			nowDate.setDate(parseInt(nowDate.getDate())-7);
			dateShow = "一周";
		}else if(defualtQuery == "ONEMONTH"){
			nowDate.setMonth(parseInt(nowDate.getMonth())-1);
			dateShow = "一月";
		}else if(defualtQuery == "ONEQUURTER"){
			nowDate.setMonth(parseInt(nowDate.getMonth())-3);
			dateShow = "一季";
		}else if(defualtQuery == "HALFYEAR"){
			nowDate.setMonth(parseInt(nowDate.getMonth())-6);
			dateShow = "半年";
		}else if(defualtQuery == "ONEYEAR"){
			nowDate.setFullYear(parseInt(nowDate.getFullYear())-1);
			dateShow = "一年";
		}else if(defualtQuery == "ALL"){
			dateStart = "";
			dateEnd = "";
			dateShow = "全部";
		}
		if(defualtQuery != "ALL"){
			dateStart = (nowDate.getFullYear()) + "-" + (nowDate.getMonth()+1) + "-" + (nowDate.getDate());
		}
		$("#CREATION_TIME1").val(dateStart);
		$("#CREATION_TIME2").val(dateEnd);
		$("#CREATION_TIME_TEXT").val(dateShow);
		defaultDateStart = dateStart;
		defaultDateEnd = dateEnd;
		defaultDateShow = dateShow;
	}catch(e){}
}

function chgButAbl(){
	var bound = document.base.BOUND.value;
	if(bound == "1"){
		document.getElementById("rgtBtn").style.display = "none";
		document.getElementById("shTrkBtn").style.display = "";
		document.getElementById("wtTrkBtn").style.display = "";
		document.getElementById("smsBtn").style.display = "none";
		document.base.PHONE.readOnly = false;
		try{document.base.SALE_NO.readOnly = false;}catch(e){}
		try{document.base.LEASE_NO.readOnly = false;}catch(e){}
	}else if(bound == "2"){
		document.getElementById("CREATION_TIME1").value = defaultDateStart;
		document.getElementById("CREATION_TIME2").value = defaultDateEnd;
		document.getElementById("CREATION_TIME_TEXT").value = defaultDateShow;
		document.getElementById("rgtBtn").style.display = "none";
		document.getElementById("shTrkBtn").style.display = "none";
		document.getElementById("wtTrkBtn").style.display = "none";
		document.getElementById("smsBtn").style.display = "none";
		document.base.PHONE.value = "";
		document.base.PHONE.readOnly = true;
		try{document.base.SALE_NO.value = "";}catch(e){}
		try{document.base.LEASE_NO.value = "";}catch(e){}
		try{document.base.SALE_NO.readOnly = true;}catch(e){}
		try{document.base.LEASE_NO.readOnly = true;}catch(e){}
	}else{
		document.getElementById("rgtBtn").style.display = "";
		document.getElementById("shTrkBtn").style.display = "";
		document.getElementById("wtTrkBtn").style.display = "";
		document.getElementById("smsBtn").style.display = "";
		document.base.PHONE.readOnly = false;
		try{document.base.SALE_NO.readOnly = false;}catch(e){}
		try{document.base.LEASE_NO.readOnly = false;}catch(e){}
	}
}

function getCenterDefault(type){
	//时间
	var defualtQuery = eval("getTiptopWindow().defualt"+type+"Query");
	var dateStart = getTiptopWindow().nowDateStr;
	var dateEnd = getTiptopWindow().nowDateStr;
	var dateShow = "";
	var nowDate = new Date(dateStart.replaceAll("-", "/"));
	if(defualtQuery == "ONEWEEK"){
		nowDate.setDate(parseInt(nowDate.getDate())-7);
		dateShow = "一周";
	}else if(defualtQuery == "ONEMONTH"){
		nowDate.setMonth(parseInt(nowDate.getMonth())-1);
		dateShow = "一月";
	}else if(defualtQuery == "ONEQUURTER"){
		nowDate.setMonth(parseInt(nowDate.getMonth())-3);
		dateShow = "一季";
	}else if(defualtQuery == "HALFYEAR"){
		nowDate.setMonth(parseInt(nowDate.getMonth())-6);
		dateShow = "半年";
	}else if(defualtQuery == "ONEYEAR"){
		nowDate.setFullYear(parseInt(nowDate.getFullYear())-1);
		dateShow = "一年";
	}else if(defualtQuery == "ALL"){
		dateStart = "";
		dateEnd = "";
		dateShow = "全部";
	}
	if(defualtQuery != "ALL"){
		dateStart = (nowDate.getFullYear()) + "-" + (nowDate.getMonth()+1) + "-" + (nowDate.getDate());
	}
	$("#CREATION_TIME1").val(dateStart);
	$("#CREATION_TIME2").val(dateEnd);
	$("#CREATION_TIME_TEXT").val(dateShow);
	defaultDateStart = dateStart;
	defaultDateEnd = dateEnd;
	defaultDateShow = dateShow;
}


/*----------------------------------功能分隔符------------------------------------*/

//替换新的replace
String.prototype._replace = String.prototype.replace;
String.prototype.replace = function(a,b){
	var retStr = "";
	try{
		retStr = this._replace((typeof(a)=="object"?a:new RegExp(a,'ig')),b);
	}catch(e){
		retStr = this._replace(a, b);
	}
	return retStr;
}

//替换新的Alert
var _alert = window.alert;//保留原始alert
var _confirm = window.confirm;//保留原始confirm
//var _Main_Frame = top.window.frames["mainFrame"];
var _Main_Frame = top;//.window.frames["mainFrame"];
window.alert = function(txt){
	if(!!_Main_Frame.Myfun7_Dialog){
		_Main_Frame.Myfun7_Dialog._alert(txt);
	}else{
		setTimeout(function(){alert(txt)},100);
	}
}
window.confirm = function(txt,yesFunc,cancleFunc){
	if(!!_Main_Frame.Myfun7_Dialog){
		_Main_Frame.Myfun7_Dialog._confirm(txt,yesFunc,cancleFunc);
	}else{
		setTimeout(function(){confirm(txt,yesFunc,cancleFunc)},100);
	}
}

//统计分析里面在用
window.toast = function(obj,txt){
	$("#closeDialog_btn_toast",document)._trigger("click");
	if(!!_Main_Frame.Myfun7_Dialog){
		if(typeof obj === "string"){
			console.log("sss");
			_Main_Frame.Myfun7_Dialog.toast(obj);
			setTimeout(function(){
				console.log(11);
				$("#closeDialog_btn_toast", document)._trigger("click");
			},2000);
		}else{
			console.log("obje");
			if($(obj).is("a"))$(obj).attr("href","javascript:void(-1)");
			_Main_Frame.Myfun7_Dialog.toast(txt);
			$(obj).bind("mouseout",function(){
				clearTimeout(window._TOAST);
				window._TOAST = setTimeout(function(){
					$("#closeDialog_btn_toast", document)._trigger("click");
				},2000);
			}).bind("mouseover",function(){
				clearTimeout(window._TOAST);
			});
			_Main_Frame.Myfun7_Dialog.toast(txt);
		}
	}else{
		setTimeout(function(){toast(obj,txt)},100);
	}
}
function OpenDiv(frameId,src,width,height,screenLeft,ScreenTop,scrollFlag,callback){
	//处理老的openDiv
	if(!isNaN(frameId)){//如果是数字
		var frameMap = _Main_Frame.document.getElementsByTagName("iframe");
		for(var t=0;t<frameMap.length;t++){
			var frameObj = frameMap[t];//_alert(frameObj.id);
			if(frameObj.contentWindow==window){frameId = frameObj.id;break;}
		}
	}
	width = (width==665)?750:width;//fix orignal code
	height = (height==470)?435:height;//fix orignal code
	_Main_Frame.Myfun7_Dialog.dialog(frameId,src,width,height,screenLeft,ScreenTop,scrollFlag,callback);
}

function OpenDiv2(opts){
	//处理老的openDiv
	if(!isNaN(opts.frameId)){//如果是数字
		var frameMap = _Main_Frame.document.getElementsByTagName("iframe");
		for(var t=0;t<frameMap.length;t++){
			var frameObj = frameMap[t];//_alert(frameObj.id);
			if(frameObj.contentWindow==window){opts.frameId = frameObj.id;break;}
		}
	}
	_Main_Frame.Myfun7_Dialog.FL(opts);
}
function OpenmishuDiv(src,width,height,screenLeft,ScreenTop){
	_Main_Frame.Myfun7_Dialog.dialog("main",src,width,height,screenLeft,ScreenTop);
}
function closetDiv(win,num){
	if(win==undefined)win = window;
	_Main_Frame.Myfun7_Dialog.closeD(win,num);
}
function nopay(txt){
	if(!!_Main_Frame.Myfun7_Dialog){
		_Main_Frame.Myfun7_Dialog._alert(txt,false);
	}else{
		setTimeout(function(){nopay(txt)},100);
	}
}
/**
 * 快速支付
 * @param type
 * @param text
 * @param lock
 */
function rapidPay(type, text, lock){
	if(ClientCachePlugin.getValue("UA_ID") == null){
		//var uMainFrame = top.document.getElementById("mainFrame").contentWindow;
		var uMainFrame = window;
		uMainFrame.lightbox.init(uMainFrame);
		uMainFrame.lightbox.setOpacity(0.6, 0.25);
		uMainFrame.lightbox.varPool = uMainFrame.lightbox.varPool || {};
		uMainFrame.lightbox.varPool.arid = ClientCachePlugin.getValue("ARCHIVE_ID");
		uMainFrame.lightbox.showUrl('/ucenter/common/bindAccount.html', '绑定资金账户', 420, 315, function(){
			var rst = uMainFrame.lightbox.bindResult;
			if(rst!=undefined){
				if(rst.code == 200){
					ClientCachePlugin.setValue("uaId", rst.data);
					//top.setUaId(rst.data); jsg 注释 现在改存客户端或者服务器
				}else{
					alert(rst.data);
				}
			}
		});
		return;
	}
	if(!!_Main_Frame.rapidPay){
		_Main_Frame.rapidPay.init(type, text, lock);
	}else{
		setTimeout(function(){rapidPay(type, text, lock)},100);
	}
}

/**
 * 电话认证
 * @param text
 * @param archiveId
 * @param userId
 */
function mobileValid(text, archiveId, userId){
	//thisMobileValid mobileValid.js 存储
	if(typeof(_archiveId) == "undefined" && ClientCachePlugin.getValue("thisMobileValid")){
		alert("你已经进行了手机认证，请重新登录系统使用该功能！");
	}else{
		_Main_Frame.MobileValid.init(text, true, archiveId, userId);
	}
}

function closeRapid(){
	_Main_Frame.lightbox.close(true);
}

function authorAlert(txt){
	alert(txt);  //将原要要alert的内容打印后 重构!
	$("#closeAlert_btn", document)
		.removeClass("ctrl_btn btn_yes")
		.addClass("ctrl_btn btn_no")
		.html("取消")
		.before("<a class=\"ctrl_btn btn_yes\" href=\"javascript:void(0)\" onclick=\"goAuthor()\">现在去认证</a>");
}
//抽奖功能专用，跳转到个人中心。
function authorLotteryAlert(txt){
	alert(txt);  //将原要要alert的内容打印后 重构!
	$("#closeAlert_btn", document)
		.removeClass("ctrl_btn btn_yes")
		.addClass("ctrl_btn btn_no")
		.html("取消")
		.before("<a class=\"ctrl_btn btn_yes\" href=\"javascript:void(0)\" onclick=\"goAuthor()\">现在去充值</a>");
}
//跳转到个人中心 调用客户端交互控件调转
function goAuthor(){
	alert("请到个人中操作");
	//$("#closeAlert_btn", document).trigger("click");
	//top.frames["mainFrame"].document.getElementById("ucenterFrm").src =ucenterPath+"&type=valid&t="+Math.random();
	//top.frames["mainFrame"].document.getElementById("ucenterFrm").style.display ="block";
	//top.frames["mainFrame"].document.getElementById(top.frames["mainFrame"].nowFrm).style.display ="none";
	//top.frames["mainFrame"].nowFrm = "ucenterFrm";
	//top.closePhotoDiv();
}

//cc添加2013-01-18,发发专用------------//
/*var zymArray = [];//验证码队列,cc添加
var shopInfoLimit = null;//S_sid
var urlsData = null;//S_hType_siteid
var oParam = {
	aid:0,
	deptId:0,
	compNo:'',
	cityPY:'',
	curSId:0,
	curSiteId:0,
	curSiteName:''
};
var pDatas = null;
var locEnable = 0;//本地发发状态 1=可用 其他不可用
var VALID_SINGLE = 'valid-single';
var VALID_BAT = 'valid-bat';
var POP_PUB = "pop-pub";
var PUBLISH = "publish";
var ORDERREF = "orderRef";//预约刷新
var leftWitdh = 0;
var status_dic = null;
*/
/*function pubHouse(caseNo,caseType,useAge,fun){
	$.ajax({
		url:getTiptopWindow().siteRoot  + '/fafunv2/fafa_dialog_ajax.jsp?t=' + new Date().getTime(),
		data:"KEY=QUERY_CENTER_HOUSE&HOUSE_NO=" + caseNo + "&HOUSE_USEAGE=" + useAge + "&SALE_LEASE=" + caseType,
		type:'POST',
		success:function(retStr){
			retStr = $.trim(retStr);
			if(retStr != "NONE"){
				setHouseInfo(eval(retStr));
				//window.location.href = getTiptopWindow().siteRoot  + '/fafunv2/fafa_dialog_vertical.html';
				var mainObj = top;//document.getElementById("mainFrame").contentWindow;
				mainObj.publicFafaDialog("/fafunv2/fafa_dialog.html","群发房源",850,430,function(){
					if(fun){
						fun();
					}
				});
			}else{
				alert("下载房源数据失败,请联系好房通客服!");
			}
		}
	});
}*/

/*function setHouseInfo(array){
	//document.getElementById("bottomFrame").contentWindow.houseItem = array;
}*/

/*function getHouseInfo(){
	//return document.getElementById("bottomFrame").contentWindow.houseItem;
}*/

//项目里面暂时没有用
/*function setFramId(){
	var topObj = top;//.frames["mainFrame"].contentWindow;
	top.ifarmId = topObj;//.nowFrm;
}*/

/*function refFafaInitInfo(fun){
	var bottomObj = document.getElementById("bottomFrame").contentWindow;
	bottomObj.initFafaParam(fun);
}*/

//项目里面暂时没有用
/*function loadFafaParam(){
	zymArray = top.zymArray;
	urlsData = top.urlsData;
	pDatas = top.pDatas;
	shopInfoLimit = top.shopInfoLimit;
	oParam = top.oParam;
	locEnable = top.locEnable;
	status_dic = top.status_dic;
}*/

/*$(document).ready(function (){
	loadFafaParam();
});*/

//公共发发,发布回调方法.
/*function fafun_callbackPublic(tType, param){
	setTimeout(function(){
		if(tType==102){
			var parArr = param.split("$");
			if(parArr[0]!='0'){
				$.ajax({
					url : getTiptopWindow().siteRoot  + '/fafunv2/site_house_list_ajax.jsp?t='+new Date().getTime(),
					data : 'action=saveSelfPub&sid='+parArr[1]+"&type="+parArr[3]+"&htype="+parArr[0]+"&houseid="+parArr[2]+"&webids="+parArr[4].replace(/｜/g, '@'),
					type : 'POST'
				});
			}
		}
		
		var oDoc = null;
		var topObj = top;//.document.getElementById("mainFrame").contentWindow;
		topObj = topObj.document.getElementById(top.ifarmId).contentWindow;
		var oLBFrame = topObj.document.getElementById("lightbox_iframe");
		if(oLBFrame){
			oDoc = oLBFrame.contentWindow;
			if(oDoc.updateView){
				try{oDoc.updateView(tType,param);}catch(e){}
			}
		}
	}, 50);
}*/


//发发编辑房源对话框调用,新盘的分销功能
/*function dialogCallBack(houseId,cityId){
	$.infowin("","<iframe id='EDITINFO' src='about:blank' frameBorder='0' width='100%' style='overflow-x:hidden;overflow-y:auto;height:420px;'></iframe>",880,480);
	$("#EDITINFO").attr("src",getTiptopWindow().siteRoot  + "/distribute1/fafa.jsp?HOUSE_ID="+houseId+"&CITY_ID="+cityId);
}*/

//房源编辑后开始发布判断  1:检查 2:发布
/*function editHouseCallBack(type){
	var oLBFrame = document.getElementById("lightbox_iframe");
	if(oLBFrame.contentWindow){
		return oLBFrame.contentWindow.editHouse(type);
	}
	return false;
}*/
//cc添加2013-01-18,发发专用------------//
/*function initUserInfoTb(compDept,userName,userPhone,nowTime){
	var tab_tpl = '\
		<table border="0" style="height:40px;width:100%;table-layout:fixed">\
		  <tr>\
		    <td align="left" id="compDept">单　位：</td>\
		    <td align="center" id="userName">经纪人：</td>\
		    <td align="center" id="userPhone">电　话：</td>\
		    <td align="right" id="nowTime"></td>\
		  </tr>\
		</table>\
		';
	$("#userInfoTb").html(tab_tpl).css("display","block");
	$("#compDept").html("单　位："+compDept);
	$("#userName").html("经纪人："+userName);
	$("#userPhone").html("电　话："+userPhone);
	$("#nowTime").html("日　期："+nowTime.replace(/日期：/gi,""));
}*/
//统计分析里面在用
/*window.toast = function(obj,txt){
	$("#closeDialog_btn_toast",top.document.getElementById("mainFrame").contentWindow.document)._trigger("click");
	if(!!_Main_Frame.Myfun7_Dialog){
		if(typeof obj === "string"){
			_Main_Frame.Myfun7_Dialog.toast(obj);
			setTimeout(function(){
				$("#closeDialog_btn_toast",top.document.getElementById("mainFrame").contentWindow.document)._trigger("click");
			},2000);
		}else{
			if($(obj).is("a"))$(obj).attr("href","javascript:void(-1)");
			_Main_Frame.Myfun7_Dialog.toast(txt);
			$(obj).bind("mouseout",function(){
				clearTimeout(window._TOAST);
				window._TOAST = setTimeout(function(){
					$("#closeDialog_btn_toast",top.document.getElementById("mainFrame").contentWindow.document)._trigger("click");
				},2000);
			}).bind("mouseover",function(){
				clearTimeout(window._TOAST);
			});
			_Main_Frame.Myfun7_Dialog.toast(txt);
		}
	}else{
		setTimeout(function(){toast(obj,txt)},100);
	}
}*/
//暂时项目里面没有用
/*function alertError(txt) {
	var w = top.document.getElementById("mainFrame").clientWidth;
	var h = top.document.getElementById("mainFrame").clientHeight+160;
	var frameObj = top.document.getElementById("mainFrame").contentWindow.document;
	/*var bottomFrameObj = document.getElementById("bottomFrame").contentWindow.document;
	var bottomShield =  bottomFrameObj.getElementById("bottomShield1");
	if(bottomShield==null){
		bottomShield = bottomFrameObj.createElement("DIV"); 
		bottomShield.id = "bottomShield1"; 
		bottomShield.style.cssText = "position:absolute;left:0px;top:0px;width:"+(w-10)+"px;height:"+(h-170)+"px;z-index:1000002;opacity: 0;background-color:#fff";
		bottomFrameObj.body.appendChild(bottomShield); 
	}
	var shield = frameObj.getElementById("shield");
	if(shield==null){
		shield = frameObj.createElement("DIV");
		shield.id = "shield"; 
		shield.style.cssText = "position:absolute;left:0px;top:0px;width:"+(w-10)+"px;height:"+(h-170)+"px;z-index:1000002;opacity: 0;background-color:#fff;display:none;";
		frameObj.body.appendChild(shield); 
	}else{
		shield.style.cssText = "position:absolute;left:0px;top:0px;width:"+(w-10)+"px;height:"+(h-170)+"px;z-index:1000002;opacity: 0;background-color:#fff;display:none;";
	}
	var alertFram = frameObj.getElementById("alertFram");
	if(alertFram==null){
		alertFram = frameObj.createElement("DIV"); 
		alertFram.id="alertFram"; 
		alertFram.style.cssText = "position:absolute;left:"+(w-400)/2+"px;top:"+(h-400)/2+"px;width:400px;height:100px;text-align:center;z-index:1000003;margin-left:0px;margin-top:0px;";
		frameObj.body.appendChild(alertFram); 
	}
	txt = "<br/><br/>"+String(txt);
	txt = txt.replace(/\n/gi,"<br/>");
	alertFram.innerHTML = txt; 
	alertFram.style.display = "block";
	shield.style.display = "block"; 
	//bottomShield.style.display = "block";
	frameObj.body.onselectstart = function(){return false;};
	//shield.onclick = function(){
	//	setTimeout(function(){
		//	closeAlert();
	//	},200);
	//} 
	//alertFram.onclick = function(){
	//	setTimeout(function(){
		//	closeAlert();
	//	},200);
	//} 
}*/
//暂时项目里面没有用
/*function closeAlert(){
	var frameObj = top.document.getElementById("mainFrame").contentWindow.document;
	//var bottomFrameObj = document.getElementById("bottomFrame").contentWindow.document;
	frameObj.body.removeChild(frameObj.getElementById("alertFram"));
	frameObj.body.removeChild(frameObj.getElementById("shield"));
	//bottomFrameObj.body.removeChild(bottomFrameObj.getElementById("bottomShield1"));
}*/
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
		console.log("注册控件");
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
			console.log("初始化服务器端参数");
			//从服务器端取
			value = this.getServerParameters();
			if(!!value){
				this.parameters = value;//$.parseJSON(value);
			}
		}
		if(!value){
			console.log("初始化参数失败，请联系客户!");
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
				console.log("缓存对象为空");
			}
		}else{
			console.log("请先注册控件:"+document.location.href);
		}
		console.log("调用控件获取值:key=" + key + "-value=" +value);
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
				console.log("调用控件设置值:key="+key+"-value="+value +" 服务端");
			}
		}else{
			console.log("请先注册控件:"+document.location.href);
		}
	},
	/**
	 * 获取服务器参数放在 如果失败是返回null
	 */
	getServerParameters : function(){
		var result = null;
		if(this.isRegisted){
			$.ajax({
			   type : "post",
			   url : this.getSiteRootUrl()+"/bulletin/getParameters",
			   data : "CLIENTKEY="+this.getClientKey(),
			   dataType : "json",
			   async : false,
			   success: function(msg){
				   result = msg;
			   },
			   error : function(){
				   console.log("获取参数失败");
			   }
			});
		}
		console.log("从服务端获取所有参数:" + result);
		return result;
	},
	getServerParameter : function(key){
		var result = true;
		if(this.isRegisted){
			$.ajax({
			   type : "post",
			   url : this.getSiteRootUrl()+"/bulletin/getParameter",
			   data : "CLIENTKEY="+this.getClientKey()+"&key="+key,
			   dataType : "json",
			   async : false,
			   success: function(msg){
				   result = msg;
			   },
			   error : function(){
				   console.log("获取参数失败");
				   result = false;
			   }
			});
		}
		console.log("从服务器端获取参数:key=" +key + "-value=" +result);
		return result;
	},
	setServerParameter : function(key, value){
		console.log("把值设置到服务器端:key="+key+"-value="+value);
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
				   console.log("获取参数失败");
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
