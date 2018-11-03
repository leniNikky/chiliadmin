<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改个人信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="EditMsg" method="post">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="edit_user"></i><em>修改个人信息</em></span>
  </div>
  <table class="list-style">
  <input type="hidden" name="userID" value="${user.userID }">
   <tr>
    <td style="width:15%;text-align:right;">用户名：</td>
    <td>${user.userName }</td>
   </tr>
   <tr>
    <td style="text-align:right;">手机号码：</td>
    <td><input type="text" name="phone" value="${user.phone }"></td>
   </tr>
   <tr>
    <td style="text-align:right;">电子邮箱：</td>
    <td><input type="text" name="email" value="${user.email }"></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="立即修改"/></td>
   </tr>
  </table>
  </div>
  </form>
 
</body>
</html>