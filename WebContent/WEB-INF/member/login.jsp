<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type=" text/javascript" src="script/member.js"></script>
<link rel="Shortcut icon" href="/favicon.ico" />

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js">
    </script>
</head>
<body>
	<h2>로그인</h2>
	<form action="testLogin.jsp" method="post" name="frm">
		<table>
			<tr>
				<label for="userid"> 아이디: </label>
				<input type="text" name="user_id" id="user_id" value="${userid}">
				<!-- class="form-control" -->
				</td>
				<br>
			</tr>
			<tr>
				<label for="uesrpwd">암 &nbsp; 호: </label>
				<input type="password" name="user_pw" id="user_pw">
				<!-- class="form-control" -->
				<br>
			</tr>
			<td><input type="checkbox" name="save_id" />아이디저장</td>
			<tr>
				<td colspan="2" algin="center"><input type="submit" value="로그인"
					onclick="return loginCheck()">&nbsp;&nbsp;<br>
					<hr> 아이디 비밀번호를 잃어버리셨습니까?</label><input type="button"
					value="아이디/비밀번호 찾기" onclick=""><br> 아직 회원이 아니시라면
					가입하세요. &nbsp;&nbsp;<input type="button" value="회원가입"
					onclick="location.href='memberInsert'"><br></td>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>