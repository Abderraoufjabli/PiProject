package entite;

import java.time.LocalDateTime;

public class Reclamation {
    private int id;
    private int commandeId;
    private String description;
    private StatutReclamation statut;
    private LocalDateTime dateCreation;
    private LocalDateTime dateResolution;

    // Constructeur
    public Reclamation( int commandeId, String description, StatutReclamation statut, LocalDateTime dateCreation, LocalDateTime dateResolution) {

        this.commandeId = commandeId;
        this.description = description;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.dateResolution = dateResolution;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutReclamation getStatut() {
        return statut;
    }

    public void setStatut(StatutReclamation statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(LocalDateTime dateResolution) {
        this.dateResolution = dateResolution;
    }

    // Méthode toString pour affichage

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", commandeId=" + commandeId +
                ", description='" + description + '\'' +
                ", statut=" + statut +
                ", dateCreation=" + dateCreation +
                ", dateResolution=" + dateResolution +
                '}';
    }
}