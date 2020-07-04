<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#container {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
		#container {
			height: 456px;
			width: 1099px;
			position: relative;
		}

		#supporting {
			position: absolute;
			z-index: 999;
			width: 304px;
			height: 420px;
			border: 1px solid #eeeeee;
			/*border: 1px solid #259CF3;*/
			right: 10px;
			top: 18px;
			background-color: #fff;
			/*box-shadow: -2px 0 0 #eeeeee;*/
		}

		#supporting #searchTitleBox {
			height: 42px;
			width: 300px;
			float: left;
			background-color: #F6F6F6;
			-webkit-user-select:none;
			-moz-user-select:none;
			-ms-user-select:none;
			user-select:none;
		}

		#supporting #searchContent {
			height: 345px;
			width: 300px;
			float: left;
			overflow-y: scroll;
		}

		#searchContent #itemArea {
			/*border: 1px solid red;*/
			/*height: auto;*/
		}
		#supporting #searchTitleBox ul{
			list-style: none;
			margin: 0 auto;
			padding: 0px;
		}

		#supporting #searchTitleBox ul li{
			float: left;
			display: block;
			height: 42px;
			width: 50px;
			text-align: center;
			line-height: 40px;
			cursor: pointer;
		}

		.liChecked {
			color: #53B1F6;
			border-top: 3px solid #259CF3;
			background-color: #ffffff;
		}
		#itemArea ul {
			list-style: none;
			margin: 0 auto;
			padding: 0px;
		}

		#itemArea ul li{
			float: left;
			display: block;
			height: 60px;
		}
		.BMap_cpyCtrl {
			display: none;
		}

		.anchorBL {
			display: none;
		}

		.nui-scroll::-webkit-scrollbar {
			width: 6px;
			height: 10px;
		}

		/*正常情况下滑块的样式*/
		.nui-scroll::-webkit-scrollbar-thumb {
			background-color: rgba(0,0,0,.05);
			border-radius: 10px;
			-webkit-box-shadow: inset 1px 1px 0 rgba(0,0,0,.1);
		}
		/*鼠标悬浮在该类指向的控件上时滑块的样式*/
		.nui-scroll:hover::-webkit-scrollbar-thumb {
			background-color: rgba(0,0,0,.2);
			border-radius: 10px;
			-webkit-box-shadow: inset 1px 1px 0 rgba(0,0,0,.1);
		}
		/*鼠标悬浮在滑块上时滑块的样式*/
		.nui-scroll::-webkit-scrollbar-thumb:hover {
			background-color: rgba(0,0,0,.4);
			-webkit-box-shadow: inset 1px 1px 0 rgba(0,0,0,.1);
		}

		.nui-scroll{
			overflow: auto;/*当内容溢出时显示滚动条*/
		}

		@font-face {
			font-family: 'iconfont';  /* project id 251874 */
			src: url('//at.alicdn.com/t/font_251874_tgykktwn4d.eot');
			src: url('//at.alicdn.com/t/font_251874_tgykktwn4d.eot?#iefix') format('embedded-opentype'),
			url('//at.alicdn.com/t/font_251874_tgykktwn4d.woff') format('woff'),
			url('//at.alicdn.com/t/font_251874_tgykktwn4d.ttf') format('truetype'),
			url('//at.alicdn.com/t/font_251874_tgykktwn4d.svg#iconfont') format('svg');
		}

		.iconfont{
			font-family:"iconfont" !important;
			font-size:16px;font-style:normal;
			-webkit-font-smoothing: antialiased;
			-webkit-text-stroke-width: 0.2px;
			-moz-osx-font-smoothing: grayscale;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=5VvTOucMGhIh2gP5qGrAXeCKhmDcBKtQ"></script>
	<script language="javascript" src="${statics}publicJs/jquery-3.3.1.min.js"></script>
	<title>地图展示</title>
</head>
<body>
<div id="container"></div>
<div class="supporting" id="supporting" >
	<div id="searchTitleBox">
		<ul>
			<li class="liChecked" style="line-height: 33px;cursor:default;" onclick="searchAround(this);" itemId="1">交通</li>
			<li onclick="searchAround(this);" itemId="2">教育</li>
			<li onclick="searchAround(this);" itemId="3">医疗</li>
			<li onclick="searchAround(this);" itemId="4">购物</li>
			<li onclick="searchAround(this);" itemId="5">生活</li>
			<li onclick="searchAround(this);" itemId="6">娱乐</li>
		</ul>
	</div>
	<div id="searchContent" class="nui-scroll">
		<div id="itemArea">
			<ul>
			</ul>
		</div>
	</div>
</div>
</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    var buildIcon,buildMark;
    var map = new BMap.Map("container");    // 创建Map实例
	var lng = ${lng};
	var lat = ${lat};
    var point = new BMap.Point(lng, lat);
    map.centerAndZoom(new BMap.Point(lng, lat), 14);  // 初始化地图,设置中心点坐标和地图级别
    // map.setCurrentCity("成都");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(false);     //开启鼠标滚轮缩放
	var searchkey = "交通";
	var selectItemNum = 1;
    addBuildMark();
    // 设置个楼盘图标
    var options = {
        onSearchComplete: function (results) {
            if (local.getStatus() == BMAP_STATUS_SUCCESS) {
                // 判断状态是否正确
                var itemHtml = "";
                if (results instanceof Array) {
                    var length = results.length;
                    for (var i = 0; i < length; i++) {
                        itemHtml += showMark(results[i]);
                    }
                } else {
                    itemHtml += showMark(results);
                }
            }
            $("#itemArea ul").html(itemHtml);
        }
    };

    function showMark(results) {
        var itemHtml = "";
        for (var i = 0; i < results.getCurrentNumPois(); i ++){

            var point = new BMap.Point(results.getPoi(i).point.lng, results.getPoi(i).point.lat);

            var itemIcon = new BMap.Icon("${statics}/images/buidMap/item"+selectItemNum+".png", new BMap.Size(32, 32));
            var itemMark = new BMap.Marker(point,{icon:itemIcon});  // 创建标注

            addMarker(itemMark);
            var distance = getDistance(lat, lng, results.getPoi(i).point.lat, results.getPoi(i).point.lng);

            var iconfont = "";

            if('交通' == searchkey) {
                iconfont = "&#xe634;";
            }else if('医疗' == searchkey) {
                iconfont = "&#xe639;";
            }else if('购物' == searchkey) {
                iconfont = "&#xe682;";
            }else if('娱乐' == searchkey) {
                iconfont = "&#xe643;";
            }else if('教育' == searchkey) {
                iconfont = "&#xe62b;";
            }else if('生活' == searchkey) {
                iconfont = "&#xe6a2;";
            }
            itemHtml+= '<li style="width: 100%;height: 40px; margin-top: 20px;line-height: 20px;">' +
                '          <div style="font-size: 12px; float: left; width: 100%; ">' +
                '            <div style="margin-left: 25px; float: left;"><i class="iconfont">'+iconfont+'</i></div>' +
                '            <div style="margin-left: 12px; float: left;font-weight: bold">'+results.getPoi(i).title+'</div>' +
                '            <div style="margin-right: 20px; float: right;">'+distance+'米</div>' +
                '          </div>' +
                '          <div style="height:40px; font-size: 12px; float: left;width: 70%; margin-left: 55px; color: #B2B2B2; overflow: hidden" title='+results.getPoi(i).address+'>'+results.getPoi(i).address+'</div>' +
                '       </li>';
        }
        return itemHtml;

    }

    var local = new BMap.LocalSearch(map, options);
    searchKeyDeal(searchkey);

    // 编写自定义函数,创建标注
    function addMarker(point){
        map.addOverlay(point);
    }

    function searchAround(obj) {
        map.clearOverlays();
        addBuildMark();
        $("#searchTitleBox").find("li[class='liChecked']").removeClass("liChecked").css("line-height","40px").css("cursor", "pointer");
        $(obj).addClass("liChecked").css("line-height","33px").css("cursor", "default");
        searchkey = $(obj).html();
        selectItemNum = $(obj).attr("itemId");
        searchKeyDeal(searchkey);
    }

    function searchKeyDeal(searchkey) {
        if("生活" == searchkey) {
            searchkey = new Array("银行","餐饮");
        }else  if("购物" == searchkey) {
            searchkey = new Array("超市","购物");
        }else  if("交通" == searchkey) {
            searchkey = new Array("交通","公交站");
        }
        local.searchNearby(searchkey,point, 2000);
	}


    //计算距离，参数分别为第一点的纬度，经度；第二点的纬度，经度
    function getDistance(lat1, lng1, lat2, lng2) {
        var radLat1 = Rad(lat1);
        var radLat2 = Rad(lat2);
        var a = radLat1 - radLat2;
        var b = Rad(lng1) - Rad(lng2);
        var s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378.137; // 地球半径，千米;
        s = Math.round(s * 10000) / 10000; //输出为公里
        s = Math.round(s * 1000) / 1; //单位修改为米,取整
        //s=s.toFixed(4);
        return s;
    }

    function Rad(d) {
        return d * Math.PI / 180.0; //经纬度转换成三角函数中度分表形式。
    }

    function addBuildMark() {
        var buildIcon = new BMap.Icon("${statics}/images/center.png", new BMap.Size(22, 22));
        buildMark = new BMap.Marker(point,{icon:buildIcon});  // 创建标注



        // var label = new BMap.Label(point, {
        //      offset: new BMap.Size(16, 16)
        //  }); //创建marker点的标记,这里注意下,因为百度地图可以对label样式做编辑,
        //  label.setStyle({
        //      display: "none"
        //  }); //对label 样式隐藏
		//
        // buildMark.setLabel(label); //把label设置到maker上

        map.addOverlay(buildMark);              // 将标注添加到地图中
		if('${buildName}') {
            var label = new BMap.Label('${buildName}', {
                offset: new BMap.Size(-52, -30)
            });

            label.setStyle({
                width: "120px",
                color: '#fff',
                background: '#5184f9',
                border: '1px solid "#ff8355"',
                borderRadius: "5px",
                textAlign: "center",
                height: "26px",
                lineHeight: "26px"
            });

            buildMark.setLabel(label); //为标注添加一个标签
		}


    }

</script>
