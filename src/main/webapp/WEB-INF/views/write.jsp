<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Insert Title here</title>
</head>

<body>
    <form  action="/write" method="post">
        <table border="1">
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" id="title" name = "title"/>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <input type="text" id="content" name = "content"/>
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" id="writer" name = "writer"/>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="text" id="password" name = "password"/>
                </td>
            </tr>
        </table>
        <button type = "submit">등록</button>
        <a href="/list">목록</a>
    </form>
</body>
</html>