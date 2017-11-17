package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String urlConection = "jdbc:sqlite:KATA5.db";
        Connection connection = DriverManager.getConnection(urlConection);
        
        Statement statement = connection.createStatement();
        String query = "select * from people";
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
    }
    
}
