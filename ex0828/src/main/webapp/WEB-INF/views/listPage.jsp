<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- list css -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

 <!-- page controll -->
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  -->

<style type="text/css">

</style>

</head>
<body>
<div id = "loginId" style="display: none;">${id}</div> 
<input type="button" id= "creatBut" value="글쓰기">

<input type="button" id= "login" value="로그인">


<div class="container">
	<div class="row">
<!--         <div class="col-md-3">
            <form action="#" method="get">
                <div class="input-group">
                    USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH
                    <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                    </span>
                </div>
            </form>
        </div> -->
		<div class="col-md-9">
    	 <table id="boardTable" class="table table-list-search">
                    <thead>
                        <tr>
                        	
                            <th>제목</th>
							<th>작성자</th>
							<th>읽힌 수</th>
							<th>작성일</th>
							<th>작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${fn:length(listBoard) eq 0}">
						<tr>
						<td>테이틀이 없습니다.</td>
						<td>테이틀이 없습니다.</td>
						<td>테이틀이 없습니다.</td>
						<td>테이틀이 없습니다.</td>
						</tr>
					
					</c:if>
					<c:if test="${fn:length(listBoard) ne 0}">
						<c:forEach items="${listBoard}" var="BoardDTO">
							<tr class="choice">
							
								<td style="display:none;" id ="bno">${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${BoardDTO.bno}</td>
<%-- 								<td style="display:none;" id ="bno">${BoardDTO.bno}</td> --%>
								
							
								<td>${BoardDTO.bno}</td>
								
								<td><c:if test="${BoardDTO.tbl_level eq 1}">
								<font style="color: red;">${BoardDTO.title}</font>
								</c:if>
								
								<c:if test="${BoardDTO.tbl_level eq 0}">
								<font>${BoardDTO.title}</font>
								</c:if>
								
								</td>
								<td>${BoardDTO.writer}</td>
								<td>${BoardDTO.viewcount}</td>
								<td>${BoardDTO.regdate}</td>
							</tr>
						</c:forEach>
					</c:if>
                    </tbody>
                </table>   
		</div>
	</div>
	
	<!-- javascript is test -->
<!--  	<form id="jobForm">
		<input type="hidden" name="page" value=${pageMaker.cri.perPageNum}>
		<input type="hidden" name="perPageNum" value=${pageMaker.cri.perPageNum} >
	</form> -->
	<!--  -->
	
	
	<!-- serch -->
	
	
	<select name="searchType" id="searchType" class="form-control" style="width: 100px;">
		<option value="n" <c:out value="${cri.searchType eq 'n'?'selected':'' }"/>>---</option>	
		<option value="a" <c:out value="${cri.searchType eq 'a'?'selected':'' }"/>>모두</option>
		<option value="t" <c:out value="${cri.searchType eq 't'?'selected':'' }"/>>제목</option>
		<option value="n" <c:out value="${cri.searchType eq 'n'?'selected':'' }"/>>내용</option>
		<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':'' }"/>>글쓴이</option>
		<option value="tn" <c:out value="${cri.searchType eq 'tn'?'selected':'' }"/>>제목/내용</option>
	</select> 
    <input type="text" name="keyword" id="keywordInput"  value="">
	<button id="searchBtn" class="btn btn-default">Search</button>
	
	
	
	<!--  -->
	<!-- page controll but  -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		     <c:if test="${pageMaker.prev}">
		    	<li class="page-item">
			      <a class="page-link" href="./listPage${pageMaker.makeSearch(pageMaker.startPage -1)}" aria-label="Previous">
			        <span aria-hidden="true">«</span>
			        <span class="sr-only">Previous</span>
			      </a>
		    	</li>
		     </c:if>
		     
		     
		     <c:forEach begin="${pageMaker.startPage }" end ="${pageMaker.endPage }" var="idx">
		    	  <li  class='page-item'
		    	  	<c:out value="${pagemaker.cri.page == idx}"/>>
		    	 
		  <a class="page-link" href="./listPage${pageMaker.makeSearch(idx)}">${idx}</a>   
		    	
		    	 <!-- javascript is test -->
<%-- 		    	   <a class="page-link" href="${idx}">${idx}</a>  --%>
		    	  <!--  --> 
		    	  
		    	  
		     </c:forEach>
<!-- 		<li class="page-item active"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li> -->
		    
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			    <li class="page-item">
			       <a class="page-link" href="./listPage${pageMaker.makeSearch(pageMaker.endPage +1)}" aria-label="Next"> 
			      
			      <!-- javascript is test -->
<!-- 		    	   <a class="page-link" href="${pageMaker.endPage +1}">${pageMaker.endPage +1}</a>  -->
		    	  <!--  --> 
			      
			      
			        <span aria-hidden="true">»</span>
			        <span class="sr-only">Next</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
</div>
</body>

<script type="text/javascript">




	<%-- var id = <%=(String)session.getAttribute("id")%> --%>
var id = document.getElementById('loginId').innerText;




//테이블 생성 이벤트 시작
function registClick() {
	window.location.href="registBoard";
	//	window.location.href="AllTeamList?Conlist="+Conlist+"&permit="+permit+"&searchFile="+searchFile+"&searchRights="+searchRights+"&keyword="+keyword+"&searchAreas="+searchAreas;
  
}
const button = document.getElementById("creatBut");
button.addEventListener("click",registClick);

//테이블 생성 이벤트 끝

//
//테이블 행 선택 클릭 이벤트 시작
var cols = document.querySelectorAll('#boardTable .choice'); 
 
[].forEach.call(cols,function(col){
    col.addEventListener("click",click,false);
});
 
<%--  var readBoardBno = <%%> --%>
function click(e){
	var bno = this.firstElementChild.innerText;
	window.location.href="readBoard"+bno;
}

//테이블 행 선택  클릭 이벤트 끝


if(id != ""){
	$("#login").val('로그아웃')
	$("#login").attr('id','logout');
	
}else if(id == ""){
	$("#logout").val('로그인')
	$("#logout").attr('id','login');
	
}


$('#login').on('click',function(){
	window.location.href="login";
});

$('#logout').on('click',function(){
	window.location.href="loginout";
});

$('#searchBtn').on("click",function(event){

	self.location = "listPage"+'${pageMaker.makeQuery(1)}'+"&searchType="+$("select option:selected").val()+"&keyword="+$('#keywordInput').val();

});


//javaScprit Test pagecountroll
/* $(".pagination li a").on("click",function(event){
	event.preventDefault();
	
	var targetPage = $(this).attr("href");
	
	var jobForm = $("#jobForm");
	jobForm.find("[name='page']").val(targetPage);
	jobForm.attr("action", "./listPage").attr("method","get");
	console.log(targetPage);
	//	jobForm.submit();
}); */


</script>
</html>