package controllers;

import entite.Reclamation;
import entite.StatutReclamation;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MiseAjourReaclamation {


    @FXML
    private TextArea commandeIdField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextArea utilisateurIdField;

    @FXML
    private ComboBox<String> statutComboBox;

    @FXML
    private DatePicker dateCreationPicker;

    @FXML
    private DatePicker dateResolutionPicker;

    private Reclamation reclamation;

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
        commandeIdField.setText(String.valueOf(reclamation.getCommandeId()));
        descriptionField.setText(reclamation.getDescription());
        utilisateurIdField.setText(String.valueOf(reclamation.getUtilisateurId()));
        statutComboBox.setValue(reclamation.getStatut().name());
        dateCreationPicker.setValue(reclamation.getDateCreation().toLocalDate());
        if (reclamation.getDateResolution() != null) {
            dateResolutionPicker.setValue(reclamation.getDateResolution().toLocalDate());
        }
    }

    @FXML
    private void handleSaveAction() {
        reclamation.setCommandeId(Integer.parseInt(commandeIdField.getText()));
        reclamation.setDescription(descriptionField.getText());
        reclamation.setUtilisateurId(Integer.parseInt(utilisateurIdField.getText()));
        reclamation.setStatut(StatutReclamation.valueOf(statutComboBox.getValue()));
        reclamation.setDateCreation(dateCreationPicker.getValue().atStartOfDay());
        LocalDate dateResolution = dateResolutionPicker.getValue();
        if (dateResolution != null) {
            reclamation.setDateResolution(dateResolution.atStartOfDay());
        }

        // Code pour enregistrer la réclamation mise à jour dans la base de données ou autre traitement

        closeWindow();
    }

    @FXML
    private void handleCancelAction() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) commandeIdField.getScene().getWindow();
        stage.close();
    }
}
