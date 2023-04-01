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
    }

    // a method when the user changes the selected item in the combo box

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Auteur auteur = (Auteur) e.getItem();
            auteurView.getIdTextField().setText(String.valueOf(auteur.getId()));
            auteurView.getNomTextField().setText(auteur.getNom());
            auteurView.getPrenomTextField().setText(auteur.getPrenom());
            auteurView.getDateNaissanceTextField().setText(auteur.getDateNaissance());
        }
    }

    // a method to init the combo box with the list of authors

    public void initComboBox() {
        auteurView.getAuteurComboBox().removeAllItems();
        for (Auteur auteur : services.getAuteurs()) {
            auteurView.getAuteurComboBox().addItem(auteur.getPrenom()+" "+auteur.getNom());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
