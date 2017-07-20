<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "shortcut icon" href="../favicon.ico" />
</head>
<body>
<div class="authen">
	<form action="confirmAction" method="post" name="confirm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" /></td>
				<td>휴대폰 번호</td>
				<td><input type="text" /></td>
				<td>
				<input type="submit" value="확인" 
					   onclick="show()" />
				</td>
			</tr>
		</table>
	</form>
</div>
<hr>
<div class="applyform">
	<form action="insertAction" type="post" name="iapply">
		<table>
			<tr>
				<td>팀</td>
				<td><select name="team" id="team">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></td>
			</tr>
			<tr>
				<td>추가</td>
				<td><input type="text" /></td>
				<td>콤마(,)로 구분하여 작성하여 주시길 바랍니다.</td>
			</tr>
			<tr>
				<td>장르</td>
			</tr>
			<tr>
				<td>1지망</td>
				<td><select name="genere" id="genre">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></td>
			</tr>
			<tr>
				<td>2지망</td>
				<td><select name="genere" id="genre">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></td>
			</tr>
			<tr>
				<td>3지망</td>
				<td><select name="genere" id="genre">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></td>
			</tr>
		</table>
	</form>
</div>
<div>
<input type="submit" value="완료" />
</div>
</body>
</html>