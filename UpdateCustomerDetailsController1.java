package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.dao.CustomerRDBMSImpl;
import com.nucleus.dao.CustomerRDBMSImplService;
import com.nucleus.dao.ICustomerDao;
import com.nucleus.dao.ICustomerService;
import com.nucleus.entity.Customer;
import com.nucleus.validation.CheckValidations;
import com.nucleus.validation.ValidationMethods;

/**
 * Servlet implementation class UpdateCustomerDetailsController1
 */
@WebServlet("/UpdateCustomerDetailsController1")
public class UpdateCustomerDetailsController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerDetailsController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				PrintWriter writer = response.getWriter();
				ValidationMethods validationmethods = new ValidationMethods();                             // Object of ValidationMethods class
				CheckValidations checkvalidationmethods = new CheckValidations(); 
				//ICustomerDao customerdao = new CustomerRDBMSImpl();
				ICustomerService customerservice = new CustomerRDBMSImplService();
				HttpSession session = request.getSession(false);
				Date createdate = (Date) session.getAttribute("createdate");
				String createdby = (String) session.getAttribute("createdby");
				String status =(String) session.getAttribute("status");
				String userid = (String) session.getAttribute("userid");
				//String userid ="Priya12";
				String customercode = request.getParameter("customercode");
				System.out.println(customercode);
				String customername= request.getParameter("customername");
				System.out.println(customername);
				String address1 = request.getParameter("address1");
				System.out.println(address1);
				String address2 = request.getParameter("address2");
				System.out.println(address2);
				int pincode = Integer.parseInt(request.getParameter("pincode"));
				System.out.println(pincode);
				String email = request.getParameter("email");
				System.out.println(email);
				long contactno = Long.parseLong(request.getParameter("contactno"));
				System.out.println(contactno);
				String contactperson = request.getParameter("contactperson");
				System.out.println(contactperson);
				String flag = request.getParameter("flag");
				System.out.println(flag);
				
				

				Customer customer = new Customer();
				customer.setCustomercode(customercode);
				customer.setCustomername(customername);
				customer.setAddress1(address1);
				customer.setAddress2(address2);
				customer.setCustomerpincode(pincode);
				customer.setEmailaddress(email);
				customer.setContactno(contactno);
				customer.setPrimary_contact_person(contactperson);
				customer.setRecord_status(status);
				customer.setActive_inactive_flag(flag);
				customer.setCreate_date(createdate);
				customer.setCreated_by(createdby);
				Date date = new Date();
				SimpleDateFormat smd = new SimpleDateFormat("dd/MMM/yyyy");
				String modifieddate = smd.format(date);
				try {
					customer.setModified_date(new SimpleDateFormat("dd/MMM/yyyy").parse(modifieddate));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				customer.setModified_by(userid);
				 boolean b = validationmethods.CheckCustomerName(customer.getCustomername());
				 System.out.println("b"+b);
		         boolean c2 = validationmethods.CheckEmailAddress(customer.getEmailaddress());
		         System.out.println("c2"+c2);
		         boolean d = validationmethods.CheckPincode(Integer.toString(customer.getCustomerpincode()));
		         System.out.println("d"+d);
		         boolean e = validationmethods.CheckRecordStatus(customer.getRecord_status());
		         System.out.println("e"+e);
		         boolean f = validationmethods.CheckFlag(customer.getActive_inactive_flag());
		         System.out.println("f"+f);
		         boolean g = checkvalidationmethods.DataLength(customer);
		         System.out.println("g"+g);
		         boolean h = checkvalidationmethods.MandatoryFields(customer);  
		         System.out.println("h"+h);
		         boolean i = checkvalidationmethods.DataType(customer);   
		         System.out.println("i"+i);
		        // boolean j = validationmethods.CheckPrimaryKey(list,customer.getCustomername());
		        
		         if(b==true||c2==false||d == true||e==false||f ==false||g==false||h==false||i==false)
		         {
		        	 RequestDispatcher dispacher = request.getRequestDispatcher("ValidationFailed.jsp");
		        	 dispacher.forward(request, response);
		        	 
		         }
		         else
		         {
		        	 try {
						customerservice.updatecustomerDetails1(customer);
						RequestDispatcher dispacher = request.getRequestDispatcher("SuccessUpdateCustomerDetails.jsp");
			        	 dispacher.forward(request, response);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	 
		         }
	}

}
