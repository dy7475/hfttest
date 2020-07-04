/************************************************************
 * 公告js整合
 * hyq 2011-12-3
 ***********************************************************/
String.prototype.trim=function(){return this.replace(/^\s*/gi,"").replace(/\s*$/gi,"")};
String.prototype.ltrim=function(){return this.replace(/^\s*/gi,"")};
String.prototype.rtrim=function(){return this.replace(/\s*$/gi,"")};
function addEvent(obj, type, fn){
    if (obj.attachEvent)
        obj.attachEvent('on' + type, fn);
    else
        obj.addEventListener(type, fn, false);
}
var _alert = window.alert;//保留原始alert
var _confirm = window.confirm;//保留原始confirm
//最外层框架的mainFrame对象
//var _Main_Frame = top.document.getElementById("mainFrame").contentWindow;
var _Main_Frame = top;
window.alert = function(txt){
	_Main_Frame.Myfun7_Dialog._alert(txt);
}
window.confirm = function(txt,yesFunc,cancleFunc){
	_Main_Frame.Myfun7_Dialog._confirm(txt,yesFunc,cancleFunc);
}
//common.js
function show_dialog(showdata,w,h,l,t){
	getWinSize();
    var objDialog = document.getElementById("show_dialog");
    if (!objDialog) objDialog = document.createElement("div");
    objDialog.id = "show_dialog";
    var oS = objDialog.style;
    oS.width = w + "px";
    oS.height = h + "px";
    oS.top = t + "px";
    oS.left = l + "px";
    oS.margin = "0px";
    oS.padding = "1px";
    oS.position = "absolute";
    oS.background = "#C9E2FF";
    oS.zIndex="100000";
    oS.border = "#fcefbb 1px solid";
    oS.filter = "Alpha(Opacity=90)";
    objDialog.innerHTML = showdata;
    document.body.appendChild(objDialog);
}
function getWinSize(_target) {
    var windowWidth, windowHeight;
    if(_target) target = _target.document;
    else target = document;
    if (self.innerHeight) { // all except Explorer
        if(_target) target = _target.self;
        else	target = self;
        windowWidth = target.innerWidth;
        windowHeight = target.innerHeight;
    } else if (target.documentElement && target.documentElement.clientHeight) { // Explorer 6 Strict Mode
        windowWidth = target.documentElement.clientWidth;
        windowHeight = target.documentElement.clientHeight;
    } else if (target.body) { // other Explorers
        windowWidth = target.body.clientWidth;
        windowHeight = target.body.clientHeight;
    }
    g_win_width = parseInt(windowWidth);
    g_win_height = parseInt(windowHeight);
}
function findX(obj){
	var curleft=0;
	if(obj.offsetParent){
		while(obj.offsetParent){
			curleft+=obj.offsetLeft
			obj=obj.offsetParent;
		}
	}else if(obj.x)
		curleft+=obj.x;
	return curleft;
}
function findY(obj){
	var curtop=0;
	if(obj.offsetParent){
		while(obj.offsetParent){
			curtop+=obj.offsetTop
			obj=obj.offsetParent;
		}
	}else if(obj.y)
		curtop+=obj.y;
	return curtop;
}

function dialogCancel(){
	var obj =  document.getElementById('show_dialog');
	obj.parentNode.removeChild(obj);
}

function setNullImg(obj){
	$(obj).removeAttr("onerror", "");
	obj.src = "./images/default.png";
}
function setImg(obj,src){
	obj.src = src;
}


/**
 * 获得页面高度
 */
