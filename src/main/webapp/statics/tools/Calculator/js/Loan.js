/**
 * 2010-03-26
 * version:201003
 */
function exc_hk(v) {
    if (v == 1) {
        $("#tdMonth_money1").css("display", "table-row"); $("#tdFirst_total").css("display", "none");
        $("#tdLast_total").css("display", "none"); $("#tdMonth_huankuan_total").css("display", "none");
        $("#tdMonth_huankuan_total1").css("display", "none"); $("#divLeft").css("height", "100%");
    } else {
        $("#tdMonth_money1").css("display", "none"); $("#tdFirst_total").css("display", "table-row");
        $("#tdLast_total").css("display", "table-row"); $("#tdMonth_huankuan_total").css("display", "table-row");
        $("#tdMonth_huankuan_total1").css("display", "table-row"); $("#divLeft").css("height", document.body.scrollHeight);
    }
}
function exc_lilv() {
    var lilv = $("#lilv").val();
    var years = $("#anjieyears").val();//得到years
    var lilv_sd = getlilv(lilv, 1, years);//得到商贷利率
    var lilv_gjj = getlilv(lilv, 2, years);//得到公积金利率
    
    $("#view_sy").html('商业' + Math.round(lilv_sd * 10000) / 100 + '%');
    $("#view_ggj").html('公积金' + Math.round(lilv_gjj * 10000) / 100 + '%');
}
//验证是否为数字

