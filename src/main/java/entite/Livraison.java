package entite;

import java.time.LocalDateTime;

public class Livraison {
    private int id;
    private int commandeId;
    private int livreurId;
    private StatutLivraison statut;
    private LocalDateTime dateLivraison;

    // Constructeur
    public Livraison( int commandeId, int livreurId, StatutLivraison statut, LocalDateTime dateLivraison) {

        this.commandeId = commandeId;
        this.livreurId = livreurId;
        this.statut = statut;
        this.dateLivraison = dateLivraison;
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

    public int getLivreurId() {
        return livreurId;
    }

    public void setLivreurId(int livreurId) {
        this.livreurId = livreurId;
    }

    public StatutLivraison getStatut() {
        return statut;
    }

    public void setStatut(StatutLivraison statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    // Méthode toString pour affichage

    @Override
    public String toString() {
        return "Livraison{" +
                "id=" + id +
                ", commandeId=" + commandeId +
                ", livreurId=" + livreurId +
                ", statut=" + statut +
                ", dateLivraison=" + dateLivraison +
                '}';
    }
}