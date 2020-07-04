<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>注册验证</title>
    <link rel="stylesheet" href="${statics}/css/inviteCss/reset.css" />
    <%--<link rel="stylesheet" href="${statics}/css/inviteCss/index.css" />--%>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <script>
        window.onpageshow = function (event) {
            if (event.persisted) {
                window.location.reload()
            }
        };

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
        /**
         * @desc 邀请注册
         * @author LiuChiLei
         * @date 2018-09-06
         */
        <%--body,html{--%>
            <%--width: 100%;--%>
            <%--height: 100%;--%>
            <%--position: relative;--%>
        <%--}--%>
        <%--#app{--%>
            <%--position: relative;--%>
            <%--margin: 0 auto;--%>
            <%--width: 3.75rem;--%>
            <%--min-height: 100%;--%>
            <%--display: flex;--%>
            <%--flex-direction: column;--%>
            <%--justify-content: space-between;--%>
        <%--}--%>
        <%--.hide{--%>
            <%--display: none;--%>
        <%--}--%>
        <%--input::-webkit-input-placeholder {--%>
            <%--color: #aab2c9;--%>
        <%--}--%>

        <%--input:-moz-placeholder {--%>
            <%--color: #aab2c9;--%>
        <%--}--%>

        <%--input::-moz-placeholder {--%>
            <%--color: #aab2c9;--%>
        <%--}--%>

        <%--input:-ms-input-placeholder {--%>
            <%--color: #aab2c9;--%>
        <%--}--%>


        <%--/** banner--%>
         <%--********************************************************/--%>
        <%--.banner{--%>
            <%--padding-top: 0.69rem;--%>
            <%--width: 100%;--%>
            <%--height: 1.45rem;--%>
            <%--box-sizing: border-box;--%>
            <%--background: url("${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/banner.${2 == leaguesType ? "png" : 'jpg'}") center center no-repeat;--%>
            <%--background-size: 100% 100%;--%>
        <%--}--%>
        <%--.banner::after{--%>
            <%--display: block;--%>
            <%--content: '';--%>
            <%--position: absolute;--%>
            <%--width: 1.085rem;--%>
            <%--height: 0.29rem;--%>
            <%--top: 0.3rem;--%>
            <%--left: 50%;--%>
            <%--transform: translateX(-50%);--%>
            <%--background: url("${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/banner_logo.${2 == leaguesType ? "png" : 'jpg'}") center center no-repeat;--%>
            <%--background-size: 100% 100%;--%>
        <%--}--%>
        <%--.banner .tt{--%>

            <%--font-size: 0.25rem;--%>
            <%--text-align: center;--%>
            <%--color: #ffffff;--%>
            <%--white-space: nowrap;--%>
            <%--text-overflow: ellipsis;--%>
            <%--overflow: hidden;--%>
            <%--max-width: 100%;--%>
        <%--}--%>

        <%--/** form check-form--%>
         <%--********************************************************/--%>

        <%--.form-section {--%>
            <%--flex: 1;--%>
            <%--box-sizing: border-box;--%>
            <%--padding: 0.3rem 0.35rem 0;--%>
        <%--}--%>
        <%--.form-section .input-cell.server-input-cell {--%>
            <%--position: relative;--%>
        <%--}--%>
        <%--.form-section .input-cell.server-input-cell::after{--%>
            <%--content: '';--%>
            <%--position: absolute;--%>
            <%--right: 0;--%>
            <%--top: 50%;--%>
            <%--margin-top: -0.025rem;--%>
            <%--width: 0.09rem;--%>
            <%--height: 0.05rem;--%>
            <%--background: url(${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/arrow-down.png) center center no-repeat;--%>
            <%--background-size: 100% 100%;--%>
        <%--}--%>
        <%--.form-section .input-cell.server-input-cell input{--%>
            <%--padding-right: 0.1rem;--%>
            <%--text-overflow: ellipsis;--%>
            <%--white-space: nowrap;--%>
            <%--overflow: hidden;--%>
        <%--}--%>
        <%--.form-section .input-cell {--%>
            <%--position: relative;--%>
            <%--display: flex;--%>
            <%--justify-content: space-between;--%>
            <%--align-items: center;--%>
            <%--font-size: 0.15rem;--%>
            <%--margin-bottom: 0.33rem;--%>
            <%--white-space: nowrap;--%>
        <%--}--%>
        <%--.form-section .input-cell:last-of-type{--%>
            <%--margin-bottom: 0.4rem;--%>
        <%--}--%>
        <%--.form-section .input-cell .tt{--%>
            <%--min-width: 0.64rem;--%>
            <%--text-align-last: justify;--%>
            <%--text-align: justify;--%>
            <%--color: #4f5c81;--%>
        <%--}--%>
        <%--.form-section .input-cell input{--%>
            <%--display: block;--%>
            <%--flex: 1;--%>
            <%--border: none;--%>
            <%--padding-left: 0.12rem;--%>
            <%--color: #4f5c81;--%>
        <%--}--%>
        <%--.form-section .input-cell .code-btn{--%>
            <%--position: absolute;--%>
            <%--top: 50%;--%>
            <%--right: 0;--%>
            <%--transform: translateY(-50%);--%>
            <%--color: ${baseColor};;--%>
            <%--font-size: 0.13rem;--%>
        <%--}--%>

        <%--.form-section .check-btn{--%>
            <%--width: 3.05rem;--%>
            <%--height: 0.45rem;--%>
            <%--line-height: 0.45rem;--%>
            <%--font-size: 0.16rem;--%>
            <%--text-align: center;--%>
            <%--color: #fff;--%>
            <%--background-color: ${baseColor};--%>
            <%--border-radius: 0.23rem;--%>
            <%--margin: 0 auto;--%>
        <%--}--%>


        <%--/** footer--%>
        <%--********************************************************/--%>
        <%--.footer{--%>
            <%--color: ${baseColor};;--%>
            <%--font-size: 0.11rem;--%>
            <%--padding-bottom: 0.15rem;--%>
            <%--text-align: center;--%>
            <%--margin-top: 15px;--%>
        <%--}--%>

        <%--#toast {--%>
            <%--position: fixed;--%>
            <%--left: 0;--%>
            <%--top: 0;--%>
            <%--width: 100%;--%>
            <%--height: 100%;--%>
            <%--display: flex;--%>
            <%--/* justify-content: center; */--%>
            <%--/* align-items: center; */--%>
            <%--/* z-index: 999; */--%>
        <%--}--%>

        <%--#toast .toast-txt {--%>
            <%--position: absolute;--%>
            <%--max-width: 2.5rem;--%>
            <%--background-color: rgba(0, 0, 0, 0.5);--%>
            <%--font-size: .16rem;--%>
            <%--border-radius: .06rem;--%>
            <%--padding: .06rem .1rem;--%>
            <%--color: #fff;--%>
            <%--left: 50%;--%>
            <%--top: 50%;--%>
            <%--transform: translate(-50%,-50%);--%>
        <%--}--%>

        <%--/* 服务 区域/商圈选择弹窗--%>
        <%--****************************************************************************/--%>

        <%--.server-reg-box{--%>
            <%--position: fixed;--%>
            <%--z-index: 100;--%>
            <%--width: 100%;--%>
            <%--height: 100%;--%>
            <%--left: 0;--%>
            <%--top: 0;--%>
        <%--}--%>
        <%--.server-reg-box .content{--%>
            <%--position: absolute;--%>
            <%--width: 3.75rem;--%>
            <%--height: 100%;--%>
            <%--left: 50%;--%>
            <%--top: 0;--%>
            <%--margin-left: -1.875rem;--%>
            <%--display: flex;--%>
            <%--flex-direction: column;--%>
            <%--justify-content: space-between;--%>
            <%--align-items: center;--%>
            <%--background: #fff;--%>
        <%--}--%>
        <%--.server-reg-box .content .tips{--%>
            <%--background: #f9f9f9;--%>
            <%--color: #333333;--%>
            <%--font-size: 0.11rem;--%>
            <%--text-align: center;--%>
            <%--width: 100%;--%>
            <%--height: 0.25rem;--%>
            <%--line-height: 0.25rem;--%>
        <%--}--%>

        <%--.server-reg-box .content .list{--%>
            <%--width: 100%;--%>
            <%--flex: 1;--%>
            <%--font-size: 0.14rem;--%>
            <%--display: flex;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul{--%>
            <%--overflow-y: auto;--%>
            <%--flex: 1;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul.reg-list{--%>
            <%--background: #f4f4f4;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul.section.list{--%>
            <%--background: #fff;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul li {--%>
            <%--padding-left: 0.27rem;--%>
            <%--box-sizing: border-box;--%>
            <%--height: 0.45rem;--%>
            <%--line-height: 0.45rem;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul li.on{--%>
            <%--color: ${baseColor};;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul.reg-list li.on{--%>
            <%--background: #fff;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul.reg-list li span{--%>
            <%--font-size: 0.13rem;--%>
            <%--margin-left: 0.02rem;--%>
        <%--}--%>
        <%--.server-reg-box .content .list-ul.reg-list li{}--%>
        <%--.server-reg-box .content .list-ul.section.list li{}--%>

        <%--.server-reg-box .content .confirm-btn{--%>
            <%--height: 0.45rem;--%>
            <%--line-height: 0.45rem;--%>
            <%--width: 100%;--%>
            <%--color: #fff;--%>
            <%--font-size: 0.16rem;--%>
            <%--text-align: center;--%>
            <%--background: ${baseColor};;--%>
        <%--}--%>

        @charset "UTF-8";

        /**
         * @desc 邀请注册
         * @author LiuChiLei
         * @date 2018-09-06
         */
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

        input::-webkit-input-placeholder {
            color: #aab2c9;
        }

        input:-moz-placeholder {
            color: #aab2c9;
        }

        input::-moz-placeholder {
            color: #aab2c9;
        }

        input:-ms-input-placeholder {
            color: #aab2c9;
        }


        /** banner
         ********************************************************/
        .banner {
            padding-top: 0.69rem;
            width: 100%;
            height: 1.45rem;
            box-sizing: border-box;
            background: url("${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/banner.${(1 == leaguesType) ? "png" : 'jpg'}") center center no-repeat;
            background-size: 100% 100%;
        }

        .banner .tt {

            font-size: 0.25rem;
            text-align: center;
            color: #ffffff;
            white-space: nowrap;
            text-overflow: ellipsis;
            overflow: hidden;
            max-width: 100%;
        }

        /** form check-form
         ********************************************************/

        .form-section {
            flex: 1;
            box-sizing: border-box;
            padding: 0.3rem 0.35rem 0;
        }

        .form-section .input-cell.server-input-cell {
            position: relative;
        }

        .form-section .input-cell.server-input-cell::after {
            content: '';
            position: absolute;
            right: 0;
            top: 50%;
            margin-top: -0.025rem;
            width: 0.09rem;
            height: 0.05rem;
            background: url(../images/arrow-down.png) center center no-repeat;
            background-size: 100% 100%;
        }

        .form-section .input-cell.server-input-cell input {
            padding-right: 0.1rem;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

        .form-section .input-cell {
            position: relative;
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 0.15rem;
            margin-bottom: 0.33rem;
            white-space: nowrap;
        }

        .form-section .input-cell:last-of-type {
            margin-bottom: 0.4rem;
        }

        .form-section .input-cell .tt {
            min-width: 0.64rem;
            text-align-last: justify;
            text-align: justify;
            color: #4f5c81;
        }

        .form-section .input-cell input {
            display: block;
            flex: 1;
            border: none;
            padding-left: 0.12rem;
            color: #4f5c81;
        }

        .form-section .input-cell .code-btn {
            position: absolute;
            top: 50%;
            right: 0;
            transform: translateY(-50%);
            color: #577bf5;
            font-size: 0.13rem;
        }

        .form-section .check-btn {
            width: 3.05rem;
            height: 0.45rem;
            line-height: 0.45rem;
            font-size: 0.16rem;
            text-align: center;
            color: #fff;
            background-color: #577bf5;
            border-radius: 0.23rem;
            margin: 0 auto;

        }


        /** footer
         ********************************************************/
        .footer {
            color: #577bf5;
            font-size: 0.11rem;
            padding-bottom: 0.15rem;
            text-align: center;
        }

        /* 封装的公用弹窗样式
         ****************************************************************************/
        #toast {
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            z-index: 999;
        }

        #toast .toast-txt {
            position: absolute;
            max-width: 2.5rem;
            background-color: rgba(0, 0, 0, 0.5);
            font-size: .16rem;
            border-radius: .06rem;
            padding: .06rem .1rem;
            color: #fff;
        }

        /* 服务 区域/商圈选择弹窗
         ****************************************************************************/

        .server-reg-box {
            position: fixed;
            z-index: 100;
            width: 100%;
            height: 100%;
            left: 0;
            top: 0;
        }

        .server-reg-box .content {
            position: absolute;
            width: 3.75rem;
            height: 100%;
            left: 50%;
            top: 0;
            margin-left: -1.875rem;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            background: #fff;
        }

        .server-reg-box .content .tips {
            background: #f9f9f9;
            color: #333333;
            font-size: 0.11rem;
            text-align: center;
            width: 100%;
            height: 0.25rem;
            line-height: 0.25rem;
        }

        .server-reg-box .content .list {
            width: 100%;
            flex: 1;
            font-size: 0.14rem;
            display: flex;
        }

        .server-reg-box .content .list-ul {
            overflow-y: auto;
            flex: 1;
        }

        .server-reg-box .content .list-ul.reg-list {
            background: #f4f4f4;
        }

        .server-reg-box .content .list-ul.section.list {
            background: #fff;
        }

        .server-reg-box .content .list-ul li {
            padding-left: 0.27rem;
            box-sizing: border-box;
            height: 0.45rem;
            line-height: 0.45rem;
        }

        .server-reg-box .content .list-ul li.on {
            color: ${4 == leaguesType ? '#00A49D' : '#3396fb'};
        }

        .server-reg-box .content .list-ul.reg-list li.on {
            background: #fff;
        }

        .server-reg-box .content .list-ul.reg-list li span {
            font-size: 0.13rem;
            margin-left: 0.02rem;
        }

        .server-reg-box .content .list-ul.reg-list li {}

        .server-reg-box .content .list-ul.section.list li {}

        .server-reg-box .content .confirm-btn {
            height: 0.45rem;
            line-height: 0.45rem;
            width: 100%;
            color: #fff;
            font-size: 0.16rem;
            text-align: center;
            background: ${4 == leaguesType ? '#00A49D' : '#FBE201'};
        }

        /* 以下是 修改覆盖样式， 新增只需修改这些 */


        /** banner
         ********************************************************/
        .banner {
            padding-top: 0.84rem;
            background: url("${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/banner.${(1 == leaguesType) ? "png" : 'jpg'}") center center no-repeat;
            background-size: 100% 100%;
        }
        .banner::after{
            display: block;
            content: '';
            position: absolute;
            width: 1.085rem;
            height: 0.29rem;
            top: 0.3rem;
            left: 50%;
            transform: translateX(-50%);
            background: url("${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/banner_logo.${(2 == leaguesType or 4 == leaguesType) ? "png" : 'jpg'}") center center no-repeat;
            background-size: 100% 100%;
        }

        .banner .tt {
            font-size: 0.23rem;
            color: ${null != bannerTt ? bannerTt : '#fff'};
            /* color: ${7 == leaguesType ? '#000' : '#fff'}; */
        }

        /** form check-form
         ********************************************************/

        .form-section .input-cell.server-input-cell::after {
            background: url("${statics}/images/inviteImages/${null != leaguesType ? leaguesType : 'hft'}/arrow-down.png") center center no-repeat;
            background-size: 100% 100%;
        }

        .form-section .input-cell .tt {
            color: #282828;
        }

        .form-section .input-cell input {
            color: #282828;
        }

        .form-section .input-cell .code-btn {
            color: ${null != getCodeColor ? getCodeColor : '#577BF5'};
        }

        .form-section .check-btn {
        	color: ${null != checkBtnTt ? checkBtnTt : '#fff'};
            /* color: ${7 == leaguesType ? '#000' : '#fff'}; */
            background: ${null != baseColor ? baseColor : '#068efe'};
            /* background: ${4 == leaguesType ? "#FFCB05" : '#068efe'}; */
        }


        /** footer
         ********************************************************/
        .footer {
            color: #068efe;
            font-size: 0.11rem;
            padding-bottom: 0.15rem;
            text-align: center;
            display: none;
        }

        /* 服务 区域/商圈选择弹窗
         ****************************************************************************/

        .server-reg-box .content .list-ul li.on {
            color: ${4 == leaguesType ? '#00A49D' : '#068efe'};
        }

        .server-reg-box .content .confirm-btn {
            background: ${4 == leaguesType ? '#00A49D' : '#3396fb'};
            color: #fff;
        }


        #loadDiv {
            position: absolute;
            width: 100%;
            height: 120px;
            display: flex;
            margin: 0 auto;
            top:40%;
            z-index: 99;
            display: none;
        }
        #loadDiv img{
            margin-left: 40%;
        }

    </style>
</head>
<body>
<div id="app">
    <div id="loadDiv">
        <img src="${statics}/images/loading-icon2.gif">
    </div>
    <!-- S banner -->
    <div class="banner">
        <div class="tt">欢迎加入${compName}</div>
    </div>
    <!-- E banner -->

    <!-- S form check-form -->
    <div class="form-section phone-check-form ">
        <div class="input-cell">
            <div class="tt">注册手机:</div>
            <input type="text" id="phoneInput" maxlength="11" placeholder="请输入手机号">
        </div>
        <div class="input-cell">
            <div class="tt">短信验证:</div>
            <input type="text" id="codeInput" maxlength="6" placeholder="请输入短信验证码">
            <div class="code-btn get-code">获取验证码</div>
        </div>
        <div class="check-btn phone-check-btn">验 证</div>
    </div>
    <!-- E form check-form -->

    <!-- S form check-form -->
    <div class="form-section submit-form hide">
        <div class="input-cell"><div class="tt">注册手机:</div><input type="text" maxlength="11" value="" readonly id="showUserMobile"></div>
        <div class="input-cell"><div class="tt">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</div><input type="text" maxlength="10" value="" readonly id="showUserName"></div>
        <div class="input-cell"><div class="tt">角&nbsp;&nbsp;&nbsp;&nbsp;色:</div><input type="text" maxlength="20" value="" readonly id="showRoleName"></div>
        <div class="input-cell"><div class="tt">${organizationType eq '1' ? '所属组织' : '所属门店' }:</div><input type="text" maxlength="20" value="" readonly id="showDeptName"></div>
        <div class="input-cell server-input-cell"><div class="tt">服务区域:</div><input type="text" id="showServiceZone" placeholder="请选择您服务的区域" value="" readonly></div>
        <div class="input-cell"><div class="tt">登录密码:</div><input type="password" id="password" maxlength="20" placeholder="请输入密码"></div>
        <div class="input-cell"><div class="tt">确认密码:</div><input type="password" id="passwordRep" maxlength="20" placeholder="请再次输入密码"></div>
        <div class="check-btn submit-form-btn">提 交</div>
    </div>
    <!-- E form check-form -->

    <!-- S footer -->
    <div class="footer" style="display: ${null eq leaguesType ? 'block' : "none"}">好房通客服电话：028-8888-9666 转4</div>
    <!-- E footer -->

    <!-- S 服务 区域/商圈选择弹窗 -->
    <div class="server-reg-box hide">
        <div class="content">
            <div class="tips">最多可选择3个服务商圈</div>
            <div class="list">
                <ul class="list-ul reg-list">
                </ul>
                <ul class="list-ul section-list">
                </ul>
            </div>
            <div class="confirm-btn">确定</div>
        </div>
    </div>
    <!-- E 服务 区域/商圈选择弹窗 -->
</div>
<script>
    var sureServer = [];    //当前用户 确认的服务区域
    var selectServer = [];  //当前 正在选择的服务区域
</script>
<script language="javascript" src="${statics}/publicJs/inviteJs/jquery.min.js"></script>
<script language="javascript" src="${statics}/publicJs/inviteJs/index.js"></script>
<script type="application/javascript">

    var regIds,sectionIds,inviteId,isSuccessSubmit = 0;

    var sureServerArr = [
        // {regId:'2',regName:'青羊区',sectionId:'3',sectionName:'少城'},
    ];
    //当前 正在选择的服务区域
    var selectServerArr = [

    ];
    //记录行政区的选择数量
    var regSelectNum = {};


    //获取验证码
    $('.get-code').on('click',function(){
        //验证号码
        var _this = this;

        var phone = $('#phoneInput').val();
        if (!phone){
            toast('请输入手机号码'); return;
        }
        if (phone.length != 11){
            toast('请输入正确手机号码');return;
        }
        if(isSuccessSubmit == 1) {
            toast('正在提交请稍后。');return;
        }

        //避免重复请求
        if ($(_this).hasClass('wait_resend')) {return false;}
        //验证码获取成功后,倒计时
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "${ctx}openApi/inviteRegist/sendCompInviteRegistSms",
            data: {"param": "${param.param}","userMobile":phone},
            beforeSend:function() {
                isSuccessSubmit = 1;
            },
            complete:function() {
                isSuccessSubmit = 0;
            },
            success: function(result){
                if(result.errCode != 200) {
                    toast(result.errMsg);return;
                } else {
                    $(_this).addClass('wait_resend');
                    $('.get-code').text('60s');
                    var time_out = 60;
                    var set_time_out = setInterval(function () {
                        time_out--;
                        if (time_out == 0) {
                            $('.get-code').removeClass('wait_resend').text('重新获取验证码');
                            clearInterval(set_time_out);
                        } else {
                            var new_tip = time_out + 's';
                            $('.get-code').text(new_tip).addClass("wait_resend");
                        }
                    }, 1000);
                }
            }
        });
    });

    /** 注册手机验证 */
    $('.phone-check-btn').on('click',function(){
        var phone = $('#phoneInput').val();
        var code = $('#codeInput').val();
        if (!phone || phone.length != 11) {
            toast('请输入正确手机号');return;
        }
        if (!code) {
            toast('请输入验证码'); return;
        }

        $.ajax({
            type: "POST",
            dataType: "json",
            url: "${ctx}openApi/inviteRegist/validateCompInviteMsg",
            data: {"param": "${param.param}","userMobile":phone, "code": code},
            success: function(result){
                if(result.errCode != 200) {
                    toast(result.errMsg);return;
                } else {
                    var resData = result.data;
                    $("#showUserMobile").val(resData.userMobile);
                    $("#showUserName").val(resData.userName);
                    $("#showRoleName").val(resData.roleName);
                    $("#showDeptName").val(resData.deptName);

                    regIds = resData.serviceReg;
                    sectionIds = resData.serviceZoneId;
                    inviteId = resData.inviteId;

                    if(resData.serviceString) {
                        //$("#showServiceZone").val(resData.serviceString);
                    }
                    //验证成功后:执行 , 展示注册弹窗
                    $('.phone-check-form').hide();
                    $('.submit-form').show();

                    //请求 行政区数据
                    initRegLit();
                    sureServerArr = resData.serviceString;
                    //初始化服务区域
                    setServerStr(sureServerArr);
                }
            }
        });
    });

    function initRegLit(){
        // 请求行政区数据
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "${ctx}openApi/inviteRegist/getCompInviteRegList",
            data: {"param": "${param.param}"},
            success: function(result){
                if(result.errCode != 200) {
                    toast(result.errMsg);return;
                } else {
                    var resList = result.data;
                    var regHtml = "";
                    var regIdStr = regIds.split(" ");
                    var checkedRegId = 0;
                    $.each(resList, function (k, v) {
                        // 遍历已选数据
                        var regId = v.regId;
                        var isChecked='';
                        if(regIdStr.indexOf(regId+",") != "-1" && checkedRegId == 0) {
                            isChecked = "class='on'";
                            checkedRegId = regId;
                        }
                        regHtml+="<li "+isChecked+" data-name='"+v.regName+"' data-id='"+regId+"'>"+v.regName+"<span></span></li>"
                    });
                    $(".reg-list").html(regHtml);


                }
            }
        });
    }


    /** 选择服务区域 */
    $('#showServiceZone').on('click',function(){
        pushHistory('选择服务区域', '#serverReg');
        document.title = '选择服务区域';
        $('.server-reg-box').show();
        // 正在选中商圈初始化
        selectServerArr = sureServerArr;
        var selectRegId = '';
        var selectRegName = '';
        //获取 选中 具体的 selectRegId
        if (selectServerArr.length > 0){
            selectRegId = selectServerArr[0]['regId']
            selectRegName = selectServerArr[0]['regName']
        }else{
            selectRegId = $('.reg-list li').eq(0).data('id');
            selectRegName = $('.reg-list li').eq(0).data('name');
        }
        $('.reg-list li[data-id=' + selectRegId + ']').addClass('on').siblings().removeClass('on');


        // 请求行政区 的商圈数据
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "${ctx}openApi/inviteRegist/getCompInviteSectionList",
            data: {"param": "${param.param}", "regId": selectRegId},
            success: function(result){
                if(result.errCode != 200) {
                    toast(result.errMsg);return;
                } else {
                    var sectionList = result.data;
                    updateSectionListHtml(sectionList, selectRegName);
                }
            }
        });

    });

    /** 点击行政区,请求商圈 */
    $('.reg-list').on('click', 'li',function () {
        if($(this).hasClass('on'))return;
        if($(this).find('span').text() == ''){
            //最多选择 2个行政区
            if (Object.keys(regSelectNum).length >= 2) {
                toast('最多选择2个行政区')
                return;
            }
            //最多选择 3个商圈
            if (selectServerArr.length >= 3) {
                toast('最多选择3个商圈')
                return;
            }
        }
        $(this).addClass('on').siblings().removeClass('on');
        var regId = $(this).data('id');
        var regName = $(this).data('name');

        // 请求行政区 的商圈数据
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "${ctx}openApi/inviteRegist/getCompInviteSectionList",
            data: {"param": "${param.param}", "regId": regId},
            success: function(result){
                if(result.errCode != 200) {
                    toast(result.errMsg);return;
                } else {
                    var sectionList = result.data;
                    updateSectionListHtml(sectionList, regName);
                }
            }
        });

    });

    /** 服务区域确定 */
    $('.server-reg-box .confirm-btn').on('click', function () {
        //获取当前选中的区域
        sureServerArr = selectServerArr;
        setServerStr(sureServerArr);

        //关闭选择弹窗
        $('.server-reg-box').hide();
        window.history.go(-1);
        document.title = '注册验证';
    });

    /** 提交注册信息 */
    $('.submit-form-btn').on('click', function () {
        if(!regIds) {
            toast('请先选择服务区域');return;
        }
        if(!sectionIds) {
            toast('请先选择服务商圈');return;
        }
        //密码验证
        var password = $('#password').val();
        var passwordRep = $('#passwordRep').val();
        if (!password) {
            toast('请先输入密码');return;
        }
        if (!passwordRep) {
            toast('请再次输入密码');return;
        }
        if (password != passwordRep) {
            toast('两次输入的密码不匹配'); return;
        }

        var reg = new RegExp("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
        if (!reg.test(password)) {
            toast("密码只能为6-20位数字和字母的组合");
            return false;
        }
        var regSectionObj = getServerObj(sureServerArr);
        if(isSuccessSubmit == 1) {
            toast('正在提交请稍后。');return;
        }
        //提交
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "${ctx}openApi/inviteRegist/addCompInviteUser",
            beforeSend:function() {
                $("#loadDiv").show();
                isSuccessSubmit = 1;
            },
            complete:function() {
                isSuccessSubmit = 0;
                $("#loadDiv").hide();
            },
            data: {"param": "${param.param}", "password": password, "regIds":regSectionObj.regIds,
                "sectionIds":regSectionObj.sectionIds,"serviceZone": regSectionObj.serviceZone,"inviteId":inviteId},
            success: function(result){
                if(result.errCode != 200) {
                    toast(result.errMsg);return;
                } else {
                    //提交成功后 跳转登录页面
                    window.location.href = '${ctx}openApi/inviteRegist/success.htm?param=${param.param}'
                }
            }
        });

    });

    /** 商圈选择 */
    $('.section-list').on('click', 'li', function () {
        var regId = $(this).data('regid');
        var regName = $(this).data('regname');
        var sectionId = $(this).data('id');
        var sectionName = $(this).text();
        if ($(this).hasClass('on')){
            //删除所选择的商圈
            selectServerArr.map(function(item,index){
                if (sectionId == item.sectionId){
                    selectServerArr.splice(index, 1)
                }
            });
            updateSectionStaus();
            $(this).removeClass('on')
        }else{
            //增加所选择的商圈

            //最多选择 3个商圈
            if (selectServerArr.length >= 3){
                toast('最多选择3个商圈')
                return;
            }

            selectServerArr.push({
                regId: regId+'', regName:  regName, sectionId: sectionId+'', sectionName: sectionName
            });
            $(this).addClass('on');
            updateSectionStaus();
        }


    });
</script>
</body>
</html>