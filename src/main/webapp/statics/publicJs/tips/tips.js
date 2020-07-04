/**
 * 提示信息 hyq 2011-11-23
 * 参数1：tips，显示文字
 * 参数2：type，提示框类型（normal，info，warm，error）
 * 参数3：callback，回调函数
 * 参数4：ex_left，排除左边的宽度
 * 参数5：ex_top，排除上边的高度
 */
Animation = {fadeIn: function(id){this.fade(id, true);},fadeOut: function(id){this.fade(id, false);},fade: function(id, flag){var target = document.getElementById(id);var value = flag?0:1;var step = 0.2;if(flag)target.style.display= "";(function(){target.style.opacity = value;target.style.filter = 'alpha(opacity=' + (value*100) + ')';var fade_timer = null;if (flag) {value+=step;if (value <= 1) {fade_timer = setTimeout(arguments.callee, 10);}else{window.clearTimeout(fade_timer);}}else {value-=step;if (value >= 0) {fade_timer = setTimeout(arguments.callee, 10);}else{window.clearTimeout(fade_timer);target.style.display="none";target.style.opacity = 1;target.style.filter = 'alpha(opacity=100)';}}})();}}
function showTips(tips) {
	var tip_wrap_id = "tip_wrap";
	var tip_container_id = "tip_container";
	var _wrap = document.getElementById(tip_wrap_id);
	var htmlArr = new Array();
	var argArr = arguments;
	var type = argArr.length>1?argArr[1]:"normal";
	var callback = argArr.length>2?argArr[2]:function(){
	var timer = setTimeout(function(){hiddenTips(tip_wrap_id);}, 2000);
	window.onscroll = _tips.onclick = function(){document.getElementById(tip_wrap_id).style.display = "none";window.onscroll=null;window.clearTimeout(timer)};};
	var ex_width = argArr.length>3?argArr[3]:0;//排除左边宽度
	var ex_height = argArr.length>4?argArr[4]:0;//排除上边高度
	if (typeof(_wrap) == "undefined" || _wrap == null) {
		_wrap = document.createElement("div");
		_wrap.id = tip_wrap_id;
		//_wrap.style.filter = "Alpha(Opacity=100)";
		document.body.appendChild(_wrap);
	}else{
		_wrap.innerHTML = "";
	}
	_wrap.alpha = 100;
	_wrap.style.opacity = 1;
	_wrap.style.filter = 'alpha(opacity=100)';
	_wrap.style.display = "none";
	var _tips = document.createElement("div");
	_tips.id = tip_container_id;
	_wrap.appendChild(_tips);
	_tips.className = "tips_box "+type;
	htmlArr.push("	<div class='leftpart'>&nbsp;</div>");
	htmlArr.push("	<div class='rightpart'>&nbsp;</div>");
	htmlArr.push("	<div class='centerpart'>");
	if(type=='normal')htmlArr.push(" <div class='loading'>&nbsp;</div>");
	htmlArr.push("		<span id='tips_txt'>"+tips+"</span></div>");
	htmlArr.push("	</div>");
	_tips.innerHTML = htmlArr.join("");
	var tipsW = 200;
	if(tips.length>12){
		tipsW = 200+(tips.length-12)*18;
		_tips.style.width = tipsW + "px";
	}
	var leftPX = parseInt(document.documentElement.clientWidth - tipsW)/ 2;
	leftPX += (!isNaN(ex_width)?ex_width/2:0);
	var topPX = parseInt(document.documentElement.clientHeight - 52)/ 2;
	topPX += document.documentElement.scrollTop + (!isNaN(ex_height)?ex_height/2:0);
	_tips.style.marginLeft = leftPX+"px";
	_wrap.style.top = topPX+"px";
	_wrap.style.width = document.documentElement.clientWidth+"px";
	_wrap.style.display = "";
	callback();
}
function hiddenTips(divid){
  	Animation.fadeOut(divid);
}