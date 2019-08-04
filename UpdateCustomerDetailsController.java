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

/**
 * Servlet implementation class UpdateCustomerDetailsController
 */
@WebServlet("/UpdateCustomerDetailsController")
public class UpdateCustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerDetailsController() {
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
		PrintWriter writer = response.getWriter();
		String customercode = request.getParameter("customercode");
		//ICustomerDao customerdao = new CustomerRDBMSImpl();
		ICustomerService customerservice = new CustomerRDBMSImplService();
		try {
			Customer customer =customerservice.updatecustomerDetails(customercode);
			HttpSession session = request.getSession(false);
			session.setAttribute("customercode",customer.getCustomercode());
			session.setAttribute("customername",customer.getCustomername());
			session.setAttribute("address1",customer.getAddress1());
			session.setAttribute("address2", customer.getAddress2());
			session.setAttribute("pincode",customer.getCustomerpincode());
			session.setAttribute("email",customer.getEmailaddress());
			session.setAttribute("contactno",customer.getContactno());
			session.setAttribute("status",customer.getRecord_status());
			session.setAttribute("contactperson",customer.getPrimary_contact_person());
			session.setAttribute("flag", customer.getActive_inactive_flag());
		    session.setAttribute("createdate",customer.getCreate_date());	
			session.setAttribute("createdby",customer.getCreated_by());
			RequestDispatcher dispacher = request.getRequestDispatcher("UpdateCustomerDetailsForm.jsp");
			dispacher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
