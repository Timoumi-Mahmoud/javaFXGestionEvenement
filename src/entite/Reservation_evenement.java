
package entite;
public class Reservation_evenement {
    
        private  int ID_re;
        private User ID_user;
        private Reservation ID_reservation;
        

    public int getID_re() {
        return ID_re;
    }

    public User getID_user() {
        return ID_user;
    }

    public Reservation getID_reservation() {
        return ID_reservation;
    }

    public void setID_re(int ID_re) {
        this.ID_re = ID_re;
    }

    public void setID_user(User ID_user) {
        this.ID_user = ID_user;
    }

    public void setID_reservation(Reservation ID_reservation) {
        this.ID_reservation = ID_reservation;
    }

    public Reservation_evenement(int ID_re, User ID_user, Reservation ID_reservation) {
        this.ID_re = ID_re;
        this.ID_user = ID_user;
        this.ID_reservation = ID_reservation;
    }

    public Reservation_evenement(int ID_re, User ID_user) {
        this.ID_re = ID_re;
        this.ID_user = ID_user;
    }

    public Reservation_evenement(User ID_user, Reservation ID_reservation) {
        this.ID_user = ID_user;
        this.ID_reservation = ID_reservation;
    }
        
    @Override
    public String toString() {
        return "Evenement{" + "ID_user: " + ID_user + ", ID_re: " + ID_re + ", ID_reservat"
                + "ion: " + ID_reservation + 
                              "\n" +'}';
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
        if (this.ID_user != other.ID_user  ) {
            return false;
        }
        return true;
    }
    
    
}


    

