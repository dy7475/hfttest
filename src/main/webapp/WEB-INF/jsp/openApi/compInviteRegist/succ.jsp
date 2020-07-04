<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>注册验证成功</title>
    <link rel="stylesheet" href="${statics}/css/inviteCss/reset.css" />
    <link rel="stylesheet" href="${statics}/css/inviteCss/succ.css" />
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
    <style type="text/css">

        body,
        html {
            width: 100%;
            height: 100%;
            position: relative;
        }

        #app {
            position: relative;
            margin: 0 auto;
            width: 3.75rem;
            min-height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .hide {
            display: none;
        }

        /** banner
        ********************************************************/
        .banner{
            width: 100%;
            height: 5.29rem;
            background: url(${statics}/images/inviteImages/1/succ_banner.png}) center center no-repeat;
            background-size: 100% 100%;
            padding-top: 2.16rem;
            box-sizing: border-box;
            text-align: center;
            position: relative;
        }
        .banner .text{
            font-size: 0.3rem;
            font-weight: bold;
            color: #fff;
            margin-bottom: 0.12rem;
            width: 100%;
            overflow: hidden;
            text-overflow: ellipsis;
            padding: 0 0.1rem;
            box-sizing: border-box;
        }
        .banner .text span{
            display: inline-block;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .banner .tips{
            font-size: 0.13rem;
            color: #fff;
            margin-bottom: 0.7rem;
        }
        .banner .download{
            display: block;
            width: 1.9rem;
            margin: 0 auto;
            height: 0.45rem;
            line-height: 0.45rem;
            font-size: 0.23rem;
            color: ${1 eq isFdd ? '#ffffff' : "#02fbf8"};
            border-radius: 0.23rem;
            border: solid 0.02rem ${1 eq isFdd ? '#ffffff' : "#02fbf8"};
        }

        .step{}
        .step img{
            display: block;
            width: 100%;
            pointer-events: none;
        }
    </style>
</head>

<body>
    <div id="app">
        <div class="banner">
        <div class="text"><span>恭喜你加入${compName}</span></div>
            <div class="tips">马上开启轻松高效的经纪人之旅</div>
            <a class="download" href="${1 eq isFdd ? 'http://e.fangdd.com/' : "http://a.app.qq.com/o/simple.jsp?pkgname=com.haofang.hftsoftapp"}">立即下载APP</a>
        </div>
        <div class="step">
            <img src="${statics}/images/inviteImages/${1 eq isFdd ? 'fdd' : "hft"}/step_0.${1 eq isFdd ? 'jpg' : "png"}" alt="">
            <img src="${statics}/images/inviteImages/${1 eq isFdd ? 'fdd' : "hft"}/step_1.${1 eq isFdd ? 'jpg' : "png"}" alt="">
            <img src="${statics}/images/inviteImages/${1 eq isFdd ? 'fdd' : "hft"}/step_2.${1 eq isFdd ? 'jpg' : "png"}" alt="">
            <img src="${statics}/images/inviteImages/${1 eq isFdd ? 'fdd' : "hft"}/step_3.${1 eq isFdd ? 'jpg' : "png"}" alt="">
            <img src="${statics}/images/inviteImages/${1 eq isFdd ? 'fdd' : "hft"}/step_4.${1 eq isFdd ? 'jpg' : "png"}" alt="">
            <img src="${statics}/images/inviteImages/${1 eq isFdd ? 'fdd' : "hft"}/step_5.png" alt="">
        </div>
    </div>
    <script language="javascript" src="${statics}/publicJs/inviteJs/jquery.min.js"></script>
</body>

</html>