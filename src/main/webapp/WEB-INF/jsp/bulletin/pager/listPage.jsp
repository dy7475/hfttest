<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
	/* 总行数 */
	int pageRowTotal = request.getParameter("PAGE_ROW_TOTAL")==null?0:Integer.parseInt(request.getParameter("PAGE_ROW_TOTAL")); 
	/* 页偏移 */
	int pageOffset = request.getParameter("PAGE_OFFSET")==null?1:Integer.parseInt(request.getParameter("PAGE_OFFSET")); 
	/* 每页行数 */
	int perPageItem = request.getParameter("perPageItem")==null||request.getParameter("perPageItem").equals("0")?20:Integer.parseInt(request.getParameter("perPageItem")); 
	/* 总页数 */
	int pageTotalNum = pageRowTotal / perPageItem	+ ((pageRowTotal % perPageItem) > 0 ? 1 : 0);
	/* 显示页数 */
	int indexItem = request.getParameter("indexItem")==null||request.getParameter("indexItem").equals("0")?20:Integer.parseInt(request.getParameter("indexItem")); 
%>
<div class="bbs_page_normal">
	<img src="images/left1.jpg" onclick="goOtherPage(<%=pageOffset-1 %>)" style="vertical-align: middle;height: 14px;cursor: pointer;" />
	<input id="jump" onkeyup="value=value.replace(/[^0123456789]/g,'<%=pageOffset %>')" class="home_imput" style="vertical-align: middle;line-height: 10px" value="<%=pageOffset %>" />
	<img src="images/left2.jpg" onclick="goOtherPage(<%=pageOffset+1 %>)" style="vertical-align: middle;height: 14px;cursor: pointer;" />
	<img src="images/go1.jpg" onclick="goSelfDefPage();return false;" style="vertical-align: middle;height: 14px;cursor: pointer;" />
	<span style="font-size:12px; text-align:center;font-family: '宋体'">
	 共<%=pageRowTotal%>条&nbsp;<%=pageTotalNum%>页	</span>
</div>