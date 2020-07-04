<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String lng = request.getParameter("lng");
	String lat = request.getParameter("lat");
	String dragAble = request.getParameter("dragAble");
	String status = request.getParameter("status");
	String cityName = request.getParameter("cityName");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/publicJs/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=5VvTOucMGhIh2gP5qGrAXeCKhmDcBKtQ"></script>
	<style type="text/css">
		body, html,#allmap,#panorama {
			width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";
		}
		#buttonBox {
			position: absolute; width: 156px;height: 24px;z-index: 100;right: 50px;top: 30px;box-shadow: 0 0 6px rgb(174, 174, 174);
		}
		#buttonBox div {
			float: left;display: block;
			width:50px;height:22px;line-height:22px; text-align: center;cursor: pointer;border:1px solid #8F8E8E;background-color:#fff;
		}

		#flashContent {background-image:url("../kujiale/img/BG.jpg");background-repeat:no-repeat;background-size:100% 100%; width:100%; height: 100%;display: none;}
		#flashContent table{width: 100%; position: absolute;top: 26%;}
		#flashContent table tr td{text-align: center;}
		#flashContent table tr td a{outline: none;}
		#flashContent .divText{font-family: 'Microsoft Yahei';font-size: 18px;color: white;text-align: center; margin-bottom: 25px;letter-spacing: 2px;}
		#noParanMap{
			font-family:"微软雅黑";
			position: absolute;
			z-index: 999;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-moz-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
		}

		#searchBox {
			position: absolute; width: 365px;height: 32px;z-index: 200;left: 100px;top: 30px;
		}

		#searchBox input{
			height: 32px;
			width: 303px;
			padding: 2px;
			font-size: 16px;
			border: 1px solid #CCCCCC;
			border-right: none;
		}

		#searchBox #search-button{
			pointer-events: auto;
			background: url(//webmap1.bdimg.com/wolfman/static/common/images/new/searchbox_f175577.png) no-repeat 0 -76px #3385ff;
			width: 57px;
			height: 38px;
			float: right;
			border: 0;
			padding: 0;
			cursor: pointer;
			border-radius: 0 2px 2px 0;
			box-shadow: 1px 2px 1px rgba(0,0,0,.15);
			outline: none;
		}


	</style>
	<script type="text/javascript">
        var map;
        var lng = '<%=lng%>';
        var lat = '<%=lat%>';
        var status = '<%=status%>';
        var dragAble = '<%=dragAble%>';
        var cityName = '<%=cityName%>';
        var marker;
        var panorama;
		var ac;
		var myValue;
		var zoom;
		$(function () {
            if('1' == status) {
                loadMap();
            }else {
                // 定位失败界面
                $("#buttonBox").hide();
                $("#errorStatus").show();
                $("#searchBox").hide();

            }
        });

        function loadMap() {
            // 百度地图API功能
            map = new BMap.Map("allmap");    // 创建Map实例
            var point = new BMap.Point(lng, lat);
            map.centerAndZoom(point, 16);  // 初始化地图,设置中心点坐标和地图级别
            marker = new BMap.Marker(point);  // 创建标注
            marker.addEventListener('dragend', function (e) {//拖动标注结束
                $("#paran").show();
                $("#buttonBox").width(156)
                var pointNew = e.point;
                var panoramaService = new BMap.PanoramaService();
                panoramaService.getPanoramaByLocation(pointNew, function(data){
                    var panoramaInfo="";
                    if (data == null) {
                        $("#paran").hide();
                        $("#buttonBox").width(104)
                    }
                });
            });
            if(dragAble && '1' == dragAble) {
                marker.enableDragging();
                // marker.addEventListener("dragend", function (e) {
                //     lng = e.point.lng; //经度
                //     lat = e.point.lat; //纬度
				// 	console.log(lng);
                // });
            }else {
                var panoramaService = new BMap.PanoramaService();
                panoramaService.getPanoramaByLocation(marker.getPosition(), function(data){
                    var panoramaInfo="";
                    if (data == null) {
                       $("#paran").hide();
                        $("#buttonBox").width(104)
                    }
                });
			}
            // marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
            map.addOverlay(marker);              // 将标注添加到地图中
            map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

            var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
            var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
            var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角

            map.addControl(top_left_navigation);



			ac = new BMap.Autocomplete(    //建立一个自动完成的对象
					{"input" : "searchKey"
						,"location" : map
					});
			ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
				var str = "";
				var _value = e.fromitem.value;
				var value = "";
				if (e.fromitem.index > -1) {
					value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
				}
				str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

				value = "";
				if (e.toitem.index > -1) {
					_value = e.toitem.value;
					value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
				}
				str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
				G("searchResultPanel").innerHTML = str;
			});

			ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
				var _value = e.item.value;
				myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
				G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
				setPlace();
			});

			zoom = map.getZoom();
		};


        function flashChecker() {
            var hasFlash = 0; //是否安装了flash
            var flashVersion = 0; //flash版本
            var canUseKujiale = 0; //可以使用
            if (navigator.plugins && navigator.plugins.length > 0) {
                var swf = navigator.plugins["Shockwave Flash"];
                if (swf) {
                    hasFlash = 1;
                    var words = swf.description.split(" ");
                    for (var i = 0; i < words.length; ++i) {
                        if (isNaN(parseInt(words[i]))){
                            continue;
                        }
                        flashVersion = parseInt(words[i]);
                    }
                }
            }
            if(hasFlash){
                //alert("当前版本号："+flashVersion);
                if(flashVersion >= 16) {
                    canUseKujiale = 1;
                }
            }
            if(canUseKujiale) {

            } else {
                $("#flashContent").show();
                $("#kujialeIframe").remove();
            }
        }
        function openDownloadFlashWindow() {
            document.getElementById('CCustObj').openWindow('http://upgrade1.myfun7.com/install_flash_player16_x86.exe');
        }

        function openPanorama(obj) {
            $("#noParanMap").hide();
            $("#searchBox").hide();
            var panoramaService = new BMap.PanoramaService();
            panoramaService.getPanoramaByLocation(marker.getPosition(), function(data){
                var panoramaInfo="";
                if (data == null) {
                   $("#noParanMap").show();
                    return
                }
            });
            flashChecker();
            $("#buttonBox div").css("background-color","").css("color","#000000");;
            $(obj).css("background-color", "#259CF3").css("color","#ffffff");
            $("#allmap").hide();
            $("#searchBox").hide();
            $("#panorama").show();

            var panorama = new BMap.Panorama('panorama'); //默认为显示导航控件
            panorama.setPosition(marker.getPosition());
        }

        function openNormalMap(obj) {
            $("#flashContent").hide();
            $("#panorama").hide();
            $("#allmap").show();
            $("#searchBox").show();
            // loadMap();
            $("#buttonBox div").css("background-color","").css("color","#000000");;
            $(obj).css("background-color", "#259CF3").css("color","#ffffff");
            map.setMapType(BMAP_NORMAL_MAP);
			zoom = map.getZoom();
        }

        function openMixMap(obj) {
            $("#flashContent").hide();
            $("#panorama").hide();
            $("#allmap").show();
            $("#searchBox").show();
            // loadMap();
            $("#buttonBox div").css("background-color","").css("color","#000000");
            $(obj).css("background-color", "#259CF3").css("color","#ffffff");
            map.setMapType(BMAP_HYBRID_MAP);
        }

		function setPlace(){
			map.clearOverlays();    //清除地图上所有覆盖物
			function myFun(){
				var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
				map.centerAndZoom(pp, 18);
				marker = new BMap.Marker(pp)
				map.addOverlay(marker);    //添加标注
				zoom = map.getZoom();
			}
			var local = new BMap.LocalSearch(map, { //智能搜索
				onSearchComplete: myFun
			});
			local.search(myValue);
		}

		// 百度地图API功能
		function G(id) {
			return document.getElementById(id);
		}

		function moveMaptoCenter() {
        	var searchKey = $("#searchKey").val().trim();
        	if(searchKey) {
				console.log(searchKey);
				// 创建地址解析器实例
				var myGeo = new BMap.Geocoder();
				// 将地址解析结果显示在地图上,并调整地图视野
				myGeo.getPoint(searchKey, function(point){
					if (point) {
						console.log(point);
						map.clearOverlays();
						marker = new BMap.Marker(point);

						map.addOverlay(marker);
						map.centerAndZoom(point, zoom);
					}
				}, cityName);
			}

		}
	</script>


	<title>业务工具-地图</title>
