<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
  <div>
    <table>
      <tr>
        <td><a href="/downloadExcelAsReponse">Download Excel As Response</a></td>
        <td><a href="/downloadExcelAsFile">Download Excel As File</a></td>
        <td><a href="/downloadExcelAsFile1">Download Excel As File 1</a></td>
        <td><a href="/download1">Download 1</a></td>
        <td><a href="/download2">Download 2</a></td>
      </tr>
    </table>

  </div>
  <div>
    <table border="1" style="padding: 5px">
      <thead>
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>CATEGORY</th>
          <th>PRICE</th>
          <th>DESCRIPTION</th>
        </tr>
      </thead>
      <c:forEach items="${products}" var="product">
        <tr>
          <td><c:out value="${product.id}">
            </c:out></td>
          <td><c:out value="${product.name}">
            </c:out></td>
          <td><c:out value="${product.category}">
            </c:out></td>
          <td><c:out value="${product.price}">
            </c:out></td>
          <td><c:out value="${product.description}">
            </c:out></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>