<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

#formDiv{
	margin: 20%;
}

</style>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

		<form action="loginGo" method="GET" id ="formId">
			<div id="formDiv">
				
				<label>아이디</label><br>
				<input type ="text" name="id" id="id" placeholder="아이디를 입력하세요" required >
				<br>
				
				<label>비밀번호</label><br>
				<input type ="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" required >
				<br>
				<br>
				<input type="submit" id="memberLog" value="회원로그인">
<!-- 				<input type="button" id="guestLog" value="비회원로그인"> -->
			</div>
		
		</form>
</body>

<script type="text/javascript">

//비회원 로그인 버튼 시작

/* function loginClick() {
	alert('비회원 로그인입니다.')
	window.location.href="loginGo?member=1";
}
const button = document.getElementById("guestLog");
button.addEventListener("click",loginClick);
 */
//비회원 로그인 버튼 끝

</script>
</html>