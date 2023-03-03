package com.wu.crmdemo.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDB() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String databaseDriver="oracle.jdbc.driver.OracleDriver";
		String connectionURL="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="scott";
		String passWord="tiger";
		String sqlQuery="SELECT * FROM Emp";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting with database by......."+connectionURL);
			
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			out.println("Connection with database successful");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
