package dao;

import beans.Pret;

import java.util.List;

public interface PretDao {

    public void ajouterPret(Pret pret);
    public void modifierPret(Pret pret);
    public void supprimerPret(Pret pret);
    public Pret rechercherPret(int id);
    public List<Pret> getPrets();

}