function reg_Num(str) {
    if (str.length == 0) { return false; }
    var Letters = "1234567890.";
    for (i = 0; i < str.length; i++) {
        var CheckChar = str.charAt(i);
        if (Letters.indexOf(CheckChar) == -1) { return false; }
    }
    return true;
}
//执行计算
function excjs() {
    //	alert("========"+$("[name='huankuantype'][checked]"));
    //	alert("--------"+$("#daikuantype"));
    var deposit = $("input[name='huankuantype']:checked").val();//得到还款方式 
    var daikuantype = $("#daikuantype").val();//得到贷款类型   1=商业  2=公积  3=组合
    var lilv = $("#lilv").val();
    var years = $("#anjieyears").val();//得到years
    var month = years * 12;//得到还款的总月数

    var lilv_sd = getlilv(lilv, 1, years);//得到商贷利率
    var lilv_gjj = getlilv(lilv, 2, years);//得到公积金利率

    if (daikuantype == 1 || daikuantype == 2) {//得到为纯商业贷款和纯公积金贷款

        var lilvall = getlilv(lilv, daikuantype, years);//得到利率
        var jisuan_radio = $("input[name='jisuan_radio']:checked").val();//得到计算方式的radio
        if (jisuan_radio == 1) {//计算方式的根据面积、单价计算

            if (!reg_Num($("#price").val())) {
                $("#price").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
            } else if ($("#price").val() == 0) {
                $("#price").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
            } else {
                $("#price").css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
            }
            if (!reg_Num($("#sqm").val())) {
                $("#sqm").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
            } else if ($("#sqm").val() == 0) {
                $("#sqm").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
            } else {
                $("#sqm").css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
            }
            var anjie = $("#anjie").val(); //按揭成数
            //房屋总价
            var fangkuan_total = $("#price").val() * $("#sqm").val();
            //贷款总额
            var daikuan_total = ($("#price").val() * $("#sqm").val() * anjie) / 10;
            //首期付款
            var money_first = fangkuan_total - daikuan_total;
            if (deposit == 1) {//本息还款						
                //月均还款
                var month_money1 = getMonthMoney1(lilvall, daikuan_total, month);//调用函数计算
                //还款总额
                var all_total1 = month_money1 * month;
                //支付利息款

                var lixi_total1 = Math.round((all_total1 - daikuan_total) * 100) / 100;
            } else {//本金还款
                var all_total2 = 0;
                var month_money2 = "";
                for (j = 0; j < month; j++) {
                    //调用函数计算: 本金月还款额
                    huankuan = getMonthMoney2(lilvall, daikuan_total, month, j);
                    all_total2 += huankuan;
                    huankuan = Math.round(huankuan * 100) / 100;
                    if (j == 0) {
                        var first_total = Math.round(huankuan * 100) / 100;
                    }
                    if (j == (month - 1)) {
                        var last_total = Math.round(huankuan * 100) / 100;
                    }
                    month_money2 += (j + 1) + "月," + huankuan + "(元)\n";
                }
                //每月还款明细
                var month_huankuan_total = month_money2;
                //还款总额
                var all_total1 = Math.round(all_total2 * 100) / 100;
                //支付利息款

                var lixi_total1 = Math.round((all_total2 - daikuan_total) * 100) / 100;
            }
        }
        if (jisuan_radio == 2) {//计算方式的根据贷款总额计算
            //房屋总价
            var fangkuan_total = "略";
            //贷款总额
            if (!reg_Num($("#daikuan_total").val())) {
                $("#daikuan_total").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
            } else if ($("#daikuan_total").val() == 0) {
                $("#daikuan_total").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
            } else {
                $("#daikuan_total").css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
            }
            var daikuan_total = $("#daikuan_total").val() * 10000;
            if (daikuantype == 2 && daikuan_total > 800000) {
                document.getElementById("CCustObj").openMessageBox("公积金贷款最高额度为80万元人民币!",3,1);
                document.forms["daikuan_total"].price.focus();
                return false;
            }
            //首期付款
            var money_first = 0;
            if (deposit == 1) {//本息还款				
                //月均还款
                var month_money1 = getMonthMoney1(lilvall, daikuan_total, month);//调用函数计算
                //还款总额
                var all_total1 = month_money1 * month;
                //支付利息款

                var lixi_total1 = Math.round((all_total1 - daikuan_total) * 100) / 100;
            } else {//本金还款
                var all_total2 = 0;
                var month_money2 = "";
                for (j = 0; j < month; j++) {
                    //调用函数计算: 本金月还款额
                    huankuan = getMonthMoney2(lilvall, daikuan_total, month, j);
                    all_total2 += huankuan;
                    huankuan = Math.round(huankuan * 100) / 100;
                    if (j == 0) {
                        var first_total = Math.round(huankuan * 100) / 100;
                    }
                    if (j == (month - 1)) {
                        var last_total = Math.round(huankuan * 100) / 100;
                    }
                    month_money2 += (j + 1) + "月," + huankuan + "(元)\n";
                }
                //每月还款明细
                var month_huankuan_total = month_money2;
                //还款总额
                var all_total1 = Math.round(all_total2 * 100) / 100;
                //支付利息款

                var lixi_total1 = Math.round((all_total2 - daikuan_total) * 100) / 100;
            }

        }
    }
    if (daikuantype == 3) {//组合贷款
        var commercial = $("#commercial").val();//商业性
        var provident = $("#provident").val();//公积金

        if (!reg_Num(commercial)) {
            $("#commercial").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
        } else if (commercial == 0) {
            $("#commercial").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
        } else {
            $("#commercial").css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
        }
        if (!reg_Num(provident)) {
            $("#provident").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
        } else if (provident == 0) {
            $("#provident").css({ border: "1px solid #FA8585", boxShadow: "0px 3px 3px #FAC3C3 inset" }); return false;
        } else {
            $("#provident").css({ border: "1px solid #CAD5DF", boxShadow: "0px 3px 3px #EFF3F6 inset" });
        }
        //房屋总价
        var fangkuan_total = "略";
        //贷款总额
        var daikuan_total = parseInt(commercial) + parseInt(provident);
        //首期付款
        var money_first = 0;
        //月还款

        var lilv_sd = getlilv(lilv, 1, years);//得到商贷利率
        var lilv_gjj = getlilv(lilv, 2, years);//得到公积金利率

        if (deposit == 1) {//本息还款			
            //月均还款
            var month_money1 = getMonthMoney1(lilv_sd, commercial, month) + getMonthMoney1(lilv_gjj, provident, month);//调用函数计算
            //还款总额
            var all_total1 = month_money1 * month;
            //支付利息款

            var lixi_total1 = Math.round((all_total1 - daikuan_total) * 100) / 100;
        } else {//本金还款
            //月还款

            var all_total2 = 0;
            var month_money2 = "";
            for (j = 0; j < month; j++) {
                //调用函数计算: 本金月还款额
                huankuan = getMonthMoney2(lilv_sd, commercial, month, j) + getMonthMoney2(lilv_gjj, provident, month, j);
                if (j == 0) {
                    var first_total = Math.round(huankuan * 100) / 100;
                }
                if (j == (month - 1)) {
                    var last_total = Math.round(huankuan * 100) / 100;
                }
                all_total2 += huankuan;
                huankuan = Math.round(huankuan * 100) / 100;
                month_money2 += (j + 1) + "月," + huankuan + "(元)\n";
            }
            //每月还款明细
            var month_huankuan_total = month_money2;
            //还款总额
            var all_total1 = Math.round(all_total2 * 100) / 100;
            //支付利息款

            var lixi_total1 = Math.round((all_total2 - daikuan_total) * 100) / 100;
        }
    }
    if (deposit == 1) {
        //本息
        if (fangkuan_total == "略") {
            $("#fangkuan_total1").html(fangkuan_total);
        } else {
            $("#fangkuan_total1").html(Math.round(fangkuan_total * 100) / 100 + '元');
        }
        $("#money_first1").html(Math.round(money_first * 100) / 100 + '元');
        $("#daikuan_total1").html(Math.round(daikuan_total * 100) / 100 + '元');
        $("#ggj_lilv1").html(Math.round(lilv_gjj * 10000) / 100 + '%');
        $("#sy_lilv1").html(Math.round(lilv_sd * 10000) / 100 + '%');
        $("#all_total1").html(Math.round(all_total1 * 100) / 100 + '元');
        $("#accrual1").html(Math.round(lixi_total1 * 100) / 100 + '元');
        $("#month1").html(month + '月');
        $("#month_money1").html(Math.round(month_money1 * 100) / 100 + '元');
        $("#tdMonth_money1").css("display", "table-row"); $("#tdFirst_total").css("display", "none");
        $("#tdLast_total").css("display", "none"); $("#tdMonth_huankuan_total").css("display", "none");
        $("#tdMonth_huankuan_total1").css("display", "none"); $("#divLeft").css("height", "100%");
    } else {
        //本金
        if (fangkuan_total == "略") {
            $("#fangkuan_total1").html(fangkuan_total);
        } else {
            $("#fangkuan_total1").html(Math.round(fangkuan_total * 100) / 100 + '元');
        }
        $("#money_first1").html(Math.round(money_first * 100) / 100 + '元');
        $("#daikuan_total1").html(Math.round(daikuan_total * 100) / 100 + '元');
        $("#ggj_lilv1").html(Math.round(lilv_gjj * 10000) / 100 + '%');
        $("#sy_lilv1").html(Math.round(lilv_sd * 10000) / 100 + '%');
        $("#all_total1").html(Math.round(all_total1 * 100) / 100 + '元');
        $("#accrual1").html(Math.round(lixi_total1 * 100) / 100 + '元');
        $("#month1").html(month + '月');

        $("#tdMonth_money1").css("display", "none"); $("#tdFirst_total").css("display", "table-row");
        $("#tdLast_total").css("display", "table-row"); $("#tdMonth_huankuan_total").css("display", "table-row");
        $("#tdMonth_huankuan_total1").css("display", "table-row"); $("#divLeft").css("height", document.body.scrollHeight);

        $("#first_total").html(first_total + '元');
        $("#last_total").html(last_total + '元');
        $("#month_huankuan_total_list").html("");
        var newStr = month_huankuan_total;
        newStr = newStr.replace(/\n/g, ";<br />");
        newStr = newStr.replace(/\(元\)/g, "元");
        $("#month_huankuan_total_list").html(newStr);
    }
    return true;
}

