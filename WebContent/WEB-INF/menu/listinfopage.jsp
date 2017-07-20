<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function changepage(page){
    //alert(page);
    location.href="viewinfo?page="+page;
}
</script>
<link rel="shortcut icon" href="../favicon-32x32.png" />
</head>
<body>
<td width="75%" valign="center">
   <select id="teamlist" onchange="changepage(value)">
   <c:forEach var="team" items="${teamlist}" varStatus="status">
    <c:choose>
        <c:when test="${status.index == page}">
            <option value="${status.index}" selected="selected">${team.teamName }</option>
        </c:when>
        <c:otherwise>
            <option value="${status.index}">${team.teamName }</option>
        </c:otherwise>
        
        </c:choose>
   </c:forEach>
   </select>
   
   </td>
    <table>
        <caption>게시물 리스트</caption>
        <thead>
            <tr>
                <th scope="cols">이름</th>
                <th scope="cols">아이디</th>
                <th scope="cols">성별</th>
                <th scope="cols">등급</th>
                <th scope="cols">핸드폰</th>
                
            </tr>
        </thead>
        <c:forEach var="mem" items="${memlist}">
        <tr>
          <td>${mem.name}</td>
          <td>${mem.userID}</td>
          <td>${mem.gender}</td>
          <td>${mem.gradeId}</td>
          <td>${mem.phone}</td>
        </tr>
        </c:forEach>
    </table>
    <table>
       <tr><td>장르</td></tr>
       <c:forEach var="app" items="${applist }">
       <tr>
           <td>${app.teamId} / ${app.userId}/ ${app.genre1}/ ${app.genre2}/ ${app.genre3}</td>
       </tr>
       </c:forEach>
    </table>
</body>
</html>