<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<style type="text/css">
	table td{
		text-align:center;
		border-bottom:1px solid black;
		line-height: 50px;
	}
</style>
<jsp:include page="../include/public.jsp"></jsp:include>
<script type="text/javascript">
var addUserFun = {
		addUser:function(){
			var name = $("input[name='name']").val();
			var age =  $("input[name='age']").val();
			$.ajax({
			   type: "POST",
			   url: "addUser.do",
			   data: {"userName":name,"userAge":age},
			   dataType: "json",
			   success: function(data){
			    	if(data.success){
			    		window.location.href="show.do";
			    	}else{
			    		alert("保存数据出错!");
			    	}
			   	}
			});
		}
}
</script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div align="center">
		<table cellpadding="0" cellspacing="0">
			<tr align="center">
				<td colspan="2">系统数据</td>
				<td><a href="${pageContext.request.contextPath }/play/show.do">查看</a></td>
			</tr>
			<tr>
				<td> 名称 <input type="text" name="name"></td> 
				<td> 年龄 <input type="text" name="age"></td>
				<td><a href="javascript:void();" onclick="addUserFun.addUser();">添加</a></td>
			</tr>
		</table>
	</div>
</body>
</html>