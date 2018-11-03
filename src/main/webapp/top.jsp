<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>header</title>
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- <script type="text/javascript">
	var admin = document.getElementById("admin");
	if(admin.value==""){
			window.location.href="http://localhost:8080/banlajiang/zadmin/checklogin.jsp";
	}
</script> -->
<div class="header">
 <div class="logo">
  <img src="res/images/logo.png" title="在哪儿"/>
 </div>
 <div class="fr top-link">
  
  <c:choose>
				<c:when test="${user ne null }">
				<a href="#" title="访问站点"><i class="shopLinkIcon"></i><span>访问站点</span></a>
					<a href="admin_list.html" target="mainCont" title="DeathGhost"><i class="adminIcon"></i><span>管理员：${user.userName }</span></a>
  
  <a href="/userExit" title="安全退出" style="background:rgb(60,60,60);" target="rightFrame"><i class="quitIcon"></i><span>安全退出</span></a>
				</c:when>
				<c:otherwise>
				
					<li><a href="http://47.106.149.153:8080/banlajiang/zadmin/adminlogin.jsp" target="rightFrame">管理员登录</a></li>
				</c:otherwise>
			</c:choose>
  
 </div>
</div>
</body>
</html>