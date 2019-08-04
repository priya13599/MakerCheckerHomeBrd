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

import com.nucleus.dao.IUserService;
import com.nucleus.dao.UserRDBMSImplService;
import com.nucleus.entity.User;

/**
 * Servlet implementation class UserLoginContoller
 */
@WebServlet("/UserLoginContoller")
public class UserLoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLoginContoller() {
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
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String value= request.getParameter("button");
		User user = new User();
		user.setUserId(userid);
		user.setPassword(password);
		user.setRole(role);
		//UserDao userdao = new UserRDBMSImpl();
		IUserService userservice = new UserRDBMSImplService();
		
		
		if(value.equals("Log In"))
		{
				try {
			User user1 = userservice.checkmakerlogindetails(user);
			String flag = user.getFlag();
			if(flag ==null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("password", password);
				userservice.updatedetails(user1);
				out.println("Login Successfully");
				RequestDispatcher requestdispacher = request.getRequestDispatcher("MakerFunctions.jsp");
				requestdispacher.forward(request,response);
			}
			
			else if(flag.equals("Active"))
			{
				request.setAttribute("flag", flag);
				RequestDispatcher rd = request.getRequestDispatcher("NotSuccess.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		  
		
		else if(value.equals("Register"))
		{
			try {
				userservice.insertcheckermakerlogindetails(user);
				HttpSession session= request.getSession();
				session.setAttribute("userid", userid);
				RequestDispatcher requestdispacher = request.getRequestDispatcher("RegisterSuccessfully.jsp");
				requestdispacher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
