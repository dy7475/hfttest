/*
    通用表单验证方法
    Validform version 5.3
	By sean during April 7, 2010 - December 28, 2012
	For more information, please visit http://validform.rjboy.cn
	Validform is available under the terms of the MIT license.
	
	Demo:
	$(".demoform").Validform({//$(".demoform")指明是哪一表单需要验证,名称需加在form表单上;
		btnSubmit:"#btn_sub", //#btn_sub是该表单下要绑定点击提交表单事件的按钮;如果form内含有submit按钮该参数可省略;
		btnReset:".btn_reset",//可选项 .btn_reset是该表单下要绑定点击重置表单事件的按钮;
		tiptype:1, //可选项 1=>pop box,2=>side tip(parent.next.find; with default pop),3=>side tip(siblings; with default pop),4=>side tip(siblings; none pop)，默认为1，也可以传入一个function函数，自定义提示信息的显示方式（可以实现你想要的任何效果，具体参见demo页）;
		mark:true,//可选项 默认为false是否高亮显示必填项
		markCss:"mark",//可选项 高亮显示的css样式
		ignoreHidden:false,//可选项 true | false 默认为false，当为true时对:hidden的表单元素将不做验证;
		dragonfly:false,//可选项 true | false 默认false，当为true时，值为空时不做验证；
		tipSweep:true,//可选项 true | false 默认为false，只在表单提交时触发检测，blur事件将不会触发检测（实时验证会在后台进行，不会显示检测结果）;
		showAllError:false,//可选项 true | false，true：提交表单时所有错误提示信息都会显示，false：一碰到验证不通过的就停止检测后面的元素，只显示该元素的错误信息;
		postonce:true, //可选项 表单是否只能提交一次，true开启，不填则默认关闭;
		ajaxPost:true, //使用ajax方式提交表单数据，默认false，提交地址就是action指定地址;
		datatype:{//传入自定义datatype类型，可以是正则，也可以是函数（函数内会传入一个参数）;
			"*6-20": /^[^\s]{6,20}$/,
			"z2-4" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,4}$/,
			"username":function(gets,obj,curform,regxp){
				//参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
				var reg1=/^[\w\.]{4,16}$/,
					reg2=/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,8}$/;
				
				if(reg1.test(gets)){return true;}
				if(reg2.test(gets)){return true;}
				return false;
				
				//注意return可以返回true 或 false 或 字符串文字，true表示验证通过，返回字符串表示验证失败，字符串作为错误提示显示，返回false则用errmsg或默认的错误提示;
			},
			"phone":function(){
				// 5.0 版本之后，要实现二选一的验证效果，datatype 的名称 不 需要以 "option_" 开头;	
			}
		},
		usePlugin:{
			swfupload:{},
			datepicker:{},
			passwordstrength:{},
			jqtransform:{
				selector:"select,input"
			}
		},
		beforeCheck:function(curform){
			//在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
			//这里明确return false的话将不会继续执行验证操作;	
		},
		beforeSubmit:function(curform){
			//在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
			//这里明确return false的话表单将不会提交;	
		},
		callback:function(data){
			//返回数据data是json格式，{"info":"demo info","status":"y"}
			//info: 输出提示信息;
			//status: 返回提交数据的状态,是否提交成功。如可以用"y"表示提交成功，"n"表示提交失败，在ajax_post.php文件返回数据里自定字符，主要用在callback函数里根据该值执行相应的回调操作;
			//你也可以在ajax_post.php文件返回更多信息在这里获取，进行相应操作；
			//ajax遇到服务端错误时也会执行回调，这时的data是{ status:**, statusText:**, readyState:**, responseText:** }；
			
			//这里执行回调操作;
			//注意：如果不是ajax方式提交表单，传入callback，这时data参数是当前表单对象，回调函数会在表单验证全部通过后执行，然后判断是否提交表单，如果callback里明确return false，则表单不会提交，如果return true或没有return，则会提交表单。
		}
	});
	
	Validform对象的方法和属性：
	tipmsg：自定义提示信息，通过修改Validform对象的这个属性值来让同一个页面的不同表单使用不同的提示文字；
	dataType：获取内置的一些正则；
	eq(n)：获取Validform对象的第n个元素;
	ajaxPost(flag,sync,url)：以ajax方式提交表单。flag为true时，跳过验证直接提交，sync为true时将以同步的方式进行ajax提交，传入了url地址时，表单会提交到这个地址；
	abort()：终止ajax的提交；
	submitForm(flag,url)：以参数里设置的方式提交表单，flag为true时，跳过验证直接提交，传入了url地址时，表单会提交到这个地址；
	resetForm()：重置表单；
	resetStatus()：重置表单的提交状态。传入了postonce参数的话，表单成功提交后状态会设置为"posted"，重置提交状态可以让表单继续可以提交；
	getStatus()：获取表单的提交状态，normal：未提交，posting：正在提交，posted：已成功提交过；
	setStatus(status)：设置表单的提交状态，可以设置normal，posting，posted三种状态，不传参则设置状态为posting，这个状态表单可以验证，但不能提交；
	ignore(selector)：忽略对所选择对象的验证(新添加对高亮显示的判断)；
	unignore(selector)：将ignore方法所忽略验证的对象重新获取验证效果(新添加对高亮显示的判断)；
	addRule(rule)：可以通过Validform对象的这个方法来给表单元素绑定验证规则；
	check(bool,selector):对指定对象进行验证(默认验证当前整个表单)，通过返回true，否则返回false（绑定实时验证的对象，格式符合要求时返回true，而不会等ajax的返回结果），bool为true时则只验证不显示提示信息；
	config(setup):可以通过这个方法来指定表单的提交地址，给表单ajax和实时验证的ajax里设置参数；
*/

