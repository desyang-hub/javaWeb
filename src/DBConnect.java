import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/new_database";

    public static void main(String[] args) {

        try {
            Connection con = getConnection();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, "root", "s;kAgHKbZ2Z");
            System.out.println("连接成功！");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
