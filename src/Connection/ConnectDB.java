
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectDB {    
    private static Connection instance;
    
    private ConnectDB(){};
    
    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/thang2", "root", "kien12051998");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static Connection openconnect(){
        return instance;
    }
    
}
