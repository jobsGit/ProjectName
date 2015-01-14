<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body >
	<div align="center">
		<div style="width:800px;height: 50px;" align="right">欢迎 ${sessionScope.USER_SESSION_KEY.name } <a href="${pageContext.request.contextPath }/play/exitSys.do">退出</a></div>
	</div>
</body>
</html>