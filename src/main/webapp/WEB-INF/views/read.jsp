<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.board.domain.BoardVO" %>
<% BoardVO data = (BoardVO) request.getAttribute("boardVO"); %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Insert Title here</title>
</head>

<body>
<table border="1">
    <tr>
        <th>제목</th>
        <td><%=data.getTitle()%></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=data.getContent()%></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=data.getWriter()%></td>
    </tr>
    <tr>
        <th>작성일</th>
        <td><%=data.getRegDate()%></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=data.getCnt()%></td>
    </tr>
</table>
<div>
    <a href="/edit/<%=data.getSeq()%>">수정</a>
    <a href="/list">목록</a>
</div>
</body>
</html>