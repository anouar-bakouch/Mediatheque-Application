package presentation.controller;

import beans.Auteur;
import beans.Oeuvre;
import business.DefaultServices;
import business.Services;
import enums.Categorie;
import presentation.view.OeuvreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OeuvreCaseAction implements ActionListener {

    private OeuvreView oeuvreView;
    private Services services;
    public OeuvreCaseAction(OeuvreView oeuvreView) {
        this.oeuvreView = oeuvreView;
        this.services = DefaultServices.getInstance();
        initCombo();
        initForm();
    }

    private void initCombo(){
        oeuvreView.getOeuvreComboBox().removeAllItems();
        for(Oeuvre oeuvre : services.getOeuvres()){
            oeuvreView.getOeuvreComboBox().addItem(String.valueOf(oeuvre.getId()));
        }
    }

    private void initForm(){
        if(oeuvreView.getOeuvreComboBox().getItemCount() > 0 ){
            oeuvreView.getOeuvreComboBox().setSelectedIndex(0);
            oeuvreView.getIdTextField().setText(String.valueOf(services.getOeuvres().get(0).getId()));
            oeuvreView.getTitreTextField().setText(services.getOeuvres().get(0).getTitre());
            oeuvreView.getCategorieTextField().setText(String.valueOf(services.getOeuvres().get(0).getCategorie()));
            oeuvreView.getAuteurtextField().setText(String.valueOf(services.getOeuvres().get(0).getAuteur()));
            oeuvreView.getEditeurTextField().setText(services.getOeuvres().get(0).getEditeur());
            oeuvreView.getAnneeSortieTextField().setText(String.valueOf(services.getOeuvres().get(0).getAnneeSortie()));
            oeuvreView.getStatutCheckBox().setSelected(services.getOeuvres().get(0).isStatut());
        }
        else
            oeuvreView.getOeuvreComboBox().setSelectedIndex(-1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== oeuvreView.getAjouterbtn()){
            Auteur auteur = services.rechercherAuteur(oeuvreView.getAuteurtextField().getText());
            Categorie categorie = Categorie.valueOf(oeuvreView.getCategorieTextField().getText());
            Oeuvre oeuvre = new Oeuvre(Integer.parseInt(oeuvreView.getIdTextField().getText()),oeuvreView.getTitreTextField().getText(),categorie,auteur,oeuvreView.getEditeurTextField().getText(),Integer.parseInt(oeuvreView.getAnneeSortieTextField().getText()),oeuvreView.getStatutCheckBox().isSelected());
            services.ajouterOeuvre(oeuvre);
        }


    }
}
