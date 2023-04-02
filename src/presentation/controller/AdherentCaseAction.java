package presentation.controller;

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
        initComboBox();
        initForm();
    }

    private void initComboBox(){
        adherentView.getAdherentsComboBox().removeAllItems();
        for (beans.Adherent adherent : services.getAdherents()) {
            adherentView.getAdherentsComboBox().addItem(adherent.getNom());
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
