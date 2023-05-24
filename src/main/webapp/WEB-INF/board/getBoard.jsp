<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoard</title>
</head>
<body>
	<h1>${board.seq} 번 글 상세보기
	</h1>
	<form action="updateBoard.do?page=1" method="post">
		<input type="hidden" name="seq" value="${board.seq }">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" value="${board.title }"
					name="title"></td>
			</tr>

			<tr>
				<td>작성자</td>
				<td>${board.writer }</td>
			</tr>

			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="40" name="content">${board.content }</textarea>
				</td>
			</tr>

			<tr>
				<td>등록일</td>
				<td>${board.regDate }</td>
			</tr>

			<tr>
				<td>조회수</td>
				<td>${board.cnt }</td>
			</tr>

			<tr>
				
				<td colspan="2"> <input type="submit" value="글 수정"></td>
				
			</tr>
		</table>
	</form>
	<a href="getBoardList.do?page=1">글목록</a> &nbsp;<a href="deleteBoard.do?seq=${board.seq}&page=1">글삭제</a>
				
	
	<br> <br>
</body>
</html>