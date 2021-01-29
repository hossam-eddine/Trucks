<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.fo{
       background-color:rgba(0,0,0,0.5);
       
       padding: 30px;
       border-radius:5%;
       box-shadow: 0px 0px 10px 0px #000;
      
       
    
    
    }
   

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<nav class='navbar navbar-expand-lg navbar-light' id='nav' style='background:transparent; box-shadow: none !important; background-color:rgba(0,0,0,0.5);'>
        <a style='margin-left: 5%' class='navbar-brand'>Admin_Panel</a>
        <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
            <span style='color: white' class='navbar-toggler-icon'></span>
        </button>
        <div style='margin-left: 40%;' class='collapse navbar-collapse'  id='navbarNav'>
            <ul class='navbar-nav'>
               
                <li class='nav-item'>
                    <a class='nav-link' style='color: white; font-family: 'Poppins Light'; margin-left: -5%;' href='camion'>Add_Trucks </a>
                </li>
               
                
                <li class='nav-item'>
                    <a class='nav-link' style='color: white; font-family: 'Poppins Light'; margin-left: -5%;' href='Historique'>My_Reservation</a>
                </li>
            </ul>
            <button id='btn' type='button' class='btn btn-primary' style='margin-left: 40%; border: 2px solid white; border-radius: 50px; '><a style='color: white; padding: 10px 20px 10px 20px; font-family: 'Poppins Medium'; text-decoration: none;' href="../log">logout</a> </button>
        </div>
    </nav>
 <form class=" fo w-50 p-3 row   mx-auto  text-light  needs-validation " method="post" style="margin-top:150px; ">
   
   
    <div class="col-md-12 mt-2">
    <label for="inputEmail4"  class="form-label">Matricule</label>
      <input type="text"  name="admin_matricule"  class="form-control" id="inputAddress" placeholder="Matricule" required="required">
  </div>
  <div class="col-md-12 mt-2">
    <label for="inputPassword4"  class="form-label">Marque</label>
    <input type="password"  name="admin_marque" class="form-control"  placeholder="Marque"  id="inputPassword4" required="required">
  </div>
   <div class="col-md-12 mt-2">
    <label for="inputPassword4"  class="form-label">Prix</label>
    <input type="number"    name="prix" class="form-control"  placeholder="Prix"  id="inputPassword4" required="required">
  </div>
  
 
 
  
  
  <div class="col-12 mt-5" >
   
       <input type="submit" class="  btn btn-primary form-control" value="Add" >
  </div>
  
  




    


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>