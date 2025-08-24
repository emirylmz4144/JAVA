package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Database {

    //Singleton Design Pattern

    private static Database instance=null;
    private Connection connection=null;
    private final String jdbcUrl="jdbc:postgresql://localhost:5432/OrderMenagmentSystem";
    private final String userName="postgres";
    private final String password="emirEmir41";

    private Database(){
        try {
            connection=DriverManager.getConnection(jdbcUrl,userName,password);
            System.err.println("Veri tabanina basari ile baglanildi");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Veri tabanina baglanirken bir problem olustu");
        }
    }

    private Connection getConnection(){
        return this.connection;
    }

    public static Connection getInstance(){
        try {
            if (instance==null || instance.getConnection().isClosed()) {
                instance=new Database();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance.getConnection();
    }
}
