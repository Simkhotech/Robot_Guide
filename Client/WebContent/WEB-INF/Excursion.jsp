<%@page import="by.bstu.robotics.excursions.Excursion"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="./bootstrap/css/style.css" />
		
<script type="text/javascript">
	function reloadEx() {
		setTimeout(
				'document.getElementById("dt").contentWindow.location.reload()',
				1000);
	}
</script>

<title>Robot-Guide Home</title>
</head>
<body>
	<div class="body">
		<div class="main">
			<jsp:include page="header.jsp"></jsp:include>

			<h3 align="center"><%=request.getAttribute("Name")%></h3>

			<br />

			<audio controls>
				<source src="/Guide/audio/file.mp3" type="audio/mpeg" preload="auto" autoplay="autoplay"> Тег audio не поддерживается вашим браузером.
			</audio>

			<br />

			<blockquote>
				<p><%=request.getAttribute("Description")%></p>
			</blockquote>


			<div style="clear: both;"></div>
		</div>
	</div>


</body>
</html>