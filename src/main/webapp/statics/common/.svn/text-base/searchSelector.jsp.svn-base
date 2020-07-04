<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="/common/error.jsp" %>
<%@page import="org.fto.jthink.j2ee.web.util.HTMLHelper"%>
<%@page import="com.myfun7.bean.common.DDInfoUJBean"%>
<%@page import="org.fto.jthink.util.DateTimeHelper"%>
<%@page import="java.util.*"%>
<%@page import="org.jdom.Element"%>
<%@page import="com.myfun7.util.*" %>
<%@page import="org.fto.jthink.util.XMLHelper"%>
<%@page import="com.myfun7.bean.house.StreetJBean"%>
<%@page import="org.fto.jthink.jdbc.DataObject"%>
<%
DDInfoUJBean ddInfoUJBean = new DDInfoUJBean(request);
StreetJBean streetJBean = new StreetJBean(request);
String selector = "";
String selectType = ddInfoUJBean.getString("SELECT_TYPE");
String inputType = ddInfoUJBean.getString("INPUT_TYPE");
String objName = selectType + inputType;
Operator operator = (Operator)session.getAttribute("operator");
//范围
if(selectType.equals("BOUND")){
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"0\" onclick=\"selectValue('BOUND_TEXT', 'BOUND', '', this)\" displayText=\"个人\" class=\"imput\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('BOUND_TEXT', 'BOUND', '', this.parentNode.childNodes[0])\">个人</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"1\" onclick=\"selectValue('BOUND_TEXT', 'BOUND', '', this)\" displayText=\"中介\" class=\"imput\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('BOUND_TEXT', 'BOUND', '', this.parentNode.childNodes[0])\">中介</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//日期
}else if(selectType.equals("TIME")){
	java.util.Date nowDate = DateTimeHelper.getSystemDate();
	String nowDateStr = DateTimeHelper.formatDateTimetoString(nowDate, "yyyy-MM-dd 23:59:59");
	String oneDayStr = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(nowDate,-1), "yyyy-MM-dd");
	String threeDayStr = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(nowDate,-3), "yyyy-MM-dd");
	String oneWeekStr = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(nowDate,-7), "yyyy-MM-dd");
	String oneMonthStr = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(nowDate,-1), "yyyy-MM-dd");
	String helfYear = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(nowDate,-6), "yyyy-MM-dd");
	
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"" + oneDayStr + "\" value2=\"" + nowDateStr + "\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this)\" displayText=\"一天\" class=\"imput\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this.parentNode.childNodes[0])\">一天</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + selectType + "\" value=\"" + threeDayStr + "\" value2=\"" + nowDateStr + "\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this)\" displayText=\"三天\" class=\"imput\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this.parentNode.childNodes[0])\">三天</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"" + oneWeekStr + "\" value2=\"" + nowDateStr + "\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this)\" displayText=\"一周\" class=\"imput\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this.parentNode.childNodes[0])\">一周</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + selectType + "\" value=\"" + oneMonthStr + "\" value2=\"" + nowDateStr + "\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this)\" displayText=\"一月\" class=\"imput\" /><a href=\"javascript:void(-1)\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this.parentNode.childNodes[0])\">一月</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"" + helfYear + "\" value2=\"" + nowDateStr + "\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this)\" displayText=\"半年\" class=\"imput\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this.parentNode.childNodes[0])\">半年</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + selectType + "\" value=\"\" value2=\"\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this)\" displayText=\"全部\" class=\"imput\" /><a href=\"javascript:void(-1)\" onclick=\"selectValue('TIME_TEXT', 'TIME1', 'TIME2', this.parentNode.childNodes[0])\">全部</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//户型
}else if(selectType.equals("ROOM")){
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n";
	
	for(int i=1; i<=9; i++){
	  if(i == 4 || i == 7){
	  	selector += "  			</tr>\n";
	  }
	  if(i == 9){
	  	selector += "    			<td width=\"33%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'ROOM_TEXT', 'ROOM1', 'ROOM2', '', '全部')\">全部</td>\n";
	  }else{
		selector += "    			<td width=\"33%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'ROOM_TEXT', 'ROOM1', 'ROOM2', '" + i + "', '" + i + "')\">" + i + "室</td>\n";
	  }
	}
	selector += "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td colspan=\"3\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'ROOM_TEXT', 'ROOM1', 'ROOM2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkBaseNumber(this)\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkBaseNumber(this)\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";


//面积
}else if(selectType.equals("AREA")){
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '0', '60')\">60m<sup>2</sup>以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '60', '90')\">60-90m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '90', '120')\">90-120m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '120', '150')\">120-150m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '150', '180')\">150-180m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '180', '240')\">180-240m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '240', '320')\">240-320m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '320', '600')\">320-600m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '600', '9999')\">600m<sup>2</sup>以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'AREA_TEXT', 'AREA1', 'AREA2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'AREA_TEXT', 'AREA1', 'AREA2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//总价
}else if(selectType.equals("PRICE")){
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '0', '30')\">30万以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '30', '50')\">30-50万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '50', '70')\">50-70万</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '70', '90')\">70-90万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '90', '120')\">90-120万</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '120', '150')\">120-150万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '150', '200')\">150-200万</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '200', '400')\">200-400万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '400', '9999')\">400万以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'PRICE_TEXT', 'PRICE1', 'PRICE2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'PRICE_TEXT', 'PRICE1', 'PRICE2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//租金
}else if(selectType.equals("LEASE_PRICE")){
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '0', '500')\">500元以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '500', '800')\">500-800元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '800', '1200')\">800-1200元</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '1200', '1800')\">1200-1800元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '1800', '2600')\">1800-2600元</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '2600', '3200')\">2600-3200元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '3200', '4200')\">3200-4200元</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '4200', '8000')\">4200-8000元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(false, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '8000', '99999')\">8000元以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"javascript:void(-1)\" onclick=\"setValue(true, 'LEASE_PRICE_TEXT', 'LEASE_PRICE1', 'LEASE_PRICE2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this)\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";


