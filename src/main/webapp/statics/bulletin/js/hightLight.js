function hightLight(str,style,fontColor){
	var bookmark;
	if(document.createRange){
		console.log(11);
		var range = document.createRange();
	}else{
		console.log(22);
		var range = document.body.createTextRange();
		bookmark = range.getBookmark();
	}
	if(range.findText){
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
	}
}
function addEvent(obj, type, fn){
	console.log("ssssssssssssssssssssssssssssssss");
    if (obj.attachEvent)
        obj.attachEvent('on' + type, fn);
    else
        obj.addEventListener(type, fn, false);
}
addEvent(window, "load", function(){
	console.log("初始化");
	try{
		var searchStr = parent.document.getElementById("textfield").value;
		var def_v = "同城交流|经纪天地|业务知识|商家信息|公司信息|本店信息|本人发帖|本人回帖|请键入关键字";
		if(def_v.indexOf(searchStr)>-1)return;
		setTimeout(hightLight(searchStr,"border:1px solid #8900CC;color:#ACE600","#ff0000"),1000);
	}catch(e){}
});