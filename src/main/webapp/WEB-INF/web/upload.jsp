<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/res/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/res/js/jquery.form.js"></script>
<script type="text/javascript">
	function uploadPic(id, formid) {
		//上传图片 异步的  	Jquery.form.js
		var options = {
			url : "/ajaxUpload",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.max != null) {
					alert(data.max);
				} else {
					$("#" + id).attr('src', data.url);
					$("#" + id + "Input").attr('value', data.url);
				}
			}
		}
		$("#" + formid).ajaxSubmit(options);
	}
</script>
</head>
<body>
	<form action="/formUpload" method="post" enctype="multipart/form-data">
		图片:<input type="file" name="pic"> <br> <input
			type="submit">

	</form>
	<form action="/formUpload_1" id="ajform" method="post" enctype="multipart/form-data">
		Ajax图片:<input type="file" name="pic" onchange="uploadPic('pic','ajform')"> <br>
			Ajax1图片:<input type="file" name="pic" onchange="uploadPic('pic1','ajform')"> <br>
			 <input type="hidden" name="pic1Url" value="" id="pic1Input">
			 <input type="hidden" name="picUrl" value="" id="picInput">
			 <input type="text" name="name" > 
			 <input type="submit"> 
			 <img alt="" src="" id="pic">
			 <img alt="" src="" id="pic1"> 
	</form>

</body>
</html>