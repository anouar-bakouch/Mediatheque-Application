package presentation.controller;

import beans.Auteur;
import beans.Oeuvre;
import business.DefaultServices;
import business.Services;
import enums.Categorie;
import presentation.view.OeuvreView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OeuvreCaseAction implements ActionListener {

    private OeuvreView oeuvreView;
    private Services services;
    private JOptionPane jOptionPane;

    // add a dialog to confirm the deletion
    private JOptionPane jOptionPaneConfirm;
    private String message;

    public OeuvreCaseAction(OeuvreView oeuvreView) {
        this.oeuvreView = oeuvreView;
        this.services = DefaultServices.getInstance();
        initCombo();
        initForm();
    }

    private void initCombo() {
        oeuvreView.getOeuvreComboBox().removeAllItems();
        for (Oeuvre oeuvre : services.getOeuvres()) {
            oeuvreView.getOeuvreComboBox().addItem(String.valueOf(oeuvre.getId()));
        }
    }

    private void initForm() {
        if (oeuvreView.getOeuvreComboBox().getItemCount() > 0) {
            oeuvreView.getOeuvreComboBox().setSelectedIndex(0);
            oeuvreView.getIdTextField().setText(String.valueOf(services.getOeuvres().get(0).getId()));
            oeuvreView.getTitreTextField().setText(services.getOeuvres().get(0).getTitre());
            oeuvreView.getCategorieTextField().setText(String.valueOf(services.getOeuvres().get(0).getCategorie()));
            oeuvreView.getAuteurtextField().setText(String.valueOf(services.getOeuvres().get(0).getAuteur().getNom()));
            oeuvreView.getEditeurTextField().setText(services.getOeuvres().get(0).getEditeur());
            oeuvreView.getAnneeSortieTextField().setText(String.valueOf(services.getOeuvres().get(0).getAnneeSortie()));
            oeuvreView.getStatutCheckBox().setSelected(services.getOeuvres().get(0).isStatut());
        } else
            oeuvreView.getOeuvreComboBox().setSelectedIndex(-1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == oeuvreView.getAjouterbtn()) {
            Auteur auteur = services.rechercherAuteur(oeuvreView.getAuteurtextField().getText());
            Categorie categorie = Categorie.valueOf(oeuvreView.getCategorieTextField().getText());
            Oeuvre oeuvre = new Oeuvre(Integer.parseInt(oeuvreView.getIdTextField().getText()), oeuvreView.getTitreTextField().getText(), categorie, auteur, oeuvreView.getEditeurTextField().getText(), Integer.parseInt(oeuvreView.getAnneeSortieTextField().getText()), oeuvreView.getStatutCheckBox().isSelected());
            services.ajouterOeuvre(oeuvre);
            this.message = oeuvre.getTitre() + "ajoutée avec succès";
            jOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
            oeuvreView.getOeuvreComboBox().addItem(String.valueOf(oeuvre.getId()));
            oeuvreView.getOeuvreComboBox().setSelectedIndex(oeuvreView.getOeuvreComboBox().getItemCount() - 1);
        }

            if (e.getSource() == oeuvreView.getOeuvreComboBox()) {
                int idOeuvre = Integer.parseInt(oeuvreView.getOeuvreComboBox().getSelectedItem().toString());
                Oeuvre oeuvre = services.getOeuvre(idOeuvre);
                oeuvreView.getIdTextField().setText(String.valueOf(idOeuvre));
                oeuvreView.getIdTextField().setEditable(false);
                oeuvreView.getTitreTextField().setText(oeuvre.getTitre());
                oeuvreView.getAuteurtextField().setText(oeuvre.getAuteur().getNom());
                oeuvreView.getCategorieTextField().setText(oeuvre.getCategorie().toString());
                oeuvreView.getAnneeSortieTextField().setText(String.valueOf(oeuvre.getAnneeSortie()));
                oeuvreView.getEditeurTextField().setText(oeuvre.getEditeur());
                oeuvreView.getStatutCheckBox().setSelected(true);
            }

            if (e.getSource() == oeuvreView.getModifierbtn()) {

                // deletion with joptionpaneConfirm
                int idOeuvre = Integer.parseInt(oeuvreView.getOeuvreComboBox().getSelectedItem().toString());
                Oeuvre oeuvre = services.getOeuvre(idOeuvre);
                this.message = "Voulez-vous vraiment modifier " + oeuvre.getTitre() + " ?";
                int option = jOptionPaneConfirm.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Auteur auteur = services.rechercherAuteur(oeuvreView.getAuteurtextField().getText());
                    Categorie categorie = Categorie.valueOf(oeuvreView.getCategorieTextField().getText());
                    Oeuvre oeuvre1 = new Oeuvre(Integer.parseInt(oeuvreView.getIdTextField().getText()), oeuvreView.getTitreTextField().getText(), categorie, auteur, oeuvreView.getEditeurTextField().getText(), Integer.parseInt(oeuvreView.getAnneeSortieTextField().getText()), oeuvreView.getStatutCheckBox().isSelected());
                    services.modifierOeuvre(oeuvre1);
                    this.message = oeuvre.getTitre() + "modifiée avec succès";
                    jOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    initForm();
                }
            }

            if (e.getSource() == oeuvreView.getSupprimerbtn()) {
                int idOeuvre = Integer.parseInt(oeuvreView.getOeuvreComboBox().getSelectedItem().toString());
                Oeuvre oeuvre = services.getOeuvre(idOeuvre);
                this.message = "Voulez-vous vraiment supprimer " + oeuvre.getTitre() + " ?";
                int option = jOptionPaneConfirm.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    services.supprimerOeuvre(oeuvre);
                    this.message = oeuvre.getTitre() + "supprimée avec succès";
                    jOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    oeuvreView.getOeuvreComboBox().removeItem(String.valueOf(oeuvre.getId()));
                    initForm();
                }
            }

            if (e.getSource() == oeuvreView.getCleanBtn()) {
                oeuvreView.getIdTextField().setText("");
                oeuvreView.getIdTextField().setEditable(true);
                oeuvreView.getTitreTextField().setText("");
                oeuvreView.getCategorieTextField().setText("");
                oeuvreView.getAuteurtextField().setText("");
                oeuvreView.getEditeurTextField().setText("");
                oeuvreView.getAnneeSortieTextField().setText("");
                oeuvreView.getStatutCheckBox().setSelected(false);
            }

    }
}

