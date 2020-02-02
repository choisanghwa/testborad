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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<style type="text/css">
	.popup{position: absolute;}
	.back{background-color: gray; opacity: 0.5; width: 47%;height: 100%;
			overflow: hidden; z-index: 1101;
			}
			
    .front{z-index: 1110; opacity: 1; border: 1px; margin: auto;}
	.show{position: relative; max-width: 1200px; max-height: 800px; overflow: auto;}
	
	
	.textbox{
		width: 100%;
	}
	
	.replayStyle{
		color: blue;
	}

</style>






</head>
<body>

	<form role='form' method="post">
	
	<input type='hidden' name='bno' id="bno" value="${boardData.bno}">
	
	</form>
	
	<div class="container" style="margin-top: 40px;">
	
	
	
		<div class="card" id="boardMain">
		  <h2 class="text-center">${boardData.title}</h2> <!-- 게시물 제목 -->
		    <div class="card-body">
		  
		        <div class="row">
		        
		        		<div>
							<button id= "returnBut">목록으로</button>
							<button id= "reboard">답글달기</button>
		        		     <c:if test="${boardData.id == id || level == 1 }">
								<button type="submit" id="modified">수정</button>
							</c:if>
							<c:if test="${boardData.id == id || level == 0 || level == 1}">
								<button id= "delect">삭제</button>
							</c:if>
		 					<input type="password" id="pw" value="" placeholder="암호를 입력하세요" required disabled>
		 				</div>
	        	    <div class="col-md-10">
    
	        	       <div class="clearfix" style="margin-top: 20px;">
	        	      
		        	        <p class='replayStyle' style="font-size: 30px;"><strong>${boardData.writer}</strong></p>
		        	        <p>${boardData.content}</p>
		        	      
			        	       <c:if test="${boardData.fileOne ne null}">
				        	        <p><img id="popup_img" src = "displayOneFile?fileName=${boardData.fileOne}" width="175" height="200"/></p>
				        	         <a href="ddisplayOneFile?fileName=${boardData.fileOne}">이미지 크게보기</a>
				        	         <a href="#" id="files">${boardData.fileOne}</a>
			        	        </c:if>
		        	        
		        	       
	        	       </div>
		        	</div>
					
					
		         </div>
		         			
		    </div>
		</div>
	<!-- 	<!-- 댓글인데...에휴.. 
			<div class="card card-inner" style="margin-top: 20px;">
            	    <div class="card-body">
            	        <div class="row">
                    	    <div class="col-md-10">
                    	        <p>Lorem Ipsum is simply dummy text of the pr make  but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                    	        <p>
                    	            <a class="float-right btn btn-outline-primary ml-2">  <i class="fa fa-reply"></i> Reply</a>
                    	            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                    	       </p>
                    	    </div>
            	        </div>
            	    </div>
   
			 </div> -->
		
		
			<div class="card card-inner" style="margin-top: 20px;">
            	    <div class="card-body">
            	        <div class="row">
                    	    <div class="col-md-10">
                    	    	<p><textarea id = "retext" class="textbox"></textarea></p>

                    	        <p>
                    	       		<input style="margin-left: 600px;" type='text' id='replypw' value='' placeholder='암호를 입력하세요' required disabled>
                    	            <button id="reply" class="float-right btn text-white btn-danger"> 댓글달기</button>
                    	       </p>
                    	    </div>
            	        </div>
            	    </div>
   
			 </div>
			  
	</div>
	

	<div class="popup back" style="display: none;"></div>
		<div id="popup_front" class='popup front' style="display: none;">
			
		</div>
		
	<div id="boardId" style="display: none;">${boardData.id}</div>
	<div id="boardPw" style="display: none;">${boardData.boardpw}</div>
	<div id="id" style="display: none;">${id}</div>
	<div id="username" style="display: none;">${name}</div>
	<div id="level" style="display: none;">${level}</div>
	<div id="page" style="display: none;">${cri.page}</div>
	<div id="perPageNum" style="display: none;">${cri.perPageNum}</div>
	<div id="searchType" style="display: none;">${cri.searchType}</div>
	<div id="keyword" style="display: none;">${cri.keyword}</div>

</body>


<script type="text/javascript">




