package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class DisplayCustomerDetailsController
 */
@WebServlet("/DisplayCustomerDetailsController")
public class DisplayCustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCustomerDetailsController() {
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
		PrintWriter writer =response.getWriter();
		String value =request.getParameter("display");
		String customercode=request.getParameter("customercode");
		//ICustomerDao customerdao = new CustomerRDBMSImpl();
		ICustomerService customerservice = new CustomerRDBMSImplService();
		HttpSession session = request.getSession(false);
		
		if(value.equals("Display"))
		{
		try {
			ArrayList<Customer> customerlist = customerservice.DisplayCustomerDetails();
			session.setAttribute("sn","sn1");
			session.setAttribute("customerlist", customerlist);
			RequestDispatcher dispacher = request.getRequestDispatcher("DisplayCustomerDetails.jsp");
			dispacher.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else if(value.equals("DisplayDetails"))
		{
			System.out.println("hhs");
			try {
				Customer customer = customerservice.DispalyCustomerDetailsByCode(customercode);
				session.setAttribute("sn","sn2");
				session.setAttribute("customer", customer);
				RequestDispatcher dispacher = request.getRequestDispatcher("DisplayCustomerDetails.jsp");
				dispacher.forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
