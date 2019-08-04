<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.nucleus.entity.Customer,java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Details</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <h1 align="center" style="color:red"><b><u>Customer Details</u></b></h1>
    <table class="table table-striped" border="1" >
    <thead>
      <tr>
        <th>Customer Code</th>
        <th>Customer Name</th>
        <th>Customer Address1</th>
        <th>Customer Address2</th>
        <th>Pin code</th>
        <th>Email Address</th>
        <th>Contact No.</th>
        <th>Primary Contact Person</th>
        <th>Record Status</th>
        <th>Active_Inactive Flag</th>
        <th>Create date</th>
        <th>Create By</th>
        <th>Modified date</th>
        <th>Modified By</th>
        <th>Authorized date</th>
         <th>Authorized By</th>
        
       
        </tr>
    </thead>
    <%
    String sn = (String)session.getAttribute("sn");
    if(sn.equals("sn1"))
    {
    ArrayList<Customer> customerlist = (ArrayList)session.getAttribute("customerlist");
    Iterator<Customer> it = customerlist.iterator();
    while(it.hasNext())
    {
    	Customer customer = (Customer)it.next();
   %>
   
   <tbody>
      <tr>
        <td><%=customer.getCustomercode() %></td>
        <td><%=customer.getCustomername()%></td>
        <td><%=customer.getAddress1()%></td>
        <td><%=customer.getAddress2()%></td>
        <td><%=customer.getCustomerpincode()%></td>
        <td><%=customer.getEmailaddress()%></td>
         <td><%=customer.getContactno()%></td>
        <td><%=customer.getPrimary_contact_person()%></td>
        <td><%=customer.getRecord_status()%></td>
        <td><%=customer.getActive_inactive_flag()%></td>
        <td><%= customer.getCreate_date()%></td>
        <td><%= customer.getCreated_by()%></td>
        <td><%= customer.getModified_date()%></td>
        <td><%= customer.getModified_by()%></td>
        <td><%= customer.getAuthorized_date()%></td>
        <td><%= customer.getAuthorized_by()%></td>
        
      </tr>
    </tbody>
    <%
    }
    }
    else if(sn.equals("sn2"))
    {
    	Customer customer = (Customer)session.getAttribute("customer");
    
    %>
     <tbody>
      <tr>
        <td><%=customer.getCustomercode() %></td>
        <td><%=customer.getCustomername()%></td>
        <td><%=customer.getAddress1()%></td>
        <td><%=customer.getAddress2()%></td>
        <td><%=customer.getCustomerpincode()%></td>
        <td><%=customer.getEmailaddress()%></td>
         <td><%=customer.getContactno()%></td>
        <td><%=customer.getPrimary_contact_person()%></td>
        <td><%=customer.getRecord_status()%></td>
        <td><%=customer.getActive_inactive_flag()%></td>
        <td><%= customer.getCreate_date()%></td>
        <td><%= customer.getCreated_by()%></td>
        <td><%= customer.getModified_date()%></td>
        <td><%= customer.getModified_by()%></td>
        <td><%= customer.getAuthorized_date()%></td>
        <td><%= customer.getAuthorized_by()%></td>
        
      </tr>
    </tbody>
    <%
    }
    %>
   

</body>
</html>