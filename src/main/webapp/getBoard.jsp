<%@page import="com.ssamz.biz.board.impl.BoardDAO"%>
<%@page import="com.ssamz.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	
//1. Controller(Servlet)가 Model(DAO)을 이용하여 검색한 결과를 세션으로부터 추출한다.
	BoardVO board = (BoardVO) session.getAttribute("board");
	
	// 2. 응답화면 구성

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<hr>
		<form action="updateBoard.do method="post">
			<input type="hidden" name="seq" value="<%=board.getSeq()%>" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="title" type="text"
						value="<%=board.getTitle()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><%=board.getWriter()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"><%=board.getContent()%></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><%=board.getRegDate()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%=board.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>
	</center>
</body>
</html>