</head>
<body>
<div id="flashContent">
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<div class="divText">使用前请下载Flash插件，安装完成后重启软件</div>
				<a href="javascript:openDownloadFlashWindow();">
					<img src="../kujiale/img/buttom.png" />
				</a>
			</td>
		</tr>
	</table>
</div>
<object type='application/x-qt-plugin' classid='CKjlAddIn' id='CKjlAddIn' style="height:0px;width:0px;display:block;" ></object>
<object type='application/x-qt-plugin' classid='SelBuilding' id="SelBuilding" style="height:0px;width:0px;display:block;"></object>
<object type='application/x-qt-plugin' classid='SelHouseTypePic' id="SelHouseTypePic" style="height:0px;width:0px;display:block;"></object>
<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
<div id="allmap">
	<div id="errorStatus" style="display: none; margin: 0 auto;">暂无相关地图</div>
</div>
<div id="noParanMap"  style='display:none;'>
	<div id="noParanMapStatus">没有街景数据</div>
</div>
<div id="panorama" style="display: none;"></div>
<div id="searchBox" ><input placeholder="请输入搜索关键字" id="searchKey"><button id="search-button" data-title="搜索" data-tooltip="1" onclick="moveMaptoCenter();"></button></div>
<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
<div id="buttonBox">
	<div id="paran" onclick="openPanorama(this)">街景</div>
	<div onclick="openNormalMap(this)" style="background-color: #259CF3; color:#ffffff">地图</div>
	<div onclick="openMixMap(this);">混合</div>
</div>
</body>
</html>
