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

			<div class="header">
				<div class="logo">
					<h1>BrSTU_Robotics logo!</h1>
				</div>

				<div class="some">English - Русский</div>

				<div class="statement">
					<font> Batary: 56%<br /> <br /> Sensors<br /> Sensor 1:
						45cm | Sensor 5: 37cm<br /> Sensor 2: 09cm | Sensor 6: 64cm<br />
						Sensor 3: 65cm | Sensor 7: 43cm<br /> Sensor 4: 36cm | Sensor 8:
						25cm<br />
					</font>
				</div>
			</div>

			<h3 align="center"><%=request.getAttribute("Name")%></h3>

			<br />

			<audio controls>
				<source src=/Guide/audio/music.mp3 type="audio/mpeg"> Тег audio не поддерживается вашим браузером.
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