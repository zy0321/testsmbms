<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
 		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${param.totalCount}条记录&nbsp;&nbsp; ${pageNo}/${param.totalPageCount}页</li>
				<c:if test="${param.pageNo > 1}">
					<a href="userlist.do?queryname=${queryname}&queryUserRole=${queryUserRole}&pageNo=1">首页</a>
					<a href="userlist.do?queryname=${queryname}&queryUserRole=${queryUserRole}&pageNo=${param.pageNo-1}">上一页</a>
				</c:if>
				<c:if test="${param.pageNo < param.totalPageCount }">
					<a href="userlist.do?queryname=${queryname}&queryUserRole=${queryUserRole}&pageNo=${param.pageNo+1}">下一页</a>
					<a href="userlist.do?queryname=${queryname}&queryUserRole=${queryUserRole}&pageNo=${param.totalPageCount}">最后一页</a>
				</c:if>
			</ul>
			<input type="hidden" value="${queryname}" id="queryname">
			<input type="hidden" value="${queryUserRole}" id="queryUserRole">
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/rollpage.js"></script>
</html>