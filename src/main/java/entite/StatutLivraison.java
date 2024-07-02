package entite;

public enum StatutLivraison {
    EN_COURS("En cours"),
    LIVREE("Livrée"),
    ANNULEE("Annulée");

    private final String statut;

    StatutLivraison(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    @Override
    public String toString() {
        return statut;
    }
}