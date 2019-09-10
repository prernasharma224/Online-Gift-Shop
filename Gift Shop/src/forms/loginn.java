package forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.lang.ClassNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginn")
public class loginn extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{ 
		PreparedStatement ps;  
	    ResultSet rs; 
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();  
		try
		{   
		String e=request.getParameter("Email");
		String p=request.getParameter("Password");
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Gift";
		String password="root";
		String username="root";
		Class.forName(driver);
		Connection com=DriverManager.getConnection(url,username,password);
		pw.println("<html><body>"); 
		
               ps=com.prepareStatement("select * from Seller where Email=? and Passwords=?");  
               ps.setString(1, e);  
               ps.setString(2, p);  
               rs=ps.executeQuery(); 
               
             if(rs.next())  
               {  
            	   RequestDispatcher rd=request.getRequestDispatcher("profile.html");  
                   rd.forward(request,response);   
               }
               else
               {
            	    
                   RequestDispatcher rd=request.getRequestDispatcher("loginn.html");  
                   rd.include(request,response);  
                   pw.println("<script type=\"text/javascript\">"); 
            	   pw.println("alert(\"Invalid username/Password\")"); 
            	   pw.println("</script>");
               }
		
		
         }
		 catch (SQLException | ClassNotFoundException e)   
         {  
         e.printStackTrace();  
         }  
		}
	}

		
	