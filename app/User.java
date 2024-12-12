abstract class User {
    protected String email;
    protected String prenom;
    protected String nom;

    public User(String email, String prenom, String nom) {
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }
}
