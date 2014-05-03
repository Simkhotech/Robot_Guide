<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>HR</title>
		<link href = "./bootstrap/css/font-awesome.css" rel = "stylesheet">
		<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="./bootstrap/css/sb-admin.css">	
		<link rel="stylesheet" href="./bootstrap/css/bootstrap-switch.css" />
		<link rel="stylesheet" href="./bootstrap/css/style.css" />
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<script>
	function show() {
		setTimeout('document.getElementById("dt").contentWindow.location.reload()', 1000);
	}
	function second() {
		window.location = 'Excursion-2.jsp';
	}
</script>

<title>Robot-Guide Home</title>
</head>
<body>
	<div class="body">
		<div class="main">
			<jsp:include page="header.jsp"></jsp:include>
			<div class="content" style="text-align: center;">
				<form name="" method="post" action="/Guide/App">
					<button class="btn btn-large btn-info" type="submit" style="width: 80%; height: 100px;"
						value="Start" name="name" title="Экскурсия 1">Экскурсия 1</button><br /> 
				</form>
			</div>

			<div style="clear: both;"></div>

			<div class="main-bottom">
				<h1>
					Добрый день!<br />Выберите интересующую вас экскурсию...
				</h1>
			</div>
		</div>
	</div>

	<script src="./bootstrap/js/jquery-1.10.2.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
	<script src="./bootstrap/js/jquery.metisMenu.js"></script>
	<script src="./bootstrap/js/sb-admin.js"></script>
	<script src="./bootstrap/js/bootstrap-switch.js"></script>
	<script src="./bootstrap/js/prism.js"></script>
	<script src="./bootstrap/js/index.js"></script>
	<script src="./bootstrap/js/sender.js"></script>

</body>
</html>