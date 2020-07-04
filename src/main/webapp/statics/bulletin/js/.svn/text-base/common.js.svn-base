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