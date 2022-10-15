<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./board/getBoardList.do">게시판 관리</a>
<p>
<a href="./menu/getMenu">메뉴 관리</a>
<p>
<a href="./user/getUserList">사용자 관리</a>
<p>
<a href="./login/login">로그인</a>

<p/><p/><p/><p/>
<table border="1">
<tr><td>Tomcat</td><td>8.0</td></tr>
<tr><td>MySQL</td><td>5.6.26</td></tr>
<tr><td>java-version</td><td>1.8</td></tr>
<tr><td>org.springframework-version</td><td>5.1.4.RELEASE</td></tr>
<tr><td>org.aspectj-version</td><td>1.9.2</td>
<tr><td>이클립스</td><td>Version: Neon.3 Release (4.6.3)</td></tr>
</table>

</body>
</html>
