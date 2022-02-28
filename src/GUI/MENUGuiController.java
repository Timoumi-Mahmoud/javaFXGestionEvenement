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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class MENUGuiController implements Initializable {

    @FXML
    private TableColumn<Evenement, Integer> columnIDE;
    @FXML
    private TableColumn<Evenement, String> columnNom;
    @FXML
    private TableColumn<Evenement, String> columType;
    @FXML
    private TableColumn<Evenement, LocalDate> columnDateDebut;
    @FXML
    private TableColumn<Evenement, LocalDate> columnDateFin;
    @FXML
    private TableColumn<Evenement, Integer> columnPrix;
    @FXML
    private TableColumn<Evenement, Integer> columnNparticipants;
    @FXML
    private TableColumn<Evenement, Hotel> columnIDhotel;
    
private EvenementService EvenementService; 
    
   ObservableList<Evenement> listE= FXCollections.observableArrayList() ;
    @FXML
    private Button btnRead;
    @FXML
    private TableView<Evenement> TableV;
    
    
    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         this.EvenementService = new EvenementService ();
       // Factories 
       columnIDE.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("ID_evenement"));
       columnNom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Nom"));
       columType.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Type"));
       columnDateDebut.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_debut"));
       columnDateFin.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("Date_fin"));
       columnPrix.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("Prix"));
       columnNparticipants.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("Nombre_Participants"));
       columnIDhotel.setCellValueFactory(new PropertyValueFactory<>("ID_hotel"));

       
        try {
              loadEvenement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
   
       
       
       
       
       
       
       
       
       
       
    }    

    @FXML
    private void GoInsert(ActionEvent event) throws IOException {
        Parent  DeleteParent= FXMLLoader.load(getClass().getResource("InsertGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
    }

    @FXML
    private void GoDelete(ActionEvent event) throws IOException {
    
    Parent  DeleteParent= FXMLLoader.load(getClass().getResource("DeleteGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();}

    @FXML
    private void GoUpdate(ActionEvent event) throws IOException {
        Parent  DeleteParent= FXMLLoader.load(getClass().getResource("UpdateGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
    }
    

    @FXML
    private void GoSearch(ActionEvent event) throws IOException {
        Parent  DeleteParent= FXMLLoader.load(getClass().getResource("SearchGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
    }

    @FXML
    private void GoStatistque(ActionEvent event) throws IOException {
    Parent  DeleteParent= FXMLLoader.load(getClass().getResource("StatistiqueGui.fxml")); // the fxml sceen that i want to move to it
        Scene DeleteScene= new Scene(DeleteParent);  
        // Get The stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeleteScene);
        window.show();
    }
/*
    @FXML
    private ObservableList<Evenement> ReadDB(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("MENUGui.fxml"));
        ObservableList<Evenement> list = FXCollections.observableArrayList();
        try {
           PreparedStatement pst = conn.prepareStatement("select * from Evenement");
            rs = pst.executeQuery();
            while(rs.next()){
                 Hotel h =new Hotel();
               list.add(new Evenement( rs.getInt("ID_evenement"), rs.getString("nom"), rs.getString("Type"), rs.getDate("Date_debut").toLocalDate(), 
                       rs.getDate("Date_fin").toLocalDate(), rs.getInt("Prix") , new Hotel(rs.getInt("ID_hotel")), rs.getInt("Nombre_Participants") ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
        
       */
          
         
       
      public void loadEvenement() throws SQLException{
    //FXMLLoader loader =new FXMLLoader(getClass().getResource("DeleteGui.fxml"));
  ObservableList <Evenement> Evenement= FXCollections.observableArrayList();
  
        
    try {
      TableV.getItems().addAll(EvenementService.read());
 
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
            
    
}       
   
         
          
          
          

        
        
   
        
   

    @FXML
    private void OnReferech(ActionEvent event) throws SQLException {
        loadRefrech() ;
    }
    public void loadRefrech() throws SQLException{
   for ( int i = 0; i< TableV.getItems().size(); i++) {
     TableV.getItems().clear();
}
        loadEvenement();
        
    }
   
         
            
            
            
            
            
            
        
        
        
        
        
    }
    
    
    
    
       
       
    
    
    
    
    

