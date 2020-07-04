function areaSelector(obj){
	var selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"\">\n"
		 + "  <tr>\n"
		 + "    <td colspan=\"3\" id=\"\">\n"
		 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
		 + "  			<tr style=\"line-height: 28px;\">\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'0','60')\">60m<sup>2</sup>以下</td>\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'60','90')\">60-90m<sup>2</sup></td>\n"
		 + "  			</tr>\n"
		 + "  			<tr style=\"line-height: 28px;\">\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'90','120')\">90-120m<sup>2</sup></td>\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'120','150')\">120-150m<sup>2</sup></td>\n"
		 + "  			</tr>\n"
		 + "  			<tr style=\"line-height: 28px;\">\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'150','180')\">150-180m<sup>2</sup></td>\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'180','240')\">180-240m<sup>2</sup></td>\n"
		 + "  			</tr>\n"
		 + "  			<tr style=\"line-height: 28px;\">\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'240','320')\">240-320m<sup>2</sup></td>\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'320','600')\">320-600m<sup>2</sup></td>\n"
		 + "  			</tr>\n"
		 + "  			<tr style=\"line-height: 28px;\">\n"
		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'600','9999')\">600m<sup>2</sup>以上</td>\n"
 		 + "    			<td width=\"50%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),'','全部')\">&nbsp;&nbsp;全部&nbsp;&nbsp;</td>\n"
		 + "  			</tr>\n"
		 + "  			<tr style=\"line-height: 28px;\">\n"
		 + "    			<td colspan=\"2\" style=\"text-align: center;\">手选：<input type=\"text\" id=\"TEMP1\" name=\"TEMP1\" value=\"\" style=\"border: 1px solid #BDC6CF;\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\">-<input type=\"text\" name=\"TEMP2\" id=\"TEMP2\" value=\"\" style=\"border: 1px solid #BDC6CF;\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:void(-1)\" onclick=\"setSelValue($('#AREA_TEXT'),document.getElementById('TEMP1').value,document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a></td>\n"
		 + "  			</tr>\n"
		 + "  		</table>\n"
		 + "  	</td>\n"
		 + "  </tr>\n"
		 + "</table>\n";
	var position = $(obj).position();
	showSelector(position.left, position.top+$(obj).height(),obj,selector);
}

function roomSelector(obj){
	var selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"\">\n"
		 + "  <tr>\n"
		 + "    <td colspan=\"3\" id=\"\">\n"
		 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
		 + "  			<tr style=\"line-height: 28px;\">\n";
		for(var i=1; i<=9; i++){
			 if(i == 4 || i == 7){
			 	selector += "</tr>\n";
			 }
			 if(i == 9){
			 	selector += "<td width=\"33%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#ROOM_TEXT'), '', '全部')\">全部</td>\n";
			 }else{
				selector += "<td width=\"33%\" align=\"center\"><a class=\"aHref\" href=\"javascript:void(-1)\" onclick=\"setSelValue($('#ROOM_TEXT'), '" + i + "', '" + i + "')\">" + i + "室</td>\n";
			 }
		}
		selector += "  			</tr>\n"
				 + "  			<tr style=\"line-height: 28px;\">\n"
				 + "    			<td colspan=\"3\" style=\"text-align: center;\">手选：<input type=\"text\" style=\"border: 1px solid #BDC6CF;\" name=\"TEMP1\" id=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkBaseNumber(this)\">-<input type=\"text\" name=\"TEMP2\" id=\"TEMP2\" value=\"\" class=\"Input_box3\" style=\"border: 1px solid #BDC6CF;\" onKeyUp=\"checkBaseNumber(this)\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:void(-1)\" onclick=\"setSelValue($('#ROOM_TEXT'), document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a></td>\n"
				 + "  			</tr>\n"
				 + "  		</table>\n"
				 + "  	</td>\n"
				 + "  </tr>\n"
				 + "</table>\n";
		var position = $(obj).position();
		showSelector(position.left, position.top+$(obj).height(),obj,selector);
}

function showSelector(left, top , obj, str){
	var divObj = null;
	if($("#selectorDiv").length < 1){
		divObj = document.createElement("div")
		divObj.id = "selectorDiv";
		divObj.style.cssText = 'margin: 0;padding: 0;font-family: "宋体",arail;font-size: 12px;line-height: 22px;border:1px solid #ccc;background:#ffffff;border-top:none;position:absolute;height:auto;z-index: 9999;box-shadow:0px 0px 5px rgb(180, 180, 180);background-color: #EFF4F9;';
		$("body").append(divObj);
	}else{
		divObj = $("#selectorDiv");
		$(divObj).html("");
	}
	$(divObj).append(str);
	$(divObj).css({left:left+"px", top:top+"px"}).show();
}
//用户手选
function setSelValue(obj, value1, value2){
	if($.trim(value1) != "" && $.trim(value2) != ""){
		$(obj).val($.trim(value1)+"-"+$.trim(value2));
	}else if($.trim(value1) != ""){
		$(obj).val($.trim(value1));
	}else{
		$(obj).val($.trim(value2));
	}
	$("#selectorDiv").hide();
}
