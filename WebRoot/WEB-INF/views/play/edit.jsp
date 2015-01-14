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
		border-top:1px solid black;
		line-height: 50px;
	}
</style>
<jsp:include page="../include/public.jsp"></jsp:include>ipt>
<script type="text/javascript">

var editUserFun = {
		 editUser:function(obj){
			var name = $("input[name='name']").val();
			var age =  $("input[name='age']").val();
			var id = $(obj).attr("id");
			$.ajax({
			   type: "POST",
			   url: "editUser.do",
			   data: {"id":id,"userName":name,"userAge":age},
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
	<div align="center"><h4>${testObj.id }数据更新</h4></div>
	<div align="center">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td> 名称 <input type="text" name="name" value="${testObj.name }"></td> 
				<td> 年龄 <input type="text" name="age" value="${testObj.age }"></td>
				<td><a id="${testObj.id }" href="javascript:void();" onclick="editUserFun.editUser(this);">更新</a></td>
			</tr>
		</table>
	</div>
</body>
</html>