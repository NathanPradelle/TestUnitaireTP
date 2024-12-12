import java.time.LocalDate;

public class Appartement {

    private Locataire locataire;
    private LocalDate dateDeSortieDuLocataire;
    private Adresse adresseAppartement;

    public Appartement(Locataire locataire, LocalDate dateDeSortieDuLocataire, Adresse adresseAppartement) {
        this.locataire = locataire;
        this.dateDeSortieDuLocataire = dateDeSortieDuLocataire;
        this.adresseAppartement = adresseAppartement;
    }

    /**
     * L'appartement est considéré vide quand il n'a pas de locataire
     */
    public boolean estVide() {
        return !locataire.peutLouerAppartement();
    }

    /**
     * L'appartement est considéré bientôt vide quand il a un locataire
     * mais qu'il a une date de sortie prévue qui est renseignée
     */
    public boolean estBientotVide() {
        return this.locataire != null && this.dateDeSortieDuLocataire != null;
    }

    /**
     * L'appartement peut être visité si il est vide ou bientôt vide
     */
    public boolean peutEtreVisite() {
        return estBientotVide() || estVide();
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public LocalDate getDateDeSortieDuLocataire() {
        return dateDeSortieDuLocataire;
    }

    public void setDateDeSortieDuLocataire(LocalDate dateDeSortieDuLocataire) {
        this.dateDeSortieDuLocataire = dateDeSortieDuLocataire;
    }

    public Adresse getAdresseAppartement() {
        return adresseAppartement;
    }

    public void setAdresseAppartement(Adresse adresseAppartement) {
        this.adresseAppartement = adresseAppartement;
    }
}