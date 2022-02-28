/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ReadGuiController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDate_debut;
    @FXML
    private TextField tfDate_fin;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfNombre_Participants;
    @FXML
    private TextField tfHotel;
    @FXML
    private TextField tfType;

    //private EvenementService EvenementService; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //this.EvenementService = new EvenementService ();
    }    

    public void setTfNom(String value) {
        this.tfNom.setText(value); 
    }

    public void setTfDate_debut(String value) {
        this.tfDate_debut.setText(value);
    }

    public void setTfDate_fin(String value) {
        this.tfDate_fin.setText(value);
    }

    public void setTfPrix(String value) {
        this.tfPrix.setText(value);
    }

    public void setTfNombre_Participants(String value) {
        this.tfNombre_Participants.setText(value);
    }

    public void setTfHotel(String value) {
        this.tfHotel.setText(value);
    }

    public void setTfType(String value) {
        this.tfType.setText(value);
    }
    
  
    
    
    
    
    
    
}
