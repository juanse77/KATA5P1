package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        String urlConection = "jdbc:sqlite:KATA5.db";
        Connection connection = DriverManager.getConnection(urlConection);

        Statement statement = connection.createStatement();
        String query = "select * from people";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }

        // query = "CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT,'Mail' TEXT NOT NULL);";
        // statement.execute(query);
        String fileString = "emails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileString)));

        String mail;
        while ((mail = reader.readLine()) != null) {
            if (!mail.contains("@")) {
                continue;
            }
            System.out.println(mail);
            
            query = "INSERT INTO MAIL (Mail) VALUES ('" + mail + "')";
            statement.execute(query);
        }
    }

}
