package entite;

public enum StatutReclamation {
    OUVERTE("Ouverte"),
    EN_COURS("En cours"),
    RESOLUE("Résolue"),
    ANNULEE("Annulée");

    private final String statut;

    StatutReclamation(String statut) {
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