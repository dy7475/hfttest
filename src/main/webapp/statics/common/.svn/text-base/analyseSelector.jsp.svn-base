<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="/common/error.jsp" %>
<%@page import="org.fto.jthink.jdbc.DataObject"%>
<%@ page import="org.jdom.*"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="org.fto.jthink.util.*"%>
<%@ page import="com.myfun7.util.Selector"%>
<%@ page import="com.myfun7.util.Constants_DIC"%>
<%@ page import="com.myfun7.bean.common.SysParameterJBean"%>
<%@ page import="com.myfun7.bean.common.DDInfoUJBean"%>
<%@ page import="com.myfun7.bean.build.BuildJBean"%>
<%@page import="org.fto.jthink.resource.*" %>
<%@page import="org.fto.jthink.j2ee.web.util.HTMLHelper"%>
<%@page import="com.myfun7.bean.user.DeptJBean" %>
<%@page import="com.myfun7.bean.user.UserJBean" %>
<%@page import="com.myfun7.db.MyfunDataStructure" %>
<%@page import="com.myfun7.util.*" %>
<%@page import="org.jdom.Element" %>
<%@page import="org.fto.jthink.j2ee.web.util.*" %>
<%@page import="org.fto.jthink.resource.*" %>
<%@page import="org.fto.jthink.util.*" %>
<%@page import="java.util.*" %>
<%
int bigDepts = 10;
BuildJBean buildJBean = new BuildJBean(request);
DeptJBean deptJBean = new DeptJBean(request);
UserJBean userJbean = new UserJBean(request);
SysParameterJBean sysParameterjBean = new SysParameterJBean(request);
DDInfoUJBean ddInfoUJBean = new DDInfoUJBean(request);
Operator operator = (Operator)request.getSession().getAttribute(Operator.class.getName());
String nowUserNo = operator.getUserNo();
String selector = "";
String deptsCount = (String)operator.getAttribute("DEPTS_COUNT");

String selectType = buildJBean.getString("SELECT_TYPE");
String inputType = buildJBean.getString("INPUT_TYPE");
String ddType = buildJBean.getString("DD_TYPE");
String caseType = buildJBean.getString("CASE_TYPE"); 
String selectedValue = sysParameterjBean.getString("SELECTED_VALUE");
String objName = selectType + inputType;

