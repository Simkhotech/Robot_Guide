<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>HR</title>
		<link href = "./bootstrap/css/bootstrap-auth.css" rel = "stylesheet">
		<link rel="stylesheet" href="./bootstrap/css/main.css">
		<link rel="stylesheet" href="./bootstrap/css/magic.css">	
		<script src = "./bootstrap/js/jquery-2.0.3.js" > </script>
		<script src = "./bootstrap/js/bootstrap.js" > </script>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"">
</head>
<body class="login">
	<div class="container">
		<div class="text-center">
			<img src="./bootstrap/img/logo-ericpol.png" alt="Logo">
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form action="#" class="form-signin">
					<div class="alert alert-block alert-error" onclick="$('#auth-error').hide()" id="auth-error"
						style="background-color: #F5A9A9; display: none;">
						<strong>Error: </strong>Incorrect login or password.
					</div>
					<div class="alert alert-block alert-error" onclick="$('#empty-error').hide()" id="empty-error"
						style="background-color: #F5A9A9; display: none;">
						<strong>Error: </strong>Empty login or password.
					</div>
					<p class="text-muted text-center">Enter your username and password</p>
					<input type="text" placeholder="Username" class="form-control" id="name">
					<input type="password" placeholder="Password" class="form-control" id="pass">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="SubmitForm()">Sign in</button>
					<a href="/Client/RegistrationOfManager">Registration</a>
				</form>
			</div>
		</div>
	</div>
	<button type="button" class="btn btn-primary" data-loading-text="Loading..."  style="display: none;">Loading state</button>
	
	<script>
	$('button[data-loading-text]').click(function () {
		$(this).button('loading');
	});
	
	jQuery(document).ready(
		function()
		{
	});
	
	function SubmitForm()
	{
		var login = $('#name').val();
		var password = $('#pass').val();
		
		if(login == ""  || password == ""){
			$('#empty-error').show();
		} else {
			$('#empty-error').hide();
			$.post("/Client/App",
				{
					login: login ,
					pass: password
				},
				function(response){
					if(response == "ok"){
						window.location.href="/Client/App";
					}else{
						$('#auth-error').show();
					}
				}
			);
		}
	}
	</script>
</body>
</html>