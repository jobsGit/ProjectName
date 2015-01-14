<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<style type="text/css">
	table td{
		text-align:center;
		border-bottom:1px solid black;
		line-height: 25px;
	}
</style>
<jsp:include page="../include/public.jsp"></jsp:include>
<script type="text/javascript">

var delUserFun = {
		 delUser:function(obj){
			var id = $(obj).attr("id");
			$.ajax({
			   type: "POST",
			   url: "delUser.do",
			   data: {"id":id},
			   dataType: "json",
			   success: function(data){
			    	if(data.success){
			    		window.location.href="show.do";
			    	}else{
			    		alert("删除数据出错!");
			    	}
			   	}
			});
		}
}


</script>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<table width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td>ID</td>
		<td>名称</td>
		<td>年龄</td>
		<td>操作 <a href="${pageContext.request.contextPath }/play/toAdd.do">添加</a></td>
	</tr>
	<c:forEach items="${testList }" var="test">
		<tr>
			<td>${test.id }</td>
			<td>${test.name }</td>
			<td>${test.age }</td>
			<td><a id="${test.id }" href="javascript:void(0);" onclick="delUserFun.delUser(this);">删除</a> &#12288;<a href="${pageContext.request.contextPath }/play/toEdit.do?id=${test.id }">更新</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>