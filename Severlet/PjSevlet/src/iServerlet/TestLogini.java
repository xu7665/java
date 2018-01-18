package iServerlet;

import java.sql.*;

public class TestLogini {
    public void login() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web8","root","123456");
        Statement stmt = conn.createStatement();
        String sql = "select * from web8 where id=1";
        String sql_i = "insert into web8(id,name,password) values(3,'hehe',123)";
        ResultSet rs = stmt.executeQuery(sql);
        int rs_i = stmt.executeUpdate(sql_i);
        System.out.println(sql);
        System.out.println(rs);
        System.out.println(rs_i);



    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestLogini aa = new TestLogini();
        aa.login();
    }

}
