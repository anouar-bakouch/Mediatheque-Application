package dao;

import beans.Adherent;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AdherentDaoImp implements AdherentDao {
    private String filePath;
    private Document doc;
    private Element root;

    public AdherentDaoImp(String filepath){
        this.filePath = filepath;
        load();
    }

    private void load() {
        try {
            SAXBuilder sax = new SAXBuilder();
            doc = sax.build(new File(filePath));
            root = doc.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(doc, new FileOutputStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterAdherent(Adherent adherent) {
        Element e = new Element("adherent");
        e.setAttribute("id", String.valueOf(adherent.getNumero()));
        Element nom = new Element("nom");
        Element prenom = new Element("prenom");
        Element adresse = new Element("adresse");
        Element email = new Element("email");

        nom.addContent(adherent.getNom());
        prenom.addContent(adherent.getPrenom());
        adresse.addContent(adherent.getAdresse());
        email.addContent(adherent.getEmail());

        e.addContent(nom);
        e.addContent(prenom);
        e.addContent(adresse);
        e.addContent(email);
        root.addContent(e);
        save();
    }

    @Override
    public void modifierAdherent(Adherent adherent) {

        List<Element> l = root.getChildren("adherent");
        if(l.size() > 0) {
            for (Element child : l) {
                long _id = Long.parseLong(child.getAttributeValue("id"));
                if (_id == adherent.getNumero()) {
                    child.getChild("nom").setText(adherent.getNom());
                    child.getChild("prenom").setText(adherent.getPrenom());
                    child.getChild("adresse").setText(adherent.getAdresse());
                    child.getChild("email").setText(adherent.getEmail());
                    save();
                    break;
                }
            }
        }

    }

    @Override
    public void supprimerAdherent(Adherent adherent) {

        List<Element> l = root.getChildren("adherent");
        if(l.size() > 0) {
            for (Element child : l) {
                long _id = Long.parseLong(child.getAttributeValue("id"));
                if (_id == adherent.getNumero()) {
                    root.removeContent(child);
                    save();
                    break;
                }
            }
        }

    }

    @Override
    public Adherent getAdherent(int id){
        List<Element> l = root.getChildren();
        if(l.size() > 0) {
            for (Element child : l) {
                long _id = Long.parseLong(child.getAttributeValue("id"));
                if (_id == id) {
                    String nom = child.getChildText("nom");
                    String prenom = child.getChildText("prenom");
                    String adresse = child.getChildText("adresse");
                    String email = child.getChildText("email");
                    return new Adherent(id,nom,prenom,adresse,email);
                }
            }
        }
        return null;
    }

    @Override
    public Adherent getAdherent(String nom) {
        List<Element> l = root.getChildren("adherent");
        if(l.size() > 0) {
            for (Element child : l) {
                String _nom = child.getChildText("nom");
                if (_nom.equals(nom)) {
                    int id = Integer.parseInt(child.getAttributeValue("id"));
                    String prenom = child.getChildText("prenom");
                    String adresse = child.getChildText("adresse");
                    String email = child.getChildText("email");
                    return new Adherent(id,nom,prenom,adresse,email);
                }
            }
        }
        return null;
    }

    @Override
    public List<Adherent> getAdherents() {
        List<Element> l = root.getChildren("adherent");
        List<Adherent> adherents = new ArrayList<Adherent>();
        if(l.size() > 0) {
            for (Element child : l) {
                int id = Integer.parseInt(child.getAttributeValue("id"));
                String nom = child.getChildText("nom");
                String prenom = child.getChildText("prenom");
                String adresse = child.getChildText("adresse");
                String email = child.getChildText("email");
                Adherent adherent = new Adherent(id,nom,prenom,adresse,email);
                adherents.add(adherent);
            }
        }
        return adherents;
    }

}


