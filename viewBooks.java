import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/viewBooks"})
public class viewBooks extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try 
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
             Statement st4 = conn1.createStatement();
            ResultSet rs = st4.executeQuery("SELECT * FROM book");
            
            out.println("<table border='1'><tr><th>Book ID</th><th>Book Name</th><th>Author Name</th><th>Category</th></tr>");
            while (rs.next()) 
            {
                out.println("<tr><td>" + rs.getInt("BookId") + "</td><td>" + rs.getString("BookName") +
                            "</td><td>" + rs.getString("AuthorName") + "</td><td>" + rs.getString("Category") + "</td></tr>");
            }
            out.println("</table>");
            
            
            
        }catch(ClassNotFoundException | SQLException e)
        {
            out.print("database connection error");
         
        }    
    }

}  