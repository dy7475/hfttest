<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
<!--   <meta charset="UTF-8"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>注册验证</title>
  <link rel="stylesheet" href="${statics}fjdInvitation/css/reset.css" />
  <link rel="stylesheet" href="${statics}fjdInvitation/css/index_add_fjd.css" />
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
    <div id="loadDiv">
      <img src="${statics}images/loading-icon2.gif">
    </div>
    <!-- S banner -->
    <div class="banner">
      <div class="logo"></div>
      <div class="tt">欢迎加入中国房产经纪人创业平台</div>
    </div>
    <!-- E banner -->

    <!-- S form check-form -->
    <div class="form-section phone-check-form hide">
      <div class="input-cell">
        <div class="tt">注册手机:</div>
        <input type="text"  maxlength="11" placeholder="请输入手机号">
      </div>
      
      <div class="check-btn phone-check-btn">验 证</div>
    </div>
    <!-- E form check-form -->

    <div class="past-from" style="flex: 1;display: flex;flex-direction: column;justify-content: center;margin-top: -0.3rem;">
        <div style="text-align: center;"><img src="${statics}fjdInvitation/images/past_2x.png" style="width: 111px;height: 118px;"/></div>
        <br/>
        <div style="font-size: 15px;text-align: center;font-family: '微软雅黑';color: #666666;">二维码已失效,请重新扫码</div>
    </div>

    <!-- S form check-form -->
    <div class="form-section submit-form ">
      <div class="input-cell">
        <div class="tt">推荐人：</div><input type="text" maxlength="20" value="${invitedName}" readonly>
      </div>
      <div class="input-cell">
        <div class="tt">姓　　名：</div><input id="userName" type="text" maxlength="10" value="" placeholder="请输入姓名">
      </div>
      <div class="input-cell">
        <div class="tt">电　　话：</div><input type="text" id="phoneInput" maxlength="11" value="" placeholder="请输入电话">
      </div>
      <div class="input-cell server-input-cell">
        <div class="tt">服务区域：</div><input type="text" id="serverReg" placeholder="请选择您服务的区域" value="" readonly>
      </div>
      <div class="input-cell">
        <div class="tt">登录密码：</div><input type="password" id="password" maxlength="20" placeholder="请输入密码">
      </div>
      <div class="input-cell">
        <div class="tt">确认密码：</div><input type="password" id="passwordRep" maxlength="20" placeholder="请再次输入密码">
      </div>
      <div class="input-cell">
        <div class="tt">短信验证：</div>
        <input type="text" id="codeInput" maxlength="6" placeholder="请输入短信验证码" onblur="value=value.replace(/[^0123456789]/g,'')" onkeyup="value=value.replace(/[^0123456789]/g,'')">
        <div class="code-btn get-code">获取验证码</div>
      </div>
      <div class="check-btn submit-form-btn">下一步</div>
    </div>
    <!-- E form check-form -->

    <!-- S footer -->
    <div class="footer">好房通客服电话：028-8888-9666 转4</div>
    <!-- E footer -->


    <!-- S 服务 区域/商圈选择弹窗 -->
    <div class="server-reg-box hide">
      <div class="content">
        <div class="tips">最多可选择3个服务商圈</div>
        <div class="list" style="overflow: auto;">
          <ul class="list-ul reg-list" >
            <li class="on" data-name="武侯区" data-id='1'>武侯区<span></span></li>
            <li data-name="锦江区" data-id='3'>锦江区<span></span></li>
            <li data-name="青羊区" data-id='2'>青羊区<span></span></li>
          </ul>
          <ul class="list-ul section-list" >
            <!-- <li class="on" data-regid="1" data-id="1">望江路</li> -->
          </ul>
        </div>
        <div class="confirm-btn">确定</div>
      </div>
    </div>
    <!-- E 服务 区域/商圈选择弹窗 -->


  </div>
  <script>
    //当前用户 确认的服务区域
    var sureServerArr = [
//     	{
//         regId: '1',
//         regName: '武侯区',
//         sectionId: '1',
//         sectionName: '望江路'
//       },
//       {
//         regId: '1',
//         regName: '武侯区',
//         sectionId: '2',
//         sectionName: '致民路'
//       },
//       {
//         regId: '2',
//         regName: '青羊区',
//         sectionId: '21',
//         sectionName: '草市街'
//       },
    ];
    var sure
    //当前 正在选择的服务区域
    var selectServerArr = [

    ];
    //记录行政区的选择数量
    var regSelectNum = {};


    var statics = '${statics}';
    var erpWebUrl = '${erpWebUrl}';
    // var erpWebUrl = 'http://192.168.200.169:9001/erpWeb/';
    var adminWebUrl = '${adminWebUrl}';
    var crmWebUrl = '${crmWebUrl}';
    var invitedId = '${invitedId}';
   	var cityId = '${cityId}';
   	var deptId = '${funDepts.deptId}';
   	var compId = '${funDepts.compId}';
   	var param = '${paramData}';
   	var invitedMobile = '${invitedMobile}';
   	var deptName = '${funDepts.deptName}';
   	var pastFlag = '${pastFlag}';
   	var sectionIds,inviteId,isSuccessSubmit = 0;
   var regIds ="";
  </script>
  <script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
  <script src="${statics}common/js/common.js" type="text/javascript"></script>
  <script src="${statics}fjdInvitation/js/jquery.min.js"></script>
  <script src="${statics}fjdInvitation/js/index.js"></script>
</body>

</html>