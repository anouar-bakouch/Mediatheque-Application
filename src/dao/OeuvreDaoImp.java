package dao;

import beans.Auteur;
import beans.Oeuvre;
import enums.Categorie;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class OeuvreDaoImp implements  OeuvreDao{

    private Document doc;
    private Element root;
    private String nomFichier;

    public OeuvreDaoImp(String nomFichier) {
        this.nomFichier = nomFichier;
        load();
    }

    private void load() {
        try {
            SAXBuilder sax = new SAXBuilder();
            doc = sax.build(new File(nomFichier));
            root = doc.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(doc, new FileOutputStream(nomFichier));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterOeuvre(Oeuvre oeuvre) {

        Element e = new Element("oeuvre");
        Element id = new Element("id");
        Element titre = new Element("titre");
        Element categorie = new Element("categorie");
        Element editeur = new Element("editeur");
        Element anneeSortie = new Element("anneeSortie");
        Element auteur = new Element("auteur");

        titre.addContent(oeuvre.getTitre());
        categorie.addContent(String.valueOf(oeuvre.getCategorie()));
        editeur.addContent(oeuvre.getEditeur());
        anneeSortie.addContent(String.valueOf(oeuvre.getAnneeSortie()));
        auteur.setAttribute("idAuteur",String.valueOf(oeuvre.getAuteur().getId()));

        e.addContent(id);
        e.addContent(titre);
        e.addContent(anneeSortie);
        e.addContent(auteur);
        e.addContent(categorie);
        e.addContent(editeur);

        root.addContent(e);
        save();
    }

    @Override
    public void modifierOeuvre(Oeuvre oeuvre) {

    }

    @Override
    public void supprimerOeuvre(Oeuvre oeuvre) {

    }

    @Override
    public Oeuvre getOeuvre(int id) {
        List<Element> e = root.getChildren();
        Auteur auteur = null;
        int idAuteur = 0;
        for(Element oeuvre : e){
            if(Integer.parseInt(oeuvre.getChildText("id")) == id){
                idAuteur = Integer.parseInt(oeuvre.getChild("auteur").getAttributeValue("idAuteur"));
                auteur = new AuteurDaoImp("auteurs.xml").rechercherAuteur(idAuteur);
                Categorie categorie = Categorie.valueOf(oeuvre.getChildText("categorie"));
                return new Oeuvre(
                        Integer.parseInt(oeuvre.getChildText("id")),
                        oeuvre.getChildText("titre"),
                        categorie,
                        auteur,
                        oeuvre.getChildText("editeur"),
                        Integer.parseInt(oeuvre.getChildText("anneeSortie")),
                        Boolean.valueOf(oeuvre.getChildText("status"))
                );
            }
        }

        return null;
    }

    @Override
    public List<Oeuvre> getOeuvres() {
        List<Oeuvre> oeuvres = new ArrayList<>();
        List<Element> e = root.getChildren();
        for(Element oeuvre : e){
            int idAuteur = Integer.parseInt(oeuvre.getChild("auteur").getAttributeValue("idAuteur"));
            Auteur auteur = new AuteurDaoImp("auteurs.xml").rechercherAuteur(idAuteur);
            Categorie categorie = Categorie.valueOf(oeuvre.getChildText("categorie"));
            oeuvres.add(new Oeuvre(
                    Integer.parseInt(oeuvre.getChildText("id")),
                    oeuvre.getChildText("titre"),
                    categorie,
                    auteur,
                    oeuvre.getChildText("editeur"),
                    Integer.parseInt(oeuvre.getChildText("anneeSortie")),
                    Boolean.valueOf(oeuvre.getChildText("status"))
            ));
        }
        return oeuvres;
    }
}
