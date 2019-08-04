package com.nucleus.controller;

import java.io.IOException;

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

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class InsertCustomerDetailsController
 */
@WebServlet("/InsertCustomerDetailsController")
public class InsertCustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCustomerDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		boolean j=false;
		ValidationMethods validationmethods = new ValidationMethods();                             // Object of ValidationMethods class
		CheckValidations checkvalidationmethods = new CheckValidations(); 
		//ICustomerDao customerdao = new CustomerRDBMSImpl();
		ICustomerService customerservice = new CustomerRDBMSImplService();
		HttpSession session = request.getSession(false);
		String userid = (String) session.getAttribute("userid");
		//String userid="Priya12";
		String customercode = request.getParameter("customercode");
		String customername= request.getParameter("customername");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String email = request.getParameter("email");
		long contactno = Long.parseLong(request.getParameter("contactno"));
		String contactperson = request.getParameter("contactperson");
		String flag = request.getParameter("flag");
		String recordstatus ="N";
		
		
		
		Customer customer = new Customer();
		customer.setCustomercode(customercode);
		customer.setCustomername(customername);
		customer.setAddress1(address1);
		customer.setAddress2(address2);
		customer.setCustomerpincode(pincode);
		customer.setEmailaddress(email);
		customer.setContactno(contactno);
		customer.setRecord_status(recordstatus);
		customer.setPrimary_contact_person(contactperson);
		customer.setActive_inactive_flag(flag);
		Date date = new Date();
		SimpleDateFormat smd = new SimpleDateFormat("dd/MMM/yyyy");
		String createdate = smd.format(date);
		try {
			customer.setCreate_date(new SimpleDateFormat("dd/MMM/yyyy").parse(createdate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		customer.setCreated_by(userid);
		
		
		 boolean b = validationmethods.CheckCustomerName(customer.getCustomername());
         boolean c2 = validationmethods.CheckEmailAddress(customer.getEmailaddress());
         boolean d = validationmethods.CheckPincode(Integer.toString(customer.getCustomerpincode()));
         boolean e = validationmethods.CheckRecordStatus(customer.getRecord_status());
         boolean f = validationmethods.CheckFlag(customer.getActive_inactive_flag());
         boolean g = checkvalidationmethods.DataLength(customer);
         boolean h = checkvalidationmethods.MandatoryFields(customer);     
         boolean i = checkvalidationmethods.DataType(customer);   
        try {
			ArrayList<Customer> list =  customerservice.CheckPrimaryKey();
			j = validationmethods.CheckPrimaryKey(list,customer.getCustomercode());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
         if(b==true||c2==false||d == true||e==false||f ==false||g==false||h==false||i==false||j==true)
         {
        	 //System.out.println("j"+j);
        	 RequestDispatcher dispacher = request.getRequestDispatcher("ValidationFailed.jsp");
        	 dispacher.forward(request, response);
        	 
         }
         else
         {
		
		try {
			customerservice.SaveCustomerDetails(customer);
			RequestDispatcher dispacher = request.getRequestDispatcher("SuccessInsertCustomerDetails.jsp");
       	 dispacher.forward(request, response);
			//System.out.println("hjdfkjkjkj");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
         }
		
	}

}
