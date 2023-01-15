<%--
  Created by IntelliJ IDEA.
  User: dgrus
  Date: 1/14/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<body>

<h2>Library</h2>
<br>

<form th:action="@{/}">
  Filter: <input type="text" name="keyword" id="keyword" size="50" th:value="${keyword}" />
  &nbsp;
  <input type="submit" value="Search" />
</form>

<table>
  <tr>
    <th>Name</th>
    <th>Author</th>
    <th>Genre</th>
    <th>Price</th>
    <th>Operations</th>
  </tr>

  <c:forEach var="book" items="${allBooks}">

    <c:url var="updateButton" value="/updateInfo">
      <c:param name="bookId" value="${book.id}" />
    </c:url>

    <c:url var="deleteButton" value="/delete">
      <c:param name="bookId" value="${book.id}" />
    </c:url>

    <tr>
      <td>${book.name}</td>
      <td>&nbsp;${book.author.name}&nbsp;${book.author.surname}</td>
      <td>&nbsp;${book.genre}&nbsp;</td>
      <td>&nbsp;${book.price}</td>
      <td>
        <input type="button" value="Update"
               onClick="window.location.href = '${updateButton}'" />
        <input type="button" value="Delete"
               onClick="window.location.href = '${deleteButton}'" />
      </td>
    </tr>
  </c:forEach>
</table>

<br>

<input type="button" value="Add a new book to the library"
       onclick="window.location.href = 'addNewBook'" />

<input type="button" value="View all authors"
       onclick="window.location.href = 'allAuthors'" />

</body>
</html>
