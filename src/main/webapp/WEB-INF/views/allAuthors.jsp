<%--
  Created by IntelliJ IDEA.
  User: dgrus
  Date: 1/14/2023
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

<h2>Authors</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
    </tr>

    <c:forEach var="author" items="${allAuthors}">
        <tr>
            <td>${author.name}</td>
            <td>&nbsp;${author.surname}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>