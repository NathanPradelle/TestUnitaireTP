
public final class Adresse {

    private String voie;
    private String codePostal;
    private String ville;

    public Adresse(String voie, String codePostal, String ville) {
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * Une adresse est valide lorsque tous ses champs sont renseignés
     */
    public boolean estValide() {
        return !this.voie.isEmpty() && !this.codePostal.isEmpty() && !this.ville.isEmpty();
    }
    /**
     * Vérifie si l'adresse se situe dans la ville fournie en paramètre.
     * Si c'est le cas, la méthode retourne "vrai"
     */
    public boolean estDansLaVille(String ville) {
        return this.ville.equals(ville);
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
