package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datasource {
    private  String url="jdbc:mysql://localhost:3306/joy_bd"; 
    private  String login="root";
    private  String pwd="";
    
    private  Connection cnx;                                   
    private static Datasource instance;                    
   
    private Datasource() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);      
        
        } catch (SQLException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public static Datasource getInstance(){   
         if(instance==null)                   
             instance=new Datasource();        
         return instance;                   
    }

    public Connection getCnx() {    
        return cnx;    
    }
   
   
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

