<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정창</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">

#title{
width: 795px;
}


#content{
    height: 351px;
    width: 795px;
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
	<form action="modifyBoard" method="POST" id="formid" enctype="multipart/form-data">
			
			<input type="hidden" name="bno" value="${boardData.bno}"> 
			
			<label>제목</label><br>
			<input type="text" name="title" id="title" value="${boardData.title}" required><br>
			<textarea name="content" id="content" >${boardData.content}</textarea>
<%-- 			<c:if test="${boardData.files ne null}">
				    <p id ="imgtag"><img id="popup_img" src = "displayOneFile?fileName=${boardData.fileOne}" width="175" height="200"/></p>
			</c:if> --%>
<%-- 			<c:if test="${boardData.files eq null}">
			
				    <p id ="imgtag"><input type='file' name = 'file'></p>
			</c:if> --%>
			<input type="submit">
	
	</form>
	
</body>

<script type="text/javascript">
$(document).ready(function(){
/* 	$("#popup_img").on("click",function(){
    	alert("이미지를 바꿉니다")	
    	$("#popup_img").remove()
    	var str = "<input type='file' name = 'file'>"
    		 $('#imgtag').after(str);
	}); */
});
	

</script>


</html>