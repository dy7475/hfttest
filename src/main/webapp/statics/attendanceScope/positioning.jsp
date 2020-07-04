<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String lat = request.getParameter("attScopeY");
    String lng = request.getParameter("attScopeX");
    String attDistance = request.getParameter("attDistance");
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>考勤地点定位</title>
    <script src="http://webapi.amap.com/maps?v=1.4.1&key=43c84ce2f9a2c7af427ec7549378adb3&plugin=AMap.Autocomplete"></script>
    <script src="jquery.js"></script>
    <style>
        html, body {
            margin: 0;
            height: 100%;
            width: 100%;
            position: absolute;
        }

        #container {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            width: 100%;
            height: 100%;
        }

        .button-group {
            position: absolute;
            bottom: 20px;
            right: 20px;
            font-size: 12px;
            padding: 10px;
        }

        .button-group .button {
            height: 28px;
            line-height: 28px;
            background-color: #0D9BF2;
            color: #FFF;
            border: 0;
            outline: none;
            padding-left: 5px;
            padding-right: 5px;
            border-radius: 3px;
            margin-bottom: 4px;
            cursor: pointer;
        }
        .button-group .inputtext {
            height: 26px;
            line-height: 26px;
            border: 1px;
            outline: none;
            padding-left: 5px;
            padding-right: 5px;
            border-radius: 3px;
            margin-bottom: 4px;
            cursor: pointer;
        }
        #tip {
            background-color: #fff;
            padding-left: 10px;
            padding-right: 10px;
            position: absolute;
            font-size: 12px;
            right: 10px;
            top: 20px;
            border-radius: 3px;
            border: 1px solid #ccc;
            line-height: 30px;
        }

        .amap-info-content {
            font-size: 12px;
        }

        #myPageTop {
            position: absolute;
            top: 5px;
            right: 10%;
            background: #fff none repeat scroll 0 0;
            border: 1px solid #ccc;
            margin: 10px auto;
            padding:6px;
            font-family: "Microsoft Yahei", "微软雅黑", "Pinghei";
            font-size: 14px;
        }
        #myPageTop label {
            margin: 0 20px 0 0;
            color: #666666;
            font-weight: normal;
        }
        #myPageTop input {
            width: 200px;
        }
        #myPageTop .column2{
            padding-left: 25px;
        }

        .amap-logo {
            right: -200px !important;
            left: auto !important;
            display: none;
        }

        .amap-copyright {
            right: -200px !important;
            left: auto !important;
        }
    </style>
</head>
<body>
<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
<div id="container"></div>
<div id="myPageTop">
    <table>
        <tr>
            <td>
                <label>按关键字搜索：</label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="text" placeholder="请输入关键字进行搜索" id="tipinput">
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<label>有效考勤范围：</label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<select style="width: 80px; float: right" id="scopeSet" onchange="changeScope(this);">--%>
                    <%--<option value="100">100米</option>--%>
                    <%--<option value="200">200米</option>--%>
                    <%--<option value="300">300米</option>--%>
                    <%--<option value="400">400米</option>--%>
                    <%--<option value="500">500米</option>--%>
                    <%--<option value="600">600米</option>--%>
                    <%--<option value="700">700米</option>--%>
                    <%--<option value="800">800米</option>--%>
                    <%--<option value="900">900米</option>--%>
                    <%--<option value="1000">1000米</option>--%>
                <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
    </table>
