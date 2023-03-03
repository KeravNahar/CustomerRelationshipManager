package com.wu.crmdemo.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wu.crmdemo.entity.Customer;

/**
 * Servlet implementation class CustomerDAO
 */
@WebServlet("/CustomerDAO")
public class CustomerDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String databaseDriver="oracle.jdbc.driver.OracleDriver";
	String connectionURL="jdbc:oracle:thin:@localhost:1521:xe";
	String userName="scott";
	String passWord="tiger";
	String sqlQuery="SELECT * FROM Customer";
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				Customer C1= new Customer();
				C1.setFirstName(rs.getString(1));
				C1.setLastName(rs.getString(2));
				C1.setEmailAddress(rs.getString(3));
				customers.add(C1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	public void addCustomer(String firstName,String lastName,String email) {
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			PreparedStatement ps = con.prepareStatement("insert into Customer values(?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			
			int i = ps.executeUpdate();
			System.out.println(i+" Record Added");
			con.commit();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCustomer(String firstName,String lastName,String email,String lastName1) {
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			PreparedStatement stmt = con.prepareStatement("UPDATE Customer SET FIRST_NAME=?,LAST_NAME=?,EMAIL=? WHERE LAST_NAME=?");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, lastName1);
			
			int i = stmt.executeUpdate();
			System.out.println(i+" Record Updated");
			con.commit();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteCustomer(String lastName) {
		try {
			Class.forName(databaseDriver);
			Connection con = DriverManager.getConnection(connectionURL,userName,passWord);
			PreparedStatement ps = con.prepareStatement("DELETE FROM Customer WHERE LAST_NAME=?");
			ps.setString(1, lastName);
			
			int i = ps.executeUpdate();
			System.out.println(i+" Record Deleted");
			con.commit();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}

	

}
