package entite;

import java.time.LocalDateTime;

public class Reclamation {
    private int id;
    private int commandeId;
    private String description;
    private int utilisateurId;
    private StatutReclamation statut;
    private LocalDateTime dateCreation;
    private LocalDateTime dateResolution;
    private String reponse;

    // Constructeur1 sans id ////////////////////////////////////////////
    public Reclamation( int utilisateurId,int commandeId, String description, StatutReclamation statut, LocalDateTime dateCreation, LocalDateTime dateResolution) {
        this.utilisateurId=utilisateurId;
        this.commandeId = commandeId;
        this.description = description;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.dateResolution = dateResolution;
    }
     //constructeur avec id ///////////////////////////////////////
    public Reclamation(int id,int utilisateurId, int commandeId, String description,  StatutReclamation statut, LocalDateTime dateCreation, LocalDateTime dateResolution) {
        this.id = id;
        this.commandeId = commandeId;
        this.description = description;
        this.utilisateurId = utilisateurId;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.dateResolution = dateResolution;
    }
// constructeur reclamation iduser,idcommande ,text descrip

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Reclamation(int utilisateurId, int commandeId, String description) {
        this.commandeId = commandeId;
        this.description = description;
        this.utilisateurId = utilisateurId;
    }

    public Reclamation(int id,int commandeId,int utilisateurId,String reponse,StatutReclamation statut)
    {
        this.utilisateurId=utilisateurId;
        this.commandeId=commandeId;
        this.reponse=reponse;
        this.statut=statut;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtilisateurId()
    {
        return utilisateurId;
    }
    public void setUtilisateurId(int utilisateurId)
    {
        this.utilisateurId=utilisateurId;
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
                ", utilisateurId="+ utilisateurId +
                ", commandeId=" + commandeId +
                ", description='" + description + '\'' +
                ", statut=" + statut +
                ", dateCreation=" + dateCreation +
                ", dateResolution=" + dateResolution +
                '}';
    }
}