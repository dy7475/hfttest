/******************************************************************
 * 客服列表
 * 奂永桥

 * 2010-1-6
 ******************************************************************/
//全局变量
var online=new Array();//接收用户的QQ在线状态，必须的

var cur = 0;
var QQlist= new Array();//设置客服信息
var thisSeeHeiht = getBodyHeight();
var isotherhide = ((thisSeeHeiht>510)?false:true);		//根据页面的高度判断是否显示售前服务和售后服务两组的客服

var kfboxh = isotherhide?380:315;
var kfboxh1=kfboxh;
var hftKF_box;
var kfMenuBox ;
var kfMenuCenter ;
var tips; 
var theTop = 80;
var old = theTop;
var dropmsg;
var absouluteUrl = (function() {
    var elements = document.getElementsByTagName('script');
    for (var i = 0, len = elements.length; i < len; i++) {
        if (elements[i].src && elements[i].src.match(/hfku[\w\-\.]*\.js/)) {
            return elements[i].src.substring(0, elements[i].src.lastIndexOf('/') + 1);
        }
    }
    return "";
})();
var webDomain = "hftsoft.cn";
var qqHref1 = "http://wpa.qq.com/msgrd?V=1&Uin=****&Exe=QQ&Site="+webDomain+"&Menu=No";
var qqHref2 = "tencent://message/?uin=***&Site="+webDomain+"&Menu=yes";
var kfMenuMini;
/*****以下为动画参数******/
var InterTime = 1;
var maxWidth=-1;
var minWidth=-131;
var numInter = 8;
var BigInter ;
var SmallInter ;
var hftKF_box_left = minWidth;


String.prototype.Trim = function(){ 
	return this.replace(/(^\s*)|(\s*$)/g, ""); 
} 
/**
 * 动态加载js文件或者css文件
 */
function loadjscssfile(filename, filetype) {
	var fileref;
    if (filetype == "js") {
        fileref = document.createElement('script');
        fileref.setAttribute("type", "text/javascript");
        fileref.setAttribute("src", filename)
    } else if (filetype == "css") {
        fileref = document.createElement("link");
        fileref.setAttribute("rel", "stylesheet");
        fileref.setAttribute("type", "text/css");
        fileref.setAttribute("href", filename)
    }
    if (typeof fileref != "undefined") document.getElementsByTagName("head")[0].appendChild(fileref);
}
function createHTMLNode(tagName){
	return document.createElement(tagName);
}
function getBodyHeight(){
	return ((document.documentElement.clientHeight==0)?document.body.clientHeight:document.documentElement.clientHeight);
}

function initKfMenu(){
		hftKF_box = createHTMLNode("div");	//创建大容器

		hftKF_box.setAttribute("id","hftKF_box");
		hftKF_box.style.left = hftKF_box_left+"px";
		
		kfMenuBox = createHTMLNode("div");	//创建客服列表的容器

		kfMenuBox.setAttribute("id","kfbox");
		
		var kfMenuTop = createHTMLNode("div");	//创建客服列表头部
		kfMenuTop.setAttribute("id","kftop");
		kfMenuTop.innerHTML = "<img id=\"miniBtn\" onclick=\"javascript:dolookmenu()\" src=\""+absouluteUrl+"image/zxhua-1.gif\" border=\"0\" />";
		kfMenuBox.appendChild(kfMenuTop);
		
		kfMenuCenter = createHTMLNode("div");//创建客服列表主体
		kfMenuCenter.setAttribute("id","kfcenter");
		setKefuList(kfMenuCenter);
		kfMenuBox.appendChild(kfMenuCenter);
		
		kfMenuChgBox = createHTMLNode("div");//创建切换图片容器
		kfMenuChgBox.setAttribute("id","kfChgBox");
		kfMenuChgBox.innerHTML = "<img id=\"kfBtnImg\" src=\""+absouluteUrl+"image/right-1.gif\"/>";
		kfMenuBox.appendChild(kfMenuChgBox);
		
		var kfMenuAdv = createHTMLNode("div");	//创建客服列表图片容器
		kfMenuAdv.setAttribute("id","kfadv");
		kfMenuAdv.innerHTML = "<img src=\""+absouluteUrl+"image/ad.png\" style='margin-left:5px;'/>";
		kfMenuBox.appendChild(kfMenuAdv);
		
		var kfMenuBottom = createHTMLNode("div");
		kfMenuBottom.setAttribute("id","kfbottom");
		kfMenuBox.appendChild(kfMenuBottom);
		
		hftKF_box.appendChild(kfMenuBox);
		
		kfMenuMini = createHTMLNode("div");	//创建缩小显示图标的容器

		kfMenuMini.setAttribute("id","kfMenuMini");
		kfMenuMini.innerHTML = "开启客服";
		kfMenuMini.onclick = new Function("showMaxandMin('max')");
		hftKF_box.appendChild(kfMenuMini);
		
		document.body.appendChild(hftKF_box);//将客服列表添加到页面
		
		var iframeObj = document.createElement("iframe");
		iframeObj.setAttribute("id","kefuIframe");
		iframeObj.style.display = "none";
		document.body.appendChild(iframeObj);
		
		showMaxandMin("min");
}

