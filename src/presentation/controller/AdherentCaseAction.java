package presentation.controller;

import beans.Adherent;
import business.DefaultServices;
import business.Services;
import presentation.view.AdherentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdherentCaseAction implements ActionListener {

    private AdherentView adherentView;
    private Services services;
    private JOptionPane jOptionPane;
    private String message;
    private JOptionPane jOptionCofirmDialog;
    public AdherentCaseAction(AdherentView adherentView) {
        this.adherentView = adherentView;
        this.services = DefaultServices.getInstance();
        jOptionCofirmDialog = new JOptionPane();
        jOptionPane = new JOptionPane();
        initComboBox();
        initForm();
    }

    private void initComboBox(){
        adherentView.getAdherentsComboBox().removeAllItems();
        for (beans.Adherent adherent : services.getAdherents()) {
            adherentView.getAdherentsComboBox().addItem(adherent.getNom());
        }
    }

    private void initForm(){
        if(adherentView.getAdherentsComboBox().getItemCount() > 0){
            adherentView.getAdherentsComboBox().setSelectedIndex(0);
            adherentView.getIdTextField().setText(String.valueOf(services.getAdherents().get(0).getNumero()));
            adherentView.getNomTextField().setText(services.getAdherents().get(0).getNom());
            adherentView.getPrenomTextField().setText(services.getAdherents().get(0).getPrenom());
            adherentView.getAddresseTextField().setText(services.getAdherents().get(0).getAdresse());
            adherentView.getEmailTextField().setText(services.getAdherents().get(0).getEmail());
        }
        else
            adherentView.getAdherentsComboBox().setSelectedIndex(-1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== adherentView.getAjouterbtn()){
            if(adherentView.getNomTextField().getText().equals("") || adherentView.getPrenomTextField().getText().equals("") || adherentView.getAddresseTextField().getText().equals("") || adherentView.getEmailTextField().getText().equals("")){
                message = "Veuillez remplir tous les champs";
                jOptionPane = new JOptionPane();
                jOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Adherent adherent = new Adherent(services.getAdherents().size()+1, adherentView.getNomTextField().getText(), adherentView.getPrenomTextField().getText(), adherentView.getAddresseTextField().getText(), adherentView.getEmailTextField().getText());
                services.ajouterAdherent(adherent);
                adherentView.getAdherentsComboBox().addItem(adherent.getNom());
                adherentView.getAdherentsComboBox().setSelectedItem(adherent.getNom());
                message = adherent.getNom()+" ajouté avec succès";
                jOptionPane.showMessageDialog(null, message, "succès", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(e.getSource()==adherentView.getAdherentsComboBox()){
            String nomAdherent = String.valueOf(adherentView.getAdherentsComboBox().getSelectedItem());
            Adherent adherent = services.getAdherent(nomAdherent);
            adherentView.getIdTextField().setText(String.valueOf(adherent.getNumero()));
            adherentView.getNomTextField().setText(adherent.getNom());
            adherentView.getPrenomTextField().setText(adherent.getPrenom());
            adherentView.getAddresseTextField().setText(adherent.getAdresse());
            adherentView.getEmailTextField().setText(adherent.getEmail());
        }

        if(e.getSource()==adherentView.getModifierbtn()) {
            String nomAdherent = adherentView.getAdherentsComboBox().getSelectedItem().toString();
            Adherent adherent = services.getAdherent(nomAdherent);
            this.message = "Voulez-vous vraiment modifier cet adherent ?";
            int option_ = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option_ == JOptionPane.OK_OPTION){
                adherent.setNom(adherentView.getNomTextField().getText());
                adherent.setPrenom(adherentView.getPrenomTextField().getText());
                adherent.setAdresse(adherentView.getAddresseTextField().getText());
                adherent.setEmail(adherentView.getEmailTextField().getText());
                services.modifierAdherent(adherent);
                this.message = "Adherent modifié avec succès";
                jOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                initForm();
                initComboBox();
            }
        }


            if(e.getSource()==adherentView.getSupprimerbtn()){
                int indice = adherentView.getAdherentsComboBox().getSelectedIndex();
                Adherent _adherent = new beans.Adherent(services.getAdherents().get(indice).getNumero(), adherentView.getNomTextField().getText(), adherentView.getPrenomTextField().getText(), adherentView.getAddresseTextField().getText(), adherentView.getEmailTextField().getText());
                this.message = "Voulez-vous vraiment supprimer cet adherent ?";
                int option_ = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option_ == JOptionPane.OK_OPTION){
                    services.supprimerAdherent(_adherent);
                    this.message = "Adherent supprimé avec succès";
                    jOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                    adherentView.getAdherentsComboBox().removeItem(_adherent.getNom());
                }
        }

        if(e.getSource()==adherentView.getCleanBtn()){
            adherentView.getEmailTextField().setText("");
            adherentView.getNomTextField().setText("");
            adherentView.getPrenomTextField().setText("");
            adherentView.getAddresseTextField().setText("");
            adherentView.getIdTextField().setText("");
            adherentView.getIdTextField().setEditable(true);
        }

    }

}
