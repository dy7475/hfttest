var Myfun7_Dialog = (function(){
	var mainFrame = document.documentElement,
	mainFrameWin = window,
	currFrameId = null,
	getEl = function(id, doc){
		var doc = doc || document;
		return doc.getElementById(id);
	},
	createEl = function(name, doc){
		var doc = doc || document;
		return doc.createElement(name);
	},
	picPath = (function() {
	    var url = top.location.href;
	    var regexp  = new RegExp(/http:\/\/[^\/]+\/([^\/]+)/i);
	    var arr = regexp.exec(url);
	    var root = "/hftWebService/publicJs/dialog/";
	    if(arr.length>1){
	    	root = "/"+arr[1]+"/publicJs/dialog/";
	    }
	    return root;
	})(),
	isIE6 = (function(){
		var isIE6Flag = false;
		var Sys = {};
		var ua = navigator.userAgent.toLowerCase();
		(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 0;
		if (Sys.ie) {
			var temp = parseInt(Sys.ie);
			if(temp==6)isIE6Flag=true;
		}
		return isIE6Flag;
	})(),
	flagOpen = false,
	empFunc = function(){},
	moveEvent = function(frameId,id,obj){
		var frame = document.documentElement;
		var frameWin = window;
		if(frameId!="main"){
			frame = document.getElementById(frameId);
			frameWin = document.getElementById(frameId).contentWindow;
		}
		flagOpen = true;
		var sc = frameWin.document.getElementById("contentDiv"+id);
		var mousedownDiv = frameWin.document.getElementById("mousedown_"+id);
		var _w = sc.offsetWidth;
		var _h = sc.offsetHeight;
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
	           }//alert(tx+"::"+pageW+"::"+_w+"::"+(pageW-_w));
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
	},
	closetDiv = function(frameId,divObj,func){
		//id 在需要关闭指定窗口时使用,如果逐级关闭不需要指定任何参数.
		var win = window;
		if(frameId!="main"){
			win = document.getElementById(frameId).contentWindow;
		}
		try{//alert(win.document.body.innerHTML);
			win.document.body.removeChild(divObj);
			win._COUNT = win._COUNT-1;
			win.dialogs.pop();
		}catch(e){
		}	
		if(typeof(func)!="undefined"){
			func();
		}
	},
	getScrollStyle = function(scrollFlag){
		if(typeof(scrollFlag)=="undefined" || scrollFlag==null ||scrollFlag=="")scrollFlag = false;
		var scrollProperty = (scrollFlag?"auto":"no");
		if(scrollFlag){
			scrollProperty = " scrolling=\"auto\" style=\"scrollbar-face-color: #cee3f6;" +
					"scrollbar-highlight-color: #ffffff;scrollbar-shadow-color: #83b5e8;" +
					"scrollbar-3dlight-color: #cee3f6;scrollbar-arrow-color: #83b5e8;" +
					"scrollbar-track-color: #cee3f6;scrollbar-darkshadow-color: #cee3f6;" +
					"scrollbar-base-color: #000000;\"";
		}else{
			scrollProperty = " scrolling=\"no\"";
		}
		return scrollProperty;
	},
	each = function(l, k, j){
		if (typeof l.length == "number") {
			for (var h = 0, g = l.length; h < g; h++) {
				k.call(j, l[h], h)
			}
		} else {
			if (typeof l == "number") {
				for (var h = 0; h < l; h++) {
					k.call(j, h, h)
				}
			} else {
				for (var h in l) {
					if (l.hasOwnProperty(h)) {
						k.call(j, l[h], h)
					}
				}
			}
		}
	},
	closeRelDialog = function(){
		if(currFrameId!=null){
			var win = document.getElementById(currFrameId).contentWindow;
			var relDs = win.dialogs;
			each(relDs,function(){win.document.body.removeChild(win.dialogs.pop());win._COUNT = win._COUNT-1;});
		}
		each(window.dialogs,function(){document.body.removeChild(window.dialogs.pop());window._COUNT=window._COUNT-1;});
	},
	closeDialog = function(win){
		win.document.body.removeChild(win.dialogs.pop());
		win._COUNT=win._COUNT-1;
	},
	addEvent = function(obj, type, fn){
	    if (obj.attachEvent)
	        obj.attachEvent('on' + type, fn);
	    else
	        obj.addEventListener(type, fn, false);
	},
	setDialog = function(containerObj){
		if(window.currFrameWin.dialogs===undefined){
			window.currFrameWin.dialogs = new Array();
			window.currFrameWin.dialogs.push(window.currFrameWin);
		}
		window.currFrameWin.dialogs.push(containerObj);
	},
	getParentDialog = function(){
		var size = window.currFrameWin.dialogs.length;
		if(size>2){
			return window.currFrameWin.dialogs[window.currFrameWin.dialogs.length-2].getElementsByTagName("iframe")[0].contentWindow;
		}else{
			return window.currFrameWin.dialogs[0];
		}
	},
	getIFrameDoc =function(iframe) {  
		return iframe.contentDocument || iframe.contentWindow.document;
	},
	shieldBottom = function(){
//		var btmFrmObj = top.document.getElementById("bottomFrame");
//		var btmFrmDoc = top;//btmFrmObj.contentWindow.document;
//		var btmShield =  btmFrmDoc.getElementById("bottomShield");
		//if(btmShield==null){
//			btmShield = btmFrmDoc.createElement("DIV"); 
//			btmShield.id = "bottomShield";
//			var w = btmFrmObj.clientWidth;
//			var h = btmFrmObj.clientHeight;
//			btmShield.style.cssText = "position:absolute;left:0px;top:0px;width:"+w+"px;height:"+h+"px;z-index:1000002;opacity:0.01;filter:alpha(opacity=1);background-color:#fff";
//			btmFrmDoc.body.appendChild(btmShield); 
		//}else{
		document.getElementById("bottomShield").style.display = "";
		//}
	},
	cancle_ShieldBottom = function(){
		var btmFrmObj = top.document.getElementById("bottomFrame");
		var btmFrmDoc = btmFrmObj.contentWindow.document;
		var btmShield =  btmFrmDoc.getElementById("bottomShield");
		btmShield.style.display = "none";
	},
	buildIframe = function(id,width,height,scrollFlag){
		var scrollProperty = getScrollStyle(scrollFlag);
		width = (width-26); 
		height = (height-46);
		return "<iframe onfocus=\"blur()\"  id=\"openFrame"+id+"\" name=\"openFrame"+id+"\" frameborder=\"0\" style=\"background:#fff;height:"+ height +"px;width:"+width+"px\" "+scrollProperty+"></iframe>"
			+ "<div id='mousedown_"+id+"' style='display:none;position:relative;background:#fff;margin-top:-"+height+"px;height:"+height+"px;width:"+width+"px;filter:alpha(opacity=1); -moz-opacity:0.01;opacity:0.01; z-index:1000'></div>";
	},
	buildDialog = function(id,width,height){
		var contentArr = [];
		if(isIE6){//png透明背景需要使用AlphaImageLoader
			contentArr.push("<img id=\"closeDivImg"+id+"\" onmouseover=\"javascript:this.src='"+picPath+"dialog_closebtn_over.gif'\" onmouseout=\"javascript:this.src='"+picPath+"dialog_closebtn.gif'\" style=\"position:absolute;top:8px;left:"+(width-59)+"px;cursor: pointer;z-index:20001\" src='"+picPath+"dialog_closebtn.gif'>");
			contentArr.push("<div id=\"divTitle1\" style=\"position:absolute;top:13px;left:20px;cursor: default;height:20px;line-height:20px;z-index:20001;color:#076D9E;font-size: 12px;padding-top:0;font-family: '宋体'\">好房通ERP - 行业标准引领者</div>");
			contentArr.push("<div id=\"divTitle2\" style=\"position:absolute;top:14px;left:21px;cursor: default;height:20px;line-height:20px;z-index:10000;color:#ffffff;font-size: 12px;padding-top:0;font-family: '宋体'\">好房通ERP - 行业标准引领者</div>");
			contentArr.push("<table width=\""+width+"px\" cellpadding=\"0\" cellspacing=\"0\">");
			contentArr.push(	"<tr style=\"height:33px;\">");
			contentArr.push(		"<td style=\"width:13px;height:33px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_lt.png', sizingMethod='crop')\"></td>");
			contentArr.push(		"<td id=\"topTd"+id+"\" style=\"cursor: move; width:"+(width-26)+"px;height:33px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_ct.png', sizingMethod='crop')\">");
			contentArr.push(		"</td>");
			contentArr.push(		"<td style=\"width:13px;height:33px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_rt.png', sizingMethod='crop');\"></td>");
			contentArr.push(	"</tr>");
			contentArr.push(	"<tr>");
			contentArr.push(		"<td id=\"leftTd"+id+"\" style=\"width:13px;height:"+(height-46)+"px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_mlb.png', sizingMethod='crop')\"></td>");
			contentArr.push(		"<td style=\"background:#fff;width:"+(width-26)+"px;height:"+(height-46)+"\" id=\"dialog_content"+id+"\"></td>");
			contentArr.push(		"<td id=\"rightTd"+id+"\" style=\"width:13px;height:"+(height-46)+"px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_mrt.png', sizingMethod='crop')\"></td>");
			contentArr.push(	"</tr>");
			contentArr.push(	"<tr style=\"height:13px;\">");
			contentArr.push(		"<td style=\"width:13px;height:13px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_lb.png', sizingMethod='crop')\"></td>");
			contentArr.push(		"<td id=\"bottomTd"+id+"\" style=\"width:"+(width-26)+"px;height:13px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_cb.png', sizingMethod='crop')\"></td>");
			contentArr.push(		"<td style=\"width:13px;height:13px;FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+picPath+"dialog_rb.png', sizingMethod='crop')\"></td>");
			contentArr.push(	"</tr>");
			contentArr.push("</table>");
		}else{
			contentArr.push("<img id=\"closeDivImg"+id+"\" onmouseover=\"javascript:this.src='"+picPath+"dialog_closebtn_over.gif'\" onmouseout=\"javascript:this.src='"+picPath+"dialog_closebtn.gif'\" style=\"position:absolute;top:8px;left:"+(width-59)+"px;cursor: pointer;z-index:20001\" src='"+picPath+"dialog_closebtn.gif'>");
			contentArr.push("<div id=\"divTitle1\" style=\"position:absolute;top:13px;left:20px;cursor: default;height:20px;line-height:20px;z-index:20001;color:#076D9E;font-size: 12px;padding-top:0;font-family: '宋体'\">好房通ERP - 行业标准引领者</div>");
			contentArr.push("<div id=\"divTitle2\" style=\"position:absolute;top:14px;left:21px;cursor: default;height:20px;line-height:20px;z-index:10000;color:#ffffff;font-size: 12px;padding-top:0;font-family: '宋体'\">好房通ERP - 行业标准引领者</div>");
			contentArr.push("<table width=\""+width+"px\" cellpadding=\"0\" cellspacing=\"0\">");
			contentArr.push(	"<tr style=\"height:33px;\">");
			contentArr.push(		"<td style=\"width:13px;height:33px;background:url('"+picPath+"dialog_lt.png');\"></td>");
			contentArr.push(		"<td id=\"topTd"+id+"\" style=\"cursor: move; width:"+(width-26)+"px;height:33px;background:url('"+picPath+"dialog_ct.png');\">");
			contentArr.push(		"</td>");
			contentArr.push(		"<td style=\"width:13px;height:33px;background:url('"+picPath+"dialog_rt.png');\"></td>");
			contentArr.push(	"</tr>");
			contentArr.push(	"<tr>");
			contentArr.push(		"<td id=\"leftTd"+id+"\" style=\"width:13px;height:"+(height-46)+"px;background:url('"+picPath+"dialog_mlb.png');\"></td>");
			contentArr.push(		"<td style=\"background:#fff;width:"+(width-26)+"px;height:"+(height-46)+"\" id=\"dialog_content"+id+"\"></td>");
			contentArr.push(		"<td id=\"rightTd"+id+"\" style=\"width:13px;height:"+(height-46)+"px;background:url('"+picPath+"dialog_mrt.png');\"></td>");
			contentArr.push(	"</tr>");
			contentArr.push(	"<tr style=\"height:13px;\">");
			contentArr.push(		"<td style=\"width:13px;height:13px;background:url('"+picPath+"dialog_lb.png');\"></td>");
			contentArr.push(		"<td id=\"bottomTd"+id+"\" style=\"width:"+(width-26)+"px;height:13px;background:url('"+picPath+"dialog_cb.png');\"></td>");
			contentArr.push(		"<td style=\"width:13px;height:13px;background:url('"+picPath+"dialog_rb.png');\"></td>");
			contentArr.push(	"</tr>");
			contentArr.push("</table>");
		}
		return contentArr.join("");
	};
	var MD_dialog = function(frameId,src,width,height,screenLeft,ScreenTop,scrollFlag,func){
		var frameDoc = null;
		if(frameId!="main"){
			window.currFrame = document.getElementById(frameId);
			window.currFrameWin = document.getElementById(frameId).contentWindow;
			frameDoc = getIFrameDoc(window.currFrame);
			currFrameId = frameId;
		}else{
			window.currFrame = document.documentElement;
			window.currFrameWin = window;
			frameDoc = document;
		}
		if (window.currFrameWin.frameId === undefined) window.currFrameWin.frameId = frameId;
		if (window.currFrameWin._COUNT === undefined) window.currFrameWin._COUNT = 0;
		if (window.currFrameWin._ZINDEX === undefined) window.currFrameWin._ZINDEX = 1000;
		//top是关键词
		if(func===undefined)func=empFunc;
		var id = window.currFrameWin._COUNT;
		try{
			var divObj = getEl("container"+id,frameDoc);
			if(divObj==null){
				var _ZINDEX = window.currFrameWin._ZINDEX;
				var w = window.currFrame.clientWidth;
				var h = window.currFrame.clientHeight;
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
				var zIndex = _ZINDEX + id*3;
				var newDiv = createEl("div",frameDoc);
				newDiv.id = "container"+id;
				newDiv.style.cssText = "position:absolute;z-index:1000;left:0;top:0;width:100%;height:100%;display:none;z-index:"+(zIndex-2)+";";
				frameDoc.body.appendChild(newDiv);
				setDialog(newDiv);//保存dialog容器
				var backDiv = createEl("div",frameDoc);
				backDiv.id = "backDiv"+id;
				backDiv.style.cssText = "position:absolute;left:0;top:0;width:100%;height:100%;background-color:#fff;filter:alpha(opacity=0);opacity:0.0;z-index:"+(zIndex-1)+";";
				newDiv.appendChild(backDiv);
				var contentDiv = createEl("div",frameDoc);
				contentDiv.id = "contentDiv"+id;
				contentDiv.style.cssText = "width:"+width+"px; height:"+height+"px; position:absolute;top:"+topPX+"px; left:"+leftPX+"px; z-index:"+zIndex+";";
				newDiv.appendChild(contentDiv);
				contentDiv.innerHTML = buildDialog(id,width,height);
				getEl("dialog_content"+id,frameDoc).innerHTML = buildIframe(id,width,height,scrollFlag);
				getEl("topTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				//getEl("leftTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				//getEl("rightTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				//getEl("bottomTd"+id,frameDoc).onmousedown = function(){moveEvent(frameId,id,this);return false;};
				getEl("openFrame"+id,frameDoc).src = src;//对不同目录的处理
				getEl("closeDivImg"+id,frameDoc).onclick = function(){closetDiv(frameId,newDiv,func);return false;};
			}
			setTimeout(function(){
				getEl("container"+id,frameDoc).style.display="";
				try{
					getEl("openFrame"+id,frameDoc).contentWindow.document.getElementsByTagName("input")[0].focus();
				}catch(e){}
			},"100");
			window.currFrameWin._COUNT = window.currFrameWin._COUNT+1;
		}catch(e){
			throw e
		}
	}//MD_dialog end
	var MD_alert = function(txt,closeEnable){
		txt = "" + txt; 
		var id="_alert",width=350,height=170,zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		if(closeEnable==undefined)closeEnable=true;
		shieldBottom();//禁止bottom弹出
		if(divObj==null){
			var w = document.documentElement.clientWidth;
			var h = document.documentElement.clientHeight;
			var leftPX = parseInt(w - width)/ 2;
			var topPX = parseInt(h - height)/ 2 - 100;
			leftPX = (leftPX<0)?0:leftPX;
			topPX = (topPX<0)?0:topPX;
			divObj = createEl("div",frameDoc);
			divObj.id = "container"+id;
			divObj.style.cssText = "position:absolute;z-index:1000;left:0;top:0;width:100%;height:100%;display:none;z-index:"+(zIndex-2)+";";
			frameDoc.body.appendChild(divObj);
			var backDiv = createEl("div",frameDoc);
			backDiv.id = "backDiv"+id;
			backDiv.style.cssText = "position:absolute;left:0;top:0;width:100%;height:100%;background-color:#fff;filter:alpha(opacity=0);opacity:0.0;z-index:"+(zIndex-1)+";";
			divObj.appendChild(backDiv);
			var contentDiv = createEl("div",frameDoc);
			contentDiv.id = "contentDiv"+id;
			contentDiv.style.cssText = "width:"+width+"px; height:"+height+"px; position:absolute;top:"+topPX+"px; left:"+leftPX+"px; z-index:"+zIndex+";";
			divObj.appendChild(contentDiv);
			contentDiv.innerHTML = buildDialog(id,width,height);
			txt = "<span style='display:table;margin: 0pt auto; text-align: left;'>"+ 
				"<br/><br/>"+(txt.replace(/\n/gi,"<br/>")) +
				"<br/>"+
				"</span>"+
				"<div style=\"text-align: center;margin-left:12px;margin-top:30px;\">"+
				"<a href=\"javascript:void(-1)\" id=\"closeAlert_btn\" class=\"alert_btn\" onfocus=\"this.blur()\">确定</a>"+
				"</div><br/>";
			getEl("dialog_content"+id,frameDoc).style.cssText = "background-color:#EFF7FF;word-spacing:0px;min-height:100px;vertical-align: middle;text-align: center;font-size: 12px;padding: 5px;";
			getEl("dialog_content"+id,frameDoc).innerHTML = txt;
			if(closeEnable){
				getEl("closeAlert_btn",frameDoc).onclick = function(){
					document.body.removeChild(divObj);cancle_ShieldBottom();return false;
				};
				getEl("closeDivImg"+id,frameDoc).onclick = function(){
					document.body.removeChild(divObj);cancle_ShieldBottom();return false;
				};
			}else{
				getEl("closeDivImg"+id,frameDoc).style.cursor = "default";
				getEl("closeAlert_btn",frameDoc).style.cursor = "default";
			}
			getEl("topTd"+id,frameDoc).onmousedown = function(){moveEvent("main",id,this);return false;};
			divObj.style.display="";
			divObj.focus();
		}
	}//MD_alert end
	var MD_confirm = function(txt,sureFunc,cancleFunc){
		var id="_confirm",width=350,height=170,zIndex=1000002,frameDoc=document;
		var divObj = getEl("container"+id,frameDoc);
		shieldBottom();//禁止bottom弹出
		if(divObj==null){
			var w = document.documentElement.clientWidth;
			var h = document.documentElement.clientHeight;
			var leftPX = parseInt(w - width)/ 2;
			var topPX = parseInt(h - height)/ 2 - 100;
			leftPX = (leftPX<0)?0:leftPX;
			topPX = (topPX<0)?0:topPX;
			divObj = createEl("div",frameDoc);
			divObj.id = "container"+id;
			divObj.style.cssText = "position:absolute;z-index:1000;left:0;top:0;width:100%;height:100%;display:none;z-index:"+(zIndex-2)+";";
			frameDoc.body.appendChild(divObj);
			var backDiv = createEl("div",frameDoc);
			backDiv.id = "backDiv"+id;
			backDiv.style.cssText = "position:absolute;left:0;top:0;width:100%;height:100%;background-color:#fff;filter:alpha(opacity=0);opacity:0.0;z-index:"+(zIndex-1)+";";
			divObj.appendChild(backDiv);
			var contentDiv = createEl("div",frameDoc);
			contentDiv.id = "contentDiv"+id;
			contentDiv.style.cssText = "width:"+width+"px; height:"+height+"px; position:absolute;top:"+topPX+"px; left:"+leftPX+"px; z-index:"+zIndex+";";
			divObj.appendChild(contentDiv);
			contentDiv.innerHTML = buildDialog(id,width,height);
			txt = "<span style='display:table;margin: 0pt auto; text-align: left;'>"+  
				"<br/><br/>"+(txt.replace(/\n/gi,"<br/>")) +
				"<br/>"+
				"</span>"+
				"<div style=\"width:100px;margin:30px auto auto auto;\">"+
				"<a href=\"javascript:void(-1)\" id=\"yesAlert\" class=\"alert_btn\" style=\"float:left;margin-right:10px;\" onfocus=\"this.blur()\">确定</a>"+
				"<a href=\"javascript:void(-1)\" id=\"cancleAlert\" class=\"alert_btn\" style=\"float:left;\" onfocus=\"this.blur()\">取消</a>"+
				"</div><br/>";
			getEl("dialog_content"+id,frameDoc).style.cssText = "background-color:#EFF7FF;word-spacing:0px;min-height:100px;vertical-align: middle;text-align: center;font-size: 12px;padding: 5px;";
			getEl("dialog_content"+id,frameDoc).innerHTML = txt;
			getEl("closeDivImg"+id,frameDoc).onclick = function(){
				try{cancleFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			};
			getEl("cancleAlert",frameDoc).onclick = function(){
				try{cancleFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			};
			getEl("yesAlert",frameDoc).onclick = function(){
				try{sureFunc()}catch(e){}
				document.body.removeChild(divObj);cancle_ShieldBottom();return false;
			};
			getEl("topTd"+id,frameDoc).onmousedown = function(){moveEvent("main",id,this);return false;};
			divObj.style.display="";
			divObj.focus();
		}
	}//MD_confirm end
	return {dialog:MD_dialog,getParentDialog:getParentDialog,closeD:closeDialog,closeRelD:closeRelDialog,_alert:MD_alert,_confirm:MD_confirm};
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