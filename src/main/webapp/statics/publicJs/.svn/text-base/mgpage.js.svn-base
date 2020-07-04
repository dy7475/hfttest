
/* 用于翻页效果
 * @author ZHL
 * @since 2015-08-17
 **/
/*
 * 主要方法：mgpage()、mgd.uppage();

1、用于初始化数据：
var mgpagert = mgpage({
	id:"pageInfo",// 用于展示分页的地方
	size:12,// 总数
	count:10,// 每页展示条数
	jump:function(page){
		
	}
});
2、用于更新页数：
mgpagert.uppage(size);
size:总页数
 */

function mgpage(mgd){
	if(!mgd)return -1;
	if(mgd.size < 1)return -2;
	if(!mgd.id)return -3;
	if(typeof(eval(mgd.jump)) != "function")return -4;
	
	mgd.obj = $("#"+mgd.id);
	mgd.obj.addClass("mgpage").attr("onselectstart","return false");

	mgd.obj.empty();
	mgd.obj.append('<div class="prev"></div>');
	mgd.obj.append('<div class="next"></div>');
	mgd.obj.append('<input type="text" class="mginput" maxlength="5" value="1">');
	mgd.obj.append('<div class="go"></div>');
	mgd.obj.append('<div class="text"></div>');
	
	mgd.p = mgd.obj.find(".prev");
	mgd.n = mgd.obj.find(".next");
	mgd.i = mgd.obj.find(".mginput");
	mgd.g = mgd.obj.find(".go");
	mgd.t = mgd.obj.find(".text");
	
	mgd.update = function(size,count){
		mgd.size = size;mgd.count = count;
		if(mgd.size == 0)return;
		mgd.page = parseInt(mgd.size / mgd.count);
		if(mgd.size % mgd.count > 0)
			mgd.page++;
		mgd.t.text('共'+mgd.page+'页，'+mgd.size+'条');
	};
	if(mgd.now) mgd.i.val(mgd.now);
	else mgd.now = 1;
	mgd.update(mgd.size,mgd.count);
	
	mgd.upshow = function(){
		if(mgd.now <= 1)mgd.p.addClass("off");
		else mgd.p.removeClass("off");
		if(mgd.now >= mgd.page)mgd.n.addClass("off");
		else mgd.n.removeClass("off");
	};
	mgd.upshow();
	mgd.mgcs = function(type){
		if(type == 1){
			if(mgd.now <= 1){mgd.p.addClass("off");return;}
			mgd.now--;
			mgd.jump(mgd.now);
		} else if(type == 2){
			if(mgd.now >= mgd.page){mgd.n.addClass("off");return;}
			mgd.now++;
			mgd.jump(mgd.now);
		} else if(type == 3){
			var ipt = parseInt(mgd.i.val());
			if(isNaN(ipt) || ipt <= 0 || ipt > mgd.page){mgd.i.val(mgd.now);return;}
			mgd.now = ipt;mgd.jump(mgd.now);
		}
		mgd.i.val(mgd.now);
		mgd.upshow();
	};
	
	mgd.p.click(function(){mgd.mgcs(1);});
	mgd.n.click(function(){mgd.mgcs(2);});
	mgd.g.click(function(){mgd.mgcs(3);});
	mgd.i.keyup(function(){
		var ipt = parseInt(mgd.i.val());
		if(isNaN(ipt) || ipt <= 0 || ipt > mgd.page)mgd.i.val(mgd.now);
	});
	return mgd;
}


