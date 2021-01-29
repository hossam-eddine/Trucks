<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.bg{
  background-color:rgba(0,0,0,0.5);
  
   width: 100%;
   height: 100vh;
   
 
  
}
    .form-container{
       background: transparent;
       
       padding: 30px;
       border-radius:10px;
       box-shadow: 0px 0px 10px 0px #000;
       position: absolute;
       top:15vh;
    
    
    }
    
    @media only screen and  (max-width:678px;){
    .bg{
    background-size: 300%;
    
    }}
</style>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Connection</title>
</head>
<section class="container-fluid bg">
<section class="row justify-content-center">
<section class="col-12 col-sm-6 col-md-3">

<form class="form-container"  method="post"> 
  
  
  <div class=" mb-3">
    <label for="exampleInputEmail1" class="form-label">Username</label>
    <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
   
  </div>
  <div class=" mb-3">
    <label for="exampleInputEmail1" class="form-label">CIN</label>
    <input type="text" name="cin" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
 
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" required="required">
  </div>

  <input  type="submit" class="btn btn-primary btn-block" value="connect">
</form>

</section>
 </section>
</section>






<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>