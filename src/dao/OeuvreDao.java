package dao;

import beans.Oeuvre;

import java.util.List;

public interface OeuvreDao {

    public void ajouterOeuvre(Oeuvre oeuvre);
    public void modifierOeuvre(Oeuvre oeuvre);
    public void supprimerOeuvre(Oeuvre oeuvre);
    public Oeuvre getOeuvre(int id);
    public List<Oeuvre> getOeuvres();

    public List<Oeuvre> getOeuvresParAuteur(int idAuteur);

}
