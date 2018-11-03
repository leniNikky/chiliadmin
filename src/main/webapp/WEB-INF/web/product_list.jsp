<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品列表</title>
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
	}else{
		alert(admin.value);
	}
</script> --%>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>产品列表</em></span>
    <span class="modular fr"><a href="add_goods.jsp" class="pt-link-btn">+添加商品</a></span>
  </div>
  <div class="operate">
   <form action="findGoodsByName" method="post">
    <input type="text" class="textBox length-long" placeholder="输入产品名称..." name="goodsName"/>
    <input type="submit" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>编号</th>
    <th>产品</th>
    <th>名称</th>
    <th>商品介绍</th>
    <th>价格</th>
    <th>库存</th>
    <th>分类</th>
    <th>上新时间</th>
    <th>操作</th>
   </tr>
   <c:forEach items="${goods}" var="good">  
   <tr>
    <td>
     <span>
     
     <i>${good.goodsNo }</i>
     </span>
    </td>
    <td class="center pic-area"><img src="${good.goodsimg }" class="thumbnail"/></td>
    <td class="td-name">
      <span class="ellipsis td-name block">${good.goodsName }</span>
    </td>
    <td class="td-name">
      <span class="ellipsis td-name block">${good.goodsIntr }</span>
    </td>
    <td class="center">
     <span>
      <i>￥</i>
      <em>${good.goodsPrice }</em>
     </span>
    </td>
    <td class="center">
     <span>
      <em>${good.goodsCount }</em>
      <i>件</i>
     </span>
    </td>
    <td class="center">
     <span>
      <em>${good.gclass }</em>
      
     </span>
    </td>
     <td class="center">
     <span>
      <em>${good.time }</em>
      
     </span>
    </td>
    <td class="center">
     <a href="goodsDetail?goodsID=${good.goodsID }" title="编辑" value=""><img src="res/images/icon_edit.gif"/></a>
     <a  href="DeleteGoods?goodsID=${good.goodsID }" title="删除"><img src="res/images/icon_drop.gif"/></a>
    </td>
   </tr>
</c:forEach> 
   
  </table>
  <!-- BatchOperation -->
  <!-- <div style="overflow:hidden;">
      Operation
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="批量删除" class="btnStyle"/>
	  </div>
	  turn page
	  <div class="turnPage center fr">
	   <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>
	  </div>
  </div> -->
 </div>
</body>

</html>