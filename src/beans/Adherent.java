package beans;

public class Adherent {

    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;

    public Adherent(int numero, String nom, String prenom, String adresse, String email) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
