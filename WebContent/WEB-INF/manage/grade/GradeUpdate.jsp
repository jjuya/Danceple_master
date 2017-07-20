<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">

	<!-- Bootstrap -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> 
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<title>등급 수정 페이지</title>

</head>
<body>
<div class="container">

<form action="gradeUpdateAction" method="post">

	<label> 등급 수정 페이지 </label>
	
	<div class="form-group row">
		<label for="gradeId" class="col-2 col-form-label">등급 아이디</label>
		<input type="text" id="gradeId" name="gradeId">
		<p class="navbar-text">${gradeVO.gradeId}</p>
	</div>
	
	<div class="form-group row">
		<label for="gradeName" class="col-2 col-form-label"> 등급 이름 </label>
		<input type="text" id="gradeName" name="gradeName" value="${gradeVO.gradeName}"/>
	</div>
	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>

</body>
</html>