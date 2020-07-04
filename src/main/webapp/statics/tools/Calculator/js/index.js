/**
 * 税费计算相关JS
 * 苟建军
 * 2014-03-15
 */
var userFlag = false;
var Tax = Tax || {};
Tax.global = {
    buildTypeItem : ["QS","JYSXF","CQDJF","GTZGBF"],
    elevatorTypeItem : ["WXJJ"],
    taxYYSItem : ["YYS"],
    taxGRSDSItem : ["GRSDS"]
};
Tax.total = {
    flag : false,//表单验证结果
    area : 0,//面积
    priceTaxPer : 0,//报税单价
    priceTaxTotal : 0,//报税总价
    buy_price : 0,//原购入总价
    buyerTotal: 0,//买方统计
    salerTotal: 0,//卖方统计
    newItem: 0//新建统计
};
Tax.item = {
    QS:{
        value : 0,
        person : [0,0]
    },
    YHS:{
        value : 0,
        person : [0,0]
    },
    JYSXF:{
        value : 0,
        person : [0,0]
    },
    WXJJ:{
        value : 0,
        person : [0,0]
    },
    YYS:{
        value : 0,
        person : [0,0]
    },
    GRSDS:{
        value : 0,
        person : [0,0]
    },
    CQDJF:{
        value : 0,
        person : [0,0]
    },
    TDCRJ:{
        value : 0,
        person : [0,0]
    },
    GTZGBF:{
        value : 0,
        person : [0,0]
    }
};
Tax.util = {
    setPrice : function(){

        //写入买卖双方的价格
        $.each(Tax.item,function(i,value){
            for(var j=0,len=Tax.item[i].person.length;j<len;j++) {
                var value = parseInt(Tax.item[i].person[j]),
                    _this = $("#" + i + "_2"),
                    oTd = _this.find("td").eq(j);
                if (_this.children("input").length != 0) return;//如果是新增 newItem,返回
                if(value > 0){
                    oTd.html(value+ "元");
                }else {
                    oTd.html("<span style='color:rgb(178, 178, 178);'>-无-</span>");
                }
            }
        });

        if (Tax.item.YYS.person[1] == 0 && $("input[type=checkbox][name=YYS_CHK]")[1].checked == true) { $("#YYS_TD4").html("0元"); }
        if (Tax.item.GRSDS.person[1] == 0 && $("input[type=checkbox][name=GRSDS_CHK]")[1].checked == true) { $("#GRSDS_TD4").html("0元"); }
        //写入税费类别的价格
        $("#totalPrice").html(parseInt(Tax.total.priceTaxTotal/10000));
        $("#feeTotal").html(Tax.total.buyerTotal + Tax.total.salerTotal);
        $("#feeForBuyer").html(Tax.total.buyerTotal);
        $("#feeForSeller").html(Tax.total.salerTotal);
    },
    //新建 item ,并保存到 tax 对象中
    caculate : function(){
		var tempIndex = 0;
    	if (Tax.total.newItem >0){
    		tempIndex = Tax.total.newItem;
    		tempIndex--;
    	}
    	if($("#newItem_"+tempIndex).length > 0){
	    	if($("#newItem_"+tempIndex).children().children("input")[0].value == ""){
	    		$("#newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	    	}else{
	    		$("#newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid #CAD5DF";
	  			$("#newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
	    	if($("#newItem_"+tempIndex).children().children("input")[1].value == ""){
	    		$("#newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	    	}else{
	    		$("#newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid #CAD5DF";
	  			$("#newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
	    	
	    	if($("#Right_newItem_"+tempIndex).children().children("input")[0].value == "" || isNaN($("#Right_newItem_"+tempIndex).children().children("input")[0].value)){
	    		$("#Right_newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	    	}else{
	    		$("#Right_newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid #CAD5DF";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
	    	if($("#Right_newItem_"+tempIndex).children().children("input")[1].value == "" || isNaN($("#Right_newItem_"+tempIndex).children().children("input")[1].value)){
	    		$("#Right_newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	    	}else{
	    		$("#Right_newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid #CAD5DF";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
    	}
    	
        //设置priceTaxTotal的值
        Tax.total.priceTaxTotal = Tax.total.area * Tax.total.priceTaxPer;

        //设置Tax.item的值
        $.each(Tax.item,function(i,value){
            switch (i) {
                case "QS":
                    Tax.item.QS.person[0] =  Tax.total.priceTaxTotal * Tax.item.QS.value * 0.01;
                    break;
                case "YHS":
                    Tax.item.YHS.person[0] = Tax.item.YHS.person[1] =  Tax.total.priceTaxTotal * Tax.item.YHS.value * 0.01;
                    break;
                case "JYSXF":
                    var type = ($("#JYSXF .item")[0].style.display == "none") ? 0 : 1;
                    if(type == 0){
                        Tax.item.JYSXF.person[0] = Tax.item.JYSXF.person[1] =  Tax.total.priceTaxTotal * Tax.item.JYSXF.value * 0.01;
                    } else {
                    	Tax.item.JYSXF.person[0] = Tax.item.JYSXF.person[1] =  Tax.total.area * Tax.item.JYSXF.value;
                    }
                    break;
                case "WXJJ":
                        Tax.item.WXJJ.person[1] =  Tax.total.area * Tax.item.WXJJ.value;
                    break;
                case "YYS":
                    var type2 = ($("#YYS .item").children(".check-box").children().children()[0].checked == true) ? 0 : 1;
                    if(type2== 0){
                        Tax.item.YYS.person[1] =  Tax.total.priceTaxTotal * Tax.item.YYS.value *0.01;
                    } else {
                        if (((Tax.total.priceTaxTotal - Tax.total.buy_price * 10000) * Tax.item.YYS.value * 0.01) <= 0) {
                            Tax.item.YYS.person[1] = 0;
                        } else {
                            Tax.item.YYS.person[1] = (Tax.total.priceTaxTotal - Tax.total.buy_price * 10000) * Tax.item.YYS.value * 0.01;
                        }
                    }
                    break;
                case "GRSDS":
                    var type3 = ($("#GRSDS .item").children(".check-box").children().children()[0].checked == true) ? 0 : 1;
                    if(type3 == 0){
                        Tax.item.GRSDS.person[1] =  Tax.total.priceTaxTotal * Tax.item.GRSDS.value *0.01;
                    } else {
                        if (((Tax.total.priceTaxTotal - Tax.total.buy_price * 10000) * Tax.item.GRSDS.value * 0.01) <= 0) {
                            Tax.item.GRSDS.person[1] = 0;
                        } else {
                            Tax.item.GRSDS.person[1] = (Tax.total.priceTaxTotal - Tax.total.buy_price * 10000) * Tax.item.GRSDS.value * 0.01;
                        }
                    }
                    break;
                case "CQDJF":
                    Tax.item.CQDJF.person[0] =  Tax.item.CQDJF.value;
                    break;
                case "TDCRJ":
                    Tax.item.TDCRJ.person[0] =  Tax.total.priceTaxTotal * Tax.item.TDCRJ.value * 0.01;
                    break;
                case "GTZGBF":
                    Tax.item.GTZGBF.person[0] =  Tax.item.GTZGBF.value;
                    break;
            }

        })

        //计算买卖双方税费
        $.each(Tax.item,function(i){
            var priceArr =  Tax.item[i].person
            Tax.total.buyerTotal += parseInt(priceArr[0]);
            Tax.total.salerTotal += parseInt(priceArr[1]);
        });
        $(".inputLeft").each(function(index,element){
        	if(element.value != "" && !isNaN(element.value)){
            	Tax.total.buyerTotal += parseFloat(element.value);
        	}
        });
        $(".inputRight").each(function(index,element){
        	if(element.value != "" && !isNaN(element.value)){
            	Tax.total.salerTotal += parseFloat(element.value);
        	}
        });
        Tax.util.setPrice();//写入价格
    },
    valid : function(){
        var flag = true,
            tipStr = "请填入正确的值";
        //去除空格
        $("input[type='text']").each(function(){
            var value = $(this).val();
            $(this).val(value.trim());
        });
        //初始化
        $.each(Tax.item,function(i){
            if(!($("#"+i).hasClass('newItem')) && (Tax.item[i] != null)) {
                (Tax.item[i].person = [0,0]);
            }
            Tax.item[i].value = 0;
            Tax.total.buyerTotal = Tax.total.salerTotal =0;
        });

        //必填项，面积，单价,原购入价
        $("#titleTable input[type='text']").not("#propertyComp").each(function(){
            var value = $(this).val(),
                id = $(this).attr("id");
            //验证
            if(value == "" || isNaN(value)) {
                $(this).addClass("tip_red");
                $(this).css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" });
                flag = false; return;
            };
            //写入Tax.total
            if(id == "area") {
                Tax.total.area = value;
                $(this).css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
            } else if(id == "price") {
                Tax.total.priceTaxPer = value;
                $(this).css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
            }  else if(id == "buyPrice") {
                Tax.total.buy_price = value;
                $(this).css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
            }
        });
        //selfDefItems 验证
        $("#selfDefItems input[type='checkbox']").each(function () {
             if($(this).prop("checked")) {
                var o = $(this).parent().parent().siblings("input");
                if(!(o.val() == "" || isNaN((o).val()))) {//验证
                    var parentId = $(this).parents("tr").attr("id") ;
                    Tax.item[parentId].value = o.val();//写入对象Tax.item
                    o.css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
                } else {
                    o.css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" });
                    flag = false;
                }
             }
         });
        Tax.total.flag = flag;
    },

    //新建item
    creatItem : function(){
    	var tempIndex = 0;
    	if (Tax.total.newItem >0){
    		tempIndex = Tax.total.newItem;
    		tempIndex--;
    	}
    	if($("#newItem_"+tempIndex).length > 0){
	    	if($("#newItem_"+tempIndex).children().children("input")[0].value == ""){
	    		document.getElementById("CCustObj").openMessageBox("对不起，类别名 不能为空。",3,1);
	    		$("#newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	  			return;
	    	}else{
	    		$("#newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid #CAD5DF";
	  			$("#newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
	    	if($("#newItem_"+tempIndex).children().children("input")[1].value == ""){
	    		document.getElementById("CCustObj").openMessageBox("对不起，详情描述 不能为空。",3,1);
	    		$("#newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	  			return;
	    	}else{
	    		$("#newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid #CAD5DF";
	  			$("#newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
	    	
	    	if($("#Right_newItem_"+tempIndex).children().children("input")[0].value == "" || isNaN($("#Right_newItem_"+tempIndex).children().children("input")[0].value)){
	    		document.getElementById("CCustObj").openMessageBox("对不起，买方 为空 或 非数字。",3,1);
	    		$("#Right_newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	  			return;
	    	}else{
	    		$("#Right_newItem_"+tempIndex).children().children("input")[0].style.border = "1px solid #CAD5DF";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[0].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
	    	if($("#Right_newItem_"+tempIndex).children().children("input")[1].value == "" || isNaN($("#Right_newItem_"+tempIndex).children().children("input")[1].value)){
	    		document.getElementById("CCustObj").openMessageBox("对不起，卖方 为空 或 非数字。",3,1);
	    		$("#Right_newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid rgb(250, 133, 133)";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "rgb(250, 195, 195) 0px 3px 3px inset";
	  			return;
	    	}else{
	    		$("#Right_newItem_"+tempIndex).children().children("input")[1].style.border = "1px solid #CAD5DF";
	  			$("#Right_newItem_"+tempIndex).children().children("input")[1].style.boxShadow = "0px 3px 3px #EFF3F6 inset";
	    	}
    	}
        var flag = true,
            oNes = 'newItem_'+Tax.total.newItem,
            oIpt = $("#"+oNes+" input[type='text']"),
            tpmHtml = '<tr id=' + oNes + '> <td><input type="text" placeholder="请输入类别名" style="width: 81px;" /></td><td colspan="2"><input type="text" placeholder="请分别将科目、费率和买卖方双方应付费用分别填写即可计算。" style="width: 341px;" /><span class="btn_del">删除</span></td> </tr>'
            tpmHtmlRight = '<tr id=Right_' + oNes + '><td class="tdHeight"><input type="text" class="inputLeft" style="width: 47px;" placeholder="（元）" maxlength="6"/></td><td><input type="text" class="inputRight" style="width:47px;" placeholder="（元）" maxlength="6"/></td></tr>'

        $(tpmHtml).insertBefore($("#createBtnTR"));
        $(tpmHtmlRight).insertBefore($("#createBtnTRRight"));
        Tax.total.newItem++; $("#divLeft").css("height", "100%"); $("#divLeft").css("height", document.body.scrollHeight);

        $("#" + oNes).find(".btn_del").bind('click',function(){
            $("#" + oNes).remove(); $("#Right_" + oNes).remove();
            Tax.total.newItem--;
            $("#divLeft").css("height", "100%"); $("#divLeft").css("height", document.body.scrollHeight);
            return false;
        });
    }
};
Tax.chk = {
    ableItem : function(obj){
        obj.children('div').addClass("checkedBoxDisable").find("input[type='checkbox']").prop("checked", 'checked');
    },
    disableItem : function(obj){
        obj.each(function(){
            $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable").removeClass("checkedBox").addClass("checkedBoxUnDisable")
            .find("input[type='checkbox']").removeAttr("checked");
        })
    },
    setSel : function(namesArr,index){
        for(i=0;i<namesArr.length;i++){
            var parent = $("#"+namesArr[i]),
                child = parent.find(".item");
            Tax.chk.disableItem(child);
            parent.data(index);
            if (child[0].tagName == "DIV") {
                $(child).css("display", "none"); $(child[index]).css("display", "block");
            }
            if(index >= 0)  {
                Tax.chk.ableItem(child.eq(index));
            }
        }
    }
};
$(document).ready(function () {
	$("#divAddTemplate").mousedown(function(e)//e鼠标事件  
    {  
        $(this).css("cursor","move");//改变鼠标指针的形状  
        
        var offset = $(this).offset();//DIV在页面的位置  
        var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离  
        var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离  
        $(document).bind("mousemove",function(ev)//绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件  
        {
            var _x = ev.pageX - x;//获得X轴方向移动的值  
            var _y = ev.pageY - y;//获得Y轴方向移动的值  
            if (_x <= 0){_x = 0;}
            if (_x >= (document.body.clientWidth-730)){_x = (document.body.clientWidth-730);}
            if (_y <= 0){_y = 0;}
            if (_y >= (document.body.clientHeight-420)){_y = (document.body.clientHeight-420);}
            $("#divAddTemplate").css({marginLeft:_x+"px",marginTop:_y+"px"},10);  
        });  
          
    });  
    $(document).mouseup(function()  
    {  
        $("#divAddTemplate").css("cursor","default");  
        $(this).unbind("mousemove");  
    });
    window.onresize = function () {
        if (((document.body.clientWidth - 200) / 2 - parseInt(882 / 2)) > 10) {
            var temp = ((document.body.clientWidth - 200) / 2 - parseInt(882 / 2)) + 200;
            $("#divRight").css("left", parseInt(temp) + "px");
        } else {
            $("#divRight").css("left", "210px");
        }
        if (document.body.clientWidth >= 651) {
            $("#divSelect").css("display", "block");
        } else {
            $("#divSelect").css("display", "none");
        }
        $("#divAddTemplate").css("marginTop", parseInt(document.body.clientHeight / 2) - (420 / 2) + "px");
        $("#divAddTemplate").css("marginLeft", parseInt(document.body.clientWidth / 2) - (730 / 2) +"px");
        $("#divMarkLayer").css("height", document.body.scrollHeight +"px");
    }
    $("#tempList").selectmenu({
        buttonClass: "ui-button-Stores",
        textClass: "ui-textClass", //文本追加样式
        change: function( event, data ) {
        	var info = JSON.parse($(data.item.element).attr("data"));
        	for(var item in info){
        		if(typeof(info[item].params) == "string"){
        			$("#" + info[item].id).children().children("input[type=text]").val(info[item].params);
        		}else if(info[item].params.length == 2){
        			if(info[item].id == "YYS" || info[item].id == "GRSDS"){
	        			$("#" + info[item].id).children(".item").children("input[type=text]")[0].value = info[item].params[0];
	        			$("#" + info[item].id).children(".item").children("input[type=text]")[1].value = info[item].params[1];
        			}else{
        				$("#" + info[item].id).children().children(".item").children("input[type=text]")[0].value = info[item].params[0];
	        			$("#" + info[item].id).children().children(".item").children("input[type=text]")[1].value = info[item].params[1];
        			}
        		}
        	}
	    }
    });
    if (parent.userInfo) {
        var userInfoJson = parent.userInfo;
        path = userInfoJson.path;
        $("#operName").html(userInfoJson.userName);
        $("#operMobile").html(userInfoJson.userTel);
        $("#deptName").html(userInfoJson.deptName);
    }
    /*raido*/
    $("#YYS_CHK1,#YYS_CHK2,#GRSDS_CHK1,#GRSDS_CHK2,#noEle_CHK1,#ele_CHK2").click(function () {
        var _this = $(this),
            name = $(this).attr("id").split("_")[0];
        if (_this.prop("checked")) {
            _this.parent().removeClass("disable").siblings().addClass("disable").find("input[type='checkbox']").removeAttr("checked");
            $("#SF_TYPE_" + name).prop("checked", 'true');
        } else {
            $("#SF_TYPE_" + name).removeAttr("checked");
            _this.parent().addClass("disable");
        }
    })
    /*新建*/
    $("#createNewItem").bind('click', function () {
        if (userFlag == false) {
            document.getElementById("CCustObj").openMessageBox("您不具有该权限！只有副总经理、总经理才可以新建税费模板。",3,1);
        } else {
            Tax.util.creatItem();
        }
    });
    $("#setForShuiFei").bind('click', function () {
        if (userFlag == false) {
            document.getElementById("CCustObj").openMessageBox("您不具有该权限！只有副总经理、总经理才可以新建税费模板。",3,1);
        } else {
            OpenDiv();
        }
    });
    //计算
    $("#calculate").bind('click', function () {
        Tax.util.valid();
        if (Tax.total.flag == true) { Tax.util.caculate() };
    })

    getTempleList();
    /*获取许可权*/
    $.get("../../web/sfParas/judgeOpers", function (data) {
    	if(data == "false"){
        	userFlag = false;
    	}else if(data == "true"){
    		userFlag = true;
    	}
    });
});
function SelectHouseOrBusiness(flap) {
    if (flap == "House") {
        Tax.chk.setSel(Tax.global.buildTypeItem, 0);
    } else if (flap == "Business") {
        Tax.chk.setSel(Tax.global.buildTypeItem, 1);
    }
}
function SelectElevator(flap) {
    if (flap == "No") {
        Tax.chk.setSel(Tax.global.elevatorTypeItem, 0);
    } else if (flap == "Have") {
        Tax.chk.setSel(Tax.global.elevatorTypeItem, 1);
    }
}
function SalesTax(obj) {
    if($(obj).prop("checked") == true){
        Tax.chk.setSel(Tax.global.taxYYSItem, 0); $(obj).prop("checked", false);
    } else {
        $(obj).prop("checked", true);
        for(i=0;i<Tax.global.taxYYSItem.length;i++){
            var parent = $("#" + Tax.global.taxYYSItem[i]),
                child = parent.find(".item");
            child.each(function(){
                $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable")
                .find("input[type='checkbox']").removeAttr("checked");
            })
        }
    }
}
function Tax(obj) {
    if ($(obj).prop("checked") == true) {
        Tax.chk.setSel(Tax.global.taxGRSDSItem, 0); $(obj).prop("checked", false);
    } else {
        $(obj).prop("checked", true);
        for (i = 0; i < Tax.global.taxGRSDSItem.length; i++) {
            var parent = $("#" + Tax.global.taxGRSDSItem[i]),
                child = parent.find(".item");
            child.each(function () {
                $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable")
                .find("input[type='checkbox']").removeAttr("checked");
            })
        }
    }
}
function SelectYYS(obj, flap) {
    if (flap == 0) {
        if ($("input[type=checkbox][name=YYS_CHK]")[1].checked == true) { return; }

        if ($(obj).parent().parent().hasClass("checkedBoxDisable") == false) {
            Tax.chk.setSel(Tax.global.taxYYSItem, 0); $(obj).prop("checked", true);
        } else {
            $(obj).prop("checked", false);
            for (i = 0; i < Tax.global.taxYYSItem.length; i++) {
                var parent = $("#" + Tax.global.taxYYSItem[i]),
                    child = parent.find(".item");
                child.each(function () {
                    $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable").removeClass("checkedBox")
                    .find("input[type='checkbox']").removeAttr("checked");
                })
            }
        }
    } else if (flap == 1) {
        if ($("input[type=checkbox][name=YYS_CHK]")[0].checked == true) { return; }

        if ($(obj).parent().parent().hasClass("checkedBoxDisable") == false) {
            Tax.chk.setSel(Tax.global.taxYYSItem, 1); $(obj).prop("checked", true);
        } else {
            $(obj).prop("checked", false);
            for (i = 0; i < Tax.global.taxYYSItem.length; i++) {
                var parent = $("#" + Tax.global.taxYYSItem[i]),
                    child = parent.find(".item");
                child.each(function () {
                    $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable").removeClass("checkedBox")
                    .find("input[type='checkbox']").removeAttr("checked");
                })
            }
        }
    }
}
function SelectGRSDS(obj, flap) {
    if (flap == 0) {
        if ($("input[type=checkbox][name=GRSDS_CHK]")[1].checked == true) { return; }

        if ($(obj).parent().parent().hasClass("checkedBoxDisable") == false) {
            Tax.chk.setSel(Tax.global.taxGRSDSItem, 0); $(obj).prop("checked", true);
        } else {
            $(obj).prop("checked", false);
            for (i = 0; i < Tax.global.taxGRSDSItem.length; i++) {
                var parent = $("#" + Tax.global.taxGRSDSItem[i]),
                    child = parent.find(".item");
                child.each(function () {
                    $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable").removeClass("checkedBox")
                    .find("input[type='checkbox']").removeAttr("checked");
                })
            }
        }
    } else if (flap == 1) {
        if ($("input[type=checkbox][name=GRSDS_CHK]")[0].checked == true) { return; }

        if ($(obj).parent().parent().hasClass("checkedBoxDisable") == false) {
            Tax.chk.setSel(Tax.global.taxGRSDSItem, 1); $(obj).prop("checked", true);
        } else {
            $(obj).prop("checked", false);
            for (i = 0; i < Tax.global.taxGRSDSItem.length; i++) {
                var parent = $("#" + Tax.global.taxGRSDSItem[i]),
                    child = parent.find(".item");
                child.each(function () {
                    $(this).children('div').removeClass("checkedBoxDisable").removeClass("checkedBoxUnDisable").removeClass("checkedBox")
                    .find("input[type='checkbox']").removeAttr("checked");
                })
            }
        }
    }
}
function saveOrUpdateTemple(obj){
	var templateName = $("#jqxComboBox").children().children().children().children("input").val();
	var staticInfo = obj.value;
	var saveObj = []; 
	if(!templateName || templateName.trim() == ""){
		document.getElementById("CCustObj").openMessageBox("对不起，请输入模板名。",3,1);
		return;
	}
	for (var index = 0; index < $("#saveTableInfo").children().children().length; index++) {
		var temp = $("#saveTableInfo").children().children()[index];
		var id = temp.id.replace("_1","");
		var name = $(temp).children()[0].innerText.replace("：","");
		
		if ($($(temp).children()[1]).children(".item").length == 2){
			var params = [];
			for (var i = 0; i < $($(temp).children()[1]).children(".item").children("input[type=text]").length; i++) {
				var value = $($(temp).children()[1]).children(".item").children("input[type=text]")[i].value;
				params.push(value.toString());
			}
			saveObj.push({"name":name,"id":id,"params":params});
		}else if($($(temp).children()[1]).children("input[type=text]").length == 1){
			if ($(temp).children().length == 2) {
				saveObj.push({"name":name,"id":id,"params": $($(temp).children()[1]).children("input[type=text]")[0].value.toString()});	
			}else if ($(temp).children().length == 3) {
				var params = [];
				params.push($($(temp).children()[1]).children("input[type=text]").val());
				params.push($($(temp).children()[2]).children("input[type=text]").val());
				saveObj.push({"name":name,"id":id,"params":params});
			}
		}
	}
	
	if(document.getElementById("CCustObj").openMessageBox("你确定要" + obj.value + "模板：" + templateName + " 吗？",5,2) == 1){
		if(obj.value == "保存"){
			//保存模板
			$.ajax({
		        type: "post",
		        dataType: "json",
		        data:{
		        	ST_NAME: templateName,
		        	NORMAL_ITEMS: JSON.stringify(saveObj)
		        },
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        scriptCharset: 'utf-8',
		        url: '../../web/sfParas/saveOrUpdateTemple',
		        success: function (data) {
		        	if(data.Result == true){
			        	document.getElementById("CCustObj").openMessageBox("恭喜你，模板："+ templateName + "，" + staticInfo + "成功。",4,1);
			        	getTempleList(); $("#divAddTemplate").css("display","none");$("#divMarkLayer").css("display","none");
		        	}else{
	        			document.getElementById("CCustObj").openMessageBox(data.Msg,2,1);	
	        		}
		        },error:function(){
		        	document.getElementById("CCustObj").openMessageBox("对不起，保存失败。",2,1);
		        }
			 });
		}else if(obj.value == "修改"){
			//更新模板
			$.ajax({
		        type: "post",
		        dataType: "json",
		        data:{
		        	"ST_ID": $("#jqxComboBox").val(),
		        	NORMAL_ITEMS: JSON.stringify(saveObj)
		        },
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        scriptCharset: 'utf-8',
		        url: '../../web/sfParas/saveOrUpdateTemple',
		        success: function (data) {
		        	if(data.Result == true){
			        	document.getElementById("CCustObj").openMessageBox("恭喜你，模板："+ templateName + "，" + staticInfo + "成功。",4,1);
			        	getTempleList(); $("#divAddTemplate").css("display","none");$("#divMarkLayer").css("display","none");
			        }else{
	        			document.getElementById("CCustObj").openMessageBox(data.Msg,2,1);	
	        		}
		        },error:function(){
		        	document.getElementById("CCustObj").openMessageBox("对不起，修改失败。",2,1);
		        }
			 });
		}
	}
}
function deleteById(title,ST_ID){
	if(document.getElementById("CCustObj").openMessageBox("你确定要删除模板：" + title + " 吗？",5,2) == 1){
		 $.ajax({
	        type: "post",
	        dataType: "json",
	        data:{
	        	"ST_ID": ST_ID
	        },
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        scriptCharset: 'utf-8',
	        url: '../../web/sfParas/deleteTemple',
	        success: function (data) {
	        	if(data.Result == true){
	        		document.getElementById("CCustObj").openMessageBox("恭喜你，删除成功。",4,1);
	        		//删除选择模板
	        		for (var index = 0; index < $("#tempList").prop("options").length; index++) {
	        			if($("#tempList").prop("options")[index].value  == data.ST_ID){
	        				$("#tempList").prop("options")[index].remove(); break;
	        			}
	        		}
	        		$("#tempList").selectmenu("refresh");
	        		$('#jqxComboBox').jqxComboBox('removeItem', data.ST_ID );
	        	}else{
	        		document.getElementById("CCustObj").openMessageBox(data.Msg,2,1);	
	        	}
	        },error:function(){
	        	document.getElementById("CCustObj").openMessageBox("对不起，删除失败。",2,1);
	        }
		 });
	}
}
//获取模板
function getTempleList(){
	$("#tempList").html(""); $("#jqxComboBox").jqxComboBox('clear'); 
	$.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        scriptCharset: 'utf-8',
        url: '../../web/sfParas/getTempleList',
        success: function (data) {
        	var strHtml = "";var sourceArry = [];
        	for (var i = 0; i < data.length; i++) {
        		sourceArry.push({"Label":data[i].ST_NAME,"Value":data[i].ST_ID,"Data":data[i].NORMAL_ITEMS});
        		if(i == 0){
        			var info = JSON.parse(data[i].NORMAL_ITEMS);
		        	for(var item in info){
		        		if(typeof(info[item].params) == "string"){
		        			$("#" + info[item].id).children().children("input[type=text]").val(info[item].params);
		        		}else if(info[item].params.length == 2){
		        			if(info[item].id == "YYS" || info[item].id == "GRSDS"){
			        			$("#" + info[item].id).children(".item").children("input[type=text]")[0].value = info[item].params[0];
			        			$("#" + info[item].id).children(".item").children("input[type=text]")[1].value = info[item].params[1];
		        			}else{
		        				$("#" + info[item].id).children().children(".item").children("input[type=text]")[0].value = info[item].params[0];
			        			$("#" + info[item].id).children().children(".item").children("input[type=text]")[1].value = info[item].params[1];
		        			}
		        		}
		        	}
        			strHtml += "<option id='" + data[i].ST_NAME + "' value='" + data[i].ST_ID +"' selected='selected' data='" + data[i].NORMAL_ITEMS + "'>" + data[i].ST_NAME + "</option>"; 
        		}else{
        			strHtml += "<option id='" + data[i].ST_NAME + "' value='" + data[i].ST_ID +"' data='" + data[i].NORMAL_ITEMS + "'>" + data[i].ST_NAME + "</option>";
        		}
        	}
        	if(strHtml == ""){strHtml = "<option id='' value='' data='' selected='selected'>通用模板</option>"};
        	$("#tempList").html(strHtml);
        	$("#tempList").selectmenu("refresh");
        	
	        // Create a jqxComboBox
	        $("#jqxComboBox").jqxComboBox({ source: sourceArry, selectedIndex: 0, width: '180', height: '25',autoComplete: true,placeHolder:'请输入模板名',searchMode: 'startswithignorecase',displayMember: "Label", valueMember: "Value"});
			$('#jqxComboBox').on('select', function (event) {
                var args = event.args;
                if (args != undefined) {
                    var item = event.args.item;
                    if (item != null) {
                    	$("#btnDelete").css("display","inline-block"); $("#btnSave").val("修改");
                    	
                    	var info = JSON.parse($('#jqxComboBox').jqxComboBox("getSelectedItem").originalItem.Data);
			        	for(var item in info){
			        		if(typeof(info[item].params) == "string"){
			        			$("#" + info[item].id + "_1").children().children("input[type=text]").val(info[item].params);
			        		}else if(info[item].params.length == 2){
			        			if(info[item].id == "YYS" || info[item].id == "GRSDS"){
				        			$("#" + info[item].id + "_1").children(".item").children("input[type=text]")[0].value = info[item].params[0];
				        			$("#" + info[item].id + "_1").children(".item").children("input[type=text]")[1].value = info[item].params[1];
			        			}else{
			        				$("#" + info[item].id + "_1").children().children(".item").children("input[type=text]")[0].value = info[item].params[0];
				        			$("#" + info[item].id + "_1").children().children(".item").children("input[type=text]")[1].value = info[item].params[1];
			        			}
			        		}
			        	}
                    }
                }
            });
            
            $("#jqxComboBox").children().children().children().children("input").bind("keyup",function(event){
           		if (event.keyCode == 8 || event.keyCode == 46) {
			    	$("#btnDelete").css("display","none");$("#btnSave").val("保存");
			   	}else if (event.keyCode == 13) {
			   		for (var index = 0; index < $('#tempList')[0].options.length; index++) {
		            	if($('#jqxComboBox').val() == $('#tempList')[0].options[index].value){
		            		$("#btnDelete").css("display","inline-block");$("#btnSave").val("修改"); break;
		            	}else{
		            		$("#btnDelete").css("display","none"); $("#btnSave").val("保存");
		            	}
	            	}
			   	}
            });
            setTimeout(function(){
            	if ($('#jqxComboBox').val() == ""){$("#btnDelete").css("display","none"); return;}
            	
            	for (var index = 0; index < $('#tempList')[0].options.length; index++) {
	            	if($('#jqxComboBox').val() == $('#tempList')[0].options[index].value){
	            		$("#btnDelete").css("display","inline-block"); $("#btnSave").val("修改"); break;
	            	}else{
	            		$("#btnDelete").css("display","none"); $("#btnSave").val("保存");
	            	}
            	}
            	$("#btnDelete").bind("click",function(event){
            		deleteById($('#jqxComboBox').jqxComboBox("getSelectedItem").label,$('#jqxComboBox').val());
            	});
            },200);
        }
    });
}
function OpenDiv() {
    document.getElementById("divAddTemplate").style.display = "block";
    document.getElementById("divMarkLayer").style.display = "block";
    $("html").css("overflow","hidden");
}
function CloseDiv() {
    document.getElementById("divAddTemplate").style.display = "none";
    document.getElementById("divMarkLayer").style.display = "none";
	$("html").css("overflow","visible");
}
function PrintInfo(){
	/*var tempIndex = 0,count = 0;
	if (Tax.total.newItem >0){
		tempIndex = Tax.total.newItem;
		tempIndex--;
	}
	if($("#newItem_"+tempIndex).length > 0){
    	if($("#newItem_"+tempIndex).children().children("input")[0].value == ""){
    		count++;
    		$($("#newItem_"+tempIndex).children().children("input")[0]).val(" ");
    	}
    	if($("#newItem_"+tempIndex).children().children("input")[1].value == ""){
    		count++;
    		$($("#newItem_"+tempIndex).children().children("input")[1]).val(" ");
    	}
    	if($("#Right_newItem_"+tempIndex).children().children("input")[0].value == "" || isNaN($("#Right_newItem_"+tempIndex).children().children("input")[0].value)){
    		count++;
    		$($("#Right_newItem_"+tempIndex).children().children("input")[0]).val(" ");
    	}
    	if($("#Right_newItem_"+tempIndex).children().children("input")[1].value == "" || isNaN($("#Right_newItem_"+tempIndex).children().children("input")[1].value)){
    		count++;
    		$($("#Right_newItem_"+tempIndex).children().children("input")[1]).val(" ");
    	}
    	if(count >= 4){// 删除为空的行
    		$("#newItem_"+tempIndex).remove();
    		$("#Right_newItem_"+tempIndex).remove();
    	}
    	else	// 打印时删除”删除“文字
    		$("#newItem_"+tempIndex).find(".btn_del").remove();
	}
	$("#createNewItem").remove();*/
	html2canvas($("#divRight")[0], {
    	onrendered: function (canvas) {
        	$("#imgBase64").val(canvas.toDataURL("image/jpeg").split(",")[1]);
        	$("#CCustPrinterObj")[0].printWeb(0,0,0,0,2,1);
        }
    });
}
function getImg(){
	return $("#imgBase64").val();
}