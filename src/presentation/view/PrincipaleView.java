package presentation.view;

import presentation.controller.PrincipaleCaseAction;
import javax.swing.*;
import java.awt.*;

public class PrincipaleView extends JFrame{

    private JLabel choixLbl;
    private JButton AuteurBtn;
    private JButton OeuvreBtn;
    private JButton PretBtn;
    private JButton AdherentBtn;

    private JPanel pan;

    public PrincipaleView(){

        this.choixLbl = new JLabel("Choisissez une action");


        this.AuteurBtn = new JButton("Auteur");
        this.OeuvreBtn = new JButton("Oeuvre");
        this.PretBtn = new JButton("Pret");
        this.AdherentBtn = new JButton("Adherent");

        this.AuteurBtn.setSize(40, 30);
        this.OeuvreBtn.setSize(40, 30);
        this.PretBtn.setSize(40, 30);
        this.AdherentBtn.setSize(40, 30);

        this.choixLbl.setSize(40, 30);

        this.pan = new JPanel();
        this.pan.add(choixLbl,BorderLayout.NORTH);
        this.pan.add(AuteurBtn,BorderLayout.SOUTH);
        this.pan.add(OeuvreBtn,BorderLayout.SOUTH);
        this.pan.add(PretBtn,BorderLayout.SOUTH);
        this.pan.add(AdherentBtn,BorderLayout.SOUTH);

        this.pan.setSize(300, 300);
        this.add(pan, BorderLayout.CENTER);
        this.setTitle("Gestion d'une médiathèque");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.AuteurBtn.addActionListener(new PrincipaleCaseAction(this));
        this.OeuvreBtn.addActionListener(new PrincipaleCaseAction(this));
        this.PretBtn.addActionListener(new PrincipaleCaseAction(this));
        this.AdherentBtn.addActionListener(new PrincipaleCaseAction(this));

    }

    public JButton getAuteurBtn() {
        return AuteurBtn;
    }

    public JButton getOeuvreBtn() {
        return OeuvreBtn;
    }

    public JButton getPretBtn() {
        return PretBtn;
    }

    public JButton getAdherentBtn() {
        return AdherentBtn;
    }
}
