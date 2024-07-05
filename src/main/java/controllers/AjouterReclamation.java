package controllers;

import entite.Reclamation;
import entite.StatutReclamation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.ServiceReclamation;

public class AjouterReclamation {

        @FXML
        private TextField txtClient;

        @FXML
        private TextField txtCommande;

        @FXML
        private TextArea txtDescription;



        @FXML
        void AjouterReclamation(ActionEvent event) {

                int idUser=Integer.parseInt(txtClient.getText());
                int idCommande=Integer.parseInt(txtCommande.getText());
                String description=txtDescription.getText();



                Reclamation recla=new Reclamation(idUser,idCommande,description);
                ServiceReclamation serviceReclamation=new ServiceReclamation();
                serviceReclamation.create(recla);

                System.out.println(idUser);
                System.out.println(idCommande);
                System.out.println(description);
//                System.out.println(stat);











        }
}

