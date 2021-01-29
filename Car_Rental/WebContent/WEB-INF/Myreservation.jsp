<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Historuque de reservation</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<table class="table">
   <thead>
    <tr>
      <th scope="col">CIN</th>
      <th scope="col">Matricule</th>
      <th scope="col">Date_Debut</th>
      <th scope="col">Date_Fin</th>
    </tr>
  </thead>

  
  <tbody>
  <c:forEach var="tr" items="${re }">
    <tr>
      
      <td><c:out value="${tr.client }"></c:out></td>
      <td><c:out value="${tr.matricule }"></c:out></td>
      <td><c:out value="${tr.date_Debut }"></c:out></td>
      <td><c:out value="${tr.date_Fin }"></c:out></td>
    </tr>
      </c:forEach>
    </tbody>



</table>
</body>
</html>