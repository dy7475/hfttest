var common = {
    //验证手机号
    CheckInputMobile: function (oInput) {

        if ('' != oInput.value.replace(/\d{1,}\.{0,1}\d{0,}/, '')) {
            oInput.value = oInput.value.match(/\d{1,}\.{0,1}\d{0,}/) == null ? '' : oInput.value.match(/\d{1,}\.{0,1}\d{0,}/);
        }
        if (oInput.value.match(/\d{1,}\.\d{2,}/)) {
            oInput.value = oInput.value.match(/\d{1,}\.\d{1}/);
        }

        if (oInput.value.match(/^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|19[0-9]|14[0-9])[0-9]{8}$/)) {
            oInput.value = oInput.value.trim();
        } else if (oInput.value.trim().length > 11) {
            oInput.value = oInput.value.trim().substring(0, 11);
            //            alert('手机号是11位哦');
        } else if (oInput.value.trim().length == 3 && !oInput.value.match(/^13[0-9]|15[012356789]|17[0123456789]|18[0-9]|19[0-9]|14[57]$/)) {
            toast("手机号码格式错误！");
        } else if (oInput.value.trim().length == 1 && oInput.value != '1') {
            toast("手机号码格式错误！")
        }
    },
    //loading中
    BtnLoading: function () {
        $('.confirm-btn').addClass('loading').text('');
    },
    //loading结束
    UnBtnLoading: function () {
        var btnText = $('.confirm-btn').attr('data-text');
        $('.confirm-btn').removeClass('loading').text('');
    },
    //窗口底部滑动禁止
    LockBody: function () {
        $('body,.main').addClass('_lock_body');
    },
    //窗口底部滑动开放
    UnlockBody: function () {
        $('body,.main').removeClass('_lock_body');
    }
};

function pushHistory(title, url) {
    var state = {
        title: title,
        url: url
    };
    window.history.pushState(state, title, url);
}

/**
 * 封装的公用 toast方法
 **/
function toast(txt) {
    if (!txt) return;
    if (document.getElementById("toast")) return;
    var toastHtml = '<div id="toast"><div class="toast-txt">' + txt + '</div></div>';
    $('body').append(toastHtml);
    setTimeout(function () {
        $('#toast').remove();
    }, 1500);
}

$(function(){
    //电话号码输入
    $("#phoneInput").on("input", function () {
        common.CheckInputMobile($("#phoneInput").get(0));
        var val = $(this).val().replace(/[^\d]+/, '');
        $(this).val(val);
    });

    /** 选择服务区域返回 */
    $(window).on("popstate", function (e) {
        $('.server-reg-box').hide();
        document.title = '注册验证';
    });

});

function updateSectionListHtml(sectionList,regName) {
    var sectionHtml = '';
    sectionList.map(function (item, index) {
        sectionHtml += '<li data-regname="'+regName+'" data-regid="' + item.regId + '" data-id="' + item.sectionId + '">' + item.sectionName + '</li>'
    })
    $('.list-ul.section-list').html(sectionHtml);

    //更新当前 已经选中的状态 商圈状态
    updateSectionStaus();
}

/**
 * 更新当前 已经选中的状态 商圈状态
 */
function updateSectionStaus(){
    regSelectNum = {};
    selectServerArr.map(function(item,index){
        //更新选中商圈
        $('.section-list li[data-id=' + item.sectionId + ']').addClass('on');
        //更新选中行政区数量
        if (!!regSelectNum[item.regId]){

            regSelectNum[item.regId]++;
        }else{
            regSelectNum[item.regId] = 1;
        }
    })

    //遍历 行政区数量数据
    $('.reg-list li span').text('');
    for (x in regSelectNum){
        $('.reg-list li[data-id=' + x + '] span').text('(' + regSelectNum[x]+')');
    }

}

/**
 * 根据选中商圈生成展示字符串
 */
function setServerStr(serverList) {
    if (serverList.length == 0) $('#showServiceZone').val('');
    var serverStr = '';
    var selectRegSection = {};
    serverList.map(function(item,index){
        if (!selectRegSection[item.regName]) {
            selectRegSection[item.regName] = [item.sectionName];
        }else{
            selectRegSection[item.regName].push(item.sectionName)
        }
    })

    for (var x in selectRegSection){
        serverStr += x + ' ' + '(' + selectRegSection[x].join(' ')+')' +' ';
    }
    $('#showServiceZone').val(serverStr);
}

/**
 * 根据选中商圈生成展示字符串
 */
function getServerObj(serverList) {
    var serverStr = '';
    var regIdArr = [];
    var sectionArr = [];
    var serviceZoneArr = [];
    serverList.map(function(item,index){
        if (regIdArr.indexOf(item.regId) == -1) {
            regIdArr.push(item.regId);
        }
        if (sectionArr.indexOf(item.sectionId) == -1) {
            sectionArr.push(item.sectionId);
        }
        if (serviceZoneArr.indexOf(item.sectionName) == -1) {
            serviceZoneArr.push(item.sectionName);
        }
    })
    var regIdArrStr = regIdArr.join(' ');
    var sectionArrStr = sectionArr.join(' ');
    var serviceZoneArrStr = serviceZoneArr.join(' ');
    var returnObj = new Object();
    returnObj.regIds = regIdArrStr;
    returnObj.sectionIds = sectionArrStr;
    returnObj.serviceZone = serviceZoneArrStr;
    return returnObj;
}
