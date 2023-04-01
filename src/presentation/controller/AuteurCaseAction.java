package presentation.controller;

import beans.Auteur;
import business.Services;
import business.DefaultServices;
import presentation.view.AuteurView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuteurCaseAction implements ActionListener {

    private AuteurView auteurView;
    private Services services;

    // dialog box
    private JOptionPane jOptionPane;
    private String message;

    public AuteurCaseAction(AuteurView auteurView) {
        this.auteurView = auteurView;
        this.services = DefaultServices.getInstance();
        initComboBox();
        initForm();
    }


    // a method to init the combo box with the list of authors

    private void initComboBox() {
        auteurView.getAuteurComboBox().removeAllItems();
        for (Auteur auteur : services.getAuteurs()) {
            auteurView.getAuteurComboBox().addItem(auteur.getNom());
        }
    }

    private void initForm(){
        if(auteurView.getAuteurComboBox().getItemCount() > 0){
            auteurView.getAuteurComboBox().setSelectedIndex(0);
            auteurView.getIdTextField().setText(String.valueOf(services.getAuteurs().get(0).getId()));
            auteurView.getNomTextField().setText(services.getAuteurs().get(0).getNom());
            auteurView.getPrenomTextField().setText(services.getAuteurs().get(0).getPrenom());
            auteurView.getDateNaissanceTextField().setText(services.getAuteurs().get(0).getDateNaissance());
        }
        else
            auteurView.getAuteurComboBox().setSelectedIndex(-1);
    }

    private int incrementIdAuto(){
        // getting the last id
        int lastId = services.getAuteurs().get(services.getAuteurs().size() - 1).getId();
        // incrementing the last id
        lastId++;
        return lastId;
   }

    @Override
    public void actionPerformed(ActionEvent e) {

    // changes related to the add button

        if (e.getSource() == auteurView.getAjouterbtn()) {
            int id = incrementIdAuto();
            String nom = auteurView.getNomTextField().getText();
            String prenom = auteurView.getPrenomTextField().getText();
            String dateNaissance = auteurView.getDateNaissanceTextField().getText();
            services.ajouterAuteur(new Auteur(id ,nom, prenom, dateNaissance));
            // add the new author to the combo box
            auteurView.getAuteurComboBox().addItem(nom);
            // select the new author in the combo box
            auteurView.getAuteurComboBox().setSelectedItem(nom);
            // display a message to the user
            this.message = "L'auteur " + nom + " a été ajouté avec succès";
            jOptionPane.showMessageDialog(null, message, "Ajout d'un auteur", JOptionPane.INFORMATION_MESSAGE);
        }

        // changes related to the combo box

        if (e.getSource() == auteurView.getAuteurComboBox()) {
            String nomAuteur = auteurView.getAuteurComboBox().getSelectedItem().toString();
            Auteur auteur = services.rechercherAuteur(nomAuteur);
            auteurView.getIdTextField().setText(String.valueOf(auteur.getId()));
            auteurView.getNomTextField().setText(auteur.getNom());
            auteurView.getPrenomTextField().setText(auteur.getPrenom());
            auteurView.getDateNaissanceTextField().setText(auteur.getDateNaissance());
        }

        // changes related to the delete button

        if(e.getSource()==auteurView.getSupprimerbtn()){
            int idAuteur = Integer.parseInt(auteurView.getIdTextField().getText());
            Auteur auteur = services.rechercherAuteur(idAuteur);
            services.supprimerAuteur(auteur);
            // remove the author from the combo box
            auteurView.getAuteurComboBox().removeItem(auteur.getNom());
            // display a message to the user
            this.message = "L'auteur " + auteur.getNom() + " a été supprimé avec succès";
            jOptionPane.showMessageDialog(null, message, "Suppression d'un auteur", JOptionPane.INFORMATION_MESSAGE);
                }

        // changes related to clean button

        if (e.getSource() == auteurView.getCleanBtn() && auteurView.getAuteurComboBox().getItemCount() > 0) {
            auteurView.getIdTextField().setText("");
            auteurView.getNomTextField().setText("");
            auteurView.getPrenomTextField().setText("");
            auteurView.getDateNaissanceTextField().setText("");
        }


    }
}
