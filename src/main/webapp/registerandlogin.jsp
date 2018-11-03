<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Ban辣酱</title>
<link rel="stylesheet" type="text/css" href="res/css/common.css">
	<link rel="stylesheet" type="text/css" href="res/css/public_header.css">
<script src="res/js/jquery-2.2.4.min.js"></script>
		<script>
			$(document).ready(function() {
				
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered").click(function() {
					$("#landing").removeClass("border-btn");
					$("#landing-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$(this).addClass("border-btn");
					
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
				})
			});
		</script>
		<style>
			* {
				margin: 0;
				padding: 0;
				font-family: "微软雅黑";
			}
			
			body {
				background: #F7F7F7;
				/* background-image: url("img/backgroundpicture1.jpg");
				background-size:100%; */
			}
			
			.form {
				position: absolute;
				top: 50%;
				left: 50%;
				margin-left: -185px;
				margin-top: -210px;
				height: 450px;
				width: 340px;
				font-size: 18px;
				-webkit-box-shadow: 0px 0px 10px #A6A6A6;
				background: #fff;
			}
			
			.border-btn {
				border-bottom: 1px solid #ccc;
			}
			
			#landing,
			#registered {
				float: left;
				text-align: center;
				width: 170px;
				padding: 15px 0;
				color: #545454;
			}
			
			#landing-content {
				clear: both;
			}
			
			.inp {
				height: 30px;
				margin: 0 auto;
				margin-bottom: 30px;
				width: 200px;
			}
			
			.inp>input {
				text-align: center;
				height: 30px;
				width: 200px;
				margin: 0 auto;
				transition: all 0.3s ease-in-out;
			}
			
			.login {
				border: 1px solid #A6A6A6;
				color: #a6a6a6;
				height: 30px;
				width: 202px;
				text-align: center;
				font-size: 13.333333px;
				margin-left: 70px;
				line-height: 30px;
				
				transition: all 0.3s ease-in-out;
			}
			
			.login:hover {
				background: #A6A6A6;
				color: #fff;
			}
			
			#bottom {
				margin-top: 30px;
				font-size: 13.333333px;
				color: #a6a6a6;
			}
			
			#registeredtxt {
				float: left;
				margin-left: 80px;
			}
			
			#forgotpassword {
				float: right;
				margin-right: 80px;
			}
			
			#photo {
				border-radius: 80px;
				border: 1px solid #ccc;
				height: 80px;
				width: 80px;
				margin: 0 auto;
				overflow: hidden;
				clear: both;
				margin-top: 30px;
				margin-bottom: 30px;
			}
			
			#photo>img:hover {
				-webkit-transform: rotateZ(360deg);
				-moz-transform: rotateZ(360deg);
				-o-transform: rotateZ(360deg);
				-ms-transform: rotateZ(360deg);
				transform: rotateZ(360deg);
			}
			
			#photo>img {
				height: 80px;
				width: 80px;
				-webkit-background-size: 220px 220px;
				border-radius: 60px;
				-webkit-transition: -webkit-transform 1s linear;
				-moz-transition: -moz-transform 1s linear;
				-o-transition: -o-transform 1s linear;
				-ms-transition: -ms-transform 1s linear;
			}
			
			
			#registered-content {
				margin-top: 40px;
				display: none;
			}
			
			.fix {
				clear: both;
			}
			.form{
				display: none;
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
	
		<div class="form">
		<form action="/usersLogin" method="post">
			<div id="landing">登录</div>
			<div id="registered">注册</div>
			<div class="fix"></div>
			<div id="landing-content">
				<div id="photo"><img src="res/img/header-logo.png" /></div>
				<div class="inp"><input type="text" placeholder="用户名" name="userName" id="userName"/></div>
				<div class="inp"><input type="password" placeholder="密码" name="userPassword" id="userPassword"/></div>
				<button class="login" type="submit" id="btn">登录</button>
				
			</div>
		</form>
			<form action="/addUser" method="post">
			<div id="registered-content">
				<div class="inp"><input type="text" placeholder="请输入用户名" name="userName" id="username" onblur="uname(this)"/><p class="hide" id="p1">用户名不能为空！</p></div>
				<div class="inp"><input type="password" placeholder="请输入6-12位字符密码" name="userPassword" id="pw" onblur="paw(this)"/><p class="hide" id="p2">请输入6-12位字符密码！</p></div>
				<div class="inp"><input type="password" placeholder="请再次输入密码" name="repw" id="repw" onblur="repaw(this)"/><p class="hide" id="p3">两次密码输入不一致！</p></div>
				<div class="inp"><input type="text" placeholder="手机号" name="phone" id="phone" onblur="p(this)"/><p class="hide" id="p4">手机号不能为空！</p></div>
				<div class="inp"><input type="text" placeholder="电子邮箱"  name="email" id="email" onblur="e(this)"/><p class="hide" id="p6">邮箱为空或格式不正确！</p></div>
				<button class="login" type="submit" id="reg">立即注册</button>
			</div>
			</form>
		</div>
		<script>
		var btn = document.getElementById("btn");
		var reg = document.getElementById("reg");
		var userName = document.getElementById("userName");
		var userPassword = document.getElementById("userPassword");
		btn.onclick = function (){
			
			if(userName.value===""){
				alert("请输入用户名！")
				return false;
			}else{
			if(userPassword.value===""){
				alert("请输入密码！");
				return false;
			}else{
				return true;
			}
			}
		}
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