$(document).ready(function() {
	
	
	var boardId = document.getElementById('boardId').innerText;
	var boardPw = document.getElementById('boardPw').innerText;
	var id = document.getElementById('id').innerText;
	var name = document.getElementById('username').innerText;
	if(id === ""){
		name = "비회원"
		id=null
	}
	var level = document.getElementById('level').innerText;
 	var pw =document.getElementById('pw');
 	var str="";
 	
 	
 	//목록으로 돌아갔을때 페이지 기억하기
 	var page =  document.getElementById('page').innerText; //페이징처리
 	var perPageNum = document.getElementById('perPageNum').innerText; //페이징처리
 	var searchType =  document.getElementById('searchType').innerText; //페이징처리
 	var keyword = document.getElementById('keyword').innerText; //페이징처리	
 	
 	var formObj = $("form[role='form']");
	getAllList();
 	
 	//게시글이 비회원이 작성한 것
	if(boardId === "" ){
		if(level != '0'){
		$("#pw").removeAttr("disabled"); 
		}
			
	} 
	
	//비회원이 댓글 작성시 비번 필요
	if(id == null){
		$("#replypw").removeAttr("disabled"); 
	}
	
	
	//var $repw = $("<input type='text' id='repws' value='' placeholder='암호를 입력하세요' required disabled>");
	function getAllList(){
		
		$.getJSON("./replies/all/"+$('#bno').val(), function(data){
			console.log(data.lenght);
			str="";
		
			$(data).each(function(){
				
				str += "<div class='card card-inner' style='margin-top: 20px;'>"
				 +"<div class='card-body'><div class='row'><div class='col-md-10'>"
				 +"<p class='replayStyle'><strong>"+this.replay+"</strong></p>"
	        	 + "<p class='retexts'  data-pw='"+this.replaypw+"' data-id='"+this.reid+"' data-rno='"+this.rno+"'>"+this.replaytext+"</p>"
	        	 
	       		 + "<p>"
	        	 
 	       		// if(this.reid == null){
	       		//	+ "<input style='margin-left: 500px;' type='text' class='repws' value='' placeholder='암호를 입력하세요' required disabled>"
	       		// }
	       		 + "<input style='margin-left: 500px;' type='text' class='repws a"+this.reid+"' value='' placeholder='암호를 입력하세요' required disabled>"
	        	 
	        	 + "<button id='delete' class='float-right btn btn-outline-primary ml-2 delete'>댓글삭제</button>"
	    	     + "<button class='float-right btn btn-outline-primary ml-2 update'>댓글수정</button>"
	        	
	        	 +"</p></div></div></div></div>"
	        	 
  
			});
			 
 			 $('#boardMain').after(str);
			 
        	 
					//댓글이 비회원이 작성한 것
						$(".a").removeAttr("disabled");
				 
			  
		});
	}
	
	//
	
	$('#reboard').on('click',function(){
	window.location.href="registBoard?bno="+$('#bno').val();
	});
	
	//
	$("#modified").on("click",function(){
    	formObj.attr("action","modifyBoard");
		formObj.attr("method","get");
	
		if(boardId == ""){
			if(document.getElementById('pw').value === boardPw){
				
				formObj.submit(); 
			}
		}else{
			
			formObj.submit();
		}
				
			
	
	});

	
	$("#delect").on("click",function(){
		formObj.attr("action","delectBoard");
		
		if(boardId == ""){
			if(document.getElementById('pw').value === boardPw ){
				
				formObj.submit(); 
			}else if(level === '0'){
				formObj.submit(); 
			}
		}else{
			
			formObj.submit();
		}
		
	});
	
	$("#returnBut").on("click",function(){
		
		window.location.href="./listPage?page="+page+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword="+keyword;


	});
	
	
 	
	//img popup
	$("#popup_img").on("click",function(){
		var path = $(this).attr('src')
		showImage(path);
	//	alert(path);
	});
	
	function showImage(fileCallPath){
		 $(".popup").css("display","flex").show();
		    
		    $("#popup_front")
		    .html("<img src='"+fileCallPath+"' >")
		    .animate({width:'100%', height: '100%'}, 10);
		    
		  }//end fileCallPath
		  
		$(".popup").on("click", function(e){
		    $("#popup_front").animate({width:'0%', height: '0%'}, 10);
		    setTimeout(function(){
		      $('.popup').hide();
		    }, 1000);
		});//end bigWrapperClick event
	
	 
		 
		$("#files").unbind("click").click(function(e){
			
			//alert("확인"+this.innerHTML);
			window.location.href="./download?fileName="+this.innerHTML;
		});
		

		
		//댓글처리 구문 
		 //댓글 //댓글
		//댓글 달기
		

		
		
		$("#reply").on("click",function(){
			
			
	 		$.ajax({
				
				url : './replies/re',
				type:"POST",
				data : {
					bno : $('#bno').val(),
					replaytext	: $('#retext').val(),
					replay : name,
					replaypw :$('#replypw').val(),
					reid : id,
					
				},
				dataType : "text",
				success : function(data){
		            if(data=="SUCCESS")
		            {
		               alert("등록성공");
			        	      
		               window.location.reload();
		              
		            }
		        },
		        error:function(data){
		            alert("실패");
		       }
				
				
			}); 
			
		});
		
		
		
		//수정
			$(document).on("click",".update", function(){
				
				var text=$(this).parent().prevAll('.retexts').text();
				var reid= $(this).parent().prevAll('.retexts').attr("data-id");
				var repw= $(this).parent().prevAll('.retexts').attr("data-pw");
				

				var $retexts = $("<textarea class='textbox textre'>"+text+"</textarea>");
				var $upBtu = $("<button class='float-right btn text-white btn-danger upgread'>수정하기</button>");
				var $canBtu = $("<button class='float-right btn btn-outline-primary ml-2 cencal'>취소하기</button>");
				
				
				
				if(reid == ""){
					if($(this).prevAll(".repws").val() === repw ){
						
						$(this).parent().prevAll('.retexts').empty();
						$(this).parent().prevAll('.retexts').append($retexts);
						$(this).prevAll(".repws").hide();
						$(this).hide();
						$(this).prevAll('.delete').hide();
						$(this).parent().prepend($upBtu);
						$(this).parent().prepend($canBtu);
					
					}else{
						alert("다시입력바람");
					}
				}else{
					$(this).parent().prevAll('.retexts').empty();
					$(this).parent().prevAll('.retexts').append($retexts);
					$(this).hide();
					$(this).prevAll('.delete').hide();
					$(this).parent().prepend($upBtu);
					$(this).parent().prepend($canBtu);
				}
				

				
				
				
				

			
		});
			
		
		$(document).on("click",".upgread",function(){
			

								$.ajax({
									//
									url : './replies/upload',
									type:"POST",
									
								//	contentType: 'application/json; charset=utf-8',
								    
								    data : {
								    	rno : $(this).parent().prevAll('.retexts').attr("data-rno"),
								    	replaytext	: $(this).parent().prev().children('.textre').val(),
									},
									
									success : function(data){
							            if(data=="SUCCESS")
							            {
							            	alert("수정 성공");
							               window.location.reload();
							            }
							        },
							        error:function(data){
							            alert("실패");
							       }
									
									
								});   
								
	 
			
		});
		
		$(document).on("click",".cencal",function(){
			window.location.reload();
			
		});
		
		//삭제
		$(document).on("click",".delete", function(){
			var reid= $(this).parent().prevAll('.retexts').attr("data-id");
			var repw= $(this).parent().prevAll('.retexts').attr("data-pw");
			if(reid == ""){
				if($(this).prevAll(".repws").val() === repw ){
					$.ajax({
						
						url : './replies/remove/'+$(this).parent().prevAll('.retexts').attr("data-rno"),
						type:"delete",
						headers:{
							"Content-Type": "application/json",
							"X-HTTP_Method-Override":"DELETE"
						},
						dataType : "text",
						success : function(data){
				            if(data=="SUCCESS")
				            {
				               alert("삭제성공");
				               window.location.reload();
				            }
				        },
				        error:function(data){
				            alert("실패");
				       }
						
						
					}); 
				}else{
					alert("다시입력바람");
				}
			}else{
				$.ajax({
					
					url : './replies/remove/'+$(this).parent().prevAll('.retexts').attr("data-rno"),
					type:"delete",
					headers:{
						"Content-Type": "application/json",
						"X-HTTP_Method-Override":"DELETE"
					},
					dataType : "text",
					success : function(data){
			            if(data=="SUCCESS")
			            {
			               alert("삭제성공");
			               window.location.reload();
			            }
			        },
			        error:function(data){
			            alert("실패");
			       }
					
					
				}); 
			}
	
					
					////

		});
		
		
		
		


});


</script>


</html>