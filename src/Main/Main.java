package Main;
import entite.Evenement;
import java.sql.Date;
import service.EvenementService;
import entite.Reservation_evenement;
import service.Reservation_evenementService;
import entite.Evenement;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import service.EvenementService;
import utils.Datasource;
import entite.Hotel;
import entite.Reservation;
import entite.User;
import java.time.LocalDate;


public class Main {
    
  
    public static void main(String[] args) throws ParseException {
            Hotel h=new Hotel(7);
          EvenementService es=new EvenementService();    
          Reservation_evenementService REs=new Reservation_evenementService();
          
        //for date
        String str="2022-02-23";  
        String str2="2020-02-17"; 
        Date date1=Date.valueOf(str);   //converting string into sql date       
        Date date2=Date.valueOf(str2);
        
      //System.out.println(es.read());
        
    //Evenement E3=new Evenement("dssssss", "dTEST",999,10); //new Date(33669999999L)
      //es.inserEvenementPst(E2);
    //Evenement E4= new Evenement("dff", "cmmmm", LocalDate.MAX, 22, 5);
       Evenement E4= new Evenement("dd", "dd", LocalDate.MAX, LocalDate.MIN, 0, h, 0);
       //es.inserEvenementPst(E4, h);
     
       //System.out.println(es.afficher());
       
       System.out.println(es.read());
        //es.update(E3, h);
        //System.out.println(es.readById(122));
        //es.delete(E3);
        //System.out.println(es.OrderbyPrice());      
        // es.Disponible(E3);
        //System.out.println(es.Search("h"));

    
//--------------------------------------------------------------------------------
            User U=new User(4);
            Reservation R= new Reservation(10);
                //Reservation_evenement RE2=new Reservation_evenement(U,R);
                //REs.inserReservation_evenementPst(RE2,U,R);
                //System.out.println(REs.read());
                //REs.delete(RE2);
                //REs.update(RE2, U, R);
                //System.out.println( REs.read());

            
      }
    
}