//得到利率  2010年前
function getlilv10(lilv_class, type, years) {
    var lilv_class = parseInt(lilv_class);
    if (years <= 5) {
        return lilv_array[lilv_class][type][5];
    } else {
        return lilv_array[lilv_class][type][10];
    }
}

//得到利率     （value,1商贷2公积金,年限以5年为准）
function getlilv(lilv_class, type, years) {
    var lilv_class = parseInt(lilv_class);
    if (years <= 6) {
        return lilv_array[lilv_class][type][years];
    } else {
        return lilv_array[lilv_class][type][6];
    }
}

//本金还款的月还款额(参数: 年利率 / 贷款总额 / 贷款总月份 / 贷款当前月0～length-1)
function getMonthMoney2(lilv, total, month, cur_month) {
    var lilv_month = lilv / 12;//月利率

    var benjin_money = total / month;
    return (total - benjin_money * cur_month) * lilv_month + benjin_money;

}


//本息还款的月还款额(参数: 年利率/贷款总额/贷款总月份)
function getMonthMoney1(lilv, total, month) {
    var lilv_month = lilv / 12;//月利率

    return total * lilv_month * Math.pow(1 + lilv_month, month) / (Math.pow(1 + lilv_month, month) - 1);
}

//定义利率
lilv_array = new Array;
//2015年10月24日
//基准利率
lilv_array[100]=new Array;
lilv_array[100][1]=new Array;
lilv_array[100][2]=new Array;
lilv_array[100][1][1]=0.0435;
lilv_array[100][1][2]=0.0475;
lilv_array[100][1][3]=0.0475;
lilv_array[100][1][4]=0.0475;
lilv_array[100][1][5]=0.0475;
lilv_array[100][1][6]=0.049;
lilv_array[100][2][1]=0.0275;
lilv_array[100][2][2]=0.0275;
lilv_array[100][2][3]=0.0275;
lilv_array[100][2][4]=0.0275;
lilv_array[100][2][5]=0.0275;
lilv_array[100][2][6]=0.0325;

