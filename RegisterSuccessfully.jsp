<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Successfully</title>
</head>
<body>
<%-- <%

if(session.getAttribute("userid") == null)
{

response.sendRedirect("MakerCheckerLogin.html");
}
	
%> --%>

<h1> Your are Registered Successfully  <% out.println(session.getAttribute("userid")); %></h1>
<form action="MakerCheckerLogin.html">
<input type="submit" value="Log In">
</form>



</body>
</html>