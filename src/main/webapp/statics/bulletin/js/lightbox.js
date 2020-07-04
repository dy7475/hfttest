var lightbox ={
style:'#lightbox h3{height:30px;line-height:30px;color:#5A6478;text-indent:10px;background:url(/hftWebService/fafunv2/images/site_setting.png) repeat-x 0 -25px;margin:0}#lightbox h3 .close{width:26px;height:18px;display:block;position:absolute;top:0;right:12px;background:url(/hftWebService/fafunv2/images/site_setting.png) 0 -96px;cursor:pointer}#lightbox h3 .close:hover{background-position:0 -122px}',
oDiv:null,
oShad:null,
oMask:null,
oTitle:null,
oCont:null,
oWin:null,
oDoc:null,
callback:null,
init:function(_win){
	if(this.oDiv && this.oDiv[0]) return;
	this.oWin = _win instanceof Window ? _win : window;
	this.oDoc = $(this.oWin.document);
	this.oWin = $(this.oWin);
	var oBody = this.oDoc.find('body');
	this.oDiv = this.oDoc.find("#lightbox");
	if(this.oDiv && this.oDiv[0]){	//该页面已经创建过
		this.oTitle = this.oDiv.find('#lightbox_title');
		this.oCont = this.oDiv.find('#lightbox_cont');
		this.oShad = oBody.find("#lightbox_shadow");
		this.oMask = oBody.find("#lightbox_mask");
	}else{
		var oStyle = this.oDoc.find("style:eq(0)");
		if(oStyle[0]){
			oStyle.text(oStyle.text() + this.style);
		}else{
			this.oDoc.find('head').append("<style type='text/css'>"+this.style+"</style>");
		}
		oBody.append("<div id='lightbox' style='position:fixed;z-index:2500;background-color:#fff;border:1px solid #646464;overflow:hidden;display:none'></div>");
		this.oDiv=oBody.find("#lightbox")
			.html("<h3><span id='lightbox_title'></span><span class='close'></span></h3><div id='lightbox_cont'></div>");
		this.oTitle = this.oDiv.find('#lightbox_title');
		this.oCont = this.oDiv.find('#lightbox_cont');
		oBody.append("<div id='lightbox_shadow' style='position:fixed;z-index:2499;background-color:gray;opacity:0.40;-moz-border-radius:5px;display:none'></div>");
		this.oShad = oBody.find("#lightbox_shadow");
		oBody.append("<div id='lightbox_mask' style='position:fixed;top:0px;left:0px;z-index:2498;width:100%;height:100%;display:none'></div>");
				//background-color:black;opacity:0.1;
		this.oMask = oBody.find("#lightbox_mask");
	}
	
	var instance = this;
	this.oDoc.delegate('.close', 'click', function(){
		instance.close();
	});
	
	$(window).unload(function(){
		instance.oDoc.undelegate();
	});
	
},
showUrl:function(url, title, w, h, fuc){
	this.callback = fuc;
	this.init();
	this.oCont.html("<iframe id='lightbox_iframe' src='"+url+"' width='100%' height='"+(h-30)+"px' frameborder='0' style='overflow-x:hidden;overflow-y:auto;padding:0;margin:0'></iframe>");
	this.oDiv.height(h).width(w);
	this.oTitle.text(title);
	this._center();
},
showDiv:function(text, title, w, h, fuc){
	this.callback = fuc;
	this.init();
	this.oDiv.height(h).width(w);
	this.oCont.html(text);
	this.oTitle.text(title);
	this._center();
},
close:function(){
	this.oDiv.hide();
	this.oShad.hide();
	this.oMask.hide();
	var o = this.oCont.find('iframe');
	if(o && o[0]){
		try{o[0].src = 'about:blank';}catch(e){}
		try{o.src = 'about:blank';}catch(e){}
	}
//	this.oCont.html('');
	if(this.callback){
		this.callback();
	}
},
_center:function(){
	var top = (this.oWin.height() - this.oDiv.height())/2;
	var left = (this.oWin.width() - this.oDiv.width())/2;
	var scrollTop = this.oDoc.scrollTop();
	var scrollLeft = this.oDoc.scrollLeft();
	this.oDiv.css({'top':(top + scrollTop),'left':(left + scrollLeft)});
	
	this.oShad.height(this.oDiv.height()+16).width(this.oDiv.width()+16);
	this.oShad.css({'top':(top + scrollTop - 7), 'left':(left + scrollLeft - 7)});
	
	this.oDiv.show();
	this.oShad.show();
	this.oMask.show();
}
};