//基准利率_下浮30%
lilv_array[70]=new Array;
lilv_array[70][1]=new Array;
lilv_array[70][2]=new Array;
lilv_array[70][1][1]=0.03045;
lilv_array[70][1][2]=0.03325;
lilv_array[70][1][3]=0.03325;
lilv_array[70][1][4]=0.03325;
lilv_array[70][1][5]=0.03325;
lilv_array[70][1][6]=0.0343;
lilv_array[70][2][1]=0.0275;
lilv_array[70][2][2]=0.0275;
lilv_array[70][2][3]=0.0275;
lilv_array[70][2][4]=0.0275;
lilv_array[70][2][5]=0.0275;
lilv_array[70][2][6]=0.0325;

//基准利率_下浮20%
lilv_array[80]=new Array;
lilv_array[80][1]=new Array;
lilv_array[80][2]=new Array;
lilv_array[80][1][1]=0.0348;
lilv_array[80][1][2]=0.038;
lilv_array[80][1][3]=0.038;
lilv_array[80][1][4]=0.038;
lilv_array[80][1][5]=0.038;
lilv_array[80][1][6]=0.0392;
lilv_array[80][2][1]=0.0275;
lilv_array[80][2][2]=0.0275;
lilv_array[80][2][3]=0.0275;
lilv_array[80][2][4]=0.0275;
lilv_array[80][2][5]=0.0275;
lilv_array[80][2][6]=0.0325;

//基准利率_下浮15%
lilv_array[85]=new Array;
lilv_array[85][1]=new Array;
lilv_array[85][2]=new Array;
lilv_array[85][1][1]=0.03697;
lilv_array[85][1][2]=0.04038;
lilv_array[85][1][3]=0.04038;
lilv_array[85][1][4]=0.04038;
lilv_array[85][1][5]=0.04038;
lilv_array[85][1][6]=0.04165;
lilv_array[85][2][1]=0.0275;
lilv_array[85][2][2]=0.0275;
lilv_array[85][2][3]=0.0275;
lilv_array[85][2][4]=0.0275;
lilv_array[85][2][5]=0.0275;
lilv_array[85][2][6]=0.0325;

//基准利率_下浮10%
lilv_array[90]=new Array;
lilv_array[90][1]=new Array;
lilv_array[90][2]=new Array;
lilv_array[90][1][1]=0.03915;
lilv_array[90][1][2]=0.04275;
lilv_array[90][1][3]=0.04275;
lilv_array[90][1][4]=0.04275;
lilv_array[90][1][5]=0.04275;
lilv_array[90][1][6]=0.0441;
lilv_array[90][2][1]=0.0275;
lilv_array[90][2][2]=0.0275;
lilv_array[90][2][3]=0.0275;
lilv_array[90][2][4]=0.0275;
lilv_array[90][2][5]=0.0275;
lilv_array[90][2][6]=0.0325;

//基准利率_上浮5%
lilv_array[105]=new Array;
lilv_array[105][1]=new Array;
lilv_array[105][2]=new Array;
lilv_array[105][1][1]=0.04568;
lilv_array[105][1][2]=0.04988;
lilv_array[105][1][3]=0.04988;
lilv_array[105][1][4]=0.04988;
lilv_array[105][1][5]=0.04988;
lilv_array[105][1][6]=0.05145;
lilv_array[105][2][1]=0.0275;
lilv_array[105][2][2]=0.0275;
lilv_array[105][2][3]=0.0275;
lilv_array[105][2][4]=0.0275;
lilv_array[105][2][5]=0.0275;
lilv_array[105][2][6]=0.0325;

//基准利率_上浮10%
lilv_array[110]=new Array;
lilv_array[110][1]=new Array;
lilv_array[110][2]=new Array;
lilv_array[110][1][1]=0.04785;
lilv_array[110][1][2]=0.05225;
lilv_array[110][1][3]=0.05225;
lilv_array[110][1][4]=0.05225;
lilv_array[110][1][5]=0.05225;
lilv_array[110][1][6]=0.0539;
lilv_array[110][2][1]=0.0275;
lilv_array[110][2][2]=0.0275;
lilv_array[110][2][3]=0.0275;
lilv_array[110][2][4]=0.0275;
lilv_array[110][2][5]=0.0275;
lilv_array[110][2][6]=0.0325;

