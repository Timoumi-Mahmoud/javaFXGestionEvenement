
package service;
import entite.Evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Datasource;
import entite.Hotel;
import java.time.LocalDate;

public class EvenementService {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    public EvenementService() {
        conn = Datasource.getInstance().getCnx();
    }
    Evenement E=new Evenement();
   /* String str="2022-02-15";  
        String str2="2022-02-17"; 
        Date date1=Date.valueOf(str);//converting string into sql date       
        Date date2=Date.valueOf(str2);*/

    public void inserEvenementPst(Evenement E , Hotel h) { 
        LocalDate Start_date = LocalDate.now();
        LocalDate End_date = LocalDate.now();
        String req = "insert into evenement (Nom,Type,Date_debut,Date_fin,Prix, ID_hotel, Nombre_Participants) values (?,?,?,?,?,?,?)";
        try {
           /* pst = conn.prepareStatement(req);
            pst.setString(1, E.getNom());  
            pst.setString(2, E.getType());
            pst.setDate(3, E.getDate_debut());
            pst.setDate(4, E.getDate_fin());
            pst.setFloat(5,E.getPrix());
            pst.setInt(6, h.getID_hotel());  
            pst.setInt(7, E.getNombre_Participants());
            pst.executeUpdate();*/
              pst = conn.prepareStatement(req);
            pst.setString(1, E.getNom());  
            pst.setString(2, E.getType());
           
            pst.setDate(3, java.sql.Date.valueOf(Start_date) );
            pst.setDate(4, java.sql.Date.valueOf(End_date) );
            pst.setInt(5,E.getPrix());
            pst.setInt(6, h.getID_hotel());  
            pst.setInt(7, E.getNombre_Participants());
            pst.executeUpdate();
            System.out.println("Evenement ajuter !!");
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  

public List<Evenement> read() {
    
   String req="select * from evenement ";
   //String req="select * from evenement  where evenement.ID_hotel=hotel.ID_hotel";
   List<Evenement> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                 Hotel h =new Hotel();
               list.add(new Evenement( rs.getInt("ID_evenement"), rs.getString("nom"), rs.getString("Type"), rs.getDate("Date_debut").toLocalDate(), 
                       rs.getDate("Date_fin").toLocalDate(), rs.getInt("Prix") , new Hotel(rs.getInt("ID_hotel")), rs.getInt("Nombre_Participants")/*rs.getInt(h.getID_hotel())*/ ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //************Read by id functon*********************************
    public List<Evenement> readById(int ID ) {
       List<Evenement> li=new ArrayList<>();
        String reqs="select * from evenement where ID_evenement=?";         
          try
            {  
            pst=conn.prepareStatement(reqs);
            pst.setInt(1,ID);
            rs= pst.executeQuery();
            while(rs.next()){
                li.add(new Evenement( rs.getInt("ID_evenement"), rs.getString("nom"), rs.getString("Type"), rs.getDate("Date_debut").toLocalDate(), 
                       rs.getDate("Date_fin").toLocalDate(), rs.getInt("Prix") , new Hotel(rs.getInt("ID_hotel")), rs.getInt("Nombre_Participants")/*rs.getInt(h.getID_hotel())*/ ));
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

    
    /*********************UPDATE************************/
    public void update(Evenement E, Hotel h) {
     String updateStatement ="UPDATE evenement SET Nom= ? ,Type=?, Prix=?, Date_Debut=?, Date_Fin=? ,Nombre_Participants=?, ID_hotel=? WHERE ID_evenement= ? " ; 
 LocalDate Start_date = LocalDate.now();
 LocalDate End_date = LocalDate.now();
        try {
            pst = conn.prepareStatement(updateStatement);                     
                pst.setString(1,E.getNom());
                pst.setString(2, E.getType());
                pst.setInt(3, E.getPrix());
                pst.setDate(4,java.sql.Date.valueOf(End_date));
                pst.setDate(5, java.sql.Date.valueOf(End_date));
                pst.setInt(6, E.getNombre_Participants());
                pst.setInt(7, h.getID_hotel());
                pst.setInt(8,E.getID_evenement()); 
        pst.executeUpdate();
        System.out.println("Record Update successfully from database.:!!: ");
        } catch (Exception e) {
             Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
   
       
  /*********************DELETE************************/
     public void delete(Evenement E, int id) {
        String Query = "DELETE FROM evenement WHERE ID_evenement= ?";
    try {
             pst = conn.prepareStatement(Query);
             ///pst.setInt(1, E.getID_evenement());
             pst.setInt(1,id);   //delete the rows where ID_eventemnet=104
             pst.executeUpdate();
             System.out.println("Record Deleted successfully from database.!! ");
        } catch (SQLException e) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, e);
        }
     }
    
    
    /*********************SORT_BY_PRICE************************/
    public List<Evenement> OrderbyPrice(){
        List<Evenement> li=new ArrayList<>();
        String reqs="select * from evenement ORDER BY Prix DESC";
          try
            {  
            pst=conn.prepareStatement(reqs);
         
            rs= pst.executeQuery();
            while(rs.next()){
                li.add(new Evenement( rs.getInt("ID_evenement"), rs.getString("nom"), rs.getString("Type"), rs.getDate("Date_debut").toLocalDate(), 
                       rs.getDate("Date_fin").toLocalDate(), rs.getInt("Prix") , new Hotel(rs.getInt("ID_hotel")), rs.getInt("Nombre_Participants")/*rs.getInt(h.getID_hotel())*/ ));
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

    /************check if an events is full or not , by checking the number of paticitant*******************/
public void Disponible(Evenement E){
    
    String sql = "SELECT Nombre_Participants, Nom " +
             "FROM evenement";

try {
             pst=conn.prepareStatement(sql);
            
            rs= pst.executeQuery();
            while(rs.next()){
                    if(rs.getInt("Nombre_Participants") > 50){
                        
                        System.out.println("n'est pas disponible:    "+ rs.getString("Nom")); }
                    else{
                        System.out.println("Disponible:    "+rs.getString("Nom")); }
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

///////////////////////////////////////////////////////
 /*    //search for events where date debut is still open 
public List<Evenement> CheckDate( ) {
       List<Evenement> li=new ArrayList<>();
        //String reqs="select Nom, Type, Date_debut, Date_fin, Prix, ID_hotel from evenement where Date_debut> ";
        //String reqs="SELECT * FROM evenement WHERE date(Date_debut) = CURDATE() ";
          String reqs="SELECT * FROM evenement WHERE date(Date_debut) = CURDATE() INTERVAL 40 day"; 
          try
            {  
            pst=conn.prepareStatement(reqs);
            //pst.setDate(1,D1);
            rs= pst.executeQuery();
            while(rs.next()){
                li.add(new Evenement( rs.getInt("ID_evenement"), rs.getString("nom"), rs.getString("Type"),
                    rs.getDate("Date_debut"), rs.getDate("Date_fin"), rs.getInt("Prix"),  new Hotel(rs.getInt("ID_hotel")),rs.getInt("ID_hotel")));
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
*/
       //************* order by the price of the events ***************
     /*public void Orderbyf(Evenement E){
        
        
        List<Evenement> li=new ArrayList<>();
        String reqs="SELECT * FROM `evenement` ORDER BY `evenement`.`Prix` ASC ";
                   
          
    try {
             pst = conn.prepareStatement(reqs);
             //pst.setInt(1,104);   //delete the rows where ID_eventemnet=3
          
            pst.executeUpdate();
             System.out.println("Record was sorted successfully from database. Row Count returned is :: ");
        } catch (SQLException e) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        
    }*/ 

/*********************SEARCH BY NAME OR SOME CARRACTER OF THAT NAME ************************/
public List<Evenement>  Search(String name){
     List<Evenement> li=new ArrayList<>();
    
      String q=  "SELECT * FROM evenement where  Nom like ('%'  ? '%')";
try {
            pst=conn.prepareStatement(q);
            pst.setString(1,name);
            rs= pst.executeQuery();
           
           
            while(rs.next()){
                 Hotel h =new Hotel();
               /*System.out.println(rs.getInt("ID_evenement")+ rs.getString("nom")+ rs.getString("Type")+ 
                    rs.getDate("Date_debut")+ rs.getDate("Date_fin")+ rs.getInt("Prix") + new Hotel(rs.getInt("ID_hotel"))+ rs.getInt("Nombre_Participants")) ;
                */
               li.add(new Evenement( rs.getInt("ID_evenement"), rs.getString("nom"), rs.getString("Type"), rs.getDate("Date_debut").toLocalDate(), 
                       rs.getDate("Date_fin").toLocalDate(), rs.getInt("Prix") , new Hotel(rs.getInt("ID_hotel")), rs.getInt("Nombre_Participants")/*rs.getInt(h.getID_hotel())*/ ));
            } rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li ;
    }






 













}
    
    
     
    






















