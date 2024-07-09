package controllers;

import entite.Reclamation;
import entite.StatutReclamation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        void ajouterReclamation(ActionEvent event) {

                if (validateInput()) {
                        int idUser = Integer.parseInt(txtClient.getText());
                        int idCommande = Integer.parseInt(txtCommande.getText());
                        String description = txtDescription.getText();


                        Reclamation recla = new Reclamation(idUser, idCommande, description);
                        ServiceReclamation serviceReclamation = new ServiceReclamation();
                        serviceReclamation.create(recla);

                        clearFields();

                        // Afficher un message de succès
                        showAlert("Succès", "Réclamation envoyée avec succès.", Alert.AlertType.INFORMATION);

                }
        }

        //controle de saisie


                private boolean validateInput () {
                        String IdUser1 = txtClient.getText().trim();
                        String idCommande1 = txtCommande.getText().trim();
                        String description1 = txtDescription.getText().trim();

                        if (IdUser1.isEmpty()) {
                                showAlert("Erreur de validationn", "L'identifiant du client doit etre un" +
                                        " nombre",Alert.AlertType.ERROR);
                                return false;
                        }
                        if (!IdUser1.matches("\\d+")) {
                                showAlert("Erreur de validation", "L'identifiant du client doit etre " +
                                        "un nombre",Alert.AlertType.ERROR);
                                return false;
                        }
                        if (idCommande1.isEmpty()) {
                                showAlert("Erreur de validation", "l'identifianat de commande doit etre" +
                                        " un nombre",Alert.AlertType.ERROR);
                                return false;
                        }
                        if (!idCommande1.matches("\\d+")) {
                                showAlert("Erreur de validation", "l'identifiant du commande doit etre " +
                                        "un nombre",Alert.AlertType.ERROR);
                                return false;
                        }
                        if (description1.isEmpty()) {
                                showAlert("Erreur de validation", "La description est " +
                                        "obligatoire.",Alert.AlertType.ERROR);
                                return false;
                        }

                        if (description1.length() < 5) {
                                showAlert("Erreur de validation", "La description doit contenir au " +
                                        "moins 5 caractères.",Alert.AlertType.ERROR);
                                return false;
                        }

                        return true;

                }

                // methode show Alerte


                private void showAlert (String title, String message,Alert.AlertType alertType){
                        Alert alert = new Alert(alertType);
                        alert.setTitle(title);
                        alert.setHeaderText(null);
                        alert.setContentText(message);
                        alert.showAndWait();
                }

        private void clearFields() {
                txtClient.clear();
                txtDescription.clear();
                txtCommande.clear();
        }



}

