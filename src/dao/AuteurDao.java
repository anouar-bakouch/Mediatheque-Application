package dao;

import beans.Auteur;

import java.util.List;

public interface AuteurDao {

    public void ajouterAuteur(Auteur auteur);
    public void supprimerAuteur(Auteur auteur);
    public void modifierAuteur(Auteur auteur);
    public Auteur rechercherAuteur(int id);
    public Auteur rechercherAuteur(String nom);
    public List<Auteur> getAuteurs();

}
