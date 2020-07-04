<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>好房通户型图工具</title>
</head>
<script src="../common/jquery-2.1.3.min.js" type="text/javascript"></script>
<style>
html,body{width: 100%;height: 100%;margin: 0;padding: 0;overflow: hidden;}
#photosDiv::-webkit-scrollbar {width: 8px;border-radius: 6px;}
#photosDiv::-webkit-scrollbar-track {background-color: #D0D6DB;}
#photosDiv::-webkit-scrollbar-thumb {background-color: #A8AFB3;border-radius: 6px;}
#photosDiv::-webkit-scrollbar-thumb:hover {background-color: #8B8A8A;}
#kujialeIframe{width: 100%;height: 100%;border: 0;position: absolute;top: 0;left: 0;}
#kujialeOptionIframe{width: 100%;height: 50%;border: 0;position: relative;top: 0;left: 0;}
#userOption{display: none;position: absolute;top: 0px;left: 0px;width: 250px;height: 34px;background-color: transparent; padding-top: 7px;padding-left: 10px;}
#userOption input{border-radius: 3px; border: 0; padding: 7px 6px;}
#searchInput{width: 130px;}
#searchPage{width: 100%;height: 100%;background-color: #fff; position: absolute; top: 0; right: 0;display: none;border-left: 1px solid #ccc;}
#closeSearchDiv{float:right;width: 70px; height: 28px;margin: 8px 20px 0 0;}
.search-title{font-weight: bold;font-size: 20px;margin: 0;padding: 12px;float: left;}
.photos-ul{padding: 0;list-style:none;}
.photos-ul li{width: 19%;height: 175px;float: left;position: relative;margin-top: 10px;}
.photos-ul li .inn-div{width: 150px;}
.photos-ul li img{width: 150px;height: 150px;border-radius: 3px;cursor: pointer;}
.photos-ul li .inn-div:hover img{box-shadow: 0px 0px 10px #7DC4F8 !important;}
.photos-ul li span{display:none;position: absolute;cursor: pointer;border-top-left-radius: 2px;float:left;margin:130px 0 0 -60px; color:#fff; background-color: rgba(150, 150, 150,0.6);width: 60px;padding: 3px 0;text-align: center;font-size: 13px;}
.photos-ul li .inn-div:hover span{display: inline-block;}
.photos-ul li p{padding: 0;margin: 0;text-align: center;}
#closePhotoShow{position: absolute;top: 0;right: 0;font-size: 30px;cursor: pointer;}
#closePhotoShow:hover{color: #7DC4F8;}
#photoShowDiv{position:absolute;top:50%;left: 50%;display: none;}
#photoShowDiv img{width: 720px;height: 540px;}
#photoShowBg{background-color: rgba(0, 0, 0, 0.7);position:absolute;top:0;left: 0;display: none;}
#photosDiv{overflow-x: hidden;overflow-y: auto;padding-left: 10px;padding-bottom: 10px;}
.searchHead{height: 45px;border-bottom: 1px solid #ccc;}
.pageInfoDiv{height: 30px;background-color: #EFF5F9;border-top: 1px solid #ccc;padding-right: 20px;padding-top: 5px;}
.pageInfoDiv span{font-size: 13px;color: #444;cursor: pointer;margin-left: 3px;}
.pageInfoDiv span.invalid{color: #888;cursor: auto;}
.pageInfoDiv span:hover{color: #7DC4F8;}
.pageInfoDiv span.invalid:hover{color: #888 !important;}
#noDataImg{margin: 30px 0 0 45%;}
</style>
<body onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false" onmouseup="return false">
	<iframe id="kujialeIframe" src="${KJL_URL}"></iframe>
	<div id="userOption">
		<input type="text" id="searchInput">
		<input type="button" value="搜户型图" onclick="showSearchHouseDiv();">
	</div>
	<div id="searchPage">
		<div class="searchHead">
			<span class="search-title">户型图库</span>
			<input type="button" id="closeSearchDiv" value="关闭" onclick="closeSearchHouseDiv();">
		</div>
		<div id="photosDiv">
			<ul class="photos-ul"></ul>
			<img id="noDataImg" src="../distribute2/images/no_data.png">
		</div>
		<div class="pageInfoDiv" align="right">
			<span class="invalid prev" onclick="prevPage();">&lt;上一页</span>
			<span class="next" onclick="nextPage();">下一页&gt;</span>
		</div>
	</div>
	<div id="photoShowBg" onclick="$('#photoShowBg,#photoShowDiv').hide();"></div>
	<div id="photoShowDiv">
		<img id="popImg"/>
		<span id="closePhotoShow" onclick="$('#photoShowBg,#photoShowDiv').hide();">×</span>
	</div>
	<object type='application/x-qt-plugin' classid='CKjlAddIn' id='CKjlAddIn' style="height:0px;width:0px;display:block;" ></object>
</body>
<script type="text/javascript">
	var nowPage = 1;
	var editOrChoiseText = "编辑";
	<c:if test="${not empty IS_CHOISE and IS_CHOISE eq 1}">
		editOrChoiseText = "选择";
	</c:if>
	$(window).resize(function() {
		onResize();
	});
	$("body").on("click", "#photosDiv li div img", function() {
		var src = $(this).attr("big");
		$('#popImg').attr("src", src);
		$('#photoShowBg,#photoShowDiv').show();
	});
	$("body").on("click", "#photosDiv li span", function(e) {
		e.preventDefault();
		e.stopPropagation();
		var planId = $(this).parents("li").attr("obsPlanId");
		<c:if test="${empty IS_CHOISE or IS_CHOISE ne 1}">
			ajaxTemp("../web/kujiale/getKjlEditFloorplanUrl", "POST", "json",
				{CLIENTKEY:"${CLIENTKEY}",PLANID:planId},
				function(data){
					//console.log(data);
					closeSearchHouseDiv();
					setUrl(data.DATA[0].URL);
				}
			);
		</c:if>
		<c:if test="${not empty IS_CHOISE and IS_CHOISE eq 1}">
			//alert("选择成功！"+planId);
			try{
				document.getElementById("CKjlAddIn").slot_editFinish(planId);
			} catch (e) {
				console.log(e);
			}
		</c:if>
	});
	function onResize() {
		$("#searchPage").css("width",document.body.clientWidth-240);
		$("#searchPage").css("height",document.body.clientHeight);
		$("#photoShowBg").css("width",document.body.clientWidth);
		$("#photoShowBg").css("height",document.body.clientHeight);
		$("#photosDiv").css("width",document.body.clientWidth-250);
		$("#photosDiv").css("height",document.body.clientHeight-85);
		$("#photoShowDiv").css("left", (document.body.clientWidth-720) / 2);
		$("#photoShowDiv").css("top", (document.body.clientHeight-540) / 2);
	}
	onResize();
	function setUrl(url) {
		$("#kujialeIframe").attr("src", url);
	}
	function reloadPage() {
		$("#kujialeIframe").attr("src", '${KJL_URL}');
	}
	function prevPage() {
		if(nowPage > 1) {
			nowPage--;
			$(".pageInfoDiv .prev").removeClass("invalid");
			searchPhotos();
		}
		if(nowPage <= 1) {
			nowPage = 1;
			$(".pageInfoDiv .prev").addClass("invalid");
		}
	}
	function nextPage() {
		nowPage++;
		searchPhotos();
		$(".pageInfoDiv .prev").removeClass("invalid");
	}
	function showSearchHouseDiv() {
		nowPage = 1;
		$("#searchPage").show();
		searchPhotos();
	}
	function searchPhotos() {
		$("#noDataImg").hide();
		$("#photosDiv ul").empty();
		var queryStr = $("#searchInput").val();
		ajaxTemp("../web/kujiale/getFloorplanList", "POST", "json",
			{CLIENTKEY:"${CLIENTKEY}",QUERY_STR:queryStr,PAGE_OFFSET:nowPage},
			function(data){
				//console.log(data);
				if(data.DATA && data.DATA.length > 0) {
					for(i in data.DATA) {
						var temp = data.DATA[i];
						$("#photosDiv ul").append(
							'<li obsPlanId="'+temp.obsPlanId+'">'
							+'<div align="center"><div class="inn-div"><img src="'+temp.smallPics+'" big="'+temp.pics+'">'
							+'<span>'+editOrChoiseText+'</span></div></div>'
							+'<p>'+temp.name+'</p>'
							+'</li>'
						);
					}
					$("#noDataImg").hide();
				} else{
					$("#noDataImg").show();
				}
			},function(){
				$("#noDataImg").show();
			}
		);
	}
	function closeSearchHouseDiv() {
		$("#searchPage").hide();
	}
	if (window.postMessage) {
		var callback = function(ev) {
			//console ? console.log(ev) : alert(ev.data);
			if (ev.origin === 'http://www.kujiale.com' || ev.origin === 'http://yun.kujiale.com' ||
				ev.origin === 'https://www.kujiale.com' || ev.origin === 'https://yun.kujiale.com') {
				var data = JSON.parse(ev.data);
				//$("#userOption").append(ev.data);
				console.log(ev);
				if(data.action == "kjl_completed") {
					//alert("完成啦！！");
					$("#kujialeIframe").attr("src", null);
					try{
						document.getElementById("CKjlAddIn").slot_editFinish(data.fpid);
					} catch (e) {
						console.log(e);
					}
					//reloadPage();
				} else if(data.action == "kjl_loaded") {
					//$("#userOption").show();
					try{
						document.getElementById("CKjlAddIn").slot_kjlLoaded();
					} catch (e) {
						console.log(e);
					}
				}
			}
		};
		if ('addEventListener' in document) {
			window.addEventListener('message', callback, false);
		} else if ('attachEvent' in document) {
			window.attachEvent('onmessage', callback);
		}
	} else {
		window.navigator.listenKJL = function(msg) {
			var data = JSON.parse(msg.data);
			$("#userOption").append(msg.data);
		};
	}
	
	/**
	 * ajaxTemp("", "GET", "html", {}, function(){}, function(){}, "");
	 */
	function ajaxTemp(url, dataSentType, dataReceiveType, paramsStr, successFunction, errorFunction, id) {
		$.ajax({
			url : url,
			sync : false,
			type : dataSentType,
			dataType : dataReceiveType,
			data : eval(paramsStr),
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(msg) {successFunction(msg, id);},
			beforeSend : function() {},
			complete : function() {},
			error : function(msg) {errorFunction(msg, id);}
		});
	}
</script>
</html>