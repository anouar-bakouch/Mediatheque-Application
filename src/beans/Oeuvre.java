package beans;
import enums.Categorie;

public class Oeuvre {
        int id;
        private String titre;
        private Categorie categorie;
        private Auteur auteur;
        private String editeur;
        private int anneeSortie;
        private boolean statut;

        public Oeuvre(int id ,String titre, Categorie categorie, Auteur auteur, String editeur, int anneeSortie, boolean statut) {
            this.id = id;
            this.titre = titre;
            this.categorie = categorie;
            this.auteur = auteur;
            this.editeur = editeur;
            this.anneeSortie = anneeSortie;
            this.statut = statut;
        }

        public String getTitre() {
                return titre;
        }

        public Categorie getCategorie() {
                return categorie;
        }

        public Auteur getAuteur() {
                return auteur;
        }

        public String getEditeur() {
                return editeur;
        }

        public int getId() {
            return id;
        }

        public int getAnneeSortie() {
                return anneeSortie;
        }

        public boolean isStatut() {
                return statut;
        }

        public void setTitre(String titre) {
                this.titre = titre;
        }

        public void setCategorie(Categorie categorie) {
                this.categorie = categorie;
        }

        public void setAuteur(Auteur auteur) {
                this.auteur = auteur;
        }

        public void setEditeur(String editeur) {
                this.editeur = editeur;
        }

        public void setAnneeSortie(int anneeSortie) {
                this.anneeSortie = anneeSortie;
        }

        public void setStatut(boolean statut) {
                this.statut = statut;
        }

        @Override
        public String toString() {
                return "Oeuvre{" +
                        "titre='" + titre + '\'' +
                        ", categorie='" + categorie + '\'' +
                        ", auteur=" + auteur.getNom() +
                        ", editeur='" + editeur + '\'' +
                        ", anneeSortie=" + anneeSortie +
                        ", statut=" + statut +
                        '}';
        }
}