(function($,win,undef){
	var errorobj=null,//指示当前验证失败的表单元素;
		msgobj=null,//pop box object 
		msghidden=true; //msgbox hidden?

	var tipmsg={//默认提示文字;
		tit:"提示信息",
		w:{
			"*":"不能为空！",
			"*6-16":"请填写6到16位任意字符！",
			"n":"请填写数字！",
			"n6-16":"请填写6到16位数字！",
			"s":"不能输入特殊字符！",
			"s6-18":"请填写6到18位字符！",
			"p":"请填写邮政编码！",
			"m":"请填写手机号码！",
			"e":"邮箱地址格式不对！",
			"url":"请填写网址！"
		},
		def:"请填写正确信息！",
		undef:"datatype未定义！",
		reck:"两次输入的内容不一致！",
		r:"通过信息验证！",
		c:"正在检测信息…",
		s:"请填入信息！",
		s_auto:"请{填写}{0}！",
		v:"所填信息没有经过验证，请稍后…",
		p:"正在提交数据…"
	}
	$.Tipmsg=tipmsg;
	
	var Validform=function(forms,settings,inited){
		var settings=$.extend({},Validform.defaults,settings);
		settings.datatype && $.extend(Validform.util.dataType,settings.datatype);
		
		var brothers=this;
		brothers.tipmsg={w:{}};
		brothers.settings=settings;
		brothers.forms=forms;
		brothers.objects=[];
		
		//创建子对象时不再绑定事件;
		if(inited===true){
			return false;
		}
		
		forms.each(function(){
			//已经绑定事件时跳过，避免事件重复绑定;
			if(this.validform_inited=="inited"){return true;}
			this.validform_inited="inited";
			
			var $this=$(this);
			$this.data("settings",settings);
			//防止表单按钮双击提交两次;
			this.validform_status="normal"; //normal | posting | posted;
			
			//让每个Validform对象都能自定义tipmsg;	
			$this.data("tipmsg",brothers.tipmsg);

			//bind the blur event;
			$this.find("[datatype]").live("blur",function(){
				//判断是否是在提交表单操作时触发的验证请求；
				var subpost=arguments[1];
				$(this).data("triggertype","blur");
				Validform.util.check.call(this,$this,brothers,subpost);
			});
			
			//点击表单元素，默认文字消失效果;
			//表单元素值比较时的信息提示增强;
			//radio、checkbox提示信息增强;
			//外调插件初始化;
			Validform.util.enhance.call($this,settings.tiptype,settings.usePlugin,settings.tipSweep);
			
			settings.btnSubmit && $this.find(settings.btnSubmit).bind("click",function(){
				$this.trigger("submit");
				return false;
			});
						
			$this.submit(function(){
				var subflag=Validform.util.submitForm.call($this,settings);
				subflag === undef && (subflag=true);
				return subflag;
			});
			
			$this.find("[type='reset']").add($this.find(settings.btnReset)).bind("click",function(){
				Validform.util.resetForm.call($this);
			});
			
		});
		
		//预创建pop box;
		if( settings.tiptype==1 || (settings.tiptype==2 || settings.tiptype==3) && settings.ajaxPost ){		
			creatMsgbox();
		}
	}
	
	Validform.defaults={
		mark:false,//@fixed 标记必填字段的标志
		markCss:"Validform_mark",//@fixed 标记必填字段的颜色
		groupCheck:false,//@fixed bulr是否触发组验证
		tiptype:1,
		tipSweep:false,
		showAllError:false,
		postonce:false,
		ajaxPost:false
	}
	
	Validform.util={
		dataType:{
			"Require":  /.+/,
			"C6-16":    /^[\w\W]{6,16}$/,
			"English":  /^[A-Za-z]+$/,
			"Nubmer":   /^\d+$/,
			"EnglishAndNumber":/^[A-Za-z0-9]+$/,
			"Chinese":  /^[\u0391-\uFFE5]+$/,
			"n6-16":    /^\d{6,16}$/,
			"Varchar":  /^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$/,
			"s6-18":    /^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{6,18}$/,
			"Zip":      /^[1-9]\d{5}$/,
			"Phone":    /(^[0-9]{7,8}$)|(^[0-9]{3,4}[0-9]{7,8})$/,
			"vPhone":   /^\d{7,20}$/,   //境外电话
			"Mobile":   /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/,
			"Email":    /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
			"Url":      /^(\w+:\/\/)?\w+(\.\w+)+.*$/,
			"Integer":  /^[-\+]?\d+$/,
			"Double":   /^[-\+]?\d+(\.\d+)?$/,
			"IdCard":   function(gets, obj, curform, regx){return Validform.util.IsIdCard(gets, obj, curform, regx)},
			"Limit":    function(gets, obj, curform, regx){return Validform.util.limit(gets, obj, curform, regx)},
			"LimitB":   function(gets, obj, curform, regx){return Validform.util.limitB(gets, obj, curform, regx)}, //包含中文(中文算2字符)的验证：attr: {Min, Max}
			"LimitC":   function(gets, obj, curform, regx){return Validform.util.limitC(gets, obj, curform, regx)}, //包含中文(中文算2字符)的验证：attr: {Min, Max}
			"Date":     function(gets, obj, curform, regx){return Validform.util.vDate(gets, obj, curform, regx)},
			"Year":     function(gets, obj, curform, regx){return Validform.util.Year(gets, obj, curform, regx)},
			"Time":     /^([0-1]?[0-9]|2[0-3]):([0-5][0-9])$/,
			"IntRange":	function(gets, obj, curform, regx){return Validform.util.intRange(gets, obj, curform, regx)},
			"PhoneOrMobile":function(gets, obj, curform, regx){return Validform.util.PhoneOrMobile(gets, obj, curform, regx)},
			"ApplyYears":function(gets, obj, curform, regx){return Validform.util.ApplyYears(gets, obj, curform, regx)},
			"ApplyAmountMax":function(gets, obj, curform, regx){return Validform.util.ApplyAmountMax(gets, obj, curform, regx)},
			"Price":function(gets, obj, curform, regx){return Validform.util.Price(gets, obj, curform, regx)},
			"TotalAmount":function(gets, obj, curform, regx){return Validform.util.TotalAmount(gets, obj, curform, regx)},
			"ZhiFuBao":function(gets, obj, curform, regx){return Validform.util.ZhiFuBao(gets, obj, curform, regx)},
			"BankName":function(gets, obj, curform, regx){return Validform.util.BankName(gets, obj, curform, regx)},
			"AccountNo":function(gets, obj, curform, regx){return Validform.util.AccountNo(gets, obj, curform, regx)}
	},
/*
			"*":/[\w\W]+/,
			"*6-16":/^[\w\W]{6,16}$/,
			"n":/^\d+$/,
			"n6-16":/^\d{6,16}$/,
			"s":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$/,
			"s6-18":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{6,18}$/,
			"p":/^[0-9]{6}$/,
			"m":/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/,
			"e":/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
			"url":/^(\w+:\/\/)?\w+(\.\w+)+.*$/,
			"ne":/^[\w\.]+$/,
			"f":/\d+(\.\d+)?$/
*/		
		toString:Object.prototype.toString,
		
		getValue:function(obj){
			var inputval,
				curform=this;
				
			if(obj.is(":radio")){
				inputval=curform.find(":radio[name='"+obj.attr("name")+"']:checked").val();
				inputval= inputval===undef ? "" : inputval;
			}else if(obj.is(":checkbox")){
				inputval="";
				curform.find(":checkbox[name='"+obj.attr("name")+"']:checked").each(function(){ 
					inputval +=$(this).val()+','; 
				})
				inputval= inputval===undef ? "" : inputval;
			}else{
				inputval=obj.val();
			}
			return $.trim(inputval);
		},
		
		limit:function(gets, obj, curform, regx){
			var valLen = gets.length;
			if(valLen < obj.attr("Min") || valLen > obj.attr("Max")){
				return false;
			}
			return true;
		},
				
		limitB:function(gets, obj, curform, regx){
			var valLen = gets.replace(/[^\x00-\xff]/g,"**").length;
			if(valLen < obj.attr("Min") || valLen > obj.attr("Max")){
				return false;
			}
			return true;
		},
		limitC:function(gets, obj, curform, regx){
		    var valLen = $("<div/>").html(gets).text().replace(/([\s]+)/gm,"").length;
		   	if(valLen < obj.attr("Min") || valLen > obj.attr("Max")){
				return false;
			}
			return true;
		},
		//这个js暂时没有地方用
		Year:function(gets, obj, curform, regx){
			if(gets==parseInt(gets) && parseInt(gets)>=1970 && parseInt(gets)<=top.nowYearStr){
				return true;
			}
			return false;
		},
		PhoneOrMobile:function(gets, obj, curform, regx){
			if(gets.match(/(^[0-9]{7,8}$)|(^[0-9]{3,4}[0-9]{7,8})$/) || gets.match( /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/)){
				return true;
			}
			return false;
		},
		ApplyYears:function(gets, obj, curform, regx){
			var max = $("#max").val();
			if(gets==parseInt(gets) && parseInt(gets) >=1 && parseInt(gets) <= max){
				return true;
			}
			return false;
		},
		ApplyAmountMax :function(gets, obj, curform, regx){
			if($("#LOAD_TYPE").val() == '3'){
				var total = $("#total").val();
				if(gets==parseFloat(gets) && parseFloat(gets) >1 && parseFloat(gets) <= total){
					return true;
				}
			}else{
				if(gets==parseFloat(gets) && parseFloat(gets) >1 && parseFloat(gets) < 10000){
					return true;
				}
			}
			return false;
		},
		Price :function(gets, obj, curform, regx){
			
				if(gets==parseFloat(gets) && parseFloat(gets) >1){
					return true;
				}
			return false;
		},
		TotalAmount:function(gets, obj, curform, regx){
			
			if(gets==parseInt(gets) && parseInt(gets) >1){
				return true;
			}
			return false;
		},
		ZhiFuBao:function(gets, obj, curform, regx){
			if(gets.match(/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/) || gets.match(/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/)){
				return true;
			}
			return false;
		},		
		BankName:function(gets, obj, curform, regx){
			gets = $.trim(gets);
			if(!Validform.util.isEmpty.call(obj,gets) && gets != ""){
				return true;
			}
			return false;
		},
		AccountNo:function(gets, obj, curform, regx){
			gets = $.trim(gets);
			if(gets != "" && gets.match(/^\d{18,}$/)){
				return true;
			}
			return false;
		},
		
		
		
		intRange:function(gets, obj, curform, regx){
			if(!/^[-\+]?\d+$/.test(obj.val())){
				return false;
			}else if(parseInt(obj.val()) < obj.attr("Min") || parseInt(obj.val()) > obj.attr("Max")){
				return false;
			}
			return true;
		},
		
		IsIdCard:function(gets, obj, curform, regx){
			number = gets.toLowerCase();
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
		
		vDate:function(gets, obj, curform, regx){
			if(!this.IsDate(gets, "ymd")) return false;
			return true;
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
		},
		
		isEmpty:function(val){
			return val==="" || val===$.trim(this.attr("tip"));
		},
		
		resetTip:function(type){
			$(this).attr("ignore","ignore").removeClass("Validform_error");//重设输入对象的样式
			if(!!$(this).data("tipObj"))$(this).data("tipObj").removeClass().addClass("Validform_checktip").html("");
//			//@fixed 以下代码可以删除
//			if(type==2){//重置提示信息
//				$(this).parent().next().find(".Validform_checktip").removeClass().addClass("Validform_checktip").html("");
//			}
//			if(type==3 || type==4){//重置提示信息
//				$(this).siblings(".Validform_checktip").removeClass().addClass("Validform_checktip").html("");
//			}
		},

		enhance:function(tiptype,usePlugin,tipSweep,addRule){
			var curform=this;
			var settings = $(this).data("settings");
			//页面上不存在提示信息的标签时，自动创建;
			var autoCreateTip = function(){
				var tipObj = $("<span class='Validform_checktip' />");
				tipObj.data("showRight",settings.showRight);
				if(tiptype==2){
					if($(this).parent().next().find(".Validform_checktip").length==0){
						tipObj.appendTo($(this).parent().next());
					}
				}else if(tiptype==3 || tiptype==4){
					if($(this).siblings(".Validform_checktip").length==0){
						tipObj.appendTo($(this).parent());
					}
				}
				if(!!$(this).attr("group")){
					$("[group='"+$(this).attr("group")+"']").data("tipObj",tipObj);
				}else{
					$(this).data("tipObj",tipObj);
				}
				return tipObj;
			}
			curform.find("[datatype]").each(function(){
				//判断是否需要标记必填项
				if(settings.mark && !$(this).attr("ignore"))$(this).addClass(settings.markCss);
				
				if(!addRule){
					autoCreateTip.call(this);
				}else if(addRule=="addRule"){
					if(!!$(this).attr("group") && $("[group='"+$(this).attr("group")+"']").index($(this))!=0){
						//如果是组验证，且索引不为0，则跳过（each中不能使用continue，break，需要return true，return false）
						return true;
					}
					if(!!$(this).attr("tipid")){//有tipid
						var newTipObj = $($(this).attr("tipid"));
						if(newTipObj.length==0){//指定的tip对象不存在
							$(this).removeAttr("tipid");
							var newTipObj = $(this).data("tipObj");
							if(!newTipObj)newTipObj = autoCreateTip.call(this);
						}else{//指定的tip对象存在
							if(!!$(this).attr("group")){
								$("[group='"+$(this).attr("group")+"']").data("tipObj",newTipObj);
							}else{
								$(this).data("tipObj",newTipObj);
							}
						}
						newTipObj.data("showRight",settings.showRight);
					}else{//无tipid
						var newTipObj = autoCreateTip.call(this);
						newTipObj.data("showRight",settings.showRight);
					}
				}
			})
			
			//表单元素值比较时的信息提示增强;
			curform.find("input[recheck]").each(function(){
				//已经绑定事件时跳过;
				if(this.validform_inited=="inited"){return true;}
				this.validform_inited="inited";
				
				var _this=$(this);
				var recheckinput=curform.find("input[name='"+$(this).attr("recheck")+"']");
				recheckinput.bind("keyup",function(){
					if(recheckinput.val()==_this.val() && recheckinput.val() != ""){
						if(recheckinput.attr("tip")){
							if(recheckinput.attr("tip") == recheckinput.val()){return false;}
						}
						_this.trigger("blur");
					}
				}).bind("blur",function(){
					if(recheckinput.val()!=_this.val() && _this.val()!=""){
						if(_this.attr("tip")){
							if(_this.attr("tip") == _this.val()){return false;}	
						}
						_this.trigger("blur");
					}
				});
			});
			
			//hasDefaultText;
			curform.find("[tip]").each(function(){//tip是表单元素的默认提示信息,这是点击清空效果;
				//已经绑定事件时跳过;
				if(this.validform_inited=="inited"){return true;}
				this.validform_inited="inited";
				
				var defaultvalue=$(this).attr("tip");
				var altercss=$(this).attr("altercss");
				$(this).focus(function(){
					if($(this).val()==defaultvalue){
						$(this).val('');
						if(altercss){$(this).removeClass(altercss);}
					}
				}).blur(function(){
					if($.trim($(this).val())===''){
						$(this).val(defaultvalue);
						if(altercss){$(this).addClass(altercss);}
					}
				});
			});
			
			//enhance info feedback for checkbox & radio;
			curform.find(":checkbox[datatype],:radio[datatype]").each(function(){
				//已经绑定事件时跳过;
				if(this.validform_inited=="inited"){return true;}
				this.validform_inited="inited";
				
				var _this=$(this);
				var name=_this.attr("name");
				curform.find("[name='"+name+"']").filter(":checkbox,:radio").bind("click",function(){
					//避免多个事件绑定时的取值滞后问题;
					setTimeout(function(){
						_this.trigger("blur");
					},0);
				});
				
			});
			
			//select multiple;
			curform.find("select[datatype][multiple]").bind("click",function(){
				var _this=$(this);
				setTimeout(function(){
					_this.trigger("blur");
				},0);
			});
			
			//plugins here to start;
			Validform.util.usePlugin.call(curform,usePlugin,tiptype,tipSweep,addRule);
		},
		
		usePlugin:function(plugin,tiptype,tipSweep,addRule){
			/*
				plugin:settings.usePlugin;
				tiptype:settings.tiptype;
				tipSweep:settings.tipSweep;
				n:当前表单的索引;
			*/
			
			var curform=this,
				plugin=plugin || {};
			//swfupload;
			if(curform.find("input[plugin='swfupload']").length && typeof(swfuploadhandler) != "undefined"){
				
				var custom={
						custom_settings:{
							form:curform,
							showmsg:function(msg,type,obj){
								Validform.util.showmsg.call(curform,msg,tiptype,{obj:curform.find("input[plugin='swfupload']"),type:type,sweep:tipSweep});	
							}	
						}	
					};

				custom=$.extend(true,{},plugin.swfupload,custom);
				
				curform.find("input[plugin='swfupload']").each(function(n){
					if(this.validform_inited=="inited"){return true;}
					this.validform_inited="inited";
					
					$(this).val("");
					swfuploadhandler.init(custom,n);
				});
				
			}
			
			//datepicker;
			if(curform.find("input[plugin='datepicker']").length && $.fn.datePicker){
				plugin.datepicker=plugin.datepicker || {};
				
				if(plugin.datepicker.format){
					Date.format=plugin.datepicker.format; 
					delete plugin.datepicker.format;
				}
				if(plugin.datepicker.firstDayOfWeek){
					Date.firstDayOfWeek=plugin.datepicker.firstDayOfWeek; 
					delete plugin.datepicker.firstDayOfWeek;
				}

				curform.find("input[plugin='datepicker']").each(function(n){
					if(this.validform_inited=="inited"){return true;}
					this.validform_inited="inited";
					
					plugin.datepicker.callback && $(this).bind("dateSelected",function(){
						var d=new Date( $.event._dpCache[this._dpId].getSelected()[0] ).asString(Date.format);
						plugin.datepicker.callback(d,this);
					});
					$(this).datePicker(plugin.datepicker);
				});
			}
			
			//passwordstrength;
			if(curform.find("input[plugin*='passwordStrength']").length && $.fn.passwordStrength){
				plugin.passwordstrength=plugin.passwordstrength || {};
				plugin.passwordstrength.showmsg=function(obj,msg,type){
					Validform.util.showmsg.call(curform,msg,tiptype,{obj:obj,type:type,sweep:tipSweep});
				};
				
				curform.find("input[plugin='passwordStrength']").each(function(n){
					if(this.validform_inited=="inited"){return true;}
					this.validform_inited="inited";
					
					$(this).passwordStrength(plugin.passwordstrength);
				});
			}
			
			//jqtransform;
			if(addRule!="addRule" && plugin.jqtransform && $.fn.jqTransSelect){
				var jqTransformHideSelect = function(oTarget){
					var ulVisible = $('.jqTransformSelectWrapper ul:visible');
					ulVisible.each(function(){
						var oSelect = $(this).parents(".jqTransformSelectWrapper:first").find("select").get(0);
						//do not hide if click on the label object associated to the select
						if( !(oTarget && oSelect.oLabel && oSelect.oLabel.get(0) == oTarget.get(0)) ){$(this).hide();}
					});
				};
				
				/* Check for an external click */
				var jqTransformCheckExternalClick = function(event) {
					if ($(event.target).parents('.jqTransformSelectWrapper').length === 0) { jqTransformHideSelect($(event.target)); }
				};
				
				var jqTransformAddDocumentListener = function (){
					$(document).mousedown(jqTransformCheckExternalClick);
				};
				
				if(plugin.jqtransform.selector){
					curform.find(plugin.jqtransform.selector).filter('input:submit, input:reset, input[type="button"]').jqTransInputButton();
					curform.find(plugin.jqtransform.selector).filter('input:text, input:password').jqTransInputText();			
					curform.find(plugin.jqtransform.selector).filter('input:checkbox').jqTransCheckBox();
					curform.find(plugin.jqtransform.selector).filter('input:radio').jqTransRadio();
					curform.find(plugin.jqtransform.selector).filter('textarea').jqTransTextarea();
					if(curform.find(plugin.jqtransform.selector).filter("select").length > 0 ){
						 curform.find(plugin.jqtransform.selector).filter("select").jqTransSelect();
						 jqTransformAddDocumentListener();
					}
					
				}else{
					curform.jqTransform();
				}
				
				curform.find(".jqTransformSelectWrapper").find("li a").click(function(){
					$(this).parents(".jqTransformSelectWrapper").find("select").trigger("blur");	
				});
			}

		},
		
		getNullmsg:function(curform){
			var obj=this;
			var reg=/[\u4E00-\u9FA5\uf900-\ufa2da-zA-Z\s]+/g;
			var nullmsg;
			
			var label=obj.siblings(".Validform_label").text() || obj.siblings().find(".Validform_label").text() || obj.parent().siblings(".Validform_label").text() ||  obj.parent().siblings().find(".Validform_label").text();
			label=label.match(reg);
			
			if(label){
				label=label[0].replace(/\s(?![a-zA-Z])/g,"");
				nullmsg=tipmsg.s_auto.replace(/\{0\}/,label);
				
				if(obj.attr("recheck")){
					nullmsg=nullmsg.replace(/\{(.+)\}/,"");
				}else{
					nullmsg=nullmsg.replace(/\{(.+)\}/,"$1");
				}
			}else{
				//@fixed 错误信息（当nullmsg没有指定时，显示errormsg）
				nullmsg=curform.data("tipmsg").s || obj.attr("errormsg") || tipmsg.s;
			}
			
			obj.attr("nullmsg",nullmsg);
			return nullmsg;
		},
		
		getErrormsg:function(curform,datatype,recheck){
			var obj=this;
			var regxp=/^(.+?)((\d+)-(\d+))?$/,
				regxp2=/^(.+?)(\d+)-(\d+)$/,
				regxp3=/(.*?)\d+(.+?)\d+(.*)/,
				mac=datatype.match(regxp),
				temp,str;
			
			//如果是值不一样而报错;
			if(recheck=="recheck"){
				str=curform.data("tipmsg").reck || tipmsg.reck;
				return str;
			}
			
			//如果原来就有，直接显示该项的提示信息;
			if(mac[0] in tipmsg.w){
				return curform.data("tipmsg").w[mac[0]] || tipmsg.w[mac[0]];
			}
			
			//没有的话在提示对象里查找相似;
			for(var name in tipmsg.w){
				if(name.indexOf(mac[1])!=-1 && regxp2.test(name)){
					str=(curform.data("tipmsg").w[name] || tipmsg.w[name]).replace(regxp3,"$1"+mac[3]+"$2"+mac[4]+"$3");
					tipmsg.w[mac[0]]=str;
					
					return str;
				}
				
			}
			
			return curform.data("tipmsg").def || tipmsg.def;
		},

		_regcheck:function(datatype,gets,obj,curform){
			var curform=curform,
				info=null,
				passed=false,
				reg=/\/.+\//g,
				regex=/^(.+?)(\d+)-(\d+)$/,
				type=3;//default set to wrong type, 2,3,4;
				
			//datatype有三种情况：正则，函数和直接绑定的正则;
			
			//直接是正则;
			if(reg.test(datatype)){
				var regstr=datatype.match(reg)[0].slice(1,-1);
				var param=datatype.replace(reg,"");
				var rexp=RegExp(regstr,param);

				passed=rexp.test(gets);

			//function;
			}else if(Validform.util.toString.call(Validform.util.dataType[datatype])=="[object Function]"){
				passed=Validform.util.dataType[datatype](gets,obj,curform,Validform.util.dataType);
				if(passed === true || passed===undef){
					passed = true;
				}else{
					info= passed;
					passed=false;
				}
			
			//自定义正则;	
			}else{
				//自动扩展datatype;
				if(!(datatype in Validform.util.dataType)){
					var mac=datatype.match(regex),
						temp;
						
					if(!mac){
						passed=false;
						info=curform.data("tipmsg").undef||tipmsg.undef;
					}else{
						for(var name in Validform.util.dataType){
							temp=name.match(regex);
							if(!temp){continue;}
							if(mac[1]===temp[1]){
								var str=Validform.util.dataType[name].toString(),
									param=str.match(/\/[mgi]*/g)[1].replace("\/",""),
									regxp=new RegExp("\\{"+temp[2]+","+temp[3]+"\\}","g");
								str=str.replace(/\/[mgi]*/g,"\/").replace(regxp,"{"+mac[2]+","+mac[3]+"}").replace(/^\//,"").replace(/\/$/,"");
								Validform.util.dataType[datatype]=new RegExp(str,param);
								break;
							}	
						}
					}
				}
				
				if(Validform.util.toString.call(Validform.util.dataType[datatype])=="[object RegExp]"){
					passed=Validform.util.dataType[datatype].test(gets);
				}
					
			}
			
			
			if(passed){
				type=2;
				info=obj.attr("sucmsg") || curform.data("tipmsg").r||tipmsg.r;
				
				//规则验证通过后，还需要对绑定recheck的对象进行值比较;
				if(obj.attr("recheck")){
					var theother=curform.find("input[name='"+obj.attr("recheck")+"']:first");
					if(gets!=theother.val()){
						passed=false;
						type=3;
						info=obj.attr("errormsg")  || Validform.util.getErrormsg.call(obj,curform,datatype,"recheck");
					}
				}
			}else{
				info=info || obj.attr("errormsg") || Validform.util.getErrormsg.call(obj,curform,datatype);
				
				//验证不通过且为空时;
				if(Validform.util.isEmpty.call(obj,gets)){
					info=obj.attr("nullmsg") || Validform.util.getNullmsg.call(obj,curform);
				}	
			}
			
			return{
					passed:passed,
					type:type,
					info:info
			};
			
		},
		
		regcheck:function(datatype,gets,obj){
			/*
				datatype:datatype;
				gets:inputvalue;
				obj:input object;
			*/
			var curform=this,
				info=null,
				passed=false,
				type=3;//default set to wrong type, 2,3,4;
				
			//ignore;
			if(obj.attr("ignore")==="ignore" && Validform.util.isEmpty.call(obj,gets)){				
				if(obj.data("cked")){
					info="";	
				}
				
				return {
					passed:true,
					type:4,
					info:info
				};
			}

			obj.data("cked","cked");//do nothing if is the first time validation triggered;
			
			var dtype=Validform.util.parseDatatype(datatype);
			var res;
			for(var eithor=0; eithor<dtype.length; eithor++){
				for(var dtp=0; dtp<dtype[eithor].length; dtp++){
					res=Validform.util._regcheck(dtype[eithor][dtp],gets,obj,curform);
					if(!res.passed){
						break;
					}
				}
				if(res.passed){
					break;
				}
			}
			return res;
			
		},
		
		parseDatatype:function(datatype){
			/*
				字符串里面只能含有一个正则表达式;
				Datatype名称必须是字母，数字、下划线或*号组成;
				datatype="/regexp/|phone|tel,s,e|f,e";
				==>[["/regexp/"],["phone"],["tel","s","e"],["f","e"]];
			*/

			var reg=/\/.+?\/[mgi]*(?=(,|$|\||\s))|[\w\*-]+/g,
				dtype=datatype.match(reg),
				sepor=datatype.replace(reg,"").replace(/\s*/g,"").split(""),
				arr=[],
				m=0;
				
			arr[0]=[];
			arr[0].push(dtype[0]);
			for(var n=0;n<sepor.length;n++){
				if(sepor[n]=="|"){
					m++;
					arr[m]=[];
				}
				arr[m].push(dtype[n+1]);
			}
			
			return arr;
		},

		showmsg:function(msg,type,o,triggered){
			/*
				msg:提示文字;
				type:提示信息显示方式;
				o:{obj:当前对象, type:1=>正在检测 | 2=>通过, sweep:true | false}, 
				triggered:在blur或提交表单触发的验证中，有些情况不需要显示提示文字，如自定义弹出提示框的显示方式，不需要每次blur时就马上弹出提示;
				
				tiptype:1\2\3时都有坑能会弹出自定义提示框
				tiptype:1时在triggered bycheck时不弹框
				tiptype:2\3时在ajax时弹框
				tipSweep为true时在triggered bycheck时不触发showmsg，但ajax出错的情况下要提示
			*/
			
			//如果msg为undefined，那么就没必要执行后面的操作，ignore有可能会出现这情况;
			if(msg==undef){return;}
			
			//tipSweep为true，且当前不是处于错误状态时，blur事件不触发信息显示;
			if(triggered=="bycheck" && o.sweep && o.obj && !o.obj.is(".Validform_error")){return;}

			$.extend(o,{curform:this});
				
			if(typeof type == "function"){
				type(msg,o,Validform.util.cssctl);
				return;
			}
			
			if(type==1 || triggered=="byajax" && type!=4){
				msgobj.find(".Validform_info").html(msg);
			}
			
			//tiptypt=1时，blur触发showmsg，验证是否通过都不弹框，提交表单触发的话，只要验证出错，就弹框;
			if(type==1 && triggered!="bycheck" && o.type!=2 || triggered=="byajax" && type!=4){
				msghidden=false;
				msgobj.find(".iframe").css("height",msgobj.outerHeight());
				msgobj.show();
				setCenter(msgobj,100);
			}

			if((type==2 || type==3 || type==4) && o.obj){
				var tipObj = $(o.obj).data("tipObj");
				tipObj.html(msg);
				Validform.util.cssctl(tipObj,o.type);
			}

		},

		cssctl:function(obj,status){
			switch(status){
				case 1:
					obj.removeClass("Validform_right Validform_wrong").addClass("Validform_checktip Validform_loading");//checking;
					break;
				case 2:
					var showRight = obj.data("showRight");
					if(showRight){
						obj.removeClass("Validform_wrong Validform_loading").addClass("Validform_checktip Validform_right");//passed;
					}else{
						obj.removeClass("Validform_wrong Validform_loading").addClass("Validform_checktip").html("");
					}
					break;
				case 4:
					obj.removeClass("Validform_right Validform_wrong Validform_loading").addClass("Validform_checktip");//for ignore;
					break;
				default:
					obj.removeClass("Validform_right Validform_loading").addClass("Validform_checktip Validform_wrong");//wrong;
			}
		},
		
		getQuery:function(url,get){
			//get方式传递数据时不做处理;
			
			var queryindex=url.indexOf("?");
			if(queryindex!=-1 && !get){
				return {
					query:url.substring(queryindex+1)+"&",
					url:url.substring(0,queryindex)	
				};
			}else{
				return {
					query:"",
					url:url
				};
			}
		},
		//@fixed 新添加方法
		checkGroup:function(curform,brothers,subpost,bool){
			var $currObj = $(this);
			var triggertype = $(this).data("triggertype");
			var group = curform.find("[group='"+$currObj.attr("group")+"']");
			if(group.length==0)return true;
			if(triggertype=="blur" && !!$(this).attr("lazy"))return true;
			
			var settings=brothers.settings;
			var subpost=subpost || "";
			var rtnBool = true;
//			在each代码块内不能使用break和continue,要实现break和continue的功能的话，
//			要使用其它的方式: break-用return false;continue-用return ture; 
			$(group).each(function(){
				//如果是blur触发的验证，不验证组中其它元素
				if(triggertype=="blur"&&$(this)[0]!=$currObj[0]){return true;}
				var inputval=Validform.util.getValue.call(curform,$(this));
				var isEmpty = Validform.util.isEmpty.call($(this),inputval);
				//隐藏或绑定ignore的表单对象不做验证;
				if(settings.ignoreHidden && $(this).is(":hidden") || ($(this).attr("ignore")==="ignore" && isEmpty)){
					if(rtnBool && $(this).attr("ignore")==="ignore" && inputval!=this.validform_lastval){
						Validform.util.resetTip.call(this,settings.tiptype);
					}
					rtnBool = rtnBool && true; 
					return true;
				}
			
				//dragonfly=true时，没有绑定ignore，值为空不做验证，但验证不通过;
				if(settings.dragonfly && !$(this).data("cked") && isEmpty && $(this).attr("ignore")!="ignore"){
					rtnBool = rtnBool && false; 
					return true;
				}
				
				var flag=Validform.util.regcheck.call(curform,$(this).attr("datatype"),inputval,$(this));
				this.validform_lastval=inputval;//存储当前值;
				
				var _this;
				errorobj=_this=$(this);
	
				if(!flag.passed){
					//取消正在进行的ajax验证;
					Validform.util.abort.call(_this[0]);
					if(!bool){
						var group = curform.find("[group='"+$(this).attr("group")+"']");
						if(rtnBool){
							//传入"bycheck"，指示当前是check方法里调用的，当tiptype=1时，blur事件不让触发错误信息显示;
							Validform.util.showmsg.call(curform,flag.info,settings.tiptype,{obj:$(this),type:flag.type,sweep:settings.tipSweep},"bycheck");
						}
						if(!$(this).hasClass("Validform_checkedgroup"))$(this).addClass("Validform_checkedgroup");
						!settings.tipSweep && _this.addClass("Validform_error");
					}
					rtnBool = rtnBool && false; 
					return true;
				}
				
				if(!bool){//bool为true时则只验证不显示提示信息
					var group = curform.find("[group='"+_this.attr("group")+"'][class*='Validform_checkedgroup']");
					if(group.length!=0){
						_this.removeClass("Validform_error Validform_checkedgroup");
						rtnBool = rtnBool && false; 
						return true;
					}
					Validform.util.showmsg.call(curform,flag.info,settings.tiptype,{obj:$(this),type:flag.type,sweep:settings.tipSweep},"bycheck");
				}
				_this.removeClass("Validform_error");
				errorobj=null;
			});//each end
			return rtnBool;
		},
		check:function(curform,brothers,subpost,bool){
			if(!!$(this).attr("group")){//包含group属性
				curform.find("[group='"+$(this).attr("group")+"'][class*='Validform_checkedgroup']").removeClass("Validform_checkedgroup");
			  	return Validform.util.checkGroup.call(this,curform,brothers,subpost,bool);
			}
			/*
				检测单个表单元素;
				验证通过返回true，否则返回false、实时验证返回值为ajax;
				bool，传入true则只检测不显示提示信息;
			*/
			var settings=brothers.settings;
			var subpost=subpost || "";
			var inputval=Validform.util.getValue.call(curform,$(this));
			var isEmpty = Validform.util.isEmpty.call($(this),inputval); 
			//隐藏或绑定ignore的表单对象不做验证;
			var triggertype = $(this).data("triggertype");
			if(triggertype=="blur" && !!$(this).attr("lazy"))return true;
			if(settings.ignoreHidden && $(this).is(":hidden") || ($(this).attr("ignore")==="ignore" && isEmpty)){
				if($(this).attr("ignore")==="ignore" && inputval!=this.validform_lastval){
					Validform.util.resetTip.call(this,settings.tiptype);
				}
				return true;
			}
		
			//dragonfly=true时，没有绑定ignore，值为空不做验证，但验证不通过;
			if(settings.dragonfly && !$(this).data("cked") && isEmpty && $(this).attr("ignore")!="ignore"){
				return false;
			}
			
			var flag=Validform.util.regcheck.call(curform,$(this).attr("datatype"),inputval,$(this));
			
			//值没变化不做检测，这时要考虑recheck情况;
			//不是在提交表单时触发的ajax验证;
			if(inputval==this.validform_lastval && !$(this).attr("recheck") && subpost==""){
				return flag.passed ? true : false;
			}

			this.validform_lastval=inputval;//存储当前值;
			
			var _this;
			errorobj=_this=$(this);

			if(!flag.passed){
				//取消正在进行的ajax验证;
				Validform.util.abort.call(_this[0]);
				
				if(!bool){
					//传入"bycheck"，指示当前是check方法里调用的，当tiptype=1时，blur事件不让触发错误信息显示;
					Validform.util.showmsg.call(curform,flag.info,settings.tiptype,{obj:$(this),type:flag.type,sweep:settings.tipSweep},"bycheck");

					!settings.tipSweep && _this.addClass("Validform_error");
				}
				return false;
			}
			
			//验证通过的话，如果绑定有ajaxurl，要执行ajax检测;
			//当ignore="ignore"时，为空值可以通过验证，这时不需要ajax检测;
			if($(this).attr("ajaxurl") && !Validform.util.isEmpty.call($(this),inputval) && !bool){
				var inputobj=$(this);

				//当提交表单时，表单中的某项已经在执行ajax检测，这时需要让该项ajax结束后继续提交表单;
				if(subpost=="postform"){
					inputobj[0].validform_subpost="postform";
				}else{
					inputobj[0].validform_subpost="";
				}
				
				if(inputobj[0].validform_valid==="posting" && inputval==inputobj[0].validform_ckvalue){return "ajax";}
				
				inputobj[0].validform_valid="posting";
				inputobj[0].validform_ckvalue=inputval;
				Validform.util.showmsg.call(curform,brothers.tipmsg.c||tipmsg.c,settings.tiptype,{obj:inputobj,type:1,sweep:settings.tipSweep},"bycheck");
				
				Validform.util.abort.call(_this[0]);
				
				var ajaxsetup=curform[0].validform_config || {};
				ajaxsetup=ajaxsetup.ajaxurl || {};
				
				var ajaxurl=Validform.util.getQuery.call(win,inputobj.attr("ajaxurl"),/get/i.test(ajaxsetup.type));
				
				var localconfig={
					type: "POST",
					cache:false,
					url: ajaxurl.url,
					data: ajaxurl.query+"param="+encodeURIComponent(inputval)+"&name="+encodeURIComponent($(this).attr("name")),
					success: function(data){
						if(data.status==="y"){
							inputobj[0].validform_valid="true";
							data.info && inputobj.attr("sucmsg",data.info);
							Validform.util.showmsg.call(curform,inputobj.attr("sucmsg") || brothers.tipmsg.r||tipmsg.r,settings.tiptype,{obj:inputobj,type:2,sweep:settings.tipSweep},"bycheck");
							_this.removeClass("Validform_error");
							errorobj=null;
							if(inputobj[0].validform_subpost=="postform"){
								curform.trigger("submit");
							}
						}else{
							inputobj[0].validform_valid=data.info;
							Validform.util.showmsg.call(curform,data.info,settings.tiptype,{obj:inputobj,type:3,sweep:settings.tipSweep});
							_this.addClass("Validform_error");
						}
						_this[0].validform_ajax=null;
					},
					error: function(data){
						if(data.statusText=="parsererror"){
							if(data.responseText=="y"){
								ajaxsetup.success({"status":"y"});
							}else{
								ajaxsetup.success({"status":"n","info":data.responseText});	
							}
							return false;
						}
						
						//正在检测时，要检测的数据发生改变，这时要终止当前的ajax。不是这种情况引起的ajax错误，那么显示相关错误信息;
						if(data.statusText!=="abort"){
							var msg="status: "+data.status+"; statusText: "+data.statusText;
						
							Validform.util.showmsg.call(curform,msg,settings.tiptype,{obj:inputobj,type:3,sweep:settings.tipSweep});
							_this.addClass("Validform_error");
						}
						
						inputobj[0].validform_valid=data.statusText;
						_this[0].validform_ajax=null;
						
						//localconfig.error返回true表示还需要执行temp_err;
						return true;
					}
				}
				
				if(ajaxsetup.success){
					var temp_suc=ajaxsetup.success;
					ajaxsetup.success=function(data){
						localconfig.success(data);
						temp_suc(data,inputobj);
					}
				}
				
				if(ajaxsetup.error){
					var temp_err=ajaxsetup.error;
					ajaxsetup.error=function(data){
						//localconfig.error返回false表示不需要执行temp_err;
						localconfig.error(data) && temp_err(data,inputobj);
					}	
				}

				ajaxsetup=$.extend({},localconfig,ajaxsetup,{dataType:"json"});
				_this[0].validform_ajax=$.ajax(ajaxsetup);
				
				return "ajax";
			}else if($(this).attr("ajaxurl") && Validform.util.isEmpty.call($(this),inputval)){
				Validform.util.abort.call(_this[0]);
				_this[0].validform_valid="true";
			}
			
			if(!bool){
				Validform.util.showmsg.call(curform,flag.info,settings.tiptype,{obj:$(this),type:flag.type,sweep:settings.tipSweep},"bycheck");
				_this.removeClass("Validform_error");
			}
			errorobj=null;
			
			return true;
		
		},
		
		submitForm:function(settings,flg,url,ajaxPost,sync){
			/*
				flg===true时跳过验证直接提交;
				ajaxPost==="ajaxPost"指示当前表单以ajax方式提交;
			*/
			var curform=this;
			
			//表单正在提交时点击提交按钮不做反应;
			if(curform[0].validform_status==="posting"){return false;}
			
			//要求只能提交一次时;
			if(settings.postonce && curform[0].validform_status==="posted"){return false;}
			
			var beforeCheck=settings.beforeCheck && settings.beforeCheck(curform);
			if(beforeCheck===false){return false;}
			
			var flag=true,
				inflag;
				
			curform.find("[datatype]").each(function(){
				//跳过验证;
				if(flg){
					return false;
				}
				
				//隐藏或绑定dataIgnore的表单对象不做验证;
				if(settings.ignoreHidden && $(this).is(":hidden") || $(this).attr("ignore")==="ignore"){
					return true;
				}
				
				var inputval=Validform.util.getValue.call(curform,$(this)),
					_this;
				errorobj=_this=$(this);
				
				inflag=Validform.util.regcheck.call(curform,$(this).attr("datatype"),inputval,$(this));

				if(!inflag.passed){
					Validform.util.showmsg.call(curform,inflag.info,settings.tiptype,{obj:$(this),type:inflag.type,sweep:settings.tipSweep});
					_this.addClass("Validform_error");
					
					if(!settings.showAllError){
						_this.focus();
						flag=false;
						return false;
					}
					
					flag && (flag=false);
					return true;
				}
				
				//当ignore="ignore"时，为空值可以通过验证，这时不需要ajax检测;
				if($(this).attr("ajaxurl") && !Validform.util.isEmpty.call($(this),inputval)){
					if(this.validform_valid!=="true"){
						var thisobj=$(this);
						Validform.util.showmsg.call(curform,curform.data("tipmsg").v||tipmsg.v,settings.tiptype,{obj:thisobj,type:3,sweep:settings.tipSweep});
						_this.addClass("Validform_error");
						
						setTimeout(function(){
							thisobj.trigger("blur",["postform"]);//continue the form post;
						},1500);
						
						if(!settings.showAllError){
							flag=false;
							return false;
						}
						
						flag && (flag=false);
						return true;
					}
				}else if($(this).attr("ajaxurl") && Validform.util.isEmpty.call($(this),inputval)){
					Validform.util.abort.call(this);
					this.validform_valid="true";
				}

				Validform.util.showmsg.call(curform,inflag.info,settings.tiptype,{obj:$(this),type:inflag.type,sweep:settings.tipSweep});
				_this.removeClass("Validform_error");
				errorobj=null;
			});
			
			if(settings.showAllError){
				curform.find(".Validform_error:first").focus();
			}

			if(flag){
				
				var beforeSubmit=settings.beforeSubmit && settings.beforeSubmit(curform);
				if(beforeSubmit===false){return false;}
				
				curform[0].validform_status="posting";
				
				var config=curform[0].validform_config || {}
				
				if(settings.ajaxPost || ajaxPost==="ajaxPost"){
					//获取配置参数;
					var ajaxsetup=config.ajaxpost || {};
					//有可能需要动态的改变提交地址，所以把action所指定的url层级设为最低;
					ajaxsetup.url=url || ajaxsetup.url || config.url || curform.attr("action");
					
					//byajax：ajax时，tiptye为1、2或3需要弹出提示框;
					//如果setup里已经自定义了success或error方法，这里不显示提示信息;
					ajaxsetup.success || ajaxsetup.error || Validform.util.showmsg.call(curform,curform.data("tipmsg").p||tipmsg.p,settings.tiptype,{obj:curform,type:1,sweep:settings.tipSweep},"byajax");

					//方法里的优先级要高;
					//有undefined情况;
					if(sync){
						ajaxsetup.async=false;
					}else if(sync===false){
						ajaxsetup.async=true;
					}
					
					if(ajaxsetup.success){
						var temp_suc=ajaxsetup.success;
						ajaxsetup.success=function(data){
							settings.callback && settings.callback(data);
							curform[0].validform_ajax=null;
							if(data.status==="y"){
								curform[0].validform_status="posted";
							}else{
								curform[0].validform_status="normal";
							}
							
							temp_suc(data,curform);
						}
					}
					
					if(ajaxsetup.error){
						var temp_err=ajaxsetup.error;
						ajaxsetup.error=function(data){
							settings.callback && settings.callback(data);
							curform[0].validform_status="normal";
							curform[0].validform_ajax=null;
							
							temp_err(data,curform);
						}	
					}
					
					var localconfig={
						type: "POST",
						async:true,
						data: curform.serializeArray(),
						success: function(data){
							if(data.status==="y"){
								//成功提交;
								curform[0].validform_status="posted";
								Validform.util.showmsg.call(curform,data.info,settings.tiptype,{obj:curform,type:2,sweep:settings.tipSweep},"byajax");
							}else{
								//提交出错;
								curform[0].validform_status="normal";
								Validform.util.showmsg.call(curform,data.info,settings.tiptype,{obj:curform,type:3,sweep:settings.tipSweep},"byajax");
							}
							
							settings.callback && settings.callback(data);
							curform[0].validform_ajax=null;
						},
						error: function(data){
							var msg="status: "+data.status+"; statusText: "+data.statusText;
									
							Validform.util.showmsg.call(curform,msg,settings.tiptype,{obj:curform,type:3,sweep:settings.tipSweep},"byajax");
							
							settings.callback && settings.callback(data);
							curform[0].validform_status="normal";
							curform[0].validform_ajax=null;
						}
					}
					
					ajaxsetup=$.extend({},localconfig,ajaxsetup,{dataType:"json"});
					
					curform[0].validform_ajax=$.ajax(ajaxsetup);

				}else{
					if(!settings.postonce){
						curform[0].validform_status="normal";
					}
					
					var url=url || config.url;
					if(url){
						curform.attr("action",url);
					}
					
					return settings.callback && settings.callback(curform);
				}
			}
			
			return false;
			
		},
		
		resetForm:function(){
			var brothers=this;
			brothers.each(function(){
				this.reset();
				this.validform_status="normal";
			});
			
			brothers.find(".Validform_right").text("");//@fixed 重置表单时设置tip
			brothers.find(".passwordStrength").children().removeClass("bgStrength");
			brothers.find(".Validform_checktip").removeClass("Validform_wrong Validform_right Validform_loading");
			brothers.find(".Validform_error").removeClass("Validform_error");
			brothers.find("[datatype]").removeData("cked");
			brothers.eq(0).find("input:first").focus();
		},
		
		abort:function(){
			if(this.validform_ajax){
				this.validform_ajax.abort();	
			}
		}
		
	}
	
	$.Datatype=Validform.util.dataType;
	
	Validform.prototype={
		dataType:Validform.util.dataType,
		
		eq:function(n){
			var obj=this;
			
			if(n>=obj.forms.length){
				return null;	
			}
			
			if(!(n in obj.objects)){
				obj.objects[n]=new Validform($(obj.forms[n]).get(),obj.settings,true);
			}
			
			return obj.objects[n];

		},
		
		resetStatus:function(){
			var obj=this;
			$(obj.forms).each(function(){
				this.validform_status="normal";	
			});
			
			return this;
		},
		
		setStatus:function(status){
			var obj=this;
			$(obj.forms).each(function(){
				this.validform_status=status || "posting";	
			});
			
			return this;
		},
		
		getStatus:function(){
			var obj=this;
			var status=$(obj.forms)[0].validform_status;
			
			return status;
		},
		
		ignore:function(selector){//@fixed 重置验证tip
			var obj=this,
				type=obj.settings.tiptype,
				curform=$(obj.forms),
				selector=selector || "[datatype]"
			
			$(obj.forms).find(selector).each(function(){
				var o = $(this);
				$(this).attr("ignore","ignore").removeClass("Validform_error");//重设输入对象的样式
				Validform.util.resetTip.call(o,type);
				if(obj.settings.mark)$(this).removeClass(obj.settings.markCss);
			});
			return this;
		},
		
		unignore:function(selector){
			var obj=this;
			var selector=selector || "[datatype]"
			
			$(obj.forms).find(selector).each(function(){
				$(this).removeAttr("ignore");
				this.validform_lastval = undefined;//@fixed 设置当前对象的最后验证值。（此处设置为undefined，可以避免与表单元素的值""相等，从而保证blur触发验证）
				if(obj.settings.mark)$(this).addClass(obj.settings.markCss);
			});
			return this;
		},
		
		addRule:function(rule){
			/*
				rule => [{
					ele:"#id",
					datatype:"*",
					errormsg:"出错提示文字！",
					nullmsg:"为空时的提示文字！",
					tip:"默认显示的提示文字",
					altercss:"gray",
					ignore:"ignore",
					ajaxurl:"valid.php",
					recheck:"password",
					plugin:"passwordStrength"
				},{},{},...]
			*/
			var obj=this;
			var rule=rule || [];
			
			for(var index=0; index<rule.length; index++){
				var o=$(obj.forms).find(rule[index].ele);
				for(var attr in rule[index]){
					attr !=="ele" && o.attr(attr,rule[index][attr]);
				}
			}
			
			$(obj.forms).each(function(){
				var $this=$(this);
				Validform.util.enhance.call($this,obj.settings.tiptype,obj.settings.usePlugin,obj.settings.tipSweep,"addRule");
			});
			
			return this;
		},
		
		ajaxPost:function(flag,sync,url){
			var obj=this;
			
			//创建pop box;
			if( obj.settings.tiptype==1 || obj.settings.tiptype==2 || obj.settings.tiptype==3 ){
				creatMsgbox();
			}
			
			Validform.util.submitForm.call($(obj.forms[0]),obj.settings,flag,url,"ajaxPost",sync);
			
			return this;
		},
		
		submitForm:function(flag,url){
			/*flag===true时不做验证直接提交*/
			
			var obj=this;
			
			//让该对象的第一个表单提交;
			var subflag=Validform.util.submitForm.call($(obj.forms[0]),obj.settings,flag,url);
			subflag === undef && (subflag=true);
			if(subflag===true){
				obj.forms[0].submit();
			}
			
			return this;
		},
		
		resetForm:function(){
			var obj=this;
			Validform.util.resetForm.call($(obj.forms));
			
			return this;
		},
		
		abort:function(){
			var obj=this;
			$(obj.forms).each(function(){
				Validform.util.abort.call(this);
			});
			
			return this;
		},
		
		check:function(bool,selector){
			/*
				bool：传入true，只检测不显示提示信息;
			*/
			var scrollFlag = !selector;//未传入selector，说明是保存触发
			var selector=selector || "[datatype]",
				obj=this,
				curform=$(obj.forms),
				flag=true;
			curform.find(selector).each(function(){
				$(this).data("triggertype","check");
				Validform.util.check.call(this,curform,obj,"",bool) || (flag=false);
			});
			var firstErrObj = curform.find("[class*='Validform_error']:first");
			if(scrollFlag && $.inArray(selector,["#BUILD_ID_TEXT","#SALE_REGION_TEXT","#SALE_ROUND_TEXT"])==-1 && firstErrObj.length>0){
				$("html").scrollTop(firstErrObj.offset().top-50);
				firstErrObj.select().focus();
			}
			return flag;
		},
		
		config:function(setup){
		/*
			config={
				url:"ajaxpost.php",//指定了url后，数据会提交到这个地址;
				ajaxurl:{
					timeout:1000,
					...
				},
				ajaxpost:{
					timeout:1000,
					...
				}
			}
		*/
			var obj=this;
			setup=setup || {};
			$(obj.forms).each(function(){
				this.validform_config=$.extend(true,this.validform_config,setup);
			});
			
			return this;
		}
	}

	$.fn.Validform=function(settings){
		return new Validform(this,settings);
	};
	
	$.fn.ignore=function(){
		var objs=this,
			curform=getP(objs[0],"form"),
			settings=curform.data("settings"),
			type=settings.tiptype;
		$(objs).each(function(){
			var o = $(this);
			$(this).attr("ignore","ignore").removeClass("Validform_error");//重设输入对象的样式
			Validform.util.resetTip.call(o,type);
			if(settings.mark)$(this).removeClass(settings.markCss);
		});
		return this;
	};
	$.fn.unignore=function(){
		var objs=this,
			curform=getP(objs[0],"form"),
			settings=curform.data("settings"),
			type=settings.tiptype;
		
		$(objs).each(function(){
			$(this).removeAttr("ignore");
			this.validform_lastval = undefined;//@fixed 设置当前对象的最后验证值。（此处设置为undefined，可以避免与表单元素的值""相等，从而保证blur触发验证）
			if(settings.mark)$(this).addClass(settings.markCss);
		});
		return this;
	};
	
	function getP(obj,pTag){
		var $obj = $(obj);
		if($obj.is(pTag)){
			return $obj;
		}	
		return getP($obj.parent(),pTag);
	}
	
	function setCenter(obj,time){
		var left=($(window).width()-obj.outerWidth())/2,
			top=($(window).height()-obj.outerHeight())/2,
			
		top=(document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop)+(top>0?top:0);

		obj.css({
			left:left
		}).animate({
			top : top
		},{ duration:time , queue:false });
	}
	
	function creatMsgbox(){
		if($("#Validform_msg").length!==0){return false;}
		msgobj=$('<div id="Validform_msg"><div class="Validform_title">'+tipmsg.tit+'<a class="Validform_close" href="javascript:void(0);">&chi;</a></div><div class="Validform_info"></div><div class="iframe"><iframe frameborder="0" scrolling="no" height="100%" width="100%"></iframe></div></div>').appendTo("body");//提示信息框;
		msgobj.find("a.Validform_close").click(function(){
			msgobj.hide();
			msghidden=true;
			if(errorobj){
				errorobj.focus().addClass("Validform_error");
			}
			return false;
		}).focus(function(){this.blur();});

		$(window).bind("scroll resize",function(){
			!msghidden && setCenter(msgobj,400);
		});
	};
	
	//公用方法显示&关闭信息提示框;
	$.Showmsg=function(msg){
		creatMsgbox();
		Validform.util.showmsg.call(win,msg,1,{});
	};
	
	$.Hidemsg=function(){
		msgobj.hide();
		msghidden=true;
	};
	
})(jQuery,window);