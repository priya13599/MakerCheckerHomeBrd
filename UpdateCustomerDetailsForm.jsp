<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="MakerCheckerLogin.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Update Customer Details</title>
</head>
<body>

<%

if(session.getAttribute("userid")==null)
{
	response.sendRedirect("MakerCheckerLogin.html");
}

else if(request.getSession(false)!=null)
{
%>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MakerChecker</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home.html">Home</a></li>
      <li><a href="InsertCustomerDetailsForm.jsp" title="Insert Details"><span class="glyphicon glyphicon-plus"></span> </a></li>
      <li><a href="UpdateCustomerDetailsForm.html" title="Update Details"><span class="glyphicon glyphicon-edit"></span> </a></li>
      <li><a href="DeleteCustomerDetailsForm.jsp" title="Delete Details"><span class="glyphicon glyphicon-trash"></span> </a></li>
      <li><a href="DisplayCustomerDetails1.jsp" title="Display Details"><span class="glyphicon glyphicon-list-alt"></span></a></li>
      <li><a href="DisplayCustomerDetailsByCode.jsp" title="Display Details By ID"><span class="glyphicon glyphicon-th-list"></span> </a></li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" title="Sort By"><span class="caret"  class="glyphicon glyphicon-sort" ></span></a>
        <ul class="dropdown-menu">
          <li ><a href="SortCustomerDetailsController">In Ascending Order</a></li>
          <li ><a href="SortCustomerDetailsController1">In Descending Order</a></li>
         </ul>
      </li>
   
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span><% out.println("Loggedin as "+session.getAttribute("userid")); %></a></li>
      <li><a href="LogoutController"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
 <!--  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p> -->
</div>



<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
 <div id="formFooter"  style="background-color:#e3f2fd; color:#5fbae9">
      <h1> Update Customer Details</h1>
    </div>

       <!-- Login Form -->
    <form action="UpdateCustomerDetailsController1" method="post">
      <input type="text" id="login" class="fadeIn second" name="customercode" value=<%=session.getAttribute("customercode") %> >
       <input type="text" id="login" class="fadeIn third" name="customername" value=<%=session.getAttribute("customername") %>>
            <textarea rows="2" cols="45" name ="address1" > <%=session.getAttribute("address1") %> </textarea><br><br>
        <textarea rows="2" cols="45" name="address2" ><%=session.getAttribute("address2") %></textarea>
          <input type="text" id="password" class="fadeIn third" name="pincode" value=<%=session.getAttribute("pincode") %> >
            <input type="text" id="password" class="fadeIn third" name="email" value=<%=session.getAttribute("email") %>>
              <input type="text" id="password" class="fadeIn third" name="contactno" value=<%=session.getAttribute("contactno") %> >
                <input type="text" id="password" class="fadeIn third" name="contactperson" value=<%=session.getAttribute("contactperson") %> >
                
               
      <br>
      <br>
      <div class="dropdown">
  
  <select class="btn btn-default dropdown-toggle" data-toggle="dropdown" name="flag">
  
  <option value="A"><%=session.getAttribute("flag") %></option>
  <option value="I"><%=session.getAttribute("flag") %></option>
  
  </select>
  </div>
        <br>
      <br>
      
      <input type="submit" class="fadeIn fourth" value="Update">
      </form>
      </div>
</div>


<%
}
%>
</body>
</html>