<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ban辣酱后台管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<style>html,body{width:100%;height:100%;}</style>
<script src="res/js/jquery.js"></script>
<script src="res/js/eject.js"></script>
<script src="res/js/public.js"></script>
</head>
<body>
<%-- <input type="hidden" value="${admin.userName }" id="admin">
<script type="text/javascript">
	var admin = document.getElementById("admin");
	if(admin.value==""){
			window.location.href="http://localhost:8080/banlajiang/zadmin/checklogin.jsp";
	}
</script> --%>
<input value="${usertotal }"  id="notnull" type="hidden" >
<!-- <a href="NewGoods">a</a> -->
<script type="text/javascript">

if(document.getElementById("notnull").value==""){
	window.location.href="count";
}
</script>

</body>
</html>