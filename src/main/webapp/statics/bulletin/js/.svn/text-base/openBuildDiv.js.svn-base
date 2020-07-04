//======== jquery.bgiframe.js ==========
;(function($){$.fn.bgIframe=$.fn.bgiframe=function(s){if($.browser.msie&&/6.0/.test(navigator.userAgent)){s=$.extend({top:'auto',left:'auto',width:'auto',height:'auto',opacity:true,src:'javascript:false;'},s||{});var prop=function(n){return n&&n.constructor==Number?n+'px':n;},html='<iframe class="bgiframe"frameborder="0"tabindex="-1"src="'+s.src+'"'+'style="display:block;position:absolute;z-index:-1;'+(s.opacity!==false?'filter:Alpha(Opacity=\'0\');':'')+'top:'+(s.top=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderTopWidth)||0)*-1)+\'px\')':prop(s.top))+';'+'left:'+(s.left=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderLeftWidth)||0)*-1)+\'px\')':prop(s.left))+';'+'width:'+(s.width=='auto'?'expression(this.parentNode.offsetWidth+\'px\')':prop(s.width))+';'+'height:'+(s.height=='auto'?'expression(this.parentNode.offsetHeight+\'px\')':prop(s.height))+';'+'"/>';return this.each(function(){if($('> iframe.bgiframe',this).length==0)this.insertBefore(document.createElement(html),this.firstChild);});}return this;};})(jQuery);
//***************IE6下Fixed定位*******************
;(function($){
  var isIE6 = ($.browser.msie && ($.browser.version == "6.0") && !$.support.style)
  	,_$html=$('html');

  // 给IE6 fixed 提供一个"不抖动的环境"
  // 只需要 html 与 body 标签其一使用背景静止定位即可让IE6下滚动条拖动元素也不会抖动

  // 注意：IE6如果 body 已经设置了背景图像静止定位后还给 html 标签设置会让 body 设置的背景静止(fixed)失效
  if (isIE6 && _$html.css('backgroundAttachment') !== 'fixed' && $('body').css('backgroundAttachment') !== 'fixed') {
      _$html.css({
			zoom: 1,// 避免偶尔出现body背景图片异常的情况

			backgroundImage: 'url(about:blank)',
			backgroundAttachment: 'fixed'
		});
  };
  $.fn.fixed = function(){
  	var elem = $(this)[0];
  	if(isIE6){
      var style = elem.style,
          dom = '(document.documentElement || document.body)',
          _left = ($(window).width()-$(this).width())/2,
          _top = ($(window).height()-$(this).height())/2;
      $(this).css("position",'absolute').css({"left":$(window).scrollLeft()+_left,"top":$(window).scrollTop()+_top});
      style.setExpression('left', 'eval(' + dom + '.scrollLeft + ' + _left + ') + "px"');
      style.setExpression('top', 'eval(' + dom + '.scrollTop + ' + _top + ') + "px"');
  	}else{
  		$(this).css({"position":'fixed',left:($(window).width()-$(this).width())/2,top:($(window).height()-$(this).height())/2});
  	}
  	return $(this);
  }
})( jQuery );

;(function($){	
$.infowin = function(title,html,w,h,cssJson){
	if($("#m_window").length==0){
		$("<div/>").attr({"id":"m_window_mask"}).css({width:$(window).width(),height:$(window).height()}).appendTo("body").fixed();
		var mw = $("<div/>").attr({"id":"m_window"}).css({left:($(window).width()-w)/2,top:($(window).height()-h)/2,width: w+4}).appendTo("body");
		$("<div/>").attr("id","m_window_contains").addClass("contains").css({width: w+2, height: h, left: 8,top:8}).appendTo(mw);
		$("<div class='topbar'><a id='m_window_closebtn' target='_self' class='closebtn' href='javascript:void(0);'></a><span id='m_window_title' class='title'>"+title+"</span></div>").appendTo("#m_window_contains");
		$("<div/>").attr("id","html_box").html(html).css({padding: 10, height: h-48, overflowY: "auto"}).appendTo("#m_window_contains");
		$("#m_window_closebtn").click(function(){$("#m_window_mask,#m_window").hide();});
	}else{
		$("#m_window_title").html(title);
		$("#html_box").html(html);
		$("#m_window").css({left:($(window).width()-w)/2,top:($(window).height()-h)/2,width: w+4});
		$("#m_window_contains").css({width: w+2, height: h});
		$("#html_box").css({height: h-48});
	}
	if(!!cssJson)$("#html_box").css(cssJson);
	$("#m_window_mask,#m_window").show();
	$("#m_window_mask").bgIframe();
	$("#m_window").fixed();
}
})( jQuery );