package presentation.controller;

import beans.Auteur;
import beans.Pret;
import business.DefaultServices;
import presentation.view.PretView;
import business.Services;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PretCaseAction implements ActionListener {

    private PretView pretView;
    private Services services;

    private String message;
    private JOptionPane jOptionPane;

    public PretCaseAction(PretView pretView) {
        this.pretView = pretView;
        services = DefaultServices.getInstance();
        initCombo();
        initForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==pretView.getAjouterbtn()){
            Pret pret = new Pret(Integer.parseInt(pretView.getIdAdherentText().getText()), Integer.parseInt(pretView.getIdTextField().getText()), pretView.getDatePretText().getText());
            services.ajouterPret(pret);
        }

        if(e.getSource() == pretView.getPretsComboBox()){
            int idOeuvre = Integer.parseInt(pretView.getPretsComboBox().getSelectedItem().toString());
            Pret pret = services.rechercherPret(idOeuvre);
            pretView.getIdTextField().setText(String.valueOf(pret.getIdOeuvre()));
            pretView.getIdAdherentText().setText(String.valueOf(pret.getIdAdherent()));
            pretView.getDatePretText().setText(pret.getDatePret());
            pretView.getIdTextField().setEditable(false);
        }

        if(e.getSource() == pretView.getAjouterbtn()){
            int idO = Integer.parseInt(pretView.getIdTextField().getText());
            int idA = Integer.parseInt(pretView.getIdAdherentText().getText());
            String date = pretView.getDatePretText().getText().toString();
            services.ajouterPret(new Pret(idO, idA, date));
            pretView.getPretsComboBox().addItem(String.valueOf(idO));
            pretView.getPretsComboBox().setSelectedItem(String.valueOf(idO));
            this.message = "le pret avec l\'id "+idO+"";
            jOptionPane.showMessageDialog(null, message, "Ajout d'un pret", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource()==pretView.getCleanBtn()){
            pretView.getIdAdherentText().setText("");
            pretView.getDatePretText().setText("");
            pretView.getIdTextField().setText("");
            pretView.getIdTextField().setEditable(true);
        }

    }

    private void initCombo(){
        pretView.getPretsComboBox().removeAllItems();
        for (Pret pret : services.getPrets()) {
            pretView.getPretsComboBox().addItem(String.valueOf(pret.getIdOeuvre()));
        }
    }

    private void initForm(){
        if(pretView.getPretsComboBox().getItemCount() > 0){
            pretView.getPretsComboBox().setSelectedIndex(0);
            pretView.getIdTextField().setText(String.valueOf(services.getPrets().get(0).getIdOeuvre()));
            pretView.getIdAdherentText().setText(String.valueOf(services.getPrets().get(0).getIdAdherent()));
            pretView.getDatePretText().setText(String.valueOf(services.getPrets().get(0).getDatePret()));
        }
        else
            pretView.getPretsComboBox().setSelectedIndex(-1);
    }

}
