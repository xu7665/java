package iServerlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
public class login extends HttpServlet {
    /**
     *
     */
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web1","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from web1 where username=? and password=?";
        try {
            ResultSet rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
