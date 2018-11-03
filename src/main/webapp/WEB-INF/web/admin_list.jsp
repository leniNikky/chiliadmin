<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="res/js/jquery.js"></script>
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
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>管理员列表</em></span>
    
  </div>
  <div class="operate">
   <form action="FindAdminByName" method="post">
    <input type="text" name="userName" class="textBox length-long" placeholder="输入管理员昵称"/>
    <input type="submit" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
     <th>编号</th>
     <th>用户昵称</th>
     <th>手机号码</th>
     <th>邮件地址</th>
     
   </tr>
   <c:forEach items="${users}" var="user"> 
   <tr>
    <td  class="center">
     <span>${user.userID }</span>
    </td>
    <td class="center">${user.userName }</td>
    <td class="center">${user.phone }</td>
    <td class="center">${user.email }</td>
    
   </tr>
   </c:forEach> 
  
 </div>
</body>
</html>