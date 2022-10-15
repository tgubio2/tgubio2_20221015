<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="texta/html; charset=UTF-8">
<title>board</title>
<script src="https://cdn.ckeditor.com/ckeditor5/12.2.0/classic/ckeditor.js"></script>
<script>
	var g_count =1;
	$(document).ready(function(){
		var mode = '<c:out value="${mode}"/>';
		if ( mode == 'edit'){
			//입력 폼 셋팅
			$("#name").prop('readonly', true);
			$("input:hidden[name='seq']").val(<c:out value="${boardContent.seq}"/>);
			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
			$("#name").val('<c:out value="${boardContent.name}"/>');
			$("#title").val('<c:out value="${boardContent.title}"/>');
			$("#content").val('<c:out value="${boardContent.content}"/>');
		}

		$(document).on('click', '#btnSave', function(e){
			e.preventDefault();
			$("#form").submit();
		});

		$(document).on('click', '#btnList', function(e){
			e.preventDefault();
			location.href="${pageContext.request.contextPath}/board/getBoardList";
		});

		$("#add").on("click",function(e){
            e.preventDefault();
            fn_fileAdd();
    
		})
	});

	function fn_fileDelete(obj){
		obj.parent().remove();
	}

	function fn_fileAdd() {
		var str = "<p><input type='file' name='file_"+(g_count++)+"'/><a href='#this' name='delete' class='btn'>삭제하기</a></p> ";
		$("#fileDiv").append(str);
		$("a[name='delete']").on("click",function(e){
			e.preventDefault();
			fn_fileDelete($(this));
		})
	}
</script>
</head>

<body>
	<article>
		<div class="container" role="main">
			<h2>board Form</h2>
			<!--<form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">-->
			<!--
			파일첨부를 위해 enctype="multipart/form-data" 추가
			단일 : type=file , 다중 : multiple="multiple"
			 -->
			<form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post" action="${pageContext.request.contextPath}/board/saveBoard" enctype="multipart/form-data">
			<form:hidden path="seq" />
			<input type="hidden" name="mode" />
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<!-- <input type="text" class="form-control" name="reg_id" id="name" placeholder="이름을 입력해 주세요">-->
					<form:input path="name" id="name" class="form-control" placeholder="이름을 입력해 주세요"/>
				</div>
				<div class="mb-3">
					<label for="title">제목</label>
					<!-- <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">-->
					<form:input path="title" id="title" class="form-control" placeholder="제목을 입력해 주세요"/>
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<!-- <textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" ></textarea>-->
					<form:textarea path="content" id="content" class="form-control" rows="5" placeholder="내용을 입력해 주세요"/>
				</div>
				<div class="mb-3" id="fileDiv">
					<input multiple="multiple" type="file" name="file_0">
					<a href="#this" id="add" class="btn">파일 추가하기</a>
				</div>
			<!--</form>-->
			</form:form>
			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
	</article>

<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>

</body>
</html>