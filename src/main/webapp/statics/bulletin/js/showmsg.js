/**
 * 操作显示提示信息
 */
document.write("<style type=\"text/css\">");
/**
 * filter:progid:DXImageTransform.Microsoft.Shadow(color=#999999,direction=135,strength=2);
 */
document.write(".myTipCss{left:0;right:0;position:absolute;font-size:12px;border:0;margin:0;padding:0;z-index:1000;overflow:hidden;}");
document.write("</style>");
function showTipsMsg(msg) {
	showMyTips(msg);
}
function showMyTips(tip) {
	var _tips = document.getElementById("myDefTip");
	var contentBox = document.getElementById("contentBox");
	if (typeof(_tips) == "undefined" || _tips == null) {
		_tips = document.createElement("div");
		_tips.id = "myDefTip";
		_tips.className = "myTipCss";
		_tips.style.filter = "Alpha( Opacity=90)";
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
		contentBox.onclick = new Function("disdiv('myDefTip', 'close')");
		window.onscroll = new Function("disdiv('myDefTip', 'close')");
		_tips.appendChild(contentBox);
	}
	contentBox.innerHTML = "<font color=\"#ff6600\">提醒: </font>" + tip;
	_tips.style.top = document.documentElement.scrollTop+"px";
	_tips.style.width = document.body.clientWidth+"px";
	_tips.style.display = "";
	setTimeout(function(){disdiv("myDefTip", "close");}, 400000);
}
/**层的淡入淡出效果*/
var t = null ;        //函数内临时时间对象变量(作用范围：全局变量) 
function disdiv(divid,type){ 
//淡入淡出DIV层效果 
//参数说明 divid=>要执行操作的层的ID值，多个ID用","分割 type=>"open"?显示层 "close"?隐藏层 
  if(t){ 
   window.setTimeout(function(){disdiv(divid,type);},500); //使同步进行的淡化效果进入排队系统，直至上个操作完毕后 自动执行本次效果 
   return false; 
  }   
        var i = (type=="close"?1:0);    //对页面动作进行定义 
        var s = 0.1;        //保留数据，请勿修改 
        var speed = 0.1       //默认渐隐的速度 0.2 (数值越小变化越慢越精细，同时占用系统资源也更多) 
        var tmpo ;
        var tmpindex = 0 ;
        //----------------开始对divid数列进行处理以及多个对象赋值---------------- 
        var o = new Array(); 
        if(divid.indexOf(",")==-1){ 
         var dividArray = [divid]; 
        }else{ 
         var dividArray = divid.split(","); 
        } 
        //判断是否重复执行并对符合要求的DIV进行数组化整合 
        for(j=0;j<dividArray.length;j++){ 
         tmpo = window.document.all[dividArray[j]] 
         if((type=="open" && tmpo.style.display!="") || (type=="close" && tmpo.style.display!="none")){ 
          o[tmpindex] = window.document.all[dividArray[j]] 
          tmpindex++ 
         }           
        } 
        //----------------结束对divid数列进行处理以及多个对象赋值---------------- 
  if(o.length==0) return false;  //如果所有参数元素都重复执行，则直接退出，不占用系统资源 
   
        for(j=0;j<o.length;j++){ 
         if(type=="open"){o[j].style.display=""} //首先把层显示出来 
        } 
        t=setInterval(function(){ 
   if((i<0 && type=="close") || (i>1 && type=="open")){ 
    //判断结束start 
    window.clearInterval(t); 
    for(j=0;j<o.length;j++){ 
     o[j].filters[0].opacity = (type=="close"?0:100) 
     if(type=="close"){o[j].style.display="none";o[j].filters[0].opacity=90;} //消失后把层隐藏起来 
    } 
    t=null; 
    return false; 
    //判断结束end 
   }else{ 
    //计算层的透明度 
      i+=s; s=i<0?speed:(i>1?-speed:s); 
      for(j=0;j<o.length;j++){ 
        if(o[j].filters) o[j].filters[0].opacity=i*100; 
        else o[j].style.opacity=i; 
       } 
      }      
  },1); 
  }