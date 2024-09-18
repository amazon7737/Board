<%@ page import="org.board.domain.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--데이터 import해줄때 object도 처리되어있는것을 List<BoardVO> 로 강제변환 시켜야함--%>
<% List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Insert Title here</title>
</head>
<body>
<table border="1">
    <tr>
        <th>NO</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>

    <%for(int i=0; i<list.size(); i++) { %>
        <tr>
<%--    =붙여줘야 데이터 뜬다..        --%>
            <td><%=list.get(i).getSeq()%></td>
            <td>
                <a href="/read/<%=list.get(i).getSeq()%>">
                <%=list.get(i).getTitle()%>
                </a>
            </td>
            <td><%=list.get(i).getWriter()%></td>
            <td><%=list.get(i).getRegDate()%></td>
            <td><%=list.get(i).getCnt()%></td>
        </tr>
    <% } %>
</table>
<a href="/write">새글</a>

</body>
</html>