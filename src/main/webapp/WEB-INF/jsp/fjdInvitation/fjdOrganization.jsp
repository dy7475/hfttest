<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en">

<head>
<%--    <meta charset="UTF-8">--%>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<%--    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />--%>
    <link rel="stylesheet" href="${statics}fjdInvitation/css/organization.css">
    <title>房基地</title>
    <script>
        function calculateSize() {
            var clientWidth = window.innerWidth || document.documentElement.clientWidth;
            if (clientWidth >= 640) { clientWidth = 640; }
            document.documentElement.style.fontSize = clientWidth / 3.75 + 'px';
        }
        calculateSize();
        window.addEventListener('resize', calculateSize);
    </script>
</head>

<body>
<div data-v-7bc4a477="" class="toast-model">
    <div data-v-7bc4a477="" class="cont">
        <div data-v-7bc4a477="" class="title">温馨提示</div>
        <div data-v-7bc4a477="" class="desc">欢迎您加入我的战队，未来我们将成为最卓越的合伙人！</div>
        <div data-v-7bc4a477="" class="btn">确定</div>
    </div>
</div>
<div class="g-head">
    <img src="${statics}fjdInvitation/images/fjd_logo.png" alt="">
    <p>欢迎加入中国房产经纪人创业平台</p>
</div>
<div id="loadDiv">
    <img src="${statics}images/loading-icon2.gif">
</div>
<form id="g-form" name="input" onsubmit="return false">
    <input value="${cityId}" name="cityId" id="cityId" type="hidden"/>
    <input value="${compId}" name="compId" id="compId" type="hidden"/>
    <input value="${deptId}" name="deptId" id="deptId" type="hidden"/>
    <input value="${inviteId}" name="inviteId" id="inviteId" type="hidden"/>
    <p class="g-title">请完善个人详细信息</p>

    <p class="g-subtitle">联系信息</p>
    <ul class="info-list">
        <li>
            <span>备用电话:</span>
            <input type="text" name="userOfficeph" maxlength="11" placeholder="请输入备用电话" onblur="value=value.replace(/[^0123456789]/g,'')" onkeyup="value=value.replace(/[^0123456789]/g,'')">
        </li>
        <li>
            <span>紧急联系人:</span>
            <input type="text" name="emergencyContact" maxlength="20" placeholder="请输入紧急联系人">
        </li>
        <li>
            <span>紧急电话:</span>
            <input type="text" name="userFixedph" maxlength="11" placeholder="请输入紧急电话" onblur="value=value.replace(/[^0123456789]/g,'')" onkeyup="value=value.replace(/[^0123456789]/g,'')">
        </li>
        <li>
            <span>家庭地址:</span>
            <input type="text" name="userAddress" maxlength="32" placeholder="请输入家庭地址">
        </li>
    </ul>

    <p class="g-subtitle">个人信息</p>
    <ul class="info-list">
        <li>
            <span>出生日期:</span>
            <input readonly class="form-control" type="text" id="date-group1-2" name="userBirthday" placeholder="请选择出生日期">
            <img src="${statics}/fjdInvitation/images/more_icon.png" alt="">
        </li>
        <li>
            <span>身份证号：</span>
            <input type="text" name="userIccode" maxlength="18" placeholder="请输入身份证号" onblur="value=value.replace(/[^\1-9a-zA-z]/g,'')" onKeyUp="value=value.replace(/[^\1-9a-zA-z]/g,'')">
        </li>
        <li>
            <span>民      族:</span>
            <input type="text" name="nation" maxlength="32" placeholder="请输入民族">
        </li>
        <li class>
            <span>婚      姻:</span><span class="placeholder-marriage">请选择婚姻</span>
            <input type="text" id="marriage-input" name="maritalStatus" style="display: none;" readonly  placeholder="请选择婚姻">
            <img src="${statics}/fjdInvitation/images/more_icon.png" alt="">
        </li>
        <li>
            <span>籍     贯：</span>
            <input type="text" name="placeOfOrigin" maxlength="10" placeholder="请输入籍贯">
        </li>
        <li>
            <span>学     历:</span><span class="placeholder-education">请选择学历</span>
            <input type="text" id="education-input" name="userSchlrecord" readonly style="display: none;" placeholder="请选择学历">
            <img src="${statics}/fjdInvitation/images/more_icon.png" alt="">
        </li>
        <li>
            <span>专     业：</span>
            <input type="text" name="userField" maxlength="15" placeholder="请输入专业">
        </li>
        <li>
            <span>房地产工作年限:</span>
            <input type="text" name="workYear" maxlength="4" placeholder="请输入房地产工作年限" onKeyUp="value=workingLife(this.value);">
        </li>
    </ul>

    <div class="g-enclosure"> <span class="g-enclosure-title">身份证</span><span class="g-enclosure-text">（最多上传2张）</span></div>
    <ul class="img-list user-id-img">
        <li id="add-ID"><input type="file" accept="image/*" multiple="multiple" id="file-id" class="file-img" value=""></li>
        <input name="userIccodeUrl" id="userIccodeUrl" type="hidden" value="">
    </ul>
    <div class="g-enclosure"> <span class="g-enclosure-title">学历证书</span><span class="g-enclosure-text">（最多上传4张）</span></div>
    <ul class="img-list g-diploma">
        <li id="add-Education"><input name="educationUrl" type="file" accept="image/*" multiple="multiple" id="file-education" class="file-img" value=""></li>
        <input name="educationUrl" id="educationUrl" type="hidden" value="">
    </ul>

    <button class="g-foot-btn">提交</button>
</form>


<div class="picker-box marriage">
    <ul class="picker-box-handle">
        <p class="picker-box-title">请选择婚姻</p>
        <li data-index='0'>未婚</li>
        <li data-index='1'>已婚</li>
        <li data-index='2'>丧偶</li>
        <li data-index='3'>离异</li>
    </ul>
</div>
<div class="picker-box education">
    <ul class="picker-box-handle">
        <p class="picker-box-title">请选择学历</p>
        <li data-index='1'>初中</li>
        <li data-index='2'>高中</li>
        <li data-index='3'>中职</li>
        <li data-index='4'>大专</li>
        <li data-index='5'>本科</li>
        <li data-index='6'>硕士</li>
        <li data-index='7'>博士</li>
    </ul>
</div>

<div class="message-box"></div>

</body>
<script type="text/javascript">
    var erpWebUrl = '${erpWebUrl}';
    // var erpWebUrl = 'http://192.168.200.169:8081/erpWeb/';
    var adminWebUrl = '${adminWebUrl}';
    var crmWebUrl = '${crmWebUrl}';
    var statics = '${statics}';
    var paramData = '${paramData}';

</script>
<script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
<script src="${statics}common/js/common.js" type="text/javascript"></script>
<script src="${statics}fjdInvitation/js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script src="${statics}fjdInvitation/js/organization.js?t=1"></script>
<script src="${statics}fjdInvitation/js/jdate.min.js"></script>

</html>