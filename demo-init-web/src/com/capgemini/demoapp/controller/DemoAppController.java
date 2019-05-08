package com.capgemini.demoapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int number1;
	int number2=45;

	public DemoAppController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		number1 = Integer.parseInt(config.getInitParameter("num1"));
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		int result = number1 + number2;
		writer.println("<h2>Addition is :" + result + "</h2>");
	}
}
