<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="res/css/adminStyle.css" rel="stylesheet" type="text/css" />
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
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>添加产品</em></span>
    <span class="modular fr"><a href="AllGoodsList" class="pt-link-btn">产品列表</a></span>
  </div>
  <form action="/formUpload_1" id="ajform" method="post">
  <table class="list-style">
  <tr>
    <td style="text-align:right;width:15%;">商品编号：</td>
    <td><input type="text" class="textBox length-long" name="goodsNo"/></td>
   </tr>
   <tr>
    <td style="text-align:right;width:15%;">商品名称：</td>
    <td><input type="text" class="textBox length-long" name="goodsName"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">商品分类：</td>
    <td>
     <select class="textBox" name="gclass">
      <option>香辣</option>
      <option>麻辣</option>
      <option>甜辣</option>
      <option>酸辣</option>
      <option>其他</option>
      
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">定价：</td>
    <td>
     <input type="text" class="textBox length-short" name="goodsPrice"/>
     <span>元</span>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">库存：</td>
    <td>
     <input type="text" class="textBox length-short" name="goodsCount"/>
     <span>件</span>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品展示图：</td>
    <td>
     <input type="file" name="pic" onchange="uploadPic('pic','ajform')"> 
     <input type="hidden" name="goodsimg" value="" id="picInput">
     <img alt="" src="" id="pic" width=50 height=50>
     
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品长图：</td>
    <td>
     <input type="file" name="pictext" onchange="uploadPic('pic1','ajform')">
     <input type="hidden" name="pictext" value="" id="pic1Input">
     <img alt="" src="" id="pic1" width=50 height=50> 
     
     
    </td>
   </tr>
  
   <tr>
    <td style="text-align:right;">商品主图1：</td>
    <td>
     <input type="file" name="gimg1" onchange="uploadPic('pic2','ajform')">
     <input type="hidden" name="gimg1" value="" id="pic2Input">
     <img alt="" src="" id="pic2" width=50 height=50> 
    
    
     
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品主图2：</td>
    <td>
     <input type="file" name="gimg2" onchange="uploadPic('pic3','ajform')">
     <input type="hidden" name="gimg2" value="" id="pic3Input">
     <img alt="" src="" id="pic3" width=50 height=50> 
    
    
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品主图3：</td>
    <td>
     <input type="file" name="gimg3" onchange="uploadPic('pic4','ajform')">
     <input type="hidden" name="gimg3" value="" id="pic4Input">
     <img alt="" src="" id="pic4" width=50 height=50> 
    
     
    </td>
   </tr>
  
   <tr>
    <td style="text-align:right;">产品详情：</td>
    <td><textarea class="textarea" name="goodsIntr"></textarea></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" value="发布新商品" class="tdBtn"/></td>
   </tr>
  </table>
  </form>
 <!-- <script type="text/javascript">
 var a= document.getElementById("check");
 var picture1 = document.getElementById("picture1").value;
 a.onclick = function(){
	 if(picture1!=""){
		 alert("1");
	 }else{
		 alert("2");
	 }
 }
 </script> -->
 
 </div>
</body>
</html>