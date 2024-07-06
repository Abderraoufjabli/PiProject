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
import java.util.ResourceBundle;

public class ReclamationView implements Initializable {

    @FXML
    private TableView<Reclamation> tableView;
    private ServiceReclamation serviceReclamation;

    public ReclamationView(ServiceReclamation serviceReclamation) {
        this.serviceReclamation = serviceReclamation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //configure les colonnes de la table view
        TableColumn<Reclamation,Integer> idcol=new TableColumn<>("ID");
        idcol.setCellFactory(new PropertyValueFactory<>("id"));



    }
}
