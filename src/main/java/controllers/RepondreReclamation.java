package controllers;

import entite.Reclamation;
import entite.StatutReclamation;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.collections.FXCollections;
import service.ServiceReclamation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepondreReclamation {

    @FXML
    private TextField txtReclamationId;

    @FXML
    private TextField txtCommandeId;

    @FXML
    private TextField txtUtilisateurId;

    @FXML
    private TextArea txtReponse;

    @FXML
    private ComboBox<String> comboStatut;


    @FXML
    private void repondreReclamation() {
        // Validation des champs
        if (validateFields()) {
            // Récupérer les valeurs des champs depuis l'interface utilisateur
            int reclamationId = Integer.parseInt(txtReclamationId.getText());
            int commandeId = Integer.parseInt(txtCommandeId.getText());
            int utilisateurId = Integer.parseInt(txtUtilisateurId.getText());
            String reponse = txtReponse.getText();
            StatutReclamation statut =StatutReclamation.valueOf(comboStatut.getValue());

            System.out.println(statut);

            // Créer un objet Reclamation avec les valeurs saisies
            Reclamation reclamation = new Reclamation(reclamationId, commandeId, utilisateurId, reponse, statut);

            ServiceReclamation serviceReclamation=new ServiceReclamation();
            serviceReclamation.update(reclamation);
            clearFields();

            // Afficher un message de succès
            showAlert("Succès", "Réclamation envoyée avec succès.", Alert.AlertType.INFORMATION);
        } else {
            // Afficher un message d'erreur ou une notification à l'utilisateur
            System.out.println("Veuillez remplir tous les champs correctement.");
        }
    }

    // Méthode pour valider les champs
    private boolean validateFields() {
        // Vérifier que les champs ne sont pas vides et sont valides
        return !txtReclamationId.getText().isEmpty() &&
                isNumeric(txtReclamationId.getText()) &&
                !txtCommandeId.getText().isEmpty() &&
                isNumeric(txtCommandeId.getText()) &&
                !txtUtilisateurId.getText().isEmpty() &&
                isNumeric(txtUtilisateurId.getText()) &&
                !txtReponse.getText().isEmpty() &&
                comboStatut.getValue() != null;
    }

    // Méthode utilitaire pour vérifier si une chaîne est numérique
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Méthode pour mettre à jour une réclamation dans la base de données
//    private void updateReclamation(Reclamation reclamation) {
//        String query = "UPDATE reclamations SET commande_id=?, utilisateur_id=?, reponse=?, statut=? WHERE reclamation_id=?";
//
//        try {
//            PreparedStatement pst = connection.prepareStatement(query);
//            pst.setInt(1, reclamation.getCommandeId());
//            pst.setInt(2, reclamation.getUtilisateurId());
//            pst.setString(3, reclamation.getReponse());
//            pst.setString(4, reclamation.getStatut());
//            pst.setInt(5, reclamation.getId());
//
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }




    private void showAlert (String title, String message,Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    // Méthode pour vider les champs après traitement
    private void clearFields() {
        txtReclamationId.clear();
        txtCommandeId.clear();
        txtUtilisateurId.clear();
        txtReponse.clear();
        comboStatut.getSelectionModel().clearSelection();
    }

    // Vous pouvez ajouter d'autres méthodes de gestion des événements ou d'initialisation ici si nécessaire
}
