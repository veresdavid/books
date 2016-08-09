<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>List</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/books"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="books">
SELECT * FROM book;
</sql:query>

<sql:query dataSource="${snapshot}" var="users">
SELECT * FROM user;
</sql:query>

<table border="1" width="100%">
<tr>
<th>Book ID</th>
<th>Author</th>
<th>Title</th>
<th>Price</th>
</tr>
<c:forEach var="row" items="${books.rows}">
<tr>
<td><c:out value="${row.id}"/></td>
<td><c:out value="${row.author}"/></td>
<td><c:out value="${row.title}"/></td>
<td><c:out value="${row.price}"/></td>
</tr>
</c:forEach>
</table>

<br />

<table border="1" width="100%">
<tr>
<th>User ID</th>
<th>Full name</th>
<th>Login name</th>
<th>Password</th>
</tr>
<c:forEach var="row" items="${users.rows}">
<tr>
<td><c:out value="${row.id}"/></td>
<td><c:out value="${row.full_name}"/></td>
<td><c:out value="${row.login_name}"/></td>
<td><c:out value="${row.password}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>