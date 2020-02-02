<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 창</title>
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
	width:180px;
	height:230px;
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
	<form action="./uploadTest" method="POST" id="formid" enctype="multipart/form-data" >
			<c:if test="${level eq 0}">
			<input type="radio" name="tbl_level" id="tbl_level" value=1>공지사항
			<input type="radio" name="tbl_level" id="tbl_level" >일반글<br><br>
			</c:if>
			
			<label>제목</label><br>
			<input type="text" name="title" id="title" placeholder="글 제목을 입력하세요" required><br>
			<textarea name="content" id="content" ></textarea><br>
			
			<input type="file" name = "file"  multiple ="multiple"> <br><br>
	
			
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
	$(document).ready(function() {
		
/* 		$(".dragAndDrop").on("dragenter dragover", function(event){
			event.preventDefault();	
		 });
		
		$(".dragAndDrop").on("drop", function(event){
			event.preventDefault();	
			
			alert("화인")
		});
		 */
		 
/* 		$(".dragAndDrop").on("click", function(event){
			var str=""
			str += "<input type='file' name = 'file[]'  multiple>";
			
			alert("화인")
		});
			 */
	});
	</script>
</body>
</html>