function getsendQQstr(qqarrlist){
	var qqstring="";
	for(var j=0;j<qqarrlist.length;j++){
		if(qqarrlist.length>=1)
			var qqarritem=qqarrlist[j][1];
		else
			continue;
		var qqnewarr=qqarritem.split("|");
		for(var jj=0;jj<qqnewarr.length;jj++){
			if(qqnewarr[jj].indexOf(",")>=0){
				var qqnewarr1=qqnewarr[jj].split(",");
				if(qqnewarr1.length>=2){
					if(!isNaN(qqnewarr1[0])){	
						qqstring = qqstring + qqnewarr1[0].toString().Trim() + ":";
					}
				}
			}
		}
		
	}
	return qqstring;
}
function getKFStatus(){
	QQlist[0] = new Array("售前咨询",
		"404246852,曾　旺|"+
		"1172235020,许黎明|"+
		"489474015,张廷瑜|"+
		"813417204,苏　伟");//第一组

	QQlist[1] = new Array("售后客服",	
		"836383189,Miss贺|"+
		"1245113292,Miss王|"+
		"1244011976,Miss翁");//第二组

	QQlist[2] = new Array("<span title='投诉建议'>投诉建议</span>",	
	"1282119371,Mr 张|"+
	"461552543,Miss李");
	document.write("<scr" + "ipt src=\"http://webpresence.qq.com/getonline?Type=1&"+ getsendQQstr(QQlist) +"\"></scr" + "ipt>");
}

function setKefuList(obj){
	var echostr = "";
	for (var i=0;i<QQlist.length;i++ ){
		var title = QQlist[i][0].Trim();
		var itemlist = QQlist[i][1].split("|");
		echostr += "<h1><a hidefocus href=\"javascript:void(-1);\" onClick=\"showandhide("+ i +")\">"+ title + "</a></h1>";
		
		if(i==0 || (i==1 && !isotherhide))
			echostr += "<table id=\"kfGroup"+ i +"\" border=\"0\" cellpadding=\"1\" cellspacing=\"0\">";
		else
			echostr += "<table id=\"kfGroup"+ i +"\" border=\"0\" cellpadding=\"1\" cellspacing=\"0\" style=\"display:none\">";
		
		for (var j=0;j<itemlist.length ;j++){
		   var qqitem=itemlist[j];
		   if(qqitem.indexOf(",")>=0){
				echostr += "<tr>";
			   var qqitemArr = qqitem.split(",");
			   var qqnum = qqitemArr[0].Trim();
			   var qqname = qqitemArr[1].Trim();
			   var qq_Href = qqHref2.replace(/\*{3}/g,qqnum);
			   
			   if(isNaN(qqnum)) 
					continue;
			   if (online[cur]==0){
					echostr += "<td><a href=\"javascript:void(-1);\" onclick=\"showQQ('"+qq_Href+"')\">"+ qqname + "</a></td>";
					echostr += "<td>";
					echostr += "<a href=\"javascript:void(-1);\" onclick=\"showQQ('"+qq_Href+"')\"><img src=\""+absouluteUrl+"image/QQ.gif\" width=\"14\" height=\"15\" border=\"0\" class=\"img\" /></a> ";
					echostr += "<a href=\"javascript:void(-1);\" onclick=\"showKefuWindow();return false;\"><img src=\""+absouluteUrl+"image/zxian-online.gif\" width=\"37\" height=\"19\" border=\"0\" /></a>";
					echostr += "</td>";
			   }else{
					echostr += "<td><a href=\"javascript:void(-1);\" onclick=\"showQQ('"+qq_Href+"')\">"+ qqname + "</a></td>";
					echostr += "<td>";
					echostr += "<a href=\"javascript:void(-1);\" onclick=\"showQQ('"+qq_Href+"')\"><img src=\""+absouluteUrl+"image/QQ-online.gif\" width=\"14\" height=\"15\" border=\"0\" class=\"img\" /></a> ";
					echostr += "<a href=\"javascript:void(-1);\" onclick=\"showKefuWindow();return false;\"><img src=\""+absouluteUrl+"image/zxian-online.gif\" width=\"37\" height=\"19\" border=\"0\" /></a>";
					echostr += "</td>";
			   }
			   echostr += "</tr>";
			   cur++;
			}
		}
		echostr +="</table>";
	}
	obj.innerHTML = echostr;
}

function showQQ(url){
	var kefuIframe = document.getElementById("kefuIframe");
	kefuIframe.src = url + "&mtyefmupn"+new Date().getMilliseconds()+"="+new Date();
}

