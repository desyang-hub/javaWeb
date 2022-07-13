import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection con;

    public DAO() {
        con = DBConnect.getConnection();
    }

    public List<Website> searchAll() {
        List<Website> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sqlSentence = "select * from websites";
            ResultSet rs = statement.executeQuery(sqlSentence);

            while(rs.next()) {
                Website site = new Website();
                site.setId(rs.getInt("id"));
                site.setUrl(rs.getString("url"));
                site.setAlexa(rs.getInt("alexa"));
                site.setCountry(rs.getString("country"));
                site.setName(rs.getString("name"));
                list.add(site);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public void add() {

        try {
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.execute("insert into user values('1234@qq.com', 'acc', 'pass')");
            statement.execute("insert into user values('22@qq.com', 'asdkfkasdf', '134')");
            con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(String acc, String pass) {

        try {
            PreparedStatement statement = con.prepareStatement("select * from user where Username = ? and " +
                    "Password = ?");

            statement.setString(1, acc);
            statement.setString(2, pass);

            ResultSet set = statement.executeQuery();

            while(set.next()) {
                System.out.println("登录成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Statement statement = con.createStatement();
//            String sql = "select * from user where Username = '" + acc + "' and Password = '"
//                    + pass + "'";
//            System.out.println(sql);
//            ResultSet set = statement.executeQuery(sql);
//
//            while(set.next()) {
//                System.out.println("登录成功");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
