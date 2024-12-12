import java.time.LocalDate;

public final class BulletinDeSalaire {

    private LocalDate dateEditionDuBulletin;
    private String nomEntreprise;

    public BulletinDeSalaire(LocalDate dateEmission, String nomEntreprise) {
        this.dateEditionDuBulletin = dateEmission;
        this.nomEntreprise = nomEntreprise;
    }

    public LocalDate getDateEditionDuBulletin() {
        return dateEditionDuBulletin;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }
}