//基准利率_上浮15%
lilv_array[115]=new Array;
lilv_array[115][1]=new Array;
lilv_array[115][2]=new Array;
lilv_array[115][1][1]=0.05002;
lilv_array[115][1][2]=0.05462;
lilv_array[115][1][3]=0.05462;
lilv_array[115][1][4]=0.05462;
lilv_array[115][1][5]=0.05462;
lilv_array[115][1][6]=0.05635;
lilv_array[115][2][1]=0.0275;
lilv_array[115][2][2]=0.0275;
lilv_array[115][2][3]=0.0275;
lilv_array[115][2][4]=0.0275;
lilv_array[115][2][5]=0.0275;
lilv_array[115][2][6]=0.0325;

//基准利率_上浮20%
lilv_array[120]=new Array;
lilv_array[120][1]=new Array;
lilv_array[120][2]=new Array;
lilv_array[120][1][1]=0.0522;
lilv_array[120][1][2]=0.057;
lilv_array[120][1][3]=0.057;
lilv_array[120][1][4]=0.057;
lilv_array[120][1][5]=0.057;
lilv_array[120][1][6]=0.0588;
lilv_array[120][2][1]=0.0275;
lilv_array[120][2][2]=0.0275;
lilv_array[120][2][3]=0.0275;
lilv_array[120][2][4]=0.0275;
lilv_array[120][2][5]=0.0275;
lilv_array[120][2][6]=0.0325;

//基准利率_上浮30%
lilv_array[130]=new Array;
lilv_array[130][1]=new Array;
lilv_array[130][2]=new Array;
lilv_array[130][1][1]=0.05655;
lilv_array[130][1][2]=0.06175;
lilv_array[130][1][3]=0.06175;
lilv_array[130][1][4]=0.06175;
lilv_array[130][1][5]=0.06175;
lilv_array[130][1][6]=0.0637;
lilv_array[130][2][1]=0.0275;
lilv_array[130][2][2]=0.0275;
lilv_array[130][2][3]=0.0275;
lilv_array[130][2][4]=0.0275;
lilv_array[130][2][5]=0.0275;
lilv_array[130][2][6]=0.0325;

//-------------------------------------------------------------------

$(document).ready(function () {
    window.onresize = function () {
        if (((document.body.clientWidth - 200) / 2 - parseInt(793 / 2)) > 10) {
            var temp = ((document.body.clientWidth - 200) / 2 - parseInt(793 / 2)) + 200;
            $("#divRight").css("left", parseInt(temp) + "px");
        } else {
            $("#divRight").css("left", "210px");
        }
    }
    $("#daikuantype").selectmenu({
        textClass: "ui-textClass", //文本追加样式
        change: function (event, data) {
            if (data.item.value == 1 || data.item.value == 2) {
                $("#trMethods").css("display", "table-row"); $("#tdTitle").html("&nbsp;");
                $("#divCombinationType").css("display", "none");

                if ($("#calc1_radio1").prop("checked") == false) {
                    $("#divArea").css("display", "none"); $("#divTotal").css("display", "block");
                } else {
                    $("#divArea").css("display", "block"); $("#divTotal").css("display", "none");
                }
            } else {
                $("#trMethods").css("display", "none"); $("#tdTitle").html("计算方式：");
                $("#divArea").css("display", "none"); $("#divTotal").css("display", "none"); $("#divCombinationType").css("display", "block");
            }
        }
    });
    $("#anjieyears").selectmenu({
        textClass: "ui-textClass", //文本追加样式
        change: function (event, data) {
            exc_lilv();
        }
    });
    $("#lilv").selectmenu({
        textClass: "ui-textClass", //文本追加样式
        change: function (event, data) {
            exc_lilv();
        }
    });
    $("#anjie").selectmenu({
        buttonClass: "ui-button-Stores",
        textClass: "ui-textClass" //文本追加样式
    });

});
function  TotalAndArea(flap) {
    if (flap == "Total") {
        $("#divTotal").css("display", "block"); $("#divArea").css("display", "none");
    } else if (flap == "Area") {
        $("#divTotal").css("display", "none"); $("#divArea").css("display", "block");
    }
}
function PrintInfo(){
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