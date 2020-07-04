var common = {
    //验证手机号
    CheckInputMobile: function (oInput) {
        if ('' != oInput.value.replace(/\d{1,}\.{0,1}\d{0,}/, '')) {
            oInput.value = oInput.value.match(/\d{1,}\.{0,1}\d{0,}/) == null ? '' : oInput.value.match(/\d{1,}\.{0,1}\d{0,}/);
        }
        if (oInput.value.match(/\d{1,}\.\d{2,}/)) {
            oInput.value = oInput.value.match(/\d{1,}\.\d{1}/);
        }
        if (oInput.value.match(/^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|16[0-9]|19[0-9]|14[0-9])[0-9]{8}$/)) {
            oInput.value = oInput.value.trim();
        } else if (oInput.value.trim().length > 11) {
            oInput.value = oInput.value.trim().substring(0, 11);
            //            alert('手机号是11位哦');
        } else if (oInput.value.trim().length == 3 && !oInput.value.match(/^13[0-9]|15[012356789]|17[0123456789]|18[0-9]|19[0-9]|16[0-9]|14[57]$/)) {
            oInput.value = '';
            //                alert('亲，请输入正确手机号');
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

/**
 * 添加历史方法
 * @param {*} title 
 * @param {*} url 
 */
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

/**
 * 更新商圈列表
 */
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
    if (serverList.length == 0)return '';
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
    $('#serverReg').val(serverStr);
}


$(function(){
    if(1 == pastFlag){
        $('.submit-form').hide();
        $('.past-from').show();
    }else{
        $('.past-from').hide();
    }
	
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
        console.log('1');
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "sendCompInviteRegistSms",
            data: {"param": param,"userMobile":phone,"isFjd":1},
            beforeSend:function() {
                isSuccessSubmit = 1;
            },
            complete:function() {
                isSuccessSubmit = 0;
            },
            success: function(result){
            	console.log('2');
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

    //初始化服务区域
    setServerStr(sureServerArr);
    // 请求行政区数据
    function initRegLit(){
	    $.ajax({
	        type: "POST",
	        dataType: "json",
	        url: "getCompInviteRegList",
	        data: {"param": param},
	        success: function(result){
	            if(result.errCode != 200) {
	                toast(result.errMsg);return;
	            } else {
	                var resList = result.data;
	                var regHtml = "";
	                var regIdStr = regIds.split(" ");
	                var checkedRegId = 0;
	                var classOn = 1;
	                $.each(resList, function (k, v) {
	                    // 遍历已选数据
	                    var regId = v.regId;
	                    var isChecked='';
	                    if(regIdStr.indexOf(regId+",") != "-1" && checkedRegId == 0) {
	                        isChecked = "class='on'";
	                        checkedRegId = regId;
	                    }
	                    if(classOn == 1){
	                    	 isChecked = "class='on'";
	                    }
	                    classOn ++
	                    regHtml+="<li "+isChecked+" data-name='"+v.regName+"' data-id='"+regId+"'>"+v.regName+"<span></span></li>"
	                });
	                $(".reg-list").html(regHtml);
	            }
	        }
	    });
    }
	
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
            url: "getCompInviteSectionList",
            data: {"param": param, "regId": regId},
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
    
   
    //电话号码输入
    $("#phoneInput").on("input", function () {
        common.CheckInputMobile($("#phoneInput").get(0));
        var val = $(this).val().replace(/[^\d]+/, '');
        $(this).val(val);
    })

    //获取验证码
    $('.get-code').on('click',function(){
        //验证号码
        var _this = this;

        //避免重复请求
        if ($(_this).hasClass('wait_resend')) {return false;}

        var phone = $('#phoneInput').val();
        if (!phone){
            toast('请输入手机号码'); return;
        }
        if (phone.length != 11){
            toast('请输入正确手机号码');return;
        }

        //验证码获取成功后,倒计时
        
        //设置倒计时，并屏蔽发送键
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
                $('.get-code').text(new_tip);
            }
        }, 1000);

    })

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

        //验证成功后:执行 , 展示注册弹窗
        $('.phone-check-form').hide();

        $('.submit-form').show();

    })


     /** 选择服务区域 */
    $('#serverReg').on('click',function(){
        pushHistory('选择服务区域', '#serverReg');
        document.title = '选择服务区域';
        $('.server-reg-box').show();
        // 正在选中商圈初始化 
//        selectServerArr = sureServerArr;
        initRegLit();
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
       
        a();
//        updateSectionListHtml(selectRegId, selectRegName);
    })

    /** 选择服务区域返回 */
    $(window).on("popstate", function (e) {
        $('.server-reg-box').hide();
        document.title = '注册验证';
    })

    /** 点击行政区 */
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
        //获取对应行政区的商圈数组
        var sectionList = $(this).data[regId];

        //遍历生成商圈 html
        updateSectionListHtml(sectionList,regName);
        
    })

    /** 点击商圈 */
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
                regId: regId, regName: regName, sectionId: sectionId, sectionName: sectionName
            });
            $(this).addClass('on')
            updateSectionStaus();
        }
    })

    /** 服务区域确定 */
    $('.server-reg-box .confirm-btn').on('click', function () {
        //获取当前选中的区域
        sureServerArr = selectServerArr;
        setServerStr(sureServerArr);
        //关闭选择弹窗
        $('.server-reg-box').hide();
        window.history.go(-1);
        document.title = '注册验证';
    })

    /** 提交注册信息 */
    $('.submit-form-btn').on('click', function () {
    	var UserName = $('#userName').val();
    	var serverReg = $('#serverReg').val();
    	var codeInput = $('#codeInput').val();
    	var phoneInput = $('#phoneInput').val();
    	var serviceReg ='';
    	var serviceZone ='';
    	var serviceZoneIds ='';
    	$.each(selectServerArr,function(index,value){
    		if(serviceReg.indexOf(value.regId) == -1){
    			serviceReg += ' '+ value.regId;
    		}
    		if(serviceZone.indexOf(value.regName) == -1){
    			serviceZone += ' '+ value.regName;
    		}
    		serviceZoneIds += ' '+ value.sectionId;
    	});
    	serviceReg = serviceReg.substring(1);
    	serviceZone = serviceZone.substring(1);
    	serviceZoneIds = serviceZoneIds.substring(1);
        //判断手机
    	if(!UserName){
    		toast('请先输入姓名');return;
    	}
    	if(!phoneInput){
    		toast('请先输入手机号');return;
    	}
        //判断是否 已经选择了服务区域
    	if(!serviceZoneIds){
    		toast('请先选择服务区域');return;
    	}
        //密码验证
        var password = $('#password').val();
        var passwordRep = $('#passwordRep').val();
        var codeInput = $('#codeInput').val();
        if (!password) {
            toast('请先输入密码');return;
        }
        if (!codeInput) {
        	toast('请先输入验证码');return;
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
        if(isSuccessSubmit == 1) {
            toast('正在提交请稍后。');return;
        }

        //提交
        $.ajax({
            type: "POST",
            dataType: "json",
            timeout :30000,
            url: erpWebUrl + "openApi/inviteRegist/validateCompInviteMsg",
            beforeSend:function() {
                $("#loadDiv").show();
                $(".form-section .check-btn").css("background","#999999");
                isSuccessSubmit = 1;
            },
            complete:function(data) {
                var responseJson = data.responseJSON;
                var errCode = responseJson.errCode;
                if(200 != errCode){
                    isSuccessSubmit = 0;
                    $(".form-section .check-btn").css("background","#00A49D");
                    $("#loadDiv").hide();
                }
            },
            data: {"param": param, "userMobile": phoneInput, "code":codeInput,"isFjd":1},
            success: function(data){
                if (data.errCode == 300 || data.errCode == 500) {
                    toast(data.errMsg);return;
                } else if (data.errCode == 200){
                    window.location.href = erpWebUrl + 'openApi/inviteRegist/fjdArchival?'
                        + "&cityId=" + cityId + "&compId=" + compId + "&deptId=" + deptId + "&inviteId=" + invitedId
                        + "&invitedMobile=" + invitedMobile + "&userName=" + UserName + "&password=" + password + "&serviceReg=" + serviceReg
                        + "&serviceZone=" + serviceZone + "&serviceZoneIds=" + serviceZoneIds + "&userMobile=" + phoneInput;
                    return;
                } else if (data.errMsg != 200) {
                    toast("系统错误");return;
                }
                //成功
            }, function(data){
                toast("网络异常，请检查网络或稍后再试。");
            }
        });

    })
    
})
a();
function a (){
	var li = $(".reg-list li").get(0)
    if($(li).find('span').text() == ''){
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
    var regId = $(li).data('id');
    var regName = $(li).data('name');

    // 请求行政区 的商圈数据
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "getCompInviteSectionList",
        data: {"param": param, "regId": regId},
        success: function(result){
            if(result.errCode != 200) {
                toast(result.errMsg);return;
            } else {
                var sectionList = result.data;
                updateSectionListHtml(sectionList, regName);
            }
        }
    });
}

