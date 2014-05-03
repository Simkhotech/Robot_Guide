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
			<div class="header">
				<div class="logo">
					<img src="./bootstrap/img/logo.png" alt="Logo" height="150px">
				</div>

				<div id="sensors" class="statement">
					<iframe id="dt" src="WEB-INF/sensors.jsp" onload="javascript:show();"></iframe>
					<!--					<font> Batary: 56%<br /> <br /> Sensors<br /> Sensor 1:
						45cm | Sensor 5: 37cm<br /> Sensor 2: 09cm | Sensor 6: 64cm<br />
						Sensor 3: 65cm | Sensor 7: 43cm<br /> Sensor 4: 36cm | Sensor 8:
						25cm<br />
						<h6></h6>
					</font>-->
				</div>
			</div>

			<a href="javascript:show()">Основные настройки</a>

			<div class="content">
				<form name="" method="post" action="/Guide/App">
					<input class="excursion excursion-1" type="submit" 
						value="Ex1" name="name" title="Экскурсия 1"> <br /> 
					<input class="excursion excursion-2" type="image" 
						value="Ex2" name="name" title="Экскурсия 2"> <br />
					<input class="excursion excursion-3" type="image" 
						value="Ex3" name="name" title="Экскурсия 3">
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