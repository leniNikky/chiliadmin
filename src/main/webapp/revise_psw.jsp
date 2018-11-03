<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
<title>修改密码</title>
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
    <span class="modular fl"><i class="user"></i><em>修改密码</em></span>
  </div>
  <form action="EditPs" method="post">
  <input type="hidden" value="${user.userID }" name="userID">
  <table class="noborder">
   <tr>
    <td style="text-align:right;">旧密码：</td>
    <td><input type="password" class="textBox length-middle" name="oldps" id="oldpw" onblur="uname(this)"/><p class="hide" id="p1">请输入原密码！</p></td>
   </tr>
   <tr>
    <td style="text-align:right;">新密码：</td>
    <td><input type="password" class="textBox length-middle" name="newps" id="pw" onblur="paw(this)"/><p class="hide" id="p2">请输入6-12位字符密码！</p></td>
   </tr>
   <tr>
    <td style="text-align:right;">再次确认密码：</td>
    <td><input type="password" class="textBox length-middle" name="reps" id="repw" onblur="repaw(this)"/><p class="hide" id="p3">两次密码输入不一致！</p></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><button type="submit" class="tdBtn" id="reg"/>确认修改</button></td>
   </tr>
  </table>
  </form>
 </div>
 <script>
		
		var p1 = document.getElementById("p1");
		function uname(oldpw){
			if(oldpw.value == ""){
				p1.className = p1.className.replace("hide","show");
				oldpw.style.border="2px red solid";
				
			}else{
				p1.className = p1.className.replace("show","hide");
				oldpw.style.border="";
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
		
		
		
		var phone = document.getElementById("phone");
		var email = document.getElementById("email");
		var repw = document.getElementById("repw");
		var oldpw = document.getElementById("oldpw");
		var userpassword = document.getElementById("pw");
		reg.onclick = function(){
			
			if(oldpw.value == "" || userpassword.value == "" || repw.value == "" || userpassword.value.length<6 || userpassword.value.length>12 || repw.value != userpassword.value ){
				return false;
			}else{
				return true;
			}
		}
		</script>
</body>
</html>