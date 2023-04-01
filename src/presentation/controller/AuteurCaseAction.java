package presentation.controller;

import beans.Auteur;
import business.Services;
import business.DefaultServices;
import presentation.view.AuteurView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class AuteurCaseAction implements ActionListener {

    private AuteurView auteurView;
    private Services services;
    public AuteurCaseAction(AuteurView auteurView) {
        this.auteurView = auteurView;
        this.services = DefaultServices.getInstance();
        initComboBox();
    }


    // a method to init the combo box with the list of authors

    private void initComboBox() {
        auteurView.getAuteurComboBox().removeAllItems();
        for (Auteur auteur : services.getAuteurs()) {
            auteurView.getAuteurComboBox().addItem(auteur.getNom()+" "+auteur.getPrenom());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    // changes related to the add button

        if (e.getSource() == auteurView.getAjouterbtn()) {
            int id = Integer.parseInt(auteurView.getIdTextField().getText());
            String nom = auteurView.getNomTextField().getText();
            String prenom = auteurView.getPrenomTextField().getText();
            String dateNaissance = auteurView.getDateNaissanceTextField().getText();
            services.ajouterAuteur(new Auteur(id ,nom, prenom, dateNaissance));
            initComboBox();
        }

        // changes related to the combo box

        if (e.getSource() == auteurView.getAuteurComboBox()) {
            Auteur auteur = (Auteur) auteurView.getAuteurComboBox().getSelectedItem();
            auteurView.getIdTextField().setText(String.valueOf(auteur.getId()));
            auteurView.getNomTextField().setText(auteur.getNom());
            auteurView.getPrenomTextField().setText(auteur.getPrenom());
            auteurView.getDateNaissanceTextField().setText(auteur.getDateNaissance());
        }

    }
}
