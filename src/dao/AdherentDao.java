package dao;

import beans.Adherent;

import java.util.List;

public interface AdherentDao {

    public void ajouterAdherent(Adherent adherent);

    public void modifierAdherent(Adherent adherent);

    public void supprimerAdherent(Adherent adherent);

    public Adherent getAdherent(int id);

    public Adherent getAdherent(String nom);

    public List<Adherent> getAdherents();

}
