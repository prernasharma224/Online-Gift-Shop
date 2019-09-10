package forms;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter; 
import java.sql.*;
@WebServlet("/signupp")
public class signupp extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String n=request.getParameter("Full_Name");  
		String p=request.getParameter("Email");
		String c=request.getParameter("Contact");
		String e=request.getParameter("Password");
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Gift";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		Statement s=com.createStatement();
		String query="insert into Seller values('"+n+"','"+p+"','"+c+"','"+e+"')";
		int sql=s.executeUpdate(query);
			if(sql>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("loginn.html");  
                rd.include(request,response);
			}
			else
			{
				
		    } 
		}
		catch (Exception e) { 
			out.println(e);
		} 
		out.close();
	} 
}

