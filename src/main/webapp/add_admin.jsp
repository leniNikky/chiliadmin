<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<title>添加管理员</title>
<style>

input{
float:left;
margin-right:10px;
}
p{
margin-top:3px;
}
.hide{
			display:none;
			}
			.show{
			display:block;
			color:red;
			font-size:12px;
			}
</style>
</head>
<body>
<div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>添加新管理员</em></span>
  </div>
  <form action="insertAdmin" method="POST">
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">管理员名称：</td>
    <td><input type="text" class="textBox length-middle" placeholder="请输入管理员名称" name="userName" id="username" onblur="uname(this)"/><p class="hide" id="p1">用户名不能为空！</p></td>
   </tr>
   <tr>
    <td style="text-align:right;">设置密码：</td>
    <td><input type="password" class="textBox length-middle" placeholder="请输入6位数初始密码" name="userPassword" id="pw" onblur="paw(this)"/><p class="hide" id="p2">请输入6-12位字符密码！</p></td>
   </tr>
   <tr>
    <td style="text-align:right;">确认密码：</td>
    <td><input type="password" class="textBox length-middle" placeholder="请再次输入密码" name="repw" id="repw" onblur="repaw(this)"/><p class="hide" id="p3">两次密码输入不一致！</p></td>
   </tr>
    <tr>
    <td style="text-align:right;">手机号码：</td>
    <td><input type="text" class="textBox length-middle" placeholder="手机号" name="phone" id="phone" onblur="p(this)"/><p class="hide" id="p4">手机号不能为空！</p></td>
   </tr>
   <tr>
    <td style="text-align:right;">邮箱：</td>
    <td><input type="text" class="textBox length-middle" placeholder="电子邮箱"  name="email" id="email" onblur="e(this)"/><p class="hide" id="p6">邮箱为空或格式不正确！</p></td>
   </tr>
   <input type="hidden" name="userRoot" value="1">
   <tr>
    <td style="text-align:right;"></td>
    <td><button type="submit" class="tdBtn"  id="reg">立即添加</button></td>
   </tr>
  </table>
  </form>
 </div>
 <script>
		
		var p1 = document.getElementById("p1");
		function uname(userName){
			if(userName.value == ""){
				p1.className = p1.className.replace("hide","show");
				userName.style.border="2px red solid";
				
			}else{
				p1.className = p1.className.replace("show","hide");
				userName.style.border="";
			}
		}
		var p2 = document.getElementById("p2");
		function paw(password){
				if(password.value.length<6 || password.value.length>12 || password.value == ""){
				p2.className = p2.className.replace("hide","show");
				password.style.border="2px red solid";
				
			}else{
				p2.className = p2.className.replace("show","hide");
				password.style.border="";
			}
		}
		var p3 = document.getElementById("p3");
		var pw = document.getElementById("pw");
		function repaw(re){
			if(re.value != pw.value){
				p3.className = p3.className.replace("hide","show");
				re.style.border="2px red solid";
				
			}else{
				p3.className = p3.className.replace("show","hide");
				re.style.border="";
			}
		}
		var p4 = document.getElementById("p4");
		function p(phone){
			if(phone.value == ""){
				p4.className = p4.className.replace("hide","show");
				phone.style.border="2px red solid";
				
			}else{
				p4.className = p4.className.replace("show","hide");
				phone.style.border="";
			}
		}
		
		var p6 = document.getElementById("p6");
		function e(email){
			    if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email.value)){
					p6.className = p6.className.replace("hide","show");
					phone.style.border="2px red solid";
					
				}else{
					p6.className = p6.className.replace("show","hide");
					phone.style.border="";
				} 
			
			
		}
		var phone = document.getElementById("phone");
		var email = document.getElementById("email");
		var repw = document.getElementById("repw");
		var username = document.getElementById("username");
		var userpassword = document.getElementById("pw");
		reg.onclick = function(){
			
			if(username.value == "" || userpassword.value == "" || repw.value == "" || userpassword.value.length<6 || userpassword.value.length>12 || repw.value != userpassword.value || phone.value == "" || email.value == "" || !/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email.value)){
				return false;
			}else{
				return true;
			}
		}
		</script>
</body>
</html>