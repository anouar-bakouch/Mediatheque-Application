package dao;

import beans.Auteur;
import beans.Oeuvre;
import enums.Categorie;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import utils.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class OeuvreDaoImp implements OeuvreDao{

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
        e.setAttribute("id",String.valueOf(oeuvre.getId()));
        Element titre = new Element("titre");
        Element categorie = new Element("categorie");
        Element editeur = new Element("editeur");
        Element anneeSortie = new Element("anneeSortie");
        Element auteur = new Element("auteur");
        Element statut = new Element("statut");

        titre.addContent(oeuvre.getTitre());
        categorie.addContent(String.valueOf(oeuvre.getCategorie()));
        editeur.addContent(oeuvre.getEditeur());
        anneeSortie.addContent(String.valueOf(oeuvre.getAnneeSortie()));
        auteur.setAttribute("idAuteur",String.valueOf(oeuvre.getAuteur().getId()));
        statut.addContent(String.valueOf(oeuvre.isStatut()));

        e.addContent(titre);
        e.addContent(categorie);
        e.addContent(editeur);
        e.addContent(anneeSortie);
        e.addContent(auteur);
        e.addContent(statut);

        root.addContent(e);
        save();
    }

    @Override
    public void modifierOeuvre(Oeuvre oeuvre) {

       List<Element> oeuvres = root.getChildren("oeuvre");
       for(Element el : oeuvres){
           if(Integer.parseInt(el.getAttributeValue("id")) == oeuvre.getId()){
               el.getChild("titre").setText(oeuvre.getTitre());
               el.getChild("categorie").setText(String.valueOf(oeuvre.getCategorie()));
               el.getChild("editeur").setText(oeuvre.getEditeur());
               el.getChild("anneeSortie").setText(String.valueOf(oeuvre.getAnneeSortie()));
               el.getChild("auteur").setAttribute("idAuteur",String.valueOf(oeuvre.getAuteur().getId()));
               el.getChild("statut").setText(String.valueOf(oeuvre.isStatut()));
           }
       }
    }

    @Override
    public void supprimerOeuvre(Oeuvre oeuvre) {

        List<Element> oeuvres = root.getChildren("oeuvre");
        for(Element el : oeuvres){
            if(Integer.parseInt(el.getAttributeValue("id")) == oeuvre.getId()){
                root.removeContent(el);
            }
        }
        save();
    }

    @Override
    public Oeuvre getOeuvre(int id) {
        List<Element> list = root.getChildren("oeuvre");

        for(Element x : list){

            if(Integer.parseInt(x.getAttributeValue("id")) == id){
                int aut_id = Integer.parseInt(x.getChild("auteur").getAttributeValue("idAuteur"));
                Auteur auteur = new AuteurDaoImp(Constants.AUTEUR_FILE).rechercherAuteur(aut_id);
                return new Oeuvre(id,x.getChildText("titre"),Categorie.valueOf(x.getChildText("categorie")),auteur,x.getChildText("editeur"),Integer.parseInt(x.getChildText("anneeSortie")),Boolean.valueOf(x.getChildText("statut")));
            }

        }

        return null;
    }

    @Override
    public List<Oeuvre> getOeuvres() {

        List<Oeuvre> oeuvres = new ArrayList<>();
        List<Element> list = root.getChildren("oeuvre");

        for(Element x : list){
            int id = Integer.parseInt(x.getAttributeValue("id"));
            int aut_id = Integer.parseInt(x.getChild("auteur").getAttributeValue("idAuteur"));
            Auteur auteur = new AuteurDaoImp(Constants.AUTEUR_FILE).rechercherAuteur(aut_id);
            oeuvres.add(new Oeuvre(id,x.getChildText("titre"),Categorie.valueOf(x.getChildText("categorie")),auteur,x.getChildText("editeur"),Integer.parseInt(x.getChildText("anneeSortie")),Boolean.valueOf(x.getChildText("statut"))));
        }

        return oeuvres;

    }

    @Override
    public List<Oeuvre> getOeuvresParAuteur(int idAuteur){

            List<Oeuvre> oeuvres = new ArrayList<>();
            List<Element> list = root.getChildren("oeuvre");

            for(Element x : list){
                int id = Integer.parseInt(x.getAttributeValue("id"));
                int aut_id = Integer.parseInt(x.getChild("auteur").getAttributeValue("idAuteur"));
                if(aut_id == idAuteur){
                    Auteur auteur = new AuteurDaoImp(Constants.AUTEUR_FILE).rechercherAuteur(aut_id);
                    oeuvres.add(new Oeuvre(id,x.getChildText("titre"),Categorie.valueOf(x.getChildText("categorie")),auteur,x.getChildText("editeur"),Integer.parseInt(x.getChildText("anneeSortie")),Boolean.valueOf(x.getChildText("statut"))));
                }
            }
            return oeuvres;

    }

}
