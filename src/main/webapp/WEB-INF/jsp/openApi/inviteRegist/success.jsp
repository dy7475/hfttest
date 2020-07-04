<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.sidaotu.cn/jsp/jstl/functions" prefix="cf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="format-detection" content="telephone=no" />
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<title>欢迎你加入${deptName}</title>
	<style type="text/css">
		@charset "UTF-8";@media screen and (max-width:319px){html{font-size:85.33333px}}@media screen and (min-width:320px) and (max-width:359px){html{font-size:85.33333px}}@media screen and (min-width:360px) and (max-width:374px){html{font-size:96px}}@media screen and (min-width:375px) and (max-width:383px){html{font-size:100px}}@media screen and (min-width:384px) and (max-width:399px){html{font-size:102.4px}}@media screen and (min-width:400px) and (max-width:413px){html{font-size:106.66667px}}@media screen and (min-width:414px){html{font-size:110.4px}}body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,input,textarea,p,blockquote,th,td,header,hgroup,nav,section,article,aside,footer,figure,figcaption,menu,button{margin:0;padding:0}
		html,body{background-color: #dfe2e7;width:100%; height: 100%; font-family: "微软雅黑"; margin: 0 auto;}
		body {font-size: 16px; color: #000; outline: 0;}
		img{display: block;}
		html,body,p{margin: 0;padding: 0;width: 100%;height: 100%;font-family: "微软雅黑";font-size: 16px;}
		#app{
			width: 100%;margin: 0 auto; overflow-x:hidden;
			background-color: #dfe2e7;box-sizing:border-box;height: 100%;
		}
		#registGuide{position: relative;}
		#registInfo{position:absolute; height: 70px;padding-top: 200px; font-size: 22px;font-weight: bolder;color: #fff;width: 100%;}
		#registInfo .text{font-size: 15px;font-weight: normal;margin-top: 10px;}
		#registGuide img{max-width: 100%;}
		#footer{width: 100%;margin-top: -30px;}
		#footer p{font-size: 14px;color: #008cee;}
		#downloadBtn{
			width: 150px;height: 35px;line-height: 35px;border: 0;font-size: 14px;outline:none;
			border-radius: 3px;text-align: center;color: #fff;font-family: "微软雅黑";
			background-image: url('${statics}openApi/inviteRegist/img/download.png');
			background-size: 150px 35px;background-color: transparent;margin-top: 80px;
		}
	</style>
</head>
<body>
	<div id="app">
		<div id="registGuide">
			<div id="registInfo" align="center">
				<div>恭喜你加入${deptName}</div>
				<div class="text">马上开启轻松高效的经纪人之旅</div>
				<div>
					<input type="button" id="downloadBtn" onclick="addDownload();">
				</div>
			</div>
			<img src="${statics}openApi/inviteRegist/img/downloadBg.png">
			<div id="footer" align="center">
				<p>好房通客服电话：028-88889666 转4</p>
			</div>
		</div>
	</div>
</body>
<script src="${statics}publicJs/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	function addDownload() {
		$.ajax({
			type : "get",
			async : false,
			url : "http://appsrv.haofang.net/add_download.jsp",
			dataType : "jsonp",
			jsonp : "callbackparam",//服务端用于接收callback调用的function名的参数
			jsonpCallback : "success_jsonpCallback",//callback的function名称
			success : function(json) {
				top.window.location.href = 'http://a.app.qq.com/o/simple.jsp?pkgname=com.haofang.hftsoftapp';
			},
			error : function(a, b, c) {
				top.window.location.href = 'http://a.app.qq.com/o/simple.jsp?pkgname=com.haofang.hftsoftapp';
			}
		});
	}
</script>
</html>
