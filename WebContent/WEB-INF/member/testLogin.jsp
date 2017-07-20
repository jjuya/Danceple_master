<%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!// PHP의 isset과 같은 기능을 합니다. 문자열이 null이거나 빈 문자열이면 false를 반환합니다. // 
	boolean isset(String str) {
		if (str == null)
			return false;
		if (str.equals(""))
			return false;
		return true;
	}%>

<%
 	String user_id=request.getParameter("memberId");
	String user_pw=DigestUtils.sha512Hex(request.getParameter("memberPwd")); 
	String memberName=request.getParameter("memberName");

 	

	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs= null;
	
	StringBuffer sql = new StringBuffer();
	sql.append("SELECT user_name");
	sql.append(" FROM t_mem");
	sql.append(" WHERE user_id=?");
	sql.append(" AND user_pw=?");
	Cookie[] cookie=request.getCookies();
	
	boolean result = false;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","bigdata","bigdata");
		st=cn.prepareStatement(sql.toString());
		st.setString(1,user_id);
		st.setString(2,user_pw);
		rs= st.executeQuery();
		if(rs.next()){
			memberName=rs.getString("memberName");
		}
		
	/* 	if(save_id != null && save_id.equals("on")){
			 Cookie c1 = new Cookie("user_id", URLEncoder.encode(user_id));
			   c1.setMaxAge(60*60*24*30);
			   response.addCookie(c1); 
		}else {
			 Cookie c1 = new Cookie("user_id", null);
			   c1.setMaxAge(0);
			   response.addCookie(c1);
		}
		 */if (!isset(request.getParameter("user_id"))) {
				out.println("<p align=\"center\">ID가 입력되지 않았습니다.</p>");
				out.println("<p align=\"center\"><a href=\"login.jsp\">로그인하기</a></p>");
				return;
			}
			if (!isset(request.getParameter("user_pw"))) {
				out.println("<p align=\"center\">암호가 입력되지 않았습니다.</p>");
				out.println("<p align=\"center\"><a href=\"login.jsp\">로그인하기</a></p>");
				return;
			} // 미리 정의된 ID와 암호 //
		
			// ID 잘못 입력 시 //
			if (!request.getParameter("user_id").equals(user_id)) {
				out.println("<p align=\"center\">ID가 일치하지 않습니다.</p>");
				out.println("<p align=\"center\"><a href=\"login.jsp\">다시 로그인하기</a></p>");
				return;
			} // 암호 잘못 입력 시 // 
			else if(!request.getParameter("user_pw").equals(user_pw)) {
				out.println("<p align=\"center\">암호가 일치하지 않습니다.</p>");
				out.println("<p align=\"center\"><a href=\"login.jsp\">다시 로그인하기</a></p>");
				return;
			} 
			// 로그인 성공 // 
			if(user_id.equals(request.getParameter("user_id")) && user_pw.equals(request.getParameter("user_pw"))){
			response.sendRedirect("loginpage.jsp?name="+URLEncoder.encode(memberName,"UTF-8"));
			
				
				/* 세션에 로그인 ID와 암호를 기억시키고 세션 정보로서 사용 */ 
				session.setAttribute("user_id",request.getParameter("user_id"));
				session.setAttribute("user_pw", request.getParameter("user_pw"));
			}
		 
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null)try{rs.close();} catch(Exception e){}
		if (st != null)try{st.close();} catch(Exception e){}
		if (cn != null)try{cn.close();} catch(Exception e){}
	}
	
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
<link rel="Shortcut icon" href="/favicon.ico" />
</head>
<body>


</body>
</html>