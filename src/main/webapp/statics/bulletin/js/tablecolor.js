/**
 * 表格的隔行换色,以及滑动变色和点击变色 * 奂永桥
 * "#DDEDFF":"#E8F3FF":"#FFFFFF"
 */
function initTab(tabName){
	var oldTrObj;
	var PtrArr;
	var tabId = "tabList";
	if(tabName!=null && tabName!=""){
		tabId = tabName;
	}
	if(typeof(document.getElementById(tabId))!="undefined"){
		PtrArr = document.getElementById(tabId).getElementsByTagName("tr");
	}
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
		        eval(this.funcstr);//将方法字符串转化为方法
		    }else{
		    	eval(this.funcstr);//将方法字符串转化为方法
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
initTab();