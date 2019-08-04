package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class DeleteCustomerDetailsController
 */
@WebServlet("/DeleteCustomerDetailsController")
public class DeleteCustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerDetailsController() {
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
		String customercode = request.getParameter("customercode");
		Customer customer = new Customer();
		HttpSession session = request.getSession(false);
		//ICustomerDao customerdao = new CustomerRDBMSImpl();
		ICustomerService customerservice = new CustomerRDBMSImplService();
		customer.setCustomercode(customercode);
		try {
			customerservice.DeleteCustomerDetails(customer);
			RequestDispatcher dispacher = request.getRequestDispatcher("SuccessDeleteCustomerDetails.jsp");
			dispacher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
