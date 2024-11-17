import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class updateBook extends HttpServlet 
{

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        int bId1 = Integer.parseInt(request.getParameter("bookId"));
        String bName1 = request.getParameter("bookName");
        String arName1 = request.getParameter("authorName");
        String cate1 = request.getParameter("category");
        try 
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root", "");
            String query2 = "UPDATE book SET BookName=?, AuthorName=?, Category=? WHERE BookId=?";
            PreparedStatement ps2 = conn.prepareStatement(query2);
           
            ps2.setString(1,bName1);
            ps2.setString(2,arName1);
            ps2.setString(3,cate1);
            ps2.setInt(4,bId1);
            int count2= ps2.executeUpdate();
            
            if(count2>0)
            {
                out.print("<h3 style='color:green'>book updated</h3>");
                
                RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                rd.include(request, response);
            }
            else
            {
                out.print("<h3 style='color:red'>book not updated</h3>");
                
                RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                rd.include(request, response); 
            }
        }catch(ClassNotFoundException | SQLException | ServletException | IOException e)
        {
            out.print("database connection error");
         
        }
    }

}  