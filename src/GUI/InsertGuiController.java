/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Evenement;
import entite.Hotel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class InsertGuiController implements Initializable {

    @FXML
    private TextField TextFieldNom;
    @FXML
    private TextField TextFieldType;
    @FXML
    private TextField TextFieldPrix;
    @FXML
    private TextField TextFieldNombre_Participants;
    @FXML
    private TextField TextFieldHotel;
    @FXML
    private Button btnSubmit;
    
    private EvenementService EvenementService; 
    @FXML
    private DatePicker DatePickerDate_debut;   ///for setting the date 
    @FXML
    private DatePicker DatePickerDate_fin;     //for setting the end date

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.EvenementService = new EvenementService ();
     
        
    }    

    @FXML
    private void onCreate(ActionEvent event) {
     
      Hotel h=new Hotel();
      //int f=h.getID_hotel();
     // f=Integer.parseInt(TextFieldHotel.getText());
      //  try {
      String Nom = TextFieldNom.getText();
      String Type =TextFieldType.getText();
      LocalDate Date_debut=DatePickerDate_debut.getValue();
      LocalDate Date_fin=DatePickerDate_fin.getValue();
      int Prix =Integer.parseInt(TextFieldPrix.getText());
      int Nombre_Participants =Integer.parseInt(TextFieldNombre_Participants.getText());
      h.ID_hotel = Integer.parseInt(TextFieldHotel.getText());
      
      Evenement E1=new Evenement(Nom, Type, Date_debut, Date_fin, Prix, h, Nombre_Participants);
      EvenementService.inserEvenementPst(E1,h);
    
        FXMLLoader loader =new FXMLLoader(getClass().getResource("ReadGui.fxml"));
          
         
          try {
          Parent root = loader.load();
          ReadGuiController  controller= loader.getController();
          controller.setTfNom(Nom);
          controller.setTfType(Type);
          controller.setTfDate_debut(Date_debut.toString());
          controller.setTfDate_fin(Date_fin.toString());
          controller.setTfPrix(String.valueOf(Prix)); 
          controller.setTfNombre_Participants(Nombre_Participants +"");
          controller.setTfHotel(h+"");
     
          
        TextFieldNom.getScene().setRoot(root);
     
         
          
          
          

        
          } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }


        
        //} catch (NumberFormatException ex) {
          //  System.out.println(ex.getMessage());
//return; 
       // }*/
        
        
    }

    private void goDelete(ActionEvent event) throws IOException {
        Parent  DeleteParent= FXMLLoader.load(getClass().getResource("DeleteGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
    }

    private void GoUpdate(ActionEvent event)throws IOException {
     
        
         Parent  DeleteParent= FXMLLoader.load(getClass().getResource("UpdateGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
    }  

    @FXML
    private void GoHome(ActionEvent event) throws IOException {
        
         Parent  DeleteParent= FXMLLoader.load(getClass().getResource("MENUGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
        
        
        
        
    }
    
    
    
     
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

/*
       Node node = (Node) event.getSource();
    Stage thisStage = (Stage) node.getScene().getWindow();     
        */
        