/*!
 * 手机认证
 * Author: Allen
 * Date: 20130221
 */
var MobileValid ={
	step:1,
	title:'',
	isError:false,
	verifyWay:1,
	chkmobileTimer:null,
	timeout:null,
	oButton:null,
	archiveId:"",
	userId:"",
	second:0,
	lock:false,
	style:'\
		#rapid_pay{padding: 15px; height:220px;}\
		#rapid_pay #srv_type{font-size: 12px;margin: 0;padding:0;font-family: Tahoma,Geneva,sans-serif}\
		#rapid_title{font-size: 14px;color: #B42319;font-family: 宋体;\
			background: none;line-height: 24px;height: 30px; }\
		#rapid_pay label{vertical-align:middle;line-height:12px; padding:5px 0}\
		#rapid_pay .item{height: 30px;line-height: 30px}\
		b{font-weight:normal}\
		.p{color:#ff6600}\
		.rp_bottom{font-size:12px;background:#f6f6f6;border-top:1px solid #dedede;height:35px;line-height:35px;\
			position:absolute;bottom:0px;\
			left:0;text-align: left;width: 100%;vertical-align: bottom}\
		.rp_bottom .rp_btn,.rp_bottom .rp_btn2{background:url("/hftWebService/fafunv2/images/site_setting.png") no-repeat -27px -115px;\
			width:73px;height:24px;line-height:24px;display:inline-block;text-align:center;\
			color:#426da2;cursor:pointer;margin-left:6px}\
		.rp_bottom .rp_btn2{background:url(/hftWebService/fafunv2/images/site_setting.png) no-repeat -27px -89px}\
		.rp_bottom img{position:relative;top:2px;visibility: hidden}\
		#pay_way,#pay_fail,#pay_rst{display:none}\
		#pay_way b,#pay_way label{color:black}\
		#pay_way li label{cursor: pointer}\
		#pay_rst ul,#pay_fail ul{margin:10px auto auto 15px}\
		#pay_rst li{list-style: square outside;color: #646464;width:auto}\
		#pay_tip{height:24px;width:100%;line-height:24px;text-align:center;padding:0 5px;\
			position:absolute;bottom:40px;left:0px;background:#cecece;display:none}\
		#pay_fail li{height:auto;width:auto;list-style: square outside;line-height: 18px;}\
		#pay_fail strong{color:#646464}\
		.i-text{border:1px solid #7f9dB9; height:20px;line-height:20px;font-size:14px;color:#3d3d3d;font-family:"Tahoma";}\
		.i-text:hover {border-color:#3eabff;-moz-box-shadow:1px 1px 1px #d8eaf8;-webkit-box-shadow:1px 1px 1px #d8eaf8;box-shadow:1px 1px 1px #d8eaf8;}\
		#mobile{width:150px;height:20px;padding:2px 5px;font-size:14px;font-weight:bold;font-family:"Lucida Grande",Verdana,Lucida,Arial,Helvetica,"宋体",sans-serif}\
		#chgMobileBtn{color:#0099FF;text-decoration:none}\
		#chgMobileBtn:hover{text-decoration:underline}\
		.fm{margin: 0px;font-size:12px}\
		.fm .message{margin:0px;margin-bottom: 10px; background: url("/hftWebService/system/images/warn.png") no-repeat;line-height: 15px;color: #4d4d4d;padding-left:15px;text-align: left;}\
		.fm .fm-item{color: #4d4d4d;padding-left: 10px;text-align: left;}\
		.fm .fm-item label{width: 70px;text-align: right;font-size: 13px;float: left;padding-top: 4px;}\
		.fm .fm-item .required{font-size: 13px;color: #f00;margin-right: 6px;font-family: SimSun}\
		.fm .fm-item .fm-explain {padding:5px 0px 0px 0px;font-size: 12px;margin: -1px 0px 0px 3px;color: #b2b2b2;}\
		.fm .fm-item .error_msg{margin: -1px 0px 0px 3px;background: url("/hftWebService/system/images/error.png") no-repeat;line-height: 15px;font:12px/15px Tahoma,Helvetica,Arial,Simsun,sans-serif;color: red;padding-left:20px;}\
		.attention{color:#2693FF;font:12px/normal Tahoma,Helvetica,Arial,Simsun,sans-serif;padding:5px;height:15px;width: 320px;}\
		#verify_way{padding:0 15px;margin: 5px;overflow:hidden;border-bottom:1px solid #FF9D26;}\
		#verify_way ul{list-style:none;margin:0;padding:0}\
		#verify_way li{float:left;padding:4px;font-size: 12px;color: gray;width:115px;text-align:center;background:#eee;border:1px solid #eee;-moz-border-radius:4px 0 0 0;-webkit-border-radius:4px 0 0 0;border-radius:4px 0 0 0;cursor:pointer;}\
		#verify_way li.curr{font-weight: bold;color: #fff;background:#FF9D26;border:1px solid #FF9D26;}\
		.smsbtn{border:1px solid #ccc;background:#F2F2F2;color:#333;padding:3px;cursor:pointer;}\
		.smsbtn:hover{border:1px solid #FF850F;background:#FFAD38;color:#fff;}\
		.disabled,.disabled:hover{border:1px solid #bbb;background:#ccc;color:#fff}\
		',
	html:'\
		<div id="rapid_pay">\
			<span id="rapid_title">#msg#</span>\
			<hr size="1" color="#e8e8e8"/>\
			<div id="srv_type">\
				<p class="checkreapet" style="margin-top:10px">请填写您要认证的手机号码，本条免费。</p>\
				<div class="srv_type item">\
					<label>手机号码：</label>\
					<input class="i-text mobile_txt" id="mobile" maxlength="11" name="mobile" value=""/>\
					<div style="color:gray" id="mobile_msg"></div>\
				</div>\
				<div class="srv_type item">\
					<div class="attention" id="mobile_info" style="color:red;display:none;">&nbsp;</div>\
				</div>\
			</div>\
			<div id="mobileValid" class="fm" style="display:none">\
				<div style="padding:8px 0 10px"><span>您要认证的手机号码：</span><span id="show_mobile" style="margin-right: 10px;font-size: 14px;font-weight: bold;color:#FF6622">***********</span><a id="chgMobileBtn" href="javascript:void(0);">更改号码</a></div>\
				<div id="verify_way">\
					<ul>\
						<li id="verify_dail" class="curr">拨打认证(推荐)</li>\
						<li id="verify_sms">短信认证</li>\
					</ul>\
				</div>\
				<div id="vway_dail" class="fm-item" style="padding: 0 0 0 5px">\
					<div class="attention" style="margin-top:17px;font-size: 13px;line-height:24px;">1. 请使用你填写的手机号码拨打 <font style="font-weight: bold; font-size: 14px; color: red">15608006097</font><br/>2. 系统将自动挂断绝不会产生通话费用<br/>3. 挂机后请等待3秒或点击确定完成认证</div>\
					<div id="dail_msg" style="margin-top: 10px">&nbsp;</div>\
				</div>\
				<div id="vway_sms1" class="fm-item" style="margin-top:20px;display: none; line-height:18px;">\
					<span><span class="required">*</span>校验码：</span>\
					<input class="i-text" id="key" maxlength="6" name="key" style="width:60px"/>\
					<span class="fm-explain" id="err_msg" style="">校验码是6位数字。</span>\
				</div>\
				<div id="vway_sms2" class="item" style="display: none; padding-left:10px;line-height:26px;">\
					<span style="font-size: 12px;">如果您#intervalFromSamePH#秒内没有收到校验码，请&nbsp;&nbsp;</span><input id="sms-validate" class="smsbtn" type="button" value="获取短信校验码" />\
					<div class=attention id="SEND_SAMEIP" style="display:none">1天内最多可以发送#canSendFromSameIP#次校验码，已发送<span id="resend-count-IP" style="color:red;">0</span>次。</div>\
					<div class=attention id="SEND_SAMEPH" style="display:;padding-left:0">1天内最多可向同一手机发送#canSendFromSamePH#次校验码，已发送<span id="resend-count-PH" style="color:red;">0</span>次。</div>\
				</div>\
			</div>\
			<div id="pay_tip"></div>\
			<div class="rp_bottom" style="padding-left:63px">\
				<img src="/hftWebService/fafunv2/images/loading.gif"></img>\
				<span class="rp_btn">下一步</span>\
				<span id="rp_msg"></span>\
			</div>\
		</div>',
	init:function(txt, _lock, _archiveId, _userId){
		if(typeof(_archiveId) != "undefined" && _archiveId != null){
			this.archiveId = _archiveId;
			this.userId = _userId;
		}
		this.title = txt || '请输入你要认证的手机号!';
		this.lock = _lock || false;
		this.step = 1;
		this.oButton = $("#sms-validate");
		var obj = this;
		this.html = this.html.replace(/#intervalFromSamePH#/g, ClientCachePlugin.getValue("intervalFromSamePH"))
				.replace(/#canSendFromSameIP#/g, ClientCachePlugin.getValue(canSendFromSameIP))
				.replace(/#canSendFromSamePH#/g, ClientCachePlugin.getValue(canSendFromSamePH));
		if(!document.getElementById("rapid_pay_style")){
			if(window['lightbox'] == undefined){
				var head = $('head').remove('#lightbox_script');
				$("<scr"+"ipt>"+"</scr" + "ipt>").attr({src:'/hftWebService/js/lightbox.js',type:'text/javascript', id:'lightbox_script'})
					.appendTo(head);
			}
			lightbox.setOpacity(0.6, 0.25);
			lightbox.init();
			$(document).find('head').append("<style id='rapid_pay_style' type='text/css'>"+obj.style+"</style>");
			$(document).delegate("#chgMobileBtn", "click", function(){
				obj.changeMobile();
				$("#rapid_pay .rp_btn").text("下一步");
			}).delegate("#rapid_pay .rp_btn2", "click", function(){
				obj.cancel();
			}).delegate("#rapid_pay .rp_btn", "click", function(){
				obj.submit();
			}).delegate("#verify_dail", "click", function(){
				$("#verify_way li").removeClass("curr");$(this).addClass("curr");
				obj.switchVerifyWay(1);
			}).delegate("#verify_sms", "click", function(){
				$("#verify_way li").removeClass("curr");$(this).addClass("curr");
				obj.switchVerifyWay(2);
			}).delegate("#sms-validate", "click", function(){
				obj.sendSmsKey();
			}).delegate("#mobile", "keyup", function(){
				this.value=this.value.replace(/[^0123456789]/g,"");
			}).delegate("#key", "keypress", function(){
				$("#key").css("border", "1px solid #7f9dB9");
				$("#err_msg").text("校验码是6位数字。");
			}).delegate("#key", "keypress", function(){
				this.value=this.value.replace(/[^0123456789]/g,"");
			});
		}
		obj.initView();
	},
	//初始化视图
	initView:function(){
		var obj = this;
		lightbox.showDiv(
						this.html.replace(/#msg#/g, this.title),
						 "手机认证", 415, 310, function(){
						 	obj.showShield();
						 });
		lightbox.lock = obj.lock;
		this.hideShield();
		//lightbox.fixHeight();
	},
	//提交请求
	submit:function(){
		var obj = this;
		if(obj.step == 1)
			obj.moile_exists();
		else if(step == 2)
			obj.chk_mobile(1);
	},
	moile_exists:function(){
		var obj = this;
		var mobile = $('#mobile').val();
		if(mobile == ''){
			$('#mobile').css("border", "1px solid red");
			$('#mobile_msg').html("<span class='error_msg'>请输入手机号码</span>");
			return;
		}else if(!/^1[3458]\d{9}$/.test(mobile)){
			$('#mobile').css("border", "1px solid red");
			$('#mobile_msg').html("<span class='error_msg'>请输入正确的手机号码</span>");
			return;
		}else if(ClientCachePlugin.getValue("needCorrect")=="1"&&ClientCachePlugin.getValue("userStorNo")==mobile){
			$('#mobile').css("border", "1px solid red");
			$('#mobile_msg').html("<span class='error_msg'>请输入新的手机号码</span>");
			return;
		}
		$.ajax({
			url: "/hftERP/mobile.do",
			async: false,
			data: "action=checkMobile&mobile=" + mobile + 
				  "&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
		    type:'GET',
		    success:function(retStr){
				var resp = eval("("+retStr+")");
				if(resp.result == 'done' || resp.msgs == 'confirm' || resp.msgs == 'hasStayData'){
					$("#srv_type").css("display", "none");
					step = 2;
					$("#rapid_pay .rp_btn").text("确定");
					$("#mobileValid").css("display", "");
					$("#show_mobile").text(mobile);
					if(this.verifyWay==2)
						obj.sendSmsKey(); //发送校验码
					else
						obj.chk_mobile();
					return;
				}
				if(resp.msgs == "exists"){
					$("#mobile_info").text("该电话已经在其他好房通门店版认证，请另设号码");
					$("#mobile_info").css("display", "");
					$("#mobile_msg").css("display", "none");
				}else{
					$("#mobile").css("border", "1px solid red");
					$("#mobile_msg").html("<span class='error_msg'>"+resp.msgs+"</span>");
				}
			}
		});
	},
	sendSmsKey:function(){
		this.oButton.attr("disabled", true).addClass("disabled");
		$("#key").val("");
		$("#key").css("border", "1px solid #7f9dB9");
		$("#mobile").css("border", "1px solid #7f9dB9");
		$("#err_msg").html("校验码是6位数字。");
		this.isError = false;
		var obj = this;
		obj.oButton = $("#sms-validate");
		var checkTimeout = function(){
			if(obj.second>1){
				obj.second -= 1;
				obj.oButton.attr("disabled", true).addClass("disabled");
				obj.oButton.val(obj.second+"秒后点此重发");
			}else{
				window.clearInterval(obj.timeout);
				obj.oButton.val("重发短信校验码");
				obj.oButton.attr("disabled", false).removeClass("disabled");
				$("#mobile").attr("readOnly", false);
			}
		};
		$.ajax({
			url: "/hftWebService/mobile.do",
			data: "action=sendSmsKey" + 
				  "&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
		    type:"GET",
		    success:function(retStr){
				var response = eval("("+retStr+")");
				if(response.result == "done"){
					obj.second = ClientCachePlugin.getValue("intervalFromSamePH"); 
					obj.timeout = window.setInterval(checkTimeout, 1000);
					obj.oButton.attr("disabled", true);
					$("#SEND_SAMEIP").css("display", "none");
					$("#SEND_SAMEPH").css("display", "");
					$("#mobile").attr("readOnly", true);
					obj.oButton.val(ClientCachePlugin.getValue("intervalFromSamePH")+"秒后点此重发");
					$("#resend-count-PH").text(response.msgs);
				}else{
					if(response.msgs == "overflow_PH"){
						obj.oButton.val("当天不能向同一手机发送"+ClientCachePlugin.getValue("canSendFromSamePH")+"次");
						obj.oButton.attr("disabled", true).addClass("disabled");
						$("#resend-count-PH").text(ClientCachePlugin.getValue("canSendFromSamePH"));
						$("#SEND_SAMEPH").css("display", "");
						$("#SEND_SAMEIP").css("display", "none");
					}else if(response.msgs == "overflow"){
						obj.oButton.val("同一IP当天发送不能超过"+ClientCachePlugin.getValue("canSendFromSameIP")+"次");
						obj.oButton.attr("disabled", true).addClass("disabled");
						$("#resend-count-IP").text(ClientCachePlugin.getValue("canSendFromSameIP"));
						$("#SEND_SAMEIP").css("display", "");
						$("#SEND_SAMEPH").css("display", "none");
					}else{
						alert(response.msgs);
					}
				}
			}
		});
	},
	chk_mobile:function(_self){
		var key = "";
		var obj = this;
		if(this.verifyWay==2){
			key = $("#key").val();
			if(key == ""){
				$("#key").css("border", "1px solid red");
				$("#err_msg").html("<span class='error_msg'>请输入校验码</span>");
				this.isError = true;
				return;
			}else if(this.isError == true){
				$("#mobile").css("border", "1px solid #7f9dB9");
				$("#key").css("border", "1px solid #7f9dB9");
				$("#err_msg").html("校验码是6位数字。");
				this.isError = false;
			}
		}
		var checkMobileFun = function(){$.ajax({
			url: "/hftWebService/mobile.do",
			async: false,
			data: "action=checkSmsKey&key=" + key + 
				  "&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
		    type:"GET",
		    success:function(retStr){
					var resp = eval("("+retStr+")");
					if(resp.result == "done"){
						$.ajax({
							url: "/hftWebService/system/user/validMobile.jsp",
							async: false,
							data: "&ARCHIVE_ID="+obj.archiveId+"&USER_ID="+obj.userId+"&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),
						    type:"GET",
						    success:function(retStr){
						    	if($.trim(retStr) == "true"){
						    		alert("恭喜，认证成功。重新登录系统即可发布网店及全城合作！");
						    		$(".rp_btn").hide();
						    	}else{
						    		alert("抱歉，认证失败。请与在线客服联系或直接拨打028-88889666！");
						    	}
								lightbox.close();
								if(obj.archiveId != ""){
									try{
										window.frames["manageFrm"].frames["manageMainFrame"].frames["user"].location =
											 window.frames["manageFrm"].frames["manageMainFrame"].frames["user"].location.href;
									}catch(e){}
								}
								ClientCachePlugin.setValue("thisMobileValid")
								ClientCachePlugin.setValue("isMobileValid")
								//top.thisMobileValid = true;
								//top.isMobileValid = true;
						    }
						});
					}else{
						if(obj.verifyWay==1){
							clearTimeout(obj.chkmobileTimer);
							obj.chkmobileTimer = setTimeout(checkMobileFun, 3000);
							if(_self==1)
								$("#dail_msg").html("<font color='red'>号码验证没有通过，请稍后重试或者再次拨打15608180666</font>")
							else
								$("#dail_msg").html("&nbsp;");
						}else{
							if(key!=""){
								$("#key").css("borderColor", "red");
								$("#err_msg").html("<span class='error_msg'>校验码有误。</span>");
							}
						}
					}
				}
			});
		};
		checkMobileFun();
	},
	switchVerifyWay:function(t){
		var obj = this;
		this.verifyWay = t;
		if(t==1){
			$("#vway_dail").show();
			$("#vway_sms1").hide();
			$("#vway_sms2").hide();
			clearTimeout(this.chkmobileTimer);
			obj.chk_mobile();
		}else{
			$("#vway_dail").hide();
			$("#vway_sms1").show();
			$("#vway_sms2").show();
			clearTimeout(this.chkmobileTimer);
			this.chkmobileTimer = null;
		}
	},
	cancel:function(){
		if(this.step == 1){
			lightbox.close();
		}else if(this.step == 2 || this.step == 3 || this.step == 4){
			this.step = 1;
			$("#srv_type").show();
			$("#rapid_title").html(this.title);
			$(".rp_bottom .rp_btn").text("确定");
			//$(".rp_bottom .rp_btn2").text("取消");
			//lightbox.fixHeight();
		}
	},
	getShield:function(id){
		var shield =  top[id+"Shield"];
		if(shield==null){
			var frmObj = top.document.getElementById(id+"Frame");
			var frmDoc = frmObj.contentWindow.document;
			shield = frmDoc.createElement("DIV"); 
			shield.id = id+"Shield";
			var w = frmObj.clientWidth;
			var h = frmObj.clientHeight;
			shield.style.cssText = "position:absolute;left:0px;top:0px;width:"+w+"px;height:"+h+"px;z-index:1000002;opacity:0.25;filter:alpha(opacity=25);background-color:black";
			frmDoc.body.appendChild(shield);
			top[id+"Shield"] = shield;
		}
		return shield;
	},
	hideShield:function(){
		var btmShield =  this.getShield("bottom");
		btmShield.style.display = "";
	},
	showShield:function(){
		var btmShield =  this.getShield("bottom");
		btmShield.style.display = "none";
	},
	changeMobile:function(){
		$("#lightbox_cont").html(this.html.replace(/#msg#/g, this.title));
/*
		console.log($("#lightbox_cont").html());
		this.oButton.attr("disabled", false).removeClass("disabled").val("获取短信校验码");
		$("#srv_type").css("display", "");
		$("#mobileValid").css("display", "none");
		$("#mobile_info").css("display", "none");
		$("#mobile").css("borderColor", "#7f9dB9");
		$("#mobile_msg").text("");
		$("#mobile").select();
		$("#mobile").attr("readOnly", false);
*/
		$("#mobile").select();
		this.step = 1;
	}
};