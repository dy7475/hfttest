var _DIALOG_STYLE_TPL = "\
*html,*html body{background-image:url(about:blank);background-attachment:fixed;}\
.d_container{position:absolute;left:0;top:0;width:100%;height:100%;}\
.toast_container{position:absolute;left:0;top:0;width:0;height:0;}\
.d_container .loadbox{width:260px;background:rgba(255,255,255,.85);-webkit-box-shadow:1px 1px 3px 0 rgba(0,0,0,.6);-moz-box-shadow:1px 1px 3px 0 rgba(0,0,0,.6);box-shadow:1px 1px 3px 0 rgba(0,0,0,.6);position:absolute;}\
.d_container .page_loading{background:url(#ROOT#loading1.gif) no-repeat 40px 10px;padding:20px 0;text-indent: 8em;font-size:12px;}\
.d_backDiv{position:absolute;left:0;top:0;width:100%;height:100%;background-color:#fff;filter:alpha(opacity=0);opacity:0.0;}\
.d_contentDiv{width:100%; height:100%; position:absolute;top:0; left:0;}\
.d_tit{position:absolute;top:11px;left:20px;cursor: default;height:20px;line-height:20px;z-index:20001;color:#076D9E;font-size: 12px;padding-top:0;font-family: '宋体'}\
.d_tit_shadow{position:absolute;top:12px;left:21px;cursor: default;height:20px;line-height:20px;z-index:10000;color:#ffffff;font-size: 12px;padding-top:0;font-family: '宋体'}\
.d_lt{width:13px;height:31px;background:url('#ROOT#dialog_lt.png') right bottom no-repeat;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_lt.png', sizingMethod='crop')}\
.d_ct{cursor: move;background:url('#ROOT#dialog_ct.png') center bottom repeat-x;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_ct.png', sizingMethod='crop')}\
.d_rt{width:13px;background:url('#ROOT#dialog_rt.png') left bottom no-repeat;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_rt.png', sizingMethod='crop');}\
.d_mlb{background:url('#ROOT#dialog_mlb.png') right 0 repeat-y;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_mlb.png', sizingMethod='crop')}\
.d_mrt{background:url('#ROOT#dialog_mrt.png') left 0 repeat-y;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_mrt.png', sizingMethod='crop')}\
.d_lb{height:13px;background:url('#ROOT#dialog_lb.png') right top no-repeat;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_lb.png', sizingMethod='crop')}\
.d_cb{background:url('#ROOT#dialog_cb.png') repeat-x;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_cb.png', sizingMethod='crop')}\
.d_rb{background:url('#ROOT#dialog_rb.png') left top no-repeat;_background:none;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='#ROOT#dialog_rb.png', sizingMethod='crop')}\
.d_close{position:absolute;width:28px;height:17px;text-indent: -200px;overflow: hidden;display: block;top:6px;right:30px;cursor: pointer;z-index:20001;background:url('#ROOT#dialog_closebtn.gif') no-repeat;}\
.d_close:hover{background:url('#ROOT#dialog_closebtn_over.gif') 1px 2px no-repeat}\
.d_table{table-layout: fixed;width: 100%;border-collapse: collapse;border-spacing: 0}\
.d_table td{padding:0}\
.scroll{scrollbar-face-color: #cee3f6;scrollbar-highlight-color: #ffffff;\
	scrollbar-shadow-color: #83b5e8;scrollbar-3dlight-color: #cee3f6;\
	scrollbar-arrow-color: #83b5e8;scrollbar-track-color: #cee3f6;\
	scrollbar-darkshadow-color: #cee3f6;scrollbar-base-color: #000000;}\
.d_iframe{height:100%;width:100%;border:0}\
/*没有边框的窗口*/\
.flsheet{position:relative;width:100%;height:100%;margin:0;padding:0;border-radius:0}\
.flcont{position: absolute;top:0;left:0;right:0;bottom:0;overflow: hidden;background:rgba(255,255,255,0);}\
.close_layer{z-index:1;position: absolute;right:10px;background:url('#ROOT#nice_rc.gif') 0 -53px no-repeat;cursor:pointer;display: block;float: right;height: 18px;line-height: 100px;margin: 6px;overflow: hidden;width: 18px;text-indent: -100px;}\
/*有边框的窗口，dlg_topbar和d_contentDiv 同级*/\
.dlg_topbar .flsheet{\
	position:relative;width:100%;height:100%;padding:6px;\
	background:rgba(102,102,102,.3);background:#666\9;filter:alpha(opacity=30);\
	-moz-border-radius:4px;\
	-webkit-border-radius:4px;\
	border-radius:4px;}\
.dlg_topbar .flcont{top:40px;right:6px;bottom:6px;left:6px;overflow: hidden;background:rgba(255,255,255,0);}\
.dlg_topbar .topbar {height: 35px;color:#FFF;background:url(#ROOT#topbar.gif) repeat-x;}\
.dlg_topbar .topbar .title {font: 700 14px/34px '宋体';margin-left: 10px;width: 50%;color:#FFF;text-shadow:0 1px 0 #333;}\
.dlg_topbar .close_layer {background-position: 0 -35px;}\
.dlg_topbar .close_layer:hover {background-position: 0 -53px;}\
.lightboxwrap{position:fixed;padding:7px;filter:alpha(opacity=1); -moz-opacity:0.01;opacity:0.01;\
filter:progid:DXImageTransform.Microsoft.gradient(enabled='true',startColorstr='#66000000', endColorstr='#66000000');\
background-color:rgba(128,128,128,0.6);\
	-moz-border-radius:5px;\
	-webkit-border-radius:5px;\
	border-radius:5px;}\
.lightbox{border:1px solid #646464}\
.lightbox h3{position:relative;height:28px;line-height:28px;color:#5A6478;text-indent:10px;background:url(#ROOT#dialog_bg.png) repeat-x 0 -26px;margin:0}\
.lightbox .lightbox_title{font-size:12px;}\
.lightbox .close{width:26px;height:20px;display:block;position:absolute;top:0;right:12px;background:url(#ROOT#dialog_bg.png) no-repeat 0 -95px;cursor:pointer}\
.lightbox .close:hover{background-position:0 -123px}\
.lightbox .lightbox_cont{position:relative;padding-bottom:30px;background-color:#EFF7FF;word-spacing:0px;min-height:100px;vertical-align: middle;text-align: center;font-size: 12px;padding: 5px;}\
.lightbox .toast_cont{position:relative;padding: 5px 20px;background:#fff;border:none;word-spacing:0px;vertical-align: middle;text-align: center;font-size: 12px;}\
.lightbox .btn_panel{position: absolute;padding:5px 15px;right:0;bottom:0;left:0;height:25px;}\
.lightbox .btnfl{float: right}\
.light_backDiv{width:100%;height:100%;\
filter:progid:DXImageTransform.Microsoft.gradient(enabled='true',startColorstr='#40000000', endColorstr='#40000000');\
background-color:rgba(0,0,0,0.25);}\
.ctrl_btn{background-image:url(#ROOT#dialog_bg.png);background-repeat:no-repeat;border:1px #fff solid;text-decoration: none;height:24px;line-height:24px;display:inline-block;text-align:center;color:#426da2;cursor:pointer;border-radius:4px;-moz-border-radius:4px;-webkit-border-radius:4px;margin-left:5px}\
.ctrl_btn:hover{border-color:#b4e6f9;_border:none;}\
.btn_no{width:72px;background:url(#ROOT#dialog_bg.png) no-repeat -27px -89px;color:#628dc2}\
.btn_yes{width:72px;background:url(#ROOT#dialog_bg.png) no-repeat -27px -115px;}\
";
;(function($){
	var mainFrame = document.documentElement,
	mainFrameWin = window,
	currFrameId = null,
	empFunc = function(){},
	_DIALOG_ARR = new Array();
	getEl = function(id, doc){
		var doc = doc || document;
		return doc.getElementById(id);
	},
	createEl = function(name, doc){
		var doc = doc || document;
		return doc.createElement(name);
	},
	isIE6 = ($.browser.msie && ($.browser.version == "6.0") && !$.support.style),
	scriptPath = (function() {
	    var elements = document.getElementsByTagName('script');
	    for (var i = 0, len = elements.length; i < len; i++) {
	        if (elements[i].src && elements[i].src.match(/jquery\.dialog[\w\-\.]*\.js/)) {
	            return elements[i].src.substring(0, elements[i].src.lastIndexOf('/') + 1);
	        }
	    }
	    return "";
	})(),
	dialog_css = (function(css){
		return css.replace(/#ROOT#/gi,scriptPath)
	})(_DIALOG_STYLE_TPL),
	loadStyle = function(doc) {
		var link = getEl("_DIALOG_CSS",doc);
		if(!link){
			$('head',doc).append("<style id='_DIALOG_CSS' type='text/css'>"+dialog_css+"</style>");
		}
    },
	getScrollStyle = function(scrollFlag){
		if(typeof(scrollFlag)=="undefined" || scrollFlag==null ||scrollFlag=="")scrollFlag = false;
		var scrollProperty = (scrollFlag?"auto":"no");
		if(scrollFlag){
			scrollProperty = " scrolling=\"auto\"";
			if(!!$.browser.msie){scrollProperty += " class=\"scroll\"";}
		}else{
			scrollProperty = " scrolling=\"no\"";
		}
		return scrollProperty;
	},
	closeDlg = function(frameId,divObj,func){
		//id 在需要关闭指定窗口时使用,如果逐级关闭不需要指定任何参数.
		var win = window;
		if(frameId!="main"){
			win = document.getElementById(frameId).contentWindow;
		}
		try{
			var dialog = win.dialogs.pop();
			_DIALOG_ARR.splice($.inArray(dialog,_DIALOG_ARR),1);
			win.document.body.removeChild(divObj);
			win._COUNT = win._COUNT-1;
		}catch(e){}	
		if(typeof(func)!="undefined"){
			func();
		}
	},
	setDialog = function(containerObj){
		if(window.currFrameWin.dialogs===undefined){
			window.currFrameWin.dialogs = new Array();
			window.currFrameWin.dialogs.push(window.currFrameWin);
		}
		window.currFrameWin.dialogs.push(containerObj);
		_DIALOG_ARR.push(containerObj);
	},
	hotKeyFunc = function(win){
		if(!$(win).data("_INIT_KEYDOWN")){
			$(win).data("_INIT_KEYDOWN",1).bind('keydown',function(event){
				var keyCode = event.which;
				if(keyCode === 27 || keyCode === 13){
					if($("#closeDialog_btn_alert").length>0){
						$("#closeDialog_btn_alert").trigger("click");
					}else if($("#closeDialog_btn_confirm").length>0){
						$((keyCode===13)?"#yesAlert":"#closeDialog_btn_confirm").trigger("click");
					}else{
						var dialogsArr = win.dialogs;
						var dlen = dialogsArr.length;
						if(dlen>1){
							var currD = dialogsArr[dlen-1];
							currD.closeFunc();
						}
					}
				}
			});
		}
		$(win).focus();
	},
	getIFrameDoc =function(iframe) {
		return iframe.contentDocument || iframe.contentWindow.document;
	},
	getShield = function(id){
		var shield =  top[id+"Shield"];
		if(shield==null){
			var frmObj = top.document.getElementById(id+"Frame");
			var frmDoc = frmObj.document;
			shield = frmDoc.createElement("DIV"); 
			shield.id = id+"Shield";
			var w = frmObj.clientWidth;
			var h = frmObj.clientHeight;
			shield.style.cssText = "display:none;position:absolute;left:0px;top:0px;width:"+w+"px;height:"+h+"px;z-index:1000002;filter:progid:DXImageTransform.Microsoft.gradient(enabled='true',startColorstr='#40000000', endColorstr='#40000000');background-color:rgba(0,0,0,0.25);";
			frmDoc.body.appendChild(shield);
			top[id+"Shield"] = shield;
		}
		return shield;
	},
	shieldBottom = function(){
		//getShield("bottom").style.display = "";
		//getShield("top").style.display = "";
	},
	cancle_ShieldBottom = function(){
		//getShield("bottom").style.display = "none";
		//getShield("top").style.display = "none";
	},
	buildIframe = function(id,height,scrollFlag){
		var scrollProperty = getScrollStyle(scrollFlag);
		height = (height-44);
		return "<div style=\"height:100%\"><iframe onfocus=\"blur()\"  id=\"openFrame"+id+"\" name=\"openFrame"+id+"\" frameborder=\"0\" style=\"background:#fff;width:100%;height:"+ height +"px;\" "+scrollProperty+"></iframe></div>"
			+ "<div id='mousedown_"+id+"' style='display:none;position:relative;background:#fff;margin-top:-"+height+"px;height:"+height+"px;width:100%;filter:alpha(opacity=1); -moz-opacity:0.01;opacity:0.01; z-index:1000'></div>";
	},
	buildDialog = function(id,width,height){
		var contentArr = [];
		contentArr.push("<a id=\"closeDivImg"+id+"\" class='d_close'>&nbsp;</a>");
		contentArr.push("<div class=\"d_tit\">好房通ERP - 行业标准引领者</div>");
		contentArr.push("<div class=\"d_tit_shadow\">好房通ERP - 行业标准引领者</div>");
		contentArr.push("<table class='d_table'>");
		contentArr.push(	"<tr>");
		contentArr.push(		"<td class='d_lt'></td>");
		contentArr.push(		"<td id=\"topTd"+id+"\" class='d_ct' style='width:"+(width-26)+"px'>");
		contentArr.push(		"</td>");
		contentArr.push(		"<td class='d_rt'></td>");
		contentArr.push(	"</tr>");
		contentArr.push(	"<tr>");
		contentArr.push(		"<td id=\"leftTd"+id+"\" class='d_mlb'></td>");
		contentArr.push(		"<td id=\"dialog_content"+id+"\" style=\"height:"+(height-44)+"px;background:#fff;\"></td>");
		contentArr.push(		"<td id=\"rightTd"+id+"\" class='d_mrt'></td>");
		contentArr.push(	"</tr>");
		contentArr.push(	"<tr>");
		contentArr.push(		"<td class='d_lb'></td>");
		contentArr.push(		"<td id=\"bottomTd"+id+"\" class='d_cb'></td>");
		contentArr.push(		"<td class='d_rb'></td>");
		contentArr.push(	"</tr>");
		contentArr.push("</table>");
		return contentArr.join("");
	},
	moveEvent = function(frameId,id,obj){
		var frame = document.documentElement;
		var frameWin = window;
		if(frameId!="main"){
			frame = document.getElementById(frameId);
			frameWin = document.getElementById(frameId).contentWindow;
		}
		var flagOpen = true;
		var sc = frameWin.document.getElementById("contentDiv"+id);
		var mousedownDiv = frameWin.document.getElementById("mousedown_"+id);
		var _w = sc.offsetWidth+2;
		var _h = sc.offsetHeight+2;
		var pageW = frame.clientWidth;
		var pageH = frame.clientHeight;
		sc.onmousedown=function(e){
			if(mousedownDiv)mousedownDiv.style.display = "block";
			e = e || frameWin.event;
			var x= e.layerX || e.offsetX;
		    var y= e.layerY || e.offsetY;
		    if(sc.setCapture){
		        sc.setCapture();
		    }else if(window.captureEvents){
		        frameWin.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
		    } 
		    frameWin.document.onmousemove=function(e){
		       if(!flagOpen){return;}
	           e= e || frameWin.event;
	           var tx=e.clientX-x;
	           var ty=e.clientY-y;
	           if(obj.id.indexOf("topTd")!=-1){
	              tx = tx - 13;
	           }else if(obj.id.indexOf("bottomTd")!=-1){
	          	  ty = ty - _h + 33;
	          	  tx = tx - 13;
	           }else if(obj.id.indexOf("leftTd")!=-1){
	           	  ty = ty - 33;
	           }else if(obj.id.indexOf("rightTd")!=-1){
	           	  tx = tx-_w+13;
	           	  ty = ty - 33;
	           }
	           //console.log(ty+"::"+pageH+"::"+_h+"::"+(pageH-_h));
	           sc.style.left=((tx<0)?0:((tx>pageW-_w)?pageW-_w:tx))+"px";
	           sc.style.top=((ty<0)?0:((ty>pageH-_h)?pageH-_h:ty))+"px";
		      };
			 frameWin.document.onmouseup=function(){
	           //取消捕获范围
	           if(sc.releaseCapture){
	              sc.releaseCapture();
	           }else if(frameWin.captureEvents){
	              frameWin.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
	           }
	           if(mousedownDiv)mousedownDiv.style.display = "none";
	           //清除事件
	           frameWin.document.onmousemove=null;
	           frameWin.document.onmouseup=null;
	           flagOpen = false;
		     };
		}
	};
	$.getParentDialog = function(){
		var size = window.currFrameWin.dialogs.length;
		if(size>2){
			return window.currFrameWin.dialogs[window.currFrameWin.dialogs.length-2].getElementsByTagName("iframe")[0].contentWindow;
		}else{
			return window.currFrameWin.dialogs[0];
		}
	};
	$.closeDialog = function(win){
		var dialog = win.dialogs.pop();
		_DIALOG_ARR.splice($.inArray(dialog,_DIALOG_ARR),1);
		win.document.body.removeChild(dialog);
		win._COUNT=win._COUNT-1;
	};
	$.closeRelDialog = function(){
		if(currFrameId!=null){
			var win = document.getElementById(currFrameId).contentWindow;
			$(win.dialogs).each(function(){
				var dialog = win.dialogs.pop();
				_DIALOG_ARR.splice($.inArray(dialog,_DIALOG_ARR),1);
				win.document.body.removeChild(dialog);
				win._COUNT = win._COUNT-1;
			});
		}
		$(window.dialogs).each(function(){
			var dialog = win.dialogs.pop();
			_DIALOG_ARR.splice($.inArray(dialog,_DIALOG_ARR),1);
			win.document.body.removeChild(dialog);
			window._COUNT=window._COUNT-1;
		});
	};
	$.MD_dialog = function(frameId,src,width,height,screenLeft,ScreenTop,scrollFlag,func){
		var frameDoc = null,frameWin = null;
		if(frameId!="main"){
			frameId = top.nowFrm;
			window.currFrame = document.getElementById(frameId);
			frameWin = window.currFrameWin = document.getElementById(frameId).contentWindow;
			frameDoc = getIFrameDoc(window.currFrame);
			currFrameId = frameId;
		}else{
			window.currFrame = document.documentElement;
			frameWin = window.currFrameWin = window;
			frameDoc = document;
		}
		if (window.currFrameWin.frameId === undefined) window.currFrameWin.frameId = frameId;
		if (window.currFrameWin._COUNT === undefined) window.currFrameWin._COUNT = 0;
		if (window.currFrameWin._ZINDEX === undefined) window.currFrameWin._ZINDEX = 1000;
		loadStyle(frameDoc);
		//top是关键词
		if(func===undefined)func=empFunc;
		var id = window.currFrameWin._COUNT;
		try{
			var divObj = getEl("container"+id,frameDoc);
			if(divObj==null){
				width = width - 5;
				var _ZINDEX = window.currFrameWin._ZINDEX;
				var initOpts = function(){
					var w = $(window).width();
					var h = $(window).height();
					var leftPX = parseInt(w - width)/ 2;
					var topPX = parseInt(h - height)/ 2;
					if(screenLeft!=undefined &&screenLeft!="" && screenLeft!=null){
						leftPX += screenLeft/2;
					}
					if(ScreenTop!=undefined && ScreenTop!="" && ScreenTop!=null){
						topPX += ScreenTop/2;
					}
					leftPX = (leftPX<0)?0:leftPX;
					topPX = (topPX<0)?0:topPX;
					return {"winw":w,"winh":h,"left":leftPX,"top":topPX}
				}
				var opts = initOpts();
				var zIndex = _ZINDEX + id*3;
				divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "d_container";divObj.style.zIndex = (zIndex-2);
				divObj.setAttribute("_frameid",frameId);
				frameDoc.body.appendChild(divObj);
				setDialog(divObj);//保存dialog容器
				//hotKeyFunc(window.currFrameWin);
				var backDiv = createEl("div",frameDoc);backDiv.id = "backDiv"+id;backDiv.className="d_backDiv";backDiv.style.zIndex = (zIndex-1);
				if(isIE6){backDiv.innerHTML="<iframe style='border:0;width:100%;height:"+opts.h+"px' src='about:blank'/>";}
				var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "d_contentDiv";
					contentDiv.style.cssText = "width:"+width+"px; height:"+height+"px; position:absolute;top:"+opts.top+"px; left:"+opts.left+"px; z-index:"+zIndex+";";
					contentDiv.innerHTML = buildDialog(id,width,height);
				divObj.appendChild(backDiv);
				divObj.appendChild(contentDiv);
				getEl("dialog_content"+id,frameDoc).innerHTML = buildIframe(id,height,scrollFlag);
				getEl("topTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				//getEl("leftTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				//getEl("rightTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				//getEl("bottomTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				getEl("openFrame"+id,frameDoc).src = src;//对不同目录的处理
				divObj.closeFunc = getEl("closeDivImg"+id,frameDoc).onclick = function(){closeDlg(frameId,divObj,func);return false;};
				var resizeFunc = function(){
					var opts2 = initOpts();
					if(opts2.top==opts.top){//由于监听top的resize.可能resizeFunc先于依附的页面执行
						setTimeout(function(){resizeFunc();},200);return;
					}
					opts = opts2;
					$("#contentDiv"+id,frameDoc).css({"top":opts.top,"left":opts.left});
				};
				$(divObj).data("_DIALOG_OPTS",{"resize":resizeFunc});
			}
			window.currFrameWin._COUNT = window.currFrameWin._COUNT+1;
		}catch(e){
			throw e
		}
	}//MD_dialog end
	$.MD_alert = function(txt,closeEnable){
		txt = "" + txt;
		var id="_alert",width=350,height=155,zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		if(closeEnable==undefined)closeEnable=true;
		shieldBottom();//禁止bottom弹出
		loadStyle(frameDoc);
		if(divObj==null){
			var w = $(window).width();
			var h = $(window).height();
			var leftPX = parseInt(w - width)/ 2;
			leftPX = (leftPX<0)?0:leftPX;
			divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "d_container";divObj.style.zIndex = (zIndex-2);
			frameDoc.body.appendChild(divObj);
			hotKeyFunc(window);
			var backDiv = createEl("div",frameDoc);backDiv.id = "backDiv"+id;backDiv.className="light_backDiv";backDiv.style.zIndex = (zIndex-1);
			if(isIE6){backDiv.innerHTML="<iframe style='border:0;width:100%;height:"+h+"px' src='about:blank'/>";}
			var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "lightboxwrap";
				contentDiv.style.cssText = "width:"+width+"px;top:0; left:"+leftPX+"px; z-index:"+zIndex+";";
				contentDiv.innerHTML = "<div class='lightbox'><h3><span class='lightbox_title'>好房通ERP</span><span style='display:none' id='closeAlert_force'>&nbsp;</span><span class='close' id='closeDialog_btn"+id+"'></span></h3><div id='lightbox_cont"+id+"' class='lightbox_cont'></div></div>";
			divObj.appendChild(backDiv);
			divObj.appendChild(contentDiv);
			txt = "<div style='display:table;margin: 20px auto 50px; text-align: left;'>"+ 
				"<input id='FOCUS_ALERT' style='width:1px;height:1px;' type='text'/>" +
				(txt.replace(/\n/gi,"<br/>")) +
				"</div>"+
				"<div class=\"btn_panel\">"+
				"	<div class='btnfl'><a href=\"javascript:void(-1)\" id=\"closeAlert_btn\" class=\"ctrl_btn btn_yes\" onfocus=\"this.blur()\">确定</a></div>"+
				"</div>";
			getEl("lightbox_cont"+id,frameDoc).innerHTML = txt;
			//定位
			var topPX = parseInt(h - $(".lightboxwrap").outerHeight())/ 2;
			topPX = (topPX<0)?0:topPX;
			$(".lightboxwrap").css({"top":topPX,"opacity":1});
			if(closeEnable){
				$("#closeAlert_btn, #closeDialog_btn"+id).click(function(){
					document.body.removeChild(divObj);cancle_ShieldBottom();return false;
				});
			}else{
				$("#closeAlert_force").click(function(){
					document.body.removeChild(divObj);cancle_ShieldBottom();return false;
				});
				$("#closeAlert_btn, #closeDialog_btn"+id).css("cursor","default");
			}
			$("#FOCUS_ALERT").focus().hide();
		}
	}
	$.MD_alert2 = function(txt,closeEnable){
		txt = "" + txt; 
		var id="_alert",width=350,height=155,zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		if(closeEnable==undefined)closeEnable=true;
		shieldBottom();//禁止bottom弹出
		loadStyle(frameDoc);
		if(divObj==null){
			var w = document.documentElement.clientWidth;
			var h = document.documentElement.clientHeight;
			var leftPX = parseInt(w - width)/ 2;
			var topPX = parseInt(h - height)/ 2 - 100;
			leftPX = (leftPX<0)?0:leftPX;
			topPX = (topPX<0)?0:topPX;
			divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "d_container";divObj.style.zIndex = (zIndex-2);
			frameDoc.body.appendChild(divObj);
			hotKeyFunc(window);
			var backDiv = createEl("div",frameDoc);backDiv.id = "backDiv"+id;backDiv.className="d_backDiv";backDiv.style.zIndex = (zIndex-1);
			if(isIE6){backDiv.innerHTML="<iframe style='border:0;width:100%;height:"+h+"px' src='about:blank'/>";}
			var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "d_contentDiv";
				contentDiv.style.cssText = "width:"+width+"px; height:"+height+"px; position:absolute;top:"+topPX+"px; left:"+leftPX+"px; z-index:"+zIndex+";";
				contentDiv.innerHTML = buildDialog(id,width,height);
			divObj.appendChild(backDiv);
			divObj.appendChild(contentDiv);
			txt = "<span style='display:table;margin: 0pt auto; text-align: left;'><span style='display:none' id='closeAlert_force'>&nbsp;</span>"+
				"<input id='FOCUS_ALERT' style='width:1px;height:1px;' type='text'/>" +
				"<br/><br/>"+(txt.replace(/\n/gi,"<br/>")) +
				"<br/>"+
				"</span>"+
				"<div style=\"text-align: center;margin-left:12px;margin-top:30px;\">"+
				"<a href=\"javascript:void(-1)\" id=\"closeAlert_btn\" class=\"alert_btn\" onfocus=\"this.blur()\">确定</a>"+
				"</div><br/>";
			getEl("dialog_content"+id,frameDoc).style.cssText = "background-color:#EFF7FF;word-spacing:0px;min-height:100px;vertical-align: middle;text-align: center;font-size: 12px;padding: 5px;";
			getEl("dialog_content"+id,frameDoc).innerHTML = txt;
			if(closeEnable){
				$("#closeAlert_btn, #closeDivImg"+id).click(function(){
					document.body.removeChild(divObj);cancle_ShieldBottom();return false;
				});
			}else{
				$("#closeAlert_force",frameDoc).click(function(){
					document.body.removeChild(divObj);cancle_ShieldBottom();return false;
				});
				$("#closeAlert_btn, #closeDivImg"+id).css("cursor","default");
			}
			getEl("topTd"+id,frameDoc).onmousedown = function(){moveEvent("main",id,this);return false;};
			$("#FOCUS_ALERT").focus().hide();
		}
	}//MD_alert end
	$.MD_confirm = function(txt,sureFunc,cancleFunc){
		var id="_confirm",width=350,height=155,zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		shieldBottom();//禁止bottom弹出
		loadStyle(frameDoc);
		if(divObj==null){
			var w = $(window).width();
			var h = $(window).height();
			var leftPX = parseInt(w - width)/ 2;
			leftPX = (leftPX<0)?0:leftPX;
			divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "d_container";divObj.style.zIndex = (zIndex-2);
			frameDoc.body.appendChild(divObj);
			hotKeyFunc(window);
			var backDiv = createEl("div",frameDoc);backDiv.id = "backDiv"+id;backDiv.className="light_backDiv";backDiv.style.zIndex = (zIndex-1);
			if(isIE6){backDiv.innerHTML="<iframe style='border:0;width:100%;height:"+h+"px' src='about:blank'/>";}
			var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "lightboxwrap";
				contentDiv.style.cssText = "width:"+width+"px;top:0; left:"+leftPX+"px; z-index:"+zIndex+";";
				contentDiv.innerHTML = "<div class='lightbox'><h3><span class='lightbox_title'>好房通ERP</span><span class='close' id='closeDialog_btn"+id+"'></span></h3><div id='lightbox_cont"+id+"' class='lightbox_cont'></div></div>";
			divObj.appendChild(backDiv);
			divObj.appendChild(contentDiv);
			txt = "<div style='display:table;margin: 20px auto 50px; text-align: left;'>"+
				"<input id='FOCUS_CONFIRM' style='width:1px;height:1px;' type='text'/>" +
				(txt.replace(/\n/gi,"<br/>")) +
				"</div>"+
				"<div class=\"btn_panel\">"+
				"	<div class='btnfl'>" +
				"		<a href=\"javascript:void(-1)\" id=\"yesAlert\" class=\"ctrl_btn btn_yes\" style=\"float:left;margin-right:10px;\" onfocus=\"this.blur()\">确定</a>"+
				"		<a href=\"javascript:void(-1)\" id=\"cancleAlert\" class=\"ctrl_btn btn_no\" style=\"float:left;\" onfocus=\"this.blur()\">取消</a>"+
				"	</div>" +
				"</div>";
			getEl("lightbox_cont"+id,frameDoc).innerHTML = txt;
			//定位
			var topPX = parseInt(h - $(".lightboxwrap").outerHeight())/ 2;
			topPX = (topPX<0)?0:topPX;
			$(".lightboxwrap").css({"top":topPX,"opacity":1});
			$("#cancleAlert, #closeDialog_btn"+id).click(function(){
				try{cancleFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			});
			$("#yesAlert").click(function(){
				try{sureFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			});
			$("#FOCUS_CONFIRM").focus().hide();
		}
	}
	$.MD_confirm2 = function(txt,sureFunc,cancleFunc){
		var id="_confirm",width=350,height=170,zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		shieldBottom();//禁止bottom弹出
		loadStyle(frameDoc);
		if(divObj==null){
			var w = document.documentElement.clientWidth;
			var h = document.documentElement.clientHeight;
			var leftPX = parseInt(w - width)/ 2;
			var topPX = parseInt(h - height)/ 2 - 100;
			leftPX = (leftPX<0)?0:leftPX;
			topPX = (topPX<0)?0:topPX;
			divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "d_container";divObj.style.zIndex = (zIndex-2);
			frameDoc.body.appendChild(divObj);
			hotKeyFunc(window);
			var backDiv = createEl("div",frameDoc);backDiv.id = "backDiv"+id;backDiv.className="d_backDiv";backDiv.style.zIndex = (zIndex-1);
			if(isIE6){backDiv.innerHTML="<iframe style='border:0;width:100%;height:"+h+"px' src='about:blank'/>";}
			var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "d_contentDiv";
				contentDiv.style.cssText = "width:"+width+"px; height:"+height+"px; position:absolute;top:"+topPX+"px; left:"+leftPX+"px; z-index:"+zIndex+";";
				contentDiv.innerHTML = buildDialog(id,width,height);
			divObj.appendChild(backDiv);
			divObj.appendChild(contentDiv);
			txt = "<span style='display:table;margin: 0pt auto; text-align: left;'>"+  
				"<input id='FOCUS_CONFIRM' style='width:1px;height:1px;' type='text'/>" +
				"<br/><br/>"+(txt.replace(/\n/gi,"<br/>")) +
				"<br/>"+
				"</span>"+
				"<div style=\"width:100px;margin:30px auto auto auto;\">"+
				"<a href=\"javascript:void(-1)\" id=\"yesAlert\" class=\"alert_btn\" style=\"float:left;margin-right:10px;\" onfocus=\"this.blur()\">确定</a>"+
				"<a href=\"javascript:void(-1)\" id=\"cancleAlert\" class=\"alert_btn\" style=\"float:left;\" onfocus=\"this.blur()\">取消</a>"+
				"</div><br/>";
			getEl("dialog_content"+id,frameDoc).style.cssText = "background-color:#EFF7FF;word-spacing:0px;min-height:100px;vertical-align: middle;text-align: center;font-size: 12px;padding: 5px;";
			getEl("dialog_content"+id,frameDoc).innerHTML = txt;
			$("#cancleAlert, #closeDialog_btn"+id).click(function(){
				try{cancleFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			});
			$("#yesAlert").click(function(){
				try{sureFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			});
			getEl("topTd"+id).onmousedown = function(){moveEvent("main",id,this);return false;};
			$("#FOCUS_CONFIRM").focus().hide();
		}
	}
	//MD_confirm end
	$.FL = function(opts,animateOpts){
		var pos = {t:50};
		opts = jQuery.extend({
			frameId:"main",
			width:'80%',
			height:"100%",
			scroll:false,
			showclose:false,
			dockid:"body",
			func:empFunc
		}, opts || {});
		animateOpts = jQuery.extend({
			show:function(){},
			hide:function(){
				$(pos.obj).stop(true).animate({left:pos.l+50,top:pos.t+pos.h/2,
						width:pos.w-100,
						height:1}
						,'fast').animate({left:pos.w/2+50,
						width:10,'opacity':'0'}
						,'fast'
						,function(){
							$(this).hide();
							closeDlg(frameId,pos.divObj,opts.func);
						});
			}
		},animateOpts || {});
		
		var frameDoc = null;
		var frameId = opts.frameId;
		if(opts.frameId!="main"){
			opts.frameId = top.nowFrm;
			window.currFrame = document.getElementById(opts.frameId);
			window.currFrameWin = document.getElementById(opts.frameId).contentWindow;
			frameDoc = getIFrameDoc(window.currFrame);
			currFrameId = opts.frameId;
		}else{
			window.currFrame = document.documentElement;
			window.currFrameWin = window;
			frameDoc = document;
		}
		if (window.currFrameWin.frameId === undefined) window.currFrameWin.frameId = frameId;
		if (window.currFrameWin._COUNT === undefined) window.currFrameWin._COUNT = 0;
		if (window.currFrameWin._ZINDEX === undefined) window.currFrameWin._ZINDEX = 1000;
		loadStyle(frameDoc);
		//top是关键词
		var id = window.currFrameWin._COUNT;
		try{
			$("html").css("overflow","hidden");
			var divObj = getEl("container"+id,frameDoc);
			if(divObj==null){
				var dlgType = !opts.type || opts.type=="0";
				var _ZINDEX = window.currFrameWin._ZINDEX;
				var zIndex = _ZINDEX + id*3;
				divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "d_container";divObj.style.zIndex = (zIndex-2);
				frameDoc.body.appendChild(divObj);
				setDialog(divObj);//保存dialog容器
				//hotKeyFunc(window.currFrameWin);
				var backDiv = createEl("div",frameDoc);backDiv.id = "backDiv"+id;backDiv.className="d_backDiv light_backDiv FL_BACKDIV";backDiv.style.zIndex = (zIndex-1);
				var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "d_contentDiv "+(!dlgType?"dlg_topbar":"");contentDiv.style.zIndex = zIndex;
				divObj.appendChild(backDiv);
				divObj.appendChild(contentDiv);
				var _fixw=0,_fixh=0,_fixl=0,_fixt=0,fixIfrmH=0;
				if(!dlgType){
					_fixw=-12,_fixh=-12,fixIfrmH=-35;
					contentDiv.innerHTML = "<div id='loading"+id+"' class='loadbox'><div class='page_loading'>正在加载页面...</div></div>" + 
						"<div id='flsheet"+id+"' class='flsheet' style='filter: alpha(opacity = 0);opacity:0;'>" +
							"<div class='topbar'>" +
							"<a id='closeDivImg"+id+"' class='close_layer'>关闭</a>" +
							"<span class='title'>好房通ERP - 行业标准引领者</span>" +
							"</div>" +
							"<div id='dialog_content"+id+"' class='flcont'></div>" +
						"</div>";
				}else{
					contentDiv.innerHTML = "<div id='loading"+id+"' class='loadbox'><div class='page_loading'>正在加载页面...</div></div>" +
						"<div id='flsheet"+id+"' class='flsheet' style='alpha(opacity = 0);opacity:0;'>" +
							"<a id='closeDivImg"+id+"' class='close_layer' style='display:"+(opts.showclose?"":"none")+"'>关闭</a>" +
							"<div id='dialog_content"+id+"' class='flcont'></div>" +
						"</div>";
					if($("._FIRST_FLSHEET",frameDoc).length>0){
						$.extend(opts,{dockid:$("._FIRST_FLSHEET",frameDoc).attr("dockid")});
					}else{
						$(".flsheet",frameDoc).addClass("_FIRST_FLSHEET").attr("dockid",opts.dockid);
					}
					var nowFrm = top.nowFrm;
					if("toolsFrm,manageFrm".indexOf(nowFrm)!=-1 && opts.dockid!="#content"){
						$.extend(opts,{dockid:"#content"});_fixh=0,_fixt=0;
					}else if("funFrm,custFrm".indexOf(nowFrm)!=-1 && opts.dockid!=".ui-layout-center"){
						$.extend(opts,{dockid:".ui-layout-center"});_fixh=27,_fixt=-27;
					}else if(nowFrm=="taskFrm" && opts.dockid!=".ui-layout-center"){
						$.extend(opts,{dockid:".ui-layout-center"});_fixh=0,_fixt=0;
					}else if(nowFrm=="fafaFrm"){
						$.extend(opts,{dockid:"#content"});_fixl=2;
					}
				}
				if($(opts.dockid,frameDoc).length==0){$.extend(opts,{dockid:"body"});_fixh=0,_fixt=0;}
				var w_w = $(opts.dockid,frameDoc).outerWidth()+_fixw;
				var w_h = $(opts.dockid,frameDoc).outerHeight()+_fixh;
				var _position =  $(opts.dockid,frameDoc).position();
				$.extend(pos,{obj:$("#flsheet"+id,frameDoc),divObj:divObj,w:w_w,h:w_h,l:_position.left+_fixl,t:_position.top+_fixt});
				$("#loading"+id,frameDoc).css({left:pos.l+(w_w-260)/2,top:(w_h-80)/2});
				if(isIE6){backDiv.innerHTML="<iframe style='border:0;width:100%;height:"+pos.h+"px' src='about:blank'/>";}
				$("#flsheet"+id,frameDoc).css({width:pos.w,height:pos.h,top:pos.t,left:pos.l});
				getEl("dialog_content"+id,frameDoc).innerHTML = "<iframe resize='1' style='border:0;width:100%;overflow-x:hidden' id='openFrame"+id+"' frameborder='no' border='0' class='d_iframe' "+getScrollStyle(opts.scroll)+" src='"+opts.src+"'/>";
				$("#openFrame"+id,frameDoc).ready(function(){setTimeout(function(){$("#loading"+id,frameDoc).hide();$("#flsheet"+id,frameDoc).css("opacity",1);},100);});
				divObj.closeFunc = getEl("closeDivImg"+id,frameDoc).onclick = function(){
					//animateOpts.hide();
					$(pos.obj).hide();
					closeDlg(frameId,pos.divObj,opts.func);
					return false;};
				var resizeFunc = function(chkflg){
					var w_w = $(opts.dockid,frameDoc).outerWidth()+_fixw;
					var w_h = $(opts.dockid,frameDoc).outerHeight()+_fixh;
					if(!chkflg && w_w==pos.w && w_h==pos.h){//由于监听top的resize.可能resizeFunc先于依附的页面执行
						setTimeout(function(){resizeFunc();},200);return;
					}
					var _position =  $(opts.dockid,frameDoc).position();
					$.extend(pos,{w:w_w,h:w_h,l:_position.left+_fixl,t:_position.top+_fixt});
					if(isIE6){
						$(".FL_BACKDIV" + " iframe",frameDoc).height(pos.h);
						$("#flsheet"+id + " iframe",frameDoc).height(pos.h+fixIfrmH);
					};
					$("#flsheet"+id,frameDoc).css({width:pos.w,height:pos.h});
					if(opts.frameId=="fafaFrm"){
						$("#flsheet"+id,frameDoc).css({left:pos.l});
					}
					if(!chkflg)setTimeout(function(){resizeFunc(true);},500);//fixed 延迟判断窗口是否适应
				};
				$(divObj).data("_DIALOG_OPTS",{"resize":resizeFunc});
			}
			window.currFrameWin._COUNT = window.currFrameWin._COUNT+1;
		}catch(e){
			throw e
		}
	}
	$.toast = function(txt,animateOpts){
		var id="_toast",zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		loadStyle(frameDoc);
		if(divObj==null){
			divObj = createEl("div",frameDoc);divObj.id = "container"+id;divObj.className = "toast_container";divObj.style.zIndex = (zIndex-2);
			frameDoc.body.appendChild(divObj);
			var contentDiv = createEl("div",frameDoc);contentDiv.id = "contentDiv"+id;contentDiv.className = "lightboxwrap";
				contentDiv.style.cssText = "opacity:0.2;filter:alpha(opacity=20);width:"+width+"px;top:0; z-index:"+zIndex+";";
				contentDiv.innerHTML = "<div class='lightbox' style='border:none'><h3 style='display:none'><span class='lightbox_title'>好房通ERP</span><span class='close' id='closeDialog_btn"+id+"'></span></h3><div id='lightbox_cont"+id+"' class='toast_cont'></div></div>";
			divObj.appendChild(contentDiv);
		}
		txt = "<div style='display:table;margin: 10px auto; text-align: left;'>"+
				"<input id='FOCUS_TOAST' style='width:1px;height:1px;' type='text'/>" +
				(txt.replace(/\n/gi,"<br/>")) +
				"</div>";
		getEl("lightbox_cont"+id,frameDoc).innerHTML = txt;
		//定位
		$("<div id='_T_W_DIV' style='position:absolute;top:-2000px;'/>").html(txt.replace(/\n/gi,"<br/>")).appendTo("body");
		var width = $("#contentDiv_toast").outerWidth();
		var height = $("#contentDiv_toast").outerHeight();
		$("#_T_W_DIV").remove();
		var w = $(window).width();
		var h = $(window).height();
		var leftPX = parseInt(w - width)/ 2;
		leftPX = (leftPX<0)?0:leftPX;
		var topPX = parseInt(h - height)/ 2;
		topPX = (topPX<0)?0:topPX;
		$(".lightboxwrap").css({"left":leftPX,"top":topPX,"opacity":0.2});
		$("#closeDialog_btn_toast").click(function(){
			$("#contentDiv_toast").stop(true).animate({left:leftPX,top:topPX,'opacity':'0.2'},'fast',function(){
				document.body.removeChild(divObj);
			});
			return false;
		});
		$("#FOCUS_TOAST").focus().hide();
		$("#contentDiv_toast").stop(true).animate({left:leftPX,top:topPX,'opacity':'1'},'fast').click(function(){
			$("#closeDialog_btn_toast").trigger("click");
		});
	}
	//绑定resize，window.resize时窗口重定位
	if(!$(top).attr("_DIALOG_RESIZE")){
		$(top).attr("_DIALOG_RESIZE",1).bind("resize",function(){
			$(_DIALOG_ARR).each(function(){
				var _d_opts = $(this).data("_DIALOG_OPTS");
				if(!!_d_opts)_d_opts.resize();
			});
		});
	}
})(jQuery);


var Myfun7_Dialog = (function(){
	return {dialog:$.MD_dialog,
		_alert:$.MD_alert,
		_confirm:$.MD_confirm,
		getParentDialog:$.getParentDialog,
		closeD:$.closeDialog,
		closeRelD:$.closeRelDialog,
		FL:$.FL,
		toast:$.toast
	};
})();

/**
 * 外部调用弹窗方法
 * @param {传入当前页面所在mainIndex的iframe Id} frameId
 * 				如果弹窗基于mainIndex，则传入"main"
 * @param {弹出页面路径} src
 * @param {宽度} width
 * @param {高度} height
 * @param {距离中心位置水平偏移} screenLeft
 * @param {距离中心位置垂直偏移} ScreenTop
 * @param {是否显示滚动条} scrollFlag
 * @param {回调函数} callback
 */
function OpenDiv(frameId,src,width,height,screenLeft,ScreenTop,scrollFlag,callback){
	Myfun7_Dialog.dialog(frameId,src,width,height,screenLeft,ScreenTop,scrollFlag,callback);
}
function FL(opts){
	Myfun7_Dialog.FL(opts);
}
function getPDlg(){
	return Myfun7_Dialog.getParentDialog();
}
function OpenmishuDiv(src,width,height,screenLeft,ScreenTop){
	Myfun7_Dialog.dialog("main",src,width,height,screenLeft,ScreenTop);
}
function closetDiv(win){
	if(win==undefined)win = window;
	Myfun7_Dialog.closeD(win);
}
/**
 * 弹窗关闭函数(点击top刷新按钮时调用此方法)
 */
function closeRelD(){
	Myfun7_Dialog.closeRelD();
}
var _alert = window.alert;//保留原始alert
var _confirm = window.confirm;//保留原始confirm
window.alert = function(txt){
	Myfun7_Dialog._alert(txt);
}
window.confirm = function(txt,yesFunc,cancleFunc){
	Myfun7_Dialog._confirm(txt,yesFunc,cancleFunc);
}
function nopay(txt){
	Myfun7_Dialog._alert(txt,false);
}