//类型
if(selectType.equals("BUILD_CASE_TYPE")){
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
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + Constants_DIC.DIC_CASE_TYPE_SALE_FUN + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"出售\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">出售</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + Constants_DIC.DIC_CASE_TYPE_LEASE_FUN + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"出租\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">出租</a></td>\n"
			 + "  			</tr>"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
}else if(selectType.equals("CASE_TYPE") || selectType.equals("S_CASE_TYPE")){

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
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + Constants_DIC.DIC_CASE_TYPE_SALE_FUN + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"出售\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">出售</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + Constants_DIC.DIC_CASE_TYPE_LEASE_FUN + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"出租\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">出租</a></td>\n"
			 + "  			</tr><tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + Constants_DIC.DIC_CASE_TYPE_BUY_CUST + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"求购\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">求购</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + Constants_DIC.DIC_CASE_TYPE_RENT_CUST + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"求租\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">求租</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//图形
}else if(selectType.equals("GRAPHIC")){
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
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"LINE\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"线状图\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">线状图</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"CYLIND\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"柱状图\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">柱状图</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
	}else if(selectType.equals("S_GRAPHIC")){
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
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"CYLIND\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"柱状图\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">柱状图</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"CAKE\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"饼状图\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">饼状图</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
}else if(selectType.equals("UNIT")){
	String realtime = buildJBean.getString("REALTIME");
	String year = "";
	if(realtime.length() > 4){
		year = realtime.substring(0,4);
		if(!year.matches("[0-9]+?")){
			year =  DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy");
		}
	}else{
		year =  DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy");
	}
	String yearStart = year + "-01-01";
	String yearEnd = year + "-12-31";
	String yearText = year + "年";
	int month =  DateTimeHelper.getMonthOfYear(DateTimeHelper.addMonths(DateTimeHelper.getSystemDate(),-1));
	String monthStart = year + "-" + month + "-01";
	String monthEnd = year + "-" + month + "-" + DateTimeHelper.getDaysOfMonth(DateTimeHelper.addMonths(DateTimeHelper.getSystemDate(),-1));
	String monthText = year + "年" + month + "月";
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\" style=\"border-collapse:separate\">\n"
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
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"MM\" onclick=\"selectUnit('" + yearStart + "', '" + yearEnd + "', '" + yearText + "', this);return false;\" displayText=\"按月\"/><a href=\"#a\" onclick=\"selectUnit('" + yearStart + "', '" + yearEnd + "', '" + yearText + "', this.parentNode.childNodes[0]);return false;\">按月</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"DD\" onclick=\"selectUnit('" + monthStart + "', '" + monthEnd + "', '" + monthText + "', this);return false;\" displayText=\"按日\"/><a href=\"#a\" onclick=\"selectUnit('" + monthStart + "', '" + monthEnd + "', '" + monthText + "', this.parentNode.childNodes[0]);return false;\">按日</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

}else if(selectType.equals("S_UNIT")){
	
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
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"1\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按城区\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按城区</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"2\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按范围\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按范围</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"3\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按类型\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按类型</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"4\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按用途\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按用途</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"5\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按装修\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按装修</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"6\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按来源\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按来源</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"7\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按年代\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按年代</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"8\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按面积\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按面积</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"11\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按总价\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按总价</a></td>\n"
			 + "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"9\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按单价\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按单价</a></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td colspan=\"2\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"10\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"按户型\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">按户型</a></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

}else if(selectType.equals("TIME")){
	String unit = buildJBean.getString("UNIT");
	if(unit.equals("MM")){
		int thisYear = DateTimeHelper.getYearOfDate(DateTimeHelper.getSystemDate());
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
				for(int i=0; i<15; i++){
				  if(i % 3 == 0 && i != 0){
				  	selector += "  			</tr><tr>\n";
				  }
				  String time1 = (thisYear - i) + "-01-01";
				  String time2 = (thisYear - i) + "-12-31";
				  selector += "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + (thisYear - i) + "\" onclick=\"selectTime('" + time1 + "', '" + time2 + "', this);return false;\" displayText=\"" + (thisYear - i) + "年\" class=\"imput\"/><a href=\"#a\" onclick=\"selectTime('" + time1 + "', '" + time2 + "', this.parentNode.childNodes[0]);return false;\">" + (thisYear - i) + "年</a></td>\n";
				}
		selector += "  			</tr>\n"
				 + "  		</table>\n"
				 + "  	</td>\n"
				 + "  </tr>\n"
				 + "</table>\n";
	}else if(unit.equals("DD")){
		String realtime = buildJBean.getString("REALTIME");
		String year = "";
		if(realtime.length() > 4){
			year = realtime.substring(0,4);
			if(!year.matches("[0-9]+?")){
				year =  DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy");
			}
		}else{
			year =  DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy");
		}
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
				for(int i=1; i<=12; i++){
				  if(i != 1&&(i-1) % 3 == 0 ){
				  	selector += "  			</tr><tr>\n";
				  }
				  String time1 = year + "-" + i + "-01";
				  String time2 = year + "-" + i + "-" + DateTimeHelper.getDaysOfMonth(DateTimeHelper.parseToDate(year + "-" + i + "-" + "01"));
				  selector += "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + i + "\" onclick=\"selectTime('" + time1 + "', '" + time2 + "', this);return false;\" displayText=\"" + year + "年" + i + "月\" class=\"imput\"/><a href=\"#a\" onclick=\"selectTime('" + time1 + "', '" + time2 + "', this.parentNode.childNodes[0]);return false;\">" + i + "月</a></td>\n";
				}
		selector += "  			</tr>\n"
				 + "  		</table>\n"
				 + "  	</td>\n"
				 + "  </tr>\n"
				 + "</table>\n";
	}
//城区
}else if(selectType.equals("HOUSE_TYPE") || selectType.equals("HOUSE_USEAGE") || selectType.equals("HOUSE_FITMENT")){
	
	List objList = ddInfoUJBean.getDDListByDicType(selectType);

	
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
	for(int i=0; i<=objList.size(); i++){
		if(i != 0 && i % 2 == 0){
			selector += "  			</tr><tr>\n";
		}
		if(i == objList.size()){
		  selector += "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"全部\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">全部</a></td>\n";
		  break;
		}
		DataObject dObject = (DataObject)objList.get(i);		
		String dicValue = dObject.get("DIC_VALUE");
		String dicCnMsg = dObject.get("DIC_CN_MSG");
		selector += "    			<td><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + dicValue + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"" + dicCnMsg + "\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">" + dicCnMsg + "</a></td>\n";
	}
	
	selector += "  			</tr>\n";
	selector += "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//售单价







}else if(selectType.equals("UNIT_PRICE") && (caseType.equals("Constants_DIC.DIC_CASE_TYPE_SALE_FUN") || caseType.equals("Constants_DIC.DIC_CASE_TYPE_BUY_CUST"))){
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
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '0', '3000')\">3000元/m<sup>2</sup>以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '3000', '4000')\">3000-4000元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '4000', '5000')\">4000-5000元/m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '5000', '6000')\">5000-6000元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '6000', '7000')\">6000-7000元/m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '7000', '9000')\">7000-9000元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '9000', '12000')\">9000-12000元/m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '12000', '20000')\">12000-20000元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '20000', '999999')\">20000元/m<sup>2</sup>以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(true, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//租单价



}else if(selectType.equals("UNIT_PRICE") && (caseType.equals("Constants_DIC.DIC_CASE_TYPE_LEASE_FUN") || caseType.equals("Constants_DIC.DIC_CASE_TYPE_RENT_CUST"))){
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
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '0', '20')\">20元/m<sup>2</sup>以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '20', '50')\">20-50元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '50', '80')\">50-80元/m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '80', '110')\">80-110元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '110', '140')\">110-140元/m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '140', '170')\">140-170元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '170', '200')\">170-200元/m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '200', '500')\">200-400元/m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '400', '9999')\">400元/m<sup>2</sup>以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(true, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"#a\" onclick=\"setValue(true, 'UNIT_PRICE_TEXT', 'UNIT_PRICE1', 'UNIT_PRICE2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\"></td>\n"
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
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '0', '60')\">60m<sup>2</sup>以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '60', '90')\">60-90m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '90', '120')\">90-120m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '120', '150')\">120-150m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '150', '180')\">150-180m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '180', '240')\">180-240m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '240', '320')\">240-320m<sup>2</sup></td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '320', '600')\">320-600m<sup>2</sup></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'AREA_TEXT', 'AREA1', 'AREA2', '600', '9999')\">600m<sup>2</sup>以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(true, 'AREA_TEXT', 'AREA1', 'AREA2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"#a\" onclick=\"setValue(true, 'AREA_TEXT', 'AREA1', 'AREA2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//售总价
}else if(selectType.equals("TOTAL_PRICE") && (caseType.equals("Constants_DIC.DIC_CASE_TYPE_SALE_FUN") || caseType.equals("Constants_DIC.DIC_CASE_TYPE_BUY_CUST"))){
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
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '0', '30')\">30万以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '30', '50')\">30-50万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '50', '70')\">50-70万</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '70', '90')\">70-90万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '90', '120')\">90-120万</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '120', '150')\">120-150万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '150', '200')\">150-200万</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '200', '400')\">200-400万</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '400', '9999')\">400万以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(true, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"#a\" onclick=\"setValue(true, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//租总价
}else if(selectType.equals("TOTAL_PRICE") && (caseType.equals("Constants_DIC.DIC_CASE_TYPE_LEASE_FUN") || caseType.equals("Constants_DIC.DIC_CASE_TYPE_RENT_CUST"))){
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
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '0', '500')\">500元以下</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '500', '800')\">500-800元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '800', '1200')\">800-1200元</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '1200', '1800')\">1200-1800元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '1800', '2600')\">1800-2600元</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '2600', '3200')\">2600-3200元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '3200', '4200')\">3200-4200元</td>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '4200', '8000')\">4200-8000元</td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '8000', '99999')\">8000元以上</td>\n"
	  		 + "    			<td width=\"50%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(true, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', '', '全部')\">全部</td>\n"
			 + "  			</tr>\n"
			 + "    			<td colspan=\"2\"><a href=\"#a\" onclick=\"setValue(true, 'TOTAL_PRICE_TEXT', 'TOTAL_PRICE1', 'TOTAL_PRICE2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkPointNumber(this);return false;\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//户型
}else if(selectType.equals("ROOMS")){
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
	  	selector += "    			<td width=\"33%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(true, 'ROOMS_TEXT', 'ROOMS1', 'ROOMS2', '', '全部')\">全部</td>\n";
	  }else{
		selector += "    			<td width=\"33%\" align=\"center\"><a href=\"#a\" onclick=\"setValue(false, 'ROOMS_TEXT', 'ROOMS1', 'ROOMS2', '" + i + "', '" + i + "')\">" + i + "室</td>\n";
	  }
	}
	selector += "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td colspan=\"3\"><a href=\"#a\" onclick=\"setValue(true, 'ROOMS_TEXT', 'ROOMS1', 'ROOMS2', document.getElementById('TEMP1').value,  document.getElementById('TEMP2').value)\" class=\"menu_zi_select\">确定</a>手选：<input type=\"text\" name=\"TEMP1\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkBaseNumber(this);return false;\">-<input type=\"text\" name=\"TEMP2\" value=\"\" class=\"Input_box3\" onKeyUp=\"checkBaseNumber(this);return false;\"></td>\n"
			 + "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";

