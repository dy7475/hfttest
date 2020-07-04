<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>注册验证成功</title>
  <link rel="stylesheet" href="${statics}/css/inviteCss/reset.css" />
  <link rel="stylesheet" href="${statics}/css/inviteCss/succLeaguesType${leaguesType}.css" />
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
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      padding-bottom: 0.39rem;
    }

    .hide {
      display: none;
    }

    /** banner
    ********************************************************/
    .banner{
      width: 100%;
      height: 5.5rem;

      background: url(${statics}/images/inviteImages/1/succ.png) center center no-repeat;
      background-size: 100% 100%;
      padding-top: 1.48rem;
      box-sizing: border-box;
      text-align: center;
      position: relative;
    }
    .banner .logo {
      width: 135px;
      height: 135px;
      margin: 0 auto 0.2rem;
      background: url(${statics}/images/inviteImages/1/download_logo.png) center center no-repeat;
      background-size: 100% 100%;
    }
    .banner .text{
      font-size: 0.28rem;
      font-weight: bold;
      color: #ffffff;
      margin-bottom: 0.06rem;
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
      color: #ffffff;
    }
    .download{
      display: block;
      width: 2.65rem;
      margin: 0.31rem auto 0;
      height: 0.47rem;
      line-height: 0.47rem;
      font-size: 0.17rem;
      background-color: #ffcb05;
      box-shadow: 0rem 0.1rem 0.1rem 0rem rgba(246, 209, 6, 0.2);
      border-radius: 0.24rem;
      color: #282828;
      text-align: center;
      font-weight: bold;
    }



  </style>
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
      <div class="text"><span>恭喜你加入${compName}</span></div>
      <div class="tips">马上开启轻松高效的经纪人之旅</div>
    </div>
  </div>
</body>

</html>