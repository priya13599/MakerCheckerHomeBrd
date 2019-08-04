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
 * Servlet implementation class SortCustomerDetailsController1
 */
@WebServlet("/SortCustomerDetailsController1")
public class SortCustomerDetailsController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortCustomerDetailsController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
         PrintWriter writer =response.getWriter();
		
		
		//ICustomerDao customerdao = new CustomerRDBMSImpl();
         ICustomerService customerservice = new CustomerRDBMSImplService();
		HttpSession session = request.getSession(false);
		try {
			ArrayList<Customer> customerlist = customerservice.SortDescendingCustomerDetails();
			session.setAttribute("sn","sn2");
			session.setAttribute("customerlist", customerlist);
			RequestDispatcher dispacher = request.getRequestDispatcher("SortCustomerDetails.jsp");
			dispacher.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
