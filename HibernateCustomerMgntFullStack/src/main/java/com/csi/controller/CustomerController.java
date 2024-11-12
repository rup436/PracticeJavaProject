package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import com.csi.service.CustomerServiceImpl;
import com.ibm.icu.text.SimpleDateFormat;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOWDATA_PAGE = "/show.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirect = "";

		String custName = request.getParameter("custname");
		String action = request.getParameter("action");

		if (custName != null && action.equals("signup")) {
			String custAddress = request.getParameter("custaddress");
			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));
			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));
			String custGender = request.getParameter("custgender");
			Date custDOBDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				custDOBDate = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custName, custAddress, custContactNumber, custAccountBalance, custGender,
					custDOBDate, custEmailId, custPassword);

			customerServiceImpl.signUp(customer);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {
			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("customerList", customerServiceImpl.getAllData());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Invalid Credentials Please try again!!!!!");
				redirect = SIGNIN_PAGE;
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);

		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
