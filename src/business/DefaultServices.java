package business;

import beans.Adherent;
import beans.Auteur;
import beans.Oeuvre;
import beans.Pret;
import dao.*;
import java.util.List;

public class DefaultServices implements Services{

    private AdherentDao adherentDao;
    private OeuvreDao oeuvreDao;
    private AuteurDao auteurDao;
    private PretDao pretDao;

    private static DefaultServices instance;

    public DefaultServices(){
        this.adherentDao = new AdherentDaoImp("resources/adherents.xml");
        this.oeuvreDao = new OeuvreDaoImp("resources/oeuvres.xml");
        this.pretDao = new PretDaoImp("resources/prets.xml");
        this.auteurDao = new AuteurDaoImp("resources/auteurs.xml");
    }

    public static DefaultServices getInstance(){
        if(instance == null){
            instance = new DefaultServices();
        }
        return instance;
    }


    @Override
    public void ajouterAdherent(Adherent adherent) {
        adherentDao.ajouterAdherent(adherent);
    }

    @Override
    public void modifierAdherent(Adherent adherent) {
        this.adherentDao.modifierAdherent(adherent);
    }

    @Override
    public void supprimerAdherent(Adherent adherent) {
        this.adherentDao.supprimerAdherent(adherent);
    }

    @Override
    public Adherent getAdherent(int id) {
        return this.adherentDao.getAdherent(id);
    }

    @Override
    public void ajouterAuteur(Auteur auteur) {
        this.auteurDao.ajouterAuteur(auteur);
    }

    @Override
    public void supprimerAuteur(Auteur auteur) {
        this.auteurDao.supprimerAuteur(auteur);
    }

    @Override
    public void modifierAuteur(Auteur auteur) {
        this.auteurDao.modifierAuteur(auteur);
    }

    @Override
    public Auteur rechercherAuteur(int id) {
        return this.auteurDao.rechercherAuteur(id);
    }

    @Override
    public List<Auteur> getAuteurs() {
        return this.auteurDao.getAuteurs();
    }

    @Override
    public void ajouterOeuvre(Oeuvre oeuvre) {
        this.oeuvreDao.ajouterOeuvre(oeuvre);
    }

    @Override
    public void modifierOeuvre(Oeuvre oeuvre) {
        this.oeuvreDao.modifierOeuvre(oeuvre);
    }

    @Override
    public void supprimerOeuvre(Oeuvre oeuvre) {
        this.oeuvreDao.supprimerOeuvre(oeuvre);
    }

    @Override
    public Oeuvre getOeuvre(int id) {
        return this.oeuvreDao.getOeuvre(id);
    }

    @Override
    public List<Oeuvre> getOeuvres() {
        return this.oeuvreDao.getOeuvres();
    }

    @Override
    public void ajouterPret(Pret pret) {
        this.pretDao.ajouterPret(pret);
    }

    @Override
    public void modifierPret(Pret pret) {
        this.pretDao.modifierPret(pret);
    }

    @Override
    public void supprimerPret(Pret pret) {
        this.pretDao.supprimerPret(pret);
    }

    @Override
    public Pret rechercherPret(int id) {
        return null;
    }

    @Override
    public List<Pret> getPrets() {
        return this.pretDao.getPrets();
    }
}
