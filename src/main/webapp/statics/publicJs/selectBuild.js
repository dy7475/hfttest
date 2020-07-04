/**
 * 搜索楼盘
 * @param obj
 * @param event
 * @param e
 */
function getBuild(obj,idInput,textInput,fun){
	try{
		if(event.keyCode==13 || event.keyCode==38 || event.keyCode==40){
			return;
		}
		var buildValue = $(obj).val();
		if($.trim(buildValue) == ""){
	 		return;
	 	}
		buildValue = encodeURI(encodeURI(buildValue));
		var param = new Array();
		param.push("PARA="+buildValue);
		$.ajax({
			url:getRootPath() + "/web/buildBidding/buildInfoList",
		    type:"POST",
		    data: param.join("&"),
		    dataType:"json",
		    success:function(retStr){
		    	var top = $(obj).offset().top + 24;
				var left = $(obj).offset().left - 4;
		    	var datas = retStr["DATA"];
		    	showBuildList(top, left, datas,obj);
		    }
		});
	}catch(e){}
}
/**
 * 显示楼盘信息
 * @param data  数据
 * @param top   top位置
 * @param left  左边位置
 * @param idInput  选择事件Id 显示 input对象
 * @param textInput 选择时间text 显示input对象
 * @param fun 绑定一个function 参数为选中的记录[JSON]
 */
function showBuildList(top, left, data,obj){
	var bNameDiv = null;
	if($("#b_name").length > 0){
		bNameDiv = $("#b_name");
	}else{
		bNameDiv = document.createElement("div")
		bNameDiv.style.cssText = 'text-align: left;margin: 0;padding: 0;font-family: "宋体",arail;font-size: 12px;line-height: 22px;border:1px solid #ccc;background:#ffffff;border-top:none;position:absolute;height:auto;width: 75px;z-index: 9999;';
		bNameDiv.id = "b_name";
		bNameDiv.style.cssTest= "";
		$("body").append(bNameDiv);
	}
	
	$(bNameDiv).html("");
	if(!!data && $.isArray(data)){
		var ul = document.createElement("ul");
		ul.style.cssText = "cursor: pointer;width: 99%;display:block;margin-left: -39px;";
		var n = 0;
		for(var i=0; i<data.length,i<5; i++){
			var li = document.createElement("li");
			li.style.cssText = "overflow: hidden;width: 99%;height:22px;";
			li.id = "d"+i;
			li.setAttribute("index",i);
			li.onmouseenter = function(){
				this.style.backgroundColor='rgb(202, 202, 255)';
				if(n>0){
					document.getElementById("d"+(n-1)).style.backgroundColor='#FFFFFF';
				}
				n=parseInt(this.id.substring(1,2))+1;
			}
			li.onmouseover = function(event){
				if (isMouseLeaveOrEnter(event,this)) {
					this.style.backgroundColor='#ECF9FF';
					if(n>0){
						document.getElementById("d"+(n-1)).style.backgroundColor='#FFFFFF';
					}
					n = parseInt(this.id.substring(1,2))+1;
				}
			};
			li.onmouseleave = function(){this.style.backgroundColor='#FFFFFF'};
			li.onclick = function(){
				console.log("sss");
				$(obj).val($.trim(this.children[0].innerHTML));
				console.log($.trim(this.children[0].innerHTML));
				$(bNameDiv).hide();
			};
			
			var buildAddr = data[i].BUILD_ADDR;
			var biuldReg = data[i].REG_NAME;
			var buildId = data[i].BUILD_ID;
			var buildName = data[i].BUILD_NAME;
			
//			var addrSpan = document.createElement("span");
//			addrSpan.style.cssText = "cursor: pointer;margin-left: 8px;";
//			addrSpan.innerHTML = buildAddr;
//			var regSpan = document.createElement("span");
//			regSpan.style.cssText = "cursor: pointer;margin-left: 8px;";
//			regSpan.innerHTML = biuldReg;
//			var idSpan = document.createElement("span");
//			idSpan.style.cssText = "display:none";
//			idSpan.innerHTML = buildId;
			var nameSpan = document.createElement("span");
			nameSpan.style.cssText = "color: #e95f09;cursor: pointer;margin-left: 8px;";
			nameSpan.innerHTML = buildName;
			li.appendChild(nameSpan);
//			li.appendChild(regSpan);
//			li.appendChild(addrSpan);
//			li.appendChild(idSpan);
			ul.appendChild(li);
		}
		$(bNameDiv).append(ul);
		$(bNameDiv).css({left:left+"px", top:top+"px"}).show();
	}
}

function isMouseLeaveOrEnter(e, handler) {
	try{
	    if (e.type != 'mouseout' && e.type != 'mouseover') return false;  
	    var reltg = e.relatedTarget ? e.relatedTarget : e.type == 'mouseout' ? e.toElement : e.fromElement;
	    while (reltg && reltg != handler){
	        reltg = reltg.parentNode;
	    }
	    return (reltg != handler);  
	}catch(e){}
}


function setCloseObj(obj) {
    obj.contentWindow.closeObj = $(obj).parent().prev().children()[0];
}