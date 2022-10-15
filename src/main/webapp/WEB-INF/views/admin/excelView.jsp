<script src="http://malsup.github.com/jquery.form.js"></script>

<!-- form 전송이므로 컨트롤러단에서의 VO객체와 클라이언트의name이 mapping되서 data를 전송한다. -->
<form action="원하는 경로" enctype="multipart/form-data" method="POST">
      <input name="title" value="테스트1"/>
      <input name="contents" value="테스트 자료입니다."/>
      <input type="file" name="file"/>
      <input type="submit" value="upload">
</form>
 
<!-- progress , bar, percent를 표시할 div 생성한다. -->
<div class="progress">
    <div class="bar"></div>
    <div class="percent">0%</div>
</div>
<div id="status"></div>

<style>
  .progress { position:relative; width:400px; border: 1px solid #ddd; padding: 1px; border-radius: 3px; }
  .bar { background-color: #B4F5B4; width:0%; height:20px; border-radius: 3px; }
  .percent { position:absolute; display:inline-block; top:3px; left:48%; }
</style>
<<script type="text/javascript">
$(function() {
    var bar = $('.bar');
    var percent = $('.percent');
    var status = $('#status');
    $('form').ajaxForm({
        beforeSend: function() {
            status.empty();
            var percentVal = '0%';
            bar.width(percentVal);
            percent.html(percentVal);
        },
        uploadProgress: function(event, position, total, percentComplete) {
            var percentVal = percentComplete + '%';
            bar.width(percentVal);
            percent.html(percentVal);
        },
        complete: function(xhr) {
           alert('성공');
        },
       error:function(e){
          alert('실패');
       }
         
    });
}); 
</script>