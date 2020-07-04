<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String lng = request.getParameter("lng");
	String lat = request.getParameter("lat");
	String dragAble = request.getParameter("dragAble");
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap,#panorama {
			width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";
		}
		#buttonBox {
			position: absolute; width: 156px;height: 24px;z-index: 100;right: 100px;top: 20px;box-shadow: 0 0 6px rgb(174, 174, 174);
		}
		#buttonBox div {
			float: left;display: block;
			width:50px;height:22px;line-height:22px; text-align: center;cursor: pointer;border:1px solid #8F8E8E;background-color:#fff;
		}
		.anchorBL{display:none}
	</style>
	<script language="javascript" src="http://172.16.140.101:8080/hftWebService/publicJs/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=5VvTOucMGhIh2gP5qGrAXeCKhmDcBKtQ"></script>
	<title>业务工具-地图</title>
</head>
<body>
<div id="allmap"></div>
<div id="panorama" style="display: none;"></div>
<div id="buttonBox">
	<div onclick="openPanorama(this)">街景</div>
	<div onclick="openNormalMap(this)" style="background-color: #259CF3">地图</div>
	<div onclick="openMixMap(this);">混合</div>
</div>
</body>
</html>
<script type="text/javascript">
    var map;
    var lng = '<%=lng%>';
    var lat = '<%=lat%>';
    var dragAble = '<%=dragAble%>';
    var marker;
    $(function () {
        console.log(dragAble);
        console.log(dragAble);
        console.log(dragAble);
        loadMap();
    });
    
    function loadMap() {
        // 百度地图API功能
        map = new BMap.Map("allmap");    // 创建Map实例
        var point = new BMap.Point(lng, lat);
        map.centerAndZoom(point, 16);  // 初始化地图,设置中心点坐标和地图级别
        marker = new BMap.Marker(point);  // 创建标注
		if(dragAble && '1' == dragAble) {
            marker.enableDragging();
        }
        // marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
        map.addOverlay(marker);              // 将标注添加到地图中
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

        var bottom_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT});// 左上角，添加比例尺
        map.addControl(bottom_left_control);
    }

	function openPanorama(obj) {
        $("#buttonBox div").css("background-color","");
        $(obj).css("background-color", "#259CF3");
        $("#allmap").hide();
        $("#panorama").show();

        var panorama = new BMap.Panorama('panorama'); //默认为显示导航控件
        panorama.setPosition(new BMap.Point(lng, lat));
    }

	function openNormalMap(obj) {
        $("#panorama").hide();
        $("#allmap").show();
        // loadMap();
        $("#buttonBox div").css("background-color","");
        $(obj).css("background-color", "#259CF3");
        map.setMapType(BMAP_NORMAL_MAP);
    }

	function openMixMap(obj) {
        $("#panorama").hide();
        $("#allmap").show();
        // loadMap();
        $("#buttonBox div").css("background-color","");
        $(obj).css("background-color", "#259CF3");
        map.setMapType(BMAP_HYBRID_MAP);

    }


</script>
