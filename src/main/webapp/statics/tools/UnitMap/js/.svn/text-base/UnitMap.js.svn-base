// 对于版本检测，设置到最小。所需的Flash Player版本，或0（或0.0.0），因为
// 没有版本检测。
var swfVersionStr = "11.1.0";var isOkInfo = false;
// 要使用快速安装，设置 playerProductInstall.swf，否则空字符串。
var xiSwfUrlStr = "UnitMap/playerProductInstall.swf";
var flashvars = {};
var params = {
    quality:"high",
    bgcolor:"#262626",
    allowscriptaccess:"always",
    allowFullScreenInteractive:"true",
    wmode: "window",
    menu: false,
    showmenu:false
};
var HousingData = {
    buildName: "",
    buildId: ""
}
var attributes = {
    id: "instdeco",
    name: "instdeco",
    align: "middle"
};
swfobject.embedSWF("UnitMap/instdeco.swf", "flashContent", "100%", "100%", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
// 启用所以显示flashContent DIV情况下，它没有与替换
// SWF 对象。
swfobject.createCSS("#flashContent", "display:block;text-align:left;");

var ApplicationMode = {
    DEFAULT: 0,
    SUGGESTION: 1,
    THIRD: 2
};
var LOGO_URL = "css/bd_logo.png"  //Logo 图标
var appConfig = {
    appMode: ApplicationMode.THIRD,
    appLogo: LOGO_URL,
    userConfig: {
        userName: ''
    },
    planConfig: {
        planId: '',
        planName: '',
        areaId: "",
        commId: ""
    },
    suggestionConfig: {
        userName: '',
        planId: '',
        planName: '',
        askId: "",
        cmtId: ""
    },
    thirdConfig: {
        appKey: '0JJlkG0vut',
        appSecret: 'mANmBdR2mTfbR0G0rJkGtb5EdqNR4z73'
    }
};
var saved = false;
window.sprashLogo = LOGO_URL;

window.getAppConfig = function () {
    setTimeout(function () {
        document.getElementById("divSearch").style.display = "block";
    }, 1000);
    return appConfig;
};

window.appSaved = function (data) {
    saved = true;
    if (document.getElementById("CCustPreView").getAttribute("data-flap") == "true") {
        document.getElementById("CCustPreView").setAttribute("data-flap", "false");
        document.getElementById("CCustPreView").style.display = "block";
        document.getElementById("CCustPreView").getHouseTypePic(data.planId);
    }
};

window.appChanged = function (data) {
    saved = true;
};

window.appExit = function (data) {
    window.onresize();
    if (document.getElementById("divClose").style.display.trim() == "none" || document.getElementById("divClose").style.display.trim() == "") {
        document.getElementById("divMaskLayer").style.display = "block"; document.getElementById("SelFunObj").style.display = "block";
        document.getElementById("SelFunObj").setPicInfo(HousingData.buildName, HousingData.buildId, data.planId);
    } else {
        document.getElementById("custObj").saveSucc(data.planId);
    }
};

window.onbeforeunload = function () {
    if (saved) {
        return;
    } else {
        return "离开前请确保已保存您的户型设计";
    }
};
function DocumentLoad() {
    document.getElementById("instdeco").focus();
    document.getElementById("SelFunObj").style.width = (document.body.clientWidth - 236) + "px";
    document.getElementById("SelFunObj").style.height = (document.body.clientHeight) + "px";

    document.getElementById("SelHouseTypePic").style.width = (document.body.clientWidth - 236) + "px";
    document.getElementById("SelHouseTypePic").style.height = (document.body.clientHeight) + "px";
    document.getElementById("divMaskLayer").style.height = (document.body.clientHeight - 102) + "px";

    document.getElementById("CCustPreView").style.height = (document.body.clientHeight) + "px";
    document.getElementById("CCustPreView").style.width = (document.body.clientWidth - 236) + "px";
    if (document.body.clientWidth > 1135) {
        document.getElementById("divPreview").style.left = "925px";
    } else {
        document.getElementById("divPreview").style.left = "604px";
    }
}
window.onresize = function () {
    document.getElementById("SelFunObj").style.width = (document.body.clientWidth - 236) + "px";
    document.getElementById("SelFunObj").style.height = (document.body.clientHeight) + "px";

    document.getElementById("SelHouseTypePic").style.width = (document.body.clientWidth - 236) + "px";
    document.getElementById("SelHouseTypePic").style.height = (document.body.clientHeight) + "px";
    document.getElementById("divMaskLayer").style.height = (document.body.clientHeight - 102) + "px";

    document.getElementById("CCustPreView").style.height = (document.body.clientHeight) + "px";
    document.getElementById("CCustPreView").style.width = (document.body.clientWidth - 236) + "px";
    var resize = setTimeout(function () {
        document.getElementById("SelFunObj").style.width = (document.body.clientWidth - 236) + "px";
        document.getElementById("SelFunObj").style.height = (document.body.clientHeight) + "px";

        document.getElementById("SelHouseTypePic").style.width = (document.body.clientWidth - 236) + "px";
        document.getElementById("SelHouseTypePic").style.height = (document.body.clientHeight) + "px";
        document.getElementById("divMaskLayer").style.height = (document.body.clientHeight - 102) + "px";
        clearTimeout(resize);
    }, 20);

    if (document.body.clientWidth > 1135) {
        document.getElementById("divPreview").style.left = "925px";
    } else {
        document.getElementById("divPreview").style.left = "604px";
    }
}

function LoadUnitMap(planId) {
    //3FO4K038DO22
    window.appConfig.planConfig.planId = planId;
    window.appConfig.planConfig.planName = "";
    window.appConfig.planConfig.areaId = "";
    window.appConfig.planConfig.commId = "";
    swfobject.getObjectById('instdeco').open(window.appConfig);
    document.getElementById("SelHouseTypePic").style.display = "none";
    document.getElementById("divMaskLayer").style.display = "none";
}
function ClearUnitMap() {
    window.appConfig.planConfig.planId = "";
    window.appConfig.planConfig.planName = "";
    window.appConfig.planConfig.areaId = "";
    window.appConfig.planConfig.commId = "";
    swfobject.getObjectById('instdeco').open(window.appConfig);
}
function SearchBtn(name, id) {
    window.onresize();
    document.getElementById("SelFunObj").style.display = "none";
    document.getElementById("divMaskLayer").style.display = "block"; document.getElementById("SelHouseTypePic").style.display = "block";
    document.getElementById("SelHouseTypePic").setSerchConditon(name, id);
}
function clearData(){
    HousingData.buildName = "";
    HousingData.buildId = "";
}
function setFunData(buildName, buildId) {
    HousingData.buildName = buildName;
    HousingData.buildId = buildId;
}
function HideWidget() {
    document.getElementById("SelHouseTypePic").style.display = "none";
    document.getElementById("SelFunObj").style.display = "none";
    document.getElementById("divMaskLayer").style.display = "none";
}
function ClosePage() {
    document.getElementById("custObj").closeWidget();
}
function ClosePreview() {
    document.getElementById("CCustPreView").style.display = "none";
    
}
function PreviewPlain() {
    document.getElementById("CCustPreView").setAttribute("data-flap", "true");
    swfobject.getObjectById('instdeco').save();
}
function startDraw() {
	isOkInfo = true;
    document.getElementById('divPreview').style.display = "none";
    document.getElementById("divClose").style.display = "none";
}
function endDraw() {
	isOkInfo = false;
    document.getElementById('divPreview').style.display = "block";
    if (document.getElementById("divClose").getAttribute("showStatus") == "1"){
    	document.getElementById("divClose").style.display = "block";
    }
}
window.appReady = function(){
	if(isOkInfo == false){
		document.getElementById("divPreview").style.display = "block";
	}
}
window.appLoaded = function(){
	var showStatus = document.getElementById("custObj").getShowClose();
    if (showStatus == "1") {
    	
    	document.getElementById("divClose").setAttribute("showStatus","1");
        document.getElementById("divClose").style.display = "block";
        var planId = document.getElementById("custObj").getPlanId();
        LoadUnitMap(planId);
    }else{
    	
    	document.getElementById("divClose").setAttribute("showStatus","0");
    }
}