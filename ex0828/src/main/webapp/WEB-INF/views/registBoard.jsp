<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성창</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">

#title{
width: 795px;
}


#content{
    height: 351px;
    width: 795px;
}


.dragAndDrop{
	margin: 20px;
 	width:900px;
	height:400px; 
	border : 1px solid;
}


#files{
 	 display: none;  
}


.selProductFile{
	margin:15px;
	width:300px;
	height:350px;
	border : 1px solid;
}

</style>

</head>
<body>
<!-- private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcount; -->
	<form action="createBoard" method="POST" id="formid" enctype="multipart/form-data" >
			<c:if test="${bno ne -1 }">
			
			<input type="hidden" name="bno" id="bno" value=${bno} >
			</c:if>
			
			<c:if test="${level eq 0}">
			<input type="radio" name="tbl_level" id="tbl_level" value=1>공지사항
			<input type="radio" name="tbl_level" id="tbl_level" >일반글<br><br>
			</c:if>
			
			<label>제목</label><br>
			<input type="text" name="title" id="title" placeholder="글 제목을 입력하세요" required><br>
			<textarea name="content" id="content" ></textarea><br>
			<!-- " -->
			<a href="javascript:" onclick="fileUploadAction();" class="my_button">파일업로드</a>
			<input type="file" id="files" name = "file" multiple> 
			<!-- file drag and Drop -->
			 <div id ="fileUpload" class = "dragAndDrop"><img id="img" scr="#"/></div>
			
			<c:if test="${id eq null}">
			<label>암호를 입력하세요</label><br>
			<input type="text" name="boardpw" placeholder="암호를 입력하세요" required>
			<input type="hidden" name="writer" value="비회원"><br>
			</c:if>
			<c:if test="${id ne null}">
			<input type="hidden" name="id" value=${id}> 
			<input type="hidden" name="writer" value=${name}><br>
			</c:if>
			
			

			<input type="submit">
			
	</form>
	

	
	
	<script type="text/javascript">
	var sel_files = [];
	$(document).ready(function() {
		
/* 		$(".dragAndDrop").on("dragenter dragover", function(event){
			event.preventDefault();	
		 });
		
		$(".dragAndDrop").on("drop", function(event){
			event.preventDefault();	
			
			alert("화인")
		});
		 */
		 
/*  		$(".dragAndDrop").on("click", function(event){
 			event.preventDefault();	
 			$('.files').click();
			
		}); */
		
		 //멀티이미지 업로드
		$("#files").on("change",handleImgFileSelect); 
 	
 	
 	
	});
	
/*     function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#files").change(function() {
        readURL(this);
    }); */
    
    
    
    //멀티이미지 업로드
		
 		function fileUploadAction(){
			console.log("fileUploadAction");
			$("#files").trigger('click');
			
		}
		
		function handleImgFileSelect(e){
			
			//이미지정보 초기화
			sel_files = [];
			$(".dragAndDrop").empty();
			
			var files = e.target.files;
			var filesArr = Array.prototype.slice.call(files);
			
			var index= 0;
			
			filesArr.forEach(function(f){
				if(!f.type.match("image.*")){
					alert("확장자는 이미지 확장자만 가능합니다.");
					return;
				}
				
				sel_files.push(f);
				
				var reader = new FileReader();
				
				reader.onload = function(e){
					var html = "<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("+index+")\" id=\"img_id_"+index+"\"><img src=\""+e.target.result+"\" data-file='"+f.name+"' class='selProductFile' title='Click to remove'></a>";
					$(".dragAndDrop").append(html);
					index++;
				}
				reader.readAsDataURL(f);
			});
		} 
			 
	
	</script>
</body>
</html>