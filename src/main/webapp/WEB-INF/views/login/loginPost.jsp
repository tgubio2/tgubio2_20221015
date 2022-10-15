<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>로그인 페이지</title>
</head>
<body>

<script>
alert("아이디와 비밀번호를 확인해주세요");
self.location = "${pageContext.request.contextPath}/login/login";
</script>

</body>
</html>