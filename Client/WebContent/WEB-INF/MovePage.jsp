<%@page import="by.bstu.robotics.excursions.Exhibit"%>
<%@page import="by.bstu.robotics.excursions.Excursion"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MovePage</title>
</head>
<body>
	<h1 align="center">Движение к следующему экспонату!</h1>

	<script type="text/javascript">
		javascript: setTimeout("window.location.assign('/Guide/MoveServlet')",
				1000);
	</script>
</body>
</html>