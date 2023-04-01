package presentation.controller;

import beans.Pret;
import business.DefaultServices;
import presentation.view.PretView;
import business.Services;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PretCaseAction implements ActionListener {

    private PretView pretView;
    private Services services;

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
            pretView.getIdTextField().setText(pret.getIdOeuvre()+"");
            pretView.getIdAdherentText().setText(pret.getIdAdherent()+"");
            pretView.getDatePretText().setText(pret.getDatePret());
        }

    }

    private void initCombo(){
        pretView.getPretsComboBox().removeAllItems();
        for (Pret pret : services.getPrets()) {
            pretView.getPretsComboBox().addItem(pret.getIdOeuvre()+"");
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
