<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
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

<sql:query dataSource="${snapshot}" var="orders">
SELECT * FROM orders WHERE return_date IS NULL;
</sql:query>

	<h2>Create order</h2>

	<form:form method="POST" commandName="order" action="create">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<div>${message}</div>
		<table>
			<tr>
				<td>User ID :</td>
				<td>
				  <form:select path="user.id">
				    <c:forEach var="row" items="${users.rows}">
				      <form:option value="${row.id}">(${row.id}) ${row.full_name}</form:option>
				    </c:forEach>
				  </form:select>
				</td>
				<td><form:errors path="user.id" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book ID :</td>
                                <td>
				  <form:select path="book.id">
				    <c:forEach var="row" items="${books.rows}">
				      <form:option value="${row.id}">(${row.id}) ${row.author} - ${row.title}</form:option>
				    </c:forEach>
				  </form:select>
				</td>
				<td><form:errors path="book.id" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

	<h2>Return order</h2>

	<form:form method="POST" commandName="order" action="return">
	  <form:errors path="*" cssClass="errorblock" element="div" />
	  <div>${message}</div>
	  <table>
	    <tr>
	      <td>Order ID :</td>
	      <td>
	        <form:select path="id">
	          <c:forEach var="row" items="${orders.rows}">
	            <form:option value="${row.id}">${row.id}</form:option>
	          </c:forEach>
	        </form:select>
	      </td>
	      <td><form:errors path="user.id" cssClass="error" /></td>
	    </tr>
	    <tr>
              <td colspan="3"><input type="submit" /></td>
            </tr>
	  </table>
	</form:form>

</body>
</html>