<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${member == null}">

<!-- 로그인 시작 -->
<div class=login-box-body>
	<p class="login-box-msg">로그인 페이지</p>
	<form name="form" id="form" modelAttribute="userVO" action="${pageContext.request.contextPath}/login/loginPost" method="post">
	<div class="form-group has-feedback">
		<input type="text" name="uid" class="form-control" placeholder="아이디">
		<span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
	</div>
	<div class="form-group has-feedback">
		<input type=""password" name="pwd" class="form-control" placeholder="비밀번호">
		<span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
	</div>
	
	<div class="col-xs-4">
		<button type="submit" class="btn btn-primary btn-block btn-flat">
			<i class="fa fa-sign-in"></i>로그인
		</button>	
</div>

</c:if>

<c:if test="${msg == false}">
	<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주십시오.</p>
</c:if>

<c:if test="${member != null}">
<p>${member.uid} 님 환경합니다.</p>
</c:if>
