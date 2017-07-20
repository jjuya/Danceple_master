<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<!-- Bootstrap -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> 
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<title>팀 추가 페이지</title>

</head>
<body>
<div class="container">

<form action="teamDeleteAction" method="post">

	<label> 팀 삭제 페이지 </label>
	
	<div class="form-group row">
		<label for="teamId" class="col-2 col-form-label">팀 아이디</label>
		<input type="text" id="teamId" name="teamId">
		<p class="navbar-text">${teamVO.teamId}</p>
	</div>
	
	<div class="form-group row">
		<label for="teamName" class="col-2 col-form-label"> 팀 이름 </label>
		<p class="navbar-text">${teamVO.teamName}</p>
	</div>
	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>

</body>
</html>