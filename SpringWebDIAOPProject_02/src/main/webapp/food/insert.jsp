<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="insert3.do">
		이름:<input type="text" name=name size=20><br>
		성별:<input type="radio" name=sex value="남자" checked>남자
			<input type="radio" name=sex value="여자">여자<br>
		주소:<input type="text" name=address size="35"><br>
		전화:<input type="text" name="phone" size="20"><br>
		이메일:<input type="text" name="email" size="35"><br>
		<button>전송</button>
	</form>
</body>
</html>