</div>
<script type="text/javascript">
    var lat = '<%=lat%>';
    var lng = '<%=lng%>';
    var address;
    var addressName;
    var scope = '<%=attDistance%>';
    if(!scope) {
        scope=100;
    }
    // $("#scopeSet").val(scope);
    var marker, circle;
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [lng, lat]
    });

    //地图中添加地图操作ToolBar插件
    map.plugin(['AMap.ToolBar'], function() {
        //设置地位标记为自定义标记
        var toolBar = new AMap.ToolBar();
        map.addControl(toolBar);
    });



    var auto = new AMap.Autocomplete({
        input: "tipinput"
    });

    marker = new AMap.Marker({
        icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
        position: [lng, lat],
        title: addressName,
    });

    marker.setMap(map);
    getAddressDetail(lng, lat);
    circle = new AMap.Circle({
        center: new AMap.LngLat(lng, lat),// 圆心位置
        radius: scope, //半径
        strokeColor: "#259CF3", //线颜色
        strokeOpacity: 0.2, //线透明度
        strokeWeight: 3,    //线宽
        fillColor: "#259CF3", //填充色
        fillOpacity: 0.05 ,//填充透明度
        strokeStyle:"dashed",
        bubble:true

    });

    circle.setMap(map);//显示圆圈

    //为地图注册click事件获取鼠标点击出的经纬度坐标
    var clickEventListener = map.on('click', function(e) {
        if(null != marker) {
            marker.hide();
        }
        if(null != circle) {
            circle.hide();
        }
        marker = new AMap.Marker({
            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            position: [e.lnglat.lng, e.lnglat.lat],
            title: addressName,
        });
        marker.setMap(map);

        circle = new AMap.Circle({
            center: new AMap.LngLat(e.lnglat.lng, e.lnglat.lat),// 圆心位置
            radius: scope, //半径
            strokeColor: "#259CF3", //线颜色
            strokeOpacity: 0.2, //线透明度
            strokeWeight: 3,    //线宽
            fillColor: "#259CF3", //填充色
            fillOpacity: 0.05 ,//填充透明度
            strokeStyle:"dashed",
            bubble:true
        });
        circle.setMap(map);//显示圆圈

        lat = e.lnglat.lat;
        lng = e.lnglat.lng;
        getAddressDetail(lng, lat);
    });
    map.setFitView();

    AMap.event.addListener(auto, "select", select);//注册监听，当选中某条记录时会触发

    function select(e) {
        address = $("#tipinput").val();
        if (e.poi && e.poi.location) {
            map.setZoom(15);
            map.setCenter(e.poi.location);

            if(null != marker) {
                marker.hide();
            }
            if(null != circle) {
                circle.hide();
            }
            marker = new AMap.Marker({
                icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
                position: [e.poi.location.lng, e.poi.location.lat],
                title: addressName,
            });

            circle = new AMap.Circle({
                center: new AMap.LngLat(e.poi.location.lng, e.poi.location.lat),// 圆心位置
                radius: scope, //半径
                strokeColor: "#259CF3", //线颜色
                strokeOpacity: 0.2, //线透明度
                strokeWeight: 3,    //线宽
                fillColor: "#259CF3", //填充色
                fillOpacity: 0.05 ,//填充透明度
                strokeStyle:"dashed",
                bubble:true
            });

            circle.setMap(map);//显示圆圈
            lat = e.poi.location.lat;
            lng = e.poi.location.lng;
            marker.setMap(map);
            getAddressDetail(lng, lat);
        }
    }

    //    前端调用
    function getAttendanceScope() {
        return lng+","+lat+","+addressName+","+address;
    }

    function changeScope(scope) {
        if(null != circle) {
            circle.hide();
        }

        circle = new AMap.Circle({
            center: new AMap.LngLat(lng, lat),// 圆心位置
            radius: scope, //半径
            strokeColor: "#259CF3", //线颜色
            strokeOpacity: 0.2, //线透明度
            strokeWeight: 3,    //线宽
            fillColor: "#259CF3", //填充色
            fillOpacity: 0.05 ,//填充透明度
            strokeStyle:"dashed",
            bubble:true
        });

        circle.setMap(map);//显示圆圈
    }

    function changeLnglat(lng1,lat1) {
        map.setZoom(15);
        map.setCenter([lng1, lat1]);
        if(null != marker) {
            marker.hide();
        }
        if(null != circle) {
            circle.hide();
        }
        marker = new AMap.Marker({
            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            position: [lng1, lat1],
            title: addressName,
        });

        circle = new AMap.Circle({
            center: new AMap.LngLat(lng1, lat1),// 圆心位置
            radius: scope, //半径
            strokeColor: "#259CF3", //线颜色
            strokeOpacity: 0.2, //线透明度
            strokeWeight: 3,    //线宽
            fillColor: "#259CF3", //填充色
            fillOpacity: 0.05 ,//填充透明度
            strokeStyle:"dashed",
            bubble:true
        });

        circle.setMap(map);//显示圆圈
        lat = lat1;
        lng = lng1;
        marker.setMap(map);
        getAddressDetail(lng1, lat1);
    }


    function getAddressDetail(lng, lat) {
        var data = lng+","+lat;
        $.ajax({
            type : "get",
            url : "https://restapi.amap.com/v3/geocode/regeo?output=json&location="+data+"&key=658d75f9eac369f531dde5b443fd3f09&radius=1000&extensions=all",
            async : false,
            success : function(e){
                address = e.regeocode.formatted_address;
                addressName = e.regeocode.pois[0].name;
                document.getElementById("CCustObj").selectAttendancePos(lng, lat,addressName, address, scope);
            }
        });
    }

</script>
</body>
</html>