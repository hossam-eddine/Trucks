<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Imprimer</title>
</head>
<body>
<h1 class="text-center">Recu</h1>
<div class ="container  mx-auto  border border-5 " style="width: 50%">

 
 <div class="mb-3 row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Client:</label>
    <div class="col-sm-10">
      <label for="staticEmail" class="col-sm-2 col-form-label"><c:out value="${sessionScope.username}"></c:out></label>
    </div>
  </div>
   <div class="mb-3 row">
    <label for="staticEmail" class="col-sm-2 col-form-label">CIN:</label>
    <div class="col-sm-10">
      <label for="staticEmail" class="col-sm-2 col-form-label"><c:out value="${sessionScope.cin}"></c:out></label>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Date_Debut:</label>
    <div class="col-sm-10">
      <label for="staticEmail" class="col-sm-6 col-form-label"><c:out value="${Db }"></c:out></label>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Date_Fin:</label>
    <div class="col-sm-10">
    <label for="staticEmail" class="col-sm-6 col-form-label"><c:out value="${Df }"></c:out></label>
    </div>
  </div>
   <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Matricule</label>
    <div class="col-sm-10">
     <label for="staticEmail" class="col-sm-2 col-form-label"><c:out value="${mat}"></c:out></label>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Marque:</label>
    <div class="col-sm-10">
     <label for="staticEmail" class="col-sm-2 col-form-label"><c:out value="${marque }"></c:out></label>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Jours:</label>
    <div class="col-sm-10">
     <label for="staticEmail" class="col-sm-2 col-form-label"><c:out value="${ days }"></c:out></label>
    </div>
  </div>
   <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Prix</label>
    <div class="col-sm-10">
     <label for="staticEmail" class="col-sm-2 col-form-label"><c:out value="${sessionScope.prix*days }"></c:out></label>
    </div>
  </div>
  


<button   onclick="imprimer()" class="btn  mt-3 " style="margin-left: 280px;">${now }</button>
</div>

<script type="text/javascript">
 function imprimer(){
	 
	 window.print();
 }
</script>
</body>
</html>