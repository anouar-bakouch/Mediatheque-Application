package dao;

import beans.Auteur;
import beans.Oeuvre;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import utils.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AuteurDaoImp implements AuteurDao{

    private Document doc;
    private Element racine;
    private String nomFichier;

    public AuteurDaoImp(String filePath) {
        this.nomFichier = filePath;
        load();
    }

    private void load(){
        try {
            SAXBuilder sax = new SAXBuilder();
            doc = sax.build(new File(nomFichier));
            racine = doc.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save(){
        try {
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(doc, new FileOutputStream(nomFichier));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterAuteur(Auteur auteur) {

        Element e = new Element("auteur");
        e.setAttribute("id", String.valueOf(auteur.getId()));
        Element nom = new Element("nom");
        Element prenom = new Element("prenom");
        Element dateNaissance = new Element("dateNaissance");

        nom.addContent(auteur.getNom());
        prenom.addContent(auteur.getPrenom());
        dateNaissance.addContent(auteur.getDateNaissance());

        e.addContent(nom);
        e.addContent(prenom);
        e.addContent(dateNaissance);
        racine.addContent(e);
        save();
    }

    @Override
    public void supprimerAuteur(Auteur auteur) {
        List<Element> elementsToRemove = new ArrayList<>();
        List<Element> list = new ArrayList<>(racine.getChildren("auteur")); // create a copy of the list
        for (Element d : list) {
            if (Integer.parseInt(d.getAttributeValue("id")) == auteur.getId()) {
                elementsToRemove.add(d);
            }
        }
        elementsToRemove.forEach(racine::removeContent);
        save();

        // delete all the author's works
        OeuvreDaoImp odi = new OeuvreDaoImp(Constants.OEUVRE_FILE);
        List<Oeuvre> oeuvres = new ArrayList<>(odi.getOeuvresParAuteur(auteur.getId())); // create a copy of the list
        for (Oeuvre oeuvre : oeuvres) {
            odi.supprimerOeuvre(oeuvre);
        }
    }

    @Override
    public void modifierAuteur(Auteur auteur) {
        List<Element> list = racine.getChildren("auteur");
        for (Element d : list) {
            if (Integer.parseInt(d.getAttributeValue("id")) == auteur.getId()) {
                d.getChild("nom").setText(auteur.getNom());
                d.getChild("prenom").setText(auteur.getPrenom());
                d.getChild("dateNaissance").setText(auteur.getDateNaissance());
                save();
                break;
            }
        }

    }

    @Override
    public Auteur rechercherAuteur(int id) {
        List<Element> list = racine.getChildren("auteur");
        for (Element d : list) {
            if (Integer.parseInt(d.getAttributeValue("id")) == id ) {
                return new Auteur(id,d.getChildText("nom"), d.getChildText("prenom"), d.getChildText("dateNaissance"));
            }
        }
        return null;
    }

    @Override
    public Auteur rechercherAuteur(String nom){
        List<Element> AuteurList = racine.getChildren("auteur");
        for (Element d : AuteurList) {
            if (d.getChildText("nom").equals(nom)) {
                return new Auteur(Integer.parseInt(d.getAttributeValue("id")),d.getChildText("nom"), d.getChildText("prenom"), d.getChildText("dateNaissance"));
            }
        }
        return null;
    }

    @Override
    public List<Auteur> getAuteurs() {
        List<Auteur> auteurs = new ArrayList<Auteur>();
        List<Element> list = racine.getChildren("auteur");
        for (Element d : list) {
            auteurs.add(new Auteur(Integer.parseInt(d.getAttributeValue("id")),d.getChildText("nom"), d.getChildText("prenom"), d.getChildText("dateNaissance")));
        }
        return auteurs;
    }



}