//部门
}else if(selectType.equals("DEPT_ID") || selectType.equals("S_DEPT_ID") || "INNER_DEPT_ID".equals(selectType)){
	String innerCounr = buildJBean.getString("INNER_COUNT");
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1)\" onclick=\"try{closeed('fd1');}catch(e){}try{closeed('fd2');}catch(e){}return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n";
	if(Integer.parseInt(deptsCount) > bigDepts){
		 selector += "  		<tr>\n"
				 + "    			<td width=\"5%\">选：</td>\n"
				 + "    			<td width=\"95%\"><input type=\"text\" name=\"DEPT_CODE\" id=\"DEPT_CODE\" oninput=\"matchDept(this, '"+selectType+"')\" class=\"Input_box2\" style=\"width:140px;\" value=\"请输入分店拼音或名字\" onclick=\"clearText(this);return false;\"></td>\n"
				 + "  			</tr>\n"
				 + "  			<tr>\n"
				 + "				<td colspan=\"2\">\n"
				 + "					<div id=\"deptDiv\">\n"
				 + "    					<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n";
	}
	deptJBean.setPageRows(bigDepts);
	List objList = deptJBean.getDeptList(operator.getCompId());
	int pageRowTotal = deptJBean.getPageTotalRows(); 
	int pageOffset = deptJBean.getPageOffset();
	int pageRowSize = Integer.parseInt(deptJBean.getPageRows());
	int pageTotal = deptJBean.getPages(pageRowTotal);
	for(int i=0; i<objList.size(); i++){
		DataObject dObject = (DataObject)objList.get(i);
		String deptId = dObject.get("DEPT_ID");
		String deptName = dObject.get("DEPT_NAME");
		selector += "		<tr>\n" 
				 + "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + deptId + "\" onclick=\"selectDept('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"" + deptName + "\"/><a href=\"#a\" onclick=\"selectDept('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">" + deptName + "</a></td>\n"
				 + "		</tr>\n";
	}
	if("1".equals(innerCounr) && "INNER_DEPT_ID".equals(selectType)){
		selector += "  			<tr>\n";
		selector += "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"ALL\" onclick=\"selectDept('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"全公司\"/><a href=\"#a\" onclick=\"selectDept('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">全公司</a></td>\n";
		selector += "  			</tr>\n";
	}
	if(pageTotal > 1){
		selector += "		<tr>\n"
			 + "    			<td align=\"center\" colspan=\"2\" height=\"25\"><a href=\"#a\" onclick=\"splitPageForBound(" + (pageOffset-1) + ", " + pageRowTotal +", " + pageTotal + ", '"+ selectType +"')\"><<上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;"
			 + "    			<a href=\"#a\" onclick=\"splitPageForBound(" + (pageOffset+1) + ", " + pageRowTotal +", " + pageTotal + ", '"+ selectType +"')\">下一页>></a><td>"
			 + "  			</tr>\n";
	}
	if(Integer.parseInt(deptsCount) > bigDepts){
		selector += "						</table>\n"
				 + "					</div>\n"
				 + "				</td>\n"
				 + "			</tr>\n";
	}
	selector += "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";


}else if(selectType.equals("USER_ID") || selectType.equals("S_USER_ID")){
	String deptId =null;
	deptId = buildJBean.getString("DEPT_ID");
	userJbean.setPageRows(12);
	List objList = userJbean.getUserListByDept(deptId, "");
	int pageRowTotal = userJbean.getPageTotalRows(); 
	int pageOffset = userJbean.getPageOffset();
	int pageRowSize = Integer.parseInt(userJbean.getPageRows());
	int pageTotal = userJbean.getPages(pageRowTotal);
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

	for(int i=0; i<objList.size(); i++){
		if(i != 0 && i % 2 == 0){
			selector += "  			</tr><tr>\n";
		}
		DataObject dObject = (DataObject)objList.get(i);
		String userId = dObject.get("USER_ID");
		String userName = dObject.get("USER_NAME");
		selector += "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + userId + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"" + userName + "\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">" + userName + "</a></td>\n";
	}
	selector += "  			</tr>\n";
	if(pageTotal > 1){
		selector += "			<tr>\n"
			 + "    			<td align=\"center\" colspan=\"2\" height=\"25\"><a href=\"javascript:createDivForPage(" + (pageOffset-1) + "," + pageRowTotal +"," + pageTotal + ",'"+selectType+"');\"><<上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;"
			 + "    			<a href=\"javascript:createDivForPage(" + (pageOffset+1) + "," + pageRowTotal +"," + pageTotal + ",'"+selectType+"');\">下一页>></a><td>"
			 + "  			</tr>\n";
	}
	selector += "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
}else if(selectType.equals("YEAR")){
	int thisYear = DateTimeHelper.getYearOfDate(DateTimeHelper.getSystemDate());
	int indexD = thisYear - 2004;
	selector = "<table width=\"200px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\" style=\"border-collapse:separate\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"180\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1);\" onclick=\"closeed('fd1');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n";
			for(int i=0; i<indexD; i++){
			  if(i % 3 == 0 && i != 0){
			  	selector += "  			</tr><tr>\n";
			  }
			  if(String.valueOf((thisYear - i)).equals(selectedValue)){
			  	selector += "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + (thisYear - i) + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"" + (thisYear - i) + "\" class=\"imput\" checked/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">" + (thisYear - i) + "年</a></td>\n";
			  }else{
			  	selector += "    			<td align=\"left\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + (thisYear - i) + "\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this);return false;\" displayText=\"" + (thisYear - i) + "\" class=\"imput\"/><a href=\"#a\" onclick=\"selectValue('" + selectType + "_TEXT', '" + selectType + "', this.parentNode.childNodes[0]);return false;\">" + (thisYear - i) + "年</a></td>\n";
			  }
			}
	selector += "  			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";
}else if(selectType.equals("BUILD_ID")){

	selector = "<table width=\"300px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"yg_tab_menu\" style=\"border-collapse:separate\">\n"
			 + "  <tr>\n"
			 + "    <td width=\"10\"><img src=\"../images/windows_left.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "    <td width=\"280\" align=\"right\" background=\"../images/windows_top_big.gif\">\n"
			 + "		<a href=\"javascript:void(-1);\" onclick=\"closeed('fd2');return false;\"><img src=\"../images/close.gif\" width=\"11\" height=\"11\" border=\"0\" /></a>\n"
			 + "	</td>\n"
			 + "    <td width=\"10\" align=\"right\"><img src=\"../images/windows_right.gif\" width=\"10\" height=\"28\" /></td>\n"
			 + "  </tr>\n"
			 + "  <tr>\n"
			 + "    <td colspan=\"3\" id=\"windows\">\n"
			 + "    	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
			 + "  			<tr>\n"
			 + "    			<td width=\"5%\">选：</td>\n"
			 + "    			<td width=\"95%\" align=\"left\" class=\"sub\"><input type=\"text\" name=\"BUILD_CODE\" id=\"BUILD_CODE\" oninput=\"matchBuild(this);return false;\" class=\"street_box\" style=\"width:230px;\" value=\"请输入楼盘拼音或名字\" onclick=\"clearText(this);return false;\"></td>\n"
			 + "  			</tr>\n"
			 + "  			<tr>\n"
			 + "    			<td colspan=\"2\">\n"
			 + "					<div id=\"buildDiv\">\n"
			 + "					</div>\n"
			 + "				</td>\n"
			 + "			</tr>\n"
			 + "			<tr>\n"
			 + "				<td colspan=\"2\" align=\"right\"><a href=\"#a\" onclick=\"document.getElementById('BUILD_ID_TEXT').value = document.getElementById('BUILD_CODE').value;closeed('fd2');\" class=\"menu_zi_select\">确定</a><div style=\"padding-top:5px;\">输入汉字进行模糊匹配!</div></td>\n"
			 + "			</tr>\n"
			 + "  		</table>\n"
			 + "  	</td>\n"
			 + "  </tr>\n"
			 + "</table>\n";


//楼盘-匹配楼盘
}else if(selectType.equals("MATCH_BUILD")){
	String buildCode = buildJBean.getString("BUILD_CODE");
	buildCode = java.net.URLDecoder.decode(buildCode,"utf-8");
	
	List objList = buildJBean.getMyBuildingList(buildCode);
	
	String selectedBuildId = buildJBean.getString("BUILD_ID");

	selector = "						<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n";
	for(int i=0; i<objList.size(); i++){
		selector += "  							<tr>\n";
		DataObject dObject = (DataObject)objList.get(i);
		String buildId = dObject.get("BUILD_ID");
		String buildCode1 = dObject.get("BUILD_CODE");
		String buildName = dObject.get("BUILD_NAME");
		String regId = dObject.get("BUILD_REGION");
		String streetId = dObject.get("BUILD_STREET");
		String regName = dObject.get("REG_NAME");
		regName = regName == null ? "" : HTMLHelper.toHTMLString(regName, HTMLHelper.ES_DEF$INPUT);
		String streetName = dObject.get("STEET_NAME");
		streetName = streetName == null ? "" : HTMLHelper.toHTMLString(streetName, HTMLHelper.ES_DEF$INPUT);
		String buildRound = dObject.get("BUILD_ROUND");
		String houseRound = ddInfoUJBean.getMSGValue("HOUSE_ROUND", buildRound);
		String regNameShow = regName.equals("") ? "-" : regName;
		String buildNameShow = "<span style='color:#e95f09'>" + buildName + "</span>&nbsp;&nbsp;<span style='color:#666'>" + regNameShow + "&nbsp;&nbsp;" + streetName + "</span>";

		if(selectedBuildId.equals(buildId)){
			selector += "								<td align=\"left\" class=\"sub\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + buildId + "\" text=\"" + buildName + "\" onclick=\"selectBuildValue(this);return false;\" BUILD_CODE=\"" + buildCode1 + "\" REG_ID=\"" + regId + "\" REG_NAME=\"" + regName + "\" STREET_ID=\"" + streetId + "\" STREET_NAME=\"" + streetName + "\" ROURD=\"" + buildRound + "\" ROUND_NAME=\"" + houseRound + "\" checked/><a href=\"#a\" onclick=\"selectBuildValue(this.parentNode.childNodes[0]);return false;\">" + buildNameShow + "</a></td>\n";
		}else{
			selector += "								<td align=\"left\" class=\"sub\"><input type=\"" + inputType + "\" name=\"" + objName + "\" id=\"" + objName + "\" value=\"" + buildId + "\" text=\"" + buildName + "\" BUILD_CODE=\"" + buildCode1 + "\" REG_ID=\"" + regId + "\" REG_NAME=\"" + regName + "\" STREET_ID=\"" + streetId + "\" STREET_NAME=\"" + streetName + "\" ROURD=\"" + buildRound + "\" ROUND_NAME=\"" + houseRound + "\" onclick=\"selectBuildValue(this);return false;\"/><a href=\"#a\" onclick=\"selectBuildValue(this.parentNode.childNodes[0]);return false;\">" + buildNameShow + "</a></td>\n";
		}
		selector += "  							</tr>\n";

	}
	selector += "						</table>\n";
}
out.println(selector);
%>
