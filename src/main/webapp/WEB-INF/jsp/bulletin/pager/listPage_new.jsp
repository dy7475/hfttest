<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
	/* 总行数 */
	int pageRowTotal = request.getParameter("PAGE_ROW_TOTAL")==null?0:Integer.parseInt(request.getParameter("PAGE_ROW_TOTAL")); 
	/* 页偏移 */
	int pageOffset = request.getParameter("PAGE_OFFSET")==null?1:Integer.parseInt(request.getParameter("PAGE_OFFSET")); 
	/* 每页行数 */
	int perPageItem = request.getParameter("perPageItem")==null||request.getParameter("perPageItem").equals("0")?20:Integer.parseInt(request.getParameter("perPageItem")); 
	/* 总页数 */
	int pageTotalNum = pageRowTotal / perPageItem + ((pageRowTotal % perPageItem) > 0 ? 1 : 0);
	/* 显示页数 */
	int indexItem = request.getParameter("indexItem")==null||request.getParameter("indexItem").equals("0")?20:Integer.parseInt(request.getParameter("indexItem")); 
	//配置分页参数，参见上面的int indexItem = 5;int perPageItem = 10;
	int begin = 1;
	int end = pageTotalNum;
	int step = indexItem/2;
	//在记录超过一页的显示条数时才显示分页
	//确定起始，结束页
	if(indexItem%2==0){
		begin = pageOffset-step+1;
	}else{
		begin = pageOffset-step;
	}
	if(begin<1)begin=1;
	end = pageOffset + step;
	if(end>pageTotalNum)end = pageTotalNum;
%>
<div class="bbs_page">
	<%for(int i=0;i<=end-begin;i++){
		int currentPage = begin+i;
		//显示第一页的链接
		if(i==0 && currentPage!=1){
			out.println("<a hidefocus href=\"javascript:void(-1);\" onClick=\"goOtherPage(1);return false;\">1...</a>");
		}
		if(currentPage == pageOffset){
			out.println("<strong>"+currentPage+"</strong>");
		}else{
			out.println("<a hidefocus href=\"javascript:void(-1);\" onClick=\"goOtherPage("+currentPage+");return false;\">"+currentPage+"</a>");
		}
		//显示最后一页的链接
		if(i==end-begin && currentPage!=pageTotalNum){
			out.println("<a hidefocus href=\"javascript:void(-1);\" onClick=\"goOtherPage("+pageTotalNum+");return false;\">..."+pageTotalNum+"</a>");
		}
	}%>
	共<%=pageTotalNum%>页&nbsp;<%=pageRowTotal%>条</div>
<div style="clear:both;text-align:center;">
	去<input name="jump" id="jump" type="text" style="border: #87afd0 1px solid;font-size: 10px;width: 30px;
		height: 14px;background-color: #e6f7ff;text-align:center;vertical-align: middle;" size="2" value="<%=pageOffset%>"/>页	<a id="bbs_go" style="width:30px;height: 16px;line-height: 16px;padding:0 5px;border:#09C 1px solid;" href="javascript:void(-1);" onclick="goSelfDefPage();return false;">GO</a>
</div>

