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
	
	<title>장르 수정 페이지</title>

</head>
<body>
<div class="container">

<form action="genreUpdateAction" method="post">

	<label> 장르 수정 페이지 </label>
	
	<div class="form-group row">
		<label for="genreId" class="col-2 col-form-label">장르 아이디</label>
		<input type="text" id="genreId" name="genreId">
		<p class="navbar-text">${genreVO.genreId}</p>
	</div>
	
	<div class="form-group row">
		<label for="genreName" class="col-2 col-form-label"> 장르 이름 </label>
		<input type="text" id="genreName" name="genreName" value="${genreVO.genreName}"/>
	</div>
	
	<div class="form-group row">
		<label for="genreName" class="col-2 col-form-label"> 장르 소개 </label>
		<input type="text" id="genreUrl" name="genreUrl" value="${genreVO.genreUrl}" />
	</div>
	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>

</body>
</html>