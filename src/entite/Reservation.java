/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.time.LocalDate;

  
public class Reservation {
//ID_reservation`, `Date_reservation`, `Date_arrivee`, 
    //`Date_depart`, `ID_user`, `ID_chambre`, `ID_formule`, `Nbr_personnes`, `Prix_total`)

    private int ID_reservation;
    private LocalDate Date_reservation;
    private LocalDate Date_arrivee;
    private LocalDate Date_depart;
    private User user;
   // private Chambre chambre;
    //private Formule formule;
    private int Nbr_personnes;
    private float Prix_total;

    public Reservation() {
    }

   /* public Reservation(int ID_reservation, LocalDate Date_reservation, LocalDate Date_arrivee, LocalDate Date_depart, User user, Chambre chambre, Formule formule, int Nbr_personnes, float Prix_total) {
        this.ID_reservation = ID_reservation;
        this.Date_reservation = Date_reservation;
        this.Date_arrivee = Date_arrivee;
        this.Date_depart = Date_depart;
        this.user = user;
        //this.chambre = chambre;
        //this.formule = formule;
        this.Nbr_personnes = Nbr_personnes;
        this.Prix_total = Prix_total;
    }*/

    public Reservation(int ID_reservation) {
        this.ID_reservation = ID_reservation;
    }

    /*public Reservation(LocalDate Date_reservation, LocalDate Date_arrivee, LocalDate Date_depart, User user, Chambre chambre, Formule formule, int Nbr_personnes, float Prix_total) {
        this.Date_reservation = Date_reservation;
        this.Date_arrivee = Date_arrivee;
        this.Date_depart = Date_depart;
        this.user = user;
      //  this.chambre = chambre;
    //    this.formule = formule;
        this.Nbr_personnes = Nbr_personnes;
        this.Prix_total = Prix_total;
    }
    

    public Reservation(LocalDate Date_arrivee, LocalDate Date_depart, Chambre chambre, Formule formule, int Nbr_personnes, float Prix_total) {
        this.Date_arrivee = Date_arrivee;
        this.Date_depart = Date_depart;
       // this.chambre = chambre;
       // this.formule = formule;
        this.Nbr_personnes = Nbr_personnes;
        this.Prix_total = Prix_total;
    }
    */

    public int getID_reservation() {
        return ID_reservation;
    }

    public void setID_reservation(int ID_reservation) {
        this.ID_reservation = ID_reservation;
    }

    public LocalDate getDate_reservation() {
        return Date_reservation;
    }

    public void setDate_reservation(LocalDate Date_reservation) {
        this.Date_reservation = Date_reservation;
    }

    public LocalDate getDate_arrivee() {
        return Date_arrivee;
    }

    public void setDate_arrivee(LocalDate Date_arrivee) {
        this.Date_arrivee = Date_arrivee;
    }

    public LocalDate getDate_depart() {
        return Date_depart;
    }

    public void setDate_depart(LocalDate Date_depart) {
        this.Date_depart = Date_depart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   // public Chambre getChambre() {
     //   return chambre;
    //}
/*
    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }*/

   // public Formule getFormule() {
    //    return formule;
    //}

   // public void setFormule(Formule formule) {
   //     this.formule = formule;
   // }/*
/*
    public int getNbr_personnes() {
        return Nbr_personnes;
    }

    public void setNbr_personnes(int Nbr_personnes) {
        this.Nbr_personnes = Nbr_personnes;
    }

    public float getPrix_total() {
        return Prix_total;
    }

    public void setPrix_total(float Prix_total) {
        this.Prix_total = Prix_total;
    }*/

    @Override
    public String toString() {
        return "Reservation{" + "ID_reservation=" + ID_reservation +  '}';
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        return hash;
//    }
   /* @Override
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
        final Reservation other = (Reservation) obj;
        if (this.ID_reservation != other.ID_reservation) {
            return false;
        }
        return true;
    }*/

}