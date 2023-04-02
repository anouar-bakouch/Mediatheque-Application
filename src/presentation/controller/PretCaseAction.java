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
            String idO = (String) pretView.getPretsComboBox().getSelectedItem();
            int idOeuvre = Integer.parseInt(idO.split("-")[0]);
            int idAdherent = Integer.parseInt(idO.split("-")[1]);
            Pret pret = services.rechercherPret(idOeuvre, idAdherent);
            pretView.getIdTextField().setText(String.valueOf(idOeuvre));
            pretView.getIdAdherentText().setText(String.valueOf(idAdherent));
            pretView.getDatePretText().setText(String.valueOf(pret.getDatePret()));
            pretView.getIdTextField().setEditable(false);
        }

        if(e.getSource() == pretView.getAjouterbtn()){
             Pret pret = new Pret(Integer.parseInt(pretView.getIdAdherentText().getText()), Integer.parseInt(pretView.getIdTextField().getText()), pretView.getDatePretText().getText());
                services.ajouterPret(pret);
                message = "Pret ajouté avec succès";
                jOptionPane = new JOptionPane();
                jOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
                initCombo();
                initForm();
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
            pretView.getPretsComboBox().addItem(pret.getIdAdherent()+"-"+pret.getIdOeuvre());
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
