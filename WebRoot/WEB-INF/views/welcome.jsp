<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试登录</title>
<jsp:include page="include/public.jsp"></jsp:include>
<style type="text/css">
	table td{
		text-align:center;
		border-bottom:1px solid black;
		border-top:1px solid black;
		line-height: 50px;
	}
</style>

<script type="text/javascript">

var userLoginFun = {
	login:function(){
		var name = $("input[name='name']").val();
		var age =  $("input[name='age']").val();
		$.ajax({
		   type: "POST",
		   url: "userLogin.do",
		   data: {"userName":name,"userAge":age},
		   dataType: "json",
		   success: function(data){
		    	if(data.success){
		    		window.location.href="show.do";
		    	}else{
		    		alert("登录失败!");
		    	}
		   	}
		});
	}
};

</script>
</head>
<body>
	<div align="center"><h4>WELCOME 测试</h4></div>
	<div align="center">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td> 名称 <input type="text" name="name"></td> 
				<td> 年龄 <input type="text" name="age"></td>
				<td><a href="javascript:void(0);" onclick="userLoginFun.login();">进入</a></td>
			</tr>
		</table>
	</div>
</body>
</html>