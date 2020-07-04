<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>注册验证成功</title>
  <link rel="stylesheet" href="${statics}fjdInvitation/css/reset.css" />
  <link rel="stylesheet" href="${statics}fjdInvitation/css/succ_add_fjd.css" />
  <script>
    function calculateSize() {
      var clientWidth = window.innerWidth || document.documentElement.clientWidth;
      if (clientWidth >= 640) {
        clientWidth = 640;
      }
      var htmlSize = clientWidth / 3.75;
      document.documentElement.style.fontSize = htmlSize + 'px';
    }
    calculateSize();
    window.addEventListener('resize', calculateSize);
  </script>
</head>

<body>
  <div id="app">
    <div class="banner">
      <div class="logo"></div>
      <div class="text"><span>欢迎加入中国房产经纪</span></div>
      <div class="text"><span>人创业平台</span></div>
<%--      <div class="tips">马上开启轻松高效的经纪人之旅</div>--%>
    </div>
    <a class="download" href="${androidDownloadUrl}">立即下载APP</a>
  </div>

  <script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
  <script src="${statics}common/js/common.js" type="text/javascript"></script>
  <script src="${statics}fjdInvitation/js/jquery.min.js"></script>
  <script src="${statics}fjdInvitation/js/index.js"></script>

<script>
  var ua = navigator.userAgent.toLowerCase();
  //ios，以直接跳转到
  if (ua.indexOf("iphone") !== -1 || ua.indexOf("ipad") !== -1 || ua.indexOf("ipod") !== -1) {
    $(".download").attr('href',"https://apps.apple.com/cn/app/%E6%8E%8C%E4%B8%8A%E5%A5%BD%E6%88%BF%E9%80%9A-%E6%88%BF%E4%BA%A7%E4%B8%AD%E4%BB%8B%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F/id893555814");
  }
</script>
</body>

</html>