//DD字段   类型
}else if(selectType.equals("USEAGE")){
	
	List<DataObject> dataInfos = ddInfoUJBean.getDDListByDicType("HOUSE_USEAGE");
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n";
	for(int i=0; i<=dataInfos.size(); i++){
		if(i != 0 && i % 2 == 0){
			selector += "  			</tr><tr>\n";
		}
		if(i == dataInfos.size()){
		  selector += "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', '', this)\" displayText=\"全部\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', '', this.parentNode.childNodes[0])\">全部</a></td>\n";
		  break;
		}
		DataObject dataInfoEL = dataInfos.get(i);
		String dicValue = dataInfoEL.get("DIC_VALUE");
		String dicCnMsg = HTMLHelper.toHTMLString(dataInfoEL.get("DIC_CN_MSG"));
		selector += "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"" + dicValue + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', '', this)\" displayText=\"" + dicCnMsg + "\"/><a href=\"javascript:void(-1)\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', '', this.parentNode.childNodes[0])\">" + dicCnMsg + "</a></td>\n";
	}
	
	selector += "  			</tr>\n";
	selector += "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";



//区域
}else if(selectType.equals("REGION")){
	//String myProvince = streetJBean.getString("PROVINCE_ID");
	//myProvince = myProvince.equals("") ? sysParameterJBean.getParaValue("FUN_PROVINCE") : myProvince;
	//String myCity = streetJBean.getString("CITY_ID");
	//myCity = myCity.equals("") ? sysParameterJBean.getParaValue("FUN_CITY") : myCity;
	//已经选择了的区域和街道
	String selectedReg = streetJBean.getString("SALE_REGION");
	String selectedSector = streetJBean.getString("SALE_SECTORS");
	
	List<DataObject> dataInfos = streetJBean.getRegList(operator.getCityId());
	selector = "<table width=\"200px\" style=\"cursor: pointer;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"5%\"></td>\n"
			 + "    			<td width=\"95%\">\n"
			 + "					<div id=\"regDiv\">\n"
			 + "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "							<tr>\n";
	for(int i=0; i<=dataInfos.size(); i++){
		if(i != 0 && i % 2 == 0){
			selector += "							</tr><tr>\n";
		}
		if(i == dataInfos.size()){
			selector += "								<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"\" onclick=\"cleanReg()\" displayText=\"全部\"/><a href=\"javascript:void(-1)\" onclick=\"cleanReg()\">全部</a></td>\n";
		  break;
		}
		DataObject dataInfoEL = dataInfos.get(i);
		String regId = dataInfoEL.get("REG_ID");
		String regName = HTMLHelper.toHTMLString(dataInfoEL.get("REG_NAME"));
		String regIdIndex = " " + regId + " ";
		if(selectedReg.indexOf(regIdIndex) != -1){
			selector += "								<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"" + regName + "\" text=\"" + regName + "\" onclick=\"selectReg(this)\" checked/><a href=\"javascript:void(-1)\" onclick=\"this.parentNode.childNodes[0].checked=!this.parentNode.childNodes[0].checked;selectReg(this.parentNode.childNodes[0])\">" + regName + "</a></td>\n";
		}else{
			selector += "								<td><input type=\"" + inputType + "\" name=\"" + objName + "\" value=\"" + regName + "\" text=\"" + regName + "\" onclick=\"selectReg(this)\"/><a href=\"javascript:void(-1)\" onclick=\"this.parentNode.childNodes[0].checked=!this.parentNode.childNodes[0].checked;selectReg(this.parentNode.childNodes[0])\">" + regName + "</a></td>\n";
		}
	}
	selector += "  							</tr>\n"
			 + "						</table>\n"
			 + "					</div>\n"
			 + "					<div id=\"streetDiv\" style=\"display: none\">\n"
			 + "					</div>\n"
			 + "				</td>\n"
			 + "			</tr>\n"
			 + "			<tr>\n"
			 + "				<td align=\"right\" colspan=\"2\"><a href=\"javascript:void(-1)\" onclick=\"closeed('fd1');\" class=\"menu_zi_select\">确定</a></td>\n"
			 + "			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
}
out.println(selector);
%>
