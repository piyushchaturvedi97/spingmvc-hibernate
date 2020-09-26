package com.piyush.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// setup connection variables
				String user = "hbstudent";
				String pass = "hbstudent";

				String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
				String driver = "com.mysql.jdbc.Driver";
				
				// get connection to database
				try {
					PrintWriter out = response.getWriter();
					
					out.println("Connecting to database:" + jdbcUrl);

					Class.forName(driver);
					
					Connection myConn = DriverManager.getConnection(jdbcUrl,user, pass);
				   
					out.println("SUCCESS!jh");
					
					myConn.close();
				}
				
				catch(Exception ex) {
					ex.printStackTrace();
					throw new ServletException(ex);
				}
				
	}

}
