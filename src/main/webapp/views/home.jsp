<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WELCOME TO SPRING TRAINING</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="navbar navbar-inverse"></div>

	<h4>Welcome to spring training   JSP Located at ==> /views/home.jsp</h4>


	<ul>
		<li><b> CORS Demonstration : From static resource </b>
			/static/corsTest.html</li>
		
		<li> Session Scope Bean : /bank/account</li>
		
		<li> <b>CORS API CALL </b>  /cors/training</li>
			
		<li>RESTful WEB SERVICES SECURITY
			<ul>
				<li><b>JSON Response : </b> /secure/trainings</li>
				<li><b>Path Parameter Test : </b>
					/secure/training/{name}/{trainer} <b>==></b>
					/secure/training/Java/Karthi</li>
			</ul>
		</li>
		

	</ul>


</body>
</html>