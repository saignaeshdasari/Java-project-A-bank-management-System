
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system", "root", "password");
            s = c.createStatement(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
