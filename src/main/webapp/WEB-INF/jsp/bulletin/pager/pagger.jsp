<%@page import="com.myfun.utils.StringUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	/* 总行数 */
	int _pageRowTotal = StringUtil.parseInteger(request.getParameter("PAGE_ROW_TOTAL"), 0); 
	/* 页偏移 */
	int _pageOffset = StringUtil.parseInteger(request.getParameter("PAGE_OFFSET"), 1); 
	/* 每页行数 */
	int _pageRowSize = StringUtil.parseInteger(request.getParameter("PAGE_ROW_SIZE"), 20); 
	/* 总页数 */
	int _pageTotalNum = _pageRowTotal / _pageRowSize + ((_pageRowTotal % _pageRowSize) > 0 ? 1 : 0);
	int index = 0;
	if(_pageOffset>1){
		out.print("<a onclick=\"goOtherPage("+(1)+")\" class=\"pageout\" onmouseover=\"this.className='pageover'\" onmouseout=\"this.className='pageout'\">首页</a>");
		out.print("<a onclick=\"goOtherPage("+(_pageOffset-1)+")\" class=\"pageout\" onmouseover=\"this.className='pageover'\" onmouseout=\"this.className='pageout'\">&lt;上一页</a>");
	}
	if(_pageTotalNum <= 3){
		index = 1;
	}else if(_pageOffset-2<1){
		index = 1;
	}else if(_pageOffset+1>_pageTotalNum){
		index = _pageOffset-2;
	}else{
		index = _pageOffset-1;
	}
 %>

<%
	for(int i=index;(i<(index+3) && i<=_pageTotalNum &&_pageTotalNum!=1) ;i++){
		if(i == _pageOffset){
			out.print("<a class=\"pagenow\">"+i+"</a>");
		}else{
			out.print("<a onclick=\"goOtherPage("+i+")\" class=\"pageout\" onmouseover=\"this.className='pageover'\" onmouseout=\"this.className='pageout'\">"+i+"</a>");
		}	
	}
	if(_pageOffset<_pageTotalNum && _pageTotalNum!=1){
		out.print("<a onclick=\"goOtherPage("+(_pageOffset+1)+")\" class=\"pageout\" onmouseover=\"this.className='pageover'\" onmouseout=\"this.className='pageout'\">下一页&gt;</a>");
		out.print("<a onclick=\"goOtherPage("+(_pageTotalNum)+")\" class=\"pageout\" onmouseover=\"this.className='pageover'\" onmouseout=\"this.className='pageout'\">尾页</a>");
	}
%>

