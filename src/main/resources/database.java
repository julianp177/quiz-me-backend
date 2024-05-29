import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://hostname:3306/databaseName";
            String user = "username";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Verbunden mit der Datenbank!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
