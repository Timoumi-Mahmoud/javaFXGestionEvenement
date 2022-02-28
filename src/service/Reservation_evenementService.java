/*
 Reservation evenement
 */
package service;

import entite.Reservation_evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Datasource;
import entite.User;
import entite.Evenement;
import entite.Reservation;
public class Reservation_evenementService {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    public Reservation_evenementService() {
        conn = Datasource.getInstance().getCnx();
    }
    
    //Reservation_evenement RE=new Reservation_evenement();
   // User U = new User();
    Reservation R=new Reservation();
    public void inserReservation_evenementPst(Reservation_evenement RE, User U, Reservation R ) {
        String req = "insert into Reservation_evenement (ID_user,ID_reservation) values (?,?)";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, U.getID_user());
            pst.setInt(2, R.getID_reservation() );
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /*/*
     public void inserReservation_evenementPst(Reservation_evenement RE  ) {
        String req = "insert into Reservation_evenement (ID_user, ID_reservation) values (?,?)";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, RE.getID_user());
            pst.setInt(2, RE.getID_re());
            pst.setInt(2, RE.getID_reservation());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    */
    
  
    public List<Reservation_evenement> read() {
        
    
                 String req="select * from Reservation_evenement";
                 List<Reservation_evenement> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
 list.add(new Reservation_evenement(rs.getInt("ID_re"), new User(rs.getInt("ID_user")),new Reservation(rs.getInt("ID_reservation")) ));
              
            } 
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
 

  public List<Reservation_evenement> readById(int ID ) {
       List<Reservation_evenement> li=new ArrayList<>();
        String reqs="select ID_user, ID_reservation  from evenement where ID_re=?";
                   
                  try
              {  
            pst=conn.prepareStatement(reqs);
            pst.setInt(1,ID);
            rs= pst.executeQuery();
            while(rs.next()){
                li.add(new Reservation_evenement( new User(rs.getInt("ID_user")), new Reservation(rs.getInt("ID_reservation"))
                    ));
            }
            rs.close();
            pst.close();
                
                }
  catch (SQLException ex)
  {
    Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
  }
           return li;  
        }

   public void update(Reservation_evenement RE, User U, Reservation R ) {
     String updateStatement ="UPDATE evenement SET ID_user= ? ,ID_reservation=?  WHERE ID_re= ? " ; 
        try {
            pst = conn.prepareStatement(updateStatement);
                      
                     pst.setInt(1,U.getID_user());
                     pst.setInt(2, R.getID_reservation());
                     pst.setInt(3, RE.getID_re());
                     
                      int rowUpdate =pst.executeUpdate();
                        System.out.println("Record Update successfully from database. Row Count returned is :: "+ rowUpdate);
        } catch (Exception e) {
             Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, e);
        }
    
    } 
    
    public void delete(Reservation_evenement RE) {

        String Query = "DELETE FROM evenement WHERE ID_re= ?";
              
    try {
             pst = conn.prepareStatement(Query);
             pst.setInt(1, RE.getID_re() );
             int rowCount = pst.executeUpdate();
             System.out.println("Record Deleted successfully from database. Row Count returned is :: "+ rowCount);
        } catch (SQLException e) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, e);
        }
    
    
    }
     
}
