// 页面所需配置
var payConfig = {

    deptName:"",
    deptAddr:"",
    deptTele:"",
    deptContact:"",
    unitPrice:"",
    deptNo:"",
    pwdDesc:"",
    copyInfo:""
};

$(document).ready(function(){

    payConfig.deptName = deptName;
    payConfig.deptAddr = deptAddr;
    payConfig.deptTele = deptTele;
    payConfig.deptContact = deptContact;
    payConfig.deptNo = deptNo;
    payConfig.pwdDesc = pwdDesc;
    $(".dept_success_info").html("门店编号："+payConfig.deptNo+"<br>验&nbsp;&nbsp;证&nbsp;码："+payConfig.pwdDesc+"<br>下载地址：www.hftsoft.com");
    $(".con-left.pay-result").show();
    $("#payForName").html("门店信息");
    $("#payForUseage").html("门店名称：<span>"+payConfig.deptName+"</span><br>门店地址：<span>"+payConfig.deptAddr+"</span><br>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<span>"+payConfig.deptTele+"</span><br>店&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：<span>"+payConfig.deptContact+"</span>");

    payConfig.copyInfo="门店编号："+payConfig.deptNo+"\n验证码："+payConfig.pwdDesc+"\n下载地址：www.hftsoft.com";
    /*parent.document.getElementById("custObj").updateUi();*/
});

$('.copy_info').on('click', function() {
    parent.document.getElementById("custObj").setAddDeptInfoToClipBoard(payConfig.copyInfo,"2");
});



