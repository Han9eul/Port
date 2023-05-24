<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<c:if test="${empty name}">
	<c:redirect url="login.jsp" />
</c:if>

<!-- 게시글이 아예 없는 경우.. 기본 totalRows를 설정. -->
<c:if test="${empty totalCount}">
	<c:set var="totalCount" value="1" />
</c:if>
<c:choose>
	<c:when test="${empty param.page }">
		<c:set var="page" value="1" />
	</c:when>
	<c:otherwise>
		<c:set var="page" value="${param.page }" />
	</c:otherwise>
</c:choose>

<html>
<head>
<meta charset="UTF-8">
<title>getBoardList</title>
</head>
<body>
	<h1>
		게시판 목록
	</h1>
	<h2>
		<a href="getUser?id=${id }">${name }</a>님 오신것을 환영합니다.
		<a href="logout.do">로그아웃</a> <br>
	</h2>

	<form action="getBoardList.do?page=1" method="post">
		게시판 검색유형 : <select name="searchCondition">
			<option value="WRITER">작성자</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
		</select> &nbsp;검색어 : <input type="text" size="20" name="searchKeyword">
		<input type="submit" value="검색">
	</form>

	<br>
	<br>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
			<th>조회수</th>
		</tr>

		<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.seq}</td>
				<td><a href="getBoard.do?seq=${board.seq}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="insertBoard.jsp">새 글 등록</a> <br>

	<!-- 페이지 리스트 삽입 시작 -->
	<jsp:include page="getBoardListPage.jsp">
		<jsp:param value="${page }" name="pg" />
		<jsp:param value="${totalCount }" name="totalCount" />
	</jsp:include>
	<!-- 페이지 리스트 삽입 끝 부분 -->
</body>
</html>