function getPageSize(){
	var xScroll, yScroll;
	if (window.innerHeight && window.scrollMaxY) {
		xScroll = document.body.scrollWidth;
		yScroll = window.innerHeight + window.scrollMaxY;
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
		xScroll = document.body.scrollWidth;
		yScroll = document.body.scrollHeight;
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
		xScroll = document.body.offsetWidth;
		yScroll = document.body.offsetHeight;
	}
	
	var windowWidth, windowHeight;
	if (self.innerHeight) { // all except Explorer
		windowWidth = self.innerWidth;
		windowHeight = self.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
		windowWidth = document.documentElement.clientWidth;
		windowHeight = document.documentElement.clientHeight;
	} else if (document.body) { // other Explorers
		windowWidth = document.body.clientWidth;
		windowHeight = document.body.clientHeight;
	}
	
	// for small pages with total height less then height of the viewport
	if(yScroll < windowHeight){
		pageHeight = windowHeight;
	} else {
		pageHeight = yScroll;
	}
	
	// for small pages with total width less then width of the viewport
	if(xScroll < windowWidth){
		pageWidth = windowWidth;
	} else {
		pageWidth = xScroll;
	}
	
	
	arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight)
	//alert(arrayPageSize[0]+"::"+arrayPageSize[1]+"::"+arrayPageSize[2]+"::"+arrayPageSize[3]);
	return arrayPageSize;
}
//common.js end

//tablecolor.js
function initTab(tabName){
	var oldTrObj;
	var PtrArr;
	var tabId = "tabList";
	if(tabName!=null && tabName!=""){
		tabId = tabName;
	}
	if(document.getElementById(tabId)!=null){
		PtrArr = document.getElementById(tabId).getElementsByTagName("tr");
		for (i=0;i<PtrArr.length;i++) { 
		      PtrArr[i].style.backgroundColor = (PtrArr[i].sectionRowIndex%2==0)?"#DDEDFF":"#E8F3FF"; 
		      PtrArr[i].onclick = function(){
		        if(this.onclicked != "1"){ 
			      	if(oldTrObj!=null && oldTrObj!=""){
			      		oldTrObj.style.backgroundColor = (oldTrObj.sectionRowIndex%2==0)?"#DDEDFF":"#E8F3FF"; ;
			      		oldTrObj.onclicked = "0";
			      	}
			      	oldTrObj = this;
			        this.onclicked = "1";
			        this.style.backgroundColor = "#ffffff";
			        eval(this.getAttribute("funcstr"));//将方法字符串转化为方法

	
			    }else{
			    	eval(this.getAttribute("funcstr"));//将方法字符串转化为方法

	
			    }
		      };
			  PtrArr[i].onmouseout = function(){
			      if(this.onclicked != "1"){
			      	this.style.backgroundColor = (this.sectionRowIndex%2==0)?"#DDEDFF":"#E8F3FF";
			      } 
		       };
			  PtrArr[i].onmouseover = function(){
			      if(this.onclicked != "1"){
			      	this.style.backgroundColor = "#ffffff";
			      }
		       };
		  }
	}
}
//tablecolor.js end
//hightLight.js
function hightLight(str,style,fontColor){
	/*var bookmark;
	var range ;
	if(document.createRange){
		range = document.createRange();
	}else{
		range = document.body.createTextRange();
		bookmark = range.getBookmark();
	}
	if(range.findText){
		console.log("ss");
		range.collapse(true);
		range.moveToBookmark(bookmark);
		while(range.findText(str)){
			range.pasteHTML(range.text.fontcolor(fontColor));
		}
	}else{
		var s,n;
		s = window.getSelection();
		s.collapse(document.body,0);
		while(window.find(str)){
			var n = document.createElement("SPAN");
			n.style.cssText=style;
			s.getRangeAt(0).surroundContents(n);
		}
	}*/
	var innerHighlight = function(node, pat) {
	  var skip = 0;
	  if (node.nodeType == 3) {
	   var pos = node.data.toUpperCase().indexOf(pat);
	   if (pos >= 0) {
	    var spannode = document.createElement('span');
	    //spannode.className = 'highlight';
	    //spannode.style = style;
	    spannode.style.color="red"
	    var middlebit = node.splitText(pos);
	    var endbit = middlebit.splitText(pat.length);
	    var middleclone = middlebit.cloneNode(true);
	    spannode.appendChild(middleclone);
	    middlebit.parentNode.replaceChild(spannode, middlebit);
	    skip = 1;
	   }
	  }
	  else if (node.nodeType == 1 && node.childNodes && !/(script|style)/i.test(node.tagName)) {
	   for (var i = 0; i < node.childNodes.length; ++i) {
	    i += innerHighlight(node.childNodes[i], pat);
	   }
	  }
	  return skip;
	 }
	innerHighlight(document.body, str.toUpperCase());
}
function innerHighlight(pat, style, fontColor){
	var node = document.body;
	console.log(pat);
	 var skip = 0;
	  if (node.nodeType == 3) {
		   var pos = node.data.toUpperCase().indexOf(pat);
		   if (pos >= 0) {
		    var spannode = document.createElement('span');
		    //spannode.className = 'highlight';
		    spannode.style = style;
		    var middlebit = node.splitText(pos);
		    var endbit = middlebit.splitText(pat.length);
		    var middleclone = middlebit.cloneNode(true);
		    spannode.appendChild(middleclone);
		    middlebit.parentNode.replaceChild(spannode, middlebit);
		    skip = 1;
		   }
	  }
	  else if (node.nodeType == 1 && node.childNodes && !/(script|style)/i.test(node.tagName)) {
		   for (var i = 0; i < node.childNodes.length; ++i) {
		    i += innerHighlight(node.childNodes[i], pat);
		   }
	  }
	  return skip;
	 }
function sethight(){
	try{
		var searchStr = parent.document.getElementById("textfield").value;
		var def_v = "同城交流|经纪天地|业务知识|商家信息|公司信息|本店信息|本人发帖|本人回帖|请键入关键字";
		if(def_v.indexOf(searchStr)>-1)return;
		setTimeout(hightLight(searchStr,"border:0px;color:#ff0000","#ff0000"),100);
	}catch(e){}
}
//hightLight.js end
//showmsg.js
Animation = {fadeIn: function(id){this.fade(id, true);},fadeOut: function(id){this.fade(id, false);},fade: function(id, flag){var target = document.getElementById(id);var value = flag?0:1;var step = 0.2;if(flag)target.style.display= "";(function(){target.style.opacity = value;target.style.filter = 'alpha(opacity=' + (value*100) + ')';target.style.opacity=value;var fade_timer = null;if (flag) {value+=step;if (value <= 1) {fade_timer = setTimeout(arguments.callee, 10);}else{window.clearTimeout(fade_timer);}}else {value-=step;if (value >= 0) {fade_timer = setTimeout(arguments.callee, 10);}else{window.clearTimeout(fade_timer);target.style.display="none";target.style.opacity = 1;target.style.filter = 'alpha(opacity=100)';}}})();}}
function showTipsMsg(tip) {
	var _tips = document.getElementById("myDefTip");
	var contentBox = document.getElementById("contentBox");
	var argArr = arguments;
	var callback = argArr.length>1?argArr[1]:function(){};
	var timer = null;
	if (_tips == null) {
		_tips = document.createElement("div");
		_tips.id = "myDefTip";
		_tips.style.cssText = "left:0;right:0;position:absolute;font-size:12px;border:0;margin:0;padding:0;z-index:1000;overflow:hidden;";
		document.body.appendChild(_tips);
		_tips.style.display = "none";
		// 创建显示信息的容器


		if (typeof(contentBox) == "undefined" || contentBox == null) {
			contentBox = document.createElement("div");
			contentBox.setAttribute("id", "contentBox");
			contentBox.style.width = "auto";
			contentBox.style.height = "25px";
			contentBox.style.lineHeight = "20px";
			contentBox.style.margin = "0";
			contentBox.style.paddingTop = "3px";
			contentBox.style.paddingLeft = "80px";
			contentBox.style.background = "url(./images/attention.png) #fffae1 no-repeat 28px 5px";
			contentBox.style.border = "#FEAA2A 2px solid";
		}
		_tips.appendChild(contentBox);
	}
	window.onscroll = contentBox.onclick = function(){hiddenTips("myDefTip");window.onscroll=null;window.clearTimeout(timer);callback();};
	contentBox.innerHTML = "<font color=\"#ff6600\">提醒: </font>" + tip;
	_tips.style.top = document.documentElement.scrollTop+"px";
	_tips.style.width = document.body.clientWidth+"px";
	_tips.style.filter = "Alpha( Opacity=90)";
	_tips.style.display = "";
	document.body.focus();
	timer = setTimeout(function(){hiddenTips("myDefTip");window.onscroll=null;window.clearTimeout(timer);callback();}, 10000);
}
function hiddenTips(divid){
  	Animation.fadeOut(divid);
}
//showmsg.js end
