<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="../common/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!-- com.myfun.erpWeb.bulletin.BulletinController#bulletinInfo -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html oncontextmenu="return false;" style="overflow:hidden;" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>签到记录</title>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main1119.css"/>
    <script language="javascript"  src="${statics}publicJs/jquery-3.3.1.min.js"></script>
    <%--<script language="javascript"  src="${statics}ucenter/common/common.js"></script>--%>
    <style type="text/css">
        .amap-info-content{
            padding: 0px ! important;
        }
        .wrap{
            padding: 0px;
            position: relative;
            width: 201px;
            height: 137px;
            overflow: hidden;
            margin:8px;
            /*margin-bottom: 50px;*/
            font-family: 宋体;

        }
        .wrap .pdiv{
            position: absolute;
            bottom:-2px;
        }
        .wrap p.txt{
            /*position: absolute;*/
            margin-top: 5px;
            margin-bottom: 5px;
            margin-left: 5px;
            margin-right: 5px;
            color: #ffffff;
        }
        .wrap p.txt1{
            font-size: 12px;
            /*bottom: 22px;*/
            left:6px;
        }
        .wrap p.txt2{
            font-size: 12px;
           /* bottom: -10px;*/
            left:6px;
        }
        .wrap img{

        }
        .remark{
            display:inline-block !important; display:inline;
           /* height: 44px;*/
            width: 201px;
            font-family:宋体;
            margin: auto;
            position:relative;
            left:12px;
            right: 15px;
            bottom: 5px;
            font-size: 12px;
            vertical-align:middle;
            line-height: 22px;
            word-break: break-all; word-wrap:break-word;
            color: #444444;
            letter-spacing:1px
        }
        .remark span{
            color: #999999;
        }
        .desc{
            padding: 5px;
            width: 200px;
            font-size: 12px;
            font-family:宋体;
            position:absolute;
            display: none;
            z-index: 999;
            background: #FFFFFF;
            letter-spacing:1px;
            color: #444444;
        }
        .amap-info-close{
            right:0px ! important;
            display: none;
        }
        .amap-info-sharp{
            top:-5px;
            background: url(https://webapi.amap.com/ui/1.0/ui/overlay/SimpleInfoWindow/assets/sharp.png) no-repeat -5px -8px ! important;
        }
        .amap-info:first-child{
            margin-bottom: -3px ! important;
        }
        .aa{
            position: absolute;
            z-index: 999;
            background-color: #0C0C0C;
        }
        a{
            position: absolute;
            z-index: 999;
            background-color: #0C0C0C;
        }
    </style>
    <script type="text/javascript"
    src="https://webapi.amap.com/maps?v=1.4.8&key=658d75f9eac369f531dde5b443fd3f09"></script>

</head>
<body>
<%--<object type='application/x-qt-plugin' classid='custObj' id='custObj' style="height:0px;width:0px;display:block;" ></object>--%>
<%--<a class="aa" href="http://localhost:8080/html/mouseOver.html">aaaaaaaaaaaaaaaaaaaaaaaaaaaaa</a>--%>
<div id="container"></div>
<div id="content"></div>
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
<script type="text/javascript" src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
<script type="text/javascript">

    //初始化地图对象，加载地图
    var data=${checkInRecords};

    var centerData=data[data.length-1]
    var map = new AMap.Map("container", {resizeEnable: true},zoom=15);
    map.plugin(["AMap.ToolBar"], function() {
        map.addControl(new AMap.ToolBar());
    });
    map.clearMap();  // 清除地图覆盖物
    var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(-12, -30)});
    for (var i=0;i < data.length;i++){
        var marker = new AMap.Marker({
            position:[data[i].longi,data[i].lati],
            map: map,
            icon: new AMap.Icon({
                size: new AMap.Size(40, 50),
                cour:1,
                image: "https://webapi.amap.com/theme/v1.3/markers/n/mark_b"+(i+1)+".png"     //自定义的标记图片样式(图片需自己准备)
            })
        });
        var photoPath=data[i].checkInDetailPhoto;
        if (photoPath==null){
            photoPath="${statics}/attendance/img/fila.png";
        }
        var remark="";
        if (data[i].checkInDescr!=null){
            remark=data[i].checkInDescr;
        }
        if (remark.length > 25) {
            remark=$.trim(remark);
            remark = remark.substring(0, 25) + "....";
            var descHtml = "<div class=\"desc desc"+i+"\">"+data[i].checkInDescr+"</div>";
            $("#content").append(descHtml);
        }
        var checkInLocation="";
        if (data[i].checkInLocation!=null){
            checkInLocation=data[i].checkInLocation;
        }
        var userName="";
        if (data[i].userName!=null){
            userName=data[i].userName;
        }
        var checkInTiem="";
        if (data[i].checkInTime!=null){
            checkInTiem=data[i].checkInTime.substring(0,16);
        }
        marker.content = "<div class=\"wrap\">\n" +
            "        <img src=\"" + photoPath + "\" width=\"100%\" height=\"auto\">\n" +
            "        <div class=pdiv><p class=\"txt txt1\"><img src=\"${statics}/attendance/img/user.png\">" + " "
            + userName + "（" + checkInTiem + "）</p>\n" +
            "        <p class=\"txt txt2\"><img src=\"${statics}/attendance/img/postion.png\">"+" "+checkInLocation+"</p></div>\n" +
            "    </div><div class=\"remark\" onmouseout=hideRemark(this) onmouseover=showRemark(this) id ="+i+"><span>备注：</span>"+remark+"</div>";
        marker.on('click', markerClick);
        marker.emit('click', {target: marker});
    }
    map.setFitView()
    function markerClick(e) {
        infoWindow.setContent(e.target.content);
        infoWindow.open(map, e.target.getPosition());
    }

    function showRemark(obj){
        var id = $(obj).attr("id");
        var e = e || window.event;
        var scrollx = window.scrollX || document.documentElement.scrollLeft;
        var scrolly = window.scrollY || document.documentElement.scrollTop;
        var x = parseFloat(e.clientX) + parseFloat(scrollx);
        var y = parseFloat(e.clientY) + parseFloat(scrolly);
        var model = ".desc" + id;
        $(model).css({'left': x - 10, 'top': y + 10});
        $(model).fadeIn(1000);
    }
    function hideRemark(){
        $(".desc").fadeOut();
    }
    $(function(){
        $(".amap-info-close").remove();
        $(".amap-info-contentContainer").remove(".amap-info-close");
    });

</script>
</body>
</html>