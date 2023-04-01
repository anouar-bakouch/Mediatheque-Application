package dao;

import beans.Adherent;

public interface AdherentDao {

    public void ajouterAdherent(Adherent adherent);

    public void modifierAdherent(Adherent adherent);

    public void supprimerAdherent(Adherent adherent);

    public Adherent getAdherent(int id);

}
