package controllers;

import entite.Reclamation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceReclamation;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReclamationView implements Initializable {

    @FXML
    private TableView<Reclamation> tableView;
    private ServiceReclamation serviceReclamation=new ServiceReclamation();

//    public ReclamationView(ServiceReclamation serviceReclamation)
//    {
//        this.serviceReclamation = serviceReclamation;
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        //configure les colonnes de la table view
        TableColumn<Reclamation,Integer> idRec=new TableColumn<>("ID RECLAMATION");
        idRec.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Reclamation,Integer> idCl=new TableColumn<>("ID CLIENT");
        idCl.setCellValueFactory(new PropertyValueFactory<>("utilisateurId"));

        TableColumn<Reclamation,Integer> idCom=new TableColumn<>("ID COMMANDE");
        idCom.setCellValueFactory(new PropertyValueFactory<>("commandeId"));

        TableColumn<Reclamation,String>  descripCol=new TableColumn<>("RECLAMATION");
        descripCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Reclamation, LocalDateTime> dateCreaCol=new TableColumn<>("DATE CREATION");
        dateCreaCol.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        TableColumn<Reclamation,LocalDateTime>  dateMiseAJour=new TableColumn<>("DATE MISE A JOUR");
        dateMiseAJour.setCellValueFactory(new PropertyValueFactory<>("dateResolution"));

        TableColumn<Reclamation,LocalDateTime> statutCol=new TableColumn<>("STATUT");
        statutCol.setCellValueFactory(new PropertyValueFactory<>("statut"));

        loadReclamation();

    }


    private void loadReclamation()
    {
        List<Reclamation> reclamations=new ArrayList<>();
        reclamations=serviceReclamation.readAll();

        tableView.getItems().addAll(reclamations);
    }
}
