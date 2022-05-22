package cs.db;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionDB {
    public Connection getConnection(){
        try{
            Class.forName("org.h2.Driver");
            Connection cn = DriverManager.getConnection("jdbc:h2:./db/test;DB_CLOSE_DELAY=-1", "sa", "");
            System.out.println("connected to db");
            return cn;
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "Database error: " + err);
            return null;
        }
    }
}