import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addBook")
public class addBook extends HttpServlet
{

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
       
        int bId = Integer.parseInt(request.getParameter("bookId"));
        String bName = request.getParameter("bookName");
        String arName = request.getParameter("authorName");
        String cate = request.getParameter("category");
        response.setContentType("text/html;charset=UTF-8");
        try  
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root", "");
            String query1 = "INSERT INTO book VALUES (?,?, ?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(query1);
            ps1.setInt(1,bId);
            ps1.setString(2,bName);
            ps1.setString(3,arName);
            ps1.setString(4,cate);
            int count1= ps1.executeUpdate();
            
            if(count1>0)
            {
                out.print("<h3 style='color:green'>book added</h3>");
                
                RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                rd.include(request, response);
            }else
            {
                out.print("<h3 style='color:red'>book not added</h3>");
                
                RequestDispatcher rd= request.getRequestDispatcher("/index.html");
                rd.include(request, response); 
            }
            
        }catch(ClassNotFoundException | SQLException | ServletException | IOException e)
        {
            out.print("database connection error");
        }
    }
}

   