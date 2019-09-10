package forms;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.PrintWriter; 
import java.sql.*;

public class pay extends HttpServlet { 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try
		{ 
		String n=request.getParameter("fullname");  
		String p=request.getParameter("email");
		String c=request.getParameter("address");
		String e=request.getParameter("city");
		String a=request.getParameter("state");
		String t=request.getParameter("zip");
		String d=request.getParameter("cardname");
		String f=request.getParameter("cardnumber");
		String g=request.getParameter("expmonth");
		String h=request.getParameter("expyear");
		String i=request.getParameter("cvv");
		
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Gift";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		Statement s=com.createStatement();
		String query="insert into payment values('"+n+"','"+p+"','"+c+"','"+e+"','"+a+"','"+t+"','"+d+"','"+f+"','"+g+"','"+h+"','"+i+"')";
		int sql=s.executeUpdate(query);
			if(sql>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("payment.html");  
                rd.include(request,response);
			}
			else
			{
				out.print("Order Placed Successfully");
		    } 
		}
		catch (Exception e) { 
			out.println(e);
		} 
		out.close();
	} 
}