function initFloatTips(){
	tips = document.getElementById('hftKF_box');
	moveTips();
}

function moveTips(){
	clearTimeout(dropmsg);
 	  var tt=50;
	  if (window.innerHeight){
		  pos = window.pageYOffset;
	  }else if (document.documentElement && document.documentElement.scrollTop) {
		 pos = document.documentElement.scrollTop;
	  }else if (document.body) {
	    pos = document.body.scrollTop;
	  }
	  pos = pos-tips.offsetTop+theTop;
	  pos = tips.offsetTop+pos/5; 
	  if (pos < theTop){
		 pos = theTop;
	  }
	  if (pos!=old && thisSeeHeiht==getBodyHeight()) {
		 tips.style.top = pos+"px";
		 tt = 10; 
	  }
	  old = pos;
	  dropmsg = setTimeout(moveTips,tt);
}
function dolookmenu(v){
	if(v=="close"){
		hftKF_box.style.display = "none";
	}else{
		if(kfMenuBox.style.display=="none"){//**
			showMaxandMin("max");
		}else{
			showMaxandMin("min");
		}
	}
}
/**
 * 显示或者隐藏组信息
 */
function showandhide(ii) {
	var alli=QQlist.length;//总项数,以0开始

	for(var c=0;c<alli;c++){
		var doobj=document.getElementById("kfGroup"+c);
		doobj.style.display = "none";
	}
	if(isotherhide){
		document.getElementById("kfGroup"+ii).style.display="";
	}else if(ii==1 || ii==0){
		document.getElementById("kfGroup"+1).style.display="";
		document.getElementById("kfGroup"+0).style.display="";
	}else{
		document.getElementById("kfGroup"+ii).style.display="";
	}
}
function showMaxandMin(type){
	kfMenuMini.style.display = "none";	//这个暂时不用，隐藏

	if(type=="max"){
		document.getElementById("kfbox").style.display = "";
		document.getElementById("kfBtnImg").onclick = new Function("showMaxandMin('min')");
		/**********以下为弹出动画**************/
		document.getElementById("kfBtnImg").src = absouluteUrl+"image/right-1.gif";
		toBig();
	}else{
		document.getElementById("kfBtnImg").onclick = new Function("showMaxandMin('max')");
		kfMenuMini.onclick = new Function("showMaxandMin('max')");
		/**********以下为收缩动画**************/
		//当缩小完成后，显示小图标
		document.getElementById("kfBtnImg").src = absouluteUrl+"image/right-2.gif";
		toSmall();
	}
}
function showQQWindow(src){
	showWindow(src);
}
function showKefuWindow(){
	showWindow("./kefu/kefu_dialog.html");
}
function showWindow(src){
	var width=700;
	var height=460;
	var x = parseInt(screen.width - width) / 2;
	var y = parseInt(screen.height - height)/ 2;
	if(src.indexOf("?")!=-1){
		src = src +"&mtyefmupn"+new Date().getMilliseconds()+"="+Math.random();
	}else{
		src = src +"?mtyefmupn"+new Date().getMilliseconds()+"="+Math.random();
	}
	window.showModalDialog(src, window, "dialogLeft="+ x +"px; dialogTop="+ y +"px; dialogWidth="+ width +"px; dialogHeight="+ height +"px; status=no; help=no; scroll=no; resizable=no");
}
/******************动画函数开始***************************/
function Big(){
	if(parseInt(hftKF_box.style.left)<maxWidth){
		hftKF_box_left = parseInt(hftKF_box.style.left);
		hftKF_box_left += numInter;	
		hftKF_box.style.left = hftKF_box_left+"px";
		if(hftKF_box_left >= maxWidth){
			hftKF_box.style.left = maxWidth+"px";
			clearInterval(BigInter);
		}
	}
}
function toBig(){
	clearInterval(SmallInter);
	clearInterval(BigInter);
	BigInter = setInterval(Big,InterTime);
}
function Small(){
	if(parseInt(hftKF_box.style.left)>minWidth)	{
		hftKF_box_left = parseInt(hftKF_box.style.left);
		hftKF_box_left -= numInter;
		hftKF_box.style.left=hftKF_box_left+"px";
		if(hftKF_box_left<=minWidth){
			hftKF_box.style.left = minWidth+"px";
			clearInterval(SmallInter);
		}
	}//alert('small');
}
function toSmall(){
	clearInterval(SmallInter);
	clearInterval(BigInter);
	SmallInter = setInterval(Small,InterTime);
}
/******************动画函数结束***************************/


loadjscssfile(absouluteUrl+"/hfkfMenu.css?mtyefmupn"+new Date().getMilliseconds()+"="+new Date().getMilliseconds(),"css"); 		//加载css样式
getKFStatus();//调用，获得客服的在线状态

setTimeout(delay,2000);//防止QQ状态未获得前初始化页面
function delay(){
	initKfMenu();//初始化HTML代码
	initFloatTips();
}


