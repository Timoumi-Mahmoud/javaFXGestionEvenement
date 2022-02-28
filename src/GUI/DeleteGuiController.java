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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class DeleteGuiController implements Initializable {

    @FXML
    private TextField tfIDDelete;
private EvenementService EvenementService; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.EvenementService = new EvenementService ();
    }    

   
    @FXML
    private void DeletRecord(ActionEvent event) {
        
        FXMLLoader loader =new FXMLLoader(getClass().getResource("DeleteGui.fxml"));
        try {
        Parent root = loader.load();
        
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("ARE YOU SURE man !!");
        if (alert.showAndWait().get()== ButtonType.OK){
              Hotel h=new Hotel();
        int ID=Integer.parseInt(tfIDDelete.getText());
        Evenement E1=new Evenement();
        //EvenementService.update(E1, h);
        EvenementService.delete(E1, ID);
            System.out.println("ok we delete ");
            
        }
        
       tfIDDelete.setText("");
           
          } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
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
    

