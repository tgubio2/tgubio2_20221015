<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
$(document).ready(function() {
});

function checkFileType(filePath){
var fileFormat = filePath.split(".");
if(fileFormat.indexOf("xls") > -1){
return true;
}else if(fileFormat.indexOf("xlsx") > -1){
return true;
}else{
return false;
}
}

function check(){
var file = $("#excel").val();
if(file == "" || file == null){
alert("파일을 선택");
return false;
}else if(!checkFileType(file)){
alert("엑셀 파일만 업로드");
return false;
}
var fileFormat = file.split(".");
var fileType = fileFormat[1];
if(confirm("업로드 하시겠습니까?")){
$("#excelUpForm").attr("action","/accountsMngs/compExcelUpload");
var options = {
success:function(data){
alert("업로드 완료");
$("#ajax-content").html(data);
},
type: "POST",
data : {"excelType" : fileType}
};
$("form").ajaxSubmit(options);
}
}


</script>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
<!-- BEGIN CONTENT BODY -->
<div class="page-content">
<div class="page-head">
<!-- BEGIN PAGE TITLE -->
<div class="page-title">
<h1>
<span id="title"></span><small id="titleSmall"></small>
</h1>
</div>
<!-- END PAGE TITLE -->
</div>
<div class="col-lg-10 well">
<div class="row">
<form id="excelUpForm" method="post" action="" role="form" enctype="multipart/form-data">
<div class="col-sm-12">
<div class="row" id="regGoodsImgArea">
<div class="col-sm-4">
<label>엑셀업로드 (업로드하고 디비에 INSERT)</label>
<input id="excel" name="excel" class="file" type="file"
multiple data-show-upload="false"
data-show-caption="true">
</input>
</div>
</div>
</div>
<button type="button" id="excelUp" onclick="check()">등록</button>
</form>
</div>
</div>
<!-- END container -->
</div>
<!-- END CONTENT BODY -->
</div>
<!-- END CONTENT -->


    <!-- excel file 읽어오기 -->
    <form id="massiveForm" name="massiveForm" enctype="multipart/form-data" method="post" action="<c:url value="/board/massiveWrite"/>" >
        <input type="file" name="excelFile"/>
        <input type="submit" value="업로드"/> 
    </form>



</body>
</html>