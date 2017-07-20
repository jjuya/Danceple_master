<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<!-- Bootstrap -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> 
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<title>강사 추가 페이지</title>

</head>
<body>

<div class="container"> 
<form action="teacherDeleteAction" method="post">

	<label> 강사 삭제 페이지 </label>
	
	<div class="form-group row">
		<label for="teacherId" class="col-2 col-form-label"> 강사 아이디 </label>
		<input type="text" id="teacherId" name="teacherId"  value="${teacherVO.teacherId}"/>
	</div>
	
	<!--
	<div class="form-group row">
		<label for="teamName" class="col-2 col-form-label"> 강사 이름 </label>
		<input type="text" id="teacherName" name="teacherName" value="${teacherVO.teacherName}" />
	</div>
	-->	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

</body>
</html>