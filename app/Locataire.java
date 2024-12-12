import java.time.LocalDate;
import java.util.List;

public class Locataire extends User {

    public static final int NB_MOIS_AVEC_BULLETIN = 3;
    public static final int AGE_MINIMUM_POUR_LOUER = 21;

    private LocalDate dateDeNaissance;
    private String metier;
    private List<BulletinDeSalaire> bulletinsDeSalaire;

    public Locataire(String email,
                     String prenom,
                     String nom,
                     LocalDate dateDeNaissance,
                     String metier,
                     List<BulletinDeSalaire> bulletinsDeSalaire) {
        super(email, prenom, nom);
        this.dateDeNaissance = dateDeNaissance;
        this.metier = metier;
        this.bulletinsDeSalaire = bulletinsDeSalaire;
    }

    /**
     * Un appartement peut être loué si le locataire a au moins AGE_MINIMUM_POUR_LOUER ans,
     * qu'il a un métier et qu'il a bien renseigné ses NB_MOIS_AVEC_BULLETIN derniers bulletins de salaire
     */
    public boolean peutLouerAppartement() {
        return this.dateDeNaissance.plusYears(AGE_MINIMUM_POUR_LOUER).isBefore(LocalDate.now()) && this.metier != null && this.auMoinsTroisBulletinDurantTroisDerniersMois();
    }

    /**
     * Permet de savoir si le locataire a bien 3 bulletins de salaire sur les 3 derniers mois
     * (à raison d'un bulletin de salaire par mois)
     */
    public boolean auMoinsTroisBulletinDurantTroisDerniersMois() {
        if (this.bulletinsDeSalaire.size() < NB_MOIS_AVEC_BULLETIN) {
            return false;
        }
        LocalDate dateDuDernierBulletin = this.bulletinsDeSalaire.getFirst().getDateEditionDuBulletin();
        for (int i = 1; i < NB_MOIS_AVEC_BULLETIN; i++) {
            if (!dateDuDernierBulletin.minusMonths(i).equals(this.bulletinsDeSalaire.get(i).getDateEditionDuBulletin())) {
                return false;
            }
        }
        return true;
    }

    public void ajouterNouveauBulletinDeSalaire(BulletinDeSalaire bulletin) {
        this.bulletinsDeSalaire.add(bulletin);
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public List<BulletinDeSalaire> getBulletinsDeSalaire() {
        return bulletinsDeSalaire;
    }

    public void setBulletinsDeSalaire(List<BulletinDeSalaire> bulletinsDeSalaire) {
        this.bulletinsDeSalaire = bulletinsDeSalaire;
    }
}
