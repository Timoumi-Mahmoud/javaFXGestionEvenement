/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import java.util.Objects;
/**
 *
 * @author lenovo
 */
public class User {
    private int ID_user;
    private String Email;
    private int Tel; 
    private int Cin;
    private int Is_Admin ;
    private String Password ;
    private String Token;

    public User(int ID_user, String Email, int Tel, int Cin, int Is_Admin, String Password, String Token) {
        this.ID_user = ID_user;
        this.Email = Email;
        this.Tel = Tel;
        this.Cin = Cin;
        this.Is_Admin = Is_Admin;
        this.Password = Password;
        this.Token = Token;
    }

    public User(String Email, int Tel, int Cin, int Is_Admin, String Password, String Token) {
        this.Email = Email;
        this.Tel = Tel;
        this.Cin = Cin;
        this.Is_Admin = Is_Admin;
        this.Password = Password;
        this.Token = Token;
    }

    public User(int ID_user) {
        this.ID_user = ID_user;
    }

    public User() {
    }

    
   

    public int getID_user() {
        return ID_user;
    }

    public void setID_user(int ID_user) {
        this.ID_user = ID_user;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public int getIs_Admin() {
        return Is_Admin;
    }

    public void setIs_Admin(int Is_Admin) {
        this.Is_Admin = Is_Admin;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    @Override
    public String toString() {
        return "User{" + "ID_user=" + ID_user + ", Email=" + Email + ", Tel=" + Tel + ", Cin=" + Cin + ", Is_Admin=" + Is_Admin + ", Password=" + Password + ", Token=" + Token + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final User other = (User) obj;
        if (this.ID_user != other.ID_user) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return true;
    }
    
    /*
 @Override
    public String toString() {
        return "User{" + "ID_User: " + ID_user + "\n" +'}';
    }   
    */
    
}