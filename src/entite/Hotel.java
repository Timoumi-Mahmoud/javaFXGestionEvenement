/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package entite;

import java.util.Objects;
/**
 *
 * @author lenovo
 */


public class Hotel  {
    public int ID_hotel ;
    private  String Nom;
    private  String  Adresse;
    private String Ville;
    private int Code_postal;
    private String Complement_adresse;
    private String Pays;
    private  int Nombre_etoile;

    public Hotel() {
    }

    public Hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
    }


    public Hotel(int ID_hotel, String Nom, String Adresse, String Ville, int Code_postal, String Complement_adresse, String Pays, int Nombre_etoile) {
        this.ID_hotel = ID_hotel;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Ville = Ville;
        this.Code_postal = Code_postal;
        this.Complement_adresse = Complement_adresse;
        this.Pays = Pays;
        this.Nombre_etoile = Nombre_etoile;
    }

    public Hotel(String Nom, String Adresse, String Ville, int Code_postal, String Complement_adresse, String Pays, int Nombre_etoile) {
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Ville = Ville;
        this.Code_postal = Code_postal;
        this.Complement_adresse = Complement_adresse;
        this.Pays = Pays;
        this.Nombre_etoile = Nombre_etoile;
    }

    public int getID_hotel() {
        return ID_hotel;
    }

    public void setID_hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public int getCode_postal() {
        return Code_postal;
    }

    public void setCode_postal(int Code_postal) {
        this.Code_postal = Code_postal;
    }

    public String getComplement_adresse() {
        return Complement_adresse;
    }

    public void setComplement_adresse(String Complement_adresse) {
        this.Complement_adresse = Complement_adresse;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    public int getNombre_etoile() {
        return Nombre_etoile;
    }

    public void setNombre_etoile(int Nombre_etoile) {
        this.Nombre_etoile = Nombre_etoile;
    }

@Override
    public String toString() {
        return "Hotel{" + "ID_hotel: " + ID_hotel + "\n" +'}';
    }
}

