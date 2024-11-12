package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    String SIGNUP_PAGE ="/signup.jsp";
    String SIGNIN_PAGE ="/signin.jsp";
    String EDITDATA_PAGE= "/edit.jsp";
    String SHOWDATA_PAGE="/show.jsp";
    
    CustomerService customerServiceImpl = new CustomerServiceImpl();
    
    public CustomerController() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect = "";

		String custName = request.getParameter("custname");
		String action = request.getParameter("action");

		if (action.equals("signup") && custName != null) {

			String custAddress = request.getParameter("custaddress");
			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));
			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));
			String custGender = request.getParameter("custgender");
			Date custDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custName, custAddress, custContactNumber, custAccountBalance, custGender,
					custDOB, custEmailId, custPassword);

			customerServiceImpl.signUp(customer);
			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {

				request.setAttribute("customerList", customerServiceImpl.getAllData());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Invalid Credentials Please try again!!!!");
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;
		} else if (action.equals("edit")) {

			int custId = Integer.parseInt(request.getParameter("custid"));

			String customerName = request.getParameter("custname");
			String custAddress = request.getParameter("custaddress");
			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));
			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));
			String custGender = request.getParameter("custgender");
			Date custDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(customerName, custAddress, custContactNumber, custAccountBalance,
					custGender, custDOB, custEmailId, custPassword);

			customerServiceImpl.updateData(custId, customer);

			request.setAttribute("customerList", customerServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("delete")) {

			int custId = Integer.parseInt(request.getParameter("custid"));

			customerServiceImpl.deleteDataById(custId);

			request.setAttribute("customerList", customerServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {

			customerServiceImpl.deleteAllData();
			request.setAttribute("customerList", customerServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("customerList", customerServiceImpl.sortByCustName());

			redirect = SHOWDATA_PAGE;
		} else if (action.equals("sortbyaccountbalance")) {

			request.setAttribute("customerList", customerServiceImpl.sortByAccountBalance());

			redirect = SHOWDATA_PAGE;
		} else if (action.equals("sortbydob")) {

			request.setAttribute("customerList", customerServiceImpl.sortByDOB());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyname")) {

			String customerName = request.getParameter("custname");

			request.setAttribute("customerList", customerServiceImpl.filterByName(customerName));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyaccountbalance")) {

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			request.setAttribute("customerList", customerServiceImpl.filterByAccountBalance(custAccountBalance));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyid")) {

			int custId = Integer.parseInt(request.getParameter("custid"));

			
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customerServiceImpl.getDataById(custId));
			request.setAttribute("customerList", customers);

			redirect = SHOWDATA_PAGE;

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
