import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet
{

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
      
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
         int bId3 = Integer.parseInt(request.getParameter("bookId"));
       
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
             String query3 = "DELETE FROM book WHERE BookId=?";
            PreparedStatement ps3 = conn.prepareStatement(query3);
            ps3.setInt(1, bId3);
            int count3 =ps3.executeUpdate();
            if(count3 >0)
            {
                out.print("<h3 style='color:green'>book deleted</h3>");
                
                RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                rd.include(request, response);
            }
            else
            {
                out.print("<h3 style='color:red'>book not deleted</h3>");
                
                RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                rd.include(request, response); 
            }
            
        }catch(ClassNotFoundException | SQLException | ServletException | IOException e)
        {
            out.print("database connection error");
         
        }
    }
}
    