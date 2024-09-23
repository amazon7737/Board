<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.board.domain.BoardVO" %>
<% BoardVO data = (BoardVO) request.getAttribute("boardVO"); %>
<% Integer seq = (Integer) data.getSeq(); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Insert Title here</title>
</head>
<body>
    <form  action="/edit/<%=seq%>" method="post">
        <input type = "hidden" id = "seq" name = "seq" value="<%= data.getSeq()%>"/>
        <table border="1">
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" id="title" name = "title" value="<%= data.getTitle() %>"/>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <input type="text" id="content" name = "content" value="<%= data.getContent()%>"/>
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" id="writer" name = "writer" value="<%= data.getWriter()%>"/>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="text" id="pwd" name = "pwd" />
                </td>
            </tr>
            <div>
                <input type="submit" value="수정">
                <a href="/list">목록</a>
            </div>
        </table>
    </form>

</body>
</html>
