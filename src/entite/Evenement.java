
package entite;
import java.sql.Date;
import java.time.LocalDate;
import entite.Hotel;
import java.time.LocalDate;
public class Evenement {
    private int ID_evenement; 	
    private String Nom ; 	
    private String Type; 	
    private LocalDate Date_debut; 	
    private  LocalDate Date_fin; 	
    private int Prix; 	
    private Hotel ID_hotel;
//Ajouter Nbre des participation
    private int Nombre_Participants;
   // int ID_user;


    //Getters and Setters

    public int getID_evenement() {
        return ID_evenement;
    }

    public String getNom() {
        return Nom;
    }

    public String getType() {
        return Type;
    }

    public LocalDate getDate_debut() {
        return Date_debut;
    }

    public LocalDate getDate_fin() {
        return Date_fin;
    }

    public int getPrix() {
        return Prix;
    }

    public Hotel getID_hotel() {
        return ID_hotel;
    }

    public int getNombre_Participants() {
        return Nombre_Participants;
    }

    public void setID_evenement(int ID_evenement) {
        this.ID_evenement = ID_evenement;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setDate_debut(LocalDate Date_debut) {
        this.Date_debut = Date_debut;
    }

    public void setDate_fin(LocalDate Date_fin) {
        this.Date_fin = Date_fin;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public void setID_hotel(Hotel ID_hotel) {
        this.ID_hotel = ID_hotel;
    }

    public void setNombre_Participants(int Nombre_Participants) {
        this.Nombre_Participants = Nombre_Participants;
    }

    
    //Constractor

    public Evenement() {
    }

    public Evenement(String Nom, String Type, LocalDate Date_debut, LocalDate Date_fin, int Prix, int Nombre_Participants) {
        this.Nom = Nom;
        this.Type = Type;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Prix = Prix;
        this.Nombre_Participants = Nombre_Participants;
    }

    public Evenement(String Nom, String Type, LocalDate Date_debut, LocalDate Date_fin, int Prix, Hotel ID_hotel, int Nombre_Participants) {
        this.Nom = Nom;
        this.Type = Type;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Prix = Prix;
        this.ID_hotel = ID_hotel;
        this.Nombre_Participants = Nombre_Participants;
    }

    public Evenement(int ID_evenement, String Nom, String Type, LocalDate Date_debut, LocalDate Date_fin, int Prix, Hotel ID_hotel, int Nombre_Participants) {
        this.ID_evenement = ID_evenement;
        this.Nom = Nom;
        this.Type = Type;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Prix = Prix;
        this.ID_hotel = ID_hotel;
        this.Nombre_Participants = Nombre_Participants;
    }

    


   

    //AFFICHAGE
    @Override
    public String toString() {
        return "Evenement{" + "Nom: " + Nom + ", Type: " + Type + ", Date_Debut: " + Date_debut + 
                              "Date_fin: "+Date_fin + ", Prix: "+ Prix + "Nombre_Participants: " + Nombre_Participants+ "ID_hotel: "+ ID_hotel + "\n" +'}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.ID_evenement != other.ID_evenement) {
            return false;
        }
        return true;
    }
    
    
}
