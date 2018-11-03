<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/addTicket" method="post">
		tid:<input type="text" name="tid"> <br>departureAdd:<input
			type="text" name="departureAdd"> <br>destinationAdd:<input
			type="text" name="destinationAdd"> <br>departureTime:<input
			type="text" name="departureTime"> <br>arrivalTime:<input
			type="text" name="arrivalTime"> <br>price:<input
			type="text" name="price"> <br>unameCode:<input
			type="text" name="unameCode"> <input type="submit">

	</form>
</body>
</html>