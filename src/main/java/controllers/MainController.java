package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private void afficherReclamations(ActionEvent event) {
        try {
            // Charger ReclamationView.fxml
            Parent reclamationView = FXMLLoader.load(getClass().getResource("../ReclamationView.fxml"));

            // Créer une nouvelle scène
            Scene scene = new Scene(reclamationView);

            // Obtenir le stage à partir de la scène du bouton
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Définir la scène sur le stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'erreur de chargement de la vue
        }
    }

    @FXML
    public void ajouterReclamations(ActionEvent actionEvent) {
        try {
            // Charger AjouterReclamation.fxml
            Parent ajouterReclamationView = FXMLLoader.load(getClass().getResource("../AjouterReclamation.fxml"));

            // Créer une nouvelle scène
            Scene scene = new Scene(ajouterReclamationView);

            // Obtenir le stage à partir de la scène du bouton
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Définir la scène sur le stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'erreur de chargement de la vue
        }
    }

    @FXML
    public void repondreReclamations(ActionEvent actionEvent) {
        try {
            // Charger RepondreReclamation.fxml
            Parent repondreReclamationView = FXMLLoader.load(getClass().getResource("../RepondreReclamation.fxml"));

            // Créer une nouvelle scène
            Scene scene = new Scene(repondreReclamationView);

            // Obtenir le stage à partir de la scène du bouton
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Définir la scène sur le stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'erreur de chargement de la vue
        